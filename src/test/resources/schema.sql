-- MySQL Script generated by MySQL Workbench
-- Wed Aug  2 17:13:50 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema budget
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema budget
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `budget` DEFAULT CHARACTER SET utf8 ;
USE `budget` ;

-- -----------------------------------------------------
-- Table `budget`.`expense`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget`.`expense` (
  `id_expense` BINARY(16) NOT NULL,
  `planned_value` DECIMAL(10,2) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_expense`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budget`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget`.`transaction` (
  `id_transaction` BINARY(16) NOT NULL,
  `value_transaction` DECIMAL(10,2) NOT NULL,
  `description` VARCHAR(100) NULL,
  `transaction_date` DATE NOT NULL,
  `id_expense` BINARY(16) NOT NULL,
  PRIMARY KEY (`id_transaction`),
  INDEX `fk_id_expense_96897657_idx` (`id_expense` ASC) VISIBLE,
  CONSTRAINT `fk_id_expense_96897657`
    FOREIGN KEY (`id_expense`)
    REFERENCES `budget`.`expense` (`id_expense`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budget`.`investment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget`.`investment` (
  `id_investment` BINARY(16) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `value` DECIMAL(10,2) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id_investment`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budget`.`income_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget`.`income_category` (
  `id_income_category` BINARY(16) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_income_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budget`.`income`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget`.`income` (
  `id_income` BINARY(16) NOT NULL,
  `value` DECIMAL(10,2) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `id_income_category` BINARY(16) NOT NULL,
  PRIMARY KEY (`id_income`),
  INDEX `fk_id_income_category_6878923_idx` (`id_income_category` ASC) VISIBLE,
  CONSTRAINT `fk_id_income_category_6878923`
    FOREIGN KEY (`id_income_category`)
    REFERENCES `budget`.`income_category` (`id_income_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;