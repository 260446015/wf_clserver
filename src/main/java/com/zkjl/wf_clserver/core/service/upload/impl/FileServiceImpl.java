package com.zkjl.wf_clserver.core.service.upload.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.common.BeanNameContext;
import com.zkjl.wf_clserver.core.common.FileUploadEnum;
import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import com.zkjl.wf_clserver.core.exception.CustomerException;
import com.zkjl.wf_clserver.core.repository.es.FileUploadEntityRepository;
import com.zkjl.wf_clserver.core.service.upload.FileService;
import com.zkjl.wf_clserver.core.service.upload.UploadAbstractService;
import com.zkjl.wf_clserver.core.util.PageUtil;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author ydw
 * Created on 2018/7/2
 */
@Service
public class FileServiceImpl implements FileService {
    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    @Resource
    private BeanNameContext beanNameContext;
    @Resource
    private FileUploadEntityRepository fileUploadEntityRepository;
    @Resource
    private Client client;
    @Value(value = "${web.uploadpath}")
    private String uploadPath;

    private static final String xls = "xls";
    private static final String xlsx = "xlsx";
    private static final String txt = "txt";
    private static final String CSV = "CSV";

    @Override
    public JSONObject upload(MultipartFile file, HttpServletRequest request) throws IOException, CustomerException {
        String checkFile = checkFile(file);
        Class<?> targetService = FileUploadEnum.getTargetService(checkFile);
        UploadAbstractService uploadService = (UploadAbstractService) beanNameContext.getBean(targetService);
        return uploadService.upload(file, request);
    }

    private String checkFile(MultipartFile file) throws IOException, CustomerException {
        String fileType;
        //判断文件是否存在
        if (null == file) {
            logger.error("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        String substring = fileName.substring(fileName.lastIndexOf(".") + 1);
        //判断文件是否是excel文件
        if(substring.equalsIgnoreCase(txt) || substring.equalsIgnoreCase(CSV)){
            logger.info("正在对txt文件进行读取");
            fileType = txt;
        }else if(substring.equalsIgnoreCase("doc") || substring.equalsIgnoreCase("docx")){
            logger.info("正在对word文件进行读取");
            fileType = "word";
        }else if (substring.equalsIgnoreCase(xls) || substring.equalsIgnoreCase(xlsx)){
            logger.info("正在对excel文件进行读取");
            fileType = "excel";
        }else{
            throw new CustomerException(fileName + "文件格式不支持");
        }
        return fileType;
    }

    @Override
    public PageImpl<FileUploadEntity> search(String search, int pageNum, int pageSize) {
//        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(search);
//        Iterable<FileUploadEntity> iterable = fileUploadEntityRepository.search(builder);
//        List<FileUploadEntity> datas = IterableUtils.toList(iterable);
//        PageImpl<FileUploadEntity> page = new PageImpl<>(datas);
//        PageUtil.pageBeagin(datas.size(), pageNum, pageSize, datas);
        QueryBuilder matchQuery = QueryBuilders.matchQuery("content",search);
//        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(search);
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("content").requireFieldMatch(false).fragmentSize(20000).numOfFragments(10);
        highlightBuilder.preTags("<i>");
        highlightBuilder.postTags("</i>");
        SearchRequestBuilder request = client.prepareSearch("file_upload")
                .setTypes("entity")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(matchQuery)
                .highlighter(highlightBuilder)
                .setExplain(true);
        SearchResponse response = request.execute().actionGet();
        SearchHits hits = response.getHits();
        SearchHit[] hits1 = hits.getHits();
        List<FileUploadEntity> datas = new ArrayList<>();
        for (int i = 0; i < hits1.length; i++) {
            SearchHit searchHitFields = hits1[i];
            String sourceAsString = searchHitFields.getSourceAsString();
            FileUploadEntity entity = JSONObject.parseObject(sourceAsString, FileUploadEntity.class);
            System.out.println("映射实体"+entity);
            Map<String, HighlightField> highlightFields = searchHitFields.getHighlightFields();
            //获取高亮结果
            Set<String> set = highlightFields.keySet();
            for (String str : set) {

                HighlightField highLight = highlightFields.get(str);
                String name = highLight.getName();
                if("content".equals(name)){
                    Text[] texts = highLight.getFragments();
                    String content = "";
                    for (int l = 0; l < texts.length; l++) {
                        Text text = texts[l];
                        content += text;
                    }
                    System.out.println(name + "=" + content);
                    entity.setContent(content.toString().replaceAll("\"","'"));
                }
            }

            datas.add(entity);
        }
        PageImpl<FileUploadEntity> page = new PageImpl<>(datas);
        PageUtil.pageBeagin(datas.size(), pageNum, pageSize, datas);
        return page;
    }

    @Override
    public boolean delete(String source) {
        try {
            fileUploadEntityRepository.deleteBySource(source);
        } catch (Exception e) {
            logger.error("删除文件上传失败:",e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String uploadImg(HttpServletRequest req, MultipartFile multipartFile) {
        String filePath = "";
        String myFileName = multipartFile.getOriginalFilename();// 文件原名称
        try {
            filePath = uploadPath + "/"+myFileName;
            filePath = filePath.replaceAll("\\/+","/");
            File localFile = new File(filePath);
            multipartFile.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myFileName;
    }

    @Override
    public PageImpl<JSONObject> findUploadData(String username,Integer pageNum,Integer pageSize) {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("file_upload").setTypes("entity");
        AbstractAggregationBuilder aggregationBuilder = AggregationBuilders.terms("source").field("source.keyword").size(10000);
//        TermsAggregationBuilder teamAgg = AggregationBuilders.terms("source_count").field("source.keyword");
        SearchResponse response = searchRequestBuilder.setQuery(QueryBuilders.termQuery("username.keyword", username)).addAggregation(aggregationBuilder).addSort("createTime", SortOrder.DESC).execute().actionGet();
        Terms terms = response.getAggregations().get("source");
        List<JSONObject> list = new ArrayList<>();
        for (Terms.Bucket entry:terms.getBuckets()){
            JSONObject data = new JSONObject();
            String value = entry.getKeyAsString();
            long count = entry.getDocCount();
            data.put("key",value);
            data.put("value",count);
            list.add(data);
        }
        return (PageImpl<JSONObject>) PageUtil.pageBeagin(list.size(),pageNum,pageSize,list);
    }

    @Override
    public Long findUploadCount(String username) {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("file_upload").setTypes("entity");
        SearchResponse response = searchRequestBuilder.setQuery(QueryBuilders.termQuery("username.keyword", username)).execute().actionGet();
        return response.getHits().totalHits;
    }
}
