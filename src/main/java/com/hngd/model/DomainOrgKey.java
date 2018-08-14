package com.hngd.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *域组织关联
 */
public class DomainOrgKey {
    /**
     *域代码
     */
    @Size(min=0,max=32)
    private String domainCode;

    /**
     *组织代码
     */
    @NotNull
    @Size(min=0,max=32)
    private String orgCode;

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode == null ? null : domainCode.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }
}