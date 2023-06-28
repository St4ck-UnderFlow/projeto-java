import java.util.ArrayList;

import classes.Game;
import classes.Menu;

public class Main {
    public static void main(String[] args) {
    
        Menu menu = new Menu();
        Game game = new Game();
    
        ArrayList<Number> options= new ArrayList<Number>();
        options.add(0, 1); // "Play the Game" option 
        options.add(0, 2); // "About the Game" option
        options.add(0, 3); // "Leave" option

        menu.clearTerminal();

        while (true) {
            menu.startMenu();
            int option = menu.requestInputNumber(options);

            switch(option) {
                case 1:
                    menu.clearTerminal();
                    game.startGame();
                    break;
                case 2:
                    menu.clearTerminal();
                    menu.aboutGameMenu();
                    break;
                case 3:
                    menu.clearTerminal();
                    System.out.println("JÁ DESISTIU ???");
                    System.exit(0);
                default:
                    // "Invalid" option
                    menu.clearTerminal();
                    continue;
            }
        } 
    }
}