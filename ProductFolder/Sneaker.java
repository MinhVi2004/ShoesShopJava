package Project.ProductFolder;

import java.util.Scanner;

public class Sneaker extends Product{
      
      private String bluchersSneaker;

      public String getBluchersSneaker() {
            return bluchersSneaker;
      }
      public void setBluchersSneaker(String bluchersSneaker) {
            this.bluchersSneaker = bluchersSneaker;
      }
      public Sneaker() {
            super();
            bluchersSneaker = "";

      }
      public Sneaker(String a, String b, int c, int d, String e) {
            super(a, b, c, d);
            bluchersSneaker = e;
      }
      public Sneaker(Sneaker a) {
            super(a);
            bluchersSneaker = a.bluchersSneaker;
      }
      @Override
      public void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.println("\t--- Nhap loai giay sneaker ---");
            System.out.print("1. Co Thap\n2. Co Cao\nLua chon : ");
            int choice1 = sc.nextInt();
            sc.nextLine();
            switch (choice1) {
                  case 1:
                        bluchersSneaker = "Co Thap";
                        break;
                  case 2:
                        bluchersSneaker = "Co Cao";
                        break;
            
                  default:
                        System.out.println("\t*** Lua chon khong hop le ! ***");
                        break;
            }
      }
      @Override
      public void xuat() {
            super.xuat();
            System.out.println( bluchersSneaker + "\t|" + "    Sneaker\t|");
            System.out.println("-------------------------------------------------------------------------------------------------");
      }     
}
