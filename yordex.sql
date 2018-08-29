-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema yordex
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `yordex` ;

-- -----------------------------------------------------
-- Schema yordex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `yordex` DEFAULT CHARACTER SET utf8 ;
USE `yordex` ;

-- -----------------------------------------------------
-- Table `yordex`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yordex`.`user` ;

CREATE TABLE IF NOT EXISTS `yordex`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(1000) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO yordexuser@localhost;
 DROP USER yordexuser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'yordexuser'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT ON TABLE `yordex`.* TO 'yordexuser'@'localhost';
GRANT SELECT, INSERT, TRIGGER ON TABLE `yordex`.* TO 'yordexuser'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `yordex`.* TO 'yordexuser'@'localhost';

-- -----------------------------------------------------
-- Data for table `yordex`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `yordex`;
INSERT INTO `yordex`.`user` (`id`, `email`, `password`, `first_name`, `last_name`) VALUES (1, 'bobsmith@gmail.com', 'password', 'Bob', 'Smith');
INSERT INTO `yordex`.`user` (`id`, `email`, `password`, `first_name`, `last_name`) VALUES (2, 'adamjones@gmail.com', 'password', 'Adam', 'Jones');

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
