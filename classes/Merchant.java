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
        // Generate a binary answear, Ex: 01 (left and right)
        String answearFormated = this.rewards.get(answears.toString());

        if (answearFormated != null) {
    
                int currentTravelCoins = maxwell.getTravelCoins();
                int currentThreshold = maxwell.getCurrentThreshold();
    
                menu.rewardMessage(answearFormated);
                switch (answearFormated) {
                    case "R1":
                        // binary answear: 00
                        maxwell.setTravelCoins(currentTravelCoins + 2);
                        break;
                    case "R2":
                        // binary answear: 01
                        maxwell.setTravelCoins(currentTravelCoins - 1);
                        maxwell.setCurrentThreshold(currentThreshold + 2);
                        if (maxwell.getTravelCoins() < 0) {
                            maxwell.setTravelCoins(0);
                        }
                        break;
                    case "R3":
                        // binary answear: 10
                        maxwell.setTravelCoins(currentTravelCoins - 2);
                        if (maxwell.getTravelCoins() < 0) {
                            maxwell.setTravelCoins(0);
                        }
                        break;
                    case "R4":
                        // binary answear: 11
                        maxwell.setTravelCoins(currentTravelCoins - 2);
                        maxwell.setCurrentThreshold(currentThreshold + 2);
                        if (maxwell.getTravelCoins() < 0) {
                            maxwell.setTravelCoins(0);
                        }
                        break;
                    default:
                        System.out.println(" ");
                        System.out.println("Recompensa inválida");
                        break;
                }
            } else {
                System.out.println(" ");
                System.out.println(merchantText + menu.textWithColor(" VOCÊ NÃO ESTÁ PERMITIDO À MENTIR PARA MIM", "RED"));
                System.out.println(menu.textWithColor("Você retornou para Ubud e suas informações foram atulizadas", "YELLOW"));
                throw new InputMismatchException(null);
            }
    }
    
    public StringBuilder askQuestions(Maxwell maxwell, City ubub) {
        Scanner input = new Scanner(System.in);
        
        while(true) {
            try {
                menu.merchantFirstQuestion();
                int answear1 = input.nextInt();

                menu.merchantSecondQuestion();
                int answear2 = input.nextInt();


                if (answear1 != maxwell.getTravelCoins() + 1) {
                    maxwell.merchantPunishmentWhenPlayerLies(ubub);
                } else if (answear1 >= 5) {
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