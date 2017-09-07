package com.se491.sensorweb.HomeNode;

import com.se491.sensorweb.User.User;
import org.springframework.data.repository.CrudRepository;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface HomeNodeRepository extends CrudRepository<User, Long> {

}
