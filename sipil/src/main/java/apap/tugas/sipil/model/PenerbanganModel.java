package apap.tugas.sipil.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "penerbangan")
public class PenerbanganModel implements Serializable {

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

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public List<PilotPenerbanganModel> getPenerbanganPilot() {
        return penerbanganPilot;
    }

    public void setPenerbanganPilot(List<PilotPenerbanganModel> penerbanganPilot) {
        this.penerbanganPilot = penerbanganPilot;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=16)
    @Column(name = "kodePenerbangan", unique = true)
    private String kode;

    @NotNull
    @Size(max=255)
    @Column(name="kotaAsal")
    private String kotaAsal;

    @NotNull
    @Size(max=255)
    @Column(name="kotaTujuan")
    private String kotaTujuan;


    public LocalDateTime getWaktuPenerbangan() {
        return waktuPenerbangan;
    }

    public void setWaktuPenerbangan(LocalDateTime waktuPenerbangan) {
        this.waktuPenerbangan = waktuPenerbangan;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
    @Column(name = "waktuPenerbangan")
    private LocalDateTime waktuPenerbangan;

    @OneToMany(mappedBy = "penerbangan")
    private List<PilotPenerbanganModel> penerbanganPilot;
}


