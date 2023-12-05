package seg3x02.pms.infrastructure.web.forms

import javax.validation.constraints.NotEmpty

class PatientRegistrationForm{
    @NotEmpty(message = "Patient NAS is required")
    var nas: String? = null

    @NotEmpty(message = "First Name is required")
    var firstName: String? = null

    @NotEmpty(message = "Last Name is required")
    var lastName: String? = null

    @NotEmpty(message = "Phone Number is required")
    var phoneNumber: String? = null

    @NotEmpty(message = "Date of Birth is required")
    var dob: String? = null

    @NotEmpty(message = "Gender is required")
    var gender: String? = null

    @NotEmpty(message = "Marital Status is required")
    var maritalStatus: String? = null

    @NotEmpty(message = "External Doctor ID is required")
    var externalDoctorID: String? = null

    @NotEmpty(message = "Street Address is required")
    var addressStreet: String? = null

    @NotEmpty(message = "City is required")
    var addressCity: String? = null

    @NotEmpty(message = "Country is required")
    var addressCountry: String? = null

    @NotEmpty(message = "Postal Code is required")
    var addressPostalCode: String? = null

    @NotEmpty(message = "Next of Kin First Name is required")
    var nextOfKinFirstName: String? = null

    @NotEmpty(message = "Next of Kin Last Name is required")
    var nextOfKinLastName: String? = null
}