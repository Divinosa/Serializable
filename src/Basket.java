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
        FileOutputStream out = new FileOutputStream(txtFile);
        ObjectOutputStream obj = new ObjectOutputStream(out);
        obj.writeObject(this);
        obj.close();
    }

    static Product[] loadFromTxtFile(File textFile) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(textFile);
        ObjectInputStream obf = new ObjectInputStream(inputStream);
        Basket basket = (Basket) obf.readObject();
        return basket.cart;
    }
}
