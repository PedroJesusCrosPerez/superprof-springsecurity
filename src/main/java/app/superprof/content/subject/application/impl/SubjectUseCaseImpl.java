package app.superprof.content.subject.application.impl;

import app.superprof.content.subject.application.SubjectUseCase;
import app.superprof.content.subject.domain.entity.Subject;
import app.superprof.content.subject.domain.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectUseCaseImpl implements SubjectUseCase {

    private final SubjectRepository subjectRepository;


    @Override
    public Long saveSubject(Subject subject) {

        return subjectRepository.saveSubject(subject);
    }

    @Override
    public Subject findByIdSubject(Long idSubject) {

        return subjectRepository.findByIdSubject(idSubject);
    }

    @Override
    public List<Subject> findAllSubjects() {

        return subjectRepository.findAllSubjects();
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
