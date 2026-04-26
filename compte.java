package entite;

public abstract class compte {

    protected double solde;
    protected String numcompte;
    protected String typecompte;

    public compte() {
    }

    public compte(double solde, String numcompte, String typecompte) {
        this.solde = solde;
        this.numcompte = numcompte;
        this.typecompte = typecompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNumcompte() {
        return numcompte;
    }

    public void setNumcompte(String numcompte) {
        this.numcompte = numcompte;
    }

    public String getTypecompte() {
        return typecompte;
    }

    public void setTypecompte(String typecompte) {
        this.typecompte = typecompte;
    }

    public void deposer(double montant) {
        if (montant <= 0) {
            System.out.println("Montant invalide");
            return;
        }
        solde += montant;
    }

    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Montant invalide");
            return;
        }

        if (montant > solde) {
            System.out.println("Solde insuffisant");
            return;
        }

        solde -= montant;
    }

    @Override
    public String toString() {
        return "compte [numcompte=" + numcompte +
                ", solde=" + solde +
                ", typecompte=" + typecompte + "]";
    }
}