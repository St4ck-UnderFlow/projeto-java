package classes;

public class Maxwell {
    private int travelCoins;
    private int power;
    private Mission currentMisson;
    private City currentCity;
    private String goal;
    private int currentThreshold;
    private boolean onMission;

    public Maxwell() {
        this.goal = "Chegar até a cidade de Nargumun e NÃO ser alocado como Servo"; // The Main Objective of Maxwell's Journey
        this.power = 0; // The power Maxwell has currently (if this exceeds the currentThreshold, he dies)
        this.currentThreshold = 7; // The current threshold of Maxwell, it may change during his journey 
        this.travelCoins = 3; // Amount of coins Maxwell currently holds (he starts with 3 coins)
        this.onMission = false;
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
        return this.currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public String getGoal() {
        return goal;
    }

    public int getCurrentThreshold() {
        return currentThreshold;
    }

    public void setCurrentThreshold(int currentThreshold) {
        this.currentThreshold = currentThreshold;
    }

    public boolean isOnMission() {
        return onMission;
    }

    public void setOnMission(boolean onMission) {
        this.onMission = onMission;
    }

}