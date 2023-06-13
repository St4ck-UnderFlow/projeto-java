package classes;
import java.util.ArrayList;

public class Map {
    private ArrayList<City> cities = new ArrayList<>();

    public Map(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<City> getCities() {
        return cities;
    }
    
}