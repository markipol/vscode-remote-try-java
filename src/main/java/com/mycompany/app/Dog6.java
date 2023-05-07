package com.mycompany.app;

public class Dog6 {
    private String name;
    private int age;
    private double weight;
    private char sex;
    private boolean microchipped;
    public Dog6(String name, int age, double weight, char sex, boolean hasChip)
    {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.sex = sex;
    this.microchipped = hasChip;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isMicrochipped() {
        return this.microchipped;
    }

    public boolean getMicrochipped() {
        return this.microchipped;
    }

    public void setMicrochipped(boolean microchipped) {
        this.microchipped = microchipped;
    }

    public String toString()
    {
    return getClass().getName() + "["
    + "name:" + name + ", age: " + age
    + ", weight: " + weight + ", sex: " + sex
    + ", microchipped: " + microchipped + "]";
    }
}
