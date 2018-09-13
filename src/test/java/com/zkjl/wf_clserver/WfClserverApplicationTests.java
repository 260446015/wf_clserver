package com.zkjl.wf_clserver;

import com.alibaba.fastjson.JSONObject;
import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import com.zkjl.wf_clserver.core.repository.es.FileUploadEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WfClserverApplication.class)
public class WfClserverApplicationTests {

    @Resource
    private FileUploadEntityRepository fileUploadEntityRepository;
    @Test
    public void test(){
        FileUploadEntity fileUploadEntity = new FileUploadEntity();
        fileUploadEntity.setContent("123");
        fileUploadEntity.setSource("123");
        fileUploadEntityRepository.save(fileUploadEntity);
    }
}
