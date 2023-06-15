import java.util.Scanner;

import classes.Game;
import classes.Maxwell;
import classes.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        Maxwell maxwell = new Maxwell();
        Game game;
    
        menu.startMenu();

        int option = input.nextInt();
        switch(option) {
            case 1:
                game = new Game();
                menu.defaultMenu(maxwell);
                menu.optionsMenu(maxwell);
                break;
            case 2:
                System.out.println("Leaving So Soon ???");
                break; 
            default:
                System.out.println("This option does not exist, please type the right ones");
                

                

        }
    }
}
