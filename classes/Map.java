package classes;

public class Map {
    private City[] cities;

    public void addCity(City city) {
        int lastPosition = this.cities.length;
        this.cities[lastPosition] = city;
    }

    public City[] getCities() {
        return cities;
    }
}