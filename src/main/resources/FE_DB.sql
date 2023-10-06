DROP DATABASE IF EXISTS `FE`;
CREATE DATABASE `FE`;
USE `FE`;

CREATE TABLE `Car`
(
    `license_plate` VARCHAR(10) UNIQUE NOT NULL,
    `repair_date` DATE NOT NULL,
    `customer_name` VARCHAR(50) NOT NULL,
    `catalogs` VARCHAR(50) NOT NULL,
    `car_maker` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`license_plate`, `repair_date`)
);



CREATE TABLE `Accessory`
(
    `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `license_plate` VARCHAR(10) UNIQUE NOT NULL,
    `repair_date` DATE NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `price` VARCHAR(50) NOT NULL,
    `status_damaged` VARCHAR(50) NOT NULL,
    `repair_status` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`license_plate`, `repair_date`) REFERENCES `Car`(`license_plate`, `repair_date`)
);


-- Inserting data into Car table
INSERT INTO Car (license_plate, repair_date, customer_name, catalogs, car_maker)
VALUES ('ABC123', '2022-01-01', 'John Doe', 'Catalog A', 'Maker X');

INSERT INTO Car (license_plate, repair_date, customer_name, catalogs, car_maker)
VALUES ('DEF456', '2022-01-02', 'Jane Smith', 'Catalog B', 'Maker Y');

-- Inserting data into Accessory table
INSERT INTO Accessory (license_plate, repair_date, name, price, status_damaged, repair_status)
VALUES ('ABC123', '2022-01-01', 'Seat Cover', '50', 'No', 'Completed');

INSERT INTO Accessory (license_plate, repair_date, name, price, status_damaged, repair_status)
VALUES ('DEF456', '2022-01-02', 'Floor Mats', '30',  'Yes', 'In Progress');



