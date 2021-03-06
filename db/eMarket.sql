-- MySQL Script generated by MySQL Workbench
-- Sáb 10 Dez 2016 21:44:14 BRST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema eMarket
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eMarket
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eMarket` DEFAULT CHARACTER SET utf8 ;
USE `eMarket` ;

-- -----------------------------------------------------
-- Table `status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `RazaoSocial` VARCHAR(45) NOT NULL,
  `CNPJ` VARCHAR(21) NOT NULL,
  `DataContratacao` DATE NOT NULL,
  `DataCancelamentoContrato` DATE NULL,
  `status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_empresa_status1_idx` (`status_id` ASC),
  CONSTRAINT `fk_empresa_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `promocao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `promocao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  `DataInicio` DATE NOT NULL,
  `DataFinal` DATE NOT NULL,
  `Porcentagem` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `produto` (
  `id` INT NOT NULL,
  `Descricao` VARCHAR(45) NOT NULL,
  `Margem` VARCHAR(45) NOT NULL,
  `NCM` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `ValorUnitario` DECIMAL(10,2) NOT NULL,
  `DataVencimento` DATE NOT NULL,
  `QuantidadeAtual` DOUBLE NOT NULL,
  `CodBarras` INT NOT NULL,
  `Empresa_id` INT NOT NULL,
  `Promocao_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Produtos_Empresa1_idx` (`Empresa_id` ASC),
  INDEX `fk_Produtos_Promocao1_idx` (`Promocao_id` ASC),
  CONSTRAINT `fk_Produtos_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_Promocao1`
    FOREIGN KEY (`Promocao_id`)
    REFERENCES `promocao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf_cnpj` VARCHAR(21) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Responsavel` VARCHAR(45) NULL,
  `IE` INT UNSIGNED NULL,
  `IM` VARCHAR(15) NULL,
  `Representante` VARCHAR(45) NULL,
  `Pessoa_id` INT NOT NULL,
  `Status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Fornecedor_Pessoa1_idx` (`Pessoa_id` ASC),
  INDEX `fk_Fornecedor_Status1_idx` (`Status_id` ASC),
  CONSTRAINT `fk_Fornecedor_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fornecedor_Status1`
    FOREIGN KEY (`Status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cargo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Salario` DECIMAL(10,3) NOT NULL,
  `Comissao` INT NOT NULL,
  `DataAdmissao` DATE NOT NULL,
  `DataDemissao` DATE NOT NULL,
  `Cargo_id` INT NOT NULL,
  `Pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Funcionario_Cargo1_idx` (`Cargo_id` ASC),
  INDEX `fk_Funcionario_Pessoa1_idx` (`Pessoa_id` ASC),
  CONSTRAINT `fk_Funcionario_Cargo1`
    FOREIGN KEY (`Cargo_id`)
    REFERENCES `cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(30) NOT NULL,
  `Senha` VARCHAR(45) NOT NULL,
  `Funcionario_id` INT NOT NULL,
  `Status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Funcionario1_idx` (`Funcionario_id` ASC),
  INDEX `fk_Usuario_Status1_idx` (`Status_id` ASC),
  CONSTRAINT `fk_Usuario_Funcionario1`
    FOREIGN KEY (`Funcionario_id`)
    REFERENCES `funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Status1`
    FOREIGN KEY (`Status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `DataDaVenda` DATETIME NOT NULL,
  `ValorTotal` DECIMAL(10,3) NULL,
  `Empresa_id` INT NOT NULL,
  `Usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vendas_Empresa1_idx` (`Empresa_id` ASC),
  INDEX `fk_Vendas_Usuario1_idx` (`Usuario_id` ASC),
  CONSTRAINT `fk_Vendas_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalvenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `terminalvenda` (
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
    REFERENCES `empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TerminaldeVenda_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `financeiro_caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `financeiro_caixa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ValorInicial` DECIMAL(65,5) NOT NULL,
  `ValorFinal` DECIMAL(65,5) NULL,
  `DataAbertura` DATETIME NOT NULL,
  `DataFechamento` DATETIME NULL,
  `Sangria` DECIMAL(10,2) NULL,
  `Suprimentos` DECIMAL(10,2) NULL,
  `Descricao` VARCHAR(45) NOT NULL,
  `TerminaldeVenda_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_FinanceiroCaixa_TerminaldeVenda1_idx` (`TerminaldeVenda_id` ASC),
  CONSTRAINT `fk_FinanceiroCaixa_TerminaldeVenda1`
    FOREIGN KEY (`TerminaldeVenda_id`)
    REFERENCES `terminalvenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `item_venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Quantidade` DOUBLE NOT NULL,
  `ValorDaVenda` DECIMAL(10,3) NOT NULL,
  `Vendas_id` INT NOT NULL,
  `FinanceiroCaixa_id` INT NOT NULL,
  `Produtos_id` INT NOT NULL,
  `Status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Itens_Vendas_Vendas1_idx` (`Vendas_id` ASC),
  INDEX `fk_Itens_Vendas_FinanceiroCaixa1_idx` (`FinanceiroCaixa_id` ASC),
  INDEX `fk_Itens_Vendas_Produtos1_idx` (`Produtos_id` ASC),
  INDEX `fk_Itens_Vendas_Status1_idx` (`Status_id` ASC),
  CONSTRAINT `fk_Itens_Vendas_Vendas1`
    FOREIGN KEY (`Vendas_id`)
    REFERENCES `venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Vendas_FinanceiroCaixa1`
    FOREIGN KEY (`FinanceiroCaixa_id`)
    REFERENCES `financeiro_caixa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Vendas_Produtos1`
    FOREIGN KEY (`Produtos_id`)
    REFERENCES `produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Vendas_Status1`
    FOREIGN KEY (`Status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movimentacao_financeira`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movimentacao_financeira` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Realizado` DECIMAL(65,5) NOT NULL,
  `AReceber` DECIMAL(65,5) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tipopagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tipopagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `formapagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `formapagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `MaxParcela` INT NOT NULL,
  `TipoPagamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_FormasDePagamento_TipoPagamento1_idx` (`TipoPagamento_id` ASC),
  CONSTRAINT `fk_FormasDePagamento_TipoPagamento1`
    FOREIGN KEY (`TipoPagamento_id`)
    REFERENCES `tipopagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `financeiro_entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `financeiro_entrada` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `DataVencimento` DATE NOT NULL,
  `Valor` DECIMAL(10,3) NOT NULL,
  `NumeroParcela` INT NOT NULL,
  `DataBaixa` DATETIME NULL,
  `MovimentacaoFinanceira_id` INT NOT NULL,
  `FormasDePagamento_id` INT NOT NULL,
  `Vendas_id` INT NOT NULL,
  `Status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Financeiro_Entrada_MovimentacaoFinanceira1_idx` (`MovimentacaoFinanceira_id` ASC),
  INDEX `fk_Financeiro_Entrada_FormasDePagamento1_idx` (`FormasDePagamento_id` ASC),
  INDEX `fk_Financeiro_Entrada_Vendas1_idx` (`Vendas_id` ASC),
  INDEX `fk_Financeiro_Entrada_Status1_idx` (`Status_id` ASC),
  CONSTRAINT `fk_Financeiro_Entrada_MovimentacaoFinanceira1`
    FOREIGN KEY (`MovimentacaoFinanceira_id`)
    REFERENCES `movimentacao_financeira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Entrada_FormasDePagamento1`
    FOREIGN KEY (`FormasDePagamento_id`)
    REFERENCES `formapagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Entrada_Vendas1`
    FOREIGN KEY (`Vendas_id`)
    REFERENCES `venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Entrada_Status1`
    FOREIGN KEY (`Status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `DataCompra` DATETIME NOT NULL,
  `ValorTotal` DECIMAL(10,3) NOT NULL,
  `Empresa_id` INT NOT NULL,
  `Usuario_id` INT NOT NULL,
  `Fornecedor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Compras_Empresa1_idx` (`Empresa_id` ASC),
  INDEX `fk_Compras_Usuario1_idx` (`Usuario_id` ASC),
  INDEX `fk_Compras_Fornecedor1_idx` (`Fornecedor_id` ASC),
  CONSTRAINT `fk_Compras_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_Fornecedor1`
    FOREIGN KEY (`Fornecedor_id`)
    REFERENCES `fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `item_compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Quantidade` DOUBLE NOT NULL,
  `ValorCompra` DECIMAL(10,3) NOT NULL,
  `DataCompra` DATETIME NOT NULL,
  `Compras_id` INT NOT NULL,
  `Produtos_id` INT NOT NULL,
  `Status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Itens_Compra_Compras1_idx` (`Compras_id` ASC),
  INDEX `fk_Itens_Compra_Produtos1_idx` (`Produtos_id` ASC),
  INDEX `fk_Itens_Compra_Status1_idx` (`Status_id` ASC),
  CONSTRAINT `fk_Itens_Compra_Compras1`
    FOREIGN KEY (`Compras_id`)
    REFERENCES `compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Compra_Produtos1`
    FOREIGN KEY (`Produtos_id`)
    REFERENCES `produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Compra_Status1`
    FOREIGN KEY (`Status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `financeiro_saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `financeiro_saida` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `DataVencimento` DATE NOT NULL,
  `Databaixa` DATETIME NOT NULL,
  `DataEmissao` DATETIME NOT NULL,
  `Valor` DECIMAL(10,3) NOT NULL,
  `MovimentacaoFinanceira_id` INT NOT NULL,
  `Compras_id` INT NOT NULL,
  `FormasDePagamento_id` INT NOT NULL,
  `Status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Financeiro_Saidas_MovimentacaoFinanceira1_idx` (`MovimentacaoFinanceira_id` ASC),
  INDEX `fk_Financeiro_Saidas_Compras1_idx` (`Compras_id` ASC),
  INDEX `fk_Financeiro_Saidas_FormasDePagamento1_idx` (`FormasDePagamento_id` ASC),
  INDEX `fk_Financeiro_Saidas_Status1_idx` (`Status_id` ASC),
  CONSTRAINT `fk_Financeiro_Saidas_MovimentacaoFinanceira1`
    FOREIGN KEY (`MovimentacaoFinanceira_id`)
    REFERENCES `movimentacao_financeira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Saidas_Compras1`
    FOREIGN KEY (`Compras_id`)
    REFERENCES `compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Saidas_FormasDePagamento1`
    FOREIGN KEY (`FormasDePagamento_id`)
    REFERENCES `formapagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Saidas_Status1`
    FOREIGN KEY (`Status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Logradouro` VARCHAR(30) NOT NULL,
  `Bairro` VARCHAR(30) NOT NULL,
  `Cidade` VARCHAR(20) NOT NULL,
  `Estado` VARCHAR(20) NOT NULL,
  `Pais` VARCHAR(15) NOT NULL,
  `Cep` VARCHAR(20) NOT NULL,
  `Pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Endereco_Pessoa1_idx` (`Pessoa_id` ASC),
  CONSTRAINT `fk_Endereco_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contato` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Telefone` VARCHAR(25) NOT NULL,
  `Pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Contatos_Pessoa1_idx` (`Pessoa_id` ASC),
  CONSTRAINT `fk_Contatos_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `permissao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  `Modulo_URL` VARCHAR(45) NOT NULL,
  `Icon` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `permissao_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `permissao_cargo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Cargo_id` INT NOT NULL,
  `Permissao_id` INT NOT NULL,
  INDEX `fk_Cargo_has_Permissao_Permissao1_idx` (`Permissao_id` ASC),
  INDEX `fk_Cargo_has_Permissao_Cargo1_idx` (`Cargo_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Cargo_has_Permissao_Cargo1`
    FOREIGN KEY (`Cargo_id`)
    REFERENCES `cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cargo_has_Permissao_Permissao1`
    FOREIGN KEY (`Permissao_id`)
    REFERENCES `permissao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pessoa_empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pessoa_empresa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Pessoa_id` INT NOT NULL,
  `Empresa_id` INT NOT NULL,
  INDEX `fk_Pessoa_has_Empresa_Empresa1_idx` (`Empresa_id` ASC),
  INDEX `fk_Pessoa_has_Empresa_Pessoa1_idx` (`Pessoa_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Pessoa_has_Empresa_Pessoa1`
    FOREIGN KEY (`Pessoa_id`)
    REFERENCES `pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoa_has_Empresa_Empresa1`
    FOREIGN KEY (`Empresa_id`)
    REFERENCES `empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `compra_formaspagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compra_formaspagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Compras_id` INT NOT NULL,
  `FormasDePagamento_id` INT NOT NULL,
  INDEX `fk_Compras_has_FormasDePagamento_FormasDePagamento1_idx` (`FormasDePagamento_id` ASC),
  INDEX `fk_Compras_has_FormasDePagamento_Compras1_idx` (`Compras_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Compras_has_FormasDePagamento_Compras1`
    FOREIGN KEY (`Compras_id`)
    REFERENCES `compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_has_FormasDePagamento_FormasDePagamento1`
    FOREIGN KEY (`FormasDePagamento_id`)
    REFERENCES `formapagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `venda_formaspagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `venda_formaspagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Vendas_id` INT NOT NULL,
  `FormasDePagamento_id` INT NOT NULL,
  INDEX `fk_Vendas_has_FormasDePagamento_FormasDePagamento1_idx` (`FormasDePagamento_id` ASC),
  INDEX `fk_Vendas_has_FormasDePagamento_Vendas1_idx` (`Vendas_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Vendas_has_FormasDePagamento_Vendas1`
    FOREIGN KEY (`Vendas_id`)
    REFERENCES `venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_has_FormasDePagamento_FormasDePagamento1`
    FOREIGN KEY (`FormasDePagamento_id`)
    REFERENCES `formapagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `email` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(45) NOT NULL,
  `pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_email_pessoa1_idx` (`pessoa_id` ASC),
  CONSTRAINT `fk_email_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Limite` DECIMAL(10,4) NOT NULL,
  `DataNascimento` DATE NOT NULL,
  `RG` INT NOT NULL,
  `pessoa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cliente_pessoa1_idx` (`pessoa_id` ASC),
  CONSTRAINT `fk_Cliente_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
