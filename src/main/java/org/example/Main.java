package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s = new Student();
        s.setStudentID(2023);
        s.setstudentName("John Doe");
        s.setprogram("Information Technology \n");

        Student s1 = new Student();
        s1.setStudentID(2022);
        s1.setstudentName("Jane Doe");
        s1.setprogram("Information Technology \n");

        Course c = new Course();
        c.setcourseID(2351698);
        c.setcourseName("Integrative Programming");
        c.setprogram("Information Technology \n");

        s.display();
        s1.display();
        c.display();







    }
}