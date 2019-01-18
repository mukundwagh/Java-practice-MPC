
create database mpcdb;


use  mpcdb;


--
-- Table structure for table `questionBank`
--

CREATE TABLE `MpcDetails` (
  `HiringID` int(4) PRIMARY KEY,
  `Domain` varchar(100) DEFAULT NULL,
  `ObjectiveScore` int(3) DEFAULT NULL, 	 
  `SubjectiveScore` int(3) DEFAULT NULL,
	`Passed_In` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Dumping data for table `questionBank`
--



INSERT INTO `MpcDetails` VALUES
(608,'Java',56,89,'MPC_1'),
(609,'Cpp',72,61,'MPC_2'),
(706,'Dot_Net',56,51,'MPC_1'),
(604,'Java',78,91,'MPC_2'),
(564,'Dot_Net',40,59,'MPC_2'),
(887,'Cpp',26,59,'MPC_2'),
(882,'Java',50,69,'MPC_1'),
(103,'Java',67,78,'MPC_2'),
(705,'Java',24,78,'MPC_2');


