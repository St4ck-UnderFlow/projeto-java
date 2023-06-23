package classes;

import java.util.TreeMap;

public class Merchant {
    private String[] questions;
    private City city;
    private int coins;
    
    public Merchant(String[] questions, City city, int coins) {
        this.questions = questions;
        this.city = city;
        this.coins = coins;
    }

    public String[] getQuestions() {
        return questions;
    }

    public City getCity() {
        return city;
    }

    public int getCoins() {
        return coins;
    }

    public void askQuestions() {

    }

    public void giveCoins() {

    }
    
}