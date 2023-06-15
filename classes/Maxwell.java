package classes;

public class Maxwell {
    private int travelCoins;
    private int power;
    private Mission currentMisson;
    private String currentCity;
    private String goal;
    private int currentThreshold;
    private int maximumThreshold;

    public Maxwell() {
        this.goal = "Getting to the town of Nargumun";
        this.power = 0;
        this.currentThreshold = 7;
        this.currentCity = "Ubud";
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

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
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

    public int getCurrentThreshold() {
        return currentThreshold;
    }

    public void setCurrentThreshold(int currentThreshold) {
        this.currentThreshold = currentThreshold;
    }

    public int getMaximumThreshold() {
        return maximumThreshold;
    }

    public void setMaximumThreshold(int maximumThreshold) {
        this.maximumThreshold = maximumThreshold;
    }

}
