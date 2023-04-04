package com.mycompany.app;

import java.util.*;

public class Pet {
    String name;
    String owner;
    String id;
    public Pet(String id, String name, String owner){
        this.name = name;
        this.owner = owner;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public String getOwner(){
        return this.owner;
    }

    public String getDetails(){
        return String.format("Name: %s, Id: %s, Owner: %s", this.name, this.id, this.owner);
    }

    public String toString(){
        return getDetails();
    }

    public static void main(String[] args) {
        Cat henry = new Cat("1", "Henry", "Mark", "LH");
        Dog harry = new Dog("2", "Harry", "Mark", "small");
        DangerousDog armanoChristianPerez = new DangerousDog("3", "Armano Christian Perez", "???", "large", 69);
        DangerousDog cocaineDog = new DangerousDog("4", "Cocaine Dog", "Hollywood", "large", 9);
        System.out.println(henry.getDetails());
        System.out.println(harry.getDetails());

	
    }
}


class Dog extends Pet {
    String size;
    private static final Set<String> acceptableSizes = Set.of(
        "small", "medium", "large"

    );
    public Dog(String id, String name, String owner, String size){
        super(name, id, owner);
        if (acceptableSizes.contains(size)){
            this.size = size;
        }
        else throw new IllegalArgumentException ("Size must be either small, medium or large");
    }
    public String getSize(){
        return this.size;
    }

    public String getDetails(){
        return String.format("Name: %s, Id: %s, Owner: %s, Size: %s", this.name, this.id, this.owner, this.size);
    }




}

class Cat extends Pet {
    String hairType;
    private static final Set<String> acceptableHairTypes = Set.of(
        "SH", "LH"
    );
    public Cat(String id, String name, String owner, String hairType){
        super(name, id, owner);
        if (acceptableHairTypes.contains(hairType)){
            this.hairType = hairType;
        }
        else throw new IllegalArgumentException ("Hair type must be either SH or LH");
    }
    public String getHairType(){
        return this.hairType;
    }
    public String getDetails(){
        return String.format("Name: %s, Id: %s, Owner: %s, Hair Type: %s", this.name, this.id, this.owner, this.hairType);
    }
}

class DangerousDog extends Dog{
    int reportedIncidents;

    public DangerousDog(String id, String name, String owner, String size) {
        super(id, name, owner, size);
        this.reportedIncidents = 0;
        
    }
    public DangerousDog(String id, String name, String owner, String size, int reportedIncidents) {
        super(id, name, owner, size);
        this.reportedIncidents = reportedIncidents;

        
    }

    public void setReportedIncidents(int reportedIncidents){
        this.reportedIncidents = reportedIncidents;
    }

    public int getReportedIncidents(){
        return this.reportedIncidents;
    }

    public String getDetails(){
        return String.format("Name: %s, Id: %s, Owner: %s, Size: %s, Incidents: %s", this.name, this.id, this.owner, this.size, this.reportedIncidents);
    }
    
}

// Make a displayAllCars function in Lab 2 instead of doing it in the main class
// And "countAndDisplayAllPass" function
