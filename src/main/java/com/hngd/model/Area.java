package com.hngd.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *地域
 */
public class Area {
    /**
     *地域代码
     */
    @NotNull
    @Size(min=0,max=12)
    private String code;

    /**
     *地域名称
     */
    @Size(min=0,max=100)
    private String name;

    /**
     *地域层级
     */
    private Short level;

    /**
     *上级地域代码
     */
    @Size(min=0,max=12)
    private String parentCode;

    /**
     *录入者编号
     */
    @Size(min=0,max=20)
    private String creatorCode;

    /**
     *是否有效
     */
    @Size(min=0,max=1)
    private String permit;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit == null ? null : permit.trim();
    }
}