package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.common.SystemControllerLog;
import com.zkjl.wf_clserver.core.service.ElementAnalysisService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ydw
 * Created on 2018/6/27
 */
@RestController
@RequestMapping(name = "/api/analysis")
public class ElementAnalysisController extends BaseController {

    @Resource
    private ElementAnalysisService elementAnalysisService;

    @GetMapping
    @SystemControllerLog(description="同要素关联分析")
    @ApiOperation(value = "同要素关联分析")
    public ApiResult analysis(String word1, String word2) throws Exception {

        return success(elementAnalysisService.analysis(word1, word2));
    }
}
