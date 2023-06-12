import java.util.Scanner;
import classes.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        menu.startMenu();

        int option = input.nextInt();
        switch(option) {
            case 1:
                System.out.println("game started");
                break;
            case 2:
                System.out.println("goodbye");
                break; 
            default:
                input.close();
        }
    }
}
