package seg3x02.pms.infrastructure.jpa.entities.division

import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientAdmissionJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.staff.StaffJpaEntity
import seg3x02.pms.infrastructure.jpa.enums.division.DivisionStatus
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
@Entity(name = "division")
@Table(name = "division")
class DivisionJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "division_id", nullable = false, unique = true)
    val id: UUID,

    @Column(name = "division_name", nullable = false, unique = true)
    val divisionName: String,

    @Column(name = "location", nullable = false)
    val location: String,

    @Column(name = "total_beds", nullable = false)
    val totalBeds: Int,

    @Column(name = "telephone_extension", nullable = true)
    val telephoneExtension: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "division_status", nullable = false, columnDefinition = "varchar(20) default 'INCOMPLETE'")
    var divisionStatus: DivisionStatus,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "charge_nurse_id", referencedColumnName = "staff_id")
    var chargeNurse: StaffJpaEntity?,

    @ElementCollection
    @CollectionTable(name = "division_staffs", joinColumns = [JoinColumn(name = "division_id")])
    var staffs: MutableList<UUID>? = null,

    @OneToMany(mappedBy = "division", cascade = [CascadeType.ALL], orphanRemoval = true)
    var rooms: MutableList<RoomJpaEntity> = ArrayList(),

    @ElementCollection
    @CollectionTable(name = "division_patient_admission_requests", joinColumns = [JoinColumn(name = "division_id")])
    var patientAdmissionRequestList: MutableList<String> = ArrayList(),

)
