package org.example.Service;

import org.example.Entity.Course;
import org.example.Entity.Student;

public class CampusRegistrar {
    private StudentReg studentRegis;
    private CourseReg courseRegis;

    public CampusRegistrar(StudentRegistration studentRegistration, CourseRegistration courseRegistration) {
    }

    public String saveStudent (Student student){
        studentRegis.saveStudent(student);
        return "Success";
    }
    
    public String updateStudent (Student student){
        studentRegis.updateStudent(student);
        return "Success";
    }
    
    public String removeStudent (Student student){
        studentRegis.removeStudent(student);
        return "Success";
    }
    
    public String displayAllStudent(){
        studentRegis.displayAllStudent();
        return "Success";
    }
    
    public String save (Course course){
        courseRegis.save(course);
        return "Success";
    }
    
    public String displayAll(){
        courseRegis.displayAll();
        return "Success";
    }
    
    public String updateCourse (Course course){
        courseRegis.updateCourse(course);
        return "Success";
    }
    
    public String removeCourse (Course course){
        courseRegis.removeCourse(course);
        return "Success";
    }
}
