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
public class Book {
    @Id
    private String book_id;
    private String title;
    private String author;
    private String descreiption;
    private String price;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

}
