package Project.HumanFolder;

//? import đọc + ghi file.txt
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.Scanner;

import Project.IChucNangCoBan;

import java.util.Arrays;

public class QLCustomer implements IChucNangCoBan{
      private static Customer[] customerList = new Customer[100];
      private static int soLuongCustomer;

      public void nhapCustomer() {
            String[] customerArray = null;
            try {
                  BufferedReader input = new BufferedReader(new FileReader("Project/Table.txt"));
                  //? readLine() lần 1 là khách hàng
                  customerArray = input.readLine().split("~");
                  input.close();
            } catch(Exception ex) {
                  ex.printStackTrace();
            }
            for(int i = 0; i < customerArray.length; i++) {
                  customerList = Arrays.copyOf(customerList, soLuongCustomer + 1);
                  String[] customerArrayElement = customerArray[i].split("-");
                  customerList[soLuongCustomer] = new Customer(customerArrayElement[0],customerArrayElement[1],customerArrayElement[2],Integer.parseInt(customerArrayElement[3]),customerArrayElement[4],Integer.parseInt(customerArrayElement[5]));
                  soLuongCustomer++;
            }
      }
      public void ghiCustomer() {
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
                  for(int i = 0; i < soLuongCustomer; i++) {
                        a += customerList[i].getId();
                        a += "-";
                        a += customerList[i].getName();
                        a += "-";
                        a += customerList[i].getPhone();
                        a += "-";
                        a += customerList[i].getBirthyear();
                        a += "-";
                        a += customerList[i].getAddress();
                        a += "-";
                        a += customerList[i].getWallet();
                        a += "~";
                  }
                  content.replace(0,endOfLine[0], a);
                  output.write(content.toString());

                  output.close();
            } catch(Exception ex) {
                  ex.printStackTrace();
            }
      }
      public void them(Scanner sc) {
            customerList = Arrays.copyOf(customerList, soLuongCustomer + 1);
            Customer a;
            int checkID;
            do {
                  checkID = 0;
                  a = new Customer();
                  a.nhap(sc);
                  for(int i = 0; i < soLuongCustomer; i++) {
                        if(a.getId().equalsIgnoreCase(customerList[i].getId())) {
                              checkID = -1;
                              System.out.println("\t*** Id da ton tai ***");
                        }
                  }
            } while(checkID == -1);
            customerList[soLuongCustomer] = new Customer(a);
            System.out.println("\t*** Them Khach Hang thanh cong ***");
            soLuongCustomer++;
            ghiCustomer();
      }
      public void xuat() {
            System.out.println("\n\t\t\t\t     --- Danh Sach Khach Hang ("+soLuongCustomer+" Khach Hang) ---\n");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|  ID   |\tHo va Ten \t\t|     So dien thoai\t|    Nam sinh\t|    Dia chi\t|\t  So du\t\t|");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            for(int i = 0; i < soLuongCustomer; i++) {
                  customerList[i].xuat();
            }
      }
      public Customer timKiemValue(String a) {
            for(int i = 0; i < soLuongCustomer; i++) {
                  if(customerList[i].name.equalsIgnoreCase(a)) 
                        return customerList[i];
            }
            return null;
      }
      public void timKiem(Scanner sc) {
            System.out.println("\n\t--- Tim kiem Khach Hang ---");
            System.out.print("Nhap ma hoac ten Khach Hang can Tim Kiem : ");
            String a = sc.nextLine();
            
            for(int i = 0; i < soLuongCustomer; i++) {
                  if(customerList[i].getId().equalsIgnoreCase(a) || customerList[i].getName().equalsIgnoreCase(a)) {
                        System.out.println("|  ID   |\t Ho va Ten \t\t|     So dien thoai\t|    Nam sinh\t|    Dia chi\t|\t  So du\t\t|");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                        customerList[i].xuat();
                        return;
                  } 
            }
            System.out.println("\n\t*** Khong tim thay Khach Hang : " + a + " ***");
      }
      public void sua(Scanner sc) {
            System.out.println("\n\t--- Sua Khach Hang ---");
            System.out.print("Nhap ma hoac ten Khach Hang Can sua: ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongCustomer; i++) {
                  if(customerList[i].getName().equalsIgnoreCase(a) || customerList[i].getId().equalsIgnoreCase(a)) {
                        if(customerList[i].getName().equalsIgnoreCase(a)) {
                              String tenVietHoa = customerList[i].getName();
                              System.out.println("\t\t\t\t    Khach Hang Can Sua");
                              System.out.println("| ID  | Ho va Ten \t\t|     So dien thoai\t|    Nam sinh\t|    Dia chi\t|\t  So du\t\t|");
                              System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                              customerList[i].xuat();
                              customerList[i].nhap(sc);
                              ghiCustomer();
                              System.out.println("\t*** Sua Thong Tin Khach Hang " + tenVietHoa + " thanh cong ***");
                              return;
                        } else {
                              System.out.println("\t\t\t\t    Khach Hang Can Sua");
                              System.out.println("|  ID   |\tHo va Ten \t\t|     So dien thoai\t|    Nam sinh\t|    Dia chi\t|\t  So du\t\t|");
                              customerList[i].xuat();
                              customerList[i].nhap(sc);
                              ghiCustomer();
                              System.out.println("\t*** Sua Thong Tin Khach Hang " + customerList[i].getId() + " thanh cong ***");
                              return;
                        }
                  }
            }
      }
      public void xoa(Scanner sc) {
            System.out.println("\n\t--- Xoa Khach Hang ---");
            System.out.print("Nhap ma hoac ten Khach Hang Can Xoa : ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongCustomer; i++) {
                  if(customerList[i].getId().equalsIgnoreCase(a) || customerList[i].getName().equalsIgnoreCase(a)) {
                        if(customerList[i].getName().equalsIgnoreCase(a)) {
                              String tenVietHoa = customerList[i].name;
                              System.out.println("\n\t\t\t\t    Khach hang muon xoa");
                              System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                              customerList[i].xuat();
                              System.out.println("Ban co chac muon xoa Khach Hang : " + a);
                              System.out.println("1. Co");
                              System.out.println("2. Khong");
                              System.out.print("Lua chon : ");
                              int confirm = sc.nextInt();
                              sc.nextLine();
                              if(confirm == 1) {
                                    int j ;
                                    for(j = i; j < soLuongCustomer-1; j++){
                                          customerList[j] = customerList[j+1];
                                    }
                                    soLuongCustomer--;
                                    ghiCustomer();
                                    System.out.println("\t*** Da xoa thanh cong Khach Hang " + tenVietHoa + " ***");
                                    return;
                              }
                              System.out.println("\t*** Thoat chuc nang xoa khach hang ***");
                              return;
                        } else {
                              System.out.println("\n\t\t\t\t    Khach hang muon xoa");
                              customerList[i].xuat();
                              System.out.println("Ban co chac muon xoa Khach Hang : " + a);
                              System.out.println("1. Co");
                              System.out.println("2. Khong");
                              System.out.print("Lua chon : ");
                              int confirm = sc.nextInt();
                              sc.nextLine();
                              if(confirm == 1) {
                                    int j ;
                                    for(j = i; j < soLuongCustomer-1; j++){
                                          customerList[j] = customerList[j+1];
                                    }
                                    soLuongCustomer--;
                                    ghiCustomer();
                                    System.out.println("\t*** Da xoa thanh cong Khach Hang " + a + " ***");
                                    return;
                              }
                              System.out.println("\t*** Thoat chuc nang xoa khach hang ***");
                              return;
                        }
                        
                  }
            }
            System.out.println("\n\t*** Khong tim thay Khach Hang : " + a + " ***");
      }
}
