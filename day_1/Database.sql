create database car_parking;
use car_parking;


-- Tạo bảng "ParkingSlot" để lưu thông tin về từng vị trí đỗ xe trong bãi đỗ
CREATE TABLE parking_slot (
  parking_id INT PRIMARY KEY,
  slot_number VARCHAR(10),
  availability BOOLEAN
);



-- Tạo bảng roles 
create table roles(
role_id int primary key,
role_name varchar(100)
);

-- Tạo bảng account
create table `account` (
account_id int primary key,
accout_name varchar(100),
account_password varchar(100),
role_id int,
 FOREIGN KEY (role_id) REFERENCES roles(role_id)
);
 
-- Tạo bảng "Customer" để lưu thông tin về khách hàng
CREATE TABLE customer (
  customer_id INT PRIMARY KEY,
  `name` VARCHAR(100),
  email VARCHAR(100),
  phone VARCHAR(20),
  number_plate varchar(10),
  account_id int,
  FOREIGN KEY (account_id) REFERENCES account(account_id)
);

 -- Tạo bảng employee
create table employee  (
employee_id int primary key,
employee_name varchar(100),
employee_email varchar(100),
account_id int,
 FOREIGN KEY (account_id) REFERENCES account(account_id)
);

-- Tạo bảng "Reservation" để lưu thông tin về việc đặt chỗ đỗ xe
CREATE TABLE reservation (
  id INT PRIMARY KEY,
  parking_id INT,
  customer_id INT,
  start_time DATETIME,
  end_time DATETIME,
  price bigint,
  FOREIGN KEY (parking_id) REFERENCES parking_slot(parking_id),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);
