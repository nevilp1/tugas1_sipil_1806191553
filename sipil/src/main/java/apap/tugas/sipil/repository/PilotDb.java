package apap.tugas.sipil.repository;


import apap.tugas.sipil.model.PilotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotDb extends JpaRepository<PilotModel, Long> {
    List<PilotModel> findByOrderByIdAsc();
    PilotModel getPilotModelByNip(String nip);
    List<PilotModel> findAllByAkademi_IdOrMaskapai_Kode(Long id, String kode);
    List<PilotModel> findAllByMaskapai_Kode(String kode);
}