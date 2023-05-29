package classes;

public class City {
    private String name;
    private String[] nearByCities;
    public boolean hasMission;
    public boolean alreadyVisited;
    private String[] rules;

    public City(String name, String[] nearByCities, boolean hasMission, boolean alreadyVisited, String[] rules) {
        this.name = name;
        this.nearByCities = nearByCities;
        this.hasMission = hasMission;
        this.alreadyVisited = alreadyVisited;
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNearByCities() {
        return nearByCities;
    }

    public String[] getRules() {
        return rules;
    }
}
