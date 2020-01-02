package com.mindtree.kalingacafechainmangement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.kalingacafechainmangement.entities.Cafe;
import com.mindtree.kalingacafechainmangement.entities.Manager;
import com.mindtree.kalingacafechainmangement.exceptions.serviceException.ManagerNotFoundException;
import com.mindtree.kalingacafechainmangement.exceptions.serviceException.NoSuchCafePresentException;

@Service
public interface KalingCafeChainManagementService {

public void addCafeAndManager(Manager manager);

public List<Cafe> getAllCafes(int managerId) throws ManagerNotFoundException;

public List<Cafe> getAllCafesWithRevenue(int revenue) throws NoSuchCafePresentException;

}
