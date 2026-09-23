package service;

import data.DemoData;
import model.Demande;

import java.util.List;

public class DemandeService {

    public List<Demande> getAllDemandes() {

        return DemoData.getDemandes();
    }

    public Demande getDemandeById(Long id) {

        return DemoData
                .getDemandes()
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}