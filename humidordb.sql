-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema humidordb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `humidordb` ;

-- -----------------------------------------------------
-- Schema humidordb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `humidordb` DEFAULT CHARACTER SET utf8 ;
USE `humidordb` ;

-- -----------------------------------------------------
-- Table `wrapper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wrapper` ;

CREATE TABLE IF NOT EXISTS `wrapper` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(225) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shape`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shape` ;

CREATE TABLE IF NOT EXISTS `shape` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `shape` VARCHAR(225) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cigar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cigar` ;

CREATE TABLE IF NOT EXISTS `cigar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `amount` VARCHAR(45) NULL DEFAULT 0,
  `wrapper_id` INT NULL,
  `shape_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cigar_wrapper_idx` (`wrapper_id` ASC),
  INDEX `fk_cigar_shape_idx` (`shape_id` ASC),
  CONSTRAINT `fk_cigar_wrapper`
    FOREIGN KEY (`wrapper_id`)
    REFERENCES `wrapper` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cigar_shape`
    FOREIGN KEY (`shape_id`)
    REFERENCES `shape` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO smoker;
 DROP USER smoker;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'smoker' IDENTIFIED BY 'smoker';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'smoker';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `wrapper`
-- -----------------------------------------------------
START TRANSACTION;
USE `humidordb`;
INSERT INTO `wrapper` (`id`, `name`) VALUES (1, 'Maduro');

COMMIT;


-- -----------------------------------------------------
-- Data for table `shape`
-- -----------------------------------------------------
START TRANSACTION;
USE `humidordb`;
INSERT INTO `shape` (`id`, `shape`) VALUES (1, 'Churchill');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cigar`
-- -----------------------------------------------------
START TRANSACTION;
USE `humidordb`;
INSERT INTO `cigar` (`id`, `brand`, `name`, `amount`, `wrapper_id`, `shape_id`) VALUES (1, 'Rose', 'Dark Choclate', '2', 1, 1);

COMMIT;
