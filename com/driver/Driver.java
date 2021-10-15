package com.driver;
import com.models.Animal;
public class Driver{
    public static void main(String[] args){

        Animal dog = new Animal();
        dog.breedName = "Pit";
        dog.color = "silver";
        dog.dogAge = 6;
        dog.gender = 'M';

        System.out.println(dog.breedName);
        System.out.println(dog.color);
        System.out.println(dog.dogAge); 



    }

}