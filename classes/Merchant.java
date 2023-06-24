package classes;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Merchant {
    TreeMap<String, String> rewards;
    
    public Merchant() {
        createTreeMap();
    }

    public void createTreeMap() {
        this.rewards= new TreeMap<>();
        this.rewards.put("00", "R1");
        this.rewards.put("01", "R2");
        this.rewards.put("10", "R3");
        this.rewards.put("11", "R4");
    }

    public void giveReward(StringBuilder answears, Maxwell maxwell) {
        String greenColorCode = "\u001B[32m";
        String redColorCode = "\u001B[31m";
        String blueColorCode = "\u001B[34m";
        String resetColorCode = "\u001B[0m";
        String merchantTitle = blueColorCode + "[MERCADOR]" + resetColorCode;

        String answearFormated = this.rewards.get(answears.toString());

        if (answearFormated != null) {
    
                int currentTravelCoins = maxwell.getTravelCoins();
                int currentThreshold = maxwell.getCurrentThreshold();
    
                switch (answearFormated) {
                case "R1":
                    System.out.println(" ");
                    System.out.println(merchantTitle + "Você ganhou "+greenColorCode+"2 Moedas de Transporte " +resetColorCode+ "!!");
                    System.out.println(" ");
    
                    maxwell.setTravelCoins(currentTravelCoins + 2);
                    break;
                case "R2":
                    System.out.println(" ");
                    System.out.println(merchantTitle + "Você ganhou " +greenColorCode+ "2 de Limiar de Poder " +resetColorCode+ "e perdeu " +redColorCode+ "1 Moeda de Transporte "+resetColorCode+"!!");
                    System.out.println(" ");
    
                    maxwell.setTravelCoins(currentTravelCoins - 1);
                    maxwell.setCurrentThreshold(currentThreshold + 2);
                    break;
                case "R3":
                    System.out.println(" ");
                    System.out.println(merchantTitle + " Você perdeu " +redColorCode+ "2 Moedas de Transporte " +resetColorCode+ "!!");
                    System.out.println(" ");
    
                    maxwell.setTravelCoins(currentTravelCoins - 2);
                    break;
                case "R4":
                    System.out.println(" ");
                    System.out.println(merchantTitle + " Você perdeu " +redColorCode+ "2 Moedas de Transporte " +resetColorCode+ "e ganhou " +greenColorCode+ "2 de Limiar de Poder" +resetColorCode+ " !!");
                    System.out.println(" ");
    
                    maxwell.setTravelCoins(currentTravelCoins - 2);
                    maxwell.setCurrentThreshold(currentThreshold + 2);
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Recompensa inválida");
                    break;
                }
            } else {
                System.out.println(" ");
                System.out.println("Não há recompensa correspondente para as respostas fornecidas.");
                throw new InputMismatchException(null);
            }
    }
    

    public StringBuilder askQuestions() {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();

        String greenColorCode = "\u001B[32m";
        String resetColorCode = "\u001B[0m";
        String blueColorCode = "\u001B[34m";


        while(true) {
            try {
                System.out.println("==================================================");
                System.out.println(blueColorCode+"[MERCADOR] " +resetColorCode+ "Quantas moedas de transporte você tem?");
                System.out.println("==================================================");
                System.out.println(" ");
                System.out.println("<< DIGITE O VALOR >>");
                int answear1 = input.nextInt();

                System.out.println("==================================================");
                System.out.println(blueColorCode+"[MERCADOR] " +resetColorCode+ "Quer trocar moeda por poder?");
                System.out.println("==================================================");
                System.out.println("[1] - SIM");
                System.out.println("[0] - NAO");
                System.out.println("==================================================");
                System.out.println(" ");
                System.out.println("<< SELECIONE A OPÇÃO DESEJADA >>");
                int answear2 = input.nextInt();

                if (answear1 >= 5) {
                    answear1 = 1;
                }else {
                    answear1 = 0;
                }

                if (answear2 != 0 && answear2 != 1) {
                    throw new InputMismatchException(null);
                }


                StringBuilder answears = new StringBuilder();
                answears.append(answear1).append(answear2);

                return answears;

            } catch(InputMismatchException error) {
                menu.clearTerminal();
                System.out.println("Opção Inválida");
                input.next();
                continue;
            }
        }
    }

}