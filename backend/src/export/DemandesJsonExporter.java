package export;

import model.Demande;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DemandesJsonExporter {

    public static void export(List<Demande> demandes) {

        try {

            FileWriter writer = new FileWriter("demandes.json");

            writer.write("[\n");

            for (int i = 0; i < demandes.size(); i++) {

                Demande d = demandes.get(i);

                writer.write(
                        String.format(
                            java.util.Locale.US,
                                """
                                {
                                  "id": %d,
                                  "titre": "%s",
                                  "demandeur": "%s",
                                  "direction": "%s",
                                  "scoreGlobal": %.1f,
                                  "categorie": "%s",
                                  "priorite": "%s",
                                  "statut": "%s"
                                }
                                """,
                                d.getId(),
                                d.getTitre(),
                                d.getDemandeur(),
                                d.getDirection(),
                                d.getAnalyse().getScoreGlobal(),
                                d.getAnalyse().getCategorie(),
                                d.getAnalyse().getPriorite(),
                                d.getStatut()
                        )
                );

                if (i < demandes.size() - 1) {
                    writer.write(",");
                }

                writer.write("\n");
            }

            writer.write("]");

            writer.close();

            System.out.println("✅ demandes.json généré");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}