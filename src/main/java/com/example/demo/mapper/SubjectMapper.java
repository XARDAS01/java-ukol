package com.example.demo.mapper;

import com.example.demo.api.CreateSubjectRequest;
import com.example.demo.api.SubjectResponse;
import com.example.demo.domain.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

  @Mapping(target = "lastName", source = "givenName")
  Subject map(CreateSubjectRequest request);

  SubjectResponse map(Subject subject);
}
