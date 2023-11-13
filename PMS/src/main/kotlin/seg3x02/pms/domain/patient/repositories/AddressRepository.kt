package seg3x02.pms.domain.patient.repositories

import seg3x02.pms.domain.patient.entities.patient.Address

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface AddressRepository {
    fun save(address: Address): Address
    fun findById(id: String): Address?
}