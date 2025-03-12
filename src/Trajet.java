public class Trajet {
    private String villeDepart,villeArrivee;
    private double klDepart,klArrivee;
    private Bus busUtilise;




    //contructeur
    public Trajet(String villeDepart, String villeArrivee, double klDepart, double klArrivee) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.klDepart = klDepart;
        this.klArrivee = klArrivee;


    }
    //accesseurs et mutateurs
    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public double getKlDepart() {
        return klDepart;
    }

    public void setKlDepart(double klDepart) {
        this.klDepart = klDepart;
    }

    public double getKlArrivee() {
        return klArrivee;
    }

    public void setKlArrivee(double klArrivee) {
        this.klArrivee = klArrivee;
    }

    public Bus getBusUtilise() {
        return busUtilise;
    }

    public void setBusUtilise(Bus bus) {
        this.busUtilise = bus;
    }
}
