package com.mycompany.AssignmentOriginal;

public class ObservationType implements Sortable{
    protected String name;
    protected String code;
    // Sorts by code if true, name otherwise
    protected boolean sortByCode = true;

    public ObservationType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKey(){
        if (sortByCode){
            return this.code;
        }
        else {
            return this.name;
        }
    }


    public String getUnique() {
        return this.code;
    }

    
}
