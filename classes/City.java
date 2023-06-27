package classes;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Frontier> frontiers;
    public boolean hasMission;
    private Merchant merchant;
    private int powerUp;
    private Mission mission;

    public City(String name, boolean hasMission, Merchant merchant, int powerUp) {
        this.name = name;
        this.frontiers = new ArrayList<Frontier>();
        this.hasMission = hasMission;
        this.merchant = merchant;
        this.powerUp = powerUp;
        this.merchant = new Merchant();
    }

    public String getName() {
        return name;
    }

    public Merchant getMerchant() {
        return merchant;
    }
 
    public ArrayList<Frontier> getFrontiers() {
        return frontiers;
    }
    
    public int getPowerUp() {
        return powerUp;
    }
    
    public Mission getMission() {
        return mission;
    }
    
    public void setMission(Mission mission) {
        this.mission = mission;
    }
    
    // Makes it impossible for the player to get the missions he already completed or abandoned again
    public void blockGetMissionAgain() {
        if(this.hasMission) {
            setMission(null);
            hasMission = false;
        }
    }
    
    // Create a new border that connects two cities
    public void addFrontier(City city, int powerUp) {
        Frontier frontier = new Frontier(city, powerUp);
        this.frontiers.add(frontier);
    }
}
