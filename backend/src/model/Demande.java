package model;

public class Demande {

    private Long id;

    private String titre;

    private String demandeur;

    private String direction;

    private String statut;

    private Analyse analyse;

    public Demande(
            Long id,
            String titre,
            String demandeur,
            String direction,
            String statut,
            Analyse analyse) {

        this.id = id;
        this.titre = titre;
        this.demandeur = demandeur;
        this.direction = direction;
        this.statut = statut;
        this.analyse = analyse;
    }

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDemandeur() {
        return demandeur;
    }

    public String getDirection() {
        return direction;
    }

    public String getStatut() {
        return statut;
    }

    public Analyse getAnalyse() {
        return analyse;
    }
}