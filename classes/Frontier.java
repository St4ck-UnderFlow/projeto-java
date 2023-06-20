package classes;

public class Frontier {
    City destination;
    int power;

    // Function that creates a "road" between two citys
    public Frontier(City destination, int power) {
        this.destination = destination;
        this.power = power;
    }
}
