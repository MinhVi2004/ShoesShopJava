package Project.HumanFolder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import Project.IChucNangCoBan;

import java.util.Arrays;

public class QLWorker implements IChucNangCoBan{
      private static Worker[] workerList = new Worker[100];
      private static int soLuongWorker;

      public void nhapWorker() {
            String[] workerArray = null;
            try {
                  BufferedReader input = new BufferedReader(new FileReader("Project/Table.txt"));
                  input.readLine().split("~");
                  //? readLine() lần 2 là nhân viên
                  workerArray = input.readLine().split("~");
                  /* System.out.println("\t--- Nhan vien ---");
                  for(int i = 0;i < workerArray.length; i++) {
                        System.out.println(workerArray[i]);
                  } */
                  
                  input.close();
            } catch(Exception ex) {
                  ex.printStackTrace();
            }
            for(int i = 0; i < workerArray.length; i++) {
                  workerList = Arrays.copyOf(workerList, soLuongWorker + 1);
                  String[] workerArrayElement = workerArray[i].split("-");
                  workerList[soLuongWorker] = new Worker(workerArrayElement[0],workerArrayElement[1],workerArrayElement[2],Integer.parseInt(workerArrayElement[3]),workerArrayElement[4],Integer.parseInt(workerArrayElement[5]));
                  soLuongWorker++;
            }     
      }
      public void ghiWorker() {
            try {
                  BufferedReader input = new BufferedReader(new FileReader("Project/Table.txt"));
                  String line;
                  int[] endOfLine = new int[10];
                  int dem = 0;
                  StringBuilder content = new StringBuilder();
                  while ((line = input.readLine()) != null) {
                        content.append(line);
                        content.append("\n");
                        endOfLine[dem] = line.length();
                        dem++;
                  }
                  input.close();

                  BufferedWriter output = new BufferedWriter(new FileWriter("Project/Table.txt"));
                  String a = "";
                  for(int i = 0; i < soLuongWorker; i++) {
                        a += workerList[i].getId();
                        a += "-";
                        a += workerList[i].getName();
                        a += "-";
                        a += workerList[i].getPhone();
                        a += "-";
                        a += workerList[i].getBirthyear();
                        a += "-";
                        a += workerList[i].getAddress();
                        a += "-";
                        a += workerList[i].getSalary();
                        a += "~";
                  }
                  //? vị trí các điểm đầu dòng và cuối dòng 
                  content.replace(endOfLine[0] + 1 ,endOfLine[0] + endOfLine[1] + 2, a);
                  output.write(content.toString());

                  output.close();
            } catch(Exception ex) {
                  ex.printStackTrace();
            }
      }
      public void them(Scanner sc) {
            workerList = Arrays.copyOf(workerList, soLuongWorker + 1);
            Worker a;
            int checkID;
            do {
                  checkID = 0;
                  a = new Worker();
                  a.nhap(sc);
                  for(int i = 0; i < soLuongWorker; i++) {
                        if(a.getId().equalsIgnoreCase(workerList[i].getId())) {
                              checkID = -1;
                              System.out.println("\t*** Id da ton tai ***");
                        }
                  }
            } while(checkID == -1);
            workerList[soLuongWorker] = new Worker(a);
            System.out.println("\t*** Them Nhan Vien thanh cong ***");
            soLuongWorker++;
            ghiWorker();
            
      }
      public void xuat() {
            System.out.println("\n\t\t\t\t     --- Danh Sach Nhan vien ("+soLuongWorker+" Nhan vien) ---\n");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|  ID   | \tHo va Ten \t\t|     So dien thoai\t|    Nam sinh\t|    Dia chi\t|\t  Luong\t\t|");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            for(int i = 0; i < soLuongWorker; i++) {
                  workerList[i].xuat();
            }
      }
      public Worker timKiemValue(String a) {
            for(int i = 0; i < soLuongWorker; i++) {
                  if(workerList[i].name.equalsIgnoreCase(a)) 
                        return workerList[i];
            }
            return null;
      }
      public void timKiem(Scanner sc) {
            System.out.println("\n\t--- Tim kiem Nhan Vien ---");
            System.out.print("Nhap ma hoac ten Nhan Vien can Tim Kiem : ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongWorker; i++) {
                  if(workerList[i].getId().equalsIgnoreCase(a) || workerList[i].getName().equalsIgnoreCase(a)) {
                        System.out.println("|  ID   |\t Ho va Ten \t\t|     So dien thoai\t|    Nam sinh\t|    Dia chi\t|\t  Luong\t\t|");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                        workerList[i].xuat();
                        return;
                  } 
            }
            System.out.println("\n\t*** Khong tim thay Khach Hang : " + a + " ***");
      }
      public void sua(Scanner sc) {
            System.out.println("\n\t--- Sua Nhan Vien ---");
            System.out.print("Nhap ma hoac ten Nhan Vien Can sua: ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongWorker; i++) {
                  if(workerList[i].getName().equalsIgnoreCase(a) || workerList[i].getId().equalsIgnoreCase(a)) {
                        if(workerList[i].getName().equalsIgnoreCase(a)) {
                              String tenVietHoa = workerList[i].getName();
                              System.out.println("\t\t\t\t    Nhan Vien Can Sua");
                              System.out.println("|  ID   | \tHo va Ten \t\t|     So dien thoai\t|    Nam sinh\t|    Dia chi\t|\t  Luong\t\t|");
                              workerList[i].xuat();
                              workerList[i].nhap(sc);
                              ghiWorker();
                              System.out.println("\t*** Sua Thong Tin Nhan Vien " + tenVietHoa + " thanh cong ***");
                              return;
                        } else {
                              System.out.println("\t\t\t\t    Nhan Vien Can Sua");
                              System.out.println("| ID  | Ho va Ten \t\t|     So dien thoai\t|    Nam sinh\t|    Dia chi\t|\t  Luong\t\t|");
                              workerList[i].xuat();
                              workerList[i].nhap(sc);
                              ghiWorker();
                              System.out.println("\t*** Sua Thong Tin Nhan Vien " + workerList[i].getId() + " thanh cong ***");
                              return;
                        }
                  }
            }
      }
      public void xoa(Scanner sc) {
            System.out.println("\n\t--- Xoa Nhan Vien ---");
            System.out.print("Nhap ma hoac ten Nhan Vien can Xoa : ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongWorker; i++) {
                  if(workerList[i].getId().equalsIgnoreCase(a) || workerList[i].getName().equalsIgnoreCase(a)) {
                        if(workerList[i].getName().equalsIgnoreCase(a)) {
                              String tenVietHoa = workerList[i].name;
                              System.out.println("\n\t\t\t\t    Nhan Vien muon xoa");
                              System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                              workerList[i].xuat();
                              System.out.println("Ban co chac muon xoa Nhan Vien : " + a);
                              System.out.println("1. Co");
                              System.out.println("2. Khong");
                              System.out.print("Lua chon : ");
                              int confirm = sc.nextInt();
                              sc.nextLine();
                              if(confirm == 1) {
                                    int j ;
                                    for(j = i; j < soLuongWorker-1; j++){
                                          workerList[j] = workerList[j+1];
                                    }
                                    soLuongWorker--;
                                    ghiWorker();
                                    System.out.println("\t*** Da xoa thanh cong Nhan Vien " + tenVietHoa + " ***");
                                    return;
                              }
                              System.out.println("\t*** Thoat chuc nang xoa nhan vien");
                              return;
                        } else {
                              System.out.println("\n\t\t\t\t    Nhan Vien muon xoa");
                              workerList[i].xuat();
                              System.out.println("Ban co chac muon xoa Nhan Vien : " + a);
                              System.out.println("1. Co");
                              System.out.println("2. Khong");
                              System.out.print("Lua chon : ");
                              int confirm = sc.nextInt();
                              sc.nextLine();
                              if(confirm == 1) {
                                    int j ;
                                    for(j = i; j < soLuongWorker-1; j++){
                                          workerList[j] = workerList[j+1];
                                    }
                                    soLuongWorker--;
                                    ghiWorker();
                                    System.out.println("\t*** Da xoa thanh cong Nhan Vien " + a + " ***");
                                    return;
                              }                              
                              System.out.println("\t*** Thoat chuc nang xoa nhan vien");
                              return;
                        }
                        
                  }
            }
            System.out.println("\n\t*** Khong tim thay Nhan Vien : " + a + " ***");
      }
}
