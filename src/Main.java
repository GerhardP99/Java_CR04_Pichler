import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Main {
    static HashMap<Integer, User> users = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        // UserMenu.printMenu();


	    Shop shop = new Shop("Zenyatas Shop", "Schikanedergasse 15, 1040 Wien");
	    User users = new User("x","x","x","x",0,"x");
        System.out.println("");
	    stockUpShop(shop);
        waitingTime();
        System.out.println("");
        shop.printShop();
        waitingTime();
        addUser(users);
        users.printUsers();
        waitingTime();
        for(int i = 1; i <= shop.getShops().size(); i++){
            shop.getShops().get(i).stockBelowFive();
        }
        waitingTime();
        shop.printShop();
        for(int i = 1; i <= shop.getShops().size(); i++){
            shop.getShops().get(i).purchaseProduct();
        }
        waitingTime();
        shop.printShop();
        for(int i = 1; i <= shop.getShops().size(); i++){
            shop.getShops().get(i).stockBelowFive();
        }
        waitingTime();
        shop.printShop();
        users.storeClose();
        users.printUsers();

    }

    static void stockUpShop(Shop shop) {
        shop.addProduct("Rainbow T-Shirt ", "A T-Shirt with rainbow colors", 55.99,15, Product.Category.TShirts);
        shop.addProduct("Biker Jacket ", "A Biker Jacket", 125.59,11, Product.Category.Jackets);
        shop.addProduct("Rolex Patek Philippe ", "Rolex wrist watch", 290770.00,1, Product.Category.Accessories);
        shop.addProduct("Nike Jordan AIR 1 MID ", "Sneaker from Nike", 119.95,12, Product.Category.Shoes);
        shop.addProduct("JOGGING PANT - Cargo ", "Cargo pants", 49.99,4, Product.Category.Trousers);
        shop.addProduct("SAINT LAURENT Hoodie ", "Hoodie", 590.00,5, Product.Category.Hoodie);
    }
    static void addUser(User users){
        users.addUser("Leslie","Tallow","ltallow0@toplist.cz","Hovde Avenue",96267,"+1 505 168 6315");
        users.addUser("Adela","Easom","aeasom1@xing.com","Welch Center",67 ,"+995 421 228 8728");
        users.addUser("Eudora","Veregan","everegan2@auda.org.au","Elka Plaza",24,"+66 169 689 3942");
        users.addUser("Joellen","Stairmond","jstairmond3@360.cn","Westerfield Drive",62032,"+84 902 643 2036");
        users.addUser("Stephen","Taylder","staylder4@yahoo.co.jp","Melrose Circle",9083,"+86 419 873 7878");
        users.addUser("Julee","Arnoult","jarnoult5@paginegialle.it","Golf Course Parkway",5881,"+86 755 447 6738");
    }
    public static void waitingTime() throws InterruptedException {
        int waitTime = 5;
        TimeUnit.SECONDS.sleep(waitTime);
    }
}
