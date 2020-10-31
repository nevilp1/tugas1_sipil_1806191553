package apap.tugas.sipil.service;


import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.repository.PenerbanganDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PenerbanganServiceImpl implements PenerbanganService{
    @Autowired
    PenerbanganDb penerbanganDb;

    @Override
    public List<PenerbanganModel> getPenerbanganList() {
        return penerbanganDb.findByOrderByIdAsc();
    }

    @Override
    public void addPenerbangan(PenerbanganModel penerbangan) {
        penerbanganDb.save(penerbangan);
    }

    @Override
    public PenerbanganModel getById(Long id) {
        return penerbanganDb.findById(id).get();
    }

    @Override
    public PenerbanganModel updatePenerbangan(PenerbanganModel penerbangan) {
        PenerbanganModel targetPenerbangan = penerbanganDb.findById(penerbangan.getId()).get();

        try {
            targetPenerbangan.setKode(penerbangan.getKode());
            targetPenerbangan.setWaktuPenerbangan(penerbangan.getWaktuPenerbangan());
            targetPenerbangan.setKotaAsal(penerbangan.getKotaAsal());
            targetPenerbangan.setKotaTujuan(penerbangan.getKotaTujuan());
            penerbanganDb.save(targetPenerbangan);
            return targetPenerbangan;
        } catch (NullPointerException nullException){
            return null;
        }
    }

    @Override
    public boolean deletePenerbangan(PenerbanganModel penerbangan) {
        if(penerbanganDb.findById(penerbangan.getId()).get().getPenerbanganPilot().size() == 0) {
            penerbanganDb.deleteById(penerbangan.getId());
            return true;
        }
        return false;
    }
}
