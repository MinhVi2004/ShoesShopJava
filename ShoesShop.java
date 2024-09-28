package Project;

import Project.HumanFolder.QLCustomerMenu;
import Project.HumanFolder.QLWorkerMenu;
import Project.ProductFolder.QLProductMenu;
import Project.BillFolder.QLBillMenu;

import java.util.Scanner;

public class ShoesShop {
      public static void main(String[] args) {
            int minhvi123 = 0;
            Scanner sc = new Scanner(System.in);
            QLCustomerMenu menuCustomer = new QLCustomerMenu();
            QLWorkerMenu menuWorker = new QLWorkerMenu();
            QLProductMenu menuProduct = new QLProductMenu();
            QLBillMenu menuBill = new QLBillMenu();
            
            while(minhvi123 == 0) {
                  System.out.println("\n------------ Quan Ly Ban Hang -----------\n");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 1 | Quan Ly Khach Hang\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 2 | Quan Ly Nhan Vien\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 3 | Quan Ly San Pham\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 4 | Quan Ly Don Hang\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 5 | Thoat \t\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.print("\t===> Lua chon : ");
                  int choice = sc.nextInt();
                  sc.nextLine();
                  switch (choice) {
                        case 1:
                              menuCustomer.customerMenu(sc);
                              break;      
                        case 2:
                              menuWorker.workerMenu(sc);
                              break;
                        case 3:
                              menuProduct.productMenu(sc);
                              break;
                        case 4:
                              menuBill.billMenu(sc);
                              break;
                        case 5:
                              System.out.println("\n\t*** Thoat quan ly ban hang ***");
                              minhvi123 = 1;
                              break;
                        default:
                              System.out.println("\n\t*** Lua chon khong hop le!\n\n\tVui long nhap lai ***");
                              break;
                  }
            }
            sc.close();
      }
}
