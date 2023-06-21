-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotel_management
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel_management
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_management` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hotel_management` ;

-- -----------------------------------------------------
-- Table `hotel_management`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management`.`client` (
                                                           `id` INT NOT NULL AUTO_INCREMENT,
                                                           `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `phone_number` VARCHAR(20) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `country` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotel_management`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management`.`hotel` (
                                                          `id` INT NOT NULL AUTO_INCREMENT,
                                                          `name` VARCHAR(100) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `room_count` INT NOT NULL,
    `rating` DOUBLE NULL DEFAULT NULL,
    `phone_number` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotel_management`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management`.`room` (
                                                         `id` INT NOT NULL AUTO_INCREMENT,
                                                         `hotel_id` INT NOT NULL,
                                                         `room_number` VARCHAR(255) NOT NULL,
    `bed_count` INT NOT NULL,
    `room_type` VARCHAR(255) NOT NULL,
    `price` DOUBLE NOT NULL,
    `availability` BIT(1) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `room_ibfk_1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotel_management`.`hotel` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `hotel_id` ON `hotel_management`.`room` (`hotel_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `hotel_management`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management`.`booking` (
                                                            `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                            `client_id` INT NOT NULL,
                                                            `room_id` INT NOT NULL,
                                                            `start_date` DATE NOT NULL,
                                                            `end_date` DATE NOT NULL,
                                                            `status` ENUM('ACTIVE', 'COMPLETED') NULL DEFAULT NULL,
    `guest_count` INT NOT NULL,
    `additional_requirements` TEXT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `booking_ibfk_1`
    FOREIGN KEY (`client_id`)
    REFERENCES `hotel_management`.`client` (`id`),
    CONSTRAINT `booking_ibfk_2`
    FOREIGN KEY (`room_id`)
    REFERENCES `hotel_management`.`room` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `client_id` ON `hotel_management`.`booking` (`client_id` ASC) VISIBLE;

CREATE INDEX `room_id` ON `hotel_management`.`booking` (`room_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `hotel_management`.`service_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management`.`service_category` (
                                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                                     `name` VARCHAR(255) NOT NULL,
    `price` DOUBLE NOT NULL,
    `availability` TINYINT(1) NOT NULL,
    `description` VARCHAR(255) NULL DEFAULT NULL,
    `category` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotel_management`.`service_management`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management`.`service_management` (
                                                                       `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                                       `hotel_id` INT NOT NULL,
                                                                       `service_id` INT NOT NULL,
                                                                       PRIMARY KEY (`id`),
    CONSTRAINT `service_management_ibfk_1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotel_management`.`hotel` (`id`),
    CONSTRAINT `service_management_ibfk_2`
    FOREIGN KEY (`service_id`)
    REFERENCES `hotel_management`.`service_category` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `hotel_id` ON `hotel_management`.`service_management` (`hotel_id` ASC) VISIBLE;

CREATE INDEX `service_id` ON `hotel_management`.`service_management` (`service_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
