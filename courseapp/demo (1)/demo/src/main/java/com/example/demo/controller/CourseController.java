package com.example.demo;
import java.security.Principal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        List<Course> courses = courseRepository.findAll();  // 🔹 Dodano!
        model.addAttribute("courses", courses);             // 🔹 Dodano!
        model.addAttribute("isAuthenticated", principal != null);
        model.addAttribute("username", principal != null ? principal.getName() : null); // 🔹 Za prikaz imena
        return "index";
    }

    @GetMapping("/admin")
    public String adminPanel(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "admin";    // Očekuje se src/main/resources/templates/admin.html
    }
}
