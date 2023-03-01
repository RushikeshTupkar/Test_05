package com.exampleTest05.Test05.controller;

import com.exampleTest05.Test05.model.Laptop;
import com.exampleTest05.Test05.service.LaptopService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptop")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @PostMapping("/addLaptop")
    public ResponseEntity<Laptop> addLaptop(@RequestBody String laptop){
        JSONObject jsonObject = new JSONObject(laptop);
        return new ResponseEntity<>(laptopService.addLAptop(jsonObject), HttpStatus.CREATED);
    }

    @GetMapping("/getAll_laptop")
    public List<Laptop> getAllLaptop(){
        return laptopService.gellAllLaptop();
    }

    @DeleteMapping("/delete_laptop")
    public ResponseEntity<String> deleteLaptop(@RequestParam("laptop_id") String laptop_id){
        laptopService.deleteLaptop(laptop_id);
        return new ResponseEntity<>("Laptop deleted", HttpStatus.OK);
    }
}
