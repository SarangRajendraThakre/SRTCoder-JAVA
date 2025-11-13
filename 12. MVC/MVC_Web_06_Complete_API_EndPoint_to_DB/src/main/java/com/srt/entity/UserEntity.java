package com.srt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "USER_WEB_6")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 1)
    private Integer id;

    @Column(unique = true)
    private String emailId;

    private String firstName;
    private String lastName;
    private String gender;
    private String married;
    private int salary;
}
