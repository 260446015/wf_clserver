package com.zkjl.wf_clserver.core.repository.es;

import com.zkjl.wf_clserver.core.entity.FileUploadEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author ydw
 * Created on 2018/6/30
 */
public interface FileUploadEntityRepository extends ElasticsearchRepository<FileUploadEntity,String> {
    List<FileUploadEntity> findAllByIdNotIn(List<String> ids);

    List<FileUploadEntity> findBySource(String source);

    List<FileUploadEntity> deleteBySource(String source);

    List<FileUploadEntity> findByUsername(String username);
}
