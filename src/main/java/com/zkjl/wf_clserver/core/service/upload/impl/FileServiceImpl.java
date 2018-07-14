package com.zkjl.wf_clserver.core.service.upload.impl;

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
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        String fileType = null;
        //判断文件是否存在
        if (null == file) {
            logger.error("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
            if (fileName.endsWith(txt) || fileName.endsWith(CSV)) {
                logger.info("正在对txt文件进行读取");
                fileType = txt;
            }
        }
        if(fileName.endsWith("doc") || fileName.endsWith("docx")){
            fileType = "word";
        }
        if(fileName.endsWith(xls) || fileName.endsWith(xlsx)){
            fileType = "excel";
        }
        if(fileType == null){
            logger.error(fileName + "不是excel文件或txt文件");
            throw new CustomerException(fileName + "不是excel文件或txt文件");
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
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(search);
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false);
        highlightBuilder.preTags("<i>");
        highlightBuilder.postTags("</i>");
        SearchRequestBuilder request = client.prepareSearch("file_upload")
                .setTypes("entity")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(builder)
                .highlighter(highlightBuilder);
        SearchResponse response = request.get();
        SearchHits hits = response.getHits();
        SearchHit[] hits1 = hits.getHits();
        List<FileUploadEntity> datas = new ArrayList<>();
        for (int i = 0; i < hits1.length; i++) {
            SearchHit searchHitFields = hits1[i];
            String sourceAsString = searchHitFields.getSourceAsString();
            FileUploadEntity entity = JSONObject.parseObject(sourceAsString, FileUploadEntity.class);
            Map<String, HighlightField> highlightFields = searchHitFields.getHighlightFields();
            //获取高亮结果
            Set<String> set = highlightFields.keySet();
            for (String str : set) {

                HighlightField highLight = highlightFields.get(str);
                String name = highLight.getName();
                if("content".equals(name)){
                    Text[] texts = highLight.getFragments();
                    for (int l = 0; l < texts.length; l++) {
                        Text text = texts[l];
                        System.out.println(name + "=" + text);
                        entity.setContent(text.toString().replaceAll("\"","'"));
                    }
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
}
