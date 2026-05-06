package org.example.Service;

import org.example.Model.Department;
import java.util.*;

public interface DepartmentRegistration {
    void save(Department department);
    List<Department> displayAll();
}