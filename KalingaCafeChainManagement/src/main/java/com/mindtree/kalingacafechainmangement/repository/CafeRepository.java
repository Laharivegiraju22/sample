package com.mindtree.kalingacafechainmangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingacafechainmangement.entities.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {

}
