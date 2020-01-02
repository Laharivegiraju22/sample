package com.mindtree.kalingacafechainmangement.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "managerId")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int managerId;
	private String managerName;
	private int salary;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
	List<Cafe> cafes;
	
	public Manager() {
		super();
	}

	public Manager(int managerId, String managerName, int salary, List<Cafe> cafes) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.salary = salary;
		this.cafes = cafes;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<Cafe> getCafes() {
		return cafes;
	}

	public void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", salary=" + salary + ", cafes="
				+ cafes + "]";
	}
	
	

}
