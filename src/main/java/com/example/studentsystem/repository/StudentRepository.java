package com.example.studentsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.example.studentsystem.model.Student;

@Repository
@PreAuthorize("hasRole('ROLE_MANAGER')")
public interface StudentRepository
      extends CrudRepository<Student, Integer>, PagingAndSortingRepository<Student, Integer> {
   @Override
   @PreAuthorize("#student?.manager == null or #student?.manager?.name == authentication?.name")
   Student save(@Param("student") Student student);

   // @Override
   // @PreAuthorize("@studentRepository.findById(#id)?.manager?.name
   // ==authentication?.name")
   // void deleteById(@Param("id") int id);

   @Override
   @PreAuthorize("#student?.manager?.name == authentication?.name")
   void delete(@Param("student") Student student);
}