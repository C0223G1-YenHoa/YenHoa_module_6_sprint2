create database car_parking;
use car_parking;

-- Tạo bảng Parking
create table parking_car(
parking_id int auto_increment primary key,
floors int
); 

-- Tạo bảng "Floor"
Create table floor_parking(
floor_id int auto_increment primary key,
capacity int,
parking_id int,
 FOREIGN KEY (parking_id) REFERENCES parking_car(parking_id)
);

-- Tạo bảng "ParkingSlot" để lưu thông tin về từng vị trí đỗ xe trong bãi đỗ
CREATE TABLE parking_slot (
  parking_id INT auto_increment PRIMARY KEY,
  slot_number VARCHAR(10),
  availability bit(1),
  price_parking_slot bigint,
  floor_id int,
   FOREIGN KEY (floor_id) REFERENCES floor_parking(floor_id)
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
  account_id int,
  purse bigint,
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
  id INT auto_increment PRIMARY KEY,
  parking_id INT,
  account_id INT,
  start_time DATETIME,
  end_time DATETIME,
  price bigint,
  number_plate varchar(10),
  FOREIGN KEY (parking_id) REFERENCES parking_slot(parking_id),
  FOREIGN KEY (account_id) REFERENCES account(account_id)
);

-- phạt vi phạm
create table penalty(
penalty_id int auto_increment primary key,
penalty_price bigint,
penalty_hour int,
id INT,
 FOREIGN KEY (id) REFERENCES reservation(id)
);

