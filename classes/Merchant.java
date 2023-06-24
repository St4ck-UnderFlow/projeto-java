package classes;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Merchant {
    TreeMap<String, String> rewards;
    Menu menu = new Menu();
    String merchantText = menu.textWithColor("[MERCADOR]", "BLUE");
    
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
        String answearFormated = this.rewards.get(answears.toString());

        if (answearFormated != null) {
    
                int currentTravelCoins = maxwell.getTravelCoins();
                int currentThreshold = maxwell.getCurrentThreshold();
    
                menu.rewardMessage(answearFormated);
                switch (answearFormated) {
                    case "R1":
                        maxwell.setTravelCoins(currentTravelCoins + 2);
                        break;
                    case "R2":
                        maxwell.setTravelCoins(currentTravelCoins - 1);
                        maxwell.setCurrentThreshold(currentThreshold + 2);
                        break;
                    case "R3":
                        maxwell.setTravelCoins(currentTravelCoins - 2);
                        break;
                    case "R4":
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
        
        while(true) {
            try {
                menu.merchantFirstQuestion();
                int answear1 = input.nextInt();

                menu.merchantSecondQuestion();
                int answear2 = input.nextInt();

                if (answear1 >= 5) {
                    answear1 = 1;
                } else {
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