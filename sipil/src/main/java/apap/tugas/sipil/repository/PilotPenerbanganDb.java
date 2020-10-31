package apap.tugas.sipil.repository;


import apap.tugas.sipil.model.PilotPenerbanganModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotPenerbanganDb extends JpaRepository<PilotPenerbanganModel, Long> {
    List<PilotPenerbanganModel> findByOrderByIdAsc();
    PilotPenerbanganModel getPilotPenerbanganModelById(Long id);
}