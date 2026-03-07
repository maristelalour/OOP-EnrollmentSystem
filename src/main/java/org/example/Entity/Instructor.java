package org.example.Entity;

public class Instructor extends Person {
    private String courses;

    public Instructor(){

    }

    public Instructor(String personID, String personName,String courses){
        super(personID, personName);
        this.courses=courses;
    }

    public String getCourses(){
        return courses;
    }

    public void setCourses(String courses){
        this.courses= courses;
    }

}
