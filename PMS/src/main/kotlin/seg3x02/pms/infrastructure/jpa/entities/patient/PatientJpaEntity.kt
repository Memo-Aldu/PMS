package seg3x02.pms.infrastructure.jpa.entities.patient

import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.division.AdmissionRequestJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientAdmissionJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientDischargeJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.prescription.MedicationPrescriptionJpaEntity
import seg3x02.pms.infrastructure.jpa.enums.patient.MaritalStatusEnum
import java.util.Date


/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/

@Entity(name = "patient")
@Table(name = "patient")
class PatientJpaEntity(
    @Id
    @Column(name = "nas", nullable = false, unique = true)
    val nas: String,

    @Column(name = "first_name", nullable = false)
    var firstName: String,

    @Column(name = "last_name", nullable = false)
    var lastName: String,

    @Column(name = "phone_number", nullable = false)
    var phoneNumber: String,

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", nullable = false)
    var dob: Date,

    @Column(name = "gender", nullable = false)
    var gender: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status", nullable = false)
    var maritalStatus: MaritalStatusEnum,

    @Embedded
    var address: AddressJpaEntity,

    @Embedded
    var externalDoctor: ExternalDoctorJpaEntity,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "kin_id", nullable = false, referencedColumnName = "kin_id") // non-owning side
    var nextOfKin: PatientNextOfKinJpaEntity,

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, orphanRemoval = true) // non-owning side
    var admissionRequests: MutableList<AdmissionRequestJpaEntity> = ArrayList(),

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, orphanRemoval = true) // non-owning side
    var admissions: MutableList<PatientAdmissionJpaEntity> = ArrayList(),

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, orphanRemoval = true) // non-owning side
    var discharges: MutableList<PatientDischargeJpaEntity> = ArrayList(),

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, orphanRemoval = true) // non-owning side
    var prescriptions: MutableList<MedicationPrescriptionJpaEntity> = ArrayList()
)