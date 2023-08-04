package com.furkankarakus.data.repository;

import com.furkankarakus.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// JpaRepository > CrudRepository jpa daha genis kapsamli
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
