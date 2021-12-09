-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Ketzal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Ketzal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Ketzal` DEFAULT CHARACTER SET utf8 ;
USE `Ketzal` ;

-- -----------------------------------------------------
-- Table `Ketzal`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ketzal`.`productos` ;

CREATE TABLE IF NOT EXISTS `Ketzal`.`productos` (
  `idproductos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `imagen` VARCHAR(200) NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `precio` DECIMAL(10,0) NOT NULL,
  `gramaje` DECIMAL(10,0) NULL,
  PRIMARY KEY (`idproductos`),
  UNIQUE INDEX `idProductos_UNIQUE` (`idproductos` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ketzal`.`contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ketzal`.`contacto` ;

CREATE TABLE IF NOT EXISTS `Ketzal`.`contacto` (
  `idcontacto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(150) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idcontacto`),
  UNIQUE INDEX `idContacto_UNIQUE` (`idcontacto` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ketzal`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ketzal`.`clientes` ;

CREATE TABLE IF NOT EXISTS `Ketzal`.`clientes` (
  `idcontacto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(150) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `contrasena` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idcontacto`),
  UNIQUE INDEX `idContacto_UNIQUE` (`idcontacto` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ketzal`.`administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ketzal`.`administrador` ;

CREATE TABLE IF NOT EXISTS `Ketzal`.`administrador` (
  `idadministrador` INT NOT NULL,
  `correo` VARCHAR(150) NULL,
  `contrasena` VARCHAR(20) NULL,
  PRIMARY KEY (`idadministrador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ketzal`.`compras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ketzal`.`compras` ;

CREATE TABLE IF NOT EXISTS `Ketzal`.`compras` (
  `idcompra` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `clientes_idcontacto` INT NOT NULL,
  PRIMARY KEY (`idcompra`, `clientes_idcontacto`),
  INDEX `fk_Compras_Clientes_idx` (`clientes_idcontacto` ASC) VISIBLE,
  CONSTRAINT `fk_Compras_Clientes`
    FOREIGN KEY (`clientes_idcontacto`)
    REFERENCES `Ketzal`.`clientes` (`idcontacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ketzal`.`detalleCompra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ketzal`.`detalleCompra` ;

CREATE TABLE IF NOT EXISTS `Ketzal`.`detalleCompra` (
  `iddetallescompra` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `direccion` VARCHAR(300) NOT NULL,
  `total` FLOAT NOT NULL,
  `compras_idcompra` INT NOT NULL,
  `compras_clientes_idcontacto` INT NOT NULL,
  `productos_idproductos` INT NOT NULL,
  PRIMARY KEY (`iddetallescompra`, `compras_idcompra`, `compras_clientes_idcontacto`, `productos_idproductos`),
  UNIQUE INDEX `idDetallesCompra_UNIQUE` (`iddetallescompra` ASC) VISIBLE,
  INDEX `fk_DetalleCompra_Compras1_idx` (`compras_idcompra` ASC, `compras_clientes_idcontacto` ASC) VISIBLE,
  INDEX `fk_DetalleCompra_Productos1_idx` (`productos_idproductos` ASC) VISIBLE,
  CONSTRAINT `fk_DetalleCompra_Compras1`
    FOREIGN KEY (`compras_idcompra` , `compras_clientes_idcontacto`)
    REFERENCES `Ketzal`.`compras` (`idcompra` , `clientes_idcontacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleCompra_Productos1`
    FOREIGN KEY (`productos_idproductos`)
    REFERENCES `Ketzal`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
