package com.srt;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@Service
public class UserService {

    // Inject the EntityManager provided by Hibernate/JPA
    @PersistenceContext
    private EntityManager entityManager;

    // --- 1. CREATE (persist) ---
    @Transactional
    public void createUser(User user) {
        // Marks the new entity to be INSERTED when the transaction commits
        entityManager.persist(user); 
        System.out.println("✅ Created: User " + user.getId() + " persisted.");
    }

    // --- 2. READ (find) ---
    @Transactional(readOnly = true)
    public Optional<User> findUser(Long id) {
        // Retrieves the entity by primary key
        User user = entityManager.find(User.class, id); 
        return Optional.ofNullable(user);
    }

    // --- 3. UPDATE (Dirty Checking / merge) ---
    @Transactional
    public void updateUserEmail(Long id, String newEmail) {
        // a) Read: Retrieve the entity, which is now 'managed' by the context
        User user = entityManager.find(User.class, id); 
        
        if (user != null) {
            // b) Modify: Changing a field on a managed entity
            user.setEmail(newEmail); 
            // c) No explicit call needed: Hibernate (JPA provider) will automatically 
            // generate an UPDATE query when the @Transactional method exits (Dirty Checking).
            System.out.println("✅ Updated: User " + id + " email changed to " + newEmail);
        }
    }

    // --- 4. DELETE (remove) ---
    @Transactional
    public void deleteUser(Long id) {
        // a) Read: Entity must be managed before removal
        User user = entityManager.find(User.class, id);
        
        if (user != null) {
            // b) Remove: Mark the managed entity for deletion
            entityManager.remove(user); 
            System.out.println("✅ Deleted: User " + id + " removed.");
        }
    }
}