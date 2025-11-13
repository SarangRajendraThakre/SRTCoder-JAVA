package com.srt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_USER")
@Data // Lombok for getters, setters, toString, etc.
@NoArgsConstructor // Lombok for no-arg constructor
public class User {

    @Id // Primary Key
    private Long id;

    private String name;
    private String email;

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}