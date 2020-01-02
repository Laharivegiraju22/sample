package com.mindtree.kalingacafechainmangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingacafechainmangement.entities.Cafe;
import com.mindtree.kalingacafechainmangement.entities.Manager;
import com.mindtree.kalingacafechainmangement.exceptions.serviceException.KalingaCafeChainManagementServiceException;
import com.mindtree.kalingacafechainmangement.exceptions.serviceException.ManagerNotFoundException;
import com.mindtree.kalingacafechainmangement.exceptions.serviceException.NoSuchCafePresentException;
import com.mindtree.kalingacafechainmangement.service.KalingCafeChainManagementService;
import com.mindtree.kalingacafechainmangement.service.serviceimplementation.KalingaCafeChainManagementServiceImplementation;

@RestController
public class KalingaCafeChainManagementController {

	@Autowired
	KalingCafeChainManagementService cafeService;

	@PostMapping("/addcafeandmanager")
	public String addCafeAndManager(@RequestBody Manager manager) {
		cafeService.addCafeAndManager(manager);
		return "added successfully";

	}
	@RequestMapping("/getallcafes/{managerId}")
	public List<Cafe> getAllCafes(@PathVariable int managerId)
	{
		try {
			return cafeService.getAllCafes(managerId);
		} catch (KalingaCafeChainManagementServiceException e) {
			
			e.printStackTrace();
		}
		return null;
	}
@RequestMapping("/getcafewithgreaterrevenue/{revenue}")
public List<Cafe> getcafeWithGreaterRevenue(@PathVariable int revenue)
{
	try {
		return cafeService.getAllCafesWithRevenue(revenue);
	} catch (KalingaCafeChainManagementServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
	
}
