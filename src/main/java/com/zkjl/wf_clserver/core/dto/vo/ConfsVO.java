package com.zkjl.wf_clserver.core.dto.vo;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

@Data
public class ConfsVO implements Serializable{
    private static final long serialVersionUID = -3243440926149310256L;

    private String _id;

    private String id;

    private String systemuser;

    private String username;

    private String password;

    private String platformName;

    private Date createDate;

    private Boolean ifCertificate;

    public Boolean getIfCertificate() {
        if(StringUtils.isBlank(this.username) || StringUtils.isBlank(this.password)){
            return true;
        }
        return false;
    }

    public void setIfCertificate() {
        if(StringUtils.isBlank(this.username) || StringUtils.isBlank(this.password)){
            this.ifCertificate = true;
        }else{
            this.ifCertificate = false;
        }
    }
}
