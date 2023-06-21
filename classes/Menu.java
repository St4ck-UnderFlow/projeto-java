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

    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void defaultMenu(Maxwell maxwell) {
        // using when the user start the game and when he arives in a city;
        //clearTerminal();

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
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");
    }
    
    public void travelMenu(ArrayList<Frontier> frontiers, City currentCity, int power, int travelCoins) {
      
        String greenColorCode = "\u001B[32m";
        String redColorCode = "\u001B[31m";
        String resetColorCode = "\u001B[0m";

        System.out.println("Cidade Atual => " + greenColorCode + currentCity.getName()+ resetColorCode);
        System.out.println("Moedas de Transporte Atual => " + redColorCode + travelCoins + resetColorCode);
        System.out.println("Poder Atual => " + redColorCode + power + resetColorCode);

        System.out.println(" ");

        

        System.out.println("+=== CIDADES FRONTEIRA ===+");
        for (int i = 0; i < frontiers.size(); i++) {
            System.out.println((i + 1) +  "- " + frontiers.get(i).getDestination().getName() + " | Ganho de Poder => " + frontiers.get(i).getPower());
        }
    }

    public void acceptMissionMenu() {
        System.out.println("=====================================");
        System.out.println("Sua cidade atual possui uma missão");
        System.out.println("[1] Aceitar");
        System.out.println("[2] Recusar");
        System.out.println("=====================================");
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");
    }

    public void optionsMenuIfHasMission(Maxwell maxwell) {
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("[1] Viajar");
        System.out.println("[2] Sair do jogo");
        System.out.println("[3] Abandonar Missão");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");
    }

}
