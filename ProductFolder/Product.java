package Project.ProductFolder;

import java.text.DecimalFormat;
import java.util.Scanner;
import Project.INhapXuat;

public class Product implements INhapXuat{
      protected String id;
      protected String name;
      protected int price;
      protected int size;

      public String getId() {
            return id;
      }
      public void setId(String id) {
            this.id = id;
      }
      public String getName() {
            return name;
      }
      public void setName(String name) {
            this.name = name;
      }
      public int getPrice() {
            return price;
      }
      public void setPrice(int price) {
            this.price = price;
      }
      public int getSize() {
            return size;
      }
      public void setSize(int size) {
            this.size = size;
      }
      public Product() {
            id = name = "";
            price = size = 0;
      }
      public Product(String a, String b, int c, int d) {
            id = a;
            name = b;
            price = c;
            size = d;
      }
      public Product(Product a) {
            id = a.id;
            name = a.name;
            price = a.price;
            size = a.size;
      }

      public String currence(int a) {
            DecimalFormat dinhDangVND = new DecimalFormat("#,### VND");
            return dinhDangVND.format(a);
      }
      @Override
      public void nhap(Scanner sc) {
            System.out.print("Nhap id san pham : ");
            id = sc.nextLine();
            System.out.print("Nhap ten san pham : ");
            name = sc.nextLine();
            int checkPrice = 0;
            do {
                  System.out.print("Nhap gia san pham : ");
                  price = sc.nextInt();
                  sc.nextLine();
                  if(price <= 0) {
                        checkPrice = -1;
                        System.out.println("\t*** Gia san pham khong hop le ***");
                  }
            } while(checkPrice == -1);

            int checkSize = 0;
            do {
                  System.out.print("Nhap size : ");
                  size = sc.nextInt();
                  if(size < 30 || size > 50) {
                        checkSize = -1;
                        System.out.println("\t*** Size giay khong phu hop ***");
                  }
            } while(checkSize == -1);
      }
      @Override
      public void xuat() {
            // System.out.println("Product - Id : " + id);
            // System.out.println("Product - Name : " + name);
            // System.out.println("Product - Price : " + currence(price));
            // System.out.println("Product - Size : " + size);
            if(name.length() > 15) {
                  System.out.print("| " + id + " |\t" + name + "\t| " + currence(price) + "\t|  " + size + "\t|    ");
            } else {
                  System.out.print("| " + id + " |\t" + name + "\t\t| " + currence(price) + "\t|  " + size + "\t|    ");
            }
      }
}
