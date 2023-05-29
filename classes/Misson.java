package classes;

public class Misson {
    private int rewardToAccept;
    private int rewardToComplete;
    private String goal;

    public Misson(int rewardToAccept, int rewardToComplete, String goal) {
        this.rewardToAccept = rewardToAccept;
        this.rewardToComplete = rewardToComplete;
        this.goal = goal;
    }

    public int getRewardToAccept() {
        return rewardToAccept;
    }

    public int getRewardToComplete() {
        return rewardToComplete;
    }

    public String getGoal() {
        return goal;
    }
}
