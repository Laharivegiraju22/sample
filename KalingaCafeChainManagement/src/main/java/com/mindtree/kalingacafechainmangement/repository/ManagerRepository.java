package com.mindtree.kalingacafechainmangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingacafechainmangement.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
