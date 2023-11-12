package seg3x02.pms.domain.patient.entities.patient

import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.enums.PatientKinRelationshipEnum
import java.util.UUID


/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
class PatientNextOfKin(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
) {
    lateinit var address: Address;
    lateinit var relationship: PatientKinRelationshipEnum;
}