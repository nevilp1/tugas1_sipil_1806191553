package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.repository.PilotDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
    @Autowired
    PilotDb pilotDb;

    @Override
    public List<PilotModel> getPilotList() {
        return pilotDb.findByOrderByIdAsc();
    }

    @Override
    public void addPilot(PilotModel pilot) {
        pilotDb.save(pilot);
    }

    @Override
    public String generateID(PilotModel pilot) {
        String nip = "";
        nip += pilot.getJenisKelamin().toString();
        nip += pilot.getTempatLahir().substring(0,2).toUpperCase();
        nip += pilot.getNama().substring(pilot.getNama().length()-1).toUpperCase();
        Date tanggal = pilot.getTanggalLahir();
        String bulan = tanggal.toString().substring(5,7);
        String hari = tanggal.toString().substring(8,10);
        String tahun = tanggal.toString().substring(0,3);
        nip += hari;
        nip += bulan;
        nip += tahun;
        Random r = new Random();
        char random1 = (char)(r.nextInt(26) + 'a');
        char random2 = (char)(r.nextInt(26) + 'a');
        nip += Character.toString(random1).toUpperCase();
        nip += Character.toString(random2).toUpperCase();

        return nip;
    }
}
