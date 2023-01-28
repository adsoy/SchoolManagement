package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void createStudent(Student student) {

       if (studentRepository.existsByEmail(student.getEmail())){
           throw new ConflictException("e mail zaten mevcuttur.");
       }

       studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id){
     return studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("boyle bir id yoktur"));

    }

    public void deleteStudent(Long id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }
}
