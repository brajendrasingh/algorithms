package com.stream;

public class Employee {
    public String eName;
    public String salary;
    public String city;

    public Employee() {
    }

    public Employee(String eName, double salary, String city) {
        this.eName = eName;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{name='" + eName + "', salary=" + salary + ", city='" + city + "'}";
    }
}