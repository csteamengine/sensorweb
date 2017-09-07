package com.se491.sensorweb.Service;

import com.se491.sensorweb.User.User;
import com.se491.sensorweb.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }

    /**
     * Get a user by their id
     * @param userId the user Id
     * @return
     */
    public User getUserById(Long userId) {
        return userRepository.findOne(userId);
    }

    /**
     * Gets a user by their email
     * @param email the email
     * @return
     */
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    /**
     * Gets all of the user's in the database
     * @return all of the user's
     */
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * Adds a user to the database
     * @param user the user to add
     * @return the new user that is saved
     */
    public User addUser(User user) {
        User savedUser = this.userRepository.save(user);

        return savedUser;
    }

    /**
     * Updates the user
     * @param user the user to udate
     * @return the new user
     */
//    public User updateUser(String email, String) {
//
//        User savedUser = this.userRepository.findByUserId(user.getUserId());
//
//        savedUser.setEmail(user.getEmail());
//        savedUser.setFirstName(user.getFirstName());
//        savedUser.setLastName(user.getLastName());
//        savedUser.setActive(user.isActive());
//        savedUser.setDateCreated(user.getDateCreated());
//        savedUser.setUsername(user.getUsername());
//        savedUser.setRole(user.getRole());
//        savedUser.setLastUpdated(new Date());
//
//        this.userRepository.save(savedUser);
//
//        return savedUser;
//
//    }

    /**
     * Deletes a user from the database
     *
     * @param id the id to delete
     *
     * @return the deleted user
     */
    public User deleteUser(Long id) {
        User deletedUser = this.userRepository.findOne(id);

        if(deletedUser == null) {
            return null;
        }else {

            this.userRepository.delete(deletedUser);

            return deletedUser;
        }
    }
}
