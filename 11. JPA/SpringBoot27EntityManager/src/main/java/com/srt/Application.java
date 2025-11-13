package com.srt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
        UserService userService = container.getBean(UserService.class);

        System.out.println("\n--- STARTING ENTITY MANAGER CRUD DEMO ---");
        
        // Ensure database structure is set up (usually via spring.jpa.hibernate.ddl-auto)

        // CREATE: Persist a new user
        userService.createUser(new User(1L, "Rishi", "rishi@example.com"));

        // READ: Find the created user
        userService.findUser(1L).ifPresent(user -> 
            System.out.println("Read: " + user.getName() + " - " + user.getEmail())
        );

        // UPDATE: Modify the user's email
        userService.updateUserEmail(1L, "rishi.new@mail.com");

        // VERIFY UPDATE (Read again)
        userService.findUser(1L).ifPresent(user -> 
            System.out.println("Read: Verified new email is " + user.getEmail())
        );

        // DELETE: Remove the user
        userService.deleteUser(1L);

        // VERIFY DELETE (Attempt read)
        System.out.println("Read: User 1 exists? " + userService.findUser(1L).isPresent());
        
        System.out.println("--- DEMO COMPLETE ---");
        container.close();
    }
}