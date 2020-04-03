package $package;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemplateRepository extends JpaRepository<TemplateEntity, Long> {

  Optional<TemplateEntity> findById(Long id);
}
