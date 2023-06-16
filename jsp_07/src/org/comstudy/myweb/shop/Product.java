package org.comstudy.myweb.shop;

public class Product {
   private int seq;
   private String pName;
   private int price;
   private int ea;
   
   public Product() {
      this(0, "", 0, 0);
   }
   
   public Product(int seq) {
      this(seq, "", 0, 0);
   }
   
   public Product(int seq, String pName, int price, int ea) {
      this.seq = seq;
      this.pName = pName;
      this.price = price;
      this.ea = ea;
   }

   public int getSeq() {
      return seq;
   }

   public void setSeq(int seq) {
      this.seq = seq;
   }

   public String getpName() {
      return pName;
   }

   public void setpName(String pName) {
      this.pName = pName;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getEa() {
      return ea;
   }

   public void setEa(int ea) {
      this.ea = ea;
   }

   @Override
   public String toString() {
      return "Product [seq=" + seq + ", pName=" + pName + ", price=" + price + ", ea=" + ea + "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + seq;
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Product other = (Product) obj;
      if (seq != other.seq)
         return false;
      return true;
   }
}