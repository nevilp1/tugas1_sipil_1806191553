package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.model.PilotPenerbanganModel;
import apap.tugas.sipil.repository.PilotDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.transaction.Transactional;

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

    @Override
    public PilotModel getPilotByNip(String nip) {
        PilotModel pilot = pilotDb.getPilotModelByNip(nip);
        return pilot;
    }

    @Override
    public PilotModel updatePilot(PilotModel pilot) {
        PilotModel targetPilot = pilotDb.findById(pilot.getId()).get();

        try {
            targetPilot.setNama(pilot.getNama());
            targetPilot.setNik(pilot.getNik());
            targetPilot.setTempatLahir(pilot.getTempatLahir());
            targetPilot.setTanggalLahir(pilot.getTanggalLahir());
            targetPilot.setJenisKelamin(pilot.getJenisKelamin());
            targetPilot.setAkademi(pilot.getAkademi());
            targetPilot.setMaskapai(pilot.getMaskapai());
            targetPilot.setNip(generateID(pilot));
            pilotDb.save(targetPilot);
            return targetPilot;
        } catch (NullPointerException nullException){
            return null;
        }
    }

    @Override
    public void deletePilot(PilotModel pilot) {
        pilotDb.deleteById(pilot.getId());
    }

    @Override
    public List<PilotModel> getPilotByKodeDanId(String kode, Long id) {
        return pilotDb.findAllByAkademi_IdOrMaskapai_Kode(id,kode);
    }

    @Override
    public List<PilotModel> getByMaskapaiKode(String kode) {
         List<PilotModel> listPilot = pilotDb.findAllByMaskapai_Kode(kode);
        ArrayList<PilotModel> sortedList = new ArrayList<PilotModel>();
         HashMap<PilotModel, Integer> map = new HashMap<PilotModel, Integer>();
         for(PilotModel p : listPilot){
             map.put(p, p.getPenerbanganPilot().size());
         }
         HashMap<PilotModel, Integer> sortedMap = sortByValue(map);

        for (Map.Entry<PilotModel, Integer> entry : sortedMap.entrySet()) {
            sortedList.add(entry.getKey());
        }

         return sortedList;
    }
    // function to sort hashmap by values
    public HashMap<PilotModel, Integer> sortByValue(HashMap<PilotModel, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<PilotModel, Integer> > list =
                new LinkedList<Map.Entry<PilotModel, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<PilotModel, Integer> >() {
            public int compare(Map.Entry<PilotModel, Integer> o1,
                               Map.Entry<PilotModel, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<PilotModel, Integer> temp = new LinkedHashMap<PilotModel, Integer>();
        for (Map.Entry<PilotModel, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
