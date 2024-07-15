package lee.cho.chan.otl.user.repository

import lee.cho.chan.otl.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}