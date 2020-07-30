import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserMenu {
    public static int menu() {
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("+------------------+");
        System.out.println("|\t\t\t\t   |");
        System.out.println("|\t  Welcome\t   |");
        System.out.println("|\t  to the\t   |");
        System.out.println("|\t  Shop\t\t   |");
        System.out.println("|\t\t\t\t   |");
        System.out.println("+------------------+");
        System.out.println("1) Display all products");
        System.out.println("2) Display all products of category x");
        System.out.println("3) Display all products where stock is < 5");
        System.out.println("4) Display all products out of stock");
        System.out.println("5) Exit");
        System.out.println("The menu does basically nothing atm its just \"working\"");

        selection = input.nextInt();
        return selection;
    }
    public static void printMenu() throws InterruptedException {
        int userChoice;
        userChoice = menu();
        int timeOut = 0; // seconds

        switch (userChoice) {
            case 1:
                System.out.println("You chose action 1.");
                TimeUnit.SECONDS.sleep(timeOut);
                System.out.print("\nDisplaying all products");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".\n");
                break;
            case 2:
                System.out.println("You chose action 2.");
                TimeUnit.SECONDS.sleep(timeOut);
                System.out.print("\nDisplaying all products of category x");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".\n");
                break;
            case 3:
                System.out.println("You chose action 3.");
                TimeUnit.SECONDS.sleep(timeOut);
                System.out.print("\nDisplaying all products where stock is < 5");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".\n");
                break;
            case 4:
                System.out.println("You chose action 4.");
                TimeUnit.SECONDS.sleep(timeOut);
                System.out.print("\nDisplay all products out of stock");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                break;
            case 5:
                System.out.println("You chose action 5.");
                TimeUnit.SECONDS.sleep(timeOut);
                System.out.print("\nExiting");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".\n");
                break;
            default:
                // The user input an unexpected choice.
        }
    }
}
