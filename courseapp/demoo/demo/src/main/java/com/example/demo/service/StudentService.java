package com.example.demo.service;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Student registerStudent(Student student) {
        return studentRepo.save(student);
    }

    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        Course course = courseRepo.findById(courseId).orElseThrow();
        student.getCourses().add(course);
        studentRepo.save(student);
    }
}
