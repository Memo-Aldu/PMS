package seg3x02.pms.infrastructure.jpa.entities.prescription

import jakarta.persistence.*
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-08, Wednesday
 **/
@Table(name = "administration_time")
@Entity(name = "administration_time")
class AdministrationTimeJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "administration_time_id", nullable = false, unique = true)
    val administrationTimeID: UUID,

    @Temporal(TemporalType.DATE)
    @Column(name = "time_of_day", nullable = false)
    val timeOfDay: Date,

    @Column(name = "unites_administered", nullable = false)
    val unitesAdministered: Int,

    @ManyToOne(fetch = FetchType.LAZY) // owning side
    @JoinColumn(name = "prescription_id", nullable = false, referencedColumnName = "prescription_id")
    var prescription: MedicationPrescriptionJpaEntity,
)