package seg3x02.pms.infrastructure.jpa.entities.user

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import seg3x02.pms.infrastructure.jpa.entities.staff.StaffJpaEntity
import seg3x02.pms.infrastructure.jpa.enums.user.UserRoleEnum

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-04, Saturday
 **/
@Entity(name = "user_account")
@Table(name = "user_account")
class UserAccountJpaEntity(
        @Id
        @NotBlank(message = "NAS is required")
        @Column(name = "nas", nullable = false, unique = true)
        val nas: String,

        @NotBlank(message = "Password is required")
        @Column(name = "password", nullable = false)
        val password: String,

        @NotBlank(message = "First name is required")
        @Column(name = "first_name", nullable = false)
        val firstName: String,

        @NotBlank(message = "Last name is required")
        @Column(name = "last_name", nullable = false)
        val lastName: String,
        @Column(name = "email", nullable = false)
        val email: String,

        @Enumerated(EnumType.STRING)
        @Column(name = "role", nullable = false)
        var role: UserRoleEnum,

        @OneToOne(mappedBy = "user") // non-owning side
        var staff: StaffJpaEntity,
)