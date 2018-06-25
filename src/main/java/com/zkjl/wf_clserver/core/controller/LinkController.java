package com.zkjl.wf_clserver.core.controller;


import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.entity.Link;
import com.zkjl.wf_clserver.core.service.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 超级链接
 */
@RestController
@RequestMapping("/link")
@Api(value = "Link-API", description = "这是超级链接详细信息的描述")
public class LinkController extends BaseController{
    @Resource
    private LinkService linkService;

    /**
     * 查询所有链接
     */
    @GetMapping("/findAll")
    @SystemControllerLog(description = "查询超链接")
    @ApiOperation(value = "查询超链接", httpMethod = "GET")
    public ApiResult findAll()throws Exception{
        List<Link> links=linkService.findAll();
        return success(links);
    }

    /**
     * 链接添加或修改
     */
    @PostMapping("/save")
    @SystemControllerLog(description = "后台管理-链接添加或修改")
    @ApiOperation(value = "链接添加", httpMethod = "POST")
    public ApiResult save(@RequestBody Link link) throws Exception {
        return success(linkService.saveOrUpdate(link));
    }

    /**
     * 链接删除
     */
    @PostMapping("/delete")
    @SystemControllerLog(description = "后台管理-链接删除")
    @ApiOperation(value = "链接删除", httpMethod = "POST")
    public ApiResult delete(@RequestParam(value = "ids") String ids) throws Exception {
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            linkService.delete(idsStr[i]);
        }
        return null;
    }

}
