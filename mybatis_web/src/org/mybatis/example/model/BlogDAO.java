package org.mybatis.example.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BlogDAO {
   InputStream inputStream = null;
   SqlSessionFactory sqlSessionFactory = null;
   SqlSession session = null;
   
   public BlogDAO() {
      try {
         inputStream = Resources.getResourceAsStream("org/mybatis/example/mybatis-config.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         session = sqlSessionFactory.openSession(true);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public Blog selectOne(int id) {
      return session.selectOne("BlogMapper.selectBlog", id);
   }
   
   public Blog selectOne(Blog blog) {
      return session.selectOne("BlogMapper.selectBlog", blog);
   }
   
   public List<Blog> selectAll() {
      return session.selectList("BlogMapper.selectAll");
   }
   
   public void insert(Blog blog) {
      session.insert("BlogMapper.insertBlog", blog);
      session.commit();
   }
   
   public void update(Blog blog) {
      session.update("BlogMapper.updateBlog", blog);
      session.commit();
   }
   
   public void delete(Blog blog) {
      session.delete("BlogMapper.deleteBlog", blog);
      session.commit();
   }
   
   public List<Blog> selectByTitle(Blog newBlog) {
      return session.selectList("BlogMapper.selectByTitle", newBlog);
   }
   
   public static void main(String[] args) {
      BlogDAO dao = new BlogDAO();
      
//      Blog blog = dao.selectOne(101);
//      System.out.println(blog);
      
//      Blog blog = dao.selectOne(new Blog(101));
//      System.out.println(blog);
      
//      Blog bbb = new Blog(0, "TEST3", "입력 테스트", "테스트 내용2");
//      dao.insert(bbb);
      
      //Blog newBlog = new Blog(104, "TEST3", "세번째 입력 테스트", "테스트 내용 수정");
      //dao.update(newBlog);
      
//      Blog newBlog = new Blog(104, "TEST3", "세번째 입력 테스트", "테스트 내용 수정");
//      dao.delete(newBlog);
      
      Blog newBlog = new Blog(0, null, "테스트", null);
      List<Blog> list = dao.selectByTitle(newBlog);
//       List<Blog> list = dao.selectAll();
      
      for(Blog b : list) {
         System.out.println(b);
      }
   }

   
}