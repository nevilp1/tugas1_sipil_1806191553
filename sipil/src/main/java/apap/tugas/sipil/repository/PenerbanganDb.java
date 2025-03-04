package apap.tugas.sipil.repository;

import apap.tugas.sipil.model.PenerbanganModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenerbanganDb extends JpaRepository<PenerbanganModel, Long> {
    List<PenerbanganModel> findByOrderByIdAsc();
}