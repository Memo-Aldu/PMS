package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.RoomJpaConverter
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.repositories.RoomRepository
import seg3x02.pms.infrastructure.jpa.dao.RoomJpaRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/

@Component
@CacheConfig(cacheNames = ["rooms"])
class RoomJpaAdapter(private val roomRepository: RoomJpaRepository): RoomRepository {
    private val converter = Mappers.getMapper(RoomJpaConverter::class.java)

    @Cacheable(key = "#id")
    override fun findById(id: UUID): Room? {
        val roomJpa = roomRepository.findByIdOrNull(id)
        return roomJpa?.let { converter.convertToModel(it) }
    }

    @CachePut(key = "#room.id")
    override fun save(room: Room): Room? {
        val roomJpa = converter.convertToJpaEntity(room)
        roomRepository.save(roomJpa)
        return room
    }

}