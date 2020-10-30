package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotModel;

import java.util.List;

public interface PilotService {
    List<PilotModel> getPilotList();

    void addPilot(PilotModel pilot);

    String generateID(PilotModel pilot);

    PilotModel getPilotByNip(String nip);

    PilotModel updatePilot(PilotModel pilot);

    void deletePilot(PilotModel pilot);
}
