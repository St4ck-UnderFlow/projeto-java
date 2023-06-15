package classes;

public class Maxwell {
    private int travelCoins;
    private int power;
    private Mission currentMisson;
    private City currentCity;
    private String goal;
    private int currentPower;
    private int maximumPower;

    public Maxwell() {
        this.goal = "Getting to the town of Nargumun";
    }

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

    public Mission getCurrentMisson() {
        return currentMisson;
    }

    public void setCurrentMisson(Mission currentMisson) {
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

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int standartPower) {
        this.currentPower = standartPower;
    }

    public int getMaximumPower() {
        return maximumPower;
    }

    public void setMaximumPower(int maximumPower) {
        this.maximumPower = maximumPower;
    }

    
}
