package classes;

import java.util.ArrayList;

public class Game {

    private ArrayList<City> citiesWithFrontiers = new ArrayList<>();

    public City ubud = new City("Ubud",false, false, null, null, 0);

    public City nekika = new City("Principality of Nekikh", false, false, null, null, 1);

    public City legmod = new City("Kingdom of Legmod", false, false, null, null, 2);

    public City gritestar = new City("Principality of Gritesthr", false, false, null, null, 5);

    public City drogove = new City("Protectorate of Dogrove", false, false, null, null, 3);

    public City oldcalia = new City("Kingdom of Oldcalia", false, false, null, null, 4);

    public City lastwatch = new City("Kingdom of Lastwatch", false, false, null, null, -2);

    public City smalia = new City("Grand Duchy of Smalia", false, false, null, null, 1);

    public City defalsia = new City("Defalsia", true, false, null, null, -3);

    public City aymarLeague = new City("Aymar League", true, false, null, null, 1);

    public City kalb = new City("Kingdom of Kalb", false, false, null, null, 2);

    public City vuneseEmpire = new City("Vunese of Empire", true, false, null, null, 0);

    public City karhora = new City("Principality of Karhora", false, false, null, null, -2);

    public City nargumun = new City("Nargumun", true, false, null, null, 0);

    public City bun = new City("Bun", true, false, null, null, 5);

    public City chandirSultanate = new City("Chandir Sultanate", false, false, null, null, 1);

    public City kasya = new City("Principality of Kasya", false, false, null, null, -7);
        
    public Game() {
        
    }

    public void startGame() {
        addNearbyCitiesFrontiers();
        addCitiesWithFrontiersOnMap();
    }

    public void addNearbyCitiesFrontiers() {
        
        // Frontier Ubud
        this.ubud.addNerabyCity(this.legmod);
        this.ubud.addNerabyCity(this.nekika);

        // Frontier Nekika
        this.nekika.addNerabyCity(this.legmod);
        this.nekika.addNerabyCity(this.gritestar);
        this.nekika.addNerabyCity(this.ubud);

        // Frontier Legmod
        this.legmod.addNerabyCity(this.ubud);
        this.legmod.addNerabyCity(this.nekika);
        this.legmod.addNerabyCity(this.gritestar);
        this.legmod.addNerabyCity(this.drogove);
        this.legmod.addNerabyCity(this.oldcalia);

        // Frontier Gritestar
        this.gritestar.addNerabyCity(this.nekika);
        this.gritestar.addNerabyCity(this.drogove);
        this.gritestar.addNerabyCity(this.legmod);
        this.gritestar.addNerabyCity(this.lastwatch);

        // Frontier Drogove
        this.drogove.addNerabyCity(this.legmod);
        this.drogove.addNerabyCity(this.gritestar);
        this.drogove.addNerabyCity(this.lastwatch);
        this.drogove.addNerabyCity(this.oldcalia);

        // Frontier LastWatch
        this.lastwatch.addNerabyCity(this.gritestar);
        this.lastwatch.addNerabyCity(this.drogove);
        this.lastwatch.addNerabyCity(this.smalia);

        // Frontier Smalia
        this.smalia.addNerabyCity(this.lastwatch);
        this.smalia.addNerabyCity(this.oldcalia);

        // Frontier OldCalia
        this.oldcalia.addNerabyCity(this.smalia);
        this.oldcalia.addNerabyCity(this.drogove);
        this.oldcalia.addNerabyCity(this.legmod);
        this.oldcalia.addNerabyCity(this.defalsia);
        this.oldcalia.addNerabyCity(this.aymarLeague);
        this.oldcalia.addNerabyCity(this.kalb);

        // Frontier Defalsia
        this.defalsia.addNerabyCity(this.aymarLeague);
        this.defalsia.addNerabyCity(this.oldcalia);

        // Frontier Kalb
        this.kalb.addNerabyCity(this.oldcalia);
        this.kalb.addNerabyCity(this.aymarLeague);
        this.kalb.addNerabyCity(this.vuneseEmpire);

        // Frontier Aymar League
        this.aymarLeague.addNerabyCity(this.defalsia);
        this.aymarLeague.addNerabyCity(this.oldcalia);
        this.aymarLeague.addNerabyCity(this.kalb);
        this.aymarLeague.addNerabyCity(this.vuneseEmpire);
        this.aymarLeague.addNerabyCity(this.chandirSultanate);
        this.aymarLeague.addNerabyCity(this.bun);
        this.aymarLeague.addNerabyCity(this.nargumun);
        this.aymarLeague.addNerabyCity(this.karhora);

        // Frontier Vunese Empire
        this.vuneseEmpire.addNerabyCity(this.aymarLeague);
        this.vuneseEmpire.addNerabyCity(this.kalb);
        this.vuneseEmpire.addNerabyCity(this.chandirSultanate);

        // Frontier Karhora
        this.karhora.addNerabyCity(this.aymarLeague);
        this.karhora.addNerabyCity(this.nargumun);

        // Frontier Nargumun
        this.nargumun.addNerabyCity(this.karhora);
        this.nargumun.addNerabyCity(this.aymarLeague);
        this.nargumun.addNerabyCity(this.bun);

        // Frontier Bun
        this.bun.addNerabyCity(this.nargumun);
        this.bun.addNerabyCity(this.aymarLeague);
        this.bun.addNerabyCity(this.chandirSultanate);

        // Frontier Chandir Sultanate
        this.chandirSultanate.addNerabyCity(this.vuneseEmpire);
        this.chandirSultanate.addNerabyCity(this.aymarLeague);
        this.chandirSultanate.addNerabyCity(this.bun);
        this.chandirSultanate.addNerabyCity(this.kasya);

        // Frontier Kasya
        this.kasya.addNerabyCity(this.chandirSultanate);
        
    }

    public void addCitiesWithFrontiersOnMap() {
        // this function must be called before addNearbyCitiesFrontiers() function
        this.citiesWithFrontiers.add(this.ubud);
        this.citiesWithFrontiers.add(this.nekika);
        this.citiesWithFrontiers.add(this.legmod);
        this.citiesWithFrontiers.add(this.gritestar);
        this.citiesWithFrontiers.add(this.drogove);
        this.citiesWithFrontiers.add(this.lastwatch);
        this.citiesWithFrontiers.add(this.smalia);
        this.citiesWithFrontiers.add(this.oldcalia);
        this.citiesWithFrontiers.add(this.defalsia);
        this.citiesWithFrontiers.add(this.kalb);
        this.citiesWithFrontiers.add(this.aymarLeague);
        this.citiesWithFrontiers.add(this.vuneseEmpire);
        this.citiesWithFrontiers.add(this.karhora);
        this.citiesWithFrontiers.add(this.nargumun);
        this.citiesWithFrontiers.add(this.bun);
        this.citiesWithFrontiers.add(this.chandirSultanate);
        this.citiesWithFrontiers.add(this.kasya);

        Map map = new Map(this.citiesWithFrontiers);
    }
}
