package com.yc.vote.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.vote.entity.Subject;
import com.yc.vote.entity.SubjectBean;
import com.yc.vote.entity.User;
import com.yc.vote.service.UserService;
import com.yc.vote.service.VoteService;
import com.yc.vote.util.VoteData;

@Controller("userAction")
public class UserAction implements ModelDriven<User>,SessionAware{
	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	@Autowired
	private VoteService voteService;

	private Map<String, Object> session;

	
	//打开登录界面
	public String login(){
		return "login";
	}

	//首页主题列表信息
	public String list(){
		User result=userService.login(user);
		if(result!=null){
			session.put(VoteData.LOGIN_USER, result);

			return "list";
		}else{
			session.put(VoteData.ERR_MSG, "用户名或密码错误");
			return "login";
		}
	}

	//注册
	public String register(){
		int result=userService.register(user);
		if(result==1){
			return "reg_success";
		}
		return "reg_fail";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public User getModel() {
		return user;
	}

}
