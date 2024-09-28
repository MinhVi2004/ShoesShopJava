package Project.BillFolder;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Bill {
      protected String billId;
      protected String customerName;
      protected String workerName;
      protected int soLuongBillDetail;
      protected BillDetail[] billDetailList;

      public String getBillId() {
            return billId;
      }
      public void setBillId(String billId) {
            this.billId = billId;
      }
      public String getCustomerName() {
            return customerName;
      }
      public void setCustomerName(String customerName) {
            this.customerName = customerName;
      }
      public String getWorkerName() {
            return workerName;
      }
      public void setWorkerName(String workerName) {
            this.workerName = workerName;
      }
      public int getSoLuongBillDetail() {
            return soLuongBillDetail;
      }
      public void setSoLuongBillDetail(int soLuongBillDetail) {
            this.soLuongBillDetail = soLuongBillDetail;
      }
      public BillDetail[] getBillDetailList() {
            return billDetailList;
      }
      public void setBillDetailList(BillDetail[] billDetailList) {
            this.billDetailList = billDetailList;
      }
      public Bill() {
            billId = customerName = workerName = "";
            soLuongBillDetail = 0;
            billDetailList = new BillDetail[100];
      }
      public Bill(String a, String b, String c, int d, BillDetail[] e) {
            billId = a;
            customerName = b;
            workerName = c;
            soLuongBillDetail = d;
            billDetailList = e;
      }
      public Bill(Bill a) {
            billId = a.billId;
            customerName = a.customerName;
            workerName = a.workerName;
            soLuongBillDetail = a.soLuongBillDetail;
            billDetailList = a.billDetailList;
      }

      public void nhap(Scanner sc) {
            System.out.print("Nhap ma don hang : ");
            billId = sc.nextLine();
            System.out.print("Nhap ten khach hang: ");
            customerName = sc.nextLine();
            //? Biến chữ cái đầu thành chữ hoa
            char[] customerNameArray = customerName.toCharArray();
            boolean foundSpace = true;
            //sử dụng vòng lặp for để duyệt các phần tử trong charArray
            for(int i = 0; i < customerNameArray.length; i++) {
                  // nếu phần tử trong mảng là một chữ cái
                  if(Character.isLetter(customerNameArray[i])) {
                  // kiểm tra khoảng trắng có trước chữ cái
                        if(foundSpace) {
                              //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
                              customerNameArray[i] = Character.toUpperCase(customerNameArray[i]);
                              foundSpace = false;
                        }
                  }
                  else {
                        foundSpace = true;
                  }
            }
            // chuyển đổi mảng char[] thành string
            customerName = String.valueOf(customerNameArray);

            System.out.print("Nhap ten nhan vien : ");
            workerName = sc.nextLine(); 
            //? Biến chữ cái đầu thành chữ hoa
            char[] workerNameArray = workerName.toCharArray();
            boolean foundSpace1 = true;
            //sử dụng vòng lặp for để duyệt các phần tử trong charArray
            for(int i = 0; i < workerNameArray.length; i++) {
                  // nếu phần tử trong mảng là một chữ cái
                  if(Character.isLetter(workerNameArray[i])) {
                  // kiểm tra khoảng trắng có trước chữ cái
                        if(foundSpace1) {
                              //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
                              workerNameArray[i] = Character.toUpperCase(workerNameArray[i]);
                              foundSpace1 = false;
                        }
                  }
                  else {
                        foundSpace1 = true;
                  }
            }
            // chuyển đổi mảng char[] thành string
            workerName = String.valueOf(workerNameArray);

            int mvi123 = 1;
            while(mvi123 == 1) {
                  System.out.println("\t--- Nhap san pham ---");
                  themBillDetail(sc);
                  System.out.print("\t--- Ban co muon nhap tiep ? ---\n1. Co\n2. Khong\nLua chon : ");
                  mvi123 = sc.nextInt();
                  sc.nextLine();
                  switch (mvi123) {
                        case 1:
                              
                              break;
                        case 2:
                              mvi123 = 2;
                              break;
                        default:
                              System.out.println("\t*** Lua chon khong hop le ***");
                              mvi123 = 2;
                              break;
                  }
            }
      }
      public void themBillDetail(Scanner sc) {
            BillDetail a = new BillDetail();
            billDetailList = Arrays.copyOf(billDetailList, soLuongBillDetail + 1);
            a.nhapProduct(sc);
            a.nhapBillDetail(sc);
            billDetailList[soLuongBillDetail] = a;
            soLuongBillDetail++;
      }
      public void xuatBill() {
            System.out.println(" _______________________________________________");
            System.out.println("| Ma don hang :\t\t" + billId + "\t\t\t|");
            if(customerName.length() < 16) {
                  System.out.println("| Khach hang :\t\t" + customerName + "\t\t|");
            } else{
                  System.out.println("| Khach hang :\t\t" + customerName + "\t|");
            }
            if(workerName.length() < 16) {
                  System.out.println("| Nhan Vien :\t\t" + workerName + "\t\t|");
            } else{
                  System.out.println("| Nhan Vien :\t\t" + workerName + "\t|");
            }
            System.out.println("| Gia tri don hang :\t" + currence(totalBill()) + "\t\t|");
            System.out.println("|_______________________________________________|");
      }
      public void xuatBillDetail() {
            System.out.println("________________________________________________");
            System.out.println("| Ma don hang :\t\t" + billId + "\t\t\t|");
            if(customerName.length() < 16) {
                  System.out.println("| Khach hang :\t\t" + customerName + "\t\t|");
            } else{
                  System.out.println("| Khach hang :\t\t" + customerName + "\t|");
            }
            if(workerName.length() < 16) {
                  System.out.println("| Nhan Vien :\t\t" + workerName + "\t\t|");
            } else{
                  System.out.println("| Nhan Vien :\t\t" + workerName + "\t|");
            }
            System.out.println("| \t--- Don hang co "+ totalProduct() +" san pham ---\t\t|");
            for(int i = 0; i < soLuongBillDetail; i++) {
                  System.out.println("| San pham " + (i+1) + "\t\t\t\t\t|");
                  billDetailList[i].xuatBillDetail();
            }
            if(currence(totalBill()).length() < 14) {
                  System.out.println("| ===> Gia tri don hang : " + currence(totalBill()) + "\t\t|");
            } else {
                  System.out.println("| ===> Gia tri don hang : " + currence(totalBill()) + "\t|");
            }
            System.out.println("|_______________________________________________|");
      }
      public int totalBill() {
            int sum = 0;
            for(int i = 0; i < soLuongBillDetail; i++) {
                  sum += billDetailList[i].totalBillDetail();
            }
            return sum;
      }
      public int totalProduct() {
            int sum = 0;
            for(int i = 0; i < soLuongBillDetail; i++) {
                  sum += billDetailList[i].getQuantityProduct();
            }
            return sum;
      }
      public String currence(int a) {
            DecimalFormat dinhDangVND = new DecimalFormat("#,### VND");
            return dinhDangVND.format(a);
      }
}
