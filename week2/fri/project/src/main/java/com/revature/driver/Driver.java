package com.revature.driver;

import com.revature.models.Animal;
import com.revature.services.OopService;

class Bird{
	public void sing() { /*Polymorphism just practicing Kevin!! I know it needs
		to be in own tab class */
		System.out.println("hoo hoo hoo" + "I am doing is");
	}
}
class brownOwl extends Bird{//Polymorphism
	public void sing() {
	System.out.println("hoo boo boo hoo tha foo");
}
	}

public class Driver {
	
	
	public static void main(String[] args) {
		Animal dog = new Animal();
		System.out.println("I have a" + " " + dog.name + " " + dog.getBreed() +
				" " + dog.isSmall + " "  + dog.getAge());
		Bird owl = new Bird();
		owl.sing();
		brownOwl a = new brownOwl();
		a.sing();
		OopService c = new OopService();
		c.doEncapsulation();
		
	}

}

