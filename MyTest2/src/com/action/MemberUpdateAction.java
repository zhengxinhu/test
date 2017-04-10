package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Member;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MemberService;

@Scope("request")
@Controller
public class MemberUpdateAction extends ActionSupport {
	
	@Resource(name="memberService")
	private MemberService memberService;
	private Member member;
	private int id;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String showMember(){
		Member mb = memberService.findById(getId());
		setMember(mb);
		return SUCCESS;
	}
	public String execute(){
		memberService.update(member);
		return SUCCESS;
	}
}
