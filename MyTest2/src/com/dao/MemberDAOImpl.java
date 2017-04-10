package com.dao;

import java.util.List;

import javax.annotation.Resource;

import com.entity.Member;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


@Scope("request")
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	//���췽��ע��SessionFactory����
	public MemberDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	//ʹ��SessionFactory���󷵻�Session����
	public Session currentSession(){
		return sessionFactory.openSession();
	}
	@Override
	public void add(Member member) {
		Session session=null;
		try {
			session=currentSession();
			Transaction tx = session.beginTransaction();
			session.save(member);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	@Override
	public void update(Member member) {
		Session session=null;
		try {
			session=currentSession();
			Transaction tx = session.beginTransaction();
			session.update(member);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	@Override
	public void delete(int id) {
		Session session=null;
		try {
			session=currentSession();
			Transaction tx = session.beginTransaction();
			Member mb = (Member)session.get(Member.class, id);
			session.delete(mb);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	@Override
	public Member findByName(String name, String password) {
		Session session=null;
		Member result = null;
		try {
			session=currentSession();
			Transaction tx = session.beginTransaction();
			String hsql = " from Member m where m.name = :mname and m.password = :mpassword";
			Query query = session.createQuery(hsql);
			query.setParameter("mname", name);
			query.setParameter("mpassword", password);
			result = (Member)query.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	@Override
	public Member findById(int id) {
		Session session=null;
		Member result = null;
		try {
			session=currentSession();
			Transaction tx = session.beginTransaction();
			String hsql = " from Member m where m.id = :id";
			Query query = session.createQuery(hsql);
			query.setParameter("id",id);
			result = (Member)query.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	@Override
	public List<Member> findAll() {
		Session session=null;
		List<Member> list = null;
		try {
			session=currentSession();
			Transaction tx = session.beginTransaction();
			String hsql = " from Member";
			Query query = session.createQuery(hsql);
			list = query.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

}
