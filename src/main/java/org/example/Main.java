package org.example;

import org.example.Model.Course;
import org.example.Model.Instructor;
import org.example.Model.Student;
import org.example.Model.Department;
import org.example.Model.Section;
import org.example.Service.CampusRegistrarController;
import org.example.Service.CourseRegistration;
import org.example.Service.DepartmentRegistrationService;
import org.example.Service.StudentRegistration;
import org.example.Model.TuitionFeePayment;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StudentRegistration studentRegis = new StudentRegistration();
    static CourseRegistration courseRegis = new CourseRegistration();
    static DepartmentRegistrationService deptService = new DepartmentRegistrationService();
    static CampusRegistrarController controller = new CampusRegistrarController(deptService, studentRegis, courseRegis);
    static TuitionFeePayment tuitionFeePayment = new TuitionFeePayment();

    public static void main(String[] args) {

        // good practice for code ; do not remove
        Student student = new Student();
        student.mainTask();

        Instructor instructor = new Instructor();
        instructor.mainTask();
        System.out.println();

        int choice;

        do {
            System.out.println("\n===== ENROLLMENT SYSTEM =====");
            System.out.println("[1] Student Management");
            System.out.println("[2] Course Management");
            System.out.println("[3] Department Management");
            System.out.println("[4] Tuition Fee");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    courseMenu();
                    break;
                case 3:
                    departmentMenu();
                    break;
                case 4:
                    tuitionMenu();
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // ===== STUDENT MENU =====
    static void studentMenu() {
        System.out.println("\n--- Student Management ---");
        System.out.println("[1] Add Student");
        System.out.println("[2] Display All Students");
        System.out.println("[3] Update Student");
        System.out.println("[4] Remove Student");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Student ID: ");
                String sID = scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String sName = scanner.nextLine();
                System.out.print("Enter Program: ");
                String sProgram = scanner.nextLine();
                controller.saveStudent(new Student(sID, sName, sProgram));
                System.out.println("Student added!");
                break;
            case 2:
                controller.displayAllStudents();
                break;
            case 3:
                System.out.print("Enter Student ID to update: ");
                String usID = scanner.nextLine();
                System.out.print("Enter New Name: ");
                String usName = scanner.nextLine();
                System.out.print("Enter New Program: ");
                String usProgram = scanner.nextLine();
                studentRegis.updateStudent(new Student(usID, usName, usProgram));
                System.out.println("Student updated!");
                break;
            case 4:
                System.out.print("Enter Student ID to remove: ");
                String rsID = scanner.nextLine();
                studentRegis.removeStudent(new Student(rsID, "", ""));
                System.out.println("Student removed!");
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
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Course ID: ");
                String cID = scanner.nextLine();
                System.out.print("Enter Course Name: ");
                String cName = scanner.nextLine();
                System.out.print("Enter Program: ");
                String cProgram = scanner.nextLine();
                controller.saveCourse(new Course(cID, cName, cProgram));
                System.out.println("Course added!");
                break;
            case 2:
                controller.displayAllCourses();
                break;
            case 3:
                System.out.print("Enter Course ID to update: ");
                String ucID = scanner.nextLine();
                System.out.print("Enter New Course Name: ");
                String ucName = scanner.nextLine();
                System.out.print("Enter New Program: ");
                String ucProgram = scanner.nextLine();
                courseRegis.updateCourse(new Course(ucID, ucName, ucProgram));
                System.out.println("Course updated!");
                break;
            case 4:
                System.out.print("Enter Course ID to remove: ");
                String rcID = scanner.nextLine();
                courseRegis.removeCourse(new Course(rcID, "", ""));
                System.out.println("Course removed!");
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
        System.out.println("[5] Add Student to Section");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Department ID: ");
                String dID = scanner.nextLine();
                System.out.print("Enter Department Name: ");
                String dName = scanner.nextLine();
                controller.saveDepartment(new Department(dID, dName));
                System.out.println("Department added!");
                break;
            case 2:
                controller.displayAllDepartments();
                break;
            case 3:
                System.out.print("Enter Department ID: ");
                String sdID = scanner.nextLine();
                System.out.print("Enter Section ID: ");
                String sID = scanner.nextLine();
                System.out.print("Enter Section Name: ");
                String sName = scanner.nextLine();
                controller.addSectionToDepartment(sdID, new Section(sID, sName));
                break;
            case 4:
                System.out.print("Enter Department ID: ");
                String idID = scanner.nextLine();
                System.out.print("Enter Instructor ID: ");
                String iID = scanner.nextLine();
                System.out.print("Enter Instructor Name: ");
                String iName = scanner.nextLine();
                System.out.print("Enter Course Handled: ");
                String iCourse = scanner.nextLine();
                controller.addInstructorToDepartment(idID, new Instructor(iID, iName, iCourse));
                break;
            case 5:
                System.out.print("Enter Department ID: ");
                String stDID = scanner.nextLine();
                System.out.print("Enter Section ID: ");
                String stSID = scanner.nextLine();
                System.out.print("Enter Student ID: ");
                String stID = scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String stName = scanner.nextLine();
                System.out.print("Enter Program: ");
                String stProgram = scanner.nextLine();
                controller.addStudentToSection(stDID, stSID, new Student(stID, stName, stProgram));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // ===== TUITION MENU =====
    static void tuitionMenu() {
        System.out.println("\n--- Tuition Fee ---");
        System.out.println("[1] Calculate Tuition Fee");
        System.out.println("[2] Make Payment");
        System.out.println("[3] Check Balance");
        System.out.println("[4] Check Payment Status");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter number of units: ");
                int units = scanner.nextInt();
                System.out.print("Enter discount rate (0 if none): ");
                double discount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Total Tuition Fee: " + tuitionFeePayment.calculateTuitionFee(units, discount));
                break;
            case 2:
                System.out.print("Enter payment amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                tuitionFeePayment.makePayment(amount);
                System.out.println("Remaining balance: " + tuitionFeePayment.getBalance());
                break;
            case 3:
                System.out.println("Balance: " + tuitionFeePayment.getBalance());
                break;
            case 4:
                System.out.println("Fully Paid: " + tuitionFeePayment.isFullyPaid());
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}