-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2023 at 04:51 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkir`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `no_tiket` int(10) NOT NULL,
  `no_pol` varchar(10) NOT NULL,
  `jenis` varchar(10) NOT NULL,
  `waktu_masuk` datetime NOT NULL DEFAULT current_timestamp(),
  `waktu_keluar` datetime DEFAULT NULL,
  `status` varchar(6) NOT NULL DEFAULT 'Masuk',
  `biaya` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`no_tiket`, `no_pol`, `jenis`, `waktu_masuk`, `waktu_keluar`, `status`, `biaya`) VALUES
(2, 'b 423 NG', 'Motor', '2023-05-27 21:42:51', '2023-05-27 21:44:17', 'keluar', 2000),
(3, 'AD 4 NI', 'Mobil', '2023-05-27 21:43:03', NULL, 'Masuk', NULL),
(4, 'AB 845 BC', 'Motor', '2023-05-27 21:43:27', '2023-05-27 21:47:21', 'keluar', 2000),
(5, 'AB 45 U', 'Motor', '2023-05-27 21:43:56', NULL, 'Masuk', NULL),
(6, 'H 45 U', 'Mobil', '2023-05-27 21:47:05', NULL, 'Masuk', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`no_tiket`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data`
--
ALTER TABLE `data`
  MODIFY `no_tiket` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
