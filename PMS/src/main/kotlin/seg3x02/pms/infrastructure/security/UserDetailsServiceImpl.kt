package seg3x02.pms.infrastructure.security

import jakarta.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import seg3x02.pms.infrastructure.jpa.dao.UserAccountJpaRepository
import seg3x02.pms.infrastructure.jpa.entities.user.UserAccountJpaEntity

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/3/2023, Sunday
 **/
@Service
class UserDetailsServiceImpl(val userRepository: UserAccountJpaRepository): UserDetailsService {

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(nas: String): UserDetails {
        val user: UserAccountJpaEntity = userRepository.findById(nas)
            .orElseThrow { UsernameNotFoundException("User with nas: $nas not found") }
        return build(user)
    }
}