import java.util.Arrays;

public class Companie {
    private String nomCompanie;

    private Chauffeur[] chauffeur;
    private Bus[] bus;

    int count = 0;

    private int nbChauffeurs ;
    private int nbBus ;
    private int nbMaxBus=100;
    //constructeur
    public Companie(String nomCompanie, int maxChauffeurs, int maxBus) {
        this.nomCompanie = nomCompanie;
        this.chauffeur = new Chauffeur[Math.max(1,maxChauffeurs)];
        this.bus = new Bus[Math.max(1,maxBus)];
        nbChauffeurs = 0;
        nbBus = 0;
    }
    //accesseurs et mutateurs
    public String getNomCompanie() {
        return nomCompanie;
    }

    public void setNomCompanie(String nomCompanie) {
        this.nomCompanie = nomCompanie;
    }

    public Chauffeur[] getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur[] chauffeur) {
        this.chauffeur = Arrays.stream(chauffeur).filter(java.util.Objects::nonNull).toArray(Chauffeur[]::new);
        this.nbChauffeurs = this.chauffeur.length;
    }

    public Bus[] getBus() {
        return bus;
    }

    public void setBus(Bus[] bus) {
        this.bus = Arrays.stream(bus).filter(java.util.Objects::nonNull).toArray(Bus[]::new);
        this.nbBus = this.bus.length;
    }

    //methode pour verifier si le chauffeur existe deja
    public boolean redondenceChaffeur(String idChauffeur){
        for (int i = 0; i < nbChauffeurs; i++) {
            if (chauffeur[i].getNumId().equals(idChauffeur)) {
                return true;
            }
        }
        return false;
    }

    //methode pour verifier si le bus existe deja
    public boolean redondenceBus(String imm){
        for (int i = 0; i < nbBus; i++) {
            if (bus[i].getNumImm().equals(imm)) {
                return true;
            }
        }
        return false;
    }

    //methede pour ajouter un chaffeur
    public void ajouterChauffeur(Chauffeur nouveauChauffeur) throws ErreurException {
        if (redondenceChaffeur(nouveauChauffeur.getNumId())){
            throw new ErreurException("ce chauffeur existe deja");
        }
        if (nbChauffeurs >= chauffeur.length) {
            //agrandir le tableau si plein
            Chauffeur[] nouveauTableau = new Chauffeur[Math.max(1,chauffeur.length * 2)];
            System.arraycopy(chauffeur, 0, nouveauTableau, 0, chauffeur.length);
            chauffeur= nouveauTableau;
        }
        chauffeur[nbChauffeurs++] = nouveauChauffeur;

        System.out.println("chauffeur ajoute avec succes");
    }
    //methode pour ajouter un bus
    public void ajouterBus(Bus nouveauBus) throws ErreurException {
        if (redondenceBus(nouveauBus.getNumImm())){
            throw new ErreurException("ce bus existe deja");
        }
        if (nbBus >= bus.length) {
            //agrandir le tableau si plein
            Bus[] nouveauTableau = new Bus[Math.max(1,bus.length * 2)];
            System.arraycopy(bus, 0, nouveauTableau, 0, bus.length);
            bus= nouveauTableau;
        }
        bus[nbBus++] = nouveauBus;

        System.out.println("bus ajoute avec succes");
    }
    //trouver un chauffeur par son id
    public Chauffeur trouverChauffeur(String idChauffeur) throws ErreurException {
        for (Chauffeur chauffeur : chauffeur) {
            if (chauffeur != null && chauffeur.getNumId().equals(idChauffeur)) {
                return chauffeur;
            }
        }
        throw new ErreurException ("chauffeur non trouve");
    }
    //methode pour trouver un bus par son immatriculation
    public Bus trouverBus(String immBus) throws ErreurException {
        for (Bus bus : bus) {
            if (bus!=null && bus.getNumImm().equals(immBus)) {
                return bus;
            }
        }
        throw new ErreurException ("bus non trouve");
    }

    // Méthode pour réserver un bus avec un trajet et un chauffeur
    public void reserverBus(String idChauffeur, String imm, Trajet trajet) throws ErreurException {
        if (trajet == null) throw new ErreurException("Trajet requis");
        Bus bus = trouverBus(imm);
        Chauffeur chauffeur = trouverChauffeur(idChauffeur);
        if (bus.getChauffeur()!=null){

            throw new ErreurException ("ce bus est deja utilise");
        }else {
            chauffeur.ajouterTrajetAssocie(trajet);
            bus.setChauffeur(chauffeur);
            trajet.setBusUtilise(bus);
            bus.setTrajet(trajet);
        }
    }




    @Override
    public String toString() {
        return "Companie{" +
                "nomCompanie='" + nomCompanie + '\'' +
                ", chauffeur=" + Arrays.toString(chauffeur) +
                ", bus=" + Arrays.toString(bus) +
                ", nbChauffeurs=" + nbChauffeurs +
                ", nbBus=" + nbBus +
                '}';
    }





    public Bus[] trouverBusConduits(String idChauffeur) {
        Bus[] busConduits = new Bus[nbBus];
        int count = 0; // Initialiser le compteur à 0

        for (int i = 0; i < nbBus; i++) {
            // Si le bus est conduit par le chauffeur, l'ajouter au tableau
            if (bus[i].getChauffeur() != null && bus[i].getChauffeur().getNumId().equals(idChauffeur)) {
                busConduits[count] = bus[i];
                count++;
            }
        }

        // Redimensionner le tableau pour qu'il contienne uniquement les bus conduits par le chauffeur
        Bus[] resultat = new Bus[count];
        System.arraycopy(busConduits, 0, resultat, 0, count);

        return resultat;
    }
    //methode pour afficher les trajets et les bus
    public void afficherTrajetsEtBus(String idChauffeur) throws ErreurException {


        Chauffeur chauffeur = trouverChauffeur(idChauffeur);

        System.out.println("Chauffeur : " + chauffeur.getNom() + " " + chauffeur.getPrenom());
        Trajet[] trajets = chauffeur.getTrajetAssocie();
        for (Trajet trajet : trajets) {
            if (trajet != null) {
                System.out.println("  Trajet associe:");
                System.out.println("    Ville de départ : " + trajet.getVilleDepart());
                System.out.println("    Ville d'arrivée : " + trajet.getVilleArrivee());
                System.out.println("    Kilométrage au départ : " + trajet.getKlDepart());
                System.out.println("    Kilométrage à l'arrivée : " + trajet.getKlArrivee());
                Bus bus = trajet.getBusUtilise();

                if (bus != null) {
                    System.out.println("  Bus associe:");
                    System.out.println("    Numéro d'immatriculation : " + bus.getNumImm());
                    System.out.println("    Capacité du réservoir : " + bus.getCapReservoir());
                    System.out.println("    Nombre de passagers : " + bus.getNbrePassagers());
                    System.out.println("    Couleur : " + bus.getCouleur());
                } else {
                    System.out.println("  Aucun bus associé à ce trajet.");
                }
            }
        }
    }
}


