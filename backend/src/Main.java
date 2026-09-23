import model.Demande;
import service.DemandeService;
import export.DemandesJsonExporter;
import api.DemandeApi;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        DemandeService service = new DemandeService();

        for (Demande demande : service.getAllDemandes()) {

            System.out.println(
                    demande.getId()
                            + " | "
                            + demande.getTitre()
                            + " | "
                            + demande.getAnalyse().getScoreGlobal()
                            + " | "
                            + demande.getAnalyse().getCategorie()
                            + " | "
                            + demande.getAnalyse().getPriorite()
            );
        }

        DemandesJsonExporter.export(
                service.getAllDemandes()
        );
        try {
            DemandeApi.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}