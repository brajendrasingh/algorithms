package com.sugya.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaObjectStream {

    public void sortingByNameAndCity() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Amit", 50000, "Delhi"));
        employees.add(new Employee("Rahul", 60000, "Mumbai"));
        employees.add(new Employee("Amit", 70000, "Bangalore"));
        employees.add(new Employee("Neha", 55000, "Pune"));

        List<Employee> sortedEmployees = employees.stream()
                // 1. Sort by name, then tie-break by city
                .sorted(Comparator.comparing((Employee e) -> e.eName).thenComparing(e -> e.city)).collect(Collectors.toList());
        sortedEmployees.forEach(System.out::println);
    }

    public void hrAndFinanceEmployees() {
        List<Department> allDepartments = getSampleData();
        List<Employee> hrAndFinanceEmployees = allDepartments.stream()
                .filter(dept -> "HR".equalsIgnoreCase(dept.getDptName()) || "Finance".equalsIgnoreCase(dept.getDptName()))
                .flatMap(dept -> dept.getEmployeeList().stream()).collect(Collectors.toList());

        hrAndFinanceEmployees.forEach(System.out::println);
    }

    public void hrDptEmpCount() {
        List<Department> departments = getSampleData(); // Assume this holds your departments

        long hrEmployeeCount = departments.stream().filter(dept -> "HR".equalsIgnoreCase(dept.dptName))
                .mapToLong(dept -> dept.employeeList.size()).sum();

        System.out.println("Total HR Employees: " + hrEmployeeCount);
    }

    public List<Department> getSampleData() {
        // IT Department Employees
        Employee emp1 = new Employee("Amit", 85000, "Bangalore");
        Employee emp2 = new Employee("Rahul", 95000, "Mumbai");
        Employee emp3 = new Employee("Neha", 78000, "Pune");
        List<Employee> itEmployees = new ArrayList<>(Arrays.asList(emp1, emp2, emp3));

        // HR Department Employees
        Employee emp4 = new Employee("Priya", 60000, "Delhi");
        Employee emp5 = new Employee("Amit", 65000, "Bangalore"); // Same name as emp1, different dept/city
        List<Employee> hrEmployees = new ArrayList<>(Arrays.asList(emp4, emp5));

        // Sales Department Employees
        Employee emp6 = new Employee("Vikram", 55000, "Chennai");
        Employee emp7 = new Employee("Sneha", 55000, "Mumbai");
        List<Employee> salesEmployees = new ArrayList<>(Arrays.asList(emp6, emp7));

        // 2. Create the Department objects and assign the employee lists
        Department itDept = new Department();
        itDept.dptName = "IT";
        itDept.employeeList = itEmployees;

        Department hrDept = new Department();
        hrDept.dptName = "HR";
        hrDept.employeeList = hrEmployees;

        Department salesDept = new Department();
        salesDept.dptName = "Sales";
        salesDept.employeeList = salesEmployees;

        // 3. Combine everything into a master list of departments
        List<Department> allDepartments = new ArrayList<>(Arrays.asList(itDept, hrDept, salesDept));

        // --- Verify data layout by printing ---
        for (Department dept : allDepartments) {
            System.out.println("Department: " + dept.dptName + " | Total Staff: " + dept.employeeList.size());
            for (Employee emp : dept.employeeList) {
                System.out.println("  -> " + emp.eName + " | Salary: ₹" + emp.salary + " | City: " + emp.city);
            }
        }
        return allDepartments;
    }
}
