package Project.ProductFolder;

import java.util.Scanner;


public class QLProductMenu {
      private QLProduct ProductList = new QLProduct();
      public QLProductMenu(){
            ProductList.nhapProduct();
      }
      public void productMenu(Scanner sc) {
            int checkOut = 0;
            while(checkOut == 0) {
                  System.out.println("\n------------ Quan ly San Pham -----------\n");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 1 | Them San Pham\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 2 | Hien thi danh sach San Pham\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 3 | Tim kiem San Pham\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 4 | Sua thong tin San Pham\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 5 | Xoa San Pham\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 6 | Thoat Quan Ly San Pham\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.print("\t===> Lua chon : ");
                  int choice3 = sc.nextInt();
                  sc.nextLine();
                  switch (choice3) {
                        case 1:
                              ProductList.them(sc);
                              break;

                        case 2:
                              ProductList.xuat();
                              break;

                        case 3:
                              ProductList.timKiem(sc);
                              break;
                        case 4:
                              ProductList.sua(sc);
                              break;

                        case 5:
                              ProductList.xoa(sc);
                              break;

                        case 6:
                              checkOut = 1;
                              break;
                  
                        default:
                              System.out.println("\n\t*** Lua chon khong hop le ! ***");
                              break;
                  }
            }
      }
}
