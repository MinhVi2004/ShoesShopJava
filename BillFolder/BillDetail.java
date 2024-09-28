package Project.BillFolder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

import Project.ProductFolder.Product;
import Project.ProductFolder.Sandal;
import Project.ProductFolder.Sneaker;

public class BillDetail extends BillDetailAbstract {
      private Product[] productList;
      private int soLuongProductList;
      
      private Product productBillDetail;
      private int quantityProduct;

      public Product[] getProductList() {
            return productList;
      }
      public void setProductList(Product[] productList) {
            this.productList = productList;
      }
      public int getSoLuongProductList() {
            return soLuongProductList;
      }
      public void setSoLuongProductList(int soLuongProductList) {
            this.soLuongProductList = soLuongProductList;
      }
      public Product getProductBillDetail() {
            return productBillDetail;
      }
      public void setProductBillDetail(Product product) {
            productBillDetail = product;
      }
      public int getQuantityProduct() {
            return quantityProduct;
      }
      public void setQuantityProduct(int quantityProduct) {
            this.quantityProduct = quantityProduct;
      }

      public BillDetail() {
            productList = new Product[100];
            productBillDetail = new Product();
            soLuongProductList = 0;
            quantityProduct = 0;
      }
      public BillDetail(Product a, int b) {
            productBillDetail = a;
            quantityProduct = b;
      }

      public void nhapProduct(Scanner sc) {
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
            for(int i = 0; i < productArray.length; i++) { //? nhập dữ liệu vào biến [productList]
                  productList = Arrays.copyOf(productList, soLuongProductList + 1);

                  String[] productArrayElement = productArray[i].split("-");
                  if(productArrayElement[1].equalsIgnoreCase("Sandal")) {
                        productList[soLuongProductList] = new Sandal(productArrayElement[0],productArrayElement[3],Integer.parseInt(productArrayElement[4]),Integer.parseInt(productArrayElement[5]), productArrayElement[2]);
                  } else if (productArrayElement[1].equalsIgnoreCase("Sneaker")){
                        productList[soLuongProductList] = new Sneaker(productArrayElement[0],productArrayElement[3],Integer.parseInt(productArrayElement[4]),Integer.parseInt(productArrayElement[5]), productArrayElement[2]);
                  } else {
                        System.out.println("Sai dinh dang file khi doc Product");
                        return;
                  }
                  soLuongProductList++;
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
      public void nhapBillDetail(Scanner sc) {
            int checkProduct = 0;
            do {
                  System.out.print("Nhap ten san pham : ");
                  String a = sc.nextLine();
                  if(timKiemProductValue(a) != null) {
                        productBillDetail = timKiemProductValue(a);
                  } else {
                        checkProduct = -1;
                        System.out.println("\t*** Khong ton tai san pham " + a + " ***");
                  }
            } while(checkProduct == -1);
            int checkQuantity = 0;
            do {
                  System.out.print("Nhap so luong : ");
                  quantityProduct = sc.nextInt();
                  sc.nextLine();
                  if(quantityProduct <= 0) {
                        checkQuantity = -1;
                        System.out.println("\t*** So luong khong hop le ! ***");
                  }
            } while(checkQuantity == -1);
            System.out.println("\t*** Nhap san pham thanh cong ***");
      }
      public void xuatBillDetail() {
            System.out.println("| \tTen san pham : " + productBillDetail.getName() + "\t\t|");
            System.out.println("| \tDon gia  : " + currence(productBillDetail.getPrice()) + "\t\t|");
            System.out.println("| \tSo luong : " + quantityProduct + "\t\t\t\t|");
            System.out.println("| \tThanh tien : " + currence(totalBillDetail())+"\t\t|");
      }
      public int totalBillDetail() {
            return productBillDetail.getPrice() * quantityProduct;
      }
      public String currence(int a) {
            DecimalFormat dinhDangVND = new DecimalFormat("#,### VND");
            return dinhDangVND.format(a);
      }
}