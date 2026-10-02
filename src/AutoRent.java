import java.util.Scanner;

public class AutoRent {
    public static Companie companie = new Companie("AutoRent",100,100);
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(true) {
            System.out.println("1. Ajouter un chauffeur\n2. Ajouter un bus\n3. Réserver un bus\n4. Bus d'un chauffeur\n5. Trajets d'un chauffeur\n0. Quitter");
            if (!scan.hasNextLine()) return;
            try {
                int choix=Integer.parseInt(scan.nextLine().trim());
                switch(choix) {
                    case 0 -> {return;}
                    case 1 -> {
                        String nom=lire(scan,"Nom"),prenom=lire(scan,"Prénom"),adresse=lire(scan,"Adresse");
                        int age=Integer.parseInt(lire(scan,"Âge")),annee=Integer.parseInt(lire(scan,"Année d'embauche"));
                        Chauffeur c=new Chauffeur(nom,prenom,adresse,Chauffeur.genererId(nom,prenom,annee),age,annee,0);
                        companie.ajouterChauffeur(c);System.out.println("Identifiant : "+c.getNumId());
                    }
                    case 2 -> companie.ajouterBus(new Bus(lire(scan,"Immatriculation"),lire(scan,"Couleur"),Double.parseDouble(lire(scan,"Réservoir")),Integer.parseInt(lire(scan,"Passagers"))));
                    case 3 -> {
                        String id=lire(scan,"Identifiant du chauffeur"),imm=lire(scan,"Immatriculation");
                        Trajet t=new Trajet(lire(scan,"Départ"),lire(scan,"Arrivée"),Double.parseDouble(lire(scan,"Kilométrage départ")),Double.parseDouble(lire(scan,"Kilométrage arrivée")));
                        companie.reserverBus(id,imm,t);
                    }
                    case 4 -> {for(Bus b:companie.trouverBusConduits(lire(scan,"Identifiant du chauffeur")))System.out.println(b);}
                    case 5 -> companie.afficherTrajetsEtBus(lire(scan,"Identifiant du chauffeur"));
                    default -> System.out.println("Choix invalide.");
                }
            } catch(ErreurException | IllegalArgumentException e) {System.out.println("Erreur : "+e.getMessage());}
            catch(java.util.NoSuchElementException e) {return;}
        }
    }
    private static String lire(Scanner s,String prompt) {System.out.println(prompt+" :");return s.nextLine().trim();}
}
