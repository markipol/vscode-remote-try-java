package com.mycompany.AssignmentOriginal;

public class MeasurementObservationType extends ObservationType{
    private String unit;

    public MeasurementObservationType(String name, String code, String unit) {
        super(name, code);
        this.unit = unit;
        
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String toString(){
        return String.format("MeasurementObservationType[code: %s, name: %s, unit: %s]",
            this.code,
            this.name,
            this.unit);
    }

    
}
