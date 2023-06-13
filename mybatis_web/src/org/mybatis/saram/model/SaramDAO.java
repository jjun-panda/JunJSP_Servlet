package org.mybatis.saram.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SaramDAO {

	InputStream inputStream = null;
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession session;

	public SaramDAO() {
		try {
			inputStream = Resources.getResourceAsStream("org/mybatis/saram/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Saram selectOne(int seq) {
		return session.selectOne("SaramMapper.selectSaram", seq);
	}
	
	public Saram selectOne(Saram saram) {
		return session.selectOne("SaramMapper.selectSaram", saram);
	}
	
	public List<Saram> selectAll() {
		return session.selectList("SaramMapper.selectAll");
	}
	
	public void insert(Saram saram) {
		session.insert("SaramMapper.insertSaram", saram);
		session.commit();
	}
	
	public void update(Saram saram) {
		session.update("SaramMapper.updateSaram", saram);
		session.commit();
	}
	
	public void delete(Saram saram) {
		session.delete("SaramMapper.deleteSaram", saram);
		session.commit();
	}
	
	public List<Saram> findByName(Saram newSaram) {
		return session.selectList("SaramMapper.findByName", newSaram);
	}
	public static void main(String[] args) {
			SaramDAO dao = new SaramDAO();
		
	      Saram saram = dao.selectOne(2);
	      System.out.println(saram);
		
//	      Saram saram = dao.selectOne(new Saram(2));
//	      System.out.println(saram);
		
//	      Saram saram = new Saram(0, "강동길", "강동길님", "mam@abc.com");
//	      dao.insert(saram);
		
//		Saram newSaram = new Saram(23, "강동원", 170, 60, 20, "남자");
//		dao.update(newSaram);
		
//	      Saram newSaram = new Saram(23, "강동원", 170, 60, 20, "남자");
//	      dao.delete(newSaram);
			
//		Saram newSaram = new Saram(0, "", 0, 0, 0, "남자");
//		List<Saram> list = dao.findByName(newSaram);
//	       List<Saram> list = dao.selectAll();
		
//		for(Saram b : list) {
//			System.out.println(b);
//		}
	}
}
