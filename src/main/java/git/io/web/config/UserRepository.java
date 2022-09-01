package git.io.web.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Members, Long> {
    Optional<Members> findByUserId(String userId);
}
