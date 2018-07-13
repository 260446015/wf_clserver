package com.zkjl.wf_clserver.core.service.impl;

import com.zkjl.wf_clserver.core.entity.Link;
import com.zkjl.wf_clserver.core.repository.kklc.LinkRepository;
import com.zkjl.wf_clserver.core.service.LinkService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Value("${web.uploadpath}")
    private String uploadpath;

    @Override
    public List<Link> findAll() {
        return linkRepository.findAll();
    }
    @Override
    public boolean saveOrUpdate(Link link) {
        try {
            link.setCreateDate(new Date());
            linkRepository.save(link);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override
    public boolean delete(String ids) {
        try {
            String basePath = "D:\\图片虚拟目录\\";
            String[] idsArr = ids.split(",");
            for (int i = 0; i < idsArr.length; i++) {
                String id = idsArr[i];
                Link one = linkRepository.findById(id).get();
                if(one == null) continue;
                String url = one.getUrl();
                String images = url.substring(url.indexOf("images"));
                File file = new File(uploadpath+images);
                FileUtils.deleteDirectory(file);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
