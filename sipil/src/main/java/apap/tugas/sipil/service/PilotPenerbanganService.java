package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotPenerbanganModel;

import java.util.List;

public interface PilotPenerbanganService {
    List<PilotPenerbanganModel> getPilotPenerbanganList();
    void addPilotPenerbangan(PilotPenerbanganModel pilotPenerbangan);
}
