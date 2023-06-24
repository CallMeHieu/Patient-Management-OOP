-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 24, 2023 lúc 07:01 AM
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
                                                                           ('SP1', '1 viên mỗi 12 giờ', 'Albuterol', 'Hũ'),
                                                                           ('SP10', '1 viên mỗi ngày', 'Simvastatin', 'Vỉ'),
                                                                           ('SP11', '1 viên mỗi 4-6 giờ', 'Codeine', 'Hộp'),
                                                                           ('SP12', '1 viên mỗi ngày', 'Sertraline', 'Vỉ'),
                                                                           ('SP13', '1 ống mỗi 4-6 giờ', 'Oxycodone', 'Ống'),
                                                                           ('SP14', '1 viên mỗi ngày', 'Cetirizine', 'Hộp'),
                                                                           ('SP15', '1-2 viên mỗi 4-6 giờ', 'Paracetamol', 'Hộp'),
                                                                           ('SP16', '1 ống mỗi ngày', 'Amlodipine', 'Ống'),
                                                                           ('SP17', '1 viên mỗi ngày', 'Citalopram', 'Hộp'),
                                                                           ('SP18', '1 ống mỗi bữa ăn', 'Metformin', 'Ống'),
                                                                           ('SP19', '1-2 viên mỗi 6-8 giờ', 'Diazepam', 'Vỉ'),
                                                                           ('SP2', '2 ống mỗi ngày', 'Gabapentin', 'Ống'),
                                                                           ('SP20', '1 ống mỗi ngày', 'Losartan', 'Ống'),
                                                                           ('SP21', '1 viên mỗi ngày', 'Fluoxetine', 'Hộp'),
                                                                           ('SP22', '1-2 viên mỗi 4-6 giờ', 'Aspirin', 'Hộp'),
                                                                           ('SP23', '1 viên mỗi ngày', 'Omeprazole', 'Hộp'),
                                                                           ('SP24', '1 viên mỗi ngày', 'Lisinopril', 'Vỉ'),
                                                                           ('SP25', '1 ống mỗi ngày', 'Escitalopram', 'Ống'),
                                                                           ('SP26', '1 viên mỗi ngày', 'Atorvastatin', 'Hộp'),
                                                                           ('SP27', '1 viên mỗi 4-6 giờ', 'Loperamide', 'Vỉ'),
                                                                           ('SP28', '1 viên mỗi ngày', 'Prednisone', 'Vỉ'),
                                                                           ('SP29', '1 viên mỗi ngày', 'Metoprolol', 'Vỉ'),
                                                                           ('SP3', '1 ống mỗi 8 giờ', 'Amoxicillin', 'Ống'),
                                                                           ('SP4', '1 ống mỗi 4-6 giờ', 'Morphine', 'Ống'),
                                                                           ('SP5', '1 viên mỗi 6-8 giờ', 'Ibuprofen', 'Vỉ'),
                                                                           ('SP6', '1 viên mỗi ngày', 'Venlafaxine', 'Vỉ'),
                                                                           ('SP7', '1 viên mỗi tối', 'Pregabalin', 'Hộp'),
                                                                           ('SP8', '1 ống mỗi 12 giờ', 'Ranitidine', 'Ống'),
                                                                           ('SP9', '1 ống mỗi 4-6 giờ', 'Tramadol', 'Ống');

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
                                                                                             ('BN1', '34 đường số 4, phường Trường Thọ, thành phố Thủ Đức', b'1', 'Nguyễn Văn Hiêu', '0798631497', 2001),
                                                                                             ('BN2', 'phường Phủ Hà, thành phố Phan Rang Tháp Chàm', b'1', 'Nguyễn Trường Đình', '0123456789', 2001),
                                                                                             ('BN3', 'thị xã An Nhơn, Bình Định', b'1', 'Trần Đình Danh', '0987654321', 2001),
                                                                                             ('BN4', 'Đà Lạt, Lâm Đồng', b'1', 'Nguyễn Hoàng Đức', '0123789456', 2001),
                                                                                             ('BN5', 'Đồng Nai', b'1', 'Nguyễn Văn Minh', '0456321789', 2001),
                                                                                             ('BN6', 'An Nhơn, Bình Định', b'0', 'Trần Thi Danh', '0147258369', 2002);

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
                                                                                              ('1', '1 viên mỗi ngày', 4, 'SP14', '1'),
                                                                                              ('10', '1 ống mỗi 4-6 giờ', 4, 'SP9', '3'),
                                                                                              ('11', '1 viên mỗi 4-6 giờ', 9, 'SP11', '4'),
                                                                                              ('12', '1 viên mỗi ngày', 9, 'SP14', '4'),
                                                                                              ('13', '1 ống mỗi 4-6 giờ', 7, 'SP13', '5'),
                                                                                              ('14', '1 ống mỗi ngày', 6, 'SP20', '6'),
                                                                                              ('15', '1 viên mỗi ngày', 4, 'SP21', '6'),
                                                                                              ('2', '1 viên mỗi ngày', 9, 'SP26', '1'),
                                                                                              ('3', '1 ống mỗi 12 giờ', 1, 'SP8', '1'),
                                                                                              ('4', '1 viên mỗi ngày', 4, 'SP14', '2'),
                                                                                              ('5', '1 viên mỗi ngày', 9, 'SP26', '2'),
                                                                                              ('6', '1 ống mỗi 12 giờ', 1, 'SP8', '2'),
                                                                                              ('7', '1 viên mỗi 12 giờ', 9, 'SP1', '2'),
                                                                                              ('8', '1 viên mỗi ngày', 9, 'SP10', '2'),
                                                                                              ('9', '1 viên mỗi tối', 6, 'SP7', '3');

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
                                                                                  ('1', 'viêm họng', '2023-06-24 11:19:54.000000', 'ho, rát họng', 'BN2'),
                                                                                  ('2', 'vết thương ngoài da', '2023-06-24 11:25:45.000000', 'trầy, nhiễm trùng', 'BN2'),
                                                                                  ('3', 'sử dụng quá nhiều rượu bia', '2023-06-24 11:45:12.000000', 'đau đầu, buồn nôn', 'BN3'),
                                                                                  ('4', 'căng thẳng dẫn đến stress', '2023-06-24 11:48:25.000000', 'rụn tóc, mất ngủ', 'BN6'),
                                                                                  ('5', 'Thiếu ngủ', '2023-06-24 11:58:43.000000', 'Uể oải, mất ngủ', 'BN1'),
                                                                                  ('6', 'thoái hóa sương khớp', '2023-06-24 12:00:50.000000', 'đau lưng, mỏi gối', 'BN4');

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
