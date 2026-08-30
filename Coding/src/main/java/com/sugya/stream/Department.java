package com.sugya.stream;

import java.util.ArrayList;
import java.util.List;

public class Department {
    public int did;
    public String dptName;
    public List<Employee> employeeList = new ArrayList<>();

    public Department() {
    }

    public Department(String name, List<Employee> employeeList) {
        this.dptName = name;
        this.employeeList = employeeList;
    }

    public Department(int did, String name, List<Employee> employeeList) {
        this.did = did;
        this.dptName = name;
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public int getDid() {
        return did;
    }

    public String getDptName() {
        return dptName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "Id=" + did +
                ", Name='" + dptName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

}