public class Product {
    private String productName;
    private int productPrice;
    private int productCount;

    public Product() {
    }

    public Product(String productName, int productPrice, int productCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount += productCount;
    }

    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount += productCount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductSumPrise() {
        return productCount * productPrice;
    }

    public String toString() {
        return productName + " стоимость: " + productPrice;
    }

    public String toStringChe() {
        return productName + " стоимость: " + productPrice + " кол-во " + productCount +
                "\n " + "                       сумма: " + (productPrice * productCount) + " руб.";
    }

}
