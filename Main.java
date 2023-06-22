import java.util.ArrayList;

import classes.Game;
import classes.Menu;

public class Main {
    public static void main(String[] args) {
    
        Menu menu = new Menu();
        Game game = new Game();
    
        ArrayList<Number> options= new ArrayList<Number>();
        options.add(0, 1);
        options.add(0, 2);

        while (true) {
            menu.startMenu();
            int option = menu.requestInputNumber(options);

            switch(option) {
                case 1:
                    // "Play the Game" option
                    menu.clearTerminal();
                    game.run();
                    break;
                case 2:
                    // "Leave" option
                    System.out.println("JÁ DESISTIU ???");
                    break; 
                default:
                    // "Invalid Number" option
                    continue;
            }
        } 
    }
}