package classes;

public class Map {
    public City ubud = new City("Ubud", false, null, 0);

    public City nekika = new City("Principality of Nekikh", false, null, 1);

    public City legmod = new City("Kingdom of Legmod", false, null, 2);

    public City gritestar = new City("Principality of Gritesthr", false, null, 5);

    public City drogove = new City("Protectorate of Dogrove", false, null, 3);

    public City oldcalia = new City("Kingdom of Oldcalia", false, null, 4);

    public City lastwatch = new City("Kingdom of Lastwatch", false, null, -2);

    public City smalia = new City("Grand Duchy of Smalia", false, null, 1);

    public City defalsia = new City("Defalsia", true, null, -3);

    public City aymarLeague = new City("Aymar League", false, null, 1);

    public City kalb = new City("Kingdom of Kalb", true, null, 2);

    public City vuneseEmpire = new City("Vunese of Empire", true, null, 0);

    public City karhora = new City("Principality of Karhora", false, null, -2);

    public City nargumun = new City("Nargumun", false, null, 0);

    public City bun = new City("Bun", false, null, 5);

    public City chandirSultanate = new City("Chandir Sultanate", false, null, 1);

    public City kasya = new City("Principality of Kasya", false, null, -7);


    public Map() { 
        setFrontiers();
        setMissionsToCities();
    }

    public void setFrontiers() {
        
        // Frontiers of Ubud
        this.ubud.addFrontier(this.legmod, 2);
        this.ubud.addFrontier(this.nekika, 1);

        // Frontiers of Nekika
        this.nekika.addFrontier(this.legmod, 2);
        this.nekika.addFrontier(this.gritestar, 5);
        this.nekika.addFrontier(this.ubud, 0);

        // Frontiers of Legmod
        this.legmod.addFrontier(this.ubud, 0);
        this.legmod.addFrontier(this.nekika, 1);
        this.legmod.addFrontier(this.gritestar, 5);
        this.legmod.addFrontier(this.drogove, 3);
        this.legmod.addFrontier(this.oldcalia, 4);

        // Frontiers of Gritestar
        this.gritestar.addFrontier(this.nekika, 1);
        this.gritestar.addFrontier(this.drogove, 3);
        this.gritestar.addFrontier(this.legmod, 2);
        this.gritestar.addFrontier(this.lastwatch, -2);

        // Frontiers of Drogove
        this.drogove.addFrontier(this.legmod, 2);
        this.drogove.addFrontier(this.gritestar, 5);
        this.drogove.addFrontier(this.lastwatch, -2);
        this.drogove.addFrontier(this.oldcalia, 4);

        // Frontiers of LastWatch
        this.lastwatch.addFrontier(this.gritestar, 5);
        this.lastwatch.addFrontier(this.drogove, 3);
        this.lastwatch.addFrontier(this.smalia, 1);
        this.lastwatch.addFrontier(this.oldcalia, 4);

        // Frontiers of Smalia
        this.smalia.addFrontier(this.lastwatch, -2);
        this.smalia.addFrontier(this.oldcalia, 4);

        // Frontiers of OldCalia
        this.oldcalia.addFrontier(this.smalia, 1);
        this.oldcalia.addFrontier(this.drogove, 3);
        this.oldcalia.addFrontier(this.legmod, 2);
        this.oldcalia.addFrontier(this.defalsia, -3);
        this.oldcalia.addFrontier(this.aymarLeague, 1);
        this.oldcalia.addFrontier(this.kalb, 2);
        this.oldcalia.addFrontier(this.lastwatch, -2);

        // Frontiers of Defalsia
        this.defalsia.addFrontier(this.aymarLeague, 1);
        this.defalsia.addFrontier(this.oldcalia, 4);

        // Frontiers of Kalb
        this.kalb.addFrontier(this.oldcalia, 4);
        this.kalb.addFrontier(this.aymarLeague, 1);
        this.kalb.addFrontier(this.vuneseEmpire, 0);

        // Frontiers of Aymar League
        this.aymarLeague.addFrontier(this.defalsia, -3);
        this.aymarLeague.addFrontier(this.oldcalia, 4);
        this.aymarLeague.addFrontier(this.kalb, 2);
        this.aymarLeague.addFrontier(this.vuneseEmpire, 0);
        this.aymarLeague.addFrontier(this.chandirSultanate, 1);
        this.aymarLeague.addFrontier(this.bun, 5);
        this.aymarLeague.addFrontier(this.nargumun, 0);
        this.aymarLeague.addFrontier(this.karhora, -2);

        // Frontiers of Vunese Empire
        this.vuneseEmpire.addFrontier(this.aymarLeague, 1);
        this.vuneseEmpire.addFrontier(this.kalb, 2);
        this.vuneseEmpire.addFrontier(this.chandirSultanate, 1);

        // Frontiers of Karhora
        this.karhora.addFrontier(this.aymarLeague, 1);
        this.karhora.addFrontier(this.nargumun, 0);

        // Frontiers of Nargumun
        this.nargumun.addFrontier(this.karhora, -2);
        this.nargumun.addFrontier(this.aymarLeague, 1);
        this.nargumun.addFrontier(this.bun, 5);

        // Frontiers of Bun
        this.bun.addFrontier(this.nargumun, 0);
        this.bun.addFrontier(this.aymarLeague, 1);
        this.bun.addFrontier(this.chandirSultanate, 1);

        // Frontiers of Chandir Sultanate
        this.chandirSultanate.addFrontier(this.vuneseEmpire, 0);
        this.chandirSultanate.addFrontier(this.aymarLeague, 1);
        this.chandirSultanate.addFrontier(this.bun, 5);
        this.chandirSultanate.addFrontier(this.kasya, -7);

        // Frontier of Kasya
        this.kasya.addFrontier(this.chandirSultanate, 1);
        
    }

    // Sets missions on the wanted cities
    public void setMissionsToCities() {
        Mission kalbMission = new Mission(4, 2, 2, "Vá para a cidade de Grand Duchy of Smalia e receba as Luvas Do Poder !!!!", smalia);

        Mission defalsiaMission = new Mission(6, 3, 1, "Vá para a cidade de Principality of Kasya e receba as Botas Do Poder !!!!", kasya);

        Mission vuneseMission = new Mission(1, 10, -4, "Vá para a cidade de Ubud e receba a Glória Dos Retornados !!!!", ubud);

        this.kalb.setMission(kalbMission); 
        this.defalsia.setMission(defalsiaMission);
        this.vuneseEmpire.setMission(vuneseMission);
    }

}
