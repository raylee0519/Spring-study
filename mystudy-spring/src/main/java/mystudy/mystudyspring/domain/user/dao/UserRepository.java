package mystudy.mystudyspring.domain.user.dao;

import mystudy.mystudyspring.domain.user.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserData, UUID> {
}
