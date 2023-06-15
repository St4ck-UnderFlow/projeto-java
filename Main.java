import java.util.Scanner;

import classes.Game;
import classes.Maxwell;
import classes.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        Game game = new Game();

        Maxwell maxwell = new Maxwell(game.ubud);
        
        boolean validInput = true;
        
        while(validInput){
            menu.startMenu();
            int option = input.nextInt();
            switch(option) {
                case 1:
                    game.startGame();
                    menu.defaultMenu(maxwell);
                    menu.optionsMenu(maxwell);
                    validInput = false;
                    break;
                case 2:
                    System.out.println("Leaving So Soon ???");
                    validInput = false;
                    break; 
                default:
                    menu.clearTerminal();
                    System.out.println("This option does not exist, please type the right ones");
                    break;
            }
        }
    }
}
