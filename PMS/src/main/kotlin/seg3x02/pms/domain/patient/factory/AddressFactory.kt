package seg3x02.pms.domain.patient.factory

import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.domain.patient.entities.patient.Address

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface AddressFactory {
    fun createAddress(address: AddressRegisterDto): Address
}