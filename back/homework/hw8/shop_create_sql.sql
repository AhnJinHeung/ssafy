-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shop` DEFAULT CHARACTER SET utf8 ;
USE `shop` ;

-- -----------------------------------------------------
-- Table `shop`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`member` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(10) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(15) NOT NULL,
  `subPhone` VARCHAR(15) NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`order` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `orderDate` DATE NOT NULL,
  `paymentStatus` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`orderId`),
  INDEX `order_userId_fk_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `order_userId_fk`
    FOREIGN KEY (`userId`)
    REFERENCES `shop`.`member` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`order_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`order_detail` (
  `orderId` INT NOT NULL,
  `productCode` INT NOT NULL,
  `cnt` INT NOT NULL,
  PRIMARY KEY (`productCode`, `orderId`),
  CONSTRAINT `order_detail_orderId_fk`
    FOREIGN KEY (`orderId`)
    REFERENCES `shop`.`order` (`orderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`product` (
  `productCode` INT NOT NULL,
  `productName` VARCHAR(20) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`productCode`),
  CONSTRAINT `product_productCode_fk`
    FOREIGN KEY (`productCode`)
    REFERENCES `shop`.`order_detail` (`productCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`delivery` (
  `orderId` INT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `deliveryStatus` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`orderId`),
  CONSTRAINT `delivery_orderId_fk`
    FOREIGN KEY (`orderId`)
    REFERENCES `shop`.`order` (`orderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
