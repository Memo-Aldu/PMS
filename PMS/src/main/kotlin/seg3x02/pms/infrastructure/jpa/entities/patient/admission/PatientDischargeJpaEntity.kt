package seg3x02.pms.infrastructure.jpa.entities.patient.admission

import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.patient.PatientJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.staff.StaffJpaEntity
import java.sql.Timestamp
import java.util.Date
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/

@Entity(name = "patient_discharge")
@Table(name = "patient_discharge")
class PatientDischargeJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "discharge_id", nullable = false, unique = true)
    val id: UUID,
    @Column(name = "discharge_reason", nullable = false)
    val dischargeReason: String,

    @Temporal(TemporalType.DATE)
    @Column(name = "discharge_date", nullable = false)
    val dischargeDate: Date,

    @Column(name = "discharge_time", nullable = false)
    val dischargeTime: Timestamp,

    @Column(name = "discharge_notes", nullable = true)
    val dischargeNotes: String?,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "patient_nas", nullable = false, referencedColumnName = "nas")
    var patient: PatientJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "discharge_nurse_id", nullable = false, referencedColumnName = "staff_id")
    var dischargeNurse: StaffJpaEntity,
)