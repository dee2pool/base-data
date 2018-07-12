package com.hngd.model;

import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *组织
 */
public class Organization {
    /**
     *组织编码
     */
    @Size(min=0,max=20)
    private String code;

    /**
     *组织名称
     */
    @NotNull
    @Size(min=0,max=256)
    private String name;

    /**
     *组织描述
     */
    @Size(min=0,max=2147483647)
    private String description;

    /**
     *地理区域编码,外键引用tb_bl_area
     */
    @NotNull
    @Size(min=0,max=12)
    private String areaCode;

    /**
     *创建者Id
     */
    @NotNull
    @Size(min=0,max=12)
    private String creatorId;

    /**
     *创建时间
     */
    @NotNull
    private Date createTime;

    /**
     *父节点代码,根组织取值为-1
     */
    @NotNull
    @Size(min=0,max=20)
    private String parentCode;

    /**
     *同级排序
     */
    @NotNull
    private Short orderNo;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Short getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Short orderNo) {
        this.orderNo = orderNo;
    }
}