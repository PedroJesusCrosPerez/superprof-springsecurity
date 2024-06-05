package app.superprof.content.subject.infrastructure.controller;

import app.superprof.content.subject.application.SubjectUseCase;
import app.superprof.content.subject.application.mapper.SubjectMapper;
import app.superprof.content.subject.domain.entity.Subject;
import app.superprof.content.subject.infrastructure.controller.dto.input.SubjectInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectUseCase subjectUseCase;


    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    @GetMapping("/{idSubject}")
    public ResponseEntity<?> findByIdSubject(
            @PathVariable Long idSubject
            ,@RequestParam(value = "outerType", defaultValue = "simple") String outerType
    ) {

        Subject subject = subjectUseCase.findByIdSubject(idSubject);

        if ("full".equalsIgnoreCase(outerType)) {

            return  ResponseEntity
                    .status(
                            HttpStatus.ACCEPTED
                    )
                    .body(
                            SubjectMapper.INSTANCE.toOutputDtoFull(
                                    subject
                            )
                    );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        SubjectMapper.INSTANCE.toOutputDto(
                                subject
                        )
                );
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    @GetMapping
    public ResponseEntity<?> findAllSubjects(
            @RequestParam(value = "outerType", defaultValue = "simple") String outerType
    ) {

        List<Subject> subjectList = subjectUseCase.findAllSubjects();

        if ("full".equalsIgnoreCase(outerType)) {

            return  ResponseEntity
                    .status(
                            HttpStatus.ACCEPTED
                    )
                    .body(
                            SubjectMapper.INSTANCE.toOutputDtoFullList(
                                    subjectList
                            )
                    );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        SubjectMapper.INSTANCE.toOutputDtoList(
                                subjectList
                        )
                );
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    @PostMapping
    public ResponseEntity<Long> saveSubject(
            @RequestBody SubjectInputDto subjectInputDto
    ) {

        Long idSubject = subjectUseCase.saveSubject(
                SubjectMapper.INSTANCE.toEntity(
                        subjectInputDto
                )
        );

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        idSubject
                );
    }
}
