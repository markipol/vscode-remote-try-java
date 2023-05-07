package com.mycompany.AssignmentOriginal;

import com.mycompany.AssignmentOriginal.InsRem;

public class PatientRecordSystem {
    // private MeasurementObservationType[] mObsTypes;
    // private CategoryObservationType[] cObsTypes;
    private ObservationType[] obsTypes;
    private Patient[] patients;
    private final int MAX_PATIENTS = 100;
    private final int MAX_OBS = 50;
    private int numObsTypes = 0;
    private int numPatients = 0;

    public PatientRecordSystem() {
        this.obsTypes = new ObservationType[MAX_OBS];
        this.patients = new Patient[MAX_PATIENTS];
    }

    public void addMeasurementObservationType(String code, String name, String unit) {
        MeasurementObservationType typeToAdd = new MeasurementObservationType(name, code, unit);
        try {
            
            addObservationType(typeToAdd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(String.format(String.format("Error: Cannot add %s measurement observation type", typeToAdd.toString())));
        }

    }

    public void addCategoryObservationType(String code, String name, String[] categories) {
        CategoryObservationType typeToAdd = new CategoryObservationType(name, code, categories);
        try {
            addObservationType(typeToAdd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(String.format("Error: Cannot add %s category observation type", typeToAdd.toString()));
        }
    }

    public void addObservationType(ObservationType typeToAdd) throws Exception {
        InsRem.insert(this.obsTypes, typeToAdd, this.numObsTypes);
        numObsTypes++;

    }

    public void addMeasurementObservation(String patientId, String typeCode, int value) throws Exception {
        try {
            Patient p = getPatient(patientId);
            for (ObservationType obsType : this.obsTypes) {
                if (obsType.getCode().equals(typeCode)) {
                    // Unnecessary because the "not a measurement observation type" is already handled in the Measurement Observation constructor
                    // Keep commented in case needed later
                    // if (obsType instanceof MeasurementObservationType) {
                    //     MeasurementObservation mObsToAdd = new MeasurementObservation(obsType, value);
                    //     p.addObservation(mObsToAdd);
                    //     return;
                    // } else {
                    //     throw new Exception(String.format("Error: Observation type %s is not a measurement observation type", obsType.getCode()));
                    // }
                    p.addObservation(new MeasurementObservation(obsType, value));
                }
            }
            throw new Exception(String.format("Error: Observation type id:%s does not exist in system", typeCode));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(String.format("Error: could not add measurement observation %s; %s; for patient code %s",
                    typeCode,
                    value,
                    patientId));

        }

    }

    public void addCategoryObservation(String patientId, String typeCode, String value) throws Exception {
        try {
            Patient p = getPatient(patientId);
            for (ObservationType obsType : this.obsTypes) {
                if (obsType.getCode().equals(typeCode)) {
                    p.addObservation(new CategoryObservation(obsType, value));
                }
            }
            throw new Exception(String.format("Error: Observation type id:%s does not exist in system", typeCode));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(String.format("Error: could not add measurement observation %s; %s; for patient code %s",
                    typeCode,
                    value,
                    patientId));

        }

    }

    public Patient getPatient(String idToSearch) throws Exception {
        for (Patient p : this.patients) {
            if (p.getId().equals(idToSearch)) {
                return p;
            }
        }
        throw new Exception(String.format("Error: Patient %s not found", idToSearch));
    }

    public void addPatient(String id, String name) throws Exception {
        Patient patientToAdd = new Patient(id, name);
        InsRem.insert(this.patients, patientToAdd, numPatients);
        numPatients++;
    }

    public String toString(){
        String output = "--------------------------\nPATIENT RECORD SYSTEM DATA\n--------------------------\nOBSERVATION TYPES:";
        for (ObservationType obsType : this.obsTypes){
            if (obsType == null){
                break;
            }
            output = output + "\n-- " + obsType.toString();
        }
        output = output + "\n\nPATIENTS:";
        for (Patient p : this.patients){
            if (p == null){
                break;
            }
            output = output + "\n-- " + p.toString() + "\nObservations:";
            for (Observation o : p.getObservations()){
                if (o == null){
                    break;
                }
                output = output + "\n - " + o.toString();

            }
        }
        return output + "\n\n\n\n";

    }

}
