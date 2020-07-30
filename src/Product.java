import java.util.Random;

public class Product {
    private double price;
    private int productID;
    private String productName, productDescription;
    private static int counter = 1;
    private Category category;
    private int quantity;
    enum Category{
        TShirts,
        Trousers,
        Hoodie,
        Jackets,
        Accessories,
        Shoes
    }

    public Product(String productName, String productDescription, double price, int quantity,Category category){
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.productID = counter++;
    }

    public double getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%-30s %-15s %-30s %-15s %,8.2f €\n", productName, category, productDescription, quantity, price);
    }

    public void stockBelowFive() { // method that checks if the maxStock is below 5
        if (quantity < 5) {
            System.out.println("\u001B[31m"+"\nPRODUCT RUNNING OUT OF STOCK"+"\u001B[0m");
            System.out.println("The stock of " + productName + "is below 5!");
            System.out.println("Calling now a Employee to restock!");
            System.out.println("Restocking now....");
            quantity=getRandom(5);
        }
    }
    public static int getRandom(int max) {
        return (int) (Math.random() * max + 5);
    }
}
