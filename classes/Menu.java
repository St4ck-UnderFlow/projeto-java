package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    String merchantText = textWithColor("[MERCADOR]", "BLUE");

    // Menu Screen | can start the game or leave 
    public void startMenu() {
        System.out.println("===== BEM-VINDO, VIAJANTE !!! =====");
        System.out.println("<< Escolha uma Opção >>");
        System.out.println("1. Começar a Aventura");
        System.out.println("2. Sobre o Jogo");
        System.out.println("3. Sair");
    }

    public void aboutGameMenu() {
        System.out.println(" => Maxwell é um viajante que mora em Ubud, ele tem o objetivo de levar uma joiá do poder para Nargumun.");
        System.out.println("");
        System.out.println(" => No caminho você deve acumular o maior número possivel de moedas para poder receber uma recompensa em Nargumun (dependendo da quantidade a recompensa muda).");
        System.out.println("");
        System.out.println(" => Em algumas cidades que você passar, terá que tomar decisões (aceitar ou recusar missões) pelo caminho.");
        System.out.println("");
        System.out.println(" => Maxwell deverá caminhar por toda a viagem obrigando-se a pensar sabiamente qual será sua proxima cidade.");
        System.out.println("");
        System.out.println(" => Ele deverá tomar cuidado com o acumulo de poder da joia, pois poderá trazer consequências terriveis (se ultrapassar o Limiar Maximo, Maxwell morrerá).");
        System.out.println("");
        System.out.println(" => Max poderá receber ajuda para melhorar o controle de poder da joia, podendo 'roubar' as recompensas e abandonar as missões ou ser honesto e concluir as missões para melhorar as recompensas finais.");
        System.out.println("");
        System.out.println(" => Tome suas decisões sabiamente, pois uma missão abandonada não poderá ser recuperada e a quantidade de missões que se pode ter por vez é apenas uma");
        System.out.println("");
    }

    // Function that clears the terminal
    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String textWithColor(String text, String color) {
        String greenColorCode = "\u001B[32m";
        String blueColorCode = "\u001B[34m";
        String colorYellowCode = "\u001B[33m";
        String redColorCode = "\u001B[31m";

        String resetColorCode = "\u001B[0m";

        String textFormated = text;

        if (color.toUpperCase() == "GREEN") {
            textFormated = greenColorCode + text + resetColorCode;
        } else if (color.toUpperCase() == "BLUE") {
            textFormated = blueColorCode + text + resetColorCode;
        } else if (color.toUpperCase() == "YELLOW") {
            textFormated = colorYellowCode + text + resetColorCode;
        } else if (color.toUpperCase() == "RED") {
            textFormated = redColorCode + text + resetColorCode;
        }

        return textFormated;
    }

    // using when the user start the game and when he arives in a city;
    public void defaultMenu(Maxwell maxwell) {
        String cityName = maxwell.getCurrentCity().getName();

        System.out.println("=== Bem-Vindo à " + textWithColor(cityName, "GREEN") + " ===");
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
    public void travelMenu(ArrayList<Frontier> frontiers, City currentCity, int power, int travelCoins, int threshold) {

        String cityName = currentCity.getName();
        String stringTravelCoins = Integer.toString(travelCoins);
        String stringPower = Integer.toString(power);
        String stringThreshold = Integer.toString(threshold);

        System.out.println("Cidade Atual => " + textWithColor(cityName, "GREEN"));
        System.out.println("Moedas de Transporte Atual => " + textWithColor(stringTravelCoins, "RED"));
        System.out.println("Poder Atual => " + textWithColor(stringPower, "RED"));
        System.out.println("Limiar Atual => " + textWithColor(stringThreshold, "RED"));

        System.out.println(" ");

        System.out.println("+=== CIDADES FRONTEIRA ===+");
        for (int i = 0; i < frontiers.size(); i++) {
            System.out.println((i + 1) +  "- " + frontiers.get(i).getDestination().getName() + " | Ganho de Poder => " + frontiers.get(i).getPower());
        }
    }

    // Option menu the player receive when arriving in a city with misson
    public void acceptMissionMenu(Mission mission) {
        
        String missionGoal = mission.getGoal();
        String stringTravelCoinsToAccept = Integer.toString(mission.getTravelCoinsToAccept());
        String stringTravelCoinsToComplete = Integer.toString(mission.getTravelCoinsToComplete());
        String stringThrasholdToComplete = Integer.toString(mission.getThresholdToComplete());

        System.out.println(" ");
        System.out.println("=====================================");
        System.out.println("Sua cidade atual possui uma missão");
        System.out.println(" ");
        System.out.println("  |+ OBJETIVO => " + textWithColor(missionGoal, "YELLOW"));
        System.out.println("  |+ RECOMPENSA POR ACEITAR => " + textWithColor(stringTravelCoinsToAccept + " Moedas de Transporte", "YELLOW"));
        System.out.println("  |+ RECOMPENSA POR CONCLUIR => " + textWithColor(stringTravelCoinsToComplete + " Moedas de Transporte " + "e " + stringThrasholdToComplete + " de Limiar Total", "YELLOW"));
        System.out.println(" ");
        System.out.println("[1] Aceitar");
        System.out.println("[2] Recusar");
        System.out.println("=====================================");
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");
    }
 
    public void changeMissionsConfirmation() {
        System.out.println(" ");
        System.out.println("===========================================");
        System.out.println(textWithColor("VOCÊ JÁ ESTA COM UMA MISSÃO !!", "RED"));
        System.out.println("DESEJA TROCAR A ATUAL PELA DESSA CIDADE ?");
        System.out.println("[1] - SIM");
        System.out.println("[2] - NÃO");
        System.out.println("===========================================");
        System.out.println(" ");
        System.out.println("<< ESCOLHA A OPÇÃO DESEJADA >>");
    }

    public void onMissionMenu(Maxwell maxwell) {

        String cityName = maxwell.getCurrentCity().getName();
        String missionGoal = maxwell.getCurrentMisson().getGoal();

        System.out.println("=== Bem-Vindo à " + textWithColor(cityName, "GREEN") + " ===");
        System.out.println("Moedas de transporte => " + maxwell.getTravelCoins());  
        System.out.println("Quantidade de poder => " + maxwell.getPower());  
        System.out.println("Limiar da joia => " + maxwell.getCurrentThreshold());  
        System.err.println("=======================================");
        System.out.println("Cidade Atual => " + maxwell.getCurrentCity().getName());
        System.out.println("Missao Atual => " + textWithColor(missionGoal, "BLUE"));
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
        int option = 0;

        while (true) {
            try {
                option = input.nextInt();
                if (!options.contains(option)) {
                    throw new InputMismatchException(null);
                }
                break;
                
            } catch (InputMismatchException error) {
                return options.size() + 1;
            } 
        }
        
        return option;
    }

    public void merchantFirstQuestion() {
        System.out.println(" ");
        System.out.println("==================================================");
        System.out.println(merchantText + " Quantas moedas de transporte você tem?");
        System.out.println("==================================================");
        System.out.println(" ");
        System.out.println("<< DIGITE O VALOR >>");
    }

    public void merchantSecondQuestion() {
        System.out.println(" ");
        System.out.println("==================================================");
        System.out.println(merchantText + " Quer trocar moeda por poder?");
        System.out.println("==================================================");
        System.out.println("[1] - SIM");
        System.out.println("[0] - NAO");
        System.out.println("==================================================");
        System.out.println(" ");
        System.out.println("<< SELECIONE A OPÇÃO DESEJADA >>");
    }

    public void rewardMessage(String answearFormated) {
        switch(answearFormated) {
            case "R1":
                System.out.println(" ");
                System.out.println(merchantText + " Você ganhou " + textWithColor("2 Moedas de Transporte", "GREEN"));
                System.out.println(" ");
                break;
            case "R2":
                System.out.println(" ");
                System.out.println(merchantText + " Você ganhou " + textWithColor("2 de Limiar de Poder ", "GREEN")+ "e perdeu" + textWithColor(" 1 Moeda de Transporte ", "RED"));
                System.out.println(" ");
                break;
            case "R3":
                System.out.println(" ");
                System.out.println(merchantText + " Você perdeu " + textWithColor("2 Moedas de Transporte" , "RED"));
                System.out.println(" ");
                break;
            case "R4":
                System.out.println(" ");
                System.out.println(merchantText + " Você perdeu " + textWithColor("2 Moedas de Transporte ", "RED") + "e ganhou " + textWithColor("2 de Limiar de Poder", "GREEN"));
                System.out.println(" ");
                break;
        }
    }
}