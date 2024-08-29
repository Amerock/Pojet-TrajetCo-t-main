-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 17, 2024 at 03:30 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simultrajet`
--

-- --------------------------------------------------------

--
-- Table structure for table `pub1`
--

CREATE TABLE `pub1` (
  `id_pub1` int NOT NULL,
  `annonceur` varchar(255) NOT NULL,
  `revenu` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pub1`
--

INSERT INTO `pub1` (`id_pub1`, `annonceur`, `revenu`) VALUES
(1, 'annonceur_test_1', 3);

-- --------------------------------------------------------

--
-- Table structure for table `pub2`
--

CREATE TABLE `pub2` (
  `id_pub2` int NOT NULL,
  `annonceur` varchar(255) NOT NULL,
  `revenu` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pub2`
--

INSERT INTO `pub2` (`id_pub2`, `annonceur`, `revenu`) VALUES
(1, 'annonceur_test_2', 1.5);

-- --------------------------------------------------------

--
-- Table structure for table `trajets`
--

CREATE TABLE `trajets` (
  `id_trajet` tinyint NOT NULL,
  `immat` varchar(255) NOT NULL,
  `distance` double NOT NULL,
  `puissance` int NOT NULL,
  `vitesse` double NOT NULL,
  `cout` double NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_pub1` int NOT NULL,
  `id_pub2` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `trajets`
--

INSERT INTO `trajets` (`id_trajet`, `immat`, `distance`, `puissance`, `vitesse`, `cout`, `date`, `id_pub1`, `id_pub2`) VALUES
(1, 'ET-313-AT', 150, 4, 90, 9, '2024-02-17 12:47:45', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pub1`
--
ALTER TABLE `pub1`
  ADD PRIMARY KEY (`id_pub1`);

--
-- Indexes for table `pub2`
--
ALTER TABLE `pub2`
  ADD PRIMARY KEY (`id_pub2`);

--
-- Indexes for table `trajets`
--
ALTER TABLE `trajets`
  ADD PRIMARY KEY (`id_trajet`),
  ADD KEY `id_pub1` (`id_pub1`),
  ADD KEY `id_pub2` (`id_pub2`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pub1`
--
ALTER TABLE `pub1`
  MODIFY `id_pub1` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pub2`
--
ALTER TABLE `pub2`
  MODIFY `id_pub2` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `trajets`
--
ALTER TABLE `trajets`
  MODIFY `id_trajet` tinyint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trajets`
--
ALTER TABLE `trajets`
  ADD CONSTRAINT `trajets_ibfk_1` FOREIGN KEY (`id_pub1`) REFERENCES `pub1` (`id_pub1`),
  ADD CONSTRAINT `trajets_ibfk_2` FOREIGN KEY (`id_pub2`) REFERENCES `pub2` (`id_pub2`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
