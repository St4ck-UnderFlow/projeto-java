package classes;

public class Mission {
    private int travelCoinsToAccept; // prize to accept a misson ( + travel coins)
    private int travelCoinsToComplete; // prize to complete a misson ( + travel coins)
    private int thresholdToComplete; // prize to complete a misson ( + Threshold)
    private String goal; // goal of the mission
    private City cityTarget;
    
    public Mission(int travelCoinsToAccept, int travelCoinsToComplete, int thresholdToComplete, String goal, City cityTarget) {
        this.travelCoinsToAccept = travelCoinsToAccept;
        this.travelCoinsToComplete = travelCoinsToComplete;
        this.thresholdToComplete = thresholdToComplete;
        this.goal = goal;
        this.cityTarget = cityTarget;
    }

    public int getTravelCoinsToAccept() {
        return travelCoinsToAccept;
    }

    public int getTravelCoinsToComplete() {
        return travelCoinsToComplete;
    }

    public int getThresholdToComplete() {
        return thresholdToComplete;
    }

    public String getGoal() {
        return goal;
    }

    public City getCityTarget() {
        return cityTarget;
    }
}
