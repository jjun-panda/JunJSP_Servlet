package org.mybatis.member.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

	InputStream inputStream = null;
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession session = null;

	public MemberDAO() {
		try {
			inputStream = Resources.getResourceAsStream("org/mybatis/member/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member selectOne(int id) {
		return session.selectOne("MemberMapper.selectMember", id);
	}
	
	public Member selectOne(Member member) {
		return session.selectOne("MemberMapper.selectMember", member);
	}
	
	public List<Member> selectAll() {
		return session.selectList("MemberMapper.selectAll");
	}
	
	public void insert(Member member) {
		session.insert("MemberMapper.insertMember", member);
		session.commit();
	}
	
	public void update(Member member) {
		session.update("MemberMapper.updateMember", member);
		session.commit();
	}
	
	public void delete(Member member) {
		session.delete("MemberMapper.deleteMember", member);
		session.commit();
	}
	
	public List<Member> findByName(Member newMember) {
		return session.selectList("MemberMapper.findByName", newMember);
	}
	public static void main(String[] args) {
			MemberDAO dao = new MemberDAO();
		
//	      Member member = dao.selectOne(2);
//	      System.out.println(member);
		
//	      Member member = dao.selectOne(new Member(2));
//	      System.out.println(member);
		
	      Member member = new Member(0, "강동길", 177, 80, 20, "남자");
	      dao.insert(member);
		
//		Member newMember = new Member(23, "강동원", 170, 60, 20, "남자");
//		dao.update(newMember);
		
//	      Member newMember = new Member(23, "강동원", 170, 60, 20, "남자");
//	      dao.delete(newMember);
			
//		Member newMember = new Member(0, "", 0, 0, 0, "남자");
//		List<Member> list = dao.findByName(newMember);
//	       List<Member> list = dao.selectAll();
		
//		for(Member b : list) {
//			System.out.println(b);
//		}
	}
}
