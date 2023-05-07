package com.mycompany.AssignmentOriginal;

public class Key {
    private String string;
    private Number number;
    public Key(Object o){
        if (o instanceof String){
            this.string = (String) o;
           
        }
        if (o instanceof Number){
            this.number = (Number) o;
        }

    }


    
}
