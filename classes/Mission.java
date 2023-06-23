package classes;

public class Mission {
    private int travelCoinsToAccept; // prize to accept a misson ( + travel coins)
    private int travelCoinsToComplete; // prize to complete a misson ( + travel coins)
    private int thresholdToComplete; // prize to complete a misson ( + Threshold)
    private String goal; // goal of the mission
    private City cityTarget; // The city Maxwell needs to arive in order to complete the mission
    
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

    public void reward(Maxwell maxwell) {
        int currentTravelCoins = maxwell.getTravelCoins();
        int currentThreshold = maxwell.getCurrentThreshold();
        maxwell.setTravelCoins(currentTravelCoins + this.travelCoinsToComplete);
        maxwell.setCurrentThreshold(currentThreshold + this.thresholdToComplete);
    }

    public void complete(Maxwell maxwell) {
        Mission mission = maxwell.getCurrentMisson();
        System.out.println("Missão de " + mission.getCityTarget().getName() + " finalizada");
        maxwell.getCurrentMisson().reward(maxwell);

        // Reset current mission of Maxwell
        maxwell.setCurrentMisson(null);
        maxwell.setOnMission(false);
    }
}
