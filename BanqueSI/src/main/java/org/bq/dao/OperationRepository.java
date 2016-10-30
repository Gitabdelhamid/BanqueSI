package org.bq.dao;

import org.bq.Entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OperationRepository extends JpaRepository<Operation, Long> {

}
