package com.yc.vote.web.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vote.entity.Item;
import com.yc.vote.entity.OptionBean;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.VoteBean;
import com.yc.vote.service.MoreVoteService;
import com.yc.vote.service.VoteService;

@Controller("voteAction")
public class VoteAction implements SessionAware,ModelDriven<Item>{
	@Autowired
	private VoteService voteService;
	private Map<String, Object> session;
	private Item item;
	private List<String> voId;
	@Autowired
	private MoreVoteService moreVoteService;

	

	public List<String> getVoId() {
		return voId;
	}

	public void setVoId(List<String> voId) {
		this.voId = voId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	
	
	//首页主题列表信息
	public String list(){
		List<SubjectBean> subjects=allVote();
		session.put("subjects", subjects);
		return "list";
	}

	//
	public String view(){
		OptionBean options=voteService.findOptionByVsId(item.getVsId());
		session.put("optionBean", options);
		return "view";
	}
	
	//
	public String vote(){
		VoteBean voteBean=voteService.findVoteBeanByVsId(item.getVsId());
		session.put("voteBean", voteBean);
		return "vote";
	}
	
	public String save(){
		String[] voId=ServletActionContext.getRequest().getParameterValues("voId");
		LogManager.getLogger().debug("save取到的item="+item+"voId="+Arrays.toString(voId));
		try {
			moreVoteService.saveVote(item,voId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		session.put("saveMsg", "投票失败");
		return "savefail";
		
		
	}
	//查询所有主题列表
	public List<SubjectBean> allVote() {
		List<SubjectBean> subjects=voteService.findAllSubjectBeans();
		return subjects;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	 
	}

	@Override
	public Item getModel() {
		this.item=new Item();
		return item;
	}
}
