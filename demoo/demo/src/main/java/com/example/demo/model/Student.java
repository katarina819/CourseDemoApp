package com.example.demo.model;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
    return courses;
}
public void setCourses(List<Course> courses) {
    this.courses = courses;
}
}
