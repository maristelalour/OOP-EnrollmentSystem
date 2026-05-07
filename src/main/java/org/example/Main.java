package org.example;

import org.example.Model.*;
import org.example.Service.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static StudentReg studentRepo = new StudentRegistration();
    static CourseReg courseRepo = new CourseRegistration();
    static DepartmentRegis deptRepo = new DepartmentRegistration();
    static SectionReg sectionRepo = new SectionRegistration();
    static TuitionReg financialRepo = new TuitionRegistration();
    static EnrollmentReg enrollmentEngine = new EnrollmentService();
    static InstructorReg facultyRepo = new InstructorRegistration();
    static CampusRegistrar registrar = new CampusRegistrar(
            studentRepo, courseRepo, deptRepo, sectionRepo,
            financialRepo, enrollmentEngine, facultyRepo);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n====================================");
            System.out.println("       ENROLLMENT SYSTEM MENU       ");
            System.out.println("====================================");
            System.out.println("[1] Student Management");
            System.out.println("[2] Course Management");
            System.out.println("[3] Instructor Management");
            System.out.println("[4] Section Management");
            System.out.println("[5] Department Management");
            System.out.println("[6] Enrollment");
            System.out.println("[7] Tuition Fee Management");
            System.out.println("[8] View Institutional Hierarchy");
            System.out.println("[0] Exit");
            System.out.println("====================================");
            System.out.print("Enter choice: ");
            String choice = input.nextLine().trim();
            switch (choice) {
                case "1": studentMenu(); break;
                case "2": courseMenu(); break;
                case "3": instructorMenu(); break;
                case "4": sectionMenu(); break;
                case "5": departmentMenu(); break;
                case "6": enrollmentMenu(); break;
                case "7": tuitionMenu(); break;
                case "8": registrar.displayHierarchy(); break;
                case "0":
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        input.close();
    }

    // ===== STUDENT MENU =====
    static void studentMenu() {
        System.out.println("\n--- Student Management ---");
        System.out.println("[1] Add Student");
        System.out.println("[2] Display All Students");
        System.out.println("[3] Update Student");
        System.out.println("[4] Remove Student");
        System.out.print("Enter choice: ");
        String choice = input.nextLine().trim();
        switch (choice) {
            case "1":
                System.out.print("Enter Student ID: ");
                String sID = input.nextLine().trim();
                System.out.print("Enter Student Name: ");
                String sName = input.nextLine().trim();
                System.out.print("Enter Program: ");
                String sProgram = input.nextLine().trim();
                registrar.addStudent(new Student(sID, sName, sProgram));
                break;
            case "2":
                registrar.displayAllStudents();
                break;
            case "3":
                System.out.print("Enter Student ID to update: ");
                String usID = input.nextLine().trim();
                System.out.print("Enter New Name: ");
                String usName = input.nextLine().trim();
                System.out.print("Enter New Program: ");
                String usProgram = input.nextLine().trim();
                registrar.updateStudent(new Student(usID, usName, usProgram));
                break;
            case "4":
                System.out.print("Enter Student ID to remove: ");
                String rsID = input.nextLine().trim();
                registrar.removeStudent(rsID);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // ===== COURSE MENU =====
    static void courseMenu() {
        System.out.println("\n--- Course Management ---");
        System.out.println("[1] Add Course");
        System.out.println("[2] Display All Courses");
        System.out.println("[3] Update Course");
        System.out.println("[4] Remove Course");
        System.out.print("Enter choice: ");
        String choice = input.nextLine().trim();
        switch (choice) {
            case "1":
                System.out.print("Enter Course ID: ");
                String cID = input.nextLine().trim();
                System.out.print("Enter Course Name: ");
                String cName = input.nextLine().trim();
                System.out.print("Enter Program: ");
                String cProgram = input.nextLine().trim();
                int cUnits = 0;
                try {
                    System.out.print("Enter Units: ");
                    cUnits = Integer.parseInt(input.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Defaulting to 3 units.");
                    cUnits = 3;
                }
                registrar.addCourse(new Course(cID, cName, cProgram, cUnits));
                break;
            case "2":
                registrar.displayAllCourses();
                break;
            case "3":
                System.out.print("Enter Course ID to update: ");
                String ucID = input.nextLine().trim();
                System.out.print("Enter New Course Name: ");
                String ucName = input.nextLine().trim();
                System.out.print("Enter New Program: ");
                String ucProgram = input.nextLine().trim();
                int ucUnits = 0;
                try {
                    System.out.print("Enter New Units: ");
                    ucUnits = Integer.parseInt(input.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Defaulting to 3 units.");
                    ucUnits = 3;
                }
                registrar.updateCourse(new Course(ucID, ucName, ucProgram, ucUnits));
                break;
            case "4":
                System.out.print("Enter Course ID to remove: ");
                String rcID = input.nextLine().trim();
                registrar.removeCourse(rcID);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // ===== INSTRUCTOR MENU =====
    static void instructorMenu() {
        System.out.println("\n--- Instructor Management ---");
        System.out.println("[1] Add Instructor");
        System.out.println("[2] Display All Instructors");
        System.out.println("[3] Update Instructor");
        System.out.println("[4] Remove Instructor");
        System.out.println("[5] Assign Instructor to Section");
        System.out.print("Enter choice: ");
        String choice = input.nextLine().trim();
        switch (choice) {
            case "1":
                System.out.print("Enter Instructor ID: ");
                String iID = input.nextLine().trim();
                System.out.print("Enter Instructor Name: ");
                String iName = input.nextLine().trim();
                System.out.print("Enter Course Handled: ");
                String iCourse = input.nextLine().trim();
                registrar.addInstructor(new Instructor(iID, iName, iCourse));
                break;
            case "2":
                registrar.displayAllInstructors();
                break;
            case "3":
                System.out.print("Enter Instructor ID to update: ");
                String uiID = input.nextLine().trim();
                System.out.print("Enter New Name: ");
                String uiName = input.nextLine().trim();
                System.out.print("Enter New Course Handled: ");
                String uiCourse = input.nextLine().trim();
                registrar.updateInstructor(uiID, new Instructor(uiID, uiName, uiCourse));
                break;
            case "4":
                System.out.print("Enter Instructor ID to remove: ");
                String riID = input.nextLine().trim();
                registrar.removeInstructor(riID);
                break;
            case "5":
                System.out.print("Enter Instructor ID: ");
                String aiID = input.nextLine().trim();
                System.out.print("Enter Section Name: ");
                String aiSection = input.nextLine().trim();
                registrar.assignInstructorToSection(aiID, aiSection);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // ===== SECTION MENU =====
    static void sectionMenu() {
        System.out.println("\n--- Section Management ---");
        System.out.println("[1] Add Section");
        System.out.println("[2] Display All Sections");
        System.out.println("[3] Update Section");
        System.out.println("[4] Delete Section");
        System.out.println("[5] View Section Details");
        System.out.println("[6] Assign Course to Section");
        System.out.print("Enter choice: ");
        String choice = input.nextLine().trim();
        switch (choice) {
            case "1":
                System.out.print("Enter Section ID: ");
                String sID = input.nextLine().trim();
                System.out.print("Enter Section Name: ");
                String sName = input.nextLine().trim();
                int sCap = 0;
                try {
                    System.out.print("Enter Max Capacity: ");
                    sCap = Integer.parseInt(input.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Defaulting to 30.");
                    sCap = 30;
                }
                registrar.addSection(new Section(sID, sName, sCap));
                break;
            case "2":
                registrar.displayAllSections();
                break;
            case "3":
                System.out.print("Enter Section Name to update: ");
                String usName = input.nextLine().trim();
                System.out.print("Enter New Section ID: ");
                String usID = input.nextLine().trim();
                System.out.print("Enter New Section Name: ");
                String usNewName = input.nextLine().trim();
                int usCap = 0;
                try {
                    System.out.print("Enter New Max Capacity: ");
                    usCap = Integer.parseInt(input.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Defaulting to 30.");
                    usCap = 30;
                }
                registrar.updateSection(usName, new Section(usID, usNewName, usCap));
                break;
            case "4":
                System.out.print("Enter Section Name to delete: ");
                String dsName = input.nextLine().trim();
                registrar.deleteSection(dsName);
                break;
            case "5":
                System.out.print("Enter Section Name: ");
                String vsName = input.nextLine().trim();
                registrar.displaySectionDetails(vsName);
                break;
            case "6":
                System.out.print("Enter Section Name: ");
                String acSection = input.nextLine().trim();
                System.out.print("Enter Course ID: ");
                String acCourse = input.nextLine().trim();
                registrar.assignCourseToSection(acSection, acCourse);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // ===== DEPARTMENT MENU =====
    static void departmentMenu() {
        System.out.println("\n--- Department Management ---");
        System.out.println("[1] Add Department");
        System.out.println("[2] Display All Departments");
        System.out.println("[3] Add Section to Department");
        System.out.println("[4] Add Instructor to Department");
        System.out.print("Enter choice: ");
        String choice = input.nextLine().trim();
        switch (choice) {
            case "1":
                System.out.print("Enter Department ID: ");
                String dID = input.nextLine().trim();
                System.out.print("Enter Department Name: ");
                String dName = input.nextLine().trim();
                registrar.addDepartment(new Department(dID, dName,
                        new ArrayList<>(), new ArrayList<>()));
                break;
            case "2":
                registrar.displayAllDepartments();
                break;
            case "3":
                System.out.print("Enter Department Name: ");
                String sdName = input.nextLine().trim();
                System.out.print("Enter Section Name: ");
                String ssName = input.nextLine().trim();
                registrar.addSectionToDepartment(sdName, ssName);
                break;
            case "4":
                System.out.print("Enter Department Name: ");
                String idName = input.nextLine().trim();
                System.out.print("Enter Instructor ID: ");
                String iiID = input.nextLine().trim();
                registrar.addInstructorToDepartment(idName, iiID);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // ===== ENROLLMENT MENU =====
    static void enrollmentMenu() {
        System.out.println("\n--- Enrollment ---");
        System.out.println("[1] Enroll Student in Section");
        System.out.println("[2] View Department Hierarchy");
        System.out.print("Enter choice: ");
        String choice = input.nextLine().trim();
        switch (choice) {
            case "1":
                System.out.print("Enter Section Name: ");
                String sectionName = input.nextLine().trim();
                System.out.print("Enter Student ID: ");
                String studentID = input.nextLine().trim();
                registrar.enrollStudent(sectionName, studentID);
                break;
            case "2":
                registrar.displayHierarchy();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // ===== TUITION MENU =====
    static void tuitionMenu() {
        System.out.println("\n--- Tuition Fee Management ---");
        System.out.println("[1] Calculate Tuition Fee");
        System.out.println("[2] Make Payment");
        System.out.println("[3] Check Balance");
        System.out.print("Enter choice: ");
        String choice = input.nextLine().trim();
        switch (choice) {
            case "1":
                System.out.print("Enter Student ID: ");
                String tID = input.nextLine().trim();
                int units = 0;
                try {
                    System.out.print("Enter Number of Units: ");
                    units = Integer.parseInt(input.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Defaulting to 3 units.");
                    units = 3;
                }
                registrar.calculateAndSetTuition(tID, units);
                break;
            case "2":
                System.out.print("Enter Student ID: ");
                String pID = input.nextLine().trim();
                double amount = 0;
                try {
                    System.out.print("Enter Payment Amount: ");
                    amount = Double.parseDouble(input.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid amount.");
                }
                if (amount > 0) {
                    registrar.processPayment(pID, amount);
                }
                break;
            case "3":
                System.out.print("Enter Student ID: ");
                String bID = input.nextLine().trim();
                registrar.checkBalance(bID);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}