package com.mycompany.AssignmentOriginal;


import java.util.Arrays;

public class CategoryObservation extends Observation {
    private String value;
    private CategoryObservationType cObsType;

    public CategoryObservation(CategoryObservationType cObsType, String value) {
        this.value = value;
        this.cObsType = cObsType;
    }

    public CategoryObservation(ObservationType obsType, String value) throws Exception {
        
        this.value = value;
        if (!(obsType instanceof CategoryObservationType)) {
        
            throw new Exception(String.format("The observation type %s is not a category observation type", obsType.getCode())); }
        
    }



    public String getValue() {
        return this.value;
    }

    public void setValue(String value) throws Exception {
        if (Arrays.asList(cObsType.getCategories()).contains(value)){
            this.value = value;
        }
        else{
            throw new Exception(String.format("Error: Category '%s' not in allowed categories for type '%s'", value, cObsType.getName()));
        }
    }
    
    public ObservationType getObservationType(){
        return this.cObsType;
    }




    public String getKey() {
        return this.cObsType.getKey();
    }
    public String getUnique() {
        return this.cObsType.getCode();
    }
    // DO NOT DELETE will need later
    // public String toString(){
    //     return String.format("%s; %s; %s; %s",
    //         this.cObsType.getCode(),
    //         this.cObsType.getName(),
    //         this.getValue()
            
    //         );
    // }
    public String toString(){
        return String.format("CategoryObservation[observationType: %s, value: %s],",
            this.cObsType.toString(),
            this.value);
    }



}
