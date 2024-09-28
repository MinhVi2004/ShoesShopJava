package Project.HumanFolder;

import java.text.DecimalFormat;
import java.util.*;

public class Customer extends Human{
      private int wallet;

      public void setWallet(int wallet) {
            this.wallet = wallet;
      }
      public int getWallet() {
            return wallet;
      }
      public Customer() {
            super();
            wallet = 0;
      }
      public Customer(String a, String b, String c, int d, String e, int f) {
            super(a,b,c,d,e);
            wallet = f;
      }
      public Customer(Customer a) {
            super(a);
            wallet = a.wallet;
      }
      public String currence(int a) {
            DecimalFormat dinhDangVND = new DecimalFormat("#,### VND");
            return dinhDangVND.format(a);
      }
      @Override
      public void nhap(Scanner sc) {
            super.nhap(sc);
            int checkWallet;
            do {
                  checkWallet = 0;
                  System.out.print("Nhap so du vi : ");
                  wallet = sc.nextInt();
                  sc.nextLine();
                  if(wallet <= 0) {
                        checkWallet = -1;
                        System.out.println("\t*** So du khong hop le ! ***");
                  }
            } while(checkWallet == -1);
      }
      @Override
      public void xuat() {
            
            // System.out.println("--- Khach hang --- ");
            // System.out.println("\tId : " + id);
            // System.out.println("\tName : " + name);
            // System.out.println("\tPhone : " + phone);
            // System.out.println("\tAge : " + birthyear);
            // System.out.println("\tAddress : " + address);
            // System.out.println("\tCustomer - So du : " + currence(wallet));
            if(name.length() > 15) {
                  System.out.println("| " + id + " |\t" + name + "\t|      " + phone + "\t|      " + birthyear + "\t|    " + address + "\t|     " + currence(wallet) + "\t|");
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            } else {
                  System.out.println("| " + id + " |\t" + name + "\t\t|      " + phone + "\t|      " + birthyear + "\t|    " + address + "\t|     " + currence(wallet) + "\t|");
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            }
      }
}
