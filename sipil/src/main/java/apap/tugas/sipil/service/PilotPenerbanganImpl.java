package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotPenerbanganModel;
import apap.tugas.sipil.repository.PilotPenerbanganDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PilotPenerbanganImpl implements  PilotPenerbanganService{
    @Autowired
    PilotPenerbanganDb pilotPenerbanganDb;

    @Override
    public List<PilotPenerbanganModel> getPilotPenerbanganList() {
        return pilotPenerbanganDb.findByOrderByIdAsc();
    }

    @Override
    public void addPilotPenerbangan(PilotPenerbanganModel pilotPenerbangan) {
        pilotPenerbanganDb.save(pilotPenerbangan);
    }
}
