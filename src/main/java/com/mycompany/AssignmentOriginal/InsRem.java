package com.mycompany.AssignmentOriginal;

import com.mycompany.Assignment.Db;
import com.mycompany.Assignment.Sortable;

public class InsRem {
    public static void insert(Sortable[] array, Sortable toInsert, int numElements) throws Exception{
        Db.p(array.getClass().getComponentType().toString());
        Db.p(toInsert.getClass().toString());
        Db.p(String.valueOf(array.getClass().getComponentType().isAssignableFrom(toInsert.getClass())));


        

        if (!(array.getClass().getComponentType().isAssignableFrom(toInsert.getClass()))){
            throw new Exception("Error: Cannot insert element of different type into array");

        }

        if (array[0] == null){
            array[0] = toInsert;
            return;
        }
        // 1 Round of insertion sort to put the newly defined observation in alphabetical order based on observation type name
        // Easier to read and display
        int i = numElements - 1;
        int diff;
        String nameToCompare;
        String nameToInsert = toInsert.getKey();
        String elementUnique = toInsert.getUnique();
        

        while (true){
            Db.p("InsRem i: " + String.valueOf(i));
            // if (array[i] == null){
            //     array[0] = toInsert;
            //     break;

            // }
            if (elementUnique.equals(array[i].getUnique())){
                throw new Exception(String.format("Error: Element with unique ID '%s' already exists",elementUnique));
            }
            if (i == 0){
                array[0] = toInsert;
                break;
            }
            nameToCompare = array[i].getKey();
            diff = nameToCompare.compareTo(nameToInsert);
            
            if(diff > 0){
                array[i] = array[i-1];
                i--;
            }
            else{
                array[i] = toInsert;
                break;
            }

        }


    }

    public static void remove(Sortable[] array, Sortable toRemove, int numElements) throws Exception{
        for (int i = 0; i < numElements; i++){
            if (array[i].getKey() == toRemove.getKey()){
                for (int j = i; j < (numElements - 1); j++){
                    array[j] = array[j+1];
                }
                
                return;
                
            }
        }
        throw new Exception(String.format("Error: Cannot remove element '%s', element does not exist",
            toRemove.getKey()
        ));


    }
}
