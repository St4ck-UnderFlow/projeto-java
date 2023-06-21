import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Game;
import classes.Maxwell;
import classes.Menu;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        Maxwell maxwell = new Maxwell();
        Game game = new Game(maxwell);

        boolean validInput = true;
        
        
        while(validInput){
            menu.clearTerminal();
            menu.startMenu();
            try {
                int option = input.nextInt();
                switch(option) {
                    case 1:
                        menu.clearTerminal();
                        game.startGame();
                        break;
                    case 2:
                        System.out.println("JÁ DESISTIU ???");
                        validInput = false;
                        break; 
                    default:
                        menu.clearTerminal();
                        System.out.println("Essa opção não existe, digite uma opção valida");
                        break;
                }
            } catch(InputMismatchException error) {
                input.next(); // Discard invalid input
                continue;
            }
        }
    }
}
