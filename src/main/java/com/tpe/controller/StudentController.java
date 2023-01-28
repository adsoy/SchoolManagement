package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Map<String,String>> createStudent(@Valid @RequestBody Student student){
        studentService.createStudent(student);

        Map<String,String> map = new HashMap<>();
        map.put("message","student create edildi");
        map.put("status","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
       List<Student> student= studentService.getAll();
        return ResponseEntity.ok(student);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteStudent(@RequestParam("id") Long id){

        studentService.deleteStudent(id);

        Map<String,String>map = new HashMap<>();
        map.put("message","student deleted");
        map.put("status","true");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    // id ile student bulma
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@RequestParam("id") Long id){
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }


}
