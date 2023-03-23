import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Basket {
    Product[] cart;

    public Basket(Product[] products) {
        cart = products;
    }

    public void addToCart(String productName, int count) {
    }

    public void printCart() {
        for (Product product : cart) {
            System.out.println(product.toStringChe());
        }

    }

    public void saveTxt(File txtFile) throws IOException {
        String[] myProducts = new String[cart.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cart.length; i++) {
            sb.append(cart[i].getProductName()).append(" ");
            sb.append(cart[i].getProductCount()).append(" ");
            sb.append(cart[i].getProductPrice()).append(" ");
            myProducts[i] = sb.toString();
            sb.setLength(0);
        }
        OutputStream outputStream = new FileOutputStream(txtFile);
        for (String pr : myProducts) {
            outputStream.write(pr.getBytes(StandardCharsets.UTF_8));
        }
    }

    static Product[] loadFromTxtFile(File textFile) throws IOException {
        InputStream inputStream = new FileInputStream(textFile);
        StringBuilder sb = new StringBuilder();
        int a = 0;
        while ((a = inputStream.read()) != -1) {
            sb.append(Character.toString(a));
        }
        String[] save = sb.toString().split(" ");
        Product[] products = new Product[save.length / 3];
        for (int p = 0; p < products.length; p++) {
            products[p] = new Product(null, 0, 0);
        }
        String[][] objSave = new String[products.length][3];
        int p = 0;
        for (int i = 0; i < objSave.length; i++) {
            for (int c = 0; c < objSave.length; c++) {
                objSave[i][c] = save[p];
                p++;
            }
        }
        for (int i = 0; i < objSave.length; i++) {
            for (int c = 0; c < objSave.length; c++) {
                if (c == 0) {
                    products[i].setProductName(objSave[i][c]);
                } else if (c == 1) {
                    products[i].setProductCount(Integer.parseInt(objSave[i][c]));
                } else {
                    products[i].setProductCount(Integer.parseInt(objSave[i][c]));
                }
            }
        }
        return products;
    }
}
