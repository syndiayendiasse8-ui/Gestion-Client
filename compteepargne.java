package entite;

public class compteepargne extends compte {

    public compteepargne(double solde, String numcompte) {
        super(solde, numcompte, "epargne");
    }

    @Override
    public void retirer(double montant) {

        if (montant <= 0) {
            System.out.println("Montant invalide.");
            return;
        }

        if (montant > solde) {
            System.out.println("Solde insuffisant.");
            return;
        }

        solde -= montant;
    }

    @Override
    public String toString() {
        return "compteepargne [" + super.toString() + "]";
    }
}