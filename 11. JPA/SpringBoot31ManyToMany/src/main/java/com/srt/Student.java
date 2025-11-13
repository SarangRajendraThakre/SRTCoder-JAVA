package com.srt;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_STUDENT")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    
    private String studentName;

    // @ManyToMany: Defines the relationship. This is the Owning Side.
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "STUDENT_COURSE_ENROLLMENT", // The name of the join table
        joinColumns = @JoinColumn(name = "student_id"), // FK column for the Student table
        inverseJoinColumns = @JoinColumn(name = "course_id") // FK column for the Course table
    )
    private Set<Course> courses = new HashSet<>();

    public Student(String studentName) {
        this.studentName = studentName;
    }
}