package app.superprof.content.subject.infrastructure.repository.impl;

import app.superprof.content.subject.application.mapper.SubjectMapper;
import app.superprof.content.subject.domain.entity.Subject;
import app.superprof.content.subject.domain.repository.SubjectRepository;
import app.superprof.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.superprof.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectRepositoryImpl implements SubjectRepository {

    private final SubjectRepositoryJpa subjectRepositoryJpa;


    @Override
    public Long saveSubject(Subject subject) {

        return subjectRepositoryJpa.save(
                SubjectMapper.INSTANCE.toEntityJpa(subject)
        ).getIdSubject();
    }

    @Override
    public Subject findByIdSubject(Long idSubject) {

        return subjectRepositoryJpa.findById(idSubject)
                .map(SubjectMapper.INSTANCE::toEntity)
                .orElseThrow( () -> new NotFoundException(Subject.class, idSubject) );
    }

    @Override
    public List<Subject> findAllSubjects() {

        return subjectRepositoryJpa.findAll().stream()
                .map(SubjectMapper.INSTANCE::toEntity)
                .toList();
    }

    @Override
    public Subject updateSubject(Subject subject) {

        return null;
    }

    @Override
    public Boolean deleteByIdSubject(Long idSubject) {

        return null;
    }
}
