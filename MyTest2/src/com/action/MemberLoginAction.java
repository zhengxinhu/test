package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Member;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MemberService;

@Scope("request")
@Controller
public class MemberLoginAction extends ActionSupport {
	private Member member;
	
	@Resource(name="memberService")
	private MemberService memberService;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	//ע��ҵ���߼����
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public String execute(){
		Member mb =memberService.findByName(member.getName(), member.getPassword());
		if(mb!=null)
			return SUCCESS;
		else
			return ERROR;
	}
}
