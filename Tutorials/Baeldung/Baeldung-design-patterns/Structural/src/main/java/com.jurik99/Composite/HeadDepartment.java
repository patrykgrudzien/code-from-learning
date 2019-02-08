package com.jurik99.Composite;

import java.util.ArrayList;
import java.util.List;

// Composite Element
public class HeadDepartment implements Department {

    private Integer id;
    private String name;

    private List<Department> childDepartments;

    public HeadDepartment(final Integer id, final String name) {
        this.id = id;
        this.name = name;
        this.childDepartments = new ArrayList<>();
    }

    @Override
    public void printDepartmentName() {
        childDepartments.forEach(Department::printDepartmentName);
    }

    public void addDepartment(final Department department) {
        childDepartments.add(department);
    }

    public void removeDepartment(final Department department) {
        childDepartments.remove(department);
    }

    /**
     * This is a composite class as it holds a collection of Department components, as well as methods for adding and removing elements from the list.
     *
     * The composite printDepartmentName() method is implemented by iterating over the list of leaf elements and invoking the appropriate method for each one.
     */
}
