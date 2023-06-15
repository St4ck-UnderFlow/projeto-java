package classes;

import java.util.ArrayList;

public class Game {

    private ArrayList<City> citiesWithFrontiers = new ArrayList<>();

    private City ubub = new City("Ubub",false, false, null, null);

    private City nekika = new City("Nekika", false, false, null, null);

    private City legmod = new City("Legmod", false, false, null, null);

    private City gritestar = new City("Gritestar", false, false, null, null);

    private City drogove = new City("Dogrove", false, false, null, null);

    private City oldcalia = new City("Oldcalia", false, false, null, null);

    private City lastwatch = new City("Lastwatch", false, false, null, null);

    private City smalia = new City("Smalia", false, false, null, null);

    private City defalsia = new City("Defalsia", true, false, null, null);

    private City aymarLeague = new City("Aymar League", true, false, null, null);

    private City kalb = new City("Kalb", false, false, null, null);

    private City vuneseEmpire = new City("Vunese Empire", true, false, null, null);

    private City karhora = new City("Karhora", false, false, null, null);

    private City nargumun = new City("Nargumun", true, false, null, null);

    private City bun = new City("Bun", true, false, null, null);

    private City chandirSultanate = new City("Chandir Sultanate", false, false, null, null);

    private City kasya = new City("Kasya", false, false, null, null);
        
    public Game() {
        addNearbyCitiesFrontiers();
        addCitiesWithFrontiersOnMap();
    }

    public void addNearbyCitiesFrontiers() {
        
        // Frontier Ubud
        this.ubub.addNerabyCity(this.legmod);
        this.ubub.addNerabyCity(this.nekika);

        // Frontier Nekika
        this.nekika.addNerabyCity(this.legmod);
        this.nekika.addNerabyCity(this.gritestar);
        this.nekika.addNerabyCity(this.ubub);

        // Frontier Legmod
        this.legmod.addNerabyCity(this.ubub);
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
        this.citiesWithFrontiers.add(this.ubub);
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
