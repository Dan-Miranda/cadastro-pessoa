-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Ago-2021 às 16:08
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `atividade7`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `id` bigint(20) NOT NULL,
  `nome` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`) VALUES
(1, 'Goiania'),
(3, 'Rio Claro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `id` bigint(20) NOT NULL,
  `nome` text DEFAULT NULL,
  `sigla` char(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`id`, `nome`, `sigla`) VALUES
(1, 'Goiás', 'GO'),
(2, 'S\0o Paulo', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoafisica`
--

CREATE TABLE `pessoafisica` (
  `id` bigint(20) NOT NULL,
  `nomeSocial` text DEFAULT NULL,
  `razaoSocial` text NOT NULL,
  `email` text NOT NULL,
  `telefone` text DEFAULT NULL,
  `rua` text DEFAULT NULL,
  `numero` text DEFAULT NULL,
  `complemento` text DEFAULT NULL,
  `bairro` text DEFAULT NULL,
  `cep` text DEFAULT NULL,
  `cidadeId` bigint(20) DEFAULT NULL,
  `estadoId` bigint(20) DEFAULT NULL,
  `cpf` text NOT NULL,
  `rg` text NOT NULL,
  `dataNascimento` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pessoafisica`
--

INSERT INTO `pessoafisica` (`id`, `nomeSocial`, `razaoSocial`, `email`, `telefone`, `rua`, `numero`, `complemento`, `bairro`, `cep`, `cidadeId`, `estadoId`, `cpf`, `rg`, `dataNascimento`) VALUES
(1, 'danillo', 'danillo miranda', 'd@gmail.com', '435353453', 'acre', '234', '-', 'centro', '1859674888', 1, 1, '45565454345', '123454343', 'Sat Feb 02 00:00:00 BRST 2002'),
(2, 'Gabriel', 'Gabriel Pigatto', 'gpigatto@gmail.com', '110499584755', 'Cidade Nova', '987', '-', 'Cidade nova', '186794588', 0, 3, '46637485999', '374586549', 'Sat Feb 02 00:00:00 BRST 2002');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoajuridica`
--

CREATE TABLE `pessoajuridica` (
  `id` bigint(20) NOT NULL,
  `nomeSocial` text NOT NULL,
  `razaoSocial` text NOT NULL,
  `email` text NOT NULL,
  `telefone` text NOT NULL,
  `rua` text NOT NULL,
  `numero` text NOT NULL,
  `complemento` text DEFAULT NULL,
  `bairro` text NOT NULL,
  `cep` text NOT NULL,
  `cidadeId` bigint(20) NOT NULL,
  `estadoId` bigint(20) NOT NULL,
  `cnpj` text NOT NULL,
  `inscricaoEstadual` text NOT NULL,
  `inscricaoMunicipal` text NOT NULL,
  `fax` text DEFAULT NULL,
  `webSite` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Índices para tabela `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `pessoafisica`
--
ALTER TABLE `pessoafisica`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `estado`
--
ALTER TABLE `estado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `pessoafisica`
--
ALTER TABLE `pessoafisica`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
