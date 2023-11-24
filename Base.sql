-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema trabajo_practico
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trabajo_practico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trabajo_practico` DEFAULT CHARACTER SET utf8 ;
USE `trabajo_practico` ;

-- -----------------------------------------------------
-- Table `trabajo_practico`.`HelpDesk`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`HelpDesk` (
  `idHelpDesk` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idHelpDesk`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trabajo_practico`.`Tecnico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`Tecnico` (
  `idTecnico` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `notificacion` ENUM('mail', 'whatsapp') NULL,
  PRIMARY KEY (`idTecnico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trabajo_practico`.`Tipo_de_Problema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`Tipo_de_Problema` (
  `idTipo` INT NOT NULL AUTO_INCREMENT,
  `tiempoMaximo` INT NULL,
  `tiempoEstResolucion` INT NULL,
  `descProblema` VARCHAR(45) NULL,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trabajo_practico`.`Incidentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`Incidentes` (
  `idIncidente` INT NOT NULL AUTO_INCREMENT,
  `estado` ENUM('abierto', 'asignado', 'resuelto') NULL,
  `tiempoEstResol` VARCHAR(45) NULL,
  `notaCierre` VARCHAR(45) NULL,
  `fechaApertura` DATETIME NULL,
  `esComplejo` TINYINT NULL,
  `fechaResolucion` DATETIME NULL,
  `descripcion` LONGTEXT NULL,
  `titulo` VARCHAR(45) NULL,
  `Help Desk_idHelpDesk` INT NOT NULL,
  `Tecnico_idTecnico` INT NOT NULL,
  `Tipo de Problema_idTipo` INT NOT NULL,
  PRIMARY KEY (`idIncidente`, `Help Desk_idHelpDesk`, `Tecnico_idTecnico`, `Tipo de Problema_idTipo`),
  INDEX `fk_Incidentes_Help Desk1_idx` (`Help Desk_idHelpDesk` ASC) VISIBLE,
  INDEX `fk_Incidentes_Tecnico1_idx` (`Tecnico_idTecnico` ASC) VISIBLE,
  INDEX `fk_Incidentes_Tipo de Problema1_idx` (`Tipo de Problema_idTipo` ASC) VISIBLE,
  CONSTRAINT `fk_Incidentes_Help Desk1`
    FOREIGN KEY (`Help Desk_idHelpDesk`)
    REFERENCES `trabajo_practico`.`HelpDesk` (`idHelpDesk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Incidentes_Tecnico1`
    FOREIGN KEY (`Tecnico_idTecnico`)
    REFERENCES `trabajo_practico`.`Tecnico` (`idTecnico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Incidentes_Tipo de Problema1`
    FOREIGN KEY (`Tipo de Problema_idTipo`)
    REFERENCES `trabajo_practico`.`Tipo_de_Problema` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trabajo_practico`.`Servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`Servicios` (
  `idServicio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` LONGTEXT NULL,
  `Incidentes_idIncidentes` INT NOT NULL,
  PRIMARY KEY (`idServicio`, `Incidentes_idIncidentes`),
  INDEX `fk_Servicios_Incidentes1_idx` (`Incidentes_idIncidentes` ASC) VISIBLE,
  CONSTRAINT `fk_Servicios_Incidentes1`
    FOREIGN KEY (`Incidentes_idIncidentes`)
    REFERENCES `trabajo_practico`.`Incidentes` (`idIncidente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trabajo_practico`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`Clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `cuit` INT NULL,
  `razonsocial` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `Servicios_idServicios1` INT NOT NULL,
  PRIMARY KEY (`idCliente`, `Servicios_idServicios1`),
  INDEX `fk_Clientes_Servicios1_idx` (`Servicios_idServicios1` ASC) VISIBLE,
  CONSTRAINT `fk_Clientes_Servicios1`
    FOREIGN KEY (`Servicios_idServicios1`)
    REFERENCES `trabajo_practico`.`Servicios` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trabajo_practico`.`Especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`Especialidad` (
  `idEspecialidad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idEspecialidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trabajo_practico`.`Tecnico_has_Especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`Tecnico_has_Especialidad` (
  `Tecnico_idTecnico` INT NOT NULL,
  `Especialidad_idEspecialidad` INT NOT NULL,
  PRIMARY KEY (`Tecnico_idTecnico`, `Especialidad_idEspecialidad`),
  INDEX `fk_Tecnico_has_Especialidad_Especialidad1_idx` (`Especialidad_idEspecialidad` ASC) VISIBLE,
  INDEX `fk_Tecnico_has_Especialidad_Tecnico1_idx` (`Tecnico_idTecnico` ASC) VISIBLE,
  CONSTRAINT `fk_Tecnico_has_Especialidad_Tecnico1`
    FOREIGN KEY (`Tecnico_idTecnico`)
    REFERENCES `trabajo_practico`.`Tecnico` (`idTecnico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tecnico_has_Especialidad_Especialidad1`
    FOREIGN KEY (`Especialidad_idEspecialidad`)
    REFERENCES `trabajo_practico`.`Especialidad` (`idEspecialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trabajo_practico`.`Tipo de Problema_has_Especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trabajo_practico`.`Tipo de Problema_has_Especialidad` (
  `Tipo de Problema_idTipo` INT NOT NULL,
  `Especialidad_idEspecialidad` INT NOT NULL,
  PRIMARY KEY (`Tipo de Problema_idTipo`, `Especialidad_idEspecialidad`),
  INDEX `fk_Tipo de Problema_has_Especialidad_Especialidad1_idx` (`Especialidad_idEspecialidad` ASC) VISIBLE,
  INDEX `fk_Tipo de Problema_has_Especialidad_Tipo de Problema1_idx` (`Tipo de Problema_idTipo` ASC) VISIBLE,
  CONSTRAINT `fk_Tipo de Problema_has_Especialidad_Tipo de Problema1`
    FOREIGN KEY (`Tipo de Problema_idTipo`)
    REFERENCES `trabajo_practico`.`Tipo_de_Problema` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tipo de Problema_has_Especialidad_Especialidad1`
    FOREIGN KEY (`Especialidad_idEspecialidad`)
    REFERENCES `trabajo_practico`.`Especialidad` (`idEspecialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
