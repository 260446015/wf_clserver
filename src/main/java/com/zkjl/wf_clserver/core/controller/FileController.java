package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.service.LogService;
import com.zkjl.wf_clserver.core.util.FileUlti;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
@Api(value = "File-API", description = "这是文件上传接口详细信息的描述")
public class FileController {

    protected Validator validator;
    @Resource
    private LogService logService;
    /**
     * 图片上传
     * @param req
     * @throws Exception
     */
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @SystemControllerLog(description="图片上传")
    @ResponseBody
    public List<Map<String, Object>> upload(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)req;
        List<Map<String, Object>> mapList=new ArrayList<>();
        List multipartFiles = multipartRequest
                .getFiles("file");// 得到所有的文件
        for (int i = 0; i < multipartFiles.size(); i++) {
            Map<String, Object> map=new HashMap<>();
            MultipartFile multipartFile = (MultipartFile)multipartFiles.get(i);
            if (multipartFile.getSize() <= 0L) {
                return null;
            }
            String fileUrl= FileUlti.uploadImg(req,multipartFile);
            map.put("url", fileUrl);
            mapList.add(map);
        }
        return mapList;
    }
    /**
     * Excel上传
     * @param req
     * @throws Exception
     */
    @RequestMapping(value = "/uploadExcel",method = RequestMethod.POST)
    @SystemControllerLog(description="Excel上传")
    @ResponseBody
    public ApiResult uploadExcel(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ApiResult apiResult=new ApiResult();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)req;
        List<Map<String, Object>> mapList=new ArrayList<>();
        List multipartFiles = multipartRequest
                .getFiles("file");// 得到所有的文件
        //存放region的list
        List<Log> logList = new ArrayList<Log>();
        for (int i = 0; i < multipartFiles.size(); i++) {
            Map<String, Object> map=new HashMap<>();
            MultipartFile multipartFile = (MultipartFile)multipartFiles.get(i);
            if (multipartFile.getSize() <= 0L) {
                return null;
            }
            try {
                //创建Excel工作簿文件(包含.xsl和.xslx格式)
                Workbook wb = WorkbookFactory.create(multipartFile.getInputStream());
                //打开需要解析的Sheet工作表
                Sheet sheet = wb.getSheetAt(0);
                //遍历工作表对象（本质是个行的集合）,读取每一行
                for (Row row : sheet) {
                    //跳过第一行
                    if (row.getRowNum() == 0) {
                        continue;
                    }

                    //另外，一般第一列都标识列，如果第一个格没数据，则认为该行数据无效，要跳过
                    //注意：getStringCellValue()读取的格必须是文本，否则抛异常
                    if (StringUtils.isNotBlank(row.getCell(0).getStringCellValue())) {
                        //暂时拿log测试
                        Log log = new Log();
                        log.setId(row.getCell(0).getStringCellValue());
                        log.setIp(row.getCell(1).getStringCellValue());
                        log.setName(row.getCell(2).getStringCellValue());
                        log.setCategory(row.getCell(3).getStringCellValue());
                        log.setRequestUri(row.getCell(4).getStringCellValue());

                        logList.add(log);
                    }
                }

            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
        }
        return apiResult;
    }


}
