package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.List;

public class AirField {

	private List<Jets> jetsList = new ArrayList<>();
	
	
	public AirField() {
		
	}
	
	public void addJet(Jets plane) {
		this.jetsList.add(plane);
	}
	
	public void removeJet(int i) {
		this.jetsList.remove(i);
	}
	
	
	public List<Jets> getJetsList(){
		return jetsList;
	}
}
