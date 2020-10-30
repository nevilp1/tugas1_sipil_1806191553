package apap.tugas.sipil.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="maskapai")
public class MaskapaiModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaMaskapai() {
        return namaMaskapai;
    }

    public void setNamaMaskapai(String namaMaskapai) {
        this.namaMaskapai = namaMaskapai;
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
    @Column(name = "kodeMaskapai", unique = true)
    private String kode;

    @NotNull
    @Size(max=255)
    @Column(name="namaMaskapai")
    private String namaMaskapai;

    @OneToMany(mappedBy = "maskapai", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PilotModel> listPilot;

}
