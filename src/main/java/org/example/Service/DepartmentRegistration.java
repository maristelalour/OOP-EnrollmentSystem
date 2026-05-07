package org.example.Service;

import org.example.Model.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRegistration implements DepartmentRegis {
    private List<Department> departmentList = new ArrayList<>();

    @Override
    public void save(Department deptData) {
        for (Department d : departmentList) {
            if (d.getDepartmentName().equalsIgnoreCase(deptData.getDepartmentName())) {
                System.out.println("Error: Department '" + deptData.getDepartmentName() + "' already exists!");
                return;
            }
        }
        departmentList.add(deptData);
        System.out.println("Department " + deptData.getDepartmentName() + " saved successfully.");
    }

    @Override
    public List<Department> displayAll() {
        return departmentList;
    }
}