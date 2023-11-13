package seg3x02.pms.domain.staff.facade

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface StaffFacade {
    fun hasExternalDoctor(externalDoctorID: String): Boolean
}