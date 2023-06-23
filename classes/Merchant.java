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

    public void giveReward(StringBuilder answears) {

        String answearFormated = this.rewards.get(answears.toString());

        if (answearFormated != null) {
            //System.out.println("Sua recompensa é: " + recompensa);
            switch (answearFormated) {
            case "R1":
                System.out.println("[MERCADOR] Você ganhou 2 moedas de transporte !!");
                break;
            case "R2":
                System.out.println("[MERCADOR] Você ganhou 2 de limiar e perdeu 1 moeda de transporte !!");
                break;
            case "R3":
                System.out.println("[MERCADOR] Você perdeu 2 moedas de transporte !!");
                break;
            case "R4":
                System.out.println("[MERCADOR] Você perdeu 2 moedas de transporte e ganhou 2 de limiar !!");
                break;
            default:
                System.out.println("Recompensa inválida");
                break;
            }
        } else {
            System.out.println("Não há recompensa correspondente para as respostas fornecidas.");
        }
    }
    

    public StringBuilder askQuestions() {
        Scanner input = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("[MERCADOR] Quantas moedas de transporte você tem?");
                int answear1 = input.nextInt();

                System.out.println("[MERCADOR] Quer trocar moeda por poder? (1 - SIM) (0 - NAO) ");
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
                System.out.println("Opção Inválida");
            }
        }
    }

}