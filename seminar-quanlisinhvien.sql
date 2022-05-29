-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 29, 2022 lúc 05:31 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `seminar-quanlisinhvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hiendien`
--

CREATE TABLE `hiendien` (
  `IDCARD` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `NGAYVAORA` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `THOIGIAN` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `hiendien`
--

INSERT INTO `hiendien` (`IDCARD`, `NGAYVAORA`, `THOIGIAN`) VALUES
('123', '0000-00-00', ''),
('1', '2022-04-22', ''),
('1', '0000-00-00', ''),
('1', '0000-00-00', ''),
('E200 1026 8110 0159 ', '2022-05-18', '16:00:00'),
('300F 4F57 3AD0 01C0 ', '2022-05-18', '7:00:00'),
('300F 4F57 3AD0 01C0 ', '2022-05-18', '14:00:00'),
('300F 4F57 3AD0 01C0 ', '2022-05-18', '15:00:00'),
('4D4F 5300', '2022-05-18', '6:59:00'),
('4D4F 5300', '2022-05-18', '16:59:00'),
('E200 1026 8110 0159 ', '2022-05-18', '16:00:00'),
('300F 4F57 3AD0 01C0 ', '2022-05-18', '7:00:00'),
('300F 4F57 3AD0 01C0 ', '2022-05-18', '14:00:00'),
('300F 4F57 3AD0 01C0 ', '2022-05-18', '15:00:00'),
('4D4F 5300', '2022-05-18', '6:59:00'),
('4D4F 5300', '2022-05-18', '16:59:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `IDCARD` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `TENSV` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`IDCARD`, `TENSV`) VALUES
('1', 'h'),
('2', 'd'),
('E200 1026 8110 0159', 'Le Thanh Huy'),
('300F 4F57 3AD0 01C0', 'Nguyen Quoc Tuan'),
('4D4F 5300', 'Nguyen Van A');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
