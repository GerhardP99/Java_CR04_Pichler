import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class User {
    private int userZip;
    private int userID;
    private String firstName, lastName, userAddress, eMail, userPhone;
    private static int counter = getRandom(100);
    private ArrayList <String[]> history = new ArrayList<>();


    public User(String firstName, String lastName, String userAddress, String eMail, int userZip, String userPhone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.eMail = eMail;
        this.userPhone = userPhone;
        this.userID = counter++;
        this.userZip = userZip;

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
        System.out.println("\n\u001B[0m"+"\u001B[34m"+"Current Users in the Shop:"+"\u001B[0m");
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

    public void addProductHistory(String name, double price){
        String[] products = {name, Double.toString(price)};
        history.add(products);
    }

    public void printHistory(){
        try {
            Path currentRelativePath = Paths.get("");
            String projectPath = currentRelativePath.toAbsolutePath().toString();
            String fileName = String.format("%s_%s_Report.txt", this.firstName, this.lastName);
            File file = new File(projectPath + "/data/" + fileName);
            if (file.createNewFile()) {
                System.out.printf("\nFile Created %s \n", file.getName());
                FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), true);
                Integer counter = 1;
                for (String[] product : history) {
                    fileWriter.write(String.format("%d | %-40s | %-5s \n", counter, product[0], product[1]));
                    counter++;
                }
                fileWriter.close();
                System.out.println("Created File successfully");
            }
        } catch (IOException e) {
            System.out.println("An error occurred \n");
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return String.format(" %s %s\n",firstName, lastName);
    }
}
