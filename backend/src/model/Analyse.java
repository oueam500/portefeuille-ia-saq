package model;

public class Analyse {

    private String resume;
    private String recommandation;
    private String categorie;
    private String priorite;

    private Double scoreGlobal;

    private Score score;

    public Analyse(
            String resume,
            String recommandation,
            String categorie,
            String priorite,
            Double scoreGlobal,
            Score score) {

        this.resume = resume;
        this.recommandation = recommandation;
        this.categorie = categorie;
        this.priorite = priorite;
        this.scoreGlobal = scoreGlobal;
        this.score = score;
    }

    public String getResume() {
        return resume;
    }

    public String getRecommandation() {
        return recommandation;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getPriorite() {
        return priorite;
    }

    public Double getScoreGlobal() {
        return scoreGlobal;
    }

    public Score getScore() {
        return score;
    }
}