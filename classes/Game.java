package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public Menu menu;
    public Maxwell maxwell;
    public Map map;

    public Game(Maxwell maxwell) {
        this.map = new Map();
        this.menu = new Menu();
        this.maxwell = maxwell;
        this.maxwell.setCurrentCity(map.ubud);
    }

    public void travel() {
        
        try {
            Scanner input = new Scanner(System.in);
    
            menu.clearTerminal();
            ArrayList<Frontier> frontiers = this.maxwell.getCurrentCity().getFrontiers();
            menu.travelMenu(frontiers, this.maxwell.getCurrentCity(), this.maxwell.getPower());
    
            // system ask which city the player wants to goa
            System.out.println(" ");
            System.out.println("<< PARA QUAL CIDADE DESEJA VIAJAR ?");
            int cityIndexChoiceInput = input.nextInt();
            
            // users options start with 1 and the array`indexs start with 0
            Frontier frontierChoosen = frontiers.get(cityIndexChoiceInput - 1);
            this.maxwell.setCurrentCity(frontierChoosen.getDestination());

            powerSync(this.maxwell.getCurrentCity().getPowerUp());
            checkGameOver();
    
        } catch (IndexOutOfBoundsException error) {
            System.out.println("NORIET ... Tente um valor de fronteira valido");
        }

    }

    public void startGame() {
        userOptions(this.maxwell);
    }

    public void userOptions(Maxwell maxwell) {

        Scanner input = new Scanner(System.in);
        boolean validOption = true;

        while (validOption) {
            menu.defaultMenu(this.maxwell);
            menu.optionsMenu();
            try {
                int option = input.nextInt();

                if (option == 1) {
                    // [1] Viajar
                    System.out.println(" ");
                    travel();
                    continue;

                } else if (option == 2) {

                    // [2] Sair do jogo
                    menu.clearTerminal();
                    System.out.println("OBRIGADO POR JOGAR NOSSO JOGUINHO, ATÉ MAIS :)");
                    System.exit(0);
                    validOption = false;

                } else {
                    menu.clearTerminal();
                    System.out.println("Valor Invalido, digitar um valor adequado");
                }

            } catch(InputMismatchException error) {
                input.next(); // Discard invalid input
                continue;
            }
        }
        input.close();
    }

    public void powerSync(int power) {
        int currentPower = this.maxwell.getPower();
        int currentPowerUptaded = currentPower + power;

        if (currentPowerUptaded <= 0) {
            this.maxwell.setPower(0);
        } else {
            this.maxwell.setPower(currentPower + power);
        } 
    }

    public void checkGameOver() {
        // this function check all the possibilities to game over 
        
        int currentPower = this.maxwell.getPower();
        int currentThreshold = this.maxwell.getCurrentThreshold();
        int currentTravelCoins = this.maxwell.getTravelCoins();

        City currentCity = this.maxwell.getCurrentCity();

        if(currentPower > currentThreshold) {
            System.out.println("Fim de jogo! => Limiar máximo ultrapassado");
            System.exit(0);               
        } 
        
        if (currentCity.getName() == "Nargumun" && currentTravelCoins < 4) {
            System.out.println("Fim de jogo! => Maxwell chegou em Nargumun, mas foi alocado como servo");
            System.exit(0);    
        }

        if (currentTravelCoins <= 0) {
            System.out.println("Fim de Jogo ! => Maxwell ficou sem Moedas de Transporte");
            System.exit(0);
        }
    }
}