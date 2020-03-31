package $package;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntityRepository extends JpaRepository<DbEntity, Long> {

    Optional<DbEntity> findById(Long id);
}
