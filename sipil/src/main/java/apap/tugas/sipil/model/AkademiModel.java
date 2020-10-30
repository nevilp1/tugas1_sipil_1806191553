package apap.tugas.sipil.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "akademi")
public class AkademiModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public List<PilotModel> getListPilot() {
        return listPilot;
    }

    public void setListPilot(List<PilotModel> listPilot) {
        this.listPilot = listPilot;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=16)
    @Column(name = "namaAkademi", unique = true)
    private String nama;

    @NotNull
    @Size(max=255)
    @Column(name="lokasi")
    private String lokasi;

    @OneToMany(mappedBy = "akademi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PilotModel> listPilot;

}
