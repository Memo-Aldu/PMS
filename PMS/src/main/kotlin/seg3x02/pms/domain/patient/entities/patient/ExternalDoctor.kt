package seg3x02.pms.domain.patient.entities.patient

import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class ExternalDoctor(
    val externalDoctorFirstName: String,
    val externalDoctorLastName: String,
    val externalDoctorPhoneNumber: String,
    val externalDoctorEmail: String,
)