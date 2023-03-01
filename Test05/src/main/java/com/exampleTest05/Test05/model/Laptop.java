package com.exampleTest05.Test05.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Laptop {
    @Id
    private String laptop_id;
    private String name;
    private String brand;
    private String price;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
