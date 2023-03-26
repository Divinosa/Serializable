import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class Basket implements Serializable {
    private static final long serialVersionUID = 2L;
    private Product[] cart;

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
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        out.write(gson.toJson(cart).getBytes(StandardCharsets.UTF_8));
        out.close();
    }

    static Product[] loadFromTxtFile(File textFile) throws IOException {
        FileInputStream file = new FileInputStream(textFile);
        int i;
        StringBuilder initLoad = new StringBuilder();
        while ((i = file.read()) != -1) {
            initLoad.append(Character.toChars(i));

        }
        file.close();
        String loadJsonText = initLoad.toString();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Product[] loadProduct = gson.fromJson(loadJsonText, Product[].class);
        return loadProduct;

    }
}
