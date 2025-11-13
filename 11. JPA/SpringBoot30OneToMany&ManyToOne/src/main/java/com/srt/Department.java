package com.srt;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "T_DEPT")
@Data
@NoArgsConstructor
public class Department {

    @Id
    private Integer deptId;
    
    private String deptName;

    // @OneToMany: Defines the relationship.
    // mappedBy: Indicates the 'Employee' entity owns the foreign key (dept_id column).
    // CascadeType.ALL: Ensures that saving the Department saves all new Employees in the list.
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    public Department(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
}