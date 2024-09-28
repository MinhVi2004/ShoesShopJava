package Project.HumanFolder;

import java.util.Scanner;

public class QLCustomerMenu {
      private QLCustomer CustomerList = new QLCustomer();
      public QLCustomerMenu(){
            CustomerList.nhapCustomer();
      }
      public void customerMenu(Scanner sc) {
            int checkOut = 0;
            while(checkOut == 0) {
                  System.out.println("\n----------- Quan ly Khach Hang ----------\n");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 1 | Them Khach Hang\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 2 | Hien thi danh sach Khach Hang\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 3 | Tim kiem Khach Hang\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 4 | Sua thong tin Khach Hang\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 5 | Xoa Khach Hang\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 6 | Thoat Quan Ly Khach Hang\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.print("\t===> Lua chon : ");
                  int choice1 = sc.nextInt();
                  sc.nextLine();
                  switch (choice1) {
                        case 1:
                              CustomerList.them(sc);
                              break;
                        case 2:
                              CustomerList.xuat();
                              break;
                        case 3:
                              CustomerList.timKiem(sc);
                              break;
                        case 4:
                              CustomerList.sua(sc);
                              break;
                        case 5:
                              CustomerList.xoa(sc);
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
      