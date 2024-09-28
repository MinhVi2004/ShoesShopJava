package Project.ProductFolder;

import java.util.Scanner;

public class Sandal extends Product{
      private String ropeSandal;

      public String getRopeSandal() {
            return ropeSandal;
      }
      public void setRopeSandal(String ropeSandal) {
            this.ropeSandal = ropeSandal;
      }
      public Sandal() {
            super();
            ropeSandal = "";

      }
      public Sandal(String a, String b, int c, int d, String e) {
            super(a, b, c, d);
            ropeSandal = e;
      }
      public Sandal(Sandal a) {
            super(a);
            ropeSandal = a.ropeSandal;
      }
      @Override
      public void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.println("\t--- Nhap loai day quai ---");
            System.out.print("1. Day Vai\n2. Day Cao Su\n3. Day Da\nLua chon : ");
            int choice1 = sc.nextInt();
            sc.nextLine();
            switch (choice1) {
                  case 1:
                        ropeSandal = "Day Vai";
                        break;
                  case 2:
                        ropeSandal = "Day Cao Su";
                        break;
                  case 3:
                        ropeSandal = "Day Da";
                        break;
            
                  default:
                        System.out.println("\t*** Lua chon khong hop le ! ***");
                        break;
            }
      }
      @Override
      public void xuat() {
            super.xuat();
            System.out.println(ropeSandal + "\t|" + "    Sandal\t|");
            System.out.println("-------------------------------------------------------------------------------------------------");
      }     
}
