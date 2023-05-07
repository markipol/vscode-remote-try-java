package com.mycompany.Assignment;


abstract class Observation implements Sortable{
    abstract public ObservationType getObservationType();
    abstract public String getKey();
    abstract public String getUnique();
    abstract public String toString();


    
}
