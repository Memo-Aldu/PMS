package seg3x02.pms.infrastructure.jpa.entities.patient.admission

import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.division.BedJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.division.DivisionJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.division.RoomJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.patient.PatientJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.staff.StaffJpaEntity
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
@Entity(name = "patient_admission")
@Table(name = "patient_admission")
class PatientAdmissionJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "admission_id", nullable = false, unique = true)
    val id: UUID,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "room_id", nullable = false, referencedColumnName = "room_id")
    var room: RoomJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "bed_id", nullable = false, referencedColumnName = "bed_id")
    var bed: BedJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "patient_nas", nullable = false, referencedColumnName = "nas")
    var patient: PatientJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    var division: DivisionJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "requesting_charged_nurse_id", nullable = false, referencedColumnName = "staff_id")
    var requestingChargedNurse: StaffJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "accepting_charged_nurse_id", nullable = false, referencedColumnName = "staff_id")
    var acceptingChargedNurse: StaffJpaEntity,
)