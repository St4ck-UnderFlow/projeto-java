package classes;

public class Mission {
    private int rewardToAccept;
    private int rewardToComplete;
    private String goal;

    public Mission(int rewardToAccept, int rewardToComplete, String goal) {
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
