package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.dto.req.DefaultPageRQ;
import com.zkjl.wf_clserver.core.entity.Confs;
import com.zkjl.wf_clserver.core.service.ConfsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 平台操作
 */
@RestController
@RequestMapping("/api/confs")
@Api(value = "Confs-API", description = "平台接口")
public class ConfsController extends BaseController {

    @Resource
    private ConfsService confsService;
    private static final Logger log = Logger.getLogger(ConfsController.class);// 日志文件


    /**
     * 查询
     */
    @ApiOperation(value = "平台查询" , httpMethod = "GET")
    @RequestMapping(value = "/page/list",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult findPage(DefaultPageRQ defaultPageRQ,
                              @RequestParam(required = false) String searchStr
                             ){
        PageImpl<Confs> confs;
        try {
            confs = confsService.findConfs(defaultPageRQ.getPageSize(), defaultPageRQ.getPageNum(), searchStr);
        } catch (Exception e) {
            return error("查询平台列表失败");
        }
        return successPages(confs);
    }
    /**
     * 查询
     */
    @ApiOperation(value = "平台查询" , httpMethod = "GET")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult findPage(){
        List<Confs> confs;
        try {
            confs = confsService.findAll();
        } catch (Exception e) {
            return error("查询平台列表失败");
        }
        return success(confs);
    }

    /**
     * 根据id查询平台
     */
    @ApiOperation(value = "根据id查询平台" , httpMethod = "GET")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getConfsById(@RequestParam String id){
        Optional<Confs> confs;
        try {
            confs = confsService.get(id);
        } catch (Exception e) {
            return error("查询用户列表失败");
        }
        return success(confs);
    }

    /**
     * 添加或修改
     */
    @PostMapping("/save")
    @SystemControllerLog(description = "后台管理-用户添加")
    @ResponseBody
    @ApiOperation(value = "用户添加", httpMethod = "POST")
    public ApiResult save(@RequestBody Confs confs) throws Exception {
        return success(confsService.addConfsOrUpdate(confs));
    }

    /**
     * 删除
     */
    @ApiOperation(value = "用户删除", httpMethod = "GET")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult delete(@RequestParam(value = "ids") String ids) throws Exception {
        ApiResult apiResult=new ApiResult();
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            confsService.deleteConfs(idsStr[i]);
        }
        return apiResult;
    }
}