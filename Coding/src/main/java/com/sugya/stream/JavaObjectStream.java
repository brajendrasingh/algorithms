package com.sugya.stream;

import java.util.*;
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
                .sorted(Comparator.comparing((Employee e) -> e.name).thenComparing(e -> e.city)).collect(Collectors.toList());
        sortedEmployees.forEach(System.out::println);
    }

    public void hrAndFinanceEmployees() {
        List<Department> allDepartments = getSampleData();
        List<Employee> hrAndFinanceEmployees = allDepartments.stream()
                .filter(dept -> "HR".equalsIgnoreCase(dept.getDptName()) || "Finance".equalsIgnoreCase(dept.getDptName()))
                .flatMap(dept -> dept.getEmployeeList().stream()).collect(Collectors.toList());

        hrAndFinanceEmployees.forEach(System.out::println);
    }

    public void employeeCountPerSkill() {
        List<Employee> list = List.of(new Employee("Amit", List.of("Java", "JS", "SQL", "MSA")),
                new Employee("Rahul",  List.of("Java", "JS", "SQL", "MSA")),
                new Employee("Neha",  List.of("Java", "JS", "SQL", "MSA")),
                new Employee("Priya",  List.of("Java", "Angular", "SQL", "MSA")),
                new Employee("Amit",  List.of("Java", "React", "SQL", "MSA")),
                new Employee("Sneha",  List.of("Java", ".Net", "Spring", "REST")),
                new Employee("Vikram",  List.of("Java", "Node", "Spring", "REST")));
        //Java=7, SQL=5, JS=3, MSA=5
        Map<String, Long> m = list.stream().flatMap(e -> e.getSkills().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        m.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public void averageSalaryPerDepartment() {
        List<Employee> list = List.of(new Employee("Amit", 85000, "Bangalore", "IT"),
                new Employee("Rahul", 95000, "Mumbai", "IT"),
                new Employee("Neha", 78000, "Pune", "HR"),
                new Employee("Priya", 60000, "Delhi", "HR"),
                new Employee("Amit", 65000, "Bangalore", "Sales"),
                new Employee("Sneha", 55000, "Mumbai", "Sales"),
                new Employee("Vikram", 55000, "Chennai", "Finance"));
        //IT=90k, HR=69k, Sales=60k, finance=55k
        Map<String, Double> m = list.stream().collect(Collectors.groupingBy(e -> e.getDpt(),
                Collectors.averagingDouble(e -> e.getSalary())));

        m.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public void highestPaidEmployeePerDepartment() {
        List<Employee> list = List.of(new Employee("Amit", 85000, "Bangalore", "IT"),
                new Employee("Rahul", 95000, "Mumbai", "IT"),
                new Employee("Neha", 78000, "Pune", "HR"),
                new Employee("Priya", 60000, "Delhi", "HR"),
                new Employee("Amit", 65000, "Bangalore", "Sales"),
                new Employee("Sneha", 55000, "Mumbai", "Sales"),
                new Employee("Vikram", 55000, "Chennai", "Finance"));
        //IT=95k, HR=78k, Sales=65k, finance=55k
        Map<String, Optional<Employee>> m = list.stream().collect(Collectors.groupingBy(e -> e.getDpt(),
                Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));

        m.forEach((k, v) -> System.out.println(k + " -> " + v.get().getSalary()));
    }

    public void lowestPaidEmployeePerDepartment() {
        List<Employee> list = List.of(new Employee("Amit", 85000, "Bangalore", "IT"),
                new Employee("Rahul", 95000, "Mumbai", "IT"),
                new Employee("Neha", 78000, "Pune", "HR"),
                new Employee("Priya", 60000, "Delhi", "HR"),
                new Employee("Amit", 65000, "Bangalore", "Sales"),
                new Employee("Sneha", 55000, "Mumbai", "Sales"),
                new Employee("Vikram", 35000, "Chennai", "Finance"));
        //IT=85k, HR=60k, Sales=55k, finance=35k
        Map<String, Optional<Employee>> m = list.stream().collect(Collectors.groupingBy(e -> e.getDpt(),
                Collectors.minBy(Comparator.comparing(e -> e.getSalary()))));

        m.forEach((k, v) -> System.out.println(k + " -> " + v.get().getSalary()));
    }

    public void employeeCountPerDepartment() {
        List<Employee> list = List.of(new Employee("Amit", 85000, "Bangalore", "IT"),
                new Employee("Rahul", 95000, "Mumbai", "IT"),
                new Employee("Neha", 78000, "Pune", "HR"),
                new Employee("Priya", 60000, "Delhi", "HR"),
                new Employee("Amit", 65000, "Bangalore", "HR"),
                new Employee("Sneha", 55000, "Mumbai", "Sales"),
                new Employee("Vikram", 55000, "Chennai", "Finance"));
        //IT=2, HR=3, Sales=1, finance=1
        Map<String, Long> m = list.stream().collect(Collectors.groupingBy(e -> e.getDpt(), Collectors.counting()));
        System.out.println(m);
    }

    public void highestPaidEmployeesPerDepartment() {
        List<Department> dptList = getSampleData();
        //IT=95k, HR=65k, Sales=55k
        Map<String, Optional<Employee>> m = dptList.stream().collect(Collectors.toMap(d -> d.getDptName(),
                d -> d.getEmployeeList().stream().max(Comparator.comparing(e -> e.getSalary()))));
        m.forEach((k, v) -> System.out.println(k + " -> " + v.get().getSalary()));
        System.out.println("---------------------------------------------------------------");
        //if we have duplicate dpt like below: //IT=95k, HR=65k, Sales=85k
        dptList.add(new Department("Sales", List.of(new Employee("Neha", 85000, "Kanpur"))));

        Map<String, Optional<Employee>> map = dptList.stream().collect(Collectors.groupingBy(d -> d.getDptName(),
        Collectors.flatMapping(d -> d.employeeList.stream(), Collectors.maxBy(Comparator.comparingDouble(e -> e.salary)))));

        map.forEach((k, v) -> System.out.println(k + " -> " + v.get().getSalary()));
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
//        for (Department dept : allDepartments) {
//            System.out.println("Department: " + dept.dptName + " | Total Staff: " + dept.employeeList.size());
//            for (Employee emp : dept.employeeList) {
//                System.out.println("  -> " + emp.name + " | Salary: ₹" + emp.salary + " | City: " + emp.city);
//            }
//        }
        return allDepartments;
    }
}
