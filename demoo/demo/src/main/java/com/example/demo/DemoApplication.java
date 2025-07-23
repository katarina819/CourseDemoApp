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
    if (courseRepository.count() == 0) {
      courseRepository.save(new Course("Java Programming", "Uvod u Java programiranje"));
      courseRepository.save(new Course("Python Basics", "Osnove Pythona"));
      courseRepository.save(new Course("Web Development", "HTML, CSS i JavaScript"));
      courseRepository.save(new Course("Spring Boot", "Izrada REST API-ja sa Spring Bootom"));
      courseRepository.save(new Course("Data Structures", "Osnove struktura podataka"));
      courseRepository.save(new Course("Algorithms", "Uvod u algoritme"));
      courseRepository.save(new Course("Databases", "Rad s relacijskim bazama podataka"));
      courseRepository.save(new Course("React.js", "Frontend razvoj s Reactom"));
      courseRepository.save(new Course("Docker", "Uvod u kontejnerizaciju s Dockerom"));
      courseRepository.save(new Course("DevOps Basics", "Osnove DevOps prakse"));
    }
  };
}
}

