import java.util.HashMap;

public class Shop {
    private String shopName, shopAddress;
    private int maxStock;
    public static HashMap<Integer, ProductItems> shops;

    public Shop(String shopName, String shopAddress){
        maxStock = 15;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        shops = new HashMap<>();
    }

    public ProductItems get(int productID){
        return shops.get(productID);
    }
    public void addProduct(String productName, String productDescription, double price, int quantity, Product.Category category){
        if(quantity < 1){
            System.out.println("How do you want to add a Product if you don't even have it? are you kidding me?!");
        }else{
            Product product = new Product(productName, productDescription, price, category);
            quantity = checkQuantity(quantity, productName);
            ProductItems productitems = new ProductItems(product, quantity);
            shops.put(product.getProductID(), productitems);
        }
    }

    public HashMap<Integer, ProductItems> getShops() {
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
        return String.valueOf(System.out.printf("%s Adding: %s to stock %s... sorry tock is full could not add! %s ",productInfo,added,productInfo,notAdded));
    }


    public void printShop(){
        System.out.println("\u001B[33m"+"\nShop: "+"\u001B[0m"+"\u001B[34m"+shopName+"\u001B[0m");
        System.out.println(shops);
    }
}
