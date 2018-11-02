/**
 * 文件名：OrgServiceImpl.java
 * 时间：2015年9月24日 上午9:01:20
 * 作者：virgil
 * 备注：
 */

package com.hngd.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hngd.common.dao.CodeMapper;
import com.hngd.common.error.ErrorCode;
import com.hngd.common.exception.DBErrorException;
import com.hngd.common.result.Result;
import com.hngd.common.result.Results;
import com.hngd.common.service.CodeUtils;
import com.hngd.common.util.SqlUtils;
import com.hngd.common.web.page.PageHelper;
import com.hngd.common.web.page.PagedData;
import com.hngd.dao.AreaMapper;
import com.hngd.dao.DomainOrgMapper;
import com.hngd.dao.OrganizationMapper;
import com.hngd.model.Area;
import com.hngd.model.AreaExample;
import com.hngd.model.DomainOrgExample;
import com.hngd.model.DomainOrgKey;
import com.hngd.model.Organization;
import com.hngd.model.OrganizationExample;
import com.hngd.service.OrgService;
 

/**
 * @author virgil
 */
@Service
public class OrgServiceImpl implements OrgService
{
    private static final Logger    logger = LoggerFactory.getLogger(OrgService.class);
    @Autowired
    private OrganizationMapper     orgDao;
    
    @Autowired
    private AreaMapper             areaDao;
    
    @Autowired
    private DomainOrgMapper domainOrgDao;

    @Override
    public Result<String> addOrgnization(Organization org, String areaCode)
    {
        if (StringUtils.isEmpty(areaCode)){
            logger.debug("the org is null or areaCode is empty");
            return Result.INVALID_PARAMETER;
        }
        if (existOrgName(org.getName())){
            return Results.newFailResult(ErrorCode.NAME_EXIST, "组织名称已存在");
        }
        // 如果添加组织没有上级，默认
        if (org.getParentCode() == null){
            return Results.newFailResult(ErrorCode.INVALID_PARAMETER, "上级组织不能为空");
        }
        String orgCode = CodeUtils.generateOrgCode(areaCode, this);
        if (orgCode == null){
            return Results.newFailResult(ErrorCode.SERVER_INTERNAL_ERROR, "生成组织代码失败");
        }
        org.setAreaCode(areaCode);
        org.setCode(orgCode);
        
        if (orgDao.insertSelective(org) > 0){
            return Results.newSuccessResult(orgCode);
        } else{
            return Results.newFailResult(ErrorCode.DB_ERROR,"组织数据写入数据库失败");
        }
    }

    @Override
    public Integer deleteOrgByCodes(List<String> codes){ 
        if (CollectionUtils.isEmpty(codes)){
            logger.debug("the ids has no data");
            return ErrorCode.INVALID_PARAMETER;
        }
        //TODO delete related resource,such as users,devices,sub orgs
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andCodeIn(codes);
        int result = orgDao.deleteByExample(example);
        deleteOrgByParentCodes(codes);
        deleteDomainOrgByOrgCode(codes);
        if (result > 0){
            return ErrorCode.NO_ERROR;
        } else{
            throw new DBErrorException();
        }
    }

    private Integer deleteOrgByParentCodes(List<String> parentCodes) {
    	OrganizationExample example = new OrganizationExample();
    	example.createCriteria().andParentCodeIn(parentCodes);
    	int result = orgDao.deleteByExample(example);
    	if(result > 0) {
    		return ErrorCode.NO_ERROR;
    	}else {
    		return ErrorCode.TARGET_NOT_FOUND;
    	}
    }
    
    private Integer deleteDomainOrgByOrgCode(List<String> orgCodes) {
    	DomainOrgExample example = new DomainOrgExample();
    	example.createCriteria().andOrgCodeIn(orgCodes);
    	int result = domainOrgDao.deleteByExample(example);
    	if(result > 0) {
    		return ErrorCode.NO_ERROR;
    	}else {
    		return ErrorCode.TARGET_NOT_FOUND;
    	}
    }
    
    @Override
    public Integer updateOrgByCode(String orgCode, Organization org){
        if (StringUtils.isEmpty(orgCode)){
            logger.debug("the org is null or  cOrgCode is null" + org);
            return ErrorCode.INVALID_PARAMETER;
        }
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andCodeEqualTo(orgCode);
        if (orgDao.updateByExampleSelective(org, example) > 0){
            return ErrorCode.NO_ERROR;
        } else{
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public Result<PagedData<Organization>> getOrgList(Integer pageNo,Integer pageSize,String orgName, String orgCode){
        OrganizationExample example = new OrganizationExample();
        OrganizationExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(orgName)){
            criteria.andNameLike(SqlUtils.wrapLike(orgName));            	
        }
        if(!StringUtils.isEmpty(orgCode)) {
        	List<String> orgCodes = getAllChildOrgCodes(orgCode);
        	criteria.andCodeIn(orgCodes);
        }
        PagedData<Organization> pr = PageHelper.startPage(pageNo, pageSize);
        pr.setResultAndEnd(orgDao.selectByExample(example));
        return Results.newSuccessResult(pr);
    }

    @Override
    public boolean existOrgName(String orgName){
        if (StringUtils.isEmpty(orgName)){
            logger.debug("the orgName is empty");
            return true;
        }
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andNameEqualTo(orgName);
        List<?> list = orgDao.selectByExample(example);
        return !CollectionUtils.isEmpty(list);
    }

    @Override
    public List<Organization> getChildList(String parentCode){
        if (StringUtils.isEmpty(parentCode)){
            logger.error("the parentCode is empty");
            return null;
        }
        OrganizationExample example = new OrganizationExample();
        OrganizationExample.Criteria criteria = example.createCriteria();
        criteria.andParentCodeEqualTo(parentCode);
        return orgDao.selectByExample(example);
    }

    @Override
    public List<Organization> listAllOrgs(){
        OrganizationExample example = new OrganizationExample();
        return orgDao.selectByExample(example);
    }

    @Override
    public Organization getOrgbyCode(String orgCode){
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andCodeEqualTo(orgCode);
        List<Organization> orgs= orgDao.selectByExample(example);
        return CollectionUtils.isEmpty(orgs)?null:orgs.get(0);
    }

    @Override
    public List<Organization> getOrgsByOrgCode(String cOrgCode){
        List<Organization> organizations = new LinkedList<Organization>();
        if (StringUtils.isEmpty(cOrgCode)){
            logger.error("the cOrgCode is empty");
            return organizations;
        }
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andCodeEqualTo(cOrgCode);
        // 找到最上层组织
        List<Organization> orgs = orgDao.selectByExample(example);
        LinkedList<Organization> temp = new LinkedList<Organization>();
        if (!CollectionUtils.isEmpty(orgs)){
            temp.offer(orgs.get(0));
        }
        // 将最上层组织节点发到队尾
        // 使用广度优先搜索查找所有组织树
        while (temp.size() > 0){
            // 从队头取一个组织节点
            Organization org = temp.poll();
            if (org == null){
                logger.error("the org is null ");
                break;
            }
            // 将该组直接点保存起来
            organizations.add(org);
            String parentName = org.getName();
            // 获取当前组织节点的所有子节点
            List<Organization> list = getChildList(org.getCode());
            // 将当前节点的所有子节点放到队尾
            if (!CollectionUtils.isEmpty(list)){
                for (Organization e : list)
                {
                	//TODO set parent name
                    //e.setParentName(parentName);
                    temp.offer(e);
                }
            }
        }
        return organizations;
    }

    @Override
    public boolean isCodeExist(String code){
        if (StringUtils.isEmpty(code)){
            return true;
        }
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andCodeEqualTo(code);
        List<?> list = orgDao.selectByExample(example);
        return !CollectionUtils.isEmpty(list);
    }

    @Override
    public List<Area> getChildArea(String parentCode){
        if (StringUtils.isEmpty(parentCode)){
            return null;
        }
        AreaExample example = new AreaExample();
        example.createCriteria().andParentCodeEqualTo(parentCode);
        return areaDao.selectByExample(example);
    }
    @Autowired
    private CodeMapper codeMapper;

    @Override
    public CodeMapper getCodeMapper(){
        return codeMapper;
    }

    @Override
    public Organization getOrgInfobyCode(String orgCode){
        if (StringUtils.isEmpty(orgCode)){
            return null;
        }
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andCodeEqualTo(orgCode);
        List<Organization> list = orgDao.selectByExample(example);
        return (!CollectionUtils.isEmpty(list)) ? list.get(0) : null;
    }

	@Override
	public List<Organization> getOrgbyDomainCode(String domainCode) {
		DomainOrgExample example=new DomainOrgExample();
		example.createCriteria().andDomainCodeEqualTo(domainCode);
		List<DomainOrgKey> domainOrgs=domainOrgDao.selectByExample(example);
		if(CollectionUtils.isEmpty(domainOrgs)){
			return Collections.EMPTY_LIST;
		}
		List<String> orgCodes=domainOrgs.stream()
				.map(DomainOrgKey::getOrgCode)
				.collect(Collectors.toList());
		OrganizationExample orgExample=new OrganizationExample();
		orgExample.createCriteria().andCodeIn(orgCodes);
		return orgDao.selectByExample(orgExample);
	}
	
	private List<String> getAllChildOrgCodes(String orgCode){
		List<Organization> orgs = getOrgsByOrgCode(orgCode);
		List<String> orgCodes = new ArrayList<String>();
		if(orgs != null) {
			for(Organization org : orgs) {
				orgCodes.add(org.getCode());
			}
		}
		return orgCodes;
	}
}
