-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 01/12/2016 às 17:19:13
-- Versão do Servidor: 5.5.49
-- Versão do PHP: 5.4.45-0+deb7u4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `admin_emarket`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE IF NOT EXISTS `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo_permissao`
--

CREATE TABLE IF NOT EXISTS `cargo_permissao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Cargo_id` int(11) NOT NULL,
  `Permissao_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Cargo_has_Permissao_Permissao1_idx` (`Permissao_id`),
  KEY `fk_Cargo_has_Permissao_Cargo1_idx` (`Cargo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `compras`
--

CREATE TABLE IF NOT EXISTS `compras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DataCompra` datetime NOT NULL,
  `ValorTotal` decimal(10,5) NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  `Usuario_id` int(11) NOT NULL,
  `Fornecedor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Compras_Empresa1_idx` (`Empresa_id`),
  KEY `fk_Compras_Usuario1_idx` (`Usuario_id`),
  KEY `fk_Compras_Fornecedor1_idx` (`Fornecedor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `compras_formaspagamento`
--

CREATE TABLE IF NOT EXISTS `compras_formaspagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Compras_id` int(11) NOT NULL,
  `FormasDePagamento_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Compras_has_FormasDePagamento_FormasDePagamento1_idx` (`FormasDePagamento_id`),
  KEY `fk_Compras_has_FormasDePagamento_Compras1_idx` (`Compras_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contatos`
--

CREATE TABLE IF NOT EXISTS `contatos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Telefone` varchar(25) NOT NULL,
  `Pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Contatos_Pessoa1_idx` (`Pessoa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `RazaoSocial` varchar(45) NOT NULL,
  `CNPJ` int(10) unsigned NOT NULL,
  `DataContratacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Logradouro` varchar(30) NOT NULL,
  `Bairro` varchar(10) NOT NULL,
  `Cidade` varchar(15) NOT NULL,
  `Estado` varchar(15) NOT NULL,
  `Pais` varchar(15) NOT NULL,
  `Cep` varchar(20) NOT NULL,
  `Pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Endereco_Pessoa1_idx` (`Pessoa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `financeirocaixa`
--

CREATE TABLE IF NOT EXISTS `financeirocaixa` (
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
  KEY `fk_FinanceiroCaixa_TerminaldeVenda1_idx` (`TerminaldeVenda_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `financeiro_entrada`
--

CREATE TABLE IF NOT EXISTS `financeiro_entrada` (
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
  KEY `fk_Financeiro_Entrada_Status1_idx` (`Status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `financeiro_saidas`
--

CREATE TABLE IF NOT EXISTS `financeiro_saidas` (
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
  KEY `fk_Financeiro_Saidas_Status1_idx` (`Status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `formaspagamento`
--

CREATE TABLE IF NOT EXISTS `formaspagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `TipoPagamento_id` int(11) NOT NULL,
  `MaxParcela` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_FormasDePagamento_TipoPagamento1_idx` (`TipoPagamento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Responsavel` varchar(45) DEFAULT NULL,
  `IE` int(10) unsigned DEFAULT NULL,
  `IM` varchar(15) DEFAULT NULL,
  `Representante` varchar(45) DEFAULT NULL,
  `Pessoa_id` int(11) NOT NULL,
  `Status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Fornecedor_Pessoa1_idx` (`Pessoa_id`),
  KEY `fk_Fornecedor_Status1_idx` (`Status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Salario` decimal(10,4) NOT NULL,
  `Comissao` int(11) NOT NULL,
  `DataAdmissao` datetime NOT NULL,
  `DataDemissao` datetime NOT NULL,
  `Cargo_id` int(11) NOT NULL,
  `Pessoa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Funcionario_Cargo1_idx` (`Cargo_id`),
  KEY `fk_Funcionario_Pessoa1_idx` (`Pessoa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_compra`
--

CREATE TABLE IF NOT EXISTS `itens_compra` (
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
  KEY `fk_Itens_Compra_Status1_idx` (`Status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_vendas`
--

CREATE TABLE IF NOT EXISTS `itens_vendas` (
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
  KEY `fk_Itens_Vendas_Status1_idx` (`Status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `movimentacaofinanceira`
--

CREATE TABLE IF NOT EXISTS `movimentacaofinanceira` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Realizado` double NOT NULL,
  `AReceber` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `permissao`
--

CREATE TABLE IF NOT EXISTS `permissao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(45) NOT NULL,
  `Modulo_URL` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf_cnpj` int(10) unsigned NOT NULL,
  `Nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_empresa`
--

CREATE TABLE IF NOT EXISTS `pessoa_empresa` (
  `Pessoa_id` int(11) NOT NULL,
  `Empresa_id` int(11) NOT NULL,
  PRIMARY KEY (`Pessoa_id`,`Empresa_id`),
  KEY `fk_Pessoa_has_Empresa_Empresa1_idx` (`Empresa_id`),
  KEY `fk_Pessoa_has_Empresa_Pessoa1_idx` (`Pessoa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
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
  KEY `fk_Produtos_Promocao1_idx` (`Promocao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `promocao`
--

CREATE TABLE IF NOT EXISTS `promocao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(45) NOT NULL,
  `DataInicio` datetime NOT NULL,
  `DataFinal` datetime NOT NULL,
  `Porcentagem` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `status`
--

CREATE TABLE IF NOT EXISTS `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `terminalvenda`
--

CREATE TABLE IF NOT EXISTS `terminalvenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroDaMaquina` int(11) DEFAULT NULL,
  `Token` varchar(70) DEFAULT NULL,
  `Empresa_id` int(11) NOT NULL,
  `Usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_TerminaldeVenda_Empresa1_idx` (`Empresa_id`),
  KEY `fk_TerminaldeVenda_Usuario1_idx` (`Usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipopagamento`
--

CREATE TABLE IF NOT EXISTS `tipopagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(30) NOT NULL,
  `Senha` varchar(45) NOT NULL,
  `TokenSession` varchar(45) NOT NULL,
  `Funcionario_id` int(11) NOT NULL,
  `Status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Usuario_Funcionario1_idx` (`Funcionario_id`),
  KEY `fk_Usuario_Status1_idx` (`Status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE IF NOT EXISTS `vendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DataDaVenda` datetime NOT NULL,
  `ValorTotal` decimal(10,4) DEFAULT NULL,
  `Empresa_id` int(11) NOT NULL,
  `Usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Vendas_Empresa1_idx` (`Empresa_id`),
  KEY `fk_Vendas_Usuario1_idx` (`Usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas_formaspagamento`
--

CREATE TABLE IF NOT EXISTS `vendas_formaspagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Vendas_id` int(11) NOT NULL,
  `FormasDePagamento_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Vendas_has_FormasDePagamento_FormasDePagamento1_idx` (`FormasDePagamento_id`),
  KEY `fk_Vendas_has_FormasDePagamento_Vendas1_idx` (`Vendas_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `cargo_permissao`
--
ALTER TABLE `cargo_permissao`
  ADD CONSTRAINT `fk_Cargo_has_Permissao_Cargo1` FOREIGN KEY (`Cargo_id`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cargo_has_Permissao_Permissao1` FOREIGN KEY (`Permissao_id`) REFERENCES `permissao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `fk_Compras_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Compras_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Compras_Fornecedor1` FOREIGN KEY (`Fornecedor_id`) REFERENCES `fornecedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `compras_formaspagamento`
--
ALTER TABLE `compras_formaspagamento`
  ADD CONSTRAINT `fk_Compras_has_FormasDePagamento_Compras1` FOREIGN KEY (`Compras_id`) REFERENCES `compras` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Compras_has_FormasDePagamento_FormasDePagamento1` FOREIGN KEY (`FormasDePagamento_id`) REFERENCES `formaspagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `contatos`
--
ALTER TABLE `contatos`
  ADD CONSTRAINT `fk_Contatos_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `fk_Endereco_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `financeirocaixa`
--
ALTER TABLE `financeirocaixa`
  ADD CONSTRAINT `fk_FinanceiroCaixa_TerminaldeVenda1` FOREIGN KEY (`TerminaldeVenda_id`) REFERENCES `terminalvenda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `financeiro_entrada`
--
ALTER TABLE `financeiro_entrada`
  ADD CONSTRAINT `fk_Financeiro_Entrada_MovimentacaoFinanceira1` FOREIGN KEY (`MovimentacaoFinanceira_id`) REFERENCES `movimentacaofinanceira` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Financeiro_Entrada_FormasDePagamento1` FOREIGN KEY (`FormasDePagamento_id`) REFERENCES `formaspagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Financeiro_Entrada_Vendas1` FOREIGN KEY (`Vendas_id`) REFERENCES `vendas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Financeiro_Entrada_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `financeiro_saidas`
--
ALTER TABLE `financeiro_saidas`
  ADD CONSTRAINT `fk_Financeiro_Saidas_MovimentacaoFinanceira1` FOREIGN KEY (`MovimentacaoFinanceira_id`) REFERENCES `movimentacaofinanceira` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Financeiro_Saidas_Compras1` FOREIGN KEY (`Compras_id`) REFERENCES `compras` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Financeiro_Saidas_FormasDePagamento1` FOREIGN KEY (`FormasDePagamento_id`) REFERENCES `formaspagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Financeiro_Saidas_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `formaspagamento`
--
ALTER TABLE `formaspagamento`
  ADD CONSTRAINT `fk_FormasDePagamento_TipoPagamento1` FOREIGN KEY (`TipoPagamento_id`) REFERENCES `tipopagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fk_Fornecedor_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Fornecedor_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_Funcionario_Cargo1` FOREIGN KEY (`Cargo_id`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Funcionario_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `itens_compra`
--
ALTER TABLE `itens_compra`
  ADD CONSTRAINT `fk_Itens_Compra_Compras1` FOREIGN KEY (`Compras_id`) REFERENCES `compras` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Itens_Compra_Produtos1` FOREIGN KEY (`Produtos_id`) REFERENCES `produtos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Itens_Compra_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `itens_vendas`
--
ALTER TABLE `itens_vendas`
  ADD CONSTRAINT `fk_Itens_Vendas_Vendas1` FOREIGN KEY (`Vendas_id`) REFERENCES `vendas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Itens_Vendas_FinanceiroCaixa1` FOREIGN KEY (`FinanceiroCaixa_id`) REFERENCES `financeirocaixa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Itens_Vendas_Produtos1` FOREIGN KEY (`Produtos_id`) REFERENCES `produtos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Itens_Vendas_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `pessoa_empresa`
--
ALTER TABLE `pessoa_empresa`
  ADD CONSTRAINT `fk_Pessoa_has_Empresa_Pessoa1` FOREIGN KEY (`Pessoa_id`) REFERENCES `pessoa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Pessoa_has_Empresa_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `fk_Produtos_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Produtos_Promocao1` FOREIGN KEY (`Promocao_id`) REFERENCES `promocao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `terminalvenda`
--
ALTER TABLE `terminalvenda`
  ADD CONSTRAINT `fk_TerminaldeVenda_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_TerminaldeVenda_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_Funcionario1` FOREIGN KEY (`Funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_Status1` FOREIGN KEY (`Status_id`) REFERENCES `status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `fk_Vendas_Empresa1` FOREIGN KEY (`Empresa_id`) REFERENCES `empresa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vendas_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `vendas_formaspagamento`
--
ALTER TABLE `vendas_formaspagamento`
  ADD CONSTRAINT `fk_Vendas_has_FormasDePagamento_Vendas1` FOREIGN KEY (`Vendas_id`) REFERENCES `vendas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vendas_has_FormasDePagamento_FormasDePagamento1` FOREIGN KEY (`FormasDePagamento_id`) REFERENCES `formaspagamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
