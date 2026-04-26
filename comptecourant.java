package entite;

public class comptecourant extends compte {

    private double taxe = 0.01;

    public comptecourant(double solde, String numcompte) {
        super(solde, numcompte, "courant");
    }

    @Override
    public void retirer(double montant) {

        if (montant <= 0) {
            System.out.println("Montant invalide.");
            return;
        }

        double total = montant + (montant * taxe);

        if (total > solde) {
            System.out.println("Solde insuffisant.");
            return;
        }

        solde -= total;
    }

    @Override
    public String toString() {
        return "comptecourant [" + super.toString() + ", taxe=" + taxe + "]";
    }
}