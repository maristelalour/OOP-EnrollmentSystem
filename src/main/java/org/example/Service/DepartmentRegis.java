package org.example.Service;

import org.example.Model.Department;
import java.util.*;

public interface DepartmentRegis {
    void save(Department deptData);
    List<Department> displayAll();
}