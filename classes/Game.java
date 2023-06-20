package classes;

import java.util.ArrayList;

public class Game {

    public City ubud = new City("Ubud", false, null, null, 0);

    public City nekika = new City("Principality of Nekikh", false, null, null, 1);

    public City legmod = new City("Kingdom of Legmod", false, null, null, 2);

    public City gritestar = new City("Principality of Gritesthr", false, null, null, 5);

    public City drogove = new City("Protectorate of Dogrove", false, null, null, 3);

    public City oldcalia = new City("Kingdom of Oldcalia", false, null, null, 4);

    public City lastwatch = new City("Kingdom of Lastwatch", false, null, null, -2);

    public City smalia = new City("Grand Duchy of Smalia", false, null, null, 1);

    public City defalsia = new City("Defalsia", true, null, null, -3);

    public City aymarLeague = new City("Aymar League", true, null, null, 1);

    public City kalb = new City("Kingdom of Kalb", false, null, null, 2);

    public City vuneseEmpire = new City("Vunese of Empire", true, null, null, 0);

    public City karhora = new City("Principality of Karhora", false, null, null, -2);

    public City nargumun = new City("Nargumun", true, null, null, 0);

    public City bun = new City("Bun", true, null, null, 5);

    public City chandirSultanate = new City("Chandir Sultanate", false, null, null, 1);

    public City kasya = new City("Principality of Kasya", false, null, null, -7);

    public ArrayList<City> cities;
    public Menu menu;
    
        
    public Game() {
        this.cities = new ArrayList<>();
        setCitiesArrayList();
        this.menu = new Menu();
    }

    public void setCitiesArrayList() {
        this.cities.add(this.ubud);
        this.cities.add(this.nekika);
        this.cities.add(this.legmod);
        this.cities.add(this.gritestar);
        this.cities.add(this.drogove);
        this.cities.add(this.oldcalia);
        this.cities.add(this.lastwatch);
        this.cities.add(this.smalia);
        this.cities.add(this.defalsia);
        this.cities.add(this.aymarLeague);
        this.cities.add(this.kalb);
        this.cities.add(this.vuneseEmpire);
        this.cities.add(this.karhora);
        this.cities.add(this.nargumun);
        this.cities.add(this.bun);
        this.cities.add(this.chandirSultanate);
        this.cities.add(this.kasya);
    }


    public void travel(Maxwell maxwell) {
        menu.clearTerminal();
        ArrayList<Frontier> frontiers = maxwell.getCurrentCity().getFrontiers();
        // Código ANSI para cor verde
        String greenColorCode = "\u001B[32m";

        // Código ANSI para resetar a cor
        String resetColorCode = "\u001B[0m";
        System.out.println("Cidade Atual => " +greenColorCode+ maxwell.getCurrentCity().getName()+resetColorCode);
        System.out.println(" ");
        System.out.println("+=== CIDADES FONTEIRA ===+");
        for (int i = 0; i < frontiers.size(); i++) {
            System.out.println((i + 1) +  "- " + frontiers.get(i).getDestination().getName() + " | Ganho de Poder => " + frontiers.get(i).getPower());
        }
    }

    public void startGame() {
        setFrontiers();
    }

    public void setFrontiers() {
        
        // Frontiers Ubud
        this.ubud.addFrontier(this.legmod, 2);
        this.ubud.addFrontier(this.nekika, 1);

        // Frontiers Nekika
        this.nekika.addFrontier(this.legmod, 2);
        this.nekika.addFrontier(this.gritestar, 5);
        this.nekika.addFrontier(this.ubud, 0);

        // Frontiers Legmod
        this.legmod.addFrontier(this.ubud, 0);
        this.legmod.addFrontier(this.nekika, 1);
        this.legmod.addFrontier(this.gritestar, 5);
        this.legmod.addFrontier(this.drogove, 3);
        this.legmod.addFrontier(this.oldcalia, 4);

        // Frontiers Gritestar
        this.gritestar.addFrontier(this.nekika, 1);
        this.gritestar.addFrontier(this.drogove, 3);
        this.gritestar.addFrontier(this.legmod, 2);
        this.gritestar.addFrontier(this.lastwatch, -2);

        // Frontiers Drogove
        this.drogove.addFrontier(this.legmod, 2);
        this.drogove.addFrontier(this.gritestar, 5);
        this.drogove.addFrontier(this.lastwatch, -2);
        this.drogove.addFrontier(this.oldcalia, 4);

        // Frontiers LastWatch
        this.lastwatch.addFrontier(this.gritestar, -5);
        this.lastwatch.addFrontier(this.drogove, 3);
        this.lastwatch.addFrontier(this.smalia, 1);

        // Frontiers Smalia
        this.smalia.addFrontier(this.lastwatch, -2);
        this.smalia.addFrontier(this.oldcalia, 4);

        // Frontiers OldCalia
        this.oldcalia.addFrontier(this.smalia, 1);
        this.oldcalia.addFrontier(this.drogove, 3);
        this.oldcalia.addFrontier(this.legmod, 2);
        this.oldcalia.addFrontier(this.defalsia, -3);
        this.oldcalia.addFrontier(this.aymarLeague, 1);
        this.oldcalia.addFrontier(this.kalb, 2);

        // Frontiers Defalsia
        this.defalsia.addFrontier(this.aymarLeague, 1);
        this.defalsia.addFrontier(this.oldcalia, 4);

        // Frontiers Kalb
        this.kalb.addFrontier(this.oldcalia, 4);
        this.kalb.addFrontier(this.aymarLeague, 1);
        this.kalb.addFrontier(this.vuneseEmpire, 0);

        // Frontiers Aymar League
        this.aymarLeague.addFrontier(this.defalsia, -3);
        this.aymarLeague.addFrontier(this.oldcalia, 4);
        this.aymarLeague.addFrontier(this.kalb, 2);
        this.aymarLeague.addFrontier(this.vuneseEmpire, 0);
        this.aymarLeague.addFrontier(this.chandirSultanate, 1);
        this.aymarLeague.addFrontier(this.bun, 5);
        this.aymarLeague.addFrontier(this.nargumun, 0);
        this.aymarLeague.addFrontier(this.karhora, -2);

        // Frontiers Vunese Empire
        this.vuneseEmpire.addFrontier(this.aymarLeague, 1);
        this.vuneseEmpire.addFrontier(this.kalb, 2);
        this.vuneseEmpire.addFrontier(this.chandirSultanate, 1);

        // Frontiers Karhora
        this.karhora.addFrontier(this.aymarLeague, 1);
        this.karhora.addFrontier(this.nargumun, 0);

        // FrontiersNargumun
        this.nargumun.addFrontier(this.karhora, -2);
        this.nargumun.addFrontier(this.aymarLeague, 1);
        this.nargumun.addFrontier(this.bun, 5);

        // Frontiers Bun
        this.bun.addFrontier(this.nargumun, 0);
        this.bun.addFrontier(this.aymarLeague, 1);
        this.bun.addFrontier(this.chandirSultanate, 1);

        // Frontiers Chandir Sultanate
        this.chandirSultanate.addFrontier(this.vuneseEmpire, 0);
        this.chandirSultanate.addFrontier(this.aymarLeague, 1);
        this.chandirSultanate.addFrontier(this.bun, 5);
        this.chandirSultanate.addFrontier(this.kasya, -7);

        // Frontier Kasya
        this.kasya.addFrontier(this.chandirSultanate, 1);
        
    }
}
