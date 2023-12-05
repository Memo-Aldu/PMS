package seg3x02.pms.infrastructure.jpa.entities.patient

import jakarta.persistence.*
import seg3x02.pms.infrastructure.jpa.enums.patient.PatientKinRelationshipEnum
import java.util.UUID


/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
@Entity(name = "patient_next_of_kin")
@Table(name = "patient_next_of_kin")
class PatientNextOfKinJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "kin_id", nullable = false, unique = true)
    val id: UUID,

    @Column(name = "first_name", nullable = false)
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    val lastName: String,

    @Column(name = "phone_number", nullable = false)
    val phoneNumber: String,

    @Embedded
    val address: AddressJpaEntity,

    @Enumerated(EnumType.STRING)
    @Column(name = "relationship", nullable = false)
    val relationship: PatientKinRelationshipEnum,

    @OneToOne(mappedBy = "nextOfKin") // owning side
    var patient: PatientJpaEntity,
)