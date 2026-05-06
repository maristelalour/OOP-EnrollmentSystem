package org.example.Service;

import org.example.Model.Instructor;
import org.example.Model.Section;
import java.util.*;

public interface InstructorReg {
    void save(Instructor instructor);
    List<Instructor> displayAll();
    Instructor findByID(String id);
    void updateInstructor(String id, Instructor updated);
    void deleteInstructor(String id);
    void assignInstructorToSection(Instructor instructor, Section section);
}