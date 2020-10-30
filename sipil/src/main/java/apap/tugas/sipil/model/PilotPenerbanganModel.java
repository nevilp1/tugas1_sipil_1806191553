package apap.tugas.sipil.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name="pilot_penerbangan")
public class PilotPenerbanganModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pilot")
    private PilotModel pilot;

    @ManyToOne
    @JoinColumn(name = "id_penerbangan")
    private PenerbanganModel penerbangan;

    @NotNull
    @Column(name = "tanggal_penugasan")
    private Date tanggalLahir;
}
