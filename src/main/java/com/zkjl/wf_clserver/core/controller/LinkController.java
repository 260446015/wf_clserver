package com.zkjl.wf_clserver.core.controller;


import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.dto.LinkDTO;
import com.zkjl.wf_clserver.core.entity.Link;
import com.zkjl.wf_clserver.core.service.LinkService;
import com.zkjl.wf_clserver.core.util.IpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 超级链接
 */
@RestController
@RequestMapping("/api/link")
@Api(value = "Link-API", description = "这是超级链接详细信息的描述")
public class LinkController extends BaseController {
    @Resource
    private LinkService linkService;

    /**
     * 查询所有链接
     */
    @PostMapping("/findAll")
    public ApiResult findAll(@RequestBody LinkDTO linkDTO) throws Exception {
        PageImpl<Link> links = linkService.findAll(linkDTO);
        return successPages(links);
    }

    /**
     * 链接添加或修改
     */
    @PostMapping("/save")
    @ApiOperation(value = "链接添加", httpMethod = "POST")
    public ApiResult save(@RequestBody Link link, HttpServletRequest request) throws Exception {
        String username = this.getCurrentUser().getUsername();
        link.setCreator(username);
        link.setLogo("http://"+IpUtils.getServerIP() +":8090/"+ link.getLogo());
        return success(linkService.saveOrUpdate(link));
    }

    /**
     * 链接删除
     */
    @GetMapping("/delete")
    @ApiOperation(value = "链接删除", httpMethod = "GET")
    public ApiResult delete(String ids) throws Exception {
        return success(linkService.delete(ids));
    }

}
