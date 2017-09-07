package com.se491.sensorweb.User;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * Find a user by their email
     * @param email the email to find by
     */
    User findByEmail(String email);

}