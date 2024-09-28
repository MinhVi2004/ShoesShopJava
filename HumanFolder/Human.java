package Project.HumanFolder;

import java.util.Scanner;

/* import java.util.Scanner; */

abstract class Human{
      Scanner sc = new Scanner (System.in);
      protected String id;
      protected String name;
      protected String phone;
      protected int birthyear;
      protected String address;
      
      public Human() {
            birthyear = 0;
            id = name = phone = address = "";
      }
      public Human(String a, String b, String c, int d, String e) {
            id = a;
            name = b;
            phone = c;
            birthyear = d;
            address = e;
      }
      public Human(Human a) {
            id = a.id;
            name = a.name;
            phone = a.phone;
            birthyear = a.birthyear;
            address = a.address;
      }

      public String getId() {
            return id;
      }
      public void setId(String id) {
            this.id = id;
      }
      public String getName() {
            return name;
      }
      public void setName(String name) {
            this.name = name;
      }
      public String getPhone() {
            return phone;
      }
      public void setPhone(String phone) {
            this.phone = phone;
      }
      public int getBirthyear() {
            return birthyear;
      }
      public void setBirthyear(int birthyear) {
            this.birthyear = birthyear;
      }
      public String getAddress() {
            return address;
      }
      public void setAddress(String address) {
            this.address = address;
      }
      
      public void nhap(Scanner sc) {
            System.out.println("\t--- Nhap Thong Tin ---");
            System.out.print("Nhap id : ");
            id = sc.nextLine();

            System.out.print("Nhap ten : ");
            name = sc.nextLine();
            char[] nameArray = name.toCharArray();
            boolean foundSpace = true;
            //sử dụng vòng lặp for để duyệt các phần tử trong charArray
            for(int i = 0; i < nameArray.length; i++) {
                  // nếu phần tử trong mảng là một chữ cái
                  if(Character.isLetter(nameArray[i])) {
                  // kiểm tra khoảng trắng có trước chữ cái
                        if(foundSpace) {
                              //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
                              nameArray[i] = Character.toUpperCase(nameArray[i]);
                              foundSpace = false;
                        }
                  }
                  else {
                        foundSpace = true;
                  }
            }
            // chuyển đổi mảng char[] thành string
            name = String.valueOf(nameArray);

            //? Validate Phone
            int checkPhone;
            do {
                  checkPhone = 0;
                  System.out.print("Nhap so dien thoai : ");
                  phone = sc.nextLine();
                  char[] phoneCharArray = phone.toCharArray();
                  if(phone.length() != 10) {
                        checkPhone = -1;
                        System.out.println("\t*** So dien thoai phai so 10 so ***");
                  }
                  for(int i = 0; i < phoneCharArray.length; i++) {
                        if(Character.isDigit(phoneCharArray[i]) == false) {
                              checkPhone = -1;
                              System.out.println("\t*** So dien thoai chua ky tu dac biet ***");
                              break;
                        }
                  }
            }while(checkPhone == -1);

            int checkBirthYear;
            do {
                  checkBirthYear = 0;
                  System.out.print("Nhap nam sinh : ");
                  birthyear = sc.nextInt();
                  sc.nextLine();
                  if(birthyear < 1900 || birthyear > 2023) {
                        checkBirthYear = -1;
                        System.out.println("\t*** Nam sinh khong hop le ***");
                  }
            } while(checkBirthYear == -1);

            int checkAddress;
            do {
                  checkAddress = 0;
                  System.out.print("Nhap dia chi : ");
                  address = sc.nextLine();
                  if(address.length() < 5) {
                        checkAddress = -1;
                        System.out.println("\t*** Dia chi phai tren 5 ky tu ***");
                  }
            } while(checkAddress == -1);
      }
      public abstract void xuat();
}
