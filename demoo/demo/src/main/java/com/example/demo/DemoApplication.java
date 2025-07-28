package com.example.demo;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
CommandLineRunner initData(CourseRepository courseRepository) {
    return args -> {
        courseRepository.deleteAll(); // OBRIŠI sve prije dodavanja
        courseRepository.save(new Course("Full Stack Web Development", "Sveobuhvatno znanje za izradu web aplikacija (frontend + backend)"));
        courseRepository.save(new Course("Python Programming", "Svestrani jezik – koristi se u analitici, AI-u, webu i automatizaciji"));
        courseRepository.save(new Course("Data Science with Python", "Analiza podataka, statistika i strojno učenje – vrlo traženo"));
        courseRepository.save(new Course("Machine Learning / AI (Python + TensorFlow, PyTorch)", "Potražnja raste zbog AI revolucije (ChatGPT, Copilot, itd)"));
        courseRepository.save(new Course("DevOps & Cloud Computing (AWS, Docker, Kubernetes)", "Neophodno znanje za moderne CI/CD i cloud sisteme"));
        courseRepository.save(new Course("Java + Spring Boot za Backend razvoj", "Popularno u korporacijama i enterprise rješenjima"));
        courseRepository.save(new Course("Mobile App Development (Flutter, React Native)", "Povećana potražnja za cross-platform mobilnim aplikacijama"));
        courseRepository.save(new Course("Cybersecurity Fundamentals", "Sigurnost je ključna – sve više firmi ulaže u zaštitu podataka"));
        courseRepository.save(new Course("SQL & Relacijske baze podataka", "Temelj za analizu podataka i backend razvoj"));
        courseRepository.save(new Course("C# i .NET za izradu poslovnih aplikacija", "Koristi se u mnogim kompanijama za desktop/web aplikacije"));
    };
}

}


