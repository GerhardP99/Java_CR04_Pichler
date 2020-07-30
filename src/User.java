import java.util.HashMap;
import java.util.Random;

public class User {
    private int userZip;
    private int userID;
    private String firstName, lastName, userAddress, eMail, userPhone;
    private static int counter = getRandom(100);
    /*private final HashMap<Integer, User> users;*/

    public User(String firstName, String lastName, String userAddress, String eMail, int userZip, String userPhone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.eMail = eMail;
        this.userPhone = userPhone;
        this.userID = counter++;
        this.userZip = userZip;
        /*users = new HashMap<>();*/
    }
    public int getUserID(){
        return userID;
    }
    public String getFirstName(){
        return firstName;
    }

    public void addUser(String firstName, String lastName, String eMail, String userAddress, int userZip, String userPhone){
            User user = new User(firstName, lastName, eMail, userAddress, userZip, userPhone);
            Main.users.put(user.getUserID(), user); // puts the user from the "main" into the "users" hashmap

    }

    public void printUsers(){
        System.out.println("\u001B[0m"+"\u001B[34m"+"Current Users in the Shop:"+"\u001B[0m");
        System.out.println(Main.users);
    }

    public static int getRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
    public void storeClose(){
        System.out.println("\n\u001B[31m"+"Store is closing everybody has to leave!");
        Main.users.clear();
    }
    public static int getRandomBuyCount(int max) {
        return (int) (Math.random() * max - 1);
    }

    @Override
    public String toString() {
        return String.format(" %s %s\n",firstName, lastName);
    }
}
