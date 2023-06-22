-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2023 lúc 02:25 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

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
                            `name` varchar(255) DEFAULT NULL,
                            `unit` varchar(255) DEFAULT NULL,
                            `defaultDosage` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `medicine`
--

INSERT INTO `medicine` (`medicineID`, `name`, `unit`, `defaultDosage`) VALUES
                                                                           ('SP001', 'Albuterol', 'Hũ', '1 viên mỗi 12 giờ'),
                                                                           ('SP002', 'Gabapentin', 'Ống', '2 ống mỗi ngày'),
                                                                           ('SP003', 'Amoxicillin', 'Ống', '1 ống mỗi 8 giờ'),
                                                                           ('SP005', 'Ibuprofen', 'Vỉ', '1 viên mỗi 6-8 giờ'),
                                                                           ('SP006', 'Venlafaxine', 'Vỉ', '1 viên mỗi ngày'),
                                                                           ('SP007', 'Pregabalin', 'Hộp', '1 viên mỗi tối'),
                                                                           ('SP008', 'Ranitidine', 'Ống', '1 ống mỗi 12 giờ'),
                                                                           ('SP009', 'Tramadol', 'Ống', '1 ống mỗi 4-6 giờ'),
                                                                           ('SP010', 'Simvastatin', 'Vỉ', '1 viên mỗi ngày'),
                                                                           ('SP011', 'Codeine', 'Hộp', '1 viên mỗi 4-6 giờ'),
                                                                           ('SP012', 'Sertraline', 'Vỉ', '1 viên mỗi ngày'),
                                                                           ('SP013', 'Oxycodone', 'Ống', '1 ống mỗi 4-6 giờ'),
                                                                           ('SP014', 'Cetirizine', 'Hộp', '1 viên mỗi ngày'),
                                                                           ('SP015', 'Paracetamol', 'Hộp', '1-2 viên mỗi 4-6 giờ'),
                                                                           ('SP016', 'Amlodipine', 'Ống', '1 ống mỗi ngày'),
                                                                           ('SP017', 'Citalopram', 'Hộp', '1 viên mỗi ngày'),
                                                                           ('SP018', 'Metformin', 'Ống', '1 ống mỗi bữa ăn'),
                                                                           ('SP019', 'Diazepam', 'Vỉ', '1-2 viên mỗi 6-8 giờ'),
                                                                           ('SP020', 'Losartan', 'Ống', '1 ống mỗi ngày'),
                                                                           ('SP021', 'Fluoxetine', 'Hộp', '1 viên mỗi ngày'),
                                                                           ('SP022', 'Aspirin', 'Hộp', '1-2 viên mỗi 4-6 giờ'),
                                                                           ('SP023', 'Omeprazole', 'Hộp', '1 viên mỗi ngày'),
                                                                           ('SP024', 'Lisinopril', 'Vỉ', '1 viên mỗi ngày'),
                                                                           ('SP025', 'Escitalopram', 'Ống', '1 ống mỗi ngày'),
                                                                           ('SP026', 'Atorvastatin', 'Hộp', '1 viên mỗi ngày'),
                                                                           ('SP027', 'Loperamide', 'Vỉ', '1 viên mỗi 4-6 giờ'),
                                                                           ('SP028', 'Prednisone', 'Vỉ', '1 viên mỗi ngày'),
                                                                           ('SP029', 'Morphine', 'Ống', '1 ống mỗi 4-6 giờ'),
                                                                           ('SP030', 'Metoprolol', 'Vỉ', '1 viên mỗi ngày');

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
                                                                                             ('001', '35 đường số 4, Trường Thọ, Thủ Đức', b'0', 'Nguyễn Văn Hiếu ngu', '0798631497', 2001),
                                                                                             ('002', 'Trần Phú, Phủ Hà, Quận 12', b'1', 'Nguyễn Trường Đình', '0163149752', 2001),
                                                                                             ('003', 'KTX A Nông Lâm, Linh Trung, Thủ Đức', b'1', 'Trần Đình Danh', '0786951463', 2001),
                                                                                             ('004', 'Làng đại học, Linh Trung, Thủ Đức', b'1', 'Nguyễn Hoàng Đức', '0335942367', 2001),
                                                                                             ('005', '123 abc', b'0', 'a', '123456789', 2001);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `prescription_medicine`
--

CREATE TABLE `prescription_medicine` (
                                         `id` varchar(255) NOT NULL,
                                         `dosage` varchar(255) DEFAULT NULL,
                                         `quantity` int(11) NOT NULL,
                                         `medicineID` varchar(255) DEFAULT NULL,
                                         `visitID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `prescription_medicine`
--

INSERT INTO `prescription_medicine` (`id`, `dosage`, `quantity`, `medicineID`, `visitID`) VALUES
                                                                                                                ('1', '1 viên mỗi 6-8 giờ', 10, 'SP005', '1'),
                                                                                                                ('2', '1 viên mỗi tối', 20, 'SP007', '1'),
                                                                                                                ('3', '1 ống mỗi 8 giờ', 20, 'SP003', '1'),
                                                                                                                ('4', '1 viên mỗi ngày', 40, 'SP006', '1'),
                                                                                                                ('5', '1 ống mỗi 4-6 giờ', 10, 'SP029', '2'),
                                                                                                                ('6', '1 viên mỗi ngày', 20, 'SP030', '2'),
                                                                                                                ('7', '1 viên mỗi 4-6 giờ', 30, 'SP027', '2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `visit`
--

CREATE TABLE `visit` (
                         `visitID` varchar(255) NOT NULL,
                         `conclusion` varchar(255) DEFAULT NULL,
                         `date` datetime(6) DEFAULT NULL,
                         `symptom` varchar(255) DEFAULT NULL,
                         `patientID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `visit`
--

INSERT INTO `visit` (`visitID`, `conclusion`, `date`, `symptom`, `patientID`) VALUES
                                                                                  ('1', ' ngu', '2023-06-20 17:57:12.000000', ' ngu', '005'),
                                                                                  ('2', ' đần', '2023-06-20 17:59:00.000000', ' đần	', '005');

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
-- Chỉ mục cho bảng `prescription_medicine`
--
ALTER TABLE `prescription_medicine`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKj33yx8ajia8l6l5od9h84k5y9` (`medicineID`),
  ADD KEY `FKamkaw38ckmsj30492hvd2mdjp` (`visitID`);

--
-- Chỉ mục cho bảng `visit`
--
ALTER TABLE `visit`
    ADD PRIMARY KEY (`visitID`),
  ADD KEY `FKo65a5evx714q4fw3myc7ei5c4` (`patientID`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `prescription_medicine`
--
ALTER TABLE `prescription_medicine`
  ADD CONSTRAINT `FKamkaw38ckmsj30492hvd2mdjp` FOREIGN KEY (`visitID`) REFERENCES `visit` (`visitID`),
  ADD CONSTRAINT `FKj33yx8ajia8l6l5od9h84k5y9` FOREIGN KEY (`medicineID`) REFERENCES `medicine` (`medicineID`);

--
-- Các ràng buộc cho bảng `visit`
--
ALTER TABLE `visit`
    ADD CONSTRAINT `FKo65a5evx714q4fw3myc7ei5c4` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
