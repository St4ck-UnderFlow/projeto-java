package classes;

public class Misson {
    private Double rewardToAccept;
    private Double rewardToComplete;
    private String goal;

    public Misson(Double rewardToAccept, Double rewardToComplete, String goal) {
        this.rewardToAccept = rewardToAccept;
        this.rewardToComplete = rewardToComplete;
        this.goal = goal;
    }

    public Double getRewardToAccept() {
        return rewardToAccept;
    }

    public Double getRewardToComplete() {
        return rewardToComplete;
    }

    public String getGoal() {
        return goal;
    }
}
