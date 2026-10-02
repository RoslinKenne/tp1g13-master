import java.util.Arrays;

public class Chauffeur {

    private String nom,prenom,adresse,numId;
    private int age,anneeE;

    private  Trajet[] trajetAssocies;
    private int nbTrajetsAssocies;
    int maxTrajetsAssocies=100;

    //constructeur
    public Chauffeur(String nom, String prenom, String adresse, String numId, int age, int anneeE ,int nbTrajetsAssocies) {
        if (nom == null || nom.trim().isEmpty() || prenom == null || prenom.trim().isEmpty()
            || age < 18 || anneeE < 1900 || anneeE > java.time.Year.now().getValue())
            throw new IllegalArgumentException("Identité, âge ou année invalides");
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numId = numId == null || numId.isBlank() ? genererId(nom,prenom,anneeE) : numId;
        this.age = age;
        this.anneeE = anneeE;

        this.trajetAssocies = new Trajet[maxTrajetsAssocies];
        this.nbTrajetsAssocies=0;
    }
    //accesseurs et mutateurs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnneeE() {
        return anneeE;
    }

    public void setAnneeE(int anneeE) {
        this.anneeE = anneeE;
    }

    public Trajet[] getTrajetAssocie() {
        return trajetAssocies;
    }

    public void setTrajetAssocie(Trajet[] trajetAssocie) {
        this.trajetAssocies = Arrays.stream(trajetAssocie).filter(java.util.Objects::nonNull).toArray(Trajet[]::new);
        this.nbTrajetsAssocies = (int)Arrays.stream(trajetAssocie).filter(java.util.Objects::nonNull).count();
    }

    public static String genererId(String nom, String prenom, int anneeE){
        if (nom == null || nom.isBlank() || prenom == null || prenom.isBlank())
            throw new IllegalArgumentException("Nom et prénom requis");
        return nom.substring(0, Math.min(4, nom.length())) + prenom.substring(0, 1) + anneeE;
    }
    //methode pour ajouter un trajet associe
    public void ajouterTrajetAssocie(Trajet trajet) throws ErreurException {
        if (trajet == null) throw new ErreurException("Trajet requis");
        if (nbTrajetsAssocies == trajetAssocies.length)
            trajetAssocies = Arrays.copyOf(trajetAssocies, Math.max(1,trajetAssocies.length*2));
        trajetAssocies[nbTrajetsAssocies++] = trajet;

    }


    //methode toString
    public String toString() {
        return "Chauffeur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numId='" + numId + '\'' +
                ", age=" + age +
                ", anneeE=" + anneeE +
                '}';
    }
}
