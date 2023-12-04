package seg3x02.pms.infrastructure.jpa.entities.division


import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientAdmissionJpaEntity
import seg3x02.pms.infrastructure.jpa.enums.division.RoomStatus
import java.util.*

@Entity(name = "room")
@Table(name = "room")
class RoomJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id", nullable = false, unique = true)
    val id: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "room_status", nullable = false, columnDefinition = "varchar(20) default 'NOT_COMPLETE'")
    val roomStatus: RoomStatus,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    var division: DivisionJpaEntity,

    @OneToMany(mappedBy = "room", cascade = [CascadeType.ALL], orphanRemoval = true)
    var beds: MutableList<BedJpaEntity> = ArrayList(),

    @OneToMany(mappedBy = "room", cascade = [CascadeType.ALL], orphanRemoval = true)
    var patientAdmissionRequestList: MutableList<PatientAdmissionJpaEntity> = ArrayList()
)