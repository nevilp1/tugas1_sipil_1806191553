package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PenerbanganModel;

import java.util.List;

public interface PenerbanganService {
    List<PenerbanganModel> getPenerbanganList();
    void addPenerbangan(PenerbanganModel penerbangan);
    PenerbanganModel getById(Long id);
    PenerbanganModel updatePenerbangan(PenerbanganModel penerbangan);
    boolean deletePenerbangan(PenerbanganModel penerbangan);
}
