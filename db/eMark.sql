-- MySQL Script generated by MySQL Workbench
-- 11/19/16 16:36:17
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema eMark
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eMark
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eMark` DEFAULT CHARACTER SET utf8 ;
USE `eMark` ;

-- -----------------------------------------------------
-- Table `eMark`.`Promocao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Promocao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NULL,
  `DataInicio` DATE NULL,
  `DataFinal` DATE NULL,
  `Porcentagem` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Empresa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `RazaoSocial` VARCHAR(45) NULL,
  `CNPJ` INT UNSIGNED NULL,
  `DataContratacao` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NULL,
  `Margem` VARCHAR(45) NULL,
  `NCM` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `ValorUnitario` DECIMAL NULL,
  `DataVencimento` VARCHAR(45) NULL,
  `Promocao_id` INT NOT NULL,
  `Empresa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Produtos_Promocao1_idx` (`Promocao_id` ASC),
  INDEX `fk_Produtos_Empresa1_idx` (`Empresa_id` ASC),
  CONSTRAINT `fk_Produtos_Promocao1`
    FOREIGN KEY (`Promocao_id`)
    REFERENCES `eMark`.`Promocao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `eMark`.`Empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `CPF/CPNJ` INT UNSIGNED NULL,
  `Nome` VARCHAR(45) NULL,
  `Empresa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pessoa_Empresa1_idx` (`Empresa_id` ASC),
  CONSTRAINT `fk_Pessoa_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `eMark`.`Empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Fornecedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Status` VARCHAR(1) NULL,
  `Responsavel` VARCHAR(45) NULL,
  `IE` INT UNSIGNED NULL,
  `IM` VARCHAR(15) NULL,
  `Representante` VARCHAR(45) NULL,
  `Pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Fornecedor_Pessoa1_idx` (`Pessoa_id` ASC),
  CONSTRAINT `fk_Fornecedor_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `eMark`.`Pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Cargo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Salario` DECIMAL NULL,
  `Comissao` INT NULL,
  `DataAdmissao` DATE NULL,
  `DataDemissao` DATE NULL,
  `Cargo_id` INT NOT NULL,
  `Pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Funcionario_Cargo1_idx` (`Cargo_id` ASC),
  INDEX `fk_Funcionario_Pessoa1_idx` (`Pessoa_id` ASC),
  CONSTRAINT `fk_Funcionario_Cargo1`
    FOREIGN KEY (`Cargo_id`)
    REFERENCES `eMark`.`Cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `eMark`.`Pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Login` INT UNSIGNED NULL,
  `Senha` VARCHAR(45) NULL,
  `Status` VARCHAR(4) NULL,
  `TokenSession` VARCHAR(45) NULL,
  `Funcionario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Funcionario1_idx` (`Funcionario_id` ASC),
  CONSTRAINT `fk_Usuario_Funcionario1`
    FOREIGN KEY (`Funcionario_id`)
    REFERENCES `eMark`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Vendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `DataDaVenda` DATE NULL,
  `ValorTotal` DECIMAL NULL,
  `Empresa_id` INT NOT NULL,
  `Usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vendas_Empresa1_idx` (`Empresa_id` ASC),
  INDEX `fk_Vendas_Usuario1_idx` (`Usuario_id` ASC),
  CONSTRAINT `fk_Vendas_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `eMark`.`Empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `eMark`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`TerminaldeVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`TerminaldeVenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `NumeroDaMaquina` INT NULL,
  `Token` VARCHAR(70) NULL,
  `Empresa_id` INT NOT NULL,
  `Usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_TerminaldeVenda_Empresa1_idx` (`Empresa_id` ASC),
  INDEX `fk_TerminaldeVenda_Usuario1_idx` (`Usuario_id` ASC),
  CONSTRAINT `fk_TerminaldeVenda_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `eMark`.`Empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TerminaldeVenda_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `eMark`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`FinanceiroCaixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`FinanceiroCaixa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ValorInicial` DECIMAL NULL,
  `ValorFinal` DECIMAL NULL,
  `DataAbertura` DATE NULL,
  `DataFechamento` DATE NULL,
  `Sangria` DECIMAL NULL,
  `Suprimentos` DECIMAL NULL,
  `Descicao` VARCHAR(45) NULL,
  `TerminaldeVenda_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_FinanceiroCaixa_TerminaldeVenda1_idx` (`TerminaldeVenda_id` ASC),
  CONSTRAINT `fk_FinanceiroCaixa_TerminaldeVenda1`
    FOREIGN KEY (`TerminaldeVenda_id`)
    REFERENCES `eMark`.`TerminaldeVenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Itens_Vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Itens_Vendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Quantidade` VARCHAR(45) NULL,
  `ValorDaVenda` INT NULL,
  `Vendas_id` INT NOT NULL,
  `FinanceiroCaixa_id` INT NOT NULL,
  `Produtos_id` INT NOT NULL,
  `Status` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Itens_Vendas_Vendas1_idx` (`Vendas_id` ASC),
  INDEX `fk_Itens_Vendas_FinanceiroCaixa1_idx` (`FinanceiroCaixa_id` ASC),
  INDEX `fk_Itens_Vendas_Produtos1_idx` (`Produtos_id` ASC),
  CONSTRAINT `fk_Itens_Vendas_Vendas1`
    FOREIGN KEY (`Vendas_id`)
    REFERENCES `eMark`.`Vendas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Vendas_FinanceiroCaixa1`
    FOREIGN KEY (`FinanceiroCaixa_id`)
    REFERENCES `eMark`.`FinanceiroCaixa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Vendas_Produtos1`
    FOREIGN KEY (`Produtos_id`)
    REFERENCES `eMark`.`Produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`MovimentacaoFinanceira`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`MovimentacaoFinanceira` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Realizado` DECIMAL NULL,
  `AReceber` DECIMAL NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`TipoPagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`TipoPagamento` (
  `id` INT NOT NULL,
  `Descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`FormasDePagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`FormasDePagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `TipoPagamento` VARCHAR(45) NULL,
  `TipoPagamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_FormasDePagamento_TipoPagamento1_idx` (`TipoPagamento_id` ASC),
  CONSTRAINT `fk_FormasDePagamento_TipoPagamento1`
    FOREIGN KEY (`TipoPagamento_id`)
    REFERENCES `eMark`.`TipoPagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Financeiro_Entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Financeiro_Entrada` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `DataVencimento` DATE NULL,
  `Valor` DECIMAL NULL,
  `StatusEntrada` VARCHAR(45) NULL,
  `NumeroParcela` INT NULL,
  `DataBaixa` DATE NULL,
  `MovimentacaoFinanceira_id` INT NOT NULL,
  `FormasDePagamento_id` INT NOT NULL,
  `Vendas_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Financeiro_Entrada_MovimentacaoFinanceira1_idx` (`MovimentacaoFinanceira_id` ASC),
  INDEX `fk_Financeiro_Entrada_FormasDePagamento1_idx` (`FormasDePagamento_id` ASC),
  INDEX `fk_Financeiro_Entrada_Vendas1_idx` (`Vendas_id` ASC),
  UNIQUE INDEX `MovimentacaoFinanceira_id_UNIQUE` (`MovimentacaoFinanceira_id` ASC),
  UNIQUE INDEX `FormasDePagamento_id_UNIQUE` (`FormasDePagamento_id` ASC),
  UNIQUE INDEX `Vendas_id_UNIQUE` (`Vendas_id` ASC),
  CONSTRAINT `fk_Financeiro_Entrada_MovimentacaoFinanceira1`
    FOREIGN KEY (`MovimentacaoFinanceira_id`)
    REFERENCES `eMark`.`MovimentacaoFinanceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Entrada_FormasDePagamento1`
    FOREIGN KEY (`FormasDePagamento_id`)
    REFERENCES `eMark`.`FormasDePagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Entrada_Vendas1`
    FOREIGN KEY (`Vendas_id`)
    REFERENCES `eMark`.`Vendas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Compras` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Data` DATE NULL,
  `ValorTotal` VARCHAR(45) NULL,
  `Caixa` VARCHAR(45) NULL,
  `Empresa_id` INT NOT NULL,
  `Usuario_id` INT NOT NULL,
  `Fornecedor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Compras_Empresa1_idx` (`Empresa_id` ASC),
  INDEX `fk_Compras_Usuario1_idx` (`Usuario_id` ASC),
  INDEX `fk_Compras_Fornecedor1_idx` (`Fornecedor_id` ASC),
  CONSTRAINT `fk_Compras_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `eMark`.`Empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `eMark`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_Fornecedor1`
    FOREIGN KEY (`Fornecedor_id`)
    REFERENCES `eMark`.`Fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Itens_Compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Itens_Compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Quantidade` DECIMAL NULL,
  `ValorCompra` DECIMAL NULL,
  `DataCompra` VARCHAR(45) NULL,
  `Compras_id` INT NOT NULL,
  `Produtos_id` INT NOT NULL,
  `Status` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Itens_Compra_Compras1_idx` (`Compras_id` ASC),
  INDEX `fk_Itens_Compra_Produtos1_idx` (`Produtos_id` ASC),
  CONSTRAINT `fk_Itens_Compra_Compras1`
    FOREIGN KEY (`Compras_id`)
    REFERENCES `eMark`.`Compras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Compra_Produtos1`
    FOREIGN KEY (`Produtos_id`)
    REFERENCES `eMark`.`Produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Financeiro_Saidas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Financeiro_Saidas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `DataVencimento` DATE NULL,
  `Databaixa` DATE NULL,
  `DataEmissao` DATE NULL,
  `Valor` INT NULL,
  `Status` VARCHAR(2) NULL,
  `MovimentacaoFinanceira_id` INT NOT NULL,
  `Compras_id` INT NOT NULL,
  `FormasDePagamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Financeiro_Saidas_MovimentacaoFinanceira1_idx` (`MovimentacaoFinanceira_id` ASC),
  INDEX `fk_Financeiro_Saidas_Compras1_idx` (`Compras_id` ASC),
  UNIQUE INDEX `MovimentacaoFinanceira_id_UNIQUE` (`MovimentacaoFinanceira_id` ASC),
  INDEX `fk_Financeiro_Saidas_FormasDePagamento1_idx` (`FormasDePagamento_id` ASC),
  CONSTRAINT `fk_Financeiro_Saidas_MovimentacaoFinanceira1`
    FOREIGN KEY (`MovimentacaoFinanceira_id`)
    REFERENCES `eMark`.`MovimentacaoFinanceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Saidas_Compras1`
    FOREIGN KEY (`Compras_id`)
    REFERENCES `eMark`.`Compras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Saidas_FormasDePagamento1`
    FOREIGN KEY (`FormasDePagamento_id`)
    REFERENCES `eMark`.`FormasDePagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NULL,
  `Pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Endereco_Pessoa1_idx` (`Pessoa_id` ASC),
  CONSTRAINT `fk_Endereco_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `eMark`.`Pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Contatos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Contatos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Telefone` VARCHAR(45) NULL,
  `Pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Contatos_Pessoa1_idx` (`Pessoa_id` ASC),
  CONSTRAINT `fk_Contatos_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `eMark`.`Pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`FormasDePagamento_has_Vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`FormasDePagamento_has_Vendas` (
  `FormasDePagamento_idFormasDePagamento` INT NOT NULL,
  `Vendas_idVendas` INT NOT NULL,
  INDEX `fk_FormasDePagamento_has_Vendas_Vendas1_idx` (`Vendas_idVendas` ASC),
  INDEX `fk_FormasDePagamento_has_Vendas_FormasDePagamento1_idx` (`FormasDePagamento_idFormasDePagamento` ASC),
  UNIQUE INDEX `Vendas_idVendas_UNIQUE` (`Vendas_idVendas` ASC),
  UNIQUE INDEX `FormasDePagamento_idFormasDePagamento_UNIQUE` (`FormasDePagamento_idFormasDePagamento` ASC),
  PRIMARY KEY (`FormasDePagamento_idFormasDePagamento`, `Vendas_idVendas`),
  CONSTRAINT `fk_FormasDePagamento_has_Vendas_FormasDePagamento1`
    FOREIGN KEY (`FormasDePagamento_idFormasDePagamento`)
    REFERENCES `eMark`.`FormasDePagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FormasDePagamento_has_Vendas_Vendas1`
    FOREIGN KEY (`Vendas_idVendas`)
    REFERENCES `eMark`.`Vendas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Permissao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NULL,
  `Modulo/URL` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eMark`.`Cargo_has_Permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eMark`.`Cargo_has_Permissao` (
  `Cargo_id` INT NOT NULL,
  `Permissao_id` INT NOT NULL,
  INDEX `fk_Cargo_has_Permissao_Permissao1_idx` (`Permissao_id` ASC),
  INDEX `fk_Cargo_has_Permissao_Cargo1_idx` (`Cargo_id` ASC),
  UNIQUE INDEX `Cargo_id_UNIQUE` (`Cargo_id` ASC),
  UNIQUE INDEX `Permissao_id_UNIQUE` (`Permissao_id` ASC),
  PRIMARY KEY (`Cargo_id`, `Permissao_id`),
  CONSTRAINT `fk_Cargo_has_Permissao_Cargo1`
    FOREIGN KEY (`Cargo_id`)
    REFERENCES `eMark`.`Cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cargo_has_Permissao_Permissao1`
    FOREIGN KEY (`Permissao_id`)
    REFERENCES `eMark`.`Permissao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
