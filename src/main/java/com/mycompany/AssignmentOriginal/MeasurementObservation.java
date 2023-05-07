package com.mycompany.AssignmentOriginal;

public class MeasurementObservation extends Observation {
    private float value;
    private MeasurementObservationType mObsType;

    public MeasurementObservation(MeasurementObservationType mObsType, float value) {
        this.value = value;
        this.mObsType = mObsType;
    }

    public MeasurementObservation(ObservationType obsType, float value) throws Exception {
        
        this.value = value;
        if (!(obsType instanceof MeasurementObservationType)) {
        
            throw new Exception(String.format("The observation type %s is not a measurement observation type", obsType.getCode())); }
        
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public ObservationType getObservationType() {
        return mObsType;
    }

    public String getKey() {
        return this.mObsType.getKey();
    }

    public String getUnique() {
        return this.mObsType.getCode();
    }

    // Will need this later, do not delete
    // public String toString() {
    //     return String.format("%s; %s; %s; %s",
    //             this.mObsType.getCode(),
    //             this.mObsType.getName(),
    //             this.getValue(),
    //             this.mObsType.getUnit());
    // }
    public String toString(){
        return String.format("MeasurementObservation[observationType: %s, value: %s],",
            this.mObsType.toString(),
            String.valueOf(this.value));
    }

}
