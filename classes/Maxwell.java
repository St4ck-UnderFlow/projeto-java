package classes;

public class Maxwell {
    private Double travelCoins;
    private Double power;
    private Misson currentMisson;
    private City currentCity;

    public Double getTravelCoins() {
        return travelCoins;
    }

    public void setTravelCoins(Double travelCoins) {
        this.travelCoins = travelCoins;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
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

    public void travel() {
        System.out.println("Time to travel!");
    }

    public void die() {
        System.out.println("Game Over!");
    }
}
