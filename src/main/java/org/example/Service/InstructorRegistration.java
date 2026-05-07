package org.example.Service;

import org.example.Exception.DuplicateIDException;
import org.example.Model.Instructor;
import org.example.Model.Section;
import java.util.ArrayList;
import java.util.List;

public class InstructorRegistration implements InstructorReg {
    private List<Instructor> instructorList = new ArrayList<>();

    @Override
    public void save(Instructor instructorData) {
        if (findByID(instructorData.getPersonID()) != null) {
            throw new DuplicateIDException("Error: Instructor ID " + instructorData.getPersonID() + " already exists!");
        }
        instructorList.add(instructorData);
        System.out.println("Instructor " + instructorData.getPersonName() + " saved successfully.");
    }

    @Override
    public List<Instructor> displayAll() {
        if (instructorList.isEmpty()) {
            System.out.println("No instructors found.");
        }
        for (Instructor i : instructorList) {
            System.out.println("ID: " + i.getPersonID() + " | Name: " + i.getPersonName());
        }
        return instructorList;
    }

    @Override
    public Instructor findByID(String instructorID) {
        for (Instructor i : instructorList) {
            if (i.getPersonID().equalsIgnoreCase(instructorID)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void updateInstructor(String instructorID, Instructor instructorInfo) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getPersonID().equalsIgnoreCase(instructorID)) {
                instructorList.set(i, instructorInfo);
                System.out.println("Instructor " + instructorID + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Instructor ID not found.");
    }

    @Override
    public void deleteInstructor(String instructorID) {
        Instructor found = findByID(instructorID);
        if (found != null) {
            String name = found.getPersonName();
            instructorList.remove(found);
            System.out.println("Instructor " + name + " deleted successfully.");
        } else {
            System.out.println("Error: Instructor ID not found.");
        }
    }

    @Override
    public void assignInstructorToSection(Instructor instructorData, Section sectionData) {
        sectionData.setAssignedInstructor(instructorData);
        System.out.println("Success: " + instructorData.getPersonName() + " assigned to " + sectionData.getSectionName());
    }
}