import java.util.Random;

public class ProductItems {
    private final int productID;
    private final Product product;
    private int quantity;

    public ProductItems(Product product, int quantity){
        this.product = product;
        this.productID = product.getProductID();
        this.quantity = quantity;
    }

    public int getProductID(){
        return productID;
    }
    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void subtractQuantity(int amount){
        quantity-=amount;
    }

    public String toString(){
        return String.format("%s %8d%n",product,quantity);
    }

    public void stockBelowFive() { // method that checks if the maxStock is below 5
        if (quantity < 5) {
            System.out.println("\u001B[31m"+"\nPRODUCT RUNNING OUT OF STOCK"+"\u001B[0m");
            System.out.println("The stock of " + product.getProductName() + "is below 5!");
            System.out.println("Calling now a Employee to restock!");
            System.out.println("Restocking now....");
            quantity=getRandom(5);
        }
    }
    public void purchaseProduct() { // method that checks if the maxStock is below 5
        if (quantity > 1) {
            Random generator = new Random();
            Object[] userValues = Main.users.entrySet().toArray();
            Object userValue = userValues[generator.nextInt(userValues.length)];
            System.out.println("\u001B[31m"+"\nUser is buying a Product"+"\u001B[0m");
            System.out.println("User: "+userValue+" Bought " + product.getProductName());
            quantity=quantity-1;
            /*User user = Main.users.get(userValue);
            user.addProductHistory(product.getProductName(), product.getPrice());*/
        }
    }
    public static int getRandom(int max) {
        return (int) (Math.random() * max + 5);
    }
}
