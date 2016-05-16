package com.yc.vote.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.mapper.SubjectMapper;
import com.yc.vote.service.VoteService;
@Transactional
@Service("voteService")
public class VoteServiceImpl implements VoteService {
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public List<Subject> findAllSubjects() {
		return subjectMapper.findAllSubjects();
	}

	@Override
	public List<SubjectBean> findAllSubjectBeans() {
		return subjectMapper.findAllSubjectBeans();
	}

	@Override
	public OptionBean findOptionByVsId(int vsId) {
		return subjectMapper.findOptionByVsId(vsId);
	}

	@Override
	public VoteBean findVoteBeanByVsId(int vsId) {
		return subjectMapper.findVoteBeanByVsId(vsId);
	}

	@Override @Transactional(propagation=Propagation.REQUIRED)
	public boolean saveVote(Item item) {
		try {
			subjectMapper.insert(item);
			return true;
		} catch (Exception e) {
			LogManager.getLogger().error("投票失败",e);
			throw new RuntimeException("投票失败",e);
		}
	}



}
