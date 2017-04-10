package com.dao;

import java.util.List;

import com.entity.Member;

public interface MemberDAO {
	public void add(Member member);
	public void update(Member member);
	public void delete(int id);
	public Member findByName(String name,String password);
	public Member findById(int id);
	public List<Member> findAll();

}
