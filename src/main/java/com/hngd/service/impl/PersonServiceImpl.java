package com.hngd.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.hngd.common.dao.CodeMapper;
import com.hngd.common.error.ErrorCode;
import com.hngd.common.exception.DBErrorException;
import com.hngd.common.result.Result;
import com.hngd.common.result.Results;
import com.hngd.common.util.SqlUtils;
import com.hngd.common.util.UuidUtils;
import com.hngd.common.web.page.PageHelper;
import com.hngd.common.web.page.PagedData;
import com.hngd.dao.PersonnelInfoMapper;
import com.hngd.dao.PersonnelMapper;
import com.hngd.dao.UserMapper;
import com.hngd.model.Personnel;
import com.hngd.model.PersonnelExample;
import com.hngd.model.PersonnelInfo;
import com.hngd.model.PersonnelInfoExample;
import com.hngd.model.User;
import com.hngd.service.PersonService;
import com.hngd.util.PasswordUtils;

@Service
public class PersonServiceImpl implements PersonService{

	private static final Logger  logger = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	private PersonnelMapper   	dao;

	@Autowired
	private PersonnelInfoMapper piDao;
	
	@Autowired
	private UserMapper          userDao;

	@Override
	public Result<String> addPersonnel(Personnel ps) {
		ps.setId(UuidUtils.uuid());
		if(existPersonnel(ps.getName())) {
			return Results.newFailResult(ErrorCode.NAME_EXIST, "人员名称已存在");
		}
		if(ps.getPersonnelNum() == null) {
			return Results.newFailResult(ErrorCode.INVALID_PARAMETER, "人员编号不能为空");
		}
		if(ps.getDepId() == null) {
			return Results.newFailResult(ErrorCode.INVALID_PARAMETER, "部门不能为空");
		}

		int result = dao.insert(ps);
		if(result > 0) {
			if(ps.getUserName() != null && ps.getUsePwd() != null) {
				User u = new User();
				u.setId(UuidUtils.uuid());
				u.setLoginName(ps.getUserName());
				u.setLoginPassword(ps.getUsePwd());
				u.setGender(ps.getSex());
				u.setEmail(ps.getEmail());
				u.setState((short) 1);
				u.setDomainCode("-1");
				PasswordUtils.processUser(u);
				userDao.insert(u);
			}
			
			return Results.newSuccessResult(ps.getId());
		}else {
			return Results.newFailResult(ErrorCode.DB_ERROR, "添加人员信息失败");
		}
	}

	@Override
	public boolean existPersonnel(String name) {
		if(StringUtils.isEmpty(name)) {
			return true;
		}
		PersonnelExample example = new PersonnelExample();
		example.createCriteria().andNameEqualTo(name);
		List<?> list = dao.selectByExample(example);
		return !CollectionUtils.isEmpty(list);
	}

	@Override
	public Integer updatePersonnelById(String id, Personnel ps) {
		if(StringUtils.isEmpty(id)) {
			logger.debug("the personnel is null or id is null" + id);
			return ErrorCode.INVALID_PARAMETER;
		}
		PersonnelExample example = new PersonnelExample();
		example.createCriteria().andIdEqualTo(id);
		int result = dao.updateByExample(ps, example);
		if(result > 0) {
			return ErrorCode.NO_ERROR;
		}else {
			return ErrorCode.DB_ERROR;
		}
	}

	@Override
	public Integer deletePersonnelByids(List<String> ids) {
		if(CollectionUtils.isEmpty(ids)) {
			logger.debug("the ids has no data");
			return ErrorCode.INVALID_PARAMETER;
		}
		PersonnelExample example = new PersonnelExample();
		example.createCriteria().andIdIn(ids);
		int result = dao.deleteByExample(example);
		if(result > 0) {
			return ErrorCode.NO_ERROR;
		}else {
			throw new DBErrorException();
		}
	}

	@Override
	public Result<PagedData<PersonnelInfo>> getPersonnelList(Integer pageNo, Integer pageSize, String name,
			String phone, String personnelNum, String depName) {
		PersonnelInfoExample example = new PersonnelInfoExample();
		PersonnelInfoExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(name)) {
			criteria.andNameLike(SqlUtils.wrapLike(name));
		}
		if(!StringUtils.isEmpty(phone)) {
			criteria.andNameLike(SqlUtils.wrapLike(phone));
		}
		if(!StringUtils.isEmpty(personnelNum)) {
			criteria.andNameLike(SqlUtils.wrapLike(personnelNum));
		}
		if(!StringUtils.isEmpty(depName)) {
			criteria.andNameLike(SqlUtils.wrapLike(depName));
		}
		PagedData<PersonnelInfo> pr = PageHelper.startPage(pageNo, pageSize);
		pr.setResultAndEnd(piDao.selectByExample(example));
		return Results.newSuccessResult(pr);
	}

	@Override
	public List<Personnel> getPersonnelInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateDepIdByPersonnelId(String depId, List<String> personIds) {
		for(String personId : personIds) {
			Personnel p = new Personnel();
			p.setDepId(depId);
			PersonnelExample example = new PersonnelExample();
			example.createCriteria().andIdEqualTo(personId);
			int result = dao.updateByExample(p, example);
			if(result < 0) {
				throw new DBErrorException();
			}
		}
		return ErrorCode.NO_ERROR;
	}
	
	@Autowired
	private CodeMapper codeMapper;
	
	@Override
	public boolean isCodeExist(String code) {
		if(StringUtils.isEmpty(code)) {
			return true;
		}
		PersonnelExample example = new PersonnelExample();
		example.createCriteria().andPersonnelNumEqualTo(code);
		List<?> list = dao.selectByExample(example);
		return !CollectionUtils.isEmpty(list);
	}

	@Override
	public CodeMapper getCodeMapper() {
		
		return codeMapper;
	}

}
