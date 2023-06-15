package classes;

import java.util.Scanner;

public class Menu {
    public void startMenu() {
        // Menu Screen | can start the game or leave 
        System.out.println("===== WELCOME, ADVENTURER !!! =====");
        System.out.println("<< Chose an option >>");
        System.out.println("1. Start Adventure");
        System.out.println("2. Exit");
    }

    public void gameOverScreen() {
        // death screen | if restart, resets the game, if not, leaves
        System.out.println("======== GAME OVER ========");
        System.out.println("1 - RESTART  | 2 - EXIT");
    }

    public void gameOverConfirm() {
        // Confirmation to leave the game
        System.out.println("======== DO YOU WISH TO LEAVE ? ========");
        System.out.println("1 - YES  | 2 - NO");
    }

    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void defaultMenu(Maxwell maxwell) {
        // using when the user start the game and when he arives in a city;

        clearTerminal();

        System.out.println("=== Welcome to " + maxwell.getCurrentCity() + " ===");
        System.out.println("Moedas de transporte => " + maxwell.getTravelCoins());  
        System.out.println("Quantidade de poder => " + maxwell.getPower());  
        System.out.println("Limiar da joia => " + maxwell.getCurrentThreshold());  
        System.err.println("=======================================");
        System.out.println("Cidade Atual => " + maxwell.getCurrentCity());
        System.out.println("Missao Atual => " + maxwell.getCurrentMisson());
        System.out.println("=======================================");
        System.out.println("Objetivo do Jogo => " + maxwell.getGoal());
    }

    public void optionsMenu(Maxwell maxwell) {

        Scanner input = new Scanner(System.in);

        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("[1] Viajar");
        System.out.println("[2] Sair do jogo");
        System.out.println("++++++++++++++++++++++++++++++");

        int option = input.nextInt();


        if (option == 1) {
            maxwell.travel();
        } else if (option == 2) {
            clearTerminal();
            System.out.println("goodbye");
            System.exit(0);
        }

        input.close();
    }
    
}
