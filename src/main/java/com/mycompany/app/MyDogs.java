package com.mycompany.app;
import java.io.*;

public class MyDogs {
    public static void main(String[] args) throws IOException {
    Dog6[] dogs = new Dog6[4];
    dogs[0] = new Dog6("Fido",3,32.5,'M',true);
    dogs[1] = new Dog6("Spot",3,39.25,'M',true);
    dogs[2] = new Dog6("Rocky",3,55.0,'M',false);
    dogs[3] = new Dog6("Princess",1,15.5,'F',true);

    ObjectOutputStream dogFile = new ObjectOutputStream (new FileOutputStream("Dogs.list"));
    for (int i = 0; i < dogs.length; ++i)
        {
        dogFile.writeUTF(dogs[i].getName());
        dogFile.writeInt(dogs[i].getAge());
        dogFile.writeDouble(dogs[i].getWeight());
        dogFile.writeChar(dogs[i].getSex());
        dogFile.writeBoolean(dogs[i].getMicrochipped());
        }
    dogFile.close();
    ObjectInputStream infile = new ObjectInputStream (new FileInputStream("Dogs.list"));
    for (int i = 0; i < 4; ++i)
        {
        String name = infile.readUTF();
        int age = infile.readInt();
        double weight = infile.readDouble();
        char sex = infile.readChar();
        boolean chipped = infile.readBoolean();
        System.out.printf("%s is %d years old," +
        " weighs %2.2f kgs, " +
        "is %s, and is %s\n", name,
        age, weight,
        sex == 'M'?"male":"female",
        (chipped == true?"":"not ") +
        "microchipped");
        }
    infile.close();
}}
