package com.yc.vote.entity;

import java.io.Serializable;
import java.util.List;

public class VoteBean implements Serializable{
	private static final long serialVersionUID = 866746979643064267L;
	private int vsId;
	private String vsTitle;
	private int vsType;
	
	public int getVsId() {
		return vsId;
	}
	public void setVsId(int vsId) {
		this.vsId = vsId;
	}
	public int getVsType() {
		return vsType;
	}
	public void setVsType(int vsType) {
		this.vsType = vsType;
	}
	private int optionCount;
	private List<Option> options;
	private int voteUserCount;
	
	public String getVsTitle() {
		return vsTitle;
	}
	public void setVsTitle(String vsTitle) {
		this.vsTitle = vsTitle;
	}
	public int getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public int getVoteUserCount() {
		return voteUserCount;
	}
	public void setVoteUserCount(int voteUserCount) {
		this.voteUserCount = voteUserCount;
	}
	@Override
	public String toString() {
		return "VoteBean [vsId=" + vsId + ", vsTitle=" + vsTitle + ", vsType="
				+ vsType + ", optionCount=" + optionCount + ", options="
				+ options + ", voteUserCount=" + voteUserCount + "]";
	}
	
}
