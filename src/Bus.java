public class Bus {
    private  Chauffeur chauffeur;
    private String numImm,couleur;
    private double capReservoir;
    private int nbrePassagers;

    private Trajet trajet;
    //costructeur
    public Bus(String numImm, String couleur, double capReservoir, int nbrePassagers) {
        this.numImm = numImm;
        this.couleur = couleur;
        this.capReservoir = capReservoir;
        this.nbrePassagers = nbrePassagers;
    }
    //accesseurs et mutateurs
    public String getNumImm() {
        return numImm;
    }

    public void setNumImm(String numImm) {
        this.numImm = numImm;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public double getCapReservoir() {
        return capReservoir;
    }

    public void setCapReservoir(double capReservoir) {
        this.capReservoir = capReservoir;
    }

    public int getNbrePassagers() {
        return nbrePassagers;
    }

    public void setNbrePassagers(int nbrePassagers) {
        this.nbrePassagers = nbrePassagers;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "chauffeur=" + chauffeur +
                ", numImm='" + numImm + '\'' +
                ", couleur='" + couleur + '\'' +
                ", capReservoir=" + capReservoir +
                ", nbrePassagers=" + nbrePassagers +
                ", trajet=" + trajet +
                '}';
    }
}
