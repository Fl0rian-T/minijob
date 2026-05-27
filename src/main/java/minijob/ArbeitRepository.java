package minijob;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArbeitRepository extends JpaRepository<ArbeitEntity, Long> {
}