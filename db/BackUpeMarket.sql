CREATE DATABASE  IF NOT EXISTS `emarket` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `emarket`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: emarket
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DataCompra` datetime NOT NULL,
  `ValorTotal` decimal(10,5) NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  `Usuario_id` int(11) NOT NULL,
  `Fornecedor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Compras_Empresa1_idx` (`Empresa_id`),
  KEY `fk_Compras_Usuario1_idx` (`Usuario_id`),
  KEY `fk_Compras_Fornecedor1_idx` (`Fornecedor_id`),
  CONSTRAINT `fk_Compras_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_Fornecedor1` FOREIGN KEY (`Fornecedor_id`) REFERENCES `fornecedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_formapagamento`
--

DROP TABLE IF EXISTS `compra_formapagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra_formapagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Compras_id` int(11) NOT NULL,
  `FormasDePagamento_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Compras_has_FormasDePagamento_FormasDePagamento1_idx` (`FormasDePagamento_id`),
  KEY `fk_Compras_has_FormasDePagamento_Compras1_idx` (`Compras_id`),
  CONSTRAINT `fk_Compras_has_FormasDePagamento_Compras1` FOREIGN KEY (`Compras_id`) REFERENCES `compra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compras_has_FormasDePagamento_FormasDePagamento1` FOREIGN KEY (`FormasDePagamento_id`) REFERENCES `formapagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_formapagamento`
--

LOCK TABLES `compra_formapagamento` WRITE;
/*!40000 ALTER TABLE `compra_formapagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_formapagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Telefone` varchar(25) NOT NULL,
  `Pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Contatos_Pessoa1_idx` (`Pessoa_id`),
  CONSTRAINT `fk_Contatos_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `RazaoSocial` varchar(45) NOT NULL,
  `CNPJ` int(10) unsigned NOT NULL,
  `DataContratacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Logradouro` varchar(30) NOT NULL,
  `Bairro` varchar(10) NOT NULL,
  `Cidade` varchar(15) NOT NULL,
  `Estado` varchar(15) NOT NULL,
  `Pais` varchar(15) NOT NULL,
  `Cep` varchar(20) NOT NULL,
  `Pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Endereco_Pessoa1_idx` (`Pessoa_id`),
  CONSTRAINT `fk_Endereco_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financeiro_caixa`
--

DROP TABLE IF EXISTS `financeiro_caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financeiro_caixa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ValorInicial` decimal(10,4) NOT NULL,
  `ValorFinal` decimal(10,4) DEFAULT NULL,
  `DataAbertura` datetime NOT NULL,
  `DataFechamento` datetime DEFAULT NULL,
  `Sangria` decimal(10,4) DEFAULT NULL,
  `Suprimentos` decimal(10,4) DEFAULT NULL,
  `Descicao` varchar(45) NOT NULL,
  `TerminaldeVenda_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_FinanceiroCaixa_TerminaldeVenda1_idx` (`TerminaldeVenda_id`),
  CONSTRAINT `fk_FinanceiroCaixa_TerminaldeVenda1` FOREIGN KEY (`TerminaldeVenda_id`) REFERENCES `terminalvenda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financeiro_caixa`
--

LOCK TABLES `financeiro_caixa` WRITE;
/*!40000 ALTER TABLE `financeiro_caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `financeiro_caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financeiro_entrada`
--

DROP TABLE IF EXISTS `financeiro_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financeiro_entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DataVencimento` datetime NOT NULL,
  `Valor` decimal(10,5) NOT NULL,
  `NumeroParcela` int(11) NOT NULL,
  `DataBaixa` datetime DEFAULT NULL,
  `MovimentacaoFinanceira_id` int(11) NOT NULL,
  `FormasDePagamento_id` int(11) NOT NULL,
  `Vendas_id` int(11) NOT NULL,
  `Status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Financeiro_Entrada_MovimentacaoFinanceira1_idx` (`MovimentacaoFinanceira_id`),
  KEY `fk_Financeiro_Entrada_FormasDePagamento1_idx` (`FormasDePagamento_id`),
  KEY `fk_Financeiro_Entrada_Vendas1_idx` (`Vendas_id`),
  KEY `fk_Financeiro_Entrada_Status1_idx` (`Status_id`),
  CONSTRAINT `fk_Financeiro_Entrada_FormasDePagamento1` FOREIGN KEY (`FormasDePagamento_id`) REFERENCES `formapagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Entrada_MovimentacaoFinanceira1` FOREIGN KEY (`MovimentacaoFinanceira_id`) REFERENCES `movimentacao_financeira` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Entrada_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Entrada_Vendas1` FOREIGN KEY (`Vendas_id`) REFERENCES `venda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financeiro_entrada`
--

LOCK TABLES `financeiro_entrada` WRITE;
/*!40000 ALTER TABLE `financeiro_entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `financeiro_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financeiro_saida`
--

DROP TABLE IF EXISTS `financeiro_saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financeiro_saida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DataVencimento` datetime NOT NULL,
  `Databaixa` datetime NOT NULL,
  `DataEmissao` datetime NOT NULL,
  `Valor` int(11) NOT NULL,
  `MovimentacaoFinanceira_id` int(11) NOT NULL,
  `Compras_id` int(11) NOT NULL,
  `FormasDePagamento_id` int(11) NOT NULL,
  `Status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Financeiro_Saidas_MovimentacaoFinanceira1_idx` (`MovimentacaoFinanceira_id`),
  KEY `fk_Financeiro_Saidas_Compras1_idx` (`Compras_id`),
  KEY `fk_Financeiro_Saidas_FormasDePagamento1_idx` (`FormasDePagamento_id`),
  KEY `fk_Financeiro_Saidas_Status1_idx` (`Status_id`),
  CONSTRAINT `fk_Financeiro_Saidas_Compras1` FOREIGN KEY (`Compras_id`) REFERENCES `compra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Saidas_FormasDePagamento1` FOREIGN KEY (`FormasDePagamento_id`) REFERENCES `formapagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Saidas_MovimentacaoFinanceira1` FOREIGN KEY (`MovimentacaoFinanceira_id`) REFERENCES `movimentacao_financeira` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Financeiro_Saidas_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financeiro_saida`
--

LOCK TABLES `financeiro_saida` WRITE;
/*!40000 ALTER TABLE `financeiro_saida` DISABLE KEYS */;
/*!40000 ALTER TABLE `financeiro_saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formapagamento`
--

DROP TABLE IF EXISTS `formapagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formapagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `TipoPagamento_id` int(11) NOT NULL,
  `MaxParcela` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_FormasDePagamento_TipoPagamento1_idx` (`TipoPagamento_id`),
  CONSTRAINT `fk_FormasDePagamento_TipoPagamento1` FOREIGN KEY (`TipoPagamento_id`) REFERENCES `tipopagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formapagamento`
--

LOCK TABLES `formapagamento` WRITE;
/*!40000 ALTER TABLE `formapagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `formapagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Responsavel` varchar(45) DEFAULT NULL,
  `IE` int(10) unsigned DEFAULT NULL,
  `IM` varchar(15) DEFAULT NULL,
  `Representante` varchar(45) DEFAULT NULL,
  `Pessoa_id` int(11) NOT NULL,
  `Status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Fornecedor_Pessoa1_idx` (`Pessoa_id`),
  KEY `fk_Fornecedor_Status1_idx` (`Status_id`),
  CONSTRAINT `fk_Fornecedor_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fornecedor_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Salario` decimal(10,4) NOT NULL,
  `Comissao` int(11) NOT NULL,
  `DataAdmissao` datetime NOT NULL,
  `DataDemissao` datetime NOT NULL,
  `Cargo_id` int(11) NOT NULL,
  `Pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Funcionario_Cargo1_idx` (`Cargo_id`),
  KEY `fk_Funcionario_Pessoa1_idx` (`Pessoa_id`),
  CONSTRAINT `fk_Funcionario_Cargo1` FOREIGN KEY (`Cargo_id`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_compra`
--

DROP TABLE IF EXISTS `item_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Quantidade` decimal(10,10) NOT NULL,
  `ValorCompra` decimal(10,5) NOT NULL,
  `DataCompra` datetime NOT NULL,
  `Compras_id` int(11) NOT NULL,
  `Produtos_id` int(11) NOT NULL,
  `Status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Itens_Compra_Compras1_idx` (`Compras_id`),
  KEY `fk_Itens_Compra_Produtos1_idx` (`Produtos_id`),
  KEY `fk_Itens_Compra_Status1_idx` (`Status_id`),
  CONSTRAINT `fk_Itens_Compra_Compras1` FOREIGN KEY (`Compras_id`) REFERENCES `compra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Compra_Produtos1` FOREIGN KEY (`Produtos_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Compra_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_compra`
--

LOCK TABLES `item_compra` WRITE;
/*!40000 ALTER TABLE `item_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_venda`
--

DROP TABLE IF EXISTS `item_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Quantidade` varchar(45) NOT NULL,
  `ValorDaVenda` decimal(10,4) NOT NULL,
  `Vendas_id` int(11) NOT NULL,
  `FinanceiroCaixa_id` int(11) NOT NULL,
  `Produtos_id` int(11) NOT NULL,
  `Status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Itens_Vendas_Vendas1_idx` (`Vendas_id`),
  KEY `fk_Itens_Vendas_FinanceiroCaixa1_idx` (`FinanceiroCaixa_id`),
  KEY `fk_Itens_Vendas_Produtos1_idx` (`Produtos_id`),
  KEY `fk_Itens_Vendas_Status1_idx` (`Status_id`),
  CONSTRAINT `fk_Itens_Vendas_FinanceiroCaixa1` FOREIGN KEY (`FinanceiroCaixa_id`) REFERENCES `financeiro_caixa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Vendas_Produtos1` FOREIGN KEY (`Produtos_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Vendas_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itens_Vendas_Vendas1` FOREIGN KEY (`Vendas_id`) REFERENCES `venda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_venda`
--

LOCK TABLES `item_venda` WRITE;
/*!40000 ALTER TABLE `item_venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacao_financeira`
--

DROP TABLE IF EXISTS `movimentacao_financeira`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimentacao_financeira` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Realizado` double NOT NULL,
  `AReceber` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacao_financeira`
--

LOCK TABLES `movimentacao_financeira` WRITE;
/*!40000 ALTER TABLE `movimentacao_financeira` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimentacao_financeira` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(45) NOT NULL,
  `Modulo_URL` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao_cargo`
--

DROP TABLE IF EXISTS `permissao_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissao_cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Cargo_id` int(11) NOT NULL,
  `Permissao_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Cargo_has_Permissao_Permissao1_idx` (`Permissao_id`),
  KEY `fk_Cargo_has_Permissao_Cargo1_idx` (`Cargo_id`),
  CONSTRAINT `fk_Cargo_has_Permissao_Cargo1` FOREIGN KEY (`Cargo_id`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cargo_has_Permissao_Permissao1` FOREIGN KEY (`Permissao_id`) REFERENCES `permissao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao_cargo`
--

LOCK TABLES `permissao_cargo` WRITE;
/*!40000 ALTER TABLE `permissao_cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissao_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf_cnpj` int(10) unsigned NOT NULL,
  `Nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa_empresa`
--

DROP TABLE IF EXISTS `pessoa_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa_empresa` (
  `Pessoa_id` int(11) NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`Pessoa_id`,`Empresa_id`),
  KEY `fk_Pessoa_has_Empresa_Empresa1_idx` (`Empresa_id`),
  KEY `fk_Pessoa_has_Empresa_Pessoa1_idx` (`Pessoa_id`),
  CONSTRAINT `fk_Pessoa_has_Empresa_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoa_has_Empresa_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa_empresa`
--

LOCK TABLES `pessoa_empresa` WRITE;
/*!40000 ALTER TABLE `pessoa_empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `Descricao` varchar(45) NOT NULL,
  `Margem` varchar(45) NOT NULL,
  `NCM` int(11) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `ValorUnitario` decimal(10,5) NOT NULL,
  `DataVencimento` datetime NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  `CodBarras` int(11) NOT NULL,
  `Promocao_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Produtos_Empresa1_idx` (`Empresa_id`),
  KEY `fk_Produtos_Promocao1_idx` (`Promocao_id`),
  CONSTRAINT `fk_Produtos_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_Promocao1` FOREIGN KEY (`Promocao_id`) REFERENCES `promocao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocao`
--

DROP TABLE IF EXISTS `promocao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promocao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(45) NOT NULL,
  `DataInicio` datetime NOT NULL,
  `DataFinal` datetime NOT NULL,
  `Porcentagem` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocao`
--

LOCK TABLES `promocao` WRITE;
/*!40000 ALTER TABLE `promocao` DISABLE KEYS */;
/*!40000 ALTER TABLE `promocao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminalvenda`
--

DROP TABLE IF EXISTS `terminalvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminalvenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroDaMaquina` int(11) DEFAULT NULL,
  `Token` varchar(70) DEFAULT NULL,
  `Empresa_id` int(11) NOT NULL,
  `Usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_TerminaldeVenda_Empresa1_idx` (`Empresa_id`),
  KEY `fk_TerminaldeVenda_Usuario1_idx` (`Usuario_id`),
  CONSTRAINT `fk_TerminaldeVenda_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TerminaldeVenda_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminalvenda`
--

LOCK TABLES `terminalvenda` WRITE;
/*!40000 ALTER TABLE `terminalvenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `terminalvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopagamento`
--

DROP TABLE IF EXISTS `tipopagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopagamento`
--

LOCK TABLES `tipopagamento` WRITE;
/*!40000 ALTER TABLE `tipopagamento` DISABLE KEYS */;
INSERT INTO `tipopagamento` VALUES (1,'Credito'),(2,'Debito'),(3,'Usuario Ativo'),(4,'Usuario Desativado'),(5,'Conta Em Aberto'),(6,'Conta Fechada'),(7,'Conta Estornada'),(8,'Item Confirmado'),(9,'Item Estornado');
/*!40000 ALTER TABLE `tipopagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(30) NOT NULL,
  `Senha` varchar(45) NOT NULL,
  `TokenSession` varchar(45) NOT NULL,
  `Funcionario_id` int(11) NOT NULL,
  `Status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Usuario_Funcionario1_idx` (`Funcionario_id`),
  KEY `fk_Usuario_Status1_idx` (`Status_id`),
  CONSTRAINT `fk_Usuario_Funcionario1` FOREIGN KEY (`Funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DataDaVenda` datetime NOT NULL,
  `ValorTotal` decimal(10,4) DEFAULT NULL,
  `Empresa_id` int(11) NOT NULL,
  `Usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Vendas_Empresa1_idx` (`Empresa_id`),
  KEY `fk_Vendas_Usuario1_idx` (`Usuario_id`),
  CONSTRAINT `fk_Vendas_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda_formapagamento`
--

DROP TABLE IF EXISTS `venda_formapagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda_formapagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Vendas_id` int(11) NOT NULL,
  `FormasDePagamento_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Vendas_has_FormasDePagamento_FormasDePagamento1_idx` (`FormasDePagamento_id`),
  KEY `fk_Vendas_has_FormasDePagamento_Vendas1_idx` (`Vendas_id`),
  CONSTRAINT `fk_Vendas_has_FormasDePagamento_FormasDePagamento1` FOREIGN KEY (`FormasDePagamento_id`) REFERENCES `formapagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_has_FormasDePagamento_Vendas1` FOREIGN KEY (`Vendas_id`) REFERENCES `venda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda_formapagamento`
--

LOCK TABLES `venda_formapagamento` WRITE;
/*!40000 ALTER TABLE `venda_formapagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda_formapagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'emarket'
--

--
-- Dumping routines for database 'emarket'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-02  8:20:06
