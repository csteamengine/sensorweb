package com.se491.sensorweb.HomeNode;

import org.springframework.data.jpa.repository.JpaRepository;
// This will be AUTO IMPLEMENTED by Spring into a Bean called homeNodeRepository
// CRUD refers Create, Read, Update, Delete

public interface HomeNodeRepository extends JpaRepository<HomeNode, Long> {

}
