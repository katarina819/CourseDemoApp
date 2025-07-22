package com.example.demo;

import com.example.demo.service.StudentService;
import com.example.demo.repository.CourseRepository;
import com.example.demo.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentService studentService;
    private final CourseRepository courseRepo;

    // ✔ Home stranica s prikazom dostupnih tečajeva i korisničkih podataka
    @GetMapping("/")
public String home(Model model, Principal principal) {
    model.addAttribute("courses", courseRepo.findAll());
    boolean isAuthenticated = (principal != null);
    model.addAttribute("isAuthenticated", isAuthenticated);
    model.addAttribute("username", isAuthenticated ? principal.getName() : null);
    return "index";
}

    // ✔ Registracija studenta
    @GetMapping("/students/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/students/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentService.registerStudent(student);
        return "redirect:/";
    }

    // ✔ Prijava studenta na tečaj
    @PostMapping("/enroll")
    public String enroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        studentService.enrollStudent(studentId, courseId);
        return "redirect:/";
    }
}
