package entite;

public class employer extends personne {

    private double salaire;

    public employer(String nom, String prenom, String email, String tel, double salaire) {
        super(nom, prenom, email, tel);
        this.salaire = salaire;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "employer [nom=" + nom +
                ", prenom=" + prenom +
                ", email=" + email +
                ", tel=" + tel +
                ", salaire=" + salaire + "]";
    }
}