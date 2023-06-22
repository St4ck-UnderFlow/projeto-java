package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    // Menu Screen | can start the game or leave 
    public void startMenu() {
        clearTerminal();
        System.out.println("===== BEM-VINDO, VIAJANTE !!! =====");
        System.out.println("<< Escolha uma Opção >>");
        System.out.println("1. Começar a Aventura");
        System.out.println("2. Sair");
    }

    // Function that clears the terminal
    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // using when the user start the game and when he arives in a city;
    public void defaultMenu(Maxwell maxwell) {
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
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("[1] Viajar");
        System.out.println("[2] Sair do jogo");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");
    }
    
    // Menu that shows the cities frontiers, as well as the current city, power and travel coins
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

    // Option menu the player receive when arriving in a city with misson
    public void acceptMissionMenu() {
        System.out.println(" ");
        System.out.println("=====================================");
        System.out.println("Sua cidade atual possui uma missão");
        System.out.println("[1] Aceitar");
        System.out.println("[2] Recusar");
        System.out.println("=====================================");
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");
    }
 
    public void changeMissionsConfirmation() {

        String redColorCode = "\u001B[31m";
        String resetColorCode = "\u001B[0m";

        System.out.println(" ");
        System.out.println("===========================================");
        System.out.println(redColorCode + "VOCÊ JA ESTA COM UMA MISSÃO !!" + resetColorCode);
        System.out.println("DESEJA TROCAR A ATUAL PELA DESSA CIDADE ?");
        System.out.println("[1] - SIM");
        System.out.println("[2] - NÃO");
        System.out.println("===========================================");
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");

    }

    public void onMissionMenu(Maxwell maxwell) {
        
        String greenColorCode = "\u001B[32m";
        String blueColorCode = "\u001B[34m";
        String resetColorCode = "\u001B[0m";

        String cityName = maxwell.getCurrentCity().getName();

        System.out.println("=== Bem-Vindo à " + greenColorCode + cityName + resetColorCode + " ===");
        System.out.println("Moedas de transporte => " + maxwell.getTravelCoins());  
        System.out.println("Quantidade de poder => " + maxwell.getPower());  
        System.out.println("Limiar da joia => " + maxwell.getCurrentThreshold());  
        System.err.println("=======================================");
        System.out.println("Cidade Atual => " + maxwell.getCurrentCity().getName());
        System.out.println("Missao Atual => " + blueColorCode + maxwell.getCurrentMisson().getGoal() + resetColorCode);
        System.out.println("=======================================");
        System.out.println("Objetivo do Jogo => " + maxwell.getGoal());
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("[1] Viajar");
        System.out.println("[2] Sair do jogo");
        System.out.println("[3] Abandonar Missão");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");
    }

    public void showMenu(Maxwell maxwell) {
        if (maxwell.isOnMission()) {
            onMissionMenu(maxwell);
        } else {
            defaultMenu(maxwell);
        }
    }

    public int requestInputNumber(ArrayList<Number> options) {
        Scanner input = new Scanner(System.in);
        boolean validOption = false;
        int option = 0;

        while (!validOption) {
            try {
                option = input.nextInt();
                if (!options.contains(option)) {
                    throw new InputMismatchException(null);
                }
                validOption = true;
                
            } catch (InputMismatchException error) {
                return options.size() + 1;
            } 
        }
        
        return option;
    }
}
