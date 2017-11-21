-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 21-Nov-2017 às 23:49
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `inventarioccr`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `computador`
--

CREATE TABLE IF NOT EXISTS `computador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `hostName` varchar(45) NOT NULL,
  `serialNumber` varchar(45) NOT NULL,
  `bp` int(11) NOT NULL,
  `site` varchar(45) NOT NULL,
  `localidade` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `chapa` varchar(45) NOT NULL,
  `ramal` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `impressora`
--

CREATE TABLE IF NOT EXISTS `impressora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fila` varchar(45) NOT NULL,
  `ip` varchar(45) NOT NULL,
  `fabricante` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `site` varchar(45) NOT NULL,
  `localidade` varchar(45) NOT NULL,
  `toner` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `serialNumber` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `notebook`
--

CREATE TABLE IF NOT EXISTS `notebook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `hostName` varchar(45) NOT NULL,
  `serialNumber` varchar(45) NOT NULL,
  `bp` varchar(45) NOT NULL,
  `site` varchar(45) NOT NULL,
  `localidade` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `chapa` varchar(45) NOT NULL,
  `ramal` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
