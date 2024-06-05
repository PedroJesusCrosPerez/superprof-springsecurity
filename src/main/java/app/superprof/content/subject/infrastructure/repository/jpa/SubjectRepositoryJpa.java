package app.superprof.content.subject.infrastructure.repository.jpa;

import app.superprof.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepositoryJpa extends JpaRepository<SubjectJpa, Long> {
}
