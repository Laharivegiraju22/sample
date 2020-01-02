package com.mindtree.kalingacafechainmangement.service.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.kalingacafechainmangement.entities.Cafe;
import com.mindtree.kalingacafechainmangement.entities.Manager;
import com.mindtree.kalingacafechainmangement.exceptions.serviceException.ManagerNotFoundException;
import com.mindtree.kalingacafechainmangement.exceptions.serviceException.NoSuchCafePresentException;
import com.mindtree.kalingacafechainmangement.repository.CafeRepository;
import com.mindtree.kalingacafechainmangement.repository.ManagerRepository;
import com.mindtree.kalingacafechainmangement.service.KalingCafeChainManagementService;

@Service
public class KalingaCafeChainManagementServiceImplementation implements KalingCafeChainManagementService {

	@Autowired
	CafeRepository cafeRepository;
	@Autowired
	ManagerRepository managerRepository;

	@Override
	public void addCafeAndManager(Manager manager) {
		Manager newManager=manager;
		newManager.getCafes().forEach(c->c.setManager(manager));
		
		managerRepository.save(newManager);

	}

	@Override
	public List<Cafe> getAllCafes(int managerId) throws ManagerNotFoundException {
		if(managerRepository.existsById(managerId))
		{
		List<Cafe> cafes = new ArrayList<Cafe>();
		cafes = managerRepository.findById(managerId).get().getCafes();
		return cafes;
	}
		else
		{
			throw new ManagerNotFoundException("manager with that id is not found");
		}
	}
	@Override
	public List<Cafe> getAllCafesWithRevenue(int revenue) throws NoSuchCafePresentException {
		List<Manager> manager = new ArrayList<Manager>();
		manager = managerRepository.findAll();
		List<Manager> resultManager = new ArrayList<>();
		List<Cafe> resultCafe = new ArrayList<Cafe>();
		for (Manager m : manager) {
			List<Cafe> cafes = new ArrayList<Cafe>();
			
			cafes = m.getCafes();
			for (Cafe c : cafes) {
				if (c.getCafeRevenue() > revenue) {
					resultCafe.add(c);

				}

			}
			
		}
		if(resultCafe.isEmpty())
		{
			throw new NoSuchCafePresentException("there is no such cafe with given revenue");
		}
		return resultCafe;
	}

}
