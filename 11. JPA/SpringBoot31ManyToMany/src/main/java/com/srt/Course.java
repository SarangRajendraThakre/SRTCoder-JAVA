package com.srt;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_COURSE")
@Data
@NoArgsConstructor
public class Course {

    @Id
    private Integer courseId;
    
    private String courseTitle;

    // @ManyToMany: Defines the relationship. This is the Inverse Side.
    // mappedBy: Points to the 'courses' field in the Student entity.
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course(Integer courseId, String courseTitle) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
    }
    
}