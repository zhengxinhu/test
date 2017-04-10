package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Member;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MemberService;

@Scope("request")
@Controller
public class MemberQueryAction extends ActionSupport {
	
	@Resource(name="memberService")
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public String execute(){
		List<Member> list = memberService.findAll();
		ServletActionContext.getRequest().setAttribute("memberList", list);
		return SUCCESS;
	}
}
