-- Create database
CREATE DATABASE customer_orders_db;
USE customer_orders_db;

-- Customers table
CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    city VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50),
    registration_date DATE
);

-- Categories table
CREATE TABLE categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL UNIQUE
);

-- Products table
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    category_id INT,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT DEFAULT 0,

    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

-- Orders table
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(30) DEFAULT 'PENDING',
    total_amount DECIMAL(12,2),

    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Order_items table
CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    discount DECIMAL(5,2) DEFAULT 0,

    FOREIGN KEY (order_id) REFERENCES orders(order_id),

    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

INSERT INTO categories (category_name) VALUES ('Electronics'),('Clothing'),('Books'),('Home Appliances'),('Sports');

INSERT INTO customers (first_name, last_name, email, phone, city, state, country, registration_date) VALUES
('Rahul', 'Sharma', 'rahul@gmail.com', '9876543210', 'Delhi', 'Delhi', 'India', '2024-01-10'),
('Amit', 'Verma', 'amit@gmail.com', '9876543211', 'Mumbai', 'Maharashtra', 'India', '2024-02-15'),
('Priya', 'Singh', 'priya@gmail.com', '9876543212', 'Lucknow', 'Uttar Pradesh', 'India', '2024-03-20'),
('Neha', 'Gupta', 'neha@gmail.com', '9876543213', 'Kanpur', 'Uttar Pradesh', 'India', '2024-04-05'),
('Rohan', 'Kumar', 'rohan@gmail.com', '9876543214', 'Bangalore', 'Karnataka', 'India', '2024-05-12'),
('Ankit', 'Yadav', 'ankit@gmail.com', '9876543215', 'Delhi', 'Delhi', 'India', '2024-06-18'),
('Sneha', 'Patel', 'sneha@gmail.com', '9876543216', 'Ahmedabad', 'Gujarat', 'India', '2024-07-22'),
('Vikas', 'Mishra', 'vikas@gmail.com', '9876543217', 'Lucknow', 'Uttar Pradesh', 'India', '2024-08-10'),
('Arjun', 'Mehta', 'arjun@gmail.com', '9876543218', 'Pune', 'Maharashtra', 'India', '2024-09-01'),
('Kavita', 'Joshi', 'kavita@gmail.com', '9876543219', 'Jaipur', 'Rajasthan', 'India', '2024-10-10'),
('Manish', 'Agarwal', 'manish@gmail.com', '9876543220', 'Noida', 'Uttar Pradesh', 'India', '2024-11-05'); 

INSERT INTO products (product_name, category_id, price, stock_quantity) VALUES
('Laptop', 1, 75000, 20),
('Mobile Phone', 1, 30000, 50),
('Headphones', 1, 2500, 100),
('T-Shirt', 2, 1200, 200),
('Jeans', 2, 2500, 150),
('Java Programming Book', 3, 800, 80),
('SQL Complete Guide', 3, 600, 100),
('Refrigerator', 4, 45000, 10),
('Washing Machine', 4, 30000, 15),
('Cricket Bat', 5, 3500, 40),
('Football', 5, 1500, 60);

INSERT INTO orders (customer_id, order_date, status, total_amount) VALUES
(1, '2025-01-10', 'DELIVERED', 77500),
(2, '2025-01-12', 'DELIVERED', 30000),
(1, '2025-02-05', 'DELIVERED', 3700),
(3, '2025-02-15', 'PENDING', 2500),
(4, '2025-03-01', 'DELIVERED', 45000),
(5, '2025-03-10', 'CANCELLED', 30000),
(2, '2025-04-05', 'DELIVERED', 6000),
(6, '2025-04-15', 'DELIVERED', 3500),
(1, '2025-05-01', 'DELIVERED', 800),
(7, '2025-05-20', 'PENDING', 1500),
(3, '2025-06-01', 'DELIVERED', 31200),
(8, '2025-06-15', 'DELIVERED', 2500);

INSERT INTO order_items (order_id, product_id, quantity, unit_price, discount) VALUES
-- Order 1
(1, 1, 1, 75000, 0),
(1, 3, 1, 2500, 0),

-- Order 2
(2, 2, 1, 30000, 0),

-- Order 3
(3, 4, 1, 1200, 0),
(3, 5, 1, 2500, 0),

-- Order 4
(4, 5, 1, 2500, 0),

-- Order 5
(5, 8, 1, 45000, 0),

-- Order 6
(6, 9, 1, 30000, 0),

-- Order 7
(7, 10, 1, 3500, 0),
(7, 7, 5, 600, 0),

-- Order 8
(8, 10, 1, 3500, 0),

-- Order 9
(9, 6, 1, 800, 0),

-- Order 10
(10, 11, 1, 1500, 0),

-- Order 11
(11, 2, 1, 30000, 0),
(11, 4, 1, 1200, 0),

-- Order 12
(12, 5, 1, 2500, 0);