package com.yc.vote.mapper;

import java.util.List;

import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.VoteBean;

public interface SubjectMapper {
	List<Subject> findAllSubjects();
	List<SubjectBean> findAllSubjectBeans();
	OptionBean findOptionByVsId(int vsId);
	VoteBean findVoteBeanByVsId(int vsId);
	void insert(Item item);
}