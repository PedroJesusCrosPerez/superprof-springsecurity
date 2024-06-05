package app.superprof.content.subject.application.mapper;

import app.superprof.content.subject.domain.entity.Subject;
import app.superprof.content.subject.infrastructure.controller.dto.input.SubjectInputDto;
import app.superprof.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import app.superprof.content.subject.infrastructure.controller.dto.output.SubjectOutputDtoFull;
import app.superprof.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {TeacherEntityMapper.class})
public interface SubjectMapper {

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);


    // Entity
    Subject toEntity(SubjectInputDto subjectInputDto);

    Subject toEntity(SubjectJpa subjectJpa);

    SubjectJpa toEntityJpa(Subject subject);

    List<Subject> toEntityList(List<SubjectJpa> subjectJpaList);

    // DTO
    List<SubjectOutputDto> toOutputDtoList(List<Subject> subjectList);

    List<SubjectOutputDtoFull> toOutputDtoFullList(List<Subject> subjectList);

    SubjectOutputDtoFull toOutputDtoFull(Subject subject);

    SubjectOutputDto toOutputDto(Subject subject);
}
