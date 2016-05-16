package com.yc.vote.web.action;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller("subjectAction")
public class SubjectAction implements ModelDriven<AddSubjectBean>{
	private AddSubjectBean addSubjectBean;
	
	public String save(){
		LogManager.getLogger().debug("subjectAction==>进来了");
		return "saveSuccess";
		
	}

	@Override
	public AddSubjectBean getModel() {
		// TODO Auto-generated method stub
		addSubjectBean=new AddSubjectBean();
		return null;
	}

}
