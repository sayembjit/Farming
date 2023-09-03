-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2023 at 06:35 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `farm`
--

-- --------------------------------------------------------

--
-- Table structure for table `crop`
--

CREATE TABLE `crop` (
  `id` bigint(20) NOT NULL,
  `crop_name` varchar(255) DEFAULT NULL,
  `disease_susceptibility` varchar(255) DEFAULT NULL,
  `growth_requirements` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `crop`
--

INSERT INTO `crop` (`id`, `crop_name`, `disease_susceptibility`, `growth_requirements`) VALUES
(1, '', '', ''),
(5, 'Cabbage', 'high', 'Sunshine'),
(6, 'Cucumber', 'high', 'Sunshine');

-- --------------------------------------------------------

--
-- Table structure for table `crop_field_mapping`
--

CREATE TABLE `crop_field_mapping` (
  `crop_id` bigint(20) NOT NULL,
  `field_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `crop_field_mapping`
--

INSERT INTO `crop_field_mapping` (`crop_id`, `field_id`) VALUES
(5, 1),
(6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `field`
--

CREATE TABLE `field` (
  `id` bigint(20) NOT NULL,
  `field_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `field`
--

INSERT INTO `field` (`id`, `field_name`, `location`) VALUES
(1, 'Field X', 'LOCATION A'),
(2, 'Field Y', 'LOCATION A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `crop`
--
ALTER TABLE `crop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `crop_field_mapping`
--
ALTER TABLE `crop_field_mapping`
  ADD PRIMARY KEY (`crop_id`,`field_id`),
  ADD KEY `FKosemss8820vuyg411pg942mh6` (`field_id`);

--
-- Indexes for table `field`
--
ALTER TABLE `field`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `crop`
--
ALTER TABLE `crop`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `field`
--
ALTER TABLE `field`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `crop_field_mapping`
--
ALTER TABLE `crop_field_mapping`
  ADD CONSTRAINT `FKid5mfbxdffe01138rx7jqvr8` FOREIGN KEY (`crop_id`) REFERENCES `crop` (`id`),
  ADD CONSTRAINT `FKosemss8820vuyg411pg942mh6` FOREIGN KEY (`field_id`) REFERENCES `field` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
