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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    @Id
    private String student_id;
    private String name;
    private Integer age;
    private String phone_number;
    private String branch;
    private String department;
    @Embedded
    private Address address;
   @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "student")
    private Laptop laptop;

}
