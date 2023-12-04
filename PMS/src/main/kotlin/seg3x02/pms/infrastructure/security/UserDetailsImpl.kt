package seg3x02.pms.infrastructure.security

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import seg3x02.pms.infrastructure.jpa.entities.user.UserAccountJpaEntity

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/3/2023, Sunday
 **/
class UserDetailsImpl(
    val id: String,
    private val username: String,
    @field:JsonIgnore
    private val password: String,
    private val enabled: Boolean,
    private val authorities: Collection<GrantedAuthority>
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return enabled
    }
}

fun build(user: UserAccountJpaEntity): UserDetailsImpl {
    val authorities = ArrayList<GrantedAuthority>()
    authorities.add(SimpleGrantedAuthority(user.role.toString()))
    return UserDetailsImpl(
        user.nas,
        user.firstName + " " + user.lastName,
        user.password,
        true,
        authorities)
}