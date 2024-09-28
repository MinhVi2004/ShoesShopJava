package Project.HumanFolder;

import java.util.Scanner;

public class QLWorkerMenu {
      private QLWorker WorkerList = new QLWorker();
      public QLWorkerMenu(){
            WorkerList.nhapWorker();
      }
      public void workerMenu(Scanner sc) {
            int checkOut = 0;
            while(checkOut == 0) {
                  System.out.println("\n----------- Quan ly Nhan Vien ----------\n");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 1 | Them Nhan Vien\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 2 | Hien thi danh sach Nhan Vien\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 3 | Tim kiem Nhan Vien\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 4 | Sua thong tin Nhan Vien\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 5 | Xoa Nhan Vien\t\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.println("| 6 | Thoat Quan Ly Nhan Vien\t\t|");
                  System.out.println("-----------------------------------------");
                  System.out.print("\t===> Lua chon : ");
                  int choice2 = sc.nextInt();
                  sc.nextLine();
                  switch (choice2) {
                        case 1:
                              WorkerList.them(sc);
                              break;
                        
                        case 2:
                              WorkerList.xuat();
                              break;

                        case 3:
                              WorkerList.timKiem(sc);
                              break;

                        case 4:
                              WorkerList.sua(sc);
                              break;

                        case 5:
                              WorkerList.xoa(sc);
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
