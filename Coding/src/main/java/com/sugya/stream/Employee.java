package com.sugya.stream;

public class Employee {
    public int id;
    public String name;
    public double salary;
    public String city;
    public String dpt;

    public Employee() {
    }

    public Employee(String name, double salary, String city) {
        this.name = name;
        this.salary = salary;
        this.city = city;
    }

    public Employee(String name, double salary, String city, String dpt) {
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.dpt = dpt;
    }

    public Employee(int id, String name, double salary, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    @Override
    public String toString() {
        return "Employee{" + "Id=" + id + ", Name='" + name + '\'' + ", Salary=" + salary + ", City='" + city + '\'' + ", Department='" + dpt + '\'' + '}';
    }
}