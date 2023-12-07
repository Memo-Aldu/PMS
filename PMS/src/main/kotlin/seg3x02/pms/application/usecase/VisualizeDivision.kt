package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.reponses.DivisionBrowsDto
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
interface VisualizeDivision {
    fun visualizeDivision(divisionId: UUID): DivisionBrowsDto?
}