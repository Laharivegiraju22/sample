package com.mindtree.kalingacafechainmangement.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cafeId")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Cafe {

@Id

private int cafeId;
private String cafeName;
private Double cafeRevenue;

@ManyToOne
Manager manager;

public Cafe() {
	super();
}

public Cafe(int cafeId, String cafeName, Double cafeRevenue, Manager manager) {
	super();
	this.cafeId = cafeId;
	this.cafeName = cafeName;
	this.cafeRevenue = cafeRevenue;
	this.manager = manager;
}

public int getCafeId() {
	return cafeId;
}

public void setCafeId(int cafeId) {
	this.cafeId = cafeId;
}

public String getCafeName() {
	return cafeName;
}

public void setCafeName(String cafeName) {
	this.cafeName = cafeName;
}

public Double getCafeRevenue() {
	return cafeRevenue;
}

public void setCafeRevenue(Double cafeRevenue) {
	this.cafeRevenue = cafeRevenue;
}

public Manager getManager() {
	return manager;
}

public void setManager(Manager manager) {
	this.manager = manager;
}

@Override
public String toString() {
	return "Cafe [cafeId=" + cafeId + ", cafeName=" + cafeName + ", cafeRevenue=" + cafeRevenue + ", manager=" + manager
			+ "]";
}

}
