package org.example.Service;

import org.example.Model.Section;
import org.example.Model.Student;
import java.util.*;

public interface SectionReg {
    void save(Section sectionData);
    List<Section> displayAll();
    Section findBySectionName(String sectionName);
    void updateSection(String sectionName, Section sectionInfo);
    void addStudentToSection(String sectionName, Student studentData);
    void deleteSection(String sectionName);
}