package com.exampleTest05.Test05.service;

import com.exampleTest05.Test05.model.Laptop;
import com.exampleTest05.Test05.model.Student;
import com.exampleTest05.Test05.repository.LaptopReporitory;
import com.exampleTest05.Test05.repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LaptopService {
    @Autowired
    private LaptopReporitory laptopReporitory;

    @Autowired
    private StudentRepository studentRepository;

    public Laptop addLAptop(JSONObject jsonObject) {
        Laptop laptop = new Laptop();
        String laptop_id = UUID.randomUUID().toString();
        laptop.setLaptop_id(laptop_id);
        laptop.setName(jsonObject.getString("name"));
        laptop.setBrand(jsonObject.getString("brand"));
        laptop.setPrice(jsonObject.getString("price"));
        Student student = studentRepository.findById(jsonObject.getString("student_id")).get();
        laptop.setStudent(student);
        return laptopReporitory.save(laptop);
    }

    public List<Laptop> gellAllLaptop() {
        return laptopReporitory.findAll();
    }

    public void deleteLaptop(String laptopId) {
        laptopReporitory.deleteById(laptopId);
    }
}
