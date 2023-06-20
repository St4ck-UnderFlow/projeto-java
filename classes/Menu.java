package classes;

import java.util.ArrayList;

public class Menu {
    public void startMenu() {
        // Menu Screen | can start the game or leave 
        System.out.println("===== BEM-VINDO, VIAJANTE !!! =====");
        System.out.println("<< Escolha uma Opção >>");
        System.out.println("1. Começar a Aventura");
        System.out.println("2. Sair");
    }

    public void gameOverScreen() {
        // death screen | if restart, resets the game, if not, leaves
        System.out.println("======== FIM DE JOGO ========");
        System.out.println("1 - REINICIAR  | 2 - SAIR");
    }

    public void gameOverConfirm() {
        // Confirmation to leave the game
        System.out.println("======== DESEJA SAIR DO JOGO ? ========");
        System.out.println("1 - SIM  | 2 - NÃO");
    }

    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void defaultMenu(Maxwell maxwell) {
        // using when the user start the game and when he arives in a city;
        clearTerminal();

        String greenColorCode = "\u001B[32m";
        String resetColorCode = "\u001B[0m";

        String cityName = maxwell.getCurrentCity().getName();

        System.out.println("=== Bem-Vindo à " + greenColorCode + cityName + resetColorCode + " ===");
        System.out.println("Moedas de transporte => " + maxwell.getTravelCoins());  
        System.out.println("Quantidade de poder => " + maxwell.getPower());  
        System.out.println("Limiar da joia => " + maxwell.getCurrentThreshold());  
        System.err.println("=======================================");
        System.out.println("Cidade Atual => " + maxwell.getCurrentCity().getName());
        System.out.println("Missao Atual => " + maxwell.getCurrentMisson());
        System.out.println("=======================================");
        System.out.println("Objetivo do Jogo => " + maxwell.getGoal());
    }

    public void optionsMenu() {
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("[1] Viajar");
        System.out.println("[2] Sair do jogo");
        System.out.println("++++++++++++++++++++++++++++++");
    }
    
    public void travelMenu(ArrayList<Frontier> frontiers) {
      
        String greenColorCode = "\u001B[32m";
        String resetColorCode = "\u001B[0m";

        // System.out.println("Cidade Atual => " + greenColorCode + maxwell.getCurrentCity().getName()+ resetColorCode);

        System.out.println(" ");

        System.out.println("+=== CIDADES FRONTEIRA ===+");
        for (int i = 0; i < frontiers.size(); i++) {
            System.out.println(i +  "- " + frontiers.get(i).getDestination().getName() + " | Ganho de Poder => " + frontiers.get(i).getPower());
        }
    }
}
