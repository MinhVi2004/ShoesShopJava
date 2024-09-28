package Project.BillFolder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import Project.HumanFolder.Customer;
import Project.HumanFolder.Worker;
import Project.ProductFolder.Product;
import Project.ProductFolder.Sandal;
import Project.ProductFolder.Sneaker;

public class QLBill {
      private Product[] productList;
      private int soLuongProduct;
      private Customer[] customerList;
      private int soLuongCustomer;
      private Worker[] workerList;
      private int soLuongWorker;
      
      private Bill[] billList;
      private int soLuongBill;

      public Bill[] getBillList() {
            return billList;
      }
      public void setBillList(Bill[] billList) {
            this.billList = billList;
      }
      public int getSoLuongBill() {
            return soLuongBill;
      }
      public void setSoLuongBill(int soLuongBill) {
            this.soLuongBill = soLuongBill;
      }
      public QLBill() {
            productList = new Product[100];
            customerList = new Customer[100];
            workerList = new Worker[100];
            billList = new Bill[100];
            soLuongBill = 0;
            soLuongProduct = soLuongCustomer = soLuongWorker = 0;
      }
      public QLBill(Bill[] a, int b) {
            billList = a;
            soLuongBill = b;
      }
      public void nhapBill() {
            String[] billArray = null;
            String[] productArray = null;
            String[] customerArray = null;
            String[] workerArray = null;
            try {
                  BufferedReader input = new BufferedReader(new FileReader("Project/Table.txt"));
                  //? readLine() lần 1 là khách hàng
                  customerArray = input.readLine().split("~");
                  //? readLine() lần 2 là khách hàng
                  workerArray = input.readLine().split("~");
                  //?readLine() lần 3 là sản phẩm
                  productArray = input.readLine().split("~");
                  //?readLine() lần 4 là đơn hàng
                  billArray = input.readLine().split("~");
                  
                  input.close();
            } catch(Exception ex) {
                  ex.printStackTrace();
            }
            //? Tạo danh sách Customer
            for(int i = 0; i < customerArray.length; i++) {
                  customerList = Arrays.copyOf(customerList, soLuongCustomer + 1);
                  String[] customerArrayElement = customerArray[i].split("-");
                  customerList[soLuongCustomer] = new Customer(customerArrayElement[0],customerArrayElement[1],customerArrayElement[2],Integer.parseInt(customerArrayElement[3]),customerArrayElement[4],Integer.parseInt(customerArrayElement[5]));
                  soLuongCustomer++;
            }
            //? Tạo danh sách Worker
            for(int i = 0; i < workerArray.length; i++) {
                  workerList = Arrays.copyOf(workerList, soLuongWorker + 1);
                  String[] workerArrayElement = workerArray[i].split("-");
                  workerList[soLuongWorker] = new Worker(workerArrayElement[0],workerArrayElement[1],workerArrayElement[2],Integer.parseInt(workerArrayElement[3]),workerArrayElement[4],Integer.parseInt(workerArrayElement[5]));
                  soLuongWorker++;
            }     
            //? Tạo danh sách Product
            for(int i = 0; i < productArray.length; i++) {
                  productList = Arrays.copyOf(productList, soLuongProduct + 1);

                  String[] productArrayElement = productArray[i].split("-");
                  if(productArrayElement[1].equalsIgnoreCase("Sandal")) {
                        productList[soLuongProduct] = new Sandal(productArrayElement[0],productArrayElement[3],Integer.parseInt(productArrayElement[4]),Integer.parseInt(productArrayElement[5]), productArrayElement[2]);
                  } else if (productArrayElement[1].equalsIgnoreCase("Sneaker")){
                        productList[soLuongProduct] = new Sneaker(productArrayElement[0],productArrayElement[3],Integer.parseInt(productArrayElement[4]),Integer.parseInt(productArrayElement[5]), productArrayElement[2]);
                  } else {
                        System.out.println("Sai dinh dang file khi doc Product");
                        return;
                  }

                  soLuongProduct++;
            }  
            //? Tạo danh sách Bill
            for(int i = 0; i < billArray.length; i++) {
                  billList = Arrays.copyOf(billList, soLuongBill + 1);
                  //? Tách từng bill ra bằng " - "
                  String[] billArrayElement = billArray[i].split("-"); 

                  //?Tạo phần tử bill với 3 giá trị 
                  billList[soLuongBill] = new Bill(billArrayElement[0], billArrayElement[1], billArrayElement[2], 0, null);

                  String[] billArrayProduct = billArrayElement[3].split("#");
                  //? Set số lượng billDetail
                  billList[soLuongBill].setSoLuongBillDetail(billArrayProduct.length);

                  //? Set mảng billDetail
                  BillDetail[] a = new BillDetail[billArrayProduct.length];
                  for(int j = 0; j < billArrayProduct.length; j++) {
                        String[] billArrayProductElement = billArrayProduct[j].split("@");
                        BillDetail b = new BillDetail();
                        b.setProductBillDetail(timKiemProductValue(billArrayProductElement[0]));
                        b.setQuantityProduct(Integer.parseInt(billArrayProductElement[1]));
                        a[j] = b;
                  }
                  billList[soLuongBill].setBillDetailList(a);
                  soLuongBill++;
            }
      }
      public void ghiBill() {
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
                  for(int i = 0; i < soLuongBill; i++) {
                        a += billList[i].getBillId();
                        a += "-";
                        a += billList[i].getCustomerName();
                        a += "-";
                        a += billList[i].getWorkerName();
                        a += "-";
                        for(int j = 0; j < billList[i].getSoLuongBillDetail(); j++) {
                              a += billList[i].getBillDetailList()[j].getProductBillDetail().getName();
                              a += "@";
                              a += billList[i].getBillDetailList()[j].getQuantityProduct();
                              a += "#";
                        }
                        a += "~";
                  }
                  content.replace(endOfLine[0] + endOfLine[1] + 2 + endOfLine[2] + 1,endOfLine[0] + endOfLine[1] + 2 + endOfLine[2] + 1 + endOfLine[3], a);
                  output.write(content.toString());

                  output.close();
            } catch(Exception ex) {
                  ex.printStackTrace();
            }
      }
      public Product timKiemProductValue(String a) {
            for(int i = 0; i < productList.length; i++) {
                  if(productList[i] != null && productList[i].getName().equalsIgnoreCase(a) == true) {
                        return productList[i];
                  }
            }
            return null;
      }
      public void themBill(Scanner sc) {
            billList = Arrays.copyOf(billList, soLuongBill + 1);
            Bill a;
            int checkCustomer,checkWorker, checkId;
            do {
                  checkCustomer = checkWorker = checkId = 0;
                  a = new Bill();
                  a.nhap(sc);
                  for(int i = 0; i < soLuongCustomer; i++) {
                        if(customerList[i].getName().equalsIgnoreCase(a.getCustomerName())) {
                              checkCustomer = 1;
                              break;
                        }
                  }
                  if(checkCustomer == 0) {
                        System.out.println("\t*** Khong ton tai khach hang " + a.getCustomerName() + " ***");
                  }
                  for(int i = 0; i < soLuongWorker; i++) {
                        if(workerList[i].getName().equalsIgnoreCase(a.getWorkerName()) == false) {
                              checkWorker = 1;
                              break;
                        }
                  }
                  if(checkWorker == 0) {
                        System.out.println("\t*** Khong ton tai nhan vien " + a.getCustomerName() + " ***");
                  }
                  for(int i = 0; i < soLuongBill; i++) {
                        if(a.getBillId().equalsIgnoreCase(billList[i].getBillId())) {
                              checkId = -1;
                              System.out.println("\t*** Id da ton tai ***");
                        }
                  }
            }while(checkCustomer == 0 || checkWorker == 0 || checkId == -1);
            billList[soLuongBill] = a;
            System.out.println("\t*** Them don hang " + billList[soLuongBill].getBillId() + " thanh cong ***");
            soLuongBill++;
            ghiBill();
      }
      public void xuatBill() {
            System.out.println("\t--- Danh sach co "+ soLuongBill+" don hang ---");
            for(int i = 0; i < soLuongBill; i++) {
                  System.out.print("\t\t Don hang " + (i+1) + "\n");
                  billList[i].xuatBill();
                  System.out.println("\n");
            }
      }
      public void xuatBillDetail(Scanner sc) {
            // System.out.print("\tNhap ma don hang hoac ten khach hang : ");
            // String a = sc.nextLine();
            // int checkExist = 0;
            // for(int i = 0; i < soLuongBill; i++) {
            //       if(billList[i].getBillId().equalsIgnoreCase(a) || billList[i].getCustomerName().equalsIgnoreCase(a)) {
            //             billList[i].xuatBillDetail();
            //             checkExist = 1;
            //       }
            // }
            // if(checkExist == 0) {
            //       System.out.println("\t*** Khong tim thay don hang co ma " + a + " ***");
            // }
            System.out.println("\t\t --------- Danh Sach Chi Tiet Don Hang ---------");
            for(int i = 0; i < soLuongBill; i++) {
                  System.out.print("\t\t Don hang " + (i+1) + "\n");
                  billList[i].xuatBillDetail();
                  System.out.println("\n");
            }
      }
      public void timKiem(Scanner sc) {
            System.out.print("Nhap ma don hang hoac ten khach hang mua hang : ");
            String a = sc.nextLine();
            int checkExist = 0;
            for(int i = 0; i < soLuongBill; i++) {
                  if(billList[i].getBillId().equalsIgnoreCase(a) || billList[i].getCustomerName().equalsIgnoreCase(a)) {
                        billList[i].xuatBillDetail();
                        checkExist = 1;
                  }
            }
            if(checkExist == 0) {
                  System.out.println("\t*** Khong tim thay don hang co ma " + a + " ***");
            }
      } 
      public void sua(Scanner sc) {
            System.out.print("Nhap ma don hang hoac ten khach hang mua hang can sua : "); 
            String a = sc.nextLine();
            for(int i = 0; i < soLuongBill; i++) {
                  if(billList[i].getBillId().equalsIgnoreCase(a) || billList[i].getCustomerName().equalsIgnoreCase(a)) {
                        if(billList[i].getBillId().equalsIgnoreCase(a) == true) {
                              System.out.println("\t--- Don hang muon sua --- ");
                              billList[i].xuatBillDetail();
                              System.out.println("\t--- Sua thong tin don hang " + a + " ---");
                              Bill b = new Bill();
                              b.nhap(sc);
                              billList[i] = b;
                              System.out.println("\t*** Sua thanh cong ***");
                              ghiBill();
                              return;
                        } else {
                              System.out.println("\t--- Don hang muon sua --- ");
                              billList[i].xuatBillDetail();
                              System.out.println("\t--- Sua thong tin don hang cua khach hang " + a + " ---");
                              Bill b = new Bill();
                              b.nhap(sc);
                              billList[i] = b;
                              System.out.println("\t*** Sua thanh cong ***");
                              ghiBill();
                              return;
                        }
                  }
            }
            System.out.println("\t*** Khong tim thay don hang " + a + " ***");
      }
      public void xoa(Scanner sc) {
            System.out.print("\t--- Nhap ma don hang hoac ten khach hang mua hang can xoa : ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongBill; i++) {
                  if(billList[i].getBillId().equalsIgnoreCase(a) || billList[i].getCustomerName().equalsIgnoreCase(a)) {
                        System.out.println("\t--- Don hang muon xoa ---");
                        billList[i].xuatBillDetail();
                        System.out.println("Ban co chac muon xoa ma don hang : " + a +" ?\n1. Co\n2. Khong\n");
                        System.out.print("Lua chon : ");
                        int confirm = sc.nextInt();
                        sc.nextLine();
                        if(confirm == 1) {
                              for(int j = i; j < soLuongBill-1; j++){
                                    billList[j] = billList[j+1];
                              }
                              soLuongBill--;
                              ghiBill();
                              System.out.println("\t*** Da xoa thanh cong ma don hang " + a + " ***");
                              return;
                        }
                        System.out.println("\t*** Thoat chuc nang xoa don hang ***");
                        return;
                  }
            }
      }
}
