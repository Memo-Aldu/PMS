package seg3x02.pms.infrastructure.web.forms

import java.time.LocalDateTime
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

class AdministrationTimeForm {
    @NotNull(message = "Time of Day is required")
    var timeOfDay: LocalDateTime? = null

    @Min(value = 1, message = "Units Administered must be at least 1")
    var unitsAdministered: Int? = null
}
