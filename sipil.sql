-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2020 at 09:19 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sipil`
--

-- --------------------------------------------------------

--
-- Dumping data for table `akademi`
--

INSERT INTO `akademi` (`id`, `lokasi`, `nama`) VALUES
(1, 'DKI Jakarta', 'Sekolah Terbang Tinggi'),
(2, 'DKI Jakarta', 'Sekolah Angkasa Luar'),
(3, 'Bekasi', 'Sekolah Galaksi'),
(4, 'Bandung', 'Sekolah Daun Hijau'),
(5, 'Bogor', 'Sekolah Angkatan Udara'),
(6, 'Bogor', 'Sekolah Angkasa Udara');

--
-- Dumping data for table `maskapai`
--



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;