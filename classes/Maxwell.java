package classes;

public class Maxwell {
    private int travelCoins;
    private int power;
    private Misson currentMisson;
    private City currentCity;
    private String goal;

    public int getTravelCoins() {
        return travelCoins;
    }

    public void setTravelCoins(int travelCoins) {
        this.travelCoins = travelCoins;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Misson getCurrentMisson() {
        return currentMisson;
    }

    public void setCurrentMisson(Misson currentMisson) {
        this.currentMisson = currentMisson;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public String getGoal() {
        return goal;
    }

    public void travel() {
        System.out.println("Time to travel!");
    }

    public void die() {
        System.out.println("Game Over!");
    }

}
