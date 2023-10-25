package com.example.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentsystem.model.Student;
import com.example.studentsystem.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
   @Autowired
   private StudentService studentService;

   @CrossOrigin
   @PostMapping("/add")
   public ResponseEntity add(@RequestBody Student student) {
      return ResponseEntity.ok(studentService.saveStudent(student));
   }

   @CrossOrigin
   @GetMapping("")
   public ResponseEntity getAll() {
      return ResponseEntity.ok(studentService.getAllStudents());
   }
}
