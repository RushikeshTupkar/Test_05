package com.exampleTest05.Test05.service;

import com.exampleTest05.Test05.model.Address;
import com.exampleTest05.Test05.model.Student;
import com.exampleTest05.Test05.repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(JSONObject jsonObject) {
        Student student = new Student();
        String student_id = UUID.randomUUID().toString();
        student.setStudent_id(student_id);
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getInt("age"));
        student.setPhone_number(jsonObject.getString("phone_number"));
        student.setBranch(jsonObject.getString("branch"));
        student.setDepartment(jsonObject.getString("department"));
        Address address = new Address();
        address.setLandmark(jsonObject.getString("landmark"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setDistrict(jsonObject.getString("district"));
        address.setState(jsonObject.getString("state"));
        address.setCountry(jsonObject.getString("country"));
        student.setAddress(address);
        return studentRepository.save(student);

    }

    public List<Student> getAllStudents(String studentId) {
        if(studentId!=null){
            List<Student>list = new ArrayList<>();
            list.add(studentRepository.findById(studentId).get());
            return list;
        }return studentRepository.findAll();
    }

    public void deleteStudentById(String studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student updateStudent(JSONObject jsonObject) {
        Student student = studentRepository.findById(jsonObject.getString("student_id")).get();
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getInt("age"));
        student.setPhone_number(jsonObject.getString("phone_number"));
        student.setBranch(jsonObject.getString("branch"));
        student.setDepartment(jsonObject.getString("department"));
        Address address = new Address();
        address.setLandmark(jsonObject.getString("landmark"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setDistrict(jsonObject.getString("district"));
        address.setState(jsonObject.getString("state"));
        address.setCountry(jsonObject.getString("country"));
        student.setAddress(address);
        return studentRepository.save(student);
    }
}
