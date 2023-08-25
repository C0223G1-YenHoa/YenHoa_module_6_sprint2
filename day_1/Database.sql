create database car_parking;
use car_parking;
-- Tạo bảng "ParkingSlot" để lưu thông tin về từng vị trí đỗ xe trong bãi đỗ
CREATE TABLE ParkingSlot (
  id INT PRIMARY KEY,
  parking_id INT,
  slot_number VARCHAR(10),
  availability BOOLEAN
);

-- Tạo bảng "Customer" để lưu thông tin về khách hàng
CREATE TABLE Customer (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  phone VARCHAR(20)
);

-- Tạo bảng "Reservation" để lưu thông tin về việc đặt chỗ đỗ xe
CREATE TABLE Reservation (
  id INT PRIMARY KEY,
  parking_id INT,
  slot_id INT,
  customer_id INT,
  start_time DATETIME,
  end_time DATETIME,
  price bigint,
  FOREIGN KEY (slot_id) REFERENCES ParkingSlot(id),
  FOREIGN KEY (customer_id) REFERENCES Customer(id)
);

