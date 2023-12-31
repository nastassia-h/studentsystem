package com.example.studentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentsystem.model.Student;
import com.example.studentsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

   @Autowired
   private StudentRepository studentRepository;

   @Override
   public Student saveStudent(Student student) {
      return studentRepository.save(student);
   }

   @Override
   public Iterable<Student> getAllStudents() {
      return studentRepository.findAll();
   }
}
