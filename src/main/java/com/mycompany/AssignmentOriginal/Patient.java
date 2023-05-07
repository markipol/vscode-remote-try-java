package com.mycompany.AssignmentOriginal;

import com.mycompany.AssignmentOriginal.InsRem;

public class Patient implements Sortable{
    private String id;
    private String name;
    // Patient cannot have 2 of the same observation type, there are maximum 50 types, so the maximum observations a patient can have is 50
    private Observation[] observations;
    private final int MAX_OBS = 50;
    private int numObservations = 0;
    // Sorts by id if true, name otherwise
    private boolean sortById = true;

    public Patient(String id, String name, Observation[] observations) {

        this.id = id;
        this.name = name;
        this.observations = new Observation[MAX_OBS];
        for (int i = 0;i<observations.length;i++){
            this.observations[i] = observations[i];
            this.numObservations++;

        }
    }

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.observations = new Observation[MAX_OBS];
        this.numObservations = 0;
    }



    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Observation[] getObservations() {
        return this.observations;
    }

    public int getNumObservations(){
        return this.numObservations;
    }

    // public void addObservation(Observation observation) throws Exception{
    //     // if (this.numberObservations < MAX_OBS){
    //     //     this.observations[this.numberObservations+1] = observation;
            
    //     // }
    //     // else {
    //     //     throw new Exception("Error: Patient has maximum number of observations, cannot add any more");
    //     // }
    //     if (this.numberObservations >= MAX_OBS){
    //         throw new Exception("Error: Patient has maximum number of observations, cannot add any more");
    //     }
    //     else{
    //         // 1 Round of insertion sort to put the newly defined observation in alphabetical order based on observation type name
    //         // Easier to read and display
    //         int i = this.numberObservations - 1;
    //         int diff;
    //         String nameToCompare;
    //         String nameToInsert = observation.getObservationType().getKey();
            

    //         while (true){
    //             if (i == 0){
    //                 this.observations[0] = observation;
    //                 break;
    //             }
    //             nameToCompare = this.observations[i].getObservationType().getKey();
    //             diff = nameToCompare.compareTo(nameToInsert);
    //             if(diff > 0){
    //                 this.observations[i] = this.observations[i-1];
    //                 i--;
    //             }
    //             else{
    //                 this.observations[i] = observation;
    //                 break;
    //             }

    //         }


    //     }


    // }

    // public void removeObservation(ObservationType observationType) throws Exception{
    //     for (int i = 0; i < this.numberObservations; i++){
    //         if (this.observations[i].getObservationType() == observationType){
    //             for (int j = i; j < (this.numberObservations - 1); j++){
    //                 this.observations[j] = this.observations[j+1];
    //             }
    //             this.numberObservations--;
    //             return;
                
    //         }
    //     }
    //     throw new Exception(String.format("Error: Cannot remove observation '%s' from patient '%s', observation does not exist",
    //         observationType.getName(),
    //         this.name));
        
    // }

    public void addObservation(Observation observation){
        try {
            InsRem.insert(this.observations, observation, this.numObservations);
            numObservations++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(String.format("Error: Cannot insert '%s' observation into '%s' patient record", 
                observation.toString(),
                this.toString()));
            
        }

    }
    
    public void removeObservation(Observation observation){
        try {
            InsRem.remove(this.observations, observation, this.numObservations);
            numObservations--;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(String.format("Error: Cannot remove '%s' observation from '%s' patient record", 
                observation.toString(),
                this.toString()));
            
        }

    }

    public void setObservations(Observation[] observations) {
        this.observations = observations;
    }
    public String getKey(){
        if (sortById){
            return this.id;
        }
        else {
            return this.name;
        }
    }

    public String getUnique(){
        return this.id;
    }

    public String toString(){
        return String.format("Patient id: %s, name: %s",
            this.getId(),
            this.getName()
            );
    }


}
