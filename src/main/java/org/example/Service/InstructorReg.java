package org.example.Service;

import org.example.Model.Instructor;
import org.example.Model.Section;
import java.util.*;

public interface InstructorReg {
    void save(Instructor instructorData);
    List<Instructor> displayAll();
    Instructor findByID(String instructorID);
    void updateInstructor(String instructorID, Instructor instructorInfo);
    void deleteInstructor(String instructorID);
    void assignInstructorToSection(Instructor instructorData, Section sectionData);
}