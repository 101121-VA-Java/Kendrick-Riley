package com.revature.services;

import com.revature.models.Animal;
import com.revature.models.SmallAnimal;

public class OopService {
//	Encapsulation is separation of variables within methods and classes
	public void doEncapsulation() {
		Animal roach = new Animal();
		SmallAnimal rat = new SmallAnimal();
		roach.setAge(6);
		rat.setCanFly(false);
		System.out.println("The roach was " + roach.getAge() + " " + "and I hated him");
	}
//	Inheritance is the passing down the characteristic from a parent to child classes
	public void doInheritance() {
		//on driver
		
	}
//	Polymorphism is method overloading and overriding
	public void doPolymorphism() {
		
		//on driver
	}
	
	public void doAbstraction() {
		
	}
}
