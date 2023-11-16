package seg3x02.pms.contracts.steps

import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.enums.BedStatus
import seg3x02.pms.domain.division.enums.DivisionStatus
import seg3x02.pms.domain.division.enums.RoomStatus
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.enums.PatientKinRelationshipEnum
import seg3x02.pms.domain.patient.repositories.ExternalDoctorRepository
import seg3x02.pms.domain.staff.entities.Staff
import seg3x02.pms.domain.staff.enums.StaffRoleEnum
import seg3x02.pms.domain.staff.repository.StaffRepository
import seg3x02.pms.domain.user.entities.UserAccount
import seg3x02.pms.domain.user.entities.UserRole
import java.sql.Date
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/

fun createStaff(staffRepository: StaffRepository): Staff {
    val staff = Staff(
        "123456789",
        UUID.randomUUID()
    )
    staff.role = StaffRoleEnum.CHARGE_NURSE
    staff.user = createUserAccount()
    return staffRepository.save(staff)
}

fun createUserAccount(): UserAccount {
    val user = UserAccount(
        "123456789",
        "password",
        "Memo",
        "Aldu",
        "info@pms.com")
    user.role = UserRole(
        UUID.randomUUID(),
        "ADMIN"
    )
    return user
}

fun createPatientInfo(externalDoctorId : UUID): PatientRegisterDto {
    return PatientRegisterDto(
        "123456789",
        "Memo",
        "Aldu",
        "123-456-7890",
        Date.valueOf("2023-11-08"),
        "M",
        seg3x02.pms.application.enums.MaritalStatusEnum.MARRIED,
        externalDoctorId,
        createAddressDto(),
        createPatientNextOfKinDto(),
    )
}

fun createAddressDto(): AddressRegisterDto {
    return AddressRegisterDto(
        "123 Fake Street",
        "Ottawa",
        "Canada",
        "K1A 0G9"
    )
}

fun createPatientNextOfKinDto(): PatientNextOfKinRegisterDto {
     return PatientNextOfKinRegisterDto(
        "Jon",
        "Doe",
        "123-456-7870",
        address = createAddressDto(),
        relationship = seg3x02.pms.application.enums.PatientKinRelationshipEnum.FATHER
    )
}

fun createExternalDoctor(repository: ExternalDoctorRepository): ExternalDoctor {
    val dco =  ExternalDoctor(
        UUID.randomUUID(),
        "John",
        "Doe",
        "123-456-7770",
        "blah@gmail.com"
    )
    return repository.save(dco)
}

fun createNextOfKin(): PatientNextOfKin {
    val kin = PatientNextOfKin(
        UUID.randomUUID(),
        "Jon",
        "Doe",
        "123-456-7870"
    )
    kin.address = createAddress()
    kin.relationship = PatientKinRelationshipEnum.FATHER
    return kin

}

fun createAddress(): Address {
    return Address(
        UUID.randomUUID(),
        "123 Fake Street",
        "Ottawa",
        "Canada",
        "K1A 0G9"
    )
}

fun createDivision(status: DivisionStatus): Division {
    val d =  Division(
        UUID.randomUUID(),
        "Emergency",
        "Emergency",
        1,
        "Emergency"
    )
    d.setDivisionStatus(status)
    return d
}

fun createRoom(division: Division, roomStatus: RoomStatus): Room {
    val r = Room(
        UUID.randomUUID(),
    )
    r.setRoomStatus(roomStatus)
    return r
}

fun createBed(room: Room, bedStatus: BedStatus): Bed {
    val b = Bed(
        UUID.randomUUID(),
    )
    b.setBedStatus(bedStatus)
    return b
}

fun createAdmissionInfo(patient: Patient, division: Division, room: Room, bed: Bed): PatientAdmissionToDivisionDto {
    return PatientAdmissionToDivisionDto(
        UUID.randomUUID(),
        patient.nas,
        division.id,
        UUID.randomUUID().toString(),
        UUID.randomUUID().toString(),
        room.id,
        bed.id,
        null
    )
}
