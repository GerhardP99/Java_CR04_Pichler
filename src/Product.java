
public class Product {
    private double price;
    private int productID;
    private String productName, productDescription;
    private static int counter = 1;
    private Category category;
    enum Category{
        TShirts,
        Trousers,
        Hoodie,
        Jackets,
        Accessories,
        Shoes
    }

    public Product(String productName, String productDescription, double price, Category category){
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
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

    @Override
    public String toString() {
        return String.format("%-30s %-15s %-30s %,8.2f €\n", productName, category, productDescription/*, quantity*/, price);
    }
}
