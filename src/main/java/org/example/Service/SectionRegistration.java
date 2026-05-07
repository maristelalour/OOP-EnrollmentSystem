package org.example.Service;

import org.example.Model.Section;
import org.example.Model.Student;
import java.util.ArrayList;
import java.util.List;

public class SectionRegistration implements SectionReg {
    private List<Section> sectionList = new ArrayList<>();

    @Override
    public void save(Section sectionData) {
        if (findBySectionName(sectionData.getSectionName()) != null) {
            System.out.println("Error: Section '" + sectionData.getSectionName() + "' already exists!");
            return;
        }
        sectionList.add(sectionData);
        System.out.println("Section " + sectionData.getSectionName() + " saved successfully.");
    }

    @Override
    public List<Section> displayAll() {
        return sectionList;
    }

    @Override
    public Section findBySectionName(String sectionName) {
        for (Section s : sectionList) {
            if (s.getSectionName().equalsIgnoreCase(sectionName)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void updateSection(String sectionName, Section sectionInfo) {
        for (int i = 0; i < sectionList.size(); i++) {
            if (sectionList.get(i).getSectionName().equalsIgnoreCase(sectionName)) {
                sectionList.set(i, sectionInfo);
                System.out.println("Section " + sectionName + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Section not found.");
    }

    @Override
    public void addStudentToSection(String sectionName, Student studentData) {
        Section found = findBySectionName(sectionName);
        if (found != null) {
            found.getStudentList().add(studentData);
            System.out.println("Student " + studentData.getPersonName() + " added to " + sectionName);
        } else {
            System.out.println("Error: Section not found.");
        }
    }

    @Override
    public void deleteSection(String sectionName) {
        Section found = findBySectionName(sectionName);
        if (found != null) {
            sectionList.remove(found);
            System.out.println("Section " + sectionName + " deleted successfully.");
        } else {
            System.out.println("Error: Section not found.");
        }
    }
}