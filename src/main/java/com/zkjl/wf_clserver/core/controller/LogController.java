package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.dto.req.DefaultPageRQ;
import com.zkjl.wf_clserver.core.entity.Log;
import com.zkjl.wf_clserver.core.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户日志操作
 */
@RestController
@RequestMapping("/api/log")
@Api(value = "Log-API", description = "用户日志接口")
public class LogController extends BaseController {

    @Resource
    private LogService logService;
    private static final Logger log = Logger.getLogger(LogController.class);// 日志文件

    /**
     * 查询
     */
    @ApiOperation(value = "日志列表查询" , httpMethod = "GET")
    @RequestMapping(value = "/page/list",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult findPage(DefaultPageRQ defaultPageRQ,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) Date beginDate,
                              @RequestParam(required = false) Date endDate){
        PageImpl<Log> log;
        try {
            log = logService.findPage(defaultPageRQ.getPageSize(), defaultPageRQ.getPageNum(), name, beginDate, endDate);
        } catch (Exception e) {
            return error("查询用户列表失败");
        }
        return successPages(log);
    }

    /**
     * 管理员删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "用户删除", httpMethod = "GET")
    public ApiResult delete(@RequestParam(value = "ids") String ids) throws Exception {
        ApiResult apiResult=new ApiResult();
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            logService.deleteLog(idsStr[i]);
        }
        return apiResult;
    }
}