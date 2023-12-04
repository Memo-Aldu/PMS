package seg3x02.pms.infrastructure.jpa.entities.staff

import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.division.AdmissionRequestJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.division.DivisionJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientAdmissionJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientDischargeJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.user.UserAccountJpaEntity
import seg3x02.pms.infrastructure.jpa.enums.staff.StaffRoleEnum
import java.util.ArrayList

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-23, Thursday
 **/
@Entity(name = "staff")
@Table(name = "staff")
class StaffJpaEntity(
    @Id
    @Column(name = "staff_id", nullable = false, unique = true)
    val staffId: String,
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "varchar(20)")
    var role: StaffRoleEnum,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id", nullable = false, referencedColumnName = "nas", unique = true)
    var user: UserAccountJpaEntity,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    val division: DivisionJpaEntity,

    @OneToOne(mappedBy = "chargeNurse", cascade = [CascadeType.ALL], orphanRemoval = true)
    var divisionChargeNurse: DivisionJpaEntity? = null,

    @OneToMany(mappedBy = "requestingChargedNurse", cascade = [CascadeType.ALL], orphanRemoval = true)
    var admissionRequest: MutableList<AdmissionRequestJpaEntity> = ArrayList(),

    @OneToMany(mappedBy = "requestingChargedNurse", cascade = [CascadeType.ALL], orphanRemoval = true)
    var patientAdmissionRequestList: MutableList<PatientAdmissionJpaEntity> = ArrayList(),

    @OneToMany(mappedBy = "acceptingChargedNurse", cascade = [CascadeType.ALL], orphanRemoval = true)
    var patientAdmissionAcceptedList: MutableList<PatientAdmissionJpaEntity> = ArrayList(),

    @OneToMany(mappedBy = "dischargeNurse", cascade = [CascadeType.ALL], orphanRemoval = true)
    var patientDischargeList: MutableList<PatientDischargeJpaEntity> = ArrayList(),
)