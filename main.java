package application;

import repertoire.banqueimpliste;

public class main {

    public static void main(String[] args) {

        banqueimpliste b = new banqueimpliste();

        int choix;

        do {
            choix = b.menuprincipal();

            switch (choix) {

                case 1:
                    b.gestionClient();
                    break;

                case 2:
                    b.gestioncompte();
                    break;

                case 3:
                    b.gestionEmploye();
                    break;

                case 4:
                    System.out.println("Au revoir !");
                    break;
            }

        } while (choix != 4);
    }
}