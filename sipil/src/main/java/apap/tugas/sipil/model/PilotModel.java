package apap.tugas.sipil.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "pilot")
public class PilotModel {
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public MaskapaiModel getMaskapai() {
        return maskapai;
    }

    public void setMaskapai(MaskapaiModel maskapai) {
        this.maskapai = maskapai;
    }

    public AkademiModel getAkademi() {
        return akademi;
    }

    public void setAkademi(AkademiModel akademi) {
        this.akademi = akademi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=255)
    @Column(name="nama")
    private String nama;

    @NotNull
    @Size(max=13)
    @Column(name="nip")
    private String nip;

    @NotNull
    @Size(max=255)
    @Column(name = "nik")
    private String nik;

    @NotNull
    @Column(name = "tanggalLahir")
    private Date tanggalLahir;

    @NotNull
    @Size(max=255)
    @Column(name = "tempatLahir")
    private String tempatLahir;

    @NotNull
    @Column(name = "jenisKelamin")
    private Integer jenisKelamin;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idMaskapai", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MaskapaiModel maskapai;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idAkademi", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AkademiModel akademi;

    @OneToMany(mappedBy = "pilot")
    private List<PilotPenerbanganModel> penerbanganPilot;

}
