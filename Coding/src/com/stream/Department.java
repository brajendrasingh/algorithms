package com.stream;

import java.util.ArrayList;
import java.util.List;

public class Department {

    public String dptName;
    public List<Employee> employeeList = new ArrayList<>();

    public Department() {
    }

    public Department(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    @Override
    public String toString() {
        return "Department: " + name + " | Employees: " + employeeList;
    }

}