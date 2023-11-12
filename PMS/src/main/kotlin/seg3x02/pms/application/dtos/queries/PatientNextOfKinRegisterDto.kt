package seg3x02.pms.application.dtos.queries

import seg3x02.pms.application.enums.PatientKinRelationshipEnum

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class PatientNextOfKinRegisterDto(
        val firstName: String,
        val lastName: String,
        val phoneNumber: String,
        val address: AddressRegisterDto,
        val relationship: PatientKinRelationshipEnum
)
