package Project.ProductFolder;

import java.util.Scanner;

import Project.IChucNangCoBan;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class QLProduct implements IChucNangCoBan{
      private static Product[] productList = new Product[100];
      private static int soLuongProduct;

      public Product[] getproductList() {
            return productList;
      }
      public void setproductList(Product[] productList) {
            QLProduct.productList = productList;
      }
      public int getSoLuongProduct() {
            return soLuongProduct;
      }
      public void setSoLuongProduct(int soLuongProduct) {
            QLProduct.soLuongProduct = soLuongProduct;
      }
      public QLProduct() {
            QLProduct.soLuongProduct = 0;
      }
      public void nhapProduct() {
            String[] productArray = null;
            try {
                  BufferedReader input = new BufferedReader(new FileReader("Project/Table.txt"));
                  //? readLine() lần 1 là khách hàng
                  input.readLine();
                  //? readLine() lần 2 là khách hàng
                  input.readLine();
                  //?readLine() lần 3 là sản phẩm
                  productArray = input.readLine().split("~");
                  
                  input.close();
            } catch(Exception ex) {
                  ex.printStackTrace();
            }
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
      }
      public void ghiProduct() {
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
                  for(int i = 0; i < soLuongProduct; i++) {
                        if(productList[i] instanceof Sandal) {    
                              Sandal sandal = (Sandal) productList[i]; 
                              a += sandal.getId();
                              a += "-";
                              a += "Sandal";
                              a += "-";
                              a += sandal.getRopeSandal();
                              a += "-";
                              a += sandal.getName();
                              a += "-";
                              a += sandal.getPrice();
                              a += "-";
                              a += sandal.getSize();
                              a += "~";
                        } else if(productList[i] instanceof Sneaker) {
                              Sneaker sneaker = (Sneaker) productList[i];
                              a += sneaker.getId();
                              a += "-";
                              a += "Sneaker";
                              a += "-";
                              a += sneaker.getBluchersSneaker();
                              a += "-";
                              a += sneaker.getName();
                              a += "-";
                              a += sneaker.getPrice();
                              a += "-";
                              a += sneaker.getSize();
                              a += "~";
                        }
                  }
                  content.replace(endOfLine[0] + endOfLine[1] + 2,endOfLine[0] + endOfLine[1] + 2 + endOfLine[2], a);
                  output.write(content.toString());

                  output.close();
            } catch(Exception ex) {
                  ex.printStackTrace();
            }
      }
      public void them(Scanner sc) {
            System.out.println("\t--- Nhap loai San Pham can them ----");
            System.out.print("1. Sandal\n2. Sneaker\nLua chon : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                  case 1:
                        Sandal a = new Sandal();
                        System.out.println("\n\t--- Nhap San Pham ---");
                        a.nhap(sc);
                        productList = Arrays.copyOf(productList, soLuongProduct + 1);
                        productList[soLuongProduct] = new Sandal(a);
                        System.out.println("\t*** Them giay Sandal thanh cong ***");
                        soLuongProduct++;
                        ghiProduct();
                        break;
                  case 2:
                        Sneaker b = new Sneaker();
                        System.out.println("\n\t--- Nhap San Pham ---");
                        b.nhap(sc);
                        productList = Arrays.copyOf(productList, soLuongProduct + 1);
                        productList[soLuongProduct] = new Sneaker(b);
                        System.out.println("\t*** Them giay Sneaker thanh cong ***");
                        soLuongProduct++;
                        ghiProduct();
                        break;
            
                  default:
                        break;
            }
            
      }
      public void xuat()  {
            System.out.println("\n\t\t------- Danh Sach San Pham ("+soLuongProduct+" San Pham ) -------\n");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("|  ID   | Ten San Pham \t\t\t|    Don Gia\t| Size\t|    Dac Diem\t|   Loai Giay \t|");
            System.out.println("-------------------------------------------------------------------------------------------------");
            for(int i = 0; i < soLuongProduct; i++) {
                  productList[i].xuat();
            }
      }
      public static Product timKiemValue(String a) {
            for(int i = 0; i < soLuongProduct; i++) {
                  if(productList[i].name.equalsIgnoreCase(a)) 
                        return productList[i];
            }
            return null;
      }
      public void timKiem(Scanner sc) {
            System.out.println("\n\t--- Tim kiem San Pham ---");
            System.out.print("Nhap ma hoac ten San Pham can Tim Kiem : ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongProduct; i++) {
                  if(productList[i].getId().equalsIgnoreCase(a) || productList[i].getName().equalsIgnoreCase(a)) {
                        System.out.println("|  ID   | Ten San Pham \t\t\t|    Don Gia\t| Size\t|    Dac Diem\t|   Loai Giay \t|");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                        productList[i].xuat();
                        return;
                  } 
            }
            System.out.println("\n\t*** Khong tim thay San Pham : " + a + " ***");
      }
      public void sua(Scanner sc) {
            System.out.println("\n\t--- Sua San Pham ---");
            System.out.print("Nhap ma hoac ten San Pham Can sua: ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongProduct; i++) {
                  if(productList[i].getName().equalsIgnoreCase(a) || productList[i].getId().equalsIgnoreCase(a)) {
                        if(productList[i].getName().equalsIgnoreCase(a)) {
                              String tenVietHoa = productList[i].getName();
                              System.out.println("\t\t\t\t    San Pham Can Sua");
                              System.out.println("|  ID   | Ten San Pham \t\t\t|    Don Gia\t| Size\t|    Dac Diem\t|   Loai Giay \t|");
                              System.out.println("-------------------------------------------------------------------------------------------------");
                              productList[i].xuat();
                              productList[i].nhap(sc);
                              ghiProduct();
                              System.out.println("\t*** Sua Thong Tin San Pham " + tenVietHoa + " thanh cong ***");
                              return;
                        } else {
                              System.out.println("\t\t\t\t    San Pham Can Sua");
                              System.out.println("|  ID   | Ten San Pham \t\t\t|    Don Gia\t| Size\t|    Dac Diem\t|   Loai Giay \t|");
                              System.out.println("------------------------------------------------------------------------------------------------");
                              productList[i].xuat();
                              productList[i].nhap(sc);
                              ghiProduct();
                              System.out.println("\t*** Sua Thong Tin San Pham " + productList[i].getId() + " thanh cong ***");
                              return;
                        }
                  }
            }
      }
      public void xoa(Scanner sc) {
            System.out.println("\n\t--- Xoa San Pham ---");
            System.out.print("Nhap ma hoac ten San Pham can Xoa : ");
            String a = sc.nextLine();
            for(int i = 0; i < soLuongProduct; i++) {
                  if(productList[i].getId().equalsIgnoreCase(a) || productList[i].getName().equalsIgnoreCase(a)) {
                        if(productList[i].getName().equalsIgnoreCase(a)) {
                              String tenVietHoa = productList[i].name;
                              System.out.println("\n\t\t\t\t    San Pham muon xoa");
                              System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                              productList[i].xuat();
                              System.out.println("Ban co chac muon xoa San Pham : " + a);
                              System.out.println("1. Co");
                              System.out.println("2. Khong");
                              System.out.print("Lua chon : ");
                              int confirm = sc.nextInt();
                              sc.nextLine();
                              if(confirm == 1) {
                                    int j ;
                                    for(j = i; j < soLuongProduct-1; j++){
                                          productList[j] = productList[j+1];
                                    }
                                    soLuongProduct--;
                                    ghiProduct();
                                    System.out.println("\t*** Da xoa thanh cong San Pham " + tenVietHoa + " ***");
                              }
                              return;
                        } else {
                              System.out.println("\n\t\t\t\t    San Pham muon xoa");
                              productList[i].xuat();
                              System.out.println("Ban co chac muon xoa San Pham : " + a);
                              System.out.println("1. Co");
                              System.out.println("2. Khong");
                              System.out.print("Lua chon : ");
                              int confirm = sc.nextInt();
                              sc.nextLine();
                              if(confirm == 1) {
                                    int j ;
                                    for(j = i; j < soLuongProduct-1; j++){
                                          productList[j] = productList[j+1];
                                    }
                                    soLuongProduct--;
                                    ghiProduct();
                                    System.out.println("\t*** Da xoa thanh cong San Pham " + a + " ***");
                                    return;
                              }
                              System.out.println("\t*** Thoat chuc nang xoa san pham ***");
                              return;
                        }
                        
                  }
            }
            System.out.println("\n\t*** Khong tim thay San Pham : " + a + " ***");
      }
}
