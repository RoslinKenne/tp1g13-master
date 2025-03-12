import java.util.Arrays;

public class Chauffeur {

    private String nom,prenom,adresse,numId;
    private int age,anneeE;

    private  Trajet[] trajetAssocies;
    private int nbTrajetsAssocies;
    int maxTrajetsAssocies=100;

    //constructeur
    public Chauffeur(String nom, String prenom, String adresse, String numId, int age, int anneeE ,int nbTrajetsAssocies) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numId = genererId(nom,prenom,anneeE);
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
        this.trajetAssocies = trajetAssocie;
    }

    public static String genererId(String nom, String prenom, int anneeE){
        return nom.substring(0, 4) + prenom.substring(0, 1) + String.valueOf(anneeE).substring(2);
    }
    //methode pour ajouter un trajet associe
    public void ajouterTrajetAssocie(Trajet trajet) throws ErreurException {
        //  si le nombre maximum de trajets associes est atteint
        if (this.nbTrajetsAssocies < trajetAssocies.length) {
            trajetAssocies[this.nbTrajetsAssocies++] = trajet;
            System.out.println("Trajet ajouté avec succès.");
        } else {
            throw new ErreurException ("Le nombre maximum de trajets associés est atteint.");
        }
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
