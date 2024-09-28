package Project.BillFolder;

import java.util.Scanner;

public class QLBillMenu {
      private QLBill BillList = new QLBill();

      public QLBillMenu() {
            BillList.nhapBill();
      }
      public void billMenu(Scanner sc) {
            int checkOut = 0;
            while(checkOut == 0) {
                  System.out.println("\n----------- Quan ly Don Hang -----------\n");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 1 | Them Don Hang\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 2 | Hien thi danh sach Don Hang\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 3 | Tim kiem Don Hang\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 4 | Sua thong tin Don Hang\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 5 | Xoa Don Hang\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 6 | Thoat Qua Ly Don Hang\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.print("\t===> Lua chon : ");
                  int choice1 = sc.nextInt();
                  sc.nextLine();
                  switch (choice1) {
                        case 1:
                              BillList.themBill(sc);;
                              break;
                        case 2: 
                        //! -------------------------- hiển thị sản phẩm --------------------------
                              BillList.xuatBill();
                              System.out.println("\t--- Ban co muon xem chi tiet san pham ? ---\n1. Xem tat ca\n2. Chon Don Hang\n3. Khong");
                              System.out.print("Lua chon : ");
                              int choice2 = sc.nextInt();
                              sc.nextLine();
                              switch (choice2) {
                                    case 1:
                                          BillList.xuatBillDetail(sc);
                                          break;
                                    case 2:
                                          BillList.timKiem(sc);
                                          break;
                                    case 3:
                                          System.out.println("\t*** Thoat xem chi tiet san pham ***");
                                          break;
                                    default:
                                          System.out.println("\t*** Lua chon khong hop le ***");
                                          break;
                              }
                              break;
                        //! -------------------------- hiển thị sản phẩm --------------------------
                        case 3:
                              BillList.timKiem(sc);
                              break;
                        case 4:
                              BillList.sua(sc);
                              break;
                        case 5:
                              BillList.xoa(sc);
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
