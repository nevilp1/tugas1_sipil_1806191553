package apap.tugas.sipil.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="pilot_penerbangan")
public class PilotPenerbanganModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PilotModel getPilot() {
        return pilot;
    }

    public void setPilot(PilotModel pilot) {
        this.pilot = pilot;
    }

    public PenerbanganModel getPenerbangan() {
        return penerbangan;
    }

    public void setPenerbangan(PenerbanganModel penerbangan) {
        this.penerbangan = penerbangan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pilot")
    private PilotModel pilot;

    @ManyToOne
    @JoinColumn(name = "id_penerbangan")
    private PenerbanganModel penerbangan;

    public LocalDate getTanggalPenugasan() {
        return tanggalPenugasan;
    }

    public void setTanggalPenugasan() {
        this.tanggalPenugasan = LocalDate.now();
    }

    @NotNull
    @Column(name = "tanggal_penugasan")
    private LocalDate tanggalPenugasan;
}
