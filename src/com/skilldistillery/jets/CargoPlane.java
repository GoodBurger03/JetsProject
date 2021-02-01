package com.skilldistillery.jets;

public class CargoPlane extends Jets implements CargoJets {
	public boolean isLoaded;
	private DisplayImage displayPic = new DisplayImage();
	
	public CargoPlane() {
		
	}

public CargoPlane(String model, double speed, int range, long price, boolean isLoaded) {
	super(model, speed, range, price);
	this.isLoaded = isLoaded;
	
	
}

public void offLoad() {
	this.isLoaded = false;
	System.out.println("This " + this.getModel() + "has been off loaded and is ready for a new haul!");
}



public void loadUp() {
this.isLoaded = true;
System.out.println("The whole payload is aboard " + this.getModel());
	//displayPic.getAccessibleContext();
}


}
