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
                    abortCurrentMission();
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
            int currentThreshold = this.maxwell.getCurrentThreshold();

            // Check if the current city misison is already accepeted/completed
            currentCity.blockGetMissionAgain();
            
            // Shows the Menu to travel from one city to another
            ArrayList<Frontier> frontiers = this.maxwell.getCurrentCity().getFrontiers();
            menu.travelMenu(frontiers, currentCity, currentPower, currentTravelCoins, currentThreshold);
    
            // Ask which city the player wants to go and travels to it
            System.out.println(" ");
            System.out.println("<< PARA QUAL CIDADE DESEJA VIAJAR ?");
            int cityIndexChoiceInput = input.nextInt();
            
            Frontier frontierChoosen = frontiers.get(cityIndexChoiceInput - 1);
            this.maxwell.setCurrentCity(frontierChoosen.getDestination());
            
            updatedMaxwellInfosWhenAriveOnCity(this.maxwell.getCurrentCity().getPowerUp(), this.maxwell.getTravelCoins());
            
            checkGameOver();
            checkMission(this.maxwell.getCurrentCity());

            // Asks from Merchant
            Merchant merchant = this.maxwell.getCurrentCity().getMerchant();
            StringBuilder answears = merchant.askQuestions();
            merchant.giveReward(answears);

        } catch (IndexOutOfBoundsException error) {
            System.out.println("NORIET ... Tente um valor de fronteira valido");
        } catch (InputMismatchException error) {
            System.out.println("Digite uma entrada valida");
        }
    }

    // Updates Maxwell's power and travel coins
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

    // Sums Maxwell's travel coins with the ones the mission gives when accepted
    public void updateTravelCoinsWhenAcceptMission(int travelCoins) {
        int currentTravelCoins = this.maxwell.getTravelCoins();
        this.maxwell.setTravelCoins(currentTravelCoins + travelCoins);
    }
    
    // Check all the possibilities to game over  
    public void checkGameOver() {

        String greenColorCode = "\u001B[32m";
        String redColorCode = "\u001B[31m";
        String resetColorCode = "\u001B[0m";
        
        int currentPower = this.maxwell.getPower();
        int currentThreshold = this.maxwell.getCurrentThreshold();
        int currentTravelCoins = this.maxwell.getTravelCoins();

        City currentCity = this.maxwell.getCurrentCity();

        if (currentPower > currentThreshold) {
            System.out.println(redColorCode +"Fim de jogo!" +resetColorCode+" => Limiar máximo ultrapassado");
            System.exit(0);               
        } 
        
        if (currentCity.getName() == "Nargumun") {
            if (currentTravelCoins < 4) {
                System.out.println(redColorCode +"Fim de jogo!" +resetColorCode+" => Maxwell chegou em Nargumun, mas foi alocado como" +redColorCode+ " SERVO DA COROA" +resetColorCode); 
            } else if (currentTravelCoins >= 4 && currentTravelCoins <= 10) {
                System.out.println(greenColorCode + "JOGO CONCLUIDO !!!" + resetColorCode);
                System.out.println("Maxwell chegou em Nargumun e foi condecorado" +greenColorCode+" LORDE" + resetColorCode);
            } else if (currentTravelCoins > 10) {
                System.out.println(greenColorCode + "JOGO CONCLUIDO !!!" + resetColorCode);
                System.out.println("Maxwell chegou em Nargumun e foi coroado" +greenColorCode+" REI DE NARGUMUN" + resetColorCode);
            }
            System.exit(0);  
        }


        if (currentTravelCoins < 0) {
            System.out.println(redColorCode +"Fim de jogo!" +resetColorCode+" => Maxwell ficou sem Moedas de Transporte");
            System.exit(0);
        }
    }

    // Options related to change, accept, reject or abort a mission
    public void checkMission(City currentCity) {
       
        if (this.maxwell.isOnMission()) {
            Mission currentMission = this.maxwell.getCurrentMisson();
            if (currentMission.getCityTarget() == currentCity) {
                // When Maxwell arives at target City of his current mission
                menu.clearTerminal();
                currentMission.complete(maxwell);
            }
        }

        if (currentCity.hasMission) {
            
            menu.acceptMissionMenu(currentCity.getMission());

            ArrayList<Number> options= new ArrayList<Number>();
            options.add(0, 1);
            options.add(0, 2);

            int optionInputed = menu.requestInputNumber(options);

            if (optionInputed == 1) {
                // Accept mission
                if (!this.maxwell.isOnMission()) {
                    acceptMission(currentCity);
                }
               
                // When Maxwell already has a mission and wants to change
                else if  (this.maxwell.isOnMission() && wantsChangeCurrentMission()) {
                    acceptMission(currentCity);
                }

            } else if(optionInputed == 2) {
                // Reject mission
                System.out.println("Missao foi negada");
            } else {
                System.out.println("Opção inválida");
            }   

        } 
    
    }

    // Function for aborting the current mission
    public void abortCurrentMission() {
        menu.clearTerminal();
        System.out.println("<<Missão Atual foi Abortada>>");
        this.maxwell.setCurrentMisson(null);
        this.maxwell.setOnMission(false);
    }

    // Function for accepting a mission 
    public void acceptMission(City currentCity) {
        menu.clearTerminal();

        City maxwellCity = this.maxwell.getCurrentCity();
    
        System.out.println("<< Missao foi aceita >>");
        System.out.println(" ");
    
        this.maxwell.setOnMission(true);
        this.maxwell.setCurrentMisson(maxwellCity.getMission());
    
        // update Maxwell's travel coins 
        int travelCoinsToAccept = currentCity.getMission().getTravelCoinsToAccept();
        updateTravelCoinsWhenAcceptMission(travelCoinsToAccept);

    }

    // Function that changes one mission for another, if the player desires
    public boolean wantsChangeCurrentMission() {

        boolean wantChange = false;

        while (true) {
            System.out.println(" ");
            this.menu.changeMissionsConfirmation();

            ArrayList<Number> options= new ArrayList<Number>();
            options.add(0, 1);
            options.add(0, 2);

            int optionInputed = menu.requestInputNumber(options);

            if (optionInputed == 1) {
                wantChange = true;
                break;
            } else if (optionInputed == 2) {
                wantChange = false;
                break;
            }  else {
                System.out.println("Opcao inválida");
                continue;
            }  
        } 

        return wantChange;
    }
}