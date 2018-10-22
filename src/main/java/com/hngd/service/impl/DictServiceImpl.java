package com.hngd.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.druid.util.StringUtils;
import com.hngd.common.error.ErrorCode;
import com.hngd.common.result.Result;
import com.hngd.common.result.Results;
import com.hngd.common.util.SqlUtils;
import com.hngd.common.util.UuidUtils;
import com.hngd.common.web.page.PageHelper;
import com.hngd.common.web.page.PagedData;
import com.hngd.dao.DictDetailInfoMapper;
import com.hngd.dao.DictDetailMapper;
import com.hngd.dao.DictMapper;
import com.hngd.model.Dict;
import com.hngd.model.DictDetail;
import com.hngd.model.DictDetailExample;
import com.hngd.model.DictDetailInfo;
import com.hngd.model.DictDetailInfoExample;
import com.hngd.model.DictExample;
import com.hngd.service.DictService;

@Service
public class DictServiceImpl implements DictService {

	private static final Logger logger = LoggerFactory.getLogger(DictService.class);
	
	@Autowired
	private DictMapper  	 dao;
	
	@Autowired
	private DictDetailMapper deDao;
	
	private DictDetailInfoMapper infoDao;
	
	@Override
	public Result<String> addDict(Dict d) {
		String name = d.getDictName();
		String dictCode = d.getDictCode();
		if(existName(name, dictCode)) {
			return Results.newFailResult(ErrorCode.INVALID_PARAMETER, "参数已存在");
		}
		
		String id =UuidUtils.uuid();
		d.setId(id);
		int result = dao.insertSelective(d);
		if(result > 0) {
			return Results.newSuccessResult(id);
		}else {
			return Results.newFailResult(ErrorCode.DB_ERROR, "添加字典信息失败");
		}
	}
	
	@Override
	public boolean existName(String name, String dictCode) {
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(dictCode)) {
			return true;
		}
		DictExample example = new DictExample();
		DictExample.Criteria criteria = example.createCriteria();
		criteria.andDictNameEqualTo(name).andDictCodeEqualTo(dictCode);
		List<Dict> list = dao.selectByExample(example);
		return !CollectionUtils.isEmpty(list);
	}

	@Override
	public Integer updateDict(String id, Dict d) {
		if(StringUtils.isEmpty(id)) {
			return ErrorCode.INVALID_PARAMETER;
		}
		if(existName(d.getDictName(),d.getDictCode())) {
			return ErrorCode.INVALID_PARAMETER;
		}
		
		DictExample examle = new DictExample();
		examle.createCriteria().andIdEqualTo(id);
		int result = dao.updateByExampleSelective(d, examle);
		if(result > 0){
			return ErrorCode.NO_ERROR;
		}else {
			return ErrorCode.TARGET_NOT_FOUND;
		}
	}

	@Override
	public Integer deleteDict(List<String> ids) {
		DictExample example = new DictExample();
		example.createCriteria().andIdIn(ids);
		int result = dao.deleteByExample(example);
		if(result > 0) {
			return ErrorCode.NO_ERROR;
		}else {
			return ErrorCode.TARGET_NOT_FOUND;
		}
	}

	@Override
	public Result<PagedData<Dict>> getDictList(Integer pageNo, Integer pageSize, String dictCode, String name) {
		PagedData<Dict> p = PageHelper.startPage(pageNo, pageSize);
		DictExample example = new DictExample();
		DictExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(name)) {
			criteria.andDictNameLike(SqlUtils.wrapLike(name));
		}
		if(!StringUtils.isEmpty(dictCode)) {
			criteria.andDictCodeLike(SqlUtils.wrapLike(dictCode));
		}
		List<Dict> list = dao.selectByExample(example);
		p.setResultAndEnd(list);
		return Results.newSuccessResult(p);
	}

	@Override
	public List<Dict> getChildList(String parentCode) {
		if(StringUtils.isEmpty(parentCode)) {
			logger.error("the parentCode is empty");
			return null;
		}
		DictExample example = new DictExample();
		example.createCriteria().andDictParentCodeEqualTo(parentCode);
		return dao.selectByExample(example);
	}

	@Override
	public Result<String> addDictDetail(DictDetail dd) {
		String detailCode = dd.getDetailCode();
		String detailName = dd.getDetailValue();
		if(existDetailName(detailName, detailCode)) {
			return Results.newFailResult(ErrorCode.INVALID_PARAMETER, "参数已存在");
		}
		
		String id = UuidUtils.uuid();
		dd.setId(id);
		int result = deDao.insertSelective(dd);
		if(result > 0) {
			return Results.newSuccessResult(id);
		}else {
			return Results.newFailResult(ErrorCode.DB_ERROR, "添加字典详情失败");
		}
	}

	@Override
	public boolean existDetailName(String name, String detailCode) {
		if(StringUtils.isEmpty(detailCode) && StringUtils.isEmpty(name)) {
			return true;
		}
		DictDetailExample example = new DictDetailExample();
		example.createCriteria().andDetailCodeEqualTo(detailCode).andDetailValueEqualTo(name);
		List<DictDetail> list = deDao.selectByExample(example);
		return !CollectionUtils.isEmpty(list);
	}

	@Override
	public Integer updateDictDetail(String id, DictDetail dd) {
		if(StringUtils.isEmpty(id)) {
			logger.error("the id is empty");
			return ErrorCode.INVALID_PARAMETER;
		}
		if(existDetailName(dd.getDetailValue(), dd.getDetailCode())) {
			return ErrorCode.INVALID_PARAMETER;
		}
		DictDetailExample example = new DictDetailExample();
		example.createCriteria().andIdEqualTo(id);
		int result = deDao.updateByExampleSelective(dd, example);
		if(result > 0) {
			return ErrorCode.NO_ERROR;
		}else {
			return ErrorCode.TARGET_NOT_FOUND;
		}
	}

	@Override
	public Integer deleteDcitDetailByIds(List<String> ids) {
		DictDetailExample example = new DictDetailExample();
		example.createCriteria().andIdIn(ids);
		int result = deDao.deleteByExample(example);
		if(result > 0) {
			return ErrorCode.NO_ERROR;
		}else {
			return ErrorCode.TARGET_NOT_FOUND;
		}
	}

	@Override
	public Result<PagedData<DictDetailInfo>> getDictDetailInfoList(Integer pageNo, Integer pageSize, String dictCode,
			String name) {
		PagedData<DictDetailInfo> p = PageHelper.startPage(pageNo, pageSize);
		DictDetailInfoExample example = new DictDetailInfoExample();
		DictDetailInfoExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(dictCode)) {
			criteria.andDictCodeLike(SqlUtils.wrapLike(dictCode));
		}
		if(!StringUtils.isEmpty(name)) {
			criteria.andDetailValueLike(SqlUtils.wrapLike(name));
		}
		List<DictDetailInfo> list = infoDao.selectByExample(example);
		p.setResultAndEnd(list);
		return Results.newSuccessResult(p);
	}

	@Override
	public List<DictDetail> getDictDetailByDictCode(String dictCode) {
		if(StringUtils.isEmpty(dictCode)) {
			logger.error("the dictCode is empty");
			return null;
		}
		DictDetailExample example = new DictDetailExample();
		example.createCriteria().andDictCodeEqualTo(dictCode);
		return deDao.selectByExample(example);
	}

	@Override
	public Integer updateDetailByDictCode(String dictCode, List<String> ids) {
		
		return null;
	}

}
