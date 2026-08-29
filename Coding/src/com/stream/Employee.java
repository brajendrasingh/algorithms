package com.stream;

public class Employee {
    public int eid;
    public String eName;
    public double salary;
    public String city;

    public Employee() {
    }

    public Employee(String eName, double salary, String city) {
        this.eName = eName;
        this.salary = salary;
        this.city = city;
    }

    public Employee(int eid, String eName, double salary, String city) {
        this.eid = eid;
        this.eName = eName;
        this.salary = salary;
        this.city = city;
    }

    public int getEid() {
        return eid;
    }

    public String getEName() {
        return eName;
    }

    public double getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + eid +
                ", Name='" + eName + '\'' +
                ", Salary=" + salary +
                ", City='" + city + '\'' +
                '}';
    }
}