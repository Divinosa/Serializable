import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        Basket basket;

        File file = new File("basket.txt");
            Product[] products = new Product[3];
            products[0] = new Product("Milk", 80);
            products[1] = new Product("Bread", 50);
            products[2] = new Product("Meat", 180);
            try {
               basket = new Basket(Basket.loadFromTxtFile(file));
            } catch (Exception e){
                basket = new Basket(products);
            }

        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i].toString());
        }

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String inputString = input.nextLine();
            if (inputString.equals("end")) {
                basket.saveTxt(file);
                System.out.println("Ваша корзина:");
                basket.printCart();
                break;
            } else {
                String[] product = inputString.split(" ");
                int productNumber = Integer.parseInt(product[0]) - 1;
                int productCount = Integer.parseInt(product[1]);
                switch (productNumber) {
                    case (0):
                        products[0].setProductCount(productCount);
                        System.out.println(products[productNumber] + " добавлен в кол-ве " + productCount);
                        break;
                    case (1):
                        products[1].setProductCount(productCount);
                        System.out.println(products[productNumber] + " добавлен в кол-ве " + productCount);
                        break;
                    case (2):
                        products[2].setProductCount(productCount);
                        System.out.println(products[productNumber] + " добавлен в кол-ве " + productCount);
                        break;
                    default:
                        System.out.println("Продукт с данным номер не существует");
                        break;
                }
            }
        }
    }
}