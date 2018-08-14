package com.hngd.dao;

import com.hngd.model.DomainOrgExample;
import com.hngd.model.DomainOrgKey;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.ibatis.annotations.Param;

public interface DomainOrgMapper {
    long countByExample(DomainOrgExample example);

    int deleteByExample(DomainOrgExample example);

    int deleteByPrimaryKey(DomainOrgKey key);

    int insert(DomainOrgKey record);

    int insertSelective(DomainOrgKey record);

    List<DomainOrgKey> selectByExample(DomainOrgExample example);

    int updateByExampleSelective(@Param("record") DomainOrgKey record, @Param("example") DomainOrgExample example);

    int updateByExample(@Param("record") DomainOrgKey record, @Param("example") DomainOrgExample example);
}