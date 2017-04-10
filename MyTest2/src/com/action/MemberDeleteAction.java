package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.service.MemberService;

@Scope("request")
@Controller
public class MemberDeleteAction extends ActionSupport {
	
	@Resource(name="memberService")
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	private int id;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String execute(){
		memberService.delete(getId());
		return SUCCESS;
	}
}
