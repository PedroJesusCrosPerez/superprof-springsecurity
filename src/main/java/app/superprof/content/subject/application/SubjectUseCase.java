package app.superprof.content.subject.application;

import app.superprof.content.subject.domain.entity.Subject;

import java.util.List;

public interface SubjectUseCase {

    Long saveSubject(Subject subject);

    Subject findByIdSubject(Long idSubject);

    List<Subject> findAllSubjects();

    Subject updateSubject(Subject subject);

    Boolean deleteByIdSubject(Long idSubject);
}
