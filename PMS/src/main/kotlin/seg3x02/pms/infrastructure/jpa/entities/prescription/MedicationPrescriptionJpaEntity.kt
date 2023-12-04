package seg3x02.pms.infrastructure.jpa.entities.prescription

import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.patient.PatientJpaEntity
import seg3x02.pms.infrastructure.jpa.enums.prescription.PrescriptionAdministrationMethodEnum
import java.util.Date
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-08, Wednesday
 **/
@Entity(name = "medication_prescription")
@Table(name = "medication_prescription")
class MedicationPrescriptionJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "prescription_id", nullable = false, unique = true)
    val id: UUID,

    @Column(name = "drug_number", nullable = false)
    val drugNumber: Long,

    @Column(name = "drug_name", nullable = false)
    val drugName: String,

    @Column(name = "unite_by_day", nullable = false)
    val uniteByDay: Int,

    @Column(name = "number_of_administration_per_day", nullable = false)
    val numberOfAdministrationPerDay: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "method_of_administration", nullable = false)
    val methodOfAdministration: PrescriptionAdministrationMethodEnum,

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    val startDate: Date,

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    val endDate: Date,

    @OneToMany(mappedBy = "prescription", fetch = FetchType.LAZY, orphanRemoval = true) // non-owning side
    var administrationTimes: MutableList<AdministrationTimeJpaEntity> = ArrayList(),

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "patient_nas", nullable = false, referencedColumnName = "nas")
    var patient: PatientJpaEntity
)