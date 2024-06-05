package app.superprof.content.role.domain.repository;

import java.util.Optional;

import app.superprof.shared.enums.ERole;
import app.superprof.content.role.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
