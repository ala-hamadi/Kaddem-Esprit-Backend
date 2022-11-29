-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2022 at 06:54 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `springdbf`
--

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `id_contract` int(11) NOT NULL,
  `archived` bit(1) NOT NULL,
  `contract_amount` int(11) NOT NULL,
  `contract_end_date` date DEFAULT NULL,
  `contract_start_date` date DEFAULT NULL,
  `specialty` varchar(255) DEFAULT NULL,
  `student_id_student` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`id_contract`, `archived`, `contract_amount`, `contract_end_date`, `contract_start_date`, `specialty`, `student_id_student`) VALUES
(1, b'1', 1000, '2022-10-31', '2022-10-01', 'IA', 1);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id_dept` int(11) NOT NULL,
  `name_dept` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id_dept`, `name_dept`) VALUES
(1, 'Informatique');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id_student` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `option` varchar(255) DEFAULT NULL,
  `department_id_dept` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id_student`, `first_name`, `last_name`, `option`, `department_id_dept`) VALUES
(1, 'Mohamed', 'Oues', 'SIM', 1),
(2, 'Mohamed', 'Oues', 'SIM', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `student_teams`
--

CREATE TABLE `student_teams` (
  `students_id_student` int(11) NOT NULL,
  `teams_id_team` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_teams`
--

INSERT INTO `student_teams` (`students_id_student`, `teams_id_team`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `id_team` int(11) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `name_team` varchar(255) DEFAULT NULL,
  `team_detail_id_team_detail` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`id_team`, `level`, `name_team`, `team_detail_id_team_detail`) VALUES
(1, 1, 'next gen lengend', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `team_detail`
--

CREATE TABLE `team_detail` (
  `id_team_detail` int(11) NOT NULL,
  `room` int(11) NOT NULL,
  `subject` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

CREATE TABLE `university` (
  `id_univ` int(11) NOT NULL,
  `name_univ` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `university`
--

INSERT INTO `university` (`id_univ`, `name_univ`) VALUES
(1, 'ISAMM'),
(2, 'Esprit'),
(3, 'ISI');

-- --------------------------------------------------------

--
-- Table structure for table `university_departments`
--

CREATE TABLE `university_departments` (
  `university_id_univ` int(11) NOT NULL,
  `departments_id_dept` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `university_departments`
--

INSERT INTO `university_departments` (`university_id_univ`, `departments_id_dept`) VALUES
(1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`id_contract`),
  ADD KEY `FKl9dhsi799rsf8y6e4pmq9meaj` (`student_id_student`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id_dept`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id_student`),
  ADD KEY `FKjgxn0hkjf58bhkw8351hnycvj` (`department_id_dept`);

--
-- Indexes for table `student_teams`
--
ALTER TABLE `student_teams`
  ADD PRIMARY KEY (`students_id_student`,`teams_id_team`),
  ADD KEY `FKl1mn0pxbrodk58uxh51d33kym` (`teams_id_team`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id_team`),
  ADD KEY `FKqic69hts966j4b6dug3ixcjuq` (`team_detail_id_team_detail`);

--
-- Indexes for table `team_detail`
--
ALTER TABLE `team_detail`
  ADD PRIMARY KEY (`id_team_detail`);

--
-- Indexes for table `university`
--
ALTER TABLE `university`
  ADD PRIMARY KEY (`id_univ`);

--
-- Indexes for table `university_departments`
--
ALTER TABLE `university_departments`
  ADD PRIMARY KEY (`university_id_univ`,`departments_id_dept`),
  ADD UNIQUE KEY `UK_jqrw0u4hg980p23ayws13bx8a` (`departments_id_dept`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contract`
--
ALTER TABLE `contract`
  MODIFY `id_contract` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id_dept` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id_student` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `id_team` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `team_detail`
--
ALTER TABLE `team_detail`
  MODIFY `id_team_detail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `university`
--
ALTER TABLE `university`
  MODIFY `id_univ` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
