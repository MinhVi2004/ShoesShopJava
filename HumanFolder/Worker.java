package Project.HumanFolder;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Worker extends Human{
      private int salary;

      
      public int getSalary() {
            return salary;
      }
      public void setSalary(int salary) {
            this.salary = salary;
      }
      public Worker() {
            super();
            salary = 0;
      }
      public Worker(String a, String b, String c, int d, String e, int f) {
            super(a,b,c,d,e);
            salary = f;
      }
      public Worker(Worker a) {
            super(a);
            salary = a.salary;
      }
      public String currence(int a) {
            DecimalFormat dinhDangVND = new DecimalFormat("#,### VND");
            return dinhDangVND.format(a);
      }
      @Override
      public void nhap(Scanner sc) {
            super.nhap(sc);
            int checkSalary;
            do {
                  checkSalary = 0;
                  System.out.print("Nhap tien luong : ");
                  salary = sc.nextInt();
                  sc.nextLine();
                  if(salary <= 0) {
                        checkSalary = -1;
                        System.out.println("\t*** Tien Luong khong hop le ***");
                  }
            } while(checkSalary == -1);            
      }
      @Override
      public void xuat() {
            if(name.length() > 15) {
                  System.out.println("| " + id + " |\t" + name + "\t|      " + phone + "\t|      " + birthyear + "\t|    " + address + "\t|     " + currence(salary) + "\t|");
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            } else {
                  System.out.println("| " + id + " |\t" + name + "\t\t|      " + phone + "\t|      " + birthyear + "\t|    " + address + "\t|     " + currence(salary) + "\t|");
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            }
      }
}
