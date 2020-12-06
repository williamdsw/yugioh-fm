-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 06, 2020 at 08:32 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yugioh-fm`
--
CREATE DATABASE IF NOT EXISTS `yugioh-fm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `yugioh-fm`;

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `id` int(11) NOT NULL,
  `atk` int(11) DEFAULT NULL,
  `card_type` int(11) DEFAULT NULL,
  `def` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `monster_type` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `star_chip_cost` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `deck`
--

CREATE TABLE `deck` (
  `id` int(11) NOT NULL,
  `character_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `deck_card`
--

CREATE TABLE `deck_card` (
  `card_id` int(11) NOT NULL,
  `deck_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `game_character`
--

CREATE TABLE `game_character` (
  `id` int(11) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `guardian_star`
--

CREATE TABLE `guardian_star` (
  `card_id` int(11) NOT NULL,
  `guardians` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `deck`
--
ALTER TABLE `deck`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpp7uwf6fof6whc4xcwn7g228o` (`character_id`);

--
-- Indexes for table `deck_card`
--
ALTER TABLE `deck_card`
  ADD PRIMARY KEY (`card_id`,`deck_id`),
  ADD KEY `FK1ugpqceq7io37kmaj7u0h876j` (`deck_id`);

--
-- Indexes for table `game_character`
--
ALTER TABLE `game_character`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `guardian_star`
--
ALTER TABLE `guardian_star`
  ADD KEY `FKeygd98n25y0tvbn27w7k7s9h3` (`card_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `card`
--
ALTER TABLE `card`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `deck`
--
ALTER TABLE `deck`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `game_character`
--
ALTER TABLE `game_character`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `deck`
--
ALTER TABLE `deck`
  ADD CONSTRAINT `FKpp7uwf6fof6whc4xcwn7g228o` FOREIGN KEY (`character_id`) REFERENCES `game_character` (`id`);

--
-- Constraints for table `deck_card`
--
ALTER TABLE `deck_card`
  ADD CONSTRAINT `FK1ugpqceq7io37kmaj7u0h876j` FOREIGN KEY (`deck_id`) REFERENCES `deck` (`id`),
  ADD CONSTRAINT `FKs1mdlmk0eh4t3uh9nmxn03dpd` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`);

--
-- Constraints for table `guardian_star`
--
ALTER TABLE `guardian_star`
  ADD CONSTRAINT `FKeygd98n25y0tvbn27w7k7s9h3` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
