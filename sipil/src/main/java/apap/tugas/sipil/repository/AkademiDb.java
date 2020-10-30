package apap.tugas.sipil.repository;

import apap.tugas.sipil.model.AkademiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AkademiDb extends JpaRepository<AkademiModel, Long> {
    List<AkademiModel> findByOrderByIdAsc();
}
