package seg3x02.pms.infrastructure.jpa.entities.division

import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientAdmissionJpaEntity
import seg3x02.pms.infrastructure.jpa.enums.division.BedStatus
import java.util.*

@Entity(name = "beds")
@Table(name = "beds")
class BedJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bed_id", nullable = false, unique = true)
    val id: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "bed_number", nullable = false, unique = true)
    val bedStatus: BedStatus,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "room_id", nullable = false, referencedColumnName = "room_id")
    var room: RoomJpaEntity,

    @OneToMany(mappedBy = "bed", cascade = [CascadeType.ALL], orphanRemoval = true)
    var patientAdmissionList: MutableList<PatientAdmissionJpaEntity> = ArrayList()
)