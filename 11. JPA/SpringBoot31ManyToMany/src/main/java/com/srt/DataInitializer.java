package com.srt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        
        // --- 0. Initial Cleanup ---
        studentRepository.deleteAll(); 
        courseRepository.deleteAll();
        
        // --- 1. Create Entities ---
        Student srt = new Student("SRT Sharma");
        Student alice = new Student("Alice Cooper");
        
        Course java = new Course(10, "Java Programming");
        Course spring = new Course(20, "Spring Boot Microservices");
        Course sql = new Course(30, "SQL & Database");
        
        // --- 2. Save Independent Entities (CRUCIAL FIX: Ensure they are managed) ---
        // Save courses first to ensure their IDs exist in the database and they are managed entities.
        // We use the returned managed instances for linking.
        Course managedJava = courseRepository.save(java);
        Course managedSpring = courseRepository.save(spring);
        Course managedSql = courseRepository.save(sql);
        
        // --- 3. Link the Relationship (using the MANAGED instances) ---
        
        // SRT enrolls in Java and Spring
        srt.getCourses().add(managedJava); // Use managed instance
        srt.getCourses().add(managedSpring);
        
        // Alice enrolls in Spring and SQL
        alice.getCourses().add(managedSpring);
        alice.getCourses().add(managedSql);
        
        // --- 4. Save the Owning Side (Student) ---
        // This will only insert into the join table because courses are already persisted.
        Student savedSrt = studentRepository.save(srt);
        Student savedAlice = studentRepository.save(alice);
        
        System.out.println("✅ Many-to-Many setup complete. Students saved.");
        
        // --- 5. Read and Verify the Join ---
        Student retrievedSrt = studentRepository.findById(savedSrt.getStudentId()).orElseThrow();
        System.out.println("\nRetrieved Student: " + retrievedSrt.getStudentName());
        System.out.println("Enrolled Courses: " + retrievedSrt.getCourses().size());
        
        retrievedSrt.getCourses().forEach(c -> System.out.println(" - " + c.getCourseTitle()));
        
        // Verification on the Inverse side
        Course retrievedSpring = courseRepository.findById(20).orElseThrow();
        System.out.println("\nCourse: " + retrievedSpring.getCourseTitle());
        System.out.println("Enrolled Students: " + retrievedSpring.getStudents().size());
    }
}