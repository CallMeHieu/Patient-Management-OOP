-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 12, 2023 lúc 02:24 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `clinic`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `medicine`
--

CREATE TABLE `medicine` (
  `medicineID` varchar(255) NOT NULL,
  `defaultDosage` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `medicine`
--

INSERT INTO `medicine` (`medicineID`, `defaultDosage`, `name`, `unit`) VALUES
('SP001', '1 viên mỗi 6 giờ', 'Albuterol', 'Vỉ'),
('SP002', '2 ống mỗi ngày', 'Gabapentin', 'Ống'),
('SP003', '1 ống mỗi 8 giờ', 'Amoxicillin', 'Ống'),
('SP004', '1 ống mỗi sáng', 'Levothyroxine', 'Ống'),
('SP005', '1 viên mỗi 6-8 giờ', 'Ibuprofen', 'Vỉ'),
('SP006', '1 viên mỗi ngày', 'Venlafaxine', 'Vỉ'),
('SP007', '1 viên mỗi tối', 'Pregabalin', 'Hộp'),
('SP008', '1 ống mỗi 12 giờ', 'Ranitidine', 'Ống'),
('SP009', '1 ống mỗi 4-6 giờ', 'Tramadol', 'Ống'),
('SP010', '1 viên mỗi ngày', 'Simvastatin', 'Vỉ'),
('SP011', '1 viên mỗi 4-6 giờ', 'Codeine', 'Hộp'),
('SP012', '1 viên mỗi ngày', 'Sertraline', 'Vỉ'),
('SP013', '1 ống mỗi 4-6 giờ', 'Oxycodone', 'Ống'),
('SP014', '1 viên mỗi ngày', 'Cetirizine', 'Hộp'),
('SP015', '1-2 viên mỗi 4-6 giờ', 'Paracetamol', 'Hộp'),
('SP016', '1 ống mỗi ngày', 'Amlodipine', 'Ống'),
('SP017', '1 viên mỗi ngày', 'Citalopram', 'Hộp'),
('SP018', '1 ống mỗi bữa ăn', 'Metformin', 'Ống'),
('SP019', '1-2 viên mỗi 6-8 giờ', 'Diazepam', 'Vỉ'),
('SP020', '1 ống mỗi ngày', 'Losartan', 'Ống'),
('SP021', '1 viên mỗi ngày', 'Fluoxetine', 'Hộp'),
('SP022', '1-2 viên mỗi 4-6 giờ', 'Aspirin', 'Hộp'),
('SP023', '1 viên mỗi ngày', 'Omeprazole', 'Hộp'),
('SP024', '1 viên mỗi ngày', 'Lisinopril', 'Vỉ'),
('SP025', '1 ống mỗi ngày', 'Escitalopram', 'Ống'),
('SP026', '1 viên mỗi ngày', 'Atorvastatin', 'Hộp'),
('SP027', '1 viên mỗi 4-6 giờ', 'Loperamide', 'Vỉ'),
('SP028', '1 viên mỗi ngày', 'Prednisone', 'Vỉ'),
('SP029', '1 ống mỗi 4-6 giờ', 'Morphine', 'Ống'),
('SP030', '1 viên mỗi ngày', 'Metoprolol', 'Vỉ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `patient`
--

CREATE TABLE `patient` (
  `patientID` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `yearOfBirth` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `patient`
--

INSERT INTO `patient` (`patientID`, `address`, `gender`, `name`, `phone`, `yearOfBirth`) VALUES
('001', '35 đường số 4, Trường Thọ, Thủ Đức', b'1', 'Nguyễn Văn Hiếu', '0798631497', 2001),
('002', 'Trần Phú, Phủ Hà, Quận 12', b'1', 'Nguyễn Trường Đình', '0163149752', 2001),
('003', 'KTX A Nông Lâm, Linh Trung, Thủ Đức', b'1', 'Trần Đình Danh', '0786951463', 2001),
('004', 'Làng đại học, Linh Trung, Thủ Đức', b'1', 'Nguyễn Hoàng Đức', '0335942367', 2001),
('005', 'Làng đại học, Linh Trung, Thủ Đức', b'0', 'Nguyễn Văn Minh', '0339741358', 2001);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `prescription`
--

CREATE TABLE `prescription` (
  `prescriptionID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `prescription_medicine`
--

CREATE TABLE `prescription_medicine` (
  `id` varchar(255) NOT NULL,
  `dosage` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `medicineID` varchar(255) DEFAULT NULL,
  `prescriptionID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `visit`
--

CREATE TABLE `visit` (
  `visitID` varchar(255) NOT NULL,
  `appointmentDate` datetime(6) DEFAULT NULL,
  `conclusion` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `symptom` varchar(255) DEFAULT NULL,
  `prescriptionID` varchar(255) DEFAULT NULL,
  `patientID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`medicineID`);

--
-- Chỉ mục cho bảng `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`);

--
-- Chỉ mục cho bảng `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`prescriptionID`);

--
-- Chỉ mục cho bảng `prescription_medicine`
--
ALTER TABLE `prescription_medicine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj33yx8ajia8l6l5od9h84k5y9` (`medicineID`),
  ADD KEY `FKeoep0n8h8yg8swcplt3dxe9q5` (`prescriptionID`);

--
-- Chỉ mục cho bảng `visit`
--
ALTER TABLE `visit`
  ADD PRIMARY KEY (`visitID`),
  ADD KEY `FKdjlf65xgbim9qyjotxfve8xrr` (`prescriptionID`),
  ADD KEY `FKo65a5evx714q4fw3myc7ei5c4` (`patientID`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `prescription_medicine`
--
ALTER TABLE `prescription_medicine`
  ADD CONSTRAINT `FKeoep0n8h8yg8swcplt3dxe9q5` FOREIGN KEY (`prescriptionID`) REFERENCES `prescription` (`prescriptionID`),
  ADD CONSTRAINT `FKj33yx8ajia8l6l5od9h84k5y9` FOREIGN KEY (`medicineID`) REFERENCES `medicine` (`medicineID`);

--
-- Các ràng buộc cho bảng `visit`
--
ALTER TABLE `visit`
  ADD CONSTRAINT `FKdjlf65xgbim9qyjotxfve8xrr` FOREIGN KEY (`prescriptionID`) REFERENCES `prescription` (`prescriptionID`),
  ADD CONSTRAINT `FKo65a5evx714q4fw3myc7ei5c4` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
