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

    // Function that runs the main menu 
    public void startGame() {
        while (true) {
            menu.showMenu(this.maxwell);

            // Menu with mission
            if (this.maxwell.isOnMission()) {
                ArrayList<Number> options= new ArrayList<Number>();
                options.add(0, 1); // Travel
                options.add(0, 2); // Exit
                options.add(0, 3); // Abort Current Mission
                int optionInputed = menu.requestInputNumber(options);

                if (optionInputed == 1) {
                    menu.clearTerminal();
                    travel();
                } else if (optionInputed == 2) {
                    System.exit(0);
                } else if (optionInputed == 3) {
                    abortCurrentMission();
                } else {
                    menu.clearTerminal();
                    System.out.println("Opção inválida");
                }
            
            // Menu without mission
            } else {
                ArrayList<Number> options= new ArrayList<Number>();
                options.add(0, 1); // Travel
                options.add(0, 2); // Exit
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

            // Shows the Menu to travel from one city to another
            ArrayList<Frontier> frontiers = this.maxwell.getCurrentCity().getFrontiers();
            menu.travelMenu(frontiers, currentCity, currentPower, currentTravelCoins, currentThreshold);
            
            // Ask which city the player wants to go and travels to it
            int cityIndexChoiceInput = input.nextInt();
            Frontier frontierChoosen = frontiers.get(cityIndexChoiceInput - 1);

            // Update Maxwell's infos
            this.maxwell.setCurrentCity(frontierChoosen.getDestination());
            updatedMaxwellInfosWhenArriveOnCity(this.maxwell.getCurrentCity().getPowerUp(), this.maxwell.getTravelCoins());

            checkGameOver();

            // Asks from Merchant
            Merchant merchant = this.maxwell.getCurrentCity().getMerchant();
            StringBuilder answears = merchant.askQuestions(this.maxwell, map.ubud);
            merchant.giveReward(answears, this.maxwell);
            
            checkMission(this.maxwell.getCurrentCity());
            currentCity.blockGetMissionAgain();

        } catch (IndexOutOfBoundsException error) {
            System.out.println("NORIET ... Tente um valor de fronteira valido");
        } catch (InputMismatchException error) {
            System.out.println("Digite uma entrada valida");
        }
    }

    // Updates Maxwell's power and travel coins
    public void updatedMaxwellInfosWhenArriveOnCity(int power, int travelCoins) {

        int currentPower = this.maxwell.getPower();
        int currentPowerUptaded = currentPower + power;
        int currentTravelCoins = this.maxwell.getTravelCoins();
        
        // Update power 
        if (currentPowerUptaded < 0) {
            this.maxwell.setPower(0);
        } else {
            this.maxwell.setPower(currentPower + power);
        } 
    
        // Update travel coins 
        this.maxwell.setTravelCoins(currentTravelCoins - 1);
    }

    // Sums Maxwell's travel coins with the ones the mission gives when accepted
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

        // Power exceeds the Threshold
        if (currentPower > currentThreshold) {
            System.out.println(menu.textWithColor("Fim de jogo!", "RED") + " => Limiar máximo ultrapassado"); 
            System.exit(0);               
        } 
        
        // Arrives at Nargumun
        if (currentCity.getName() == "Nargumun") {
            menu.arriveAtNargumunMessage(currentTravelCoins);
            System.exit(0);  
        }

        // Out of Travel Coins
        if (currentTravelCoins < 0) {
            System.out.println(menu.textWithColor("Fim de jogo!", "RED") + " => Maxwell ficou sem Moedas de Transporte");
            System.exit(0);
        }
    }

    // Options related to change, accept, reject or abort a mission
    public void checkMission(City currentCity) {
       
        // Completes mission when arrives on the target City
        if (this.maxwell.isOnMission()) {

            Mission currentMission = this.maxwell.getCurrentMisson();
            if (currentMission.getCityTarget() == currentCity) {
                menu.clearTerminal();
                currentMission.complete(maxwell);
            }
        }

        // Accept/Reject/Change mission menu
        if (currentCity.hasMission) {
            
            menu.acceptMissionMenu(currentCity.getMission());

            ArrayList<Number> options= new ArrayList<Number>();
            options.add(0, 1); //Accept
            options.add(0, 2); //Reject

            int optionInputed = menu.requestInputNumber(options);

            if (optionInputed == 1) {
                
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
    
        // Mission accepted
        this.maxwell.setOnMission(true);
        this.maxwell.setCurrentMisson(maxwellCity.getMission());
    
        // Update Travel Coins 
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
            options.add(0, 1); // Want to change
            options.add(0, 2); // Doesn't want to change

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