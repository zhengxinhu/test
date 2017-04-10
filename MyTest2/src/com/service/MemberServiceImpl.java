package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.entity.Member;


@Scope("request")
@Service
public class MemberServiceImpl implements MemberService {
	
	@Resource(name="memberDao")
	private MemberDAO memberDao;
	//��ֵע��DAO����
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void add(Member member) {
		if(memberDao.findById(member.getId())==null)
			memberDao.add(member);

	}

	@Override
	public void update(Member member) {
		if(memberDao.findById(member.getId())!=null)
			memberDao.update(member);

	}

	@Override
	public void delete(int id) {
		if(memberDao.findById(id)!=null)
			memberDao.delete(id);

	}

	@Override
	public Member findByName(String name, String password) {
		return memberDao.findByName(name, password);
	}

	@Override
	public Member findById(int id) {
		return memberDao.findById(id);
	}

	@Override
	public List<Member> findAll() {
		return memberDao.findAll();
	}

}
