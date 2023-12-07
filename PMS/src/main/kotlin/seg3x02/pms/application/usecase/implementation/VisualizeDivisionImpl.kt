package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.reponses.DivisionBrowsDto
import seg3x02.pms.application.usecase.VisualizeDivision
import seg3x02.pms.domain.division.facade.DivisionFacade
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
class VisualizeDivisionImpl(
    private val divisionFacade: DivisionFacade
): VisualizeDivision {
    override fun visualizeDivision(divisionId: UUID): DivisionBrowsDto? {
        val division = divisionFacade.getDivision(divisionId) ?: return null
        return DivisionBrowsDto(division)
    }
}