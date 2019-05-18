package green.belka.backend.repository;

import green.belka.backend.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

}
