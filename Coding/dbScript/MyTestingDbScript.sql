-- Create database
CREATE DATABASE employee_db;
USE employee_db;

-- Department table
CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50) UNIQUE NOT NULL,
    location VARCHAR(50)
);

-- Employee table
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    salary DECIMAL(10,2),
    dept_id INT,
    manager_id INT,
    join_date DATE,
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

INSERT INTO departments VALUES
(1, 'HR', 'Mumbai'),
(2, 'IT', 'Bangalore'),
(3, 'Finance', 'Delhi'),
(4, 'Sales', 'Chennai');


INSERT INTO employees VALUES
(101, 'Amit', 'amit@company.com',   50000, 1, NULL, '2020-01-10'),
(102, 'Rohit', 'rohit@company.com',  60000, 2, 105,  '2021-03-15'),
(103, 'Neha', 'neha@company.com',   55000, 2, 105,  '2019-07-22'),
(104, 'Pooja', 'pooja@company.com',  45000, 1, 101,  '2022-06-01'),
(105, 'Suresh', 'suresh@company.com', 90000, 2, NULL, '2018-11-30'),
(106, 'Kiran', 'kiran@company.com',  70000, 3, 107,  '2020-09-10'),
(107, 'Manoj', 'manoj@company.com', 120000,3, NULL, '2017-05-19'),
(108, 'Ravi', 'ravi@company.com',   40000, 4, 109,  '2021-12-01'),
(109, 'Anil', 'anil@company.com',   80000, 4, NULL, '2019-08-14');
