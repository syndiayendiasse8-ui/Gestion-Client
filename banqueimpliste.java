package repertoire;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entite.client;
import entite.compte;
import entite.comptecourant;
import entite.compteepargne;
import entite.employer;

public class banqueimpliste implements ibanque {

    Map<String, compte> comptes = new HashMap<>();
    Map<String, client> clients = new HashMap<>();
    Map<String, employer> employes = new HashMap<>();

    Scanner clavier = new Scanner(System.in);

    // ===================== COMPTE =====================
    @Override
    public compte scancompte() {

        System.out.println("Entrer le numero du compte : ");
        String numc = clavier.nextLine();

        System.out.println("Entrer le solde du compte : ");
        double solde = Double.parseDouble(clavier.nextLine());

        System.out.println("Entrer le type du compte (epargne/courant) : ");
        String type = clavier.nextLine();

        compte c = null;

        if (type.equalsIgnoreCase("epargne")) {
            c = new compteepargne(solde, numc);
        }

        if (type.equalsIgnoreCase("courant")) {
            c = new comptecourant(solde, numc);
        }

        if (c == null) {
            System.out.println("Type invalide !");
        }

        return c;
    }

    // ===================== MENU PRINCIPAL =====================
    public int menuprincipal() {

        int choix;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gerer les clients");
            System.out.println("2. Gerer les comptes");
            System.out.println("3. Gerer les employes");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");

            choix = Integer.parseInt(clavier.nextLine());

        } while (choix < 1 || choix > 4);

        return choix;
    }

    // ===================== GESTION CLIENT =====================
    public void gestionClient() {

        int choix;

        do {
            System.out.println("\n===== CLIENTS =====");
            System.out.println("1. Ajouter client");
            System.out.println("2. Afficher clients");
            System.out.println("3. Modifier client");
            System.out.println("4. Supprimer client");
            System.out.println("5. Quitter");

            choix = Integer.parseInt(clavier.nextLine());

            switch (choix) {

                case 1:
                    client c = scanclient();
                    compte cpt = scancompte();

                    if (c != null && cpt != null) {
                        c.getComptes().put(cpt.getNumcompte(), cpt);
                        clients.put(c.getEmail(), c);
                        comptes.put(cpt.getNumcompte(), cpt);
                    }
                    break;

                case 2:
                    clients.values().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Modifier client (non implemente)");
                    break;

                case 4:
                    System.out.println("Supprimer client (non implemente)");
                    break;
            }

        } while (choix != 5);
    }

    // ===================== GESTION COMPTE =====================
    public void gestioncompte() {

        int choix;

        do {
            System.out.println("\n===== COMPTES =====");
            System.out.println("1. Ajouter compte");
            System.out.println("2. Afficher comptes");
            System.out.println("3. Supprimer compte");
            System.out.println("4. Quitter");

            choix = Integer.parseInt(clavier.nextLine());

            switch (choix) {

                case 1:
                    compte c = scancompte();
                    if (c != null) {
                        comptes.put(c.getNumcompte(), c);
                    }
                    break;

                case 2:
                    comptes.values().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Suppression non implemente");
                    break;
            }

        } while (choix != 4);
    }

    // ===================== GESTION EMPLOYE =====================
    public void gestionEmploye() {

        int choix;

        do {
            System.out.println("\n===== EMPLOYES =====");
            System.out.println("1. Ajouter employe");
            System.out.println("2. Afficher employes");
            System.out.println("3. Modifier employe");
            System.out.println("4. Supprimer employe");
            System.out.println("5. Quitter");

            choix = Integer.parseInt(clavier.nextLine());

            switch (choix) {

                case 1:
                    employer e = scanemployer();
                    employes.put(e.getEmail(), e);
                    break;

                case 2:
                    employes.values().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Modifier employe (non implemente)");
                    break;

                case 4:
                    System.out.println("Supprimer employe (non implemente)");
                    break;
            }

        } while (choix != 5);
    }

    // ===================== SCAN CLIENT =====================
    @Override
    public client scanclient() {

        System.out.println("Nom : ");
        String nom = clavier.nextLine();

        System.out.println("Prenom : ");
        String prenom = clavier.nextLine();

        System.out.println("Email : ");
        String email = clavier.nextLine();

        System.out.println("Tel : ");
        String tel = clavier.nextLine();

        System.out.println("Adresse : ");
        String adresse = clavier.nextLine();

        System.out.println("Mode paiement : ");
        String mdp = clavier.nextLine();

        return new client(nom, prenom, email, tel, adresse, mdp);
    }

    // ===================== SCAN EMPLOYE =====================
    @Override
    public employer scanemployer() {

        System.out.println("Nom : ");
        String nom = clavier.nextLine();

        System.out.println("Prenom : ");
        String prenom = clavier.nextLine();

        System.out.println("Email : ");
        String email = clavier.nextLine();

        System.out.println("Tel : ");
        String tel = clavier.nextLine();

        System.out.println("Salaire : ");
        double salaire = Double.parseDouble(clavier.nextLine());

        return new employer(nom, prenom, email, tel, salaire);
    }

    // ===================== INTERFACE =====================
    @Override
    public void addclient() {
        client c = scanclient();
        clients.put(c.getEmail(), c);
    }

    @Override
    public void addcompte() {
        compte c = scancompte();
        if (c != null) {
            comptes.put(c.getNumcompte(), c);
        }
    }

    @Override
    public void addemployer() {
        employer e = scanemployer();
        employes.put(e.getEmail(), e);
    }

    @Override
    public void printallclient() {
        clients.values().forEach(System.out::println);
    }

    @Override
    public void printallemployer() {
        employes.values().forEach(System.out::println);
    }
}