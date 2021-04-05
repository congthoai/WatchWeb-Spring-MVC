create database IF NOT EXISTS watch;
use watch;

-- phpMyAdmin SQL Dump
-- version 4.6.6deb4+deb9u2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 13, 2020 at 09:25 AM
-- Server version: 10.1.47-MariaDB-0+deb9u1
-- PHP Version: 7.0.33-0+deb9u10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `watch`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE IF NOT EXISTS `brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `code`, `description`, `name`, `place`) VALUES
(1, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', NULL, 'SX tại nhật', 'Seiko', 'Japan'),
(2, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', NULL, 'Đồng hồ nổi tiếng tại thụy điển', 'DanielWellington', 'Thụy điển'),
(3, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', NULL, 'SX tại nhật', 'Casio', 'Japan'),
(4, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', NULL, 'SX tại nhật', 'Q&Q', 'Japan');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `new`
--

CREATE TABLE IF NOT EXISTS `new` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `content` text,
  `shortdescription` text,
  `thumbnail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_n64e68925ltftar1nwdaqhaa` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_k8kupdtcdpqd57b6j4yq9uvdj` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `watch_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q6bwjb8y711vixrxinko7wmnw` (`order_id`),
  KEY `FK_qq50cmotjyeyqng0s0k6fanie` (`watch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `code`, `name`) VALUES
(1, NULL, NULL, NULL, NULL, 'ADMIN', 'Quản trị'),
(2, NULL, NULL, NULL, NULL, 'USER', 'Người dùng');

-- --------------------------------------------------------

--
-- Table structure for table `slide`
--

CREATE TABLE IF NOT EXISTS `slide` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `slide`
--

INSERT INTO `slide` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `link`, `name`, `sort`) VALUES
(1, NULL, NULL, NULL, NULL, '/resources/images/slide/slide1.png', 'slide 1', 1),
(2, NULL, NULL, NULL, NULL, '/resources/images/slide/slide2.png', 'slide 2', 2),
(3, NULL, NULL, NULL, NULL, '/resources/images/slide/slide3.png', 'slide 3', 3);

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `code`, `description`, `name`) VALUES
(1, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', NULL, 'Đồng hồ lên dây cót', 'Đồng hồ cơ'),
(2, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', NULL, 'Đồng hồ chạy bằng pin', 'Đồng hồ pin'),
(3, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', NULL, 'Đồng hồ sạc năng lượng mặt trời', 'Đồng hồ năng lượng');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `email`, `fullname`, `password`, `phone`, `status`, `username`) VALUES
(1, NULL, NULL, NULL, NULL, '16521191@gm.uit.edu.vn', 'Cong Thoai', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', '0983583845', 1, 'admin'),
(2, NULL, NULL, NULL, NULL, '16521191@gm.uit.edu.vn', 'Người dùng 1', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', '0983583845', 1, 'user'),
(3, NULL, NULL, NULL, NULL, '16521191@gm.uit.edu.vn', 'Công Thoại', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', '0983583845', 1, 'congthoai');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `userid` bigint(20) NOT NULL,
  `roleid` bigint(20) NOT NULL,
  KEY `FK_jpkvqqgndeonhr2alguthv64e` (`roleid`),
  KEY `FK_jwv62hhuqojjk7pot7kaex3e1` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`userid`, `roleid`) VALUES
(1, 1),
(2, 2),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `watch`
--

CREATE TABLE IF NOT EXISTS `watch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `buyed` int(11) DEFAULT NULL,
  `discount` bigint(20) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `view` int(11) DEFAULT NULL,
  `warranty` int(11) DEFAULT NULL,
  `waterproof` int(11) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_d2vd28olf0omwv6c953xj648b` (`brand_id`),
  KEY `FK_hhubovguh3pfwjlx6w0t9a5xv` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `watch`
--

INSERT INTO `watch` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `buyed`, `discount`, `gender`, `material`, `name`, `price`, `size`, `stock`, `thumbnail`, `view`, `warranty`, `waterproof`, `brand_id`, `type_id`) VALUES
(1, '2020-12-13', '2020-12-13 00:00:00', '2020-12-13', '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 001', 900000, 41, 100, '/resources/images/watch/dhnam.jpg', 0, 12, 100, 1, 1),
(2, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 0, 'Nam', 'kim loại da trâu', 'Đồng hồ 002', 800000, 41, 100, '/resources/images/watch/dh5.jpg', 0, 12, 100, 2, 1),
(3, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 003', 750000, 41, 100, '/resources/images/watch/dhnu.jpg', 0, 12, 100, 3, 2),
(4, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 0, 'Nữ', 'kim loại da heo', 'Đồng hồ 004', 600000, 41, 100, '/resources/images/watch/dh9.jpg', 0, 12, 100, 4, 2),
(5, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 005', 900000, 41, 100, '/resources/images/watch/dh1.jpg', 0, 12, 100, 1, 1),
(6, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da trâu', 'Đồng hồ 006', 800000, 41, 100, '/resources/images/watch/dh2.jpg', 0, 12, 100, 2, 1),
(7, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 007', 750000, 41, 100, '/resources/images/watch/dh6.jpg', 0, 12, 100, 3, 2),
(8, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da heo', 'Đồng hồ 008', 600000, 41, 100, '/resources/images/watch/dh7.jpg', 0, 12, 100, 4, 2),
(9, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 009', 900000, 41, 100, '/resources/images/watch/dh3.jpg', 0, 12, 100, 1, 1),
(10, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da trâu', 'Đồng hồ 010', 800000, 41, 100, '/resources/images/watch/dh4.jpg', 0, 12, 100, 2, 1),
(11, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 011', 750000, 41, 100, '/resources/images/watch/dh8.jpg', 0, 12, 100, 3, 2),
(12, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da heo', 'Đồng hồ 012', 1000000, 41, 100, '/resources/images/watch/dh9.jpg', 0, 12, 100, 4, 2),
(13, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 013', 800000, 41, 100, '/resources/images/watch/dh5.jpg', 0, 12, 100, 1, 1),
(14, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 30000, 'Nữ', 'kim loại da heo', 'Đồng hồ 014', 1000000, 41, 100, '/resources/images/watch/dh10.jpg', 0, 12, 100, 4, 2),
(15, '2020-12-13', '2020-12-13 00:00:00', '2020-12-13', '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 001', 900000, 41, 100, '/resources/images/watch/dhnam.jpg', 0, 12, 100, 1, 1),
(16, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 0, 'Nam', 'kim loại da trâu', 'Đồng hồ 002', 800000, 41, 100, '/resources/images/watch/dh5.jpg', 0, 12, 100, 2, 1),
(17, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 003', 750000, 41, 100, '/resources/images/watch/dhnu.jpg', 0, 12, 100, 3, 2),
(18, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 0, 'Nữ', 'kim loại da heo', 'Đồng hồ 004', 600000, 41, 100, '/resources/images/watch/dh9.jpg', 0, 12, 100, 4, 2),
(19, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 005', 900000, 41, 100, '/resources/images/watch/dh1.jpg', 0, 12, 100, 1, 1),
(20, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da trâu', 'Đồng hồ 006', 800000, 41, 100, '/resources/images/watch/dh2.jpg', 0, 12, 100, 2, 1),
(21, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 007', 750000, 41, 100, '/resources/images/watch/dh6.jpg', 0, 12, 100, 3, 2),
(22, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da heo', 'Đồng hồ 008', 600000, 41, 100, '/resources/images/watch/dh7.jpg', 0, 12, 100, 4, 2),
(23, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 009', 900000, 41, 100, '/resources/images/watch/dh3.jpg', 0, 12, 100, 1, 1),
(24, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da trâu', 'Đồng hồ 010', 800000, 41, 100, '/resources/images/watch/dh4.jpg', 0, 12, 100, 2, 1),
(25, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 011', 750000, 41, 100, '/resources/images/watch/dh8.jpg', 0, 12, 100, 3, 2),
(26, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da heo', 'Đồng hồ 012', 1000000, 41, 100, '/resources/images/watch/dh9.jpg', 0, 12, 100, 4, 2),
(27, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 013', 800000, 41, 100, '/resources/images/watch/dh5.jpg', 0, 12, 100, 1, 1),
(28, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 30000, 'Nữ', 'kim loại da heo', 'Đồng hồ 014', 1000000, 41, 100, '/resources/images/watch/dh10.jpg', 0, 12, 100, 4, 2),
(29, '2020-12-13', '2020-12-13 00:00:00', '2020-12-13', '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 001', 900000, 41, 100, '/resources/images/watch/dhnam.jpg', 0, 12, 100, 1, 3),
(30, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 0, 'Nam', 'kim loại da trâu', 'Đồng hồ 002', 800000, 41, 100, '/resources/images/watch/dh5.jpg', 0, 12, 100, 2, 3),
(31, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 003', 750000, 41, 100, '/resources/images/watch/dhnu.jpg', 0, 12, 100, 3, 1),
(32, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 0, 'Nữ', 'kim loại da heo', 'Đồng hồ 004', 600000, 41, 100, '/resources/images/watch/dh9.jpg', 0, 12, 100, 4, 2),
(33, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 005', 900000, 41, 100, '/resources/images/watch/dh1.jpg', 0, 12, 100, 1, 3),
(34, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da trâu', 'Đồng hồ 006', 800000, 41, 100, '/resources/images/watch/dh2.jpg', 0, 12, 100, 2, 3),
(35, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 007', 750000, 41, 100, '/resources/images/watch/dh6.jpg', 0, 12, 100, 3, 2),
(36, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da heo', 'Đồng hồ 008', 600000, 41, 100, '/resources/images/watch/dh7.jpg', 0, 12, 100, 4, 2),
(37, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 009', 900000, 41, 100, '/resources/images/watch/dh3.jpg', 0, 12, 100, 1, 3),
(38, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da trâu', 'Đồng hồ 010', 800000, 41, 100, '/resources/images/watch/dh4.jpg', 0, 12, 100, 2, 3),
(39, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 011', 750000, 41, 100, '/resources/images/watch/dh8.jpg', 0, 12, 100, 3, 3),
(40, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da heo', 'Đồng hồ 012', 1000000, 41, 100, '/resources/images/watch/dh9.jpg', 0, 12, 100, 4, 3),
(41, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 013', 800000, 41, 100, '/resources/images/watch/dh5.jpg', 0, 12, 100, 1, 1),
(42, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 30000, 'Nữ', 'kim loại da heo', 'Đồng hồ 014', 1000000, 41, 100, '/resources/images/watch/dh10.jpg', 0, 12, 100, 4, 3),
(43, '2020-12-13', '2020-12-13 00:00:00', '2020-12-13', '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 001', 900000, 41, 100, '/resources/images/watch/dhnam.jpg', 0, 12, 100, 1, 3),
(44, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 0, 'Nam', 'kim loại da trâu', 'Đồng hồ 002', 800000, 41, 100, '/resources/images/watch/dh5.jpg', 0, 12, 100, 2, 3),
(45, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 003', 750000, 41, 100, '/resources/images/watch/dhnu.jpg', 0, 12, 100, 3, 1),
(46, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 0, 'Nữ', 'kim loại da heo', 'Đồng hồ 004', 600000, 41, 100, '/resources/images/watch/dh9.jpg', 0, 12, 100, 4, 2),
(47, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 005', 900000, 41, 100, '/resources/images/watch/dh1.jpg', 0, 12, 100, 1, 3),
(48, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da trâu', 'Đồng hồ 006', 800000, 41, 100, '/resources/images/watch/dh2.jpg', 0, 12, 100, 2, 3),
(49, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 007', 750000, 41, 100, '/resources/images/watch/dh6.jpg', 0, 12, 100, 3, 2),
(50, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da heo', 'Đồng hồ 008', 600000, 41, 100, '/resources/images/watch/dh7.jpg', 0, 12, 100, 4, 2),
(51, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 009', 900000, 41, 100, '/resources/images/watch/dh3.jpg', 0, 12, 100, 1, 3),
(52, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da trâu', 'Đồng hồ 010', 800000, 41, 100, '/resources/images/watch/dh4.jpg', 0, 12, 100, 2, 3),
(53, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da', 'Đồng hồ 011', 750000, 41, 100, '/resources/images/watch/dh8.jpg', 0, 12, 100, 3, 3),
(54, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nữ', 'kim loại da heo', 'Đồng hồ 012', 1000000, 41, 100, '/resources/images/watch/dh9.jpg', 0, 12, 100, 4, 3),
(55, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 50000, 'Nam', 'kim loại da bò', 'Đồng hồ 013', 800000, 41, 100, '/resources/images/watch/dh5.jpg', 0, 12, 100, 1, 1),
(56, NULL, '2020-12-13 00:00:00', NULL, '2020-12-13 00:00:00', 0, 30000, 'Nữ', 'kim loại da heo', 'Đồng hồ 014', 1000000, 41, 100, '/resources/images/watch/dh10.jpg', 0, 12, 100, 4, 3);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `new`
--
ALTER TABLE `new`
  ADD CONSTRAINT `FK_n64e68925ltftar1nwdaqhaa` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_k8kupdtcdpqd57b6j4yq9uvdj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FK_q6bwjb8y711vixrxinko7wmnw` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `FK_qq50cmotjyeyqng0s0k6fanie` FOREIGN KEY (`watch_id`) REFERENCES `watch` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK_jpkvqqgndeonhr2alguthv64e` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FK_jwv62hhuqojjk7pot7kaex3e1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`);

--
-- Constraints for table `watch`
--
ALTER TABLE `watch`
  ADD CONSTRAINT `FK_d2vd28olf0omwv6c953xj648b` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  ADD CONSTRAINT `FK_hhubovguh3pfwjlx6w0t9a5xv` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
