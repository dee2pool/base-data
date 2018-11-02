/**
 * Copyright (c) 2015,湖南华南光电科技股份有限公司
 * All rights reserved.
 *
 * 文件名：OrgService.java
 * 时间：2015年9月22日 下午3:09:27
 * 作者：virgil
 * 备注：
 */

package com.hngd.service;

import java.util.List;

import com.hngd.common.result.Result;
import com.hngd.common.service.CodeValidator;
import com.hngd.common.web.page.PagedData;
import com.hngd.model.Area;
import com.hngd.model.Organization;
 

/**
 * @author tqd
 */
public interface OrgService extends CodeValidator
{
    /**
     * 添加组织机构
     * @param org 组织结构对象
     * @param areaCode 区域代码
     * @return
     * @author tqd
     * @since 0.0.1
     */
    public Result<String> addOrgnization(Organization org, String areaCode);

    /**
     * 根据组织编码删除组织
     * @param codes 组织编码列表
     * @return 删除成功 则返回ErrorCode.NO_ERROR,否则返回其他错误码 参考{@link ErrorCode},
     * @作者:Administrator
     * @时间:2015年11月16日 上午11:33:42
     * @备注:
     */
    public Integer deleteOrgByCodes(List<String> codes);

    /**
     * 根据组织的代码更新组织信息
     * @param cOrgCode 组织代码
     * @param org 组织对象
     * @return 修改成功 则返回ErrorCode.NO_ERROR,否则返回其他错误码
     * @作者:Administrator
     * @时间:2015年11月16日 上午11:36:53
     * @备注:
     */
    public Integer updateOrgByCode(String cOrgCode, Organization org);

    /**
     * 多条件,分页,排序 查询组织列表
     * @param pageNo 分页页号
     * @param page 分页大小
     * @param orgName 组织名称，可选查询参数
     * @return
     * @作者:Administrator
     * @时间:2015年11月16日 下午3:56:34
     * @备注:
     */
    public Result<PagedData<Organization>> getOrgList(Integer pageNo,Integer pageSize,String orgName, String orgCode);

    /**
     * 判断是否存在组织名称 orgName
     * @param orgName 组织名称
     * @return 若存在返回true,否则false,如果orgName为null，返回true
     * @作者:virgil
     * @时间:2015年9月28日 下午3:09:04
     * @备注:
     */
    public boolean existOrgName(String orgName);

    /**
     * 根据组织编码 orgCode 查询其 直接 子节点
     * @param orgCode 组织编码
     * @return Organization对象集合
     * @作者:virgil
     * @时间:2015年9月29日 上午10:37:02
     * @备注:
     */
    public List<Organization> getChildList(String orgCode);

    /**
     * 通过组织编码,查询该组织所属的所有组织,包括该组织本身
     * @param cOrgCode 组织编码
     * @return 如果组织编码为null，返回一个空集合，组织编码为ADMIN_ORG_ID，返回所有组织，其他返回该组织所属的所有组织,
     *         包括该组织本身
     * @作者:Administrator
     * @时间:2015年11月16日 上午10:57:45
     * @备注:
     */
    public List<Organization> getOrgsByOrgCode(String cOrgCode);

    /**
     * 获取指定区域子区域
     * @param cParentCode 区域编码
     * @return
     * @作者:Administrator
     * @时间:2016年6月14日 上午10:28:55
     * @备注:
     */
    public List<Area> getChildArea(String cParentCode);

    /**
     * 获取所有组织
     * @return
     * @作者:Administrator
     * @时间:2016年6月14日 上午10:28:55
     * @备注:
     */
    public List<Organization> listAllOrgs();

    /**
     * 获取指定组织
     * @param orgCode 组织编码
     * @return
     * @作者:Administrator
     * @时间:2016年6月14日 上午10:28:55
     * @备注:
     */
    public Organization getOrgbyCode(String orgCode);

    /**
     * 获取指定组织信息
     * @param orgCode 组织编码
     * @return
     * @作者:Administrator
     * @时间:2016年6月14日 上午10:28:55
     * @备注:
     */
    public Organization getOrgInfobyCode(String orgCode);

	public List<Organization> getOrgbyDomainCode(String domainCode);
}
