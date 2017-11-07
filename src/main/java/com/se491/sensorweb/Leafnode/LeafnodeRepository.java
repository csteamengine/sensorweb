package com.se491.sensorweb.Leafnode;

import org.springframework.data.repository.CrudRepository;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LeafnodeRepository extends CrudRepository<Leafnode, Long> {

    Leafnode findByLeafnodeIdAndHomenodeId(Long leafnodeId, Long homenodeId);
}