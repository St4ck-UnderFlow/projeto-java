package classes;
import java.util.ArrayList;

public class Map {
    private ArrayList<City> cities;

    
    public Map(ArrayList<City> cities) {
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        this.cities.add(city);;
    }

    public ArrayList<City> getCities() {
        return cities;
    }
    
}