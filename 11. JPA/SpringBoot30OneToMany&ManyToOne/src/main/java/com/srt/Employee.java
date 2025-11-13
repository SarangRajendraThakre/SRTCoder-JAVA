package com.srt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_EMP")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming AUTO_INCREMENT or sequence
    private Long empId;
    
    private String empName;

    // @ManyToOne: Defines the relationship to the 'Department' entity.
    // @JoinColumn: Specifies the actual foreign key column name in the T_EMP table.
    // FetchType.LAZY: Recommended practice to only load the Department when explicitly accessed.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", nullable = false) 
    private Department department; 

    // Constructor for new employees (without the ID)
    public Employee(String empName) {
        this.empName = empName;
    }
}