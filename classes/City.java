package classes;

public class City {
    private String name;
    private String[] nearbyCities;
    public boolean hasMission;
    public boolean alreadyVisited;
    private String[] rules;
    private Merchant merchant;

    public City(String name, String[] nearbyCities, boolean hasMission, boolean alreadyVisited, String[] rules, Merchant merchant) {
        this.name = name;
        this.nearbyCities = nearbyCities;
        this.hasMission = hasMission;
        this.alreadyVisited = alreadyVisited;
        this.rules = rules;
        this.merchant = merchant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public String[] getNearbyCities() {
        return nearbyCities;
    }

    public String[] getRules() {
        return rules;
    }
}
