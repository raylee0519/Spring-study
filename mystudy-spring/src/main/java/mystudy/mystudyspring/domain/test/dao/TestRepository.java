package mystudy.mystudyspring.domain.test.dao;

import mystudy.mystudyspring.domain.test.domain.TestData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestRepository extends JpaRepository<TestData, UUID> {
}
