package com.srt; // Assuming your service package


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.CommandLineRunner; // Useful for running setup logic

@Component
public class DatabaseOperation implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    /**
     * Executes the setup logic automatically upon Spring Boot application start.
     */
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        runManyToManyDemo();
    }
    
    /**
     * Main logic to set up, save, and verify the Many-to-Many relationship.
     */
    @Transactional
    public void runManyToManyDemo() {
        System.out.println("\n==================================================");
        System.out.println("🔄 STARTING MANY-TO-MANY ENROLLMENT DEMO");
        
        // --- 1. Cleanup and Create Independent Entities ---
        studentRepository.deleteAll(); 
        courseRepository.deleteAll();
        
        Student srt = new Student("SRT Sharma");
        Student alice = new Student("Alice Cooper");
        
        // Ensure courses are saved first as they have independent IDs
        Course java = courseRepository.save(new Course(10, "Java Programming"));
        Course spring = courseRepository.save(new Course(20, "Spring Boot Microservices"));
        Course sql = courseRepository.save(new Course(30, "SQL & Database"));
        
        // --- 2. Link the Relationship (CRUCIAL: From the Owning Side - Student) ---
        
        // SRT enrolls in Java and Spring
        srt.getCourses().add(java);
        srt.getCourses().add(spring);
        
        // Alice enrolls in Spring and SQL
        alice.getCourses().add(spring);
        alice.getCourses().add(sql);
        
        // --- 3. Save the Owning Side ---
        // Cascading ensures the join table entries are created.
        Student savedSrt = studentRepository.save(srt);
        Student savedAlice = studentRepository.save(alice);
        
        System.out.println("✅ Enrollment Data Saved.");
        System.out.println("--------------------------------------------------");
        
        // --- 4. Read and Verify the Join from the Owning Side (Student) ---
        verifyEnrollment(savedSrt.getStudentId());

        // --- 5. Read and Verify the Join from the Inverse Side (Course) ---
        verifyCourseEnrollment(spring.getCourseId());
    }
    
    /**
     * Helper method to retrieve and print a student's course list.
     */
    @Transactional(readOnly = true)
    public void verifyEnrollment(Long studentId) {
        Student retrievedStudent = studentRepository.findById(studentId).orElseThrow();
        
        System.out.println("🔎 Student: " + retrievedStudent.getStudentName());
        System.out.println("   Enrolled in " + retrievedStudent.getCourses().size() + " courses:");
        
        retrievedStudent.getCourses().forEach(c -> System.out.println("   - " + c.getCourseTitle()));
    }

    /**
     * Helper method to retrieve and print students in a course.
     */
    @Transactional(readOnly = true)
    public void verifyCourseEnrollment(Integer courseId) {
        Course retrievedCourse = courseRepository.findById(courseId).orElseThrow();
        
        System.out.println("\n🔎 Course: " + retrievedCourse.getCourseTitle());
        System.out.println("   Total Students: " + retrievedCourse.getStudents().size());
        
        retrievedCourse.getStudents().forEach(s -> System.out.println("   - " + s.getStudentName()));
        System.out.println("==================================================");
    }
}