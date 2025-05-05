DROP DATABASE IF EXISTS `shopping_online`;
CREATE DATABASE `shopping_online`;
USE `shopping_online`;

CREATE TABLE users (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(500) NOT NULL,
    fullname VARCHAR(500),
    status VARCHAR(50),
    role VARCHAR(50)
);

CREATE TABLE orders (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(500),
    status VARCHAR(255),
    total_amount NUMERIC(19, 3),
    user_id INT(10),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE products (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(500),
    description VARCHAR(500),
    price NUMERIC(19, 3),
    stock INT(10),
    original_price NUMERIC(19, 3),
    category VARCHAR(255)
);

CREATE TABLE carts (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    user_id INT(10),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE cart_items (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    product_id INT(10),
    quantity INT(10),
    cart_id INT(10),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (cart_id) REFERENCES carts(id)
);

CREATE TABLE order_items (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    product_id INT(10),
    order_id INT(10),
    original_price NUMERIC(19, 3),
    price NUMERIC(19, 3),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);


-- USERS
INSERT INTO users (email, password, fullname, status, role) VALUES
('alice@example.com', 'password123', 'Alice Johnson', 'active', 'customer'),
('bob@example.com', 'password123', 'Bob Smith', 'active', 'customer'),
('carol@example.com', 'password123', 'Carol Nguyen', 'active', 'customer'),
('david@example.com', 'password123', 'David Lee', 'active', 'customer'),
('eva@example.com', 'password123', 'Eva Chen', 'inactive', 'customer'),
('frank@example.com', 'password123', 'Frank Wright', 'active', 'admin'),
('grace@example.com', 'password123', 'Grace Kim', 'active', 'customer'),
('henry@example.com', 'password123', 'Henry Ford', 'active', 'customer'),
('ivy@example.com', 'password123', 'Ivy Zhao', 'active', 'customer'),
('jack@example.com', 'password123', 'Jack Ma', 'active', 'customer');

-- CARTS
INSERT INTO carts (user_id) VALUES
(1),(1),(5),(4),(5),(5),(7),(8),(9),(10);

-- PRODUCTS
INSERT INTO products (name, description, price, stock, original_price, category) VALUES
('Laptop A', 'High-end laptop', 1200.00, 10, 1500.00, 'Electronics'),
('Smartphone X', 'Flagship phone', 999.99, 20, 1099.99, 'Electronics'),
('Headphones B', 'Noise cancelling', 150.00, 15, 200.00, 'Accessories'),
('Keyboard C', 'Mechanical keyboard', 80.00, 25, 100.00, 'Accessories'),
('Mouse D', 'Wireless mouse', 45.00, 30, 60.00, 'Accessories'),
('Monitor E', '27-inch 4K', 300.00, 12, 350.00, 'Electronics'),
('Tablet F', '10-inch Android', 400.00, 18, 450.00, 'Electronics'),
('Charger G', 'Fast charger', 25.00, 50, 30.00, 'Accessories'),
('Camera H', 'DSLR 24MP', 800.00, 8, 950.00, 'Photography'),
('Watch I', 'Smart watch', 199.99, 0, 249.99, 'Wearables'),
('TV J', 'Smart 55-inch', 650.00, 5, 800.00, 'Electronics'),
('Router K', 'WiFi 6 router', 120.00, 14, 150.00, 'Networking'),
('Speaker L', 'Bluetooth speaker', 75.00, 40, 90.00, 'Audio'),
('Powerbank M', '20,000mAh', 60.00, 60, 70.00, 'Accessories'),
('Fan N', 'Desk fan', 35.00, 33, 45.00, 'Home'),
('Lamp O', 'LED desk lamp', 25.00, 45, 30.00, 'Home'),
('Mic P', 'USB microphone', 110.00, 0, 130.00, 'Audio'),
('Chair Q', 'Ergonomic chair', 220.00, 7, 250.00, 'Furniture'),
('Bag R', 'Laptop backpack', 90.00, 20, 120.00, 'Fashion'),
('Shoes S', 'Running shoes', 150.00, 12, 180.00, 'Fashion');

-- CART ITEMS
INSERT INTO cart_items (product_id, quantity, cart_id) VALUES
(1, 1, 1), (2, 1, 1), (3, 2, 2), (4, 1, 2), (5, 1, 3),
(6, 2, 3), (7, 1, 4), (8, 1, 4), (9, 1, 5), (10, 2, 5),
(11, 1, 6), (12, 1, 6), (13, 2, 7), (14, 1, 7), (15, 1, 8),
(16, 2, 8), (17, 1, 9), (18, 1, 9), (19, 1, 10), (20, 2, 10),
(1, 1, 6), (2, 1, 3), (3, 1, 9), (4, 1, 10), (5, 1, 7),
(6, 2, 8), (7, 1, 5), (8, 1, 2), (9, 1, 1), (10, 1, 4);

-- ORDERS
INSERT INTO orders (description, status, total_amount, user_id) VALUES
('Order for Alice', 'completed', 2150.00, 1),
('Order for Bob', 'pending', 850.00, 2),
('Order for Carol', 'shipped', 560.00, 3),
('Order for David', 'cancelled', 420.00, 4),
('Order for Eva', 'completed', 1500.00, 5),
('Order for Frank', 'shipped', 1150.00, 6),
('Order for Grace', 'pending', 720.00, 7),
('Order for Henry', 'completed', 930.00, 8),
('Order for Ivy', 'completed', 1030.00, 9),
('Order for Jack', 'pending', 1100.00, 10);

-- ORDER ITEMS
INSERT INTO order_items (product_id, order_id, original_price, price) VALUES
(1, 1, 1500.00, 1200.00), (2, 1, 1099.99, 950.00),
(3, 2, 200.00, 150.00), (4, 2, 100.00, 80.00),
(5, 3, 60.00, 45.00), (6, 3, 350.00, 300.00),
(7, 4, 450.00, 400.00), (8, 4, 30.00, 25.00),
(9, 5, 950.00, 800.00), (10, 5, 249.99, 199.99),
(11, 6, 800.00, 650.00), (12, 6, 150.00, 120.00),
(13, 7, 90.00, 75.00), (14, 7, 70.00, 60.00),
(15, 8, 45.00, 35.00), (16, 8, 30.00, 25.00),
(17, 9, 130.00, 110.00), (18, 9, 250.00, 220.00),
(19, 10, 120.00, 90.00), (20, 10, 180.00, 150.00);


