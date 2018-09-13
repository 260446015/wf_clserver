package com.zkjl.wf_clserver.core.controller;

import com.zkjl.wf_clserver.core.common.ApiResult;
import com.zkjl.wf_clserver.core.dto.vo.ConfsVO;
import com.zkjl.wf_clserver.core.entity.Confs;
import com.zkjl.wf_clserver.core.service.PersonCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class PersonCenterController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(PersonCenterController.class);

    @Resource
    private PersonCenterService personCenterService;

    @GetMapping(value = "listSearchConfig")
    public ApiResult listSearchConfig() {
        List<ConfsVO> result;
        String username;
        try {
            username = this.getCurrentUser().getId();
            result = personCenterService.listSearchConfig(username);
        } catch (Exception e) {
            logger.error("获取用户查询配置失败" + e.getMessage());
            return error("获取用户查询配置失败");
        }
        return success(result);
    }

    @PostMapping(value = "updateConfs")
    public ApiResult updateConfs(@RequestBody Confs confs) {
        ConfsVO vo;
        try {
            confs.setSystemuser(this.getCurrentUser().getId());
            vo = personCenterService.updateConfs(confs);
        } catch (Exception e) {
            logger.error("更新用户查询配置失败" + e.getMessage());
            return error("更新用户查询配置失败");
        }
        return success(vo);
    }

}
