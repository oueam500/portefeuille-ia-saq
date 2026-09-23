package data;

import model.Analyse;
import model.Demande;
import model.Score;

import java.util.ArrayList;
import java.util.List;

public class DemoData {

    public static List<Demande> getDemandes() {

        List<Demande> demandes = new ArrayList<>();

        demandes.add(
                new Demande(
                        1L,
                        "Assistant RH",
                        "Amal Ouedraogo",
                        "Ressources humaines",
                        "En analyse",
                        new Analyse(
                                "Automatiser les réponses RH.",
                                "Créer un agent RH.",
                                "Agent avancé",
                                "Haute",
                                78.0,
                                new Score(80, 75, 70, 80, 85)
                        )
                )
        );

        demandes.add(
                new Demande(
                        2L,
                        "Prévisions des ventes",
                        "Jean Tremblay",
                        "Ventes",
                        "Comité IA",
                        new Analyse(
                                "Prévision des ventes par région.",
                                "Projet stratégique.",
                                "Projet stratégique IA",
                                "Critique",
                                94.0,
                                new Score(95, 90, 90, 95, 85)
                        )
                )
        );

        demandes.add(
                new Demande(
                        3L,
                        "FAQ RH",
                        "Julie Gagnon",
                        "Ressources humaines",
                        "Backlog",
                        new Analyse(
                                "Réponses automatiques RH.",
                                "Agent simple.",
                                "Agent simple",
                                "Moyenne",
                                68.0,
                                new Score(65, 75, 60, 70, 70)
                        )
                )
        );

        demandes.add(
                new Demande(
                        4L,
                        "Résumé de réunions",
                        "Marc Bouchard",
                        "TI",
                        "Approuvé",
                        new Analyse(
                                "Résumé automatique des réunions.",
                                "Agent avancé Teams.",
                                "Agent avancé",
                                "Haute",
                                82.0,
                                new Score(85, 80, 75, 80, 90)
                        )
                )
        );

        demandes.add(
                new Demande(
                        5L,
                        "Assistant gestionnaire",
                        "Sophie Roy",
                        "Opérations",
                        "Développement",
                        new Analyse(
                                "Préparation automatisée des réunions.",
                                "Agent multi-sources.",
                                "Agent avancé",
                                "Haute",
                                88.0,
                                new Score(90, 90, 80, 85, 85)
                        )
                )
        );

        return demandes;
    }
}