package seg3x02.pms.domain.patient.entities.patient

import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.patient.enums.MaritalStatusEnum
import java.sql.Date

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
class Patient(
    val nas: String,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var dob: Date,
    var gender: String,
    var maritalStatus: MaritalStatusEnum,
) {
    lateinit var address: Address;
    lateinit var nextOfKin: PatientNextOfKin;
    lateinit var externalDoctor: ExternalDoctor;

    fun update(patient: Patient) {
        this.firstName = patient.firstName
        this.lastName = patient.lastName
        this.phoneNumber = patient.phoneNumber
        this.dob = patient.dob
        this.gender = patient.gender
        this.maritalStatus = patient.maritalStatus
    }
}