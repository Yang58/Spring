package com.zerock.sample;

public class Car {
	private String model;
	
	public Car(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}

// 자바에서 객체를 직접 생성 할떄 
//Car c = new Car("kia");
//c.setModel("kia");