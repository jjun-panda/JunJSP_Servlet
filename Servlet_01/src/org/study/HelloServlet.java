package org.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
   private String name;
   
   @Override
   public void init() throws ServletException {
      System.out.println("1. init() - HelloServlet");
      name = "김길동";
   }
   
   @Override
   public void destroy() {
      System.out.println("3. destroy() - HelloServlet");
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("2-1. doGet() - HelloServlet");
      System.out.println("name => " + name);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("2-2. doPost() - HelloServlet");
   }
   
}