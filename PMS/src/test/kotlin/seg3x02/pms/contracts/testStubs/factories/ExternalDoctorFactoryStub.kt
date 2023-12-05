package seg3x02.pms.contracts.testStubs.factories

import seg3x02.pms.application.dtos.queries.ExternalDoctorDto
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.factory.ExternalDoctorFactory

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/4/2023, Monday
 **/
class ExternalDoctorFactoryStub: ExternalDoctorFactory {
    override fun createExternalDoctor(externalDoctor: ExternalDoctorDto): ExternalDoctor {
        return ExternalDoctor(
            externalDoctor.firstName,
            externalDoctor.lastName,
            externalDoctor.email,
            externalDoctor.phoneNumber,
        )
    }
}