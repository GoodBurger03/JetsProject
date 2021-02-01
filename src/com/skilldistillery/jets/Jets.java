package com.skilldistillery.jets;

public abstract class Jets {
	private String model;
	private double speed;
	private Integer range;
	private Long price;

// ToString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Jets [model=").append(model).append(", speed = ").append(speed).append("MPH").append(",  range = ")
				.append(range).append("miles").append(", price = ").append(price).append("]");
		return sb.toString();

	}
//Jet Constuctors

	public Jets() {
		super();
	}

	public Jets(String model, Double speed, Integer range, Long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

//get and setters 
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the speed
	 */
	public Double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the range
	 */
	public Integer getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(Integer range) {
		this.range = range;
	}

	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	public void fly() {
		// distance = rate x time
		double flightTime = ((double) this.range) / this.speed;
		toString();
		System.out.printf("The " + this.model + " can fly %.2f hours before it runs out of fuel\n", flightTime);
	}

	public Object getSpeedInMach() {
		double mach = this.speed / 767.269;
		return mach;		
	}
	

}
