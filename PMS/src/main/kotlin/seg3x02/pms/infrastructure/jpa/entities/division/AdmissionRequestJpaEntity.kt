package seg3x02.pms.infrastructure.jpa.entities.division


import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.patient.PatientJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.staff.StaffJpaEntity
import seg3x02.pms.infrastructure.jpa.enums.division.RationalOfRequestEnum
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
@Entity(name = "admission_request")
@Table(name = "admission_request")
class AdmissionRequestJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_request_id", nullable = false, unique = true)
    val id: UUID,

    @Column(name = "rationale_for_request", nullable = false)
    val rationaleForRequest: String,

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority_assessment", nullable = false, columnDefinition = "int(2)")
    val priorityAssessment: RationalOfRequestEnum,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    var division: DivisionJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "requesting_charged_nurse_id", nullable = false, referencedColumnName = "staff_id")
    var requestingChargedNurse: StaffJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "patient_nas", nullable = false, referencedColumnName = "nas")
    var patient: PatientJpaEntity,
)