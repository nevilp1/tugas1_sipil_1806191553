package apap.tugas.sipil.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "penerbangan")
public class PenerbanganModel implements Serializable {

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

    @NotNull
    @Column(name = "waktuPenerbangan")
    private Date waktuPenerbangan;
}


