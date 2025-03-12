

import java.util.Scanner;

public class AutoRent {

    public static Companie companie = new Companie("AatoRent",100,100);


    public static void main(String[]args) throws ErreurException {
        Scanner scan = new Scanner(System.in);

        //ajout de chauffeurs predefinis
        Chauffeur chauffeur1 = new Chauffeur("kenne", "roslin", "1080 rue viger", "kenner20", 30, 2020,0);
        Chauffeur chauffeur2 = new Chauffeur("kenne", "roslin", "1080 rue viger", "kenner20", 35, 2020,0);

        companie.ajouterChauffeur(chauffeur1);


        try {
            companie.ajouterChauffeur(chauffeur1);
        } catch (ErreurException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        //ajout de bus predefinis
        Bus bus1 = new Bus("k123456", "noir", 30, 50);
        Bus bus2 = new Bus("k123455", "noir", 30, 50);

        companie.ajouterBus(bus1);

        try {
            companie.ajouterBus(bus2);
        } catch (ErreurException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

//ajout de trajets predefinis
        Trajet trajet1 = new Trajet("VilleDepart1", "VilleArrivee1", 100, 200);
        Trajet trajet2 = new Trajet("VilleDepart2", "VilleArrivee2", 100, 200);
        chauffeur1.setTrajetAssocie(new Trajet[]{trajet1});
        chauffeur2.setTrajetAssocie(new Trajet[]{trajet2});
        chauffeur1.ajouterTrajetAssocie(trajet1);
        System.out.println(chauffeur1);
        System.out.println(chauffeur2);
        System.out.println(bus1);
        System.out.println(bus2);

        bus1.setChauffeur(chauffeur1);
        int sousmenu ;
        boolean arret = false;


        // Menu avec 3 choix
        while (!arret) // cette boucle permet de boucler tant que l'utilisateur ne quitte pas le menu
        {
            System.out.println("--Mon menu--");
            System.out.println("1. ajouter un chauffeur");
            System.out.println("2. ajouter un bus");
            System.out.println("3. faire une reservstion");
            System.out.println("4.  trouver toutes les bus conduits par un chauffeur donné");
            System.out.println("5.afficher toutes les caractéristiques des trajets effectués ainsi que les caractéristiques des bus utilisés ");
            System.out.println("0. Quitter");

            sousmenu = Integer.parseInt(scan.nextLine());

            switch (sousmenu)
            {
                case 1:

                    String nom;
                    try {

                        System.out.println("Entrez le nom du chauffeur (minimum 4 caracteres) :");
                        nom = scan.nextLine();
                        if (nom.length() < 4) {
                            throw new ErreurException("Le nom doit contenir au moins 4 caractères.");
                        }
//ajouter un chauffeur
                        System.out.println("Entrez le prénom du chauffeur :");
                        String prenom = scan.nextLine();
                        System.out.println("Entrez l'âge du chauffeur :");
                        int age = Integer.parseInt(scan.nextLine());
                        System.out.println("Entrez l'année d'embauche du chauffeur :");
                        int anneeE = Integer.parseInt(scan.nextLine());
                        String id = Chauffeur.genererId(nom, prenom, anneeE);
                        System.out.println("Entrez l'adresse du chauffeur :");
                        String adresse = scan.nextLine();
                        System.out.println("Entrez le nombre de trajets associes :");
                        int nbTrajets = scan.nextInt();

                        scan.nextLine(); // Pour consommer la nouvelle ligne

                        Chauffeur chauffeur = new Chauffeur(nom, prenom, adresse, id, age, anneeE,nbTrajets);
                        String idU = chauffeur.getNumId();
                        System.out.println(idU);
                        try {
                            companie.ajouterChauffeur(chauffeur);
                        } catch (ErreurException e) {
                            System.out.println("Erreur : " + e.getMessage());
                        }

                    } catch (ErreurException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
//ajouter un bus
                    System.out.println("entrez le numéro d’immatriculation du bus");
                    String imm = scan.nextLine();
                    System.out.println("entrez la capacité du réservoir du bus");
                    double capRes = Double.parseDouble(scan.nextLine());
                    System.out.println("entrez  le nombre de passagers du bus");
                    int nbrePass = Integer.parseInt(scan.nextLine());
                    System.out.println("entrez la couleur du bus");
                    String couleur = scan.nextLine();

                    Bus buss = new Bus(imm, couleur, capRes, nbrePass);
                    try {
                        companie.ajouterBus(buss);
                    } catch (ErreurException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }

                    break;

                case 3:
                    // Code pour faire une réservation
                    System.out.println("entrez l’id du Chauffeur");
                    String idChauffeur = scan.nextLine();
                    System.out.println("entrez l’imm du bus");
                    imm = scan.nextLine();
                    System.out.println("Entrez la ville de départ:");
                    String villeDepart = scan.nextLine();
                    System.out.println("Entrez la ville d'arriver:");
                    String villeArrivee = scan.nextLine();
                    System.out.println("Entrez le kilométrage au depart:");
                    double klDepart = scan.nextDouble();
                    System.out.println("Entrez le kilométrage à l'arriver:");
                    double klArrivee = scan.nextDouble();
                    scan.nextLine();

                    // Créer un nouveau trajet avec les informations saisies
                    Trajet trajet = new Trajet(villeDepart, villeArrivee, klDepart, klArrivee);
                    try {
                        companie.reserverBus(idChauffeur, imm, trajet);
                    } catch (ErreurException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Entrez l'id du Chauffeur :");
                    idChauffeur = scan.nextLine();

// Appel de la méthode pour trouver les bus conduits par le chauffeur
                    Bus[] busConduits = companie.trouverBusConduits(idChauffeur);

// Vérifier les bus conduits par ce chauffeur et les afficher
                    if (busConduits.length > 0) {
                        System.out.println("Les bus conduits par le chauffeur d'id" + idChauffeur + " sont :");
                        for (Bus bus : busConduits) {
                            System.out.println("Détails du bus :");
                            System.out.println("Numéro d'immatriculation : " + bus.getNumImm());
                            System.out.println("Capacité du réservoir : " + bus.getCapReservoir());
                            System.out.println("Nombre de passagers : " + bus.getNbrePassagers());
                            System.out.println("Couleur : " + bus.getCouleur());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Aucun bus conduit par le chauffeur " + idChauffeur);
                    }


                    break;
                case 5:
                    //afficher les caracteristiques du trajet et du bus
                    System.out.println("entrez l’identifiant du Chauffeur");
                    idChauffeur = scan.nextLine();
                    companie.afficherTrajetsEtBus(idChauffeur);
                    break;
                case 0:

                    arret = true;
                    break;


                default: // si un chiffre autre que 1-2-3-4-5 est entre

                    System.out.println("que voulez vous faire???");
                    break;

            }

            System.out.println();
        }

        System.out.println("Fin du programme");
    }



}

