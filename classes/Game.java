package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public Menu menu;
    public Maxwell maxwell;
    public Map map;

    public Game() {
        this.map = new Map();
        this.menu = new Menu();
        this.maxwell = new Maxwell();
        this.maxwell.setCurrentCity(map.ubud);
    }

    // Function that runs the menu of Maxwell
    public void run() {
        while (true) {
            menu.showMenu(this.maxwell);

            if (this.maxwell.isOnMission()) {
                ArrayList<Number> options= new ArrayList<Number>();
                options.add(0, 1);
                options.add(0, 2);
                options.add(0, 3);
                int optionInputed = menu.requestInputNumber(options);

                if (optionInputed == 1) {
                    // Travel mission
                    menu.clearTerminal();
                    travel();
                } else if (optionInputed == 2) {
                    // Exit option
                    System.exit(0);
                } else if (optionInputed == 3) {
                    // Abort mission option
                    System.out.println("Abandonar missão");
                } else {
                    menu.clearTerminal();
                    System.out.println("Opção inválida");
                }
            } else {
                ArrayList<Number> options= new ArrayList<Number>();
                options.add(0, 1);
                options.add(0, 2);
                int optionInputed = menu.requestInputNumber(options);
            
                if (optionInputed == 1) {
                    menu.clearTerminal();
                    travel();
                } else if (optionInputed == 2) {
                    menu.clearTerminal();
                    System.out.println("Obrigado por jogar...");
                    System.exit(0);
                } else {
                    continue;
                }
            }
        
        }
    }

    // Function to travel from one city to another chosen by the player
    public void travel() {
        menu.clearTerminal();
        try {
            Scanner input = new Scanner(System.in);

            City currentCity = this.maxwell.getCurrentCity();
            int currentPower = this.maxwell.getPower();
            int currentTravelCoins = this.maxwell.getTravelCoins();
    
            ArrayList<Frontier> frontiers = this.maxwell.getCurrentCity().getFrontiers();
            menu.travelMenu(frontiers, currentCity, currentPower, currentTravelCoins);
    
            // Ask which city the player wants to go
            System.out.println(" ");
            System.out.println("<< PARA QUAL CIDADE DESEJA VIAJAR ?");
            int cityIndexChoiceInput = input.nextInt();
            
            Frontier frontierChoosen = frontiers.get(cityIndexChoiceInput - 1);
            this.maxwell.setCurrentCity(frontierChoosen.getDestination());
            
            updatedMaxwellInfosWhenAriveOnCity(this.maxwell.getCurrentCity().getPowerUp(), this.maxwell.getTravelCoins());

            checkGameOver();
            checkMission(this.maxwell.getCurrentCity());

        } catch (IndexOutOfBoundsException error) {
            System.out.println("NORIET ... Tente um valor de fronteira valido");
        } catch (InputMismatchException error) {
            System.out.println("Digite uma entrada valida");
        }
    }

    public void updatedMaxwellInfosWhenAriveOnCity(int power, int travelCoins) {

        // update current power of Maxwell 
        int currentPower = this.maxwell.getPower();
        int currentPowerUptaded = currentPower + power;

        if (currentPowerUptaded < 0) {
            this.maxwell.setPower(0);
        }else {
            this.maxwell.setPower(currentPower + power);
        } 
    
        // update travel coins of Maxwell
        int currentTravelCoins = this.maxwell.getTravelCoins();
        this.maxwell.setTravelCoins(currentTravelCoins - 1);
    }

    public void updateTravelCoinsWhenAcceptMission(int travelCoins) {
        int currentTravelCoins = this.maxwell.getTravelCoins();
        this.maxwell.setTravelCoins(currentTravelCoins + travelCoins);
    }
    
    // Check all the possibilities to game over  
    public void checkGameOver() {
        
        int currentPower = this.maxwell.getPower();
        int currentThreshold = this.maxwell.getCurrentThreshold();
        int currentTravelCoins = this.maxwell.getTravelCoins();

        City currentCity = this.maxwell.getCurrentCity();

        if (currentPower > currentThreshold) {
            System.out.println("Fim de jogo! => Limiar máximo ultrapassado");
            System.exit(0);               
        } 
        
        if (currentCity.getName() == "Nargumun" && currentTravelCoins < 4) {
            System.out.println("Fim de jogo! => Maxwell chegou em Nargumun, mas foi alocado como servo");
            System.exit(0);    
        }

        if (currentTravelCoins < 0) {
            System.out.println("Fim de Jogo ! => Maxwell ficou sem Moedas de Transporte");
            System.exit(0);
        }
    }

    public void checkMission(City currentCity) {
       
        if (currentCity.hasMission) {
            menu.acceptMissionMenu();

            ArrayList<Number> options= new ArrayList<Number>();
            options.add(0, 1);
            options.add(0, 2);

            int optionInputed = menu.requestInputNumber(options);

            if (optionInputed == 1) {
                // Accpet mission
                acceptMission(currentCity);
            } else if(optionInputed == 2) {
                // Reject mission
                System.out.println("Missao foi negada");
            } else {
                System.out.println("Opção inválida");
            }

        } 
    }

    public void acceptMission(City currentCity) {
        City maxwellCity = this.maxwell.getCurrentCity();
        System.out.println("Missao foi aceita");
        this.maxwell.setOnMission(true);
        this.maxwell.setCurrentMisson(maxwellCity.getMission());

        // update Maxwell's travel coins 
        int travelCoinsToAccept = currentCity.getMission().getTravelCoinsToAccept();
        updateTravelCoinsWhenAcceptMission(travelCoinsToAccept);
    }
}