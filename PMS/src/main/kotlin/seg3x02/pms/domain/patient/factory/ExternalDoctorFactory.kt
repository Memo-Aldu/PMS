package seg3x02.pms.domain.patient.factory

import seg3x02.pms.application.dtos.queries.ExternalDoctorDto
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/4/2023, Monday
 **/
interface ExternalDoctorFactory {
    fun createExternalDoctor(externalDoctor: ExternalDoctorDto): ExternalDoctor
}