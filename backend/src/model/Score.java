package model;

public class Score {

    private int valeurAffaires;
    private int productivite;
    private int coutsEvites;
    private int portee;
    private int faisabilite;

    public Score(
            int valeurAffaires,
            int productivite,
            int coutsEvites,
            int portee,
            int faisabilite) {

        this.valeurAffaires = valeurAffaires;
        this.productivite = productivite;
        this.coutsEvites = coutsEvites;
        this.portee = portee;
        this.faisabilite = faisabilite;
    }

    public int getValeurAffaires() {
        return valeurAffaires;
    }

    public int getProductivite() {
        return productivite;
    }

    public int getCoutsEvites() {
        return coutsEvites;
    }

    public int getPortee() {
        return portee;
    }

    public int getFaisabilite() {
        return faisabilite;
    }
}