package com.mycompany.Assignment;

public class CategoryObservationType extends ObservationType {
    private String[] categories;

    public CategoryObservationType(String name, String code, String[] categories) {
        super(name, code);
        this.categories = categories;
        
    }

    public String[] getCategories() {
        return this.categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String toString(){
        return String.format("CategoryObservationType[code: %s, name: %s, categories:%s]",
            this.code,
            this.name,
            categoriesString());

    }

    public String categoriesString(){
        String output = "|";
        for (String s : this.categories){
            output = output + s + "|";

        }
        return output;
    }
    


    
}
