import java.util.HashMap;
import java.util.Random;

public class Shop {
    private String shopName, shopAddress;
    private int maxStock;
    public static HashMap<Integer, Product> shops;

    public Shop(String shopName, String shopAddress){
        maxStock = 15;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        shops = new HashMap<>();
    }

    public Product get(int productID){
        return shops.get(productID);
    }
    public void addProduct(String productName, String productDescription, double price, int quantity, Product.Category category){
        if(quantity < 1){
            System.out.println("How do you want to add a Product if you don't even have it? are you kidding me?!");
        }else{
            Product product = new Product(productName, productDescription, price, quantity, category);
            quantity = checkQuantity(quantity, productName);
            shops.put(product.getProductID(), product);
        }
    }

    public HashMap<Integer, Product> getShops() {
        return shops;
    }

    private int checkQuantity(int quantity, String product) {
        try {
            return CheckQuantity(quantity, product);
        } catch (StockException e) {
            System.out.println(e.getMessage());
            return maxStock;
        }
    }

    private int CheckQuantity(int quantity, String product) throws StockException{
        if (quantity > maxStock) {
            quantity -= maxStock;
            throw new StockException(stockFull(product, maxStock, quantity));
        } else {
            System.out.println(product + "Adding " + quantity + " to stock.");
            return quantity;
        }
    }

    private String stockFull(String productInfo, int added, int notAdded) {
        return productInfo + ": Adding " + added + " to stock.\n" + productInfo + ": Warning. Stock is full. Could not add " + notAdded;
    }

    public void printShop(){
        System.out.println("\u001B[33m"+"\nShop: "+"\u001B[0m"+"\u001B[34m"+shopName+"\u001B[0m");
        System.out.println(shops);
    }
}
