CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(15),
    id_number VARCHAR(20),
    gender CHAR(1),
    email VARCHAR(100),
    date_of_birth DATE,
    address VARCHAR(255),
    zip_code VARCHAR(10),
    salary DECIMAL(10, 2),
    department VARCHAR(50),
    join_date DATE,
    status VARCHAR(20)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
