package com.exampleTest05.Test05.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    @Id
    private String course_id;
    private String title;
    private String description;
    private String duration;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Student> studentList = new ArrayList<>();

}
