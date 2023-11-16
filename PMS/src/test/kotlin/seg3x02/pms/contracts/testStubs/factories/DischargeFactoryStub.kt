package seg3x02.pms.contracts.testStubs.factories

import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.PatientDischargeDto
import seg3x02.pms.domain.patient.entities.admission.PatientDischarge
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.factory.AddressFactory
import seg3x02.pms.domain.patient.factory.PatientDischargeFactory
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
class DischargeFactoryStub: PatientDischargeFactory {

    override fun createPatientDischarge(patientDischargeDto: PatientDischargeDto): PatientDischarge {
        TODO("Not yet implemented")
    }
}