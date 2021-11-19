package com.revature.models;

public class Animal extends BigAnimal {

	private String breed;
	public String name;
	private int age;
	public char gender;
	public boolean isSmall;
	

	public Animal() {		
	setBreed(("pit"));
	name = "Killer";
	setAge(1);
	gender = 'M';
	isSmall = true;
			
	}	
	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	}	
