package com.skilldistillery.jets;

public class FighterJet extends Jets implements Fighters {
	public boolean misslesUp;

	@Override
	public void Missles() {
		this.misslesUp = true;

	}

	@Override
	public void fight() {
		this.misslesUp = false;

	}
	
	
	
	public FighterJet(String model, double speed, int range, long price, boolean misslesUp) {
		super(model, speed, range, price);
		this.misslesUp = misslesUp;
	}
	
	
	

	public FighterJet() {
		// TODO Auto-generated constructor stub
	}

	public void dogFight() {
		if(this.misslesUp = true) {
			System.out.println(this.getModel() + "got into a roaring dog fight! Shot down every Bogey you saw! Good job Captain! ");
			this.misslesUp = false;
		}
	}

}
