package com.exampleTest05.Test05.controller;

import com.exampleTest05.Test05.model.Student;
import com.exampleTest05.Test05.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentColtroller {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody String student){
        JSONObject jsonObject = new JSONObject(student);
         return new ResponseEntity<>(studentService.addStudent(jsonObject), HttpStatus.CREATED);
    }
    @GetMapping("/get_all_students")
    public List<Student> getALLStudents(@Nullable @RequestParam("student_id") String student_id){
        return studentService.getAllStudents(student_id);
    }

    @DeleteMapping("delete_student_by_id")
    public ResponseEntity<String> deleteStudent(@RequestParam("student_id") String student_id){
        studentService.deleteStudentById(student_id);
        return new ResponseEntity<>("Student_deleted",HttpStatus.OK);
    }

    @PutMapping("/update_student")
    public ResponseEntity<String> updateStudentDatails(@RequestBody String student){
        JSONObject jsonObject = new JSONObject(student);
        Student student1 = studentService.updateStudent(jsonObject);
        return new ResponseEntity<>(student1.toString(),HttpStatus.OK);
    }

}