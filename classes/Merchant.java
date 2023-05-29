package classes;

public class Merchant {
    private String[] questions;
    private City city;
    private Double coins;
    
    public Merchant(String[] questions, City city, Double coins) {
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

    public Double getCoins() {
        return coins;
    }

    public void askQuestions() {

    }

    public void giveCoins() {

    }
    
}