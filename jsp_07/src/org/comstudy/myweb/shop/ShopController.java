package org.comstudy.myweb.shop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.comstudy.myweb.controller.Controller;

public class ShopController implements Controller {
   // 상품 목록
   static private List<Product> productList = new ArrayList<Product>();
   static {
      productList.add(new Product(1, "선풍기", 40, 0));
      productList.add(new Product(2, "냉장고", 300, 0));
      productList.add(new Product(3, "노트북", 200, 0));
      productList.add(new Product(4, "테레비", 500, 0));
      productList.add(new Product(5, "냉장고", 700, 0));
      productList.add(new Product(6, "세탁기", 600, 0));
      productList.add(new Product(7, "마우스", 500, 0));
      productList.add(new Product(8, "컴퓨터", 400, 0));
      productList.add(new Product(9, "인덕션", 700, 0));
      productList.add(new Product(10, "청소기", 800, 0));
      productList.add(new Product(11, "핸드폰", 300, 0));
   }

   HttpSession session;
      // System.out.println("execute - ShopController");
      
   @Override
   public String execute(HttpServletRequest req) {
      session = req.getSession();

      
      String filePath = (String)req.getAttribute("filePath");
      String viewName = "shop/product_list";
      if("/product_list.do".equals(filePath)) {
         // 상품 목록 request에 저장
         req.setAttribute("productList", productList);         
         // 페이지 전환
         viewName = "shop/product_list";
      } else if("/product_detail.do".equals(filePath)) {
         // 상품을 session의 cartList에 추가
         int seq = Integer.parseInt(req.getParameter("seq"));
         Product product = null;
         for(int i=0; i<productList.size(); i++) {
            if(productList.get(i).getSeq() == seq) {
               product = productList.get(i);
               break;
            }
         }
         req.setAttribute("product", product);
         viewName = "shop/product_detail";
      } else if("/cart_list.do".equals(filePath)) {
         // 상품을 session의 cartList에 추가
         
         List<Product> cartList = null;
         // session에 cartList가 있다면 carList 참조
         // session에 없다면 새 리스트 만들어서 session 저장.
         // System.out.println("seq => " + seq);
         if(session.getAttribute("cartList") != null) {
            // session에 cartList가 있다면 cartList 참조
            cartList = (List<Product>)session.getAttribute("cartList");
         } else {
            // session에 없다면 새 리스트를 만들어서 session 저장.
            cartList = new ArrayList<Product>();
            session.setAttribute("cartList", cartList);
         }
         
         if(req.getParameter("seq")!=null && req.getParameter("ea")!=null) {
            int seq = Integer.parseInt(req.getParameter("seq"));
            int ea = Integer.parseInt(req.getParameter("ea"));

            Product product = null;
            for(int i=0; i<productList.size(); i++) {
               if(productList.get(i).getSeq() == seq) {
                  product = productList.get(i);
                  break;
               }
            }
            if(product != null) {
               // if(session.getAttribute("cartList") != null) {
               //    cartList = (List<Product>)session.getAttribute("cartList");
               // } else {
               //    cartList = new ArrayList<Product>();
               //    session.setAttribute("cartList", cartList);
               // }
               int index = cartList.indexOf(new Product(seq));
               if(index != -1) {
                  Product curProduct = cartList.get(index);
                  curProduct.setEa(curProduct.getEa() + ea);
               } else {
                  String pName = product.getpName();
                  int price = product.getPrice();
                  Product newProduct = new Product(seq, pName, price, ea);
                  cartList.add(newProduct);
               }
            }
         }
         req.setAttribute("cartList", cartList);
         viewName = "shop/cart_list";
      } else if ("/cart_delete.do".equals(filePath)) {
         // 장바구니에서 상품 삭제
      List<Product> cartList = null;
      if(session.getAttribute("cartList") != null) {
         // session에 cartList가 있다면 cartList 참조
         cartList = (List<Product>)session.getAttribute("cartList");
      } else {
         // session에 없다면 새 리스트를 만들어서 session 저장.
         cartList = new ArrayList<Product>();
         session.setAttribute("cartList", cartList);
      }
         int seq = Integer.parseInt(req.getParameter("seq"));
         int idx = cartList.indexOf(new Product(seq));
         if(idx != -1) {
            cartList.remove(idx);
         }
         // cartList = (List<Product>) session.getAttribute("cartList");
         // if (cartList != null) {
         //    for (int i = 0; i < cartList.size(); i++) {
         //       Product product = cartList.get(i);
         //       if (product.getSeq() == seq) {
         //          cartList.remove(i);
         //          break;
         //       }
         //    }
         // }
         viewName = "redirect:cart_list.do";
      }
      return viewName;
   }
}