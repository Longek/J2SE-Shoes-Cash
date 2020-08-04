-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 17, 2020 at 02:55 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_shoescash`
--
CREATE DATABASE IF NOT EXISTS `db_shoescash` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_shoescash`;

-- --------------------------------------------------------

--
-- Table structure for table `getfree`
--

CREATE TABLE `getfree` (
  `id_promo` varchar(100) NOT NULL,
  `id_product` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `getfree`
--

INSERT INTO `getfree` (`id_promo`, `id_product`) VALUES
('PR008', 'SH001'),
('PR008', 'SH003'),
('PR008', 'SH004'),
('PR009', 'SH008'),
('PR010', 'SH008'),
('PR006', 'SH009'),
('PR008', 'SH010'),
('PR006', 'SH013'),
('PR008', 'SH015'),
('PR008', 'SH019'),
('PR006', 'SH020'),
('PR008', 'SH020');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id_product` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `descr` varchar(100) NOT NULL,
  `size` int(100) NOT NULL,
  `capital` int(100) NOT NULL,
  `price` int(100) NOT NULL,
  `stock` int(100) NOT NULL,
  `updateAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id_product`, `brand`, `type`, `descr`, `size`, `capital`, `price`, `stock`, `updateAt`) VALUES
('SH001', 'Vans', 'Balck Widown', '-', 39, 230000, 330000, 2, '2020-06-16 01:11:08'),
('SH002', 'Vans', 'Balck Widown', '-', 40, 260000, 350000, 2, '2020-06-16 01:11:08'),
('SH003', 'Vans', 'Balck Widown', '-', 41, 200000, 270000, 1, '2020-06-16 01:11:08'),
('SH004', 'Vans', 'Balck Widown', '-', 42, 210000, 290000, 6, '2020-06-16 01:11:08'),
('SH005', 'Vans', 'Chees Stop', '-', 37, 237000, 330000, 0, '2020-06-16 01:11:08'),
('SH008', 'Vans', 'Chees Stop', '-', 39, 230000, 330000, 2, '2020-06-16 01:11:08'),
('SH009', 'Vans', 'Chees Stop', '-', 40, 230000, 300000, 3, '2020-06-16 01:11:08'),
('SH010', 'AllStar', 'Styleme', '-', 39, 270000, 310000, 3, '2020-06-16 01:11:08'),
('SH011', 'AllStar', 'Styleme', '-', 40, 275000, 320000, 4, '2020-06-16 01:11:08'),
('SH012', 'AllStar', 'Styleme', '-', 41, 250000, 300000, 4, '2020-06-16 01:11:08'),
('SH013', 'GMX', 'Blood Shecker', 'New Edition', 39, 330000, 450000, 9, '2020-06-17 01:17:42'),
('SH015', 'Vans', 'Limited Edition', 'import from UK', 37, 410000, 530000, 6, '2020-06-16 01:11:08'),
('SH016', 'Vans', 'Limited Edition', 'import from UK', 38, 390000, 500000, 2, '2020-06-16 01:11:08'),
('SH017', 'Ardiles', 'Red White', '-', 39, 190000, 270000, 2, '2020-06-16 01:11:08'),
('SH018', 'Ardiles', 'Full White', '-', 39, 230000, 330000, 4, '2020-06-16 01:11:08'),
('SH019', 'GeoffMax', 'Black', 'Limited Edition', 39, 200000, 250000, 6, '2020-06-16 01:11:08'),
('SH020', 'Vans', 'Black', '-', 38, 280000, 330000, 3, '2020-06-16 01:11:08'),
('SH021', 'Vans', 'Limited Edition', 'Terbatas', 30, 270000, 300000, 3, '2020-06-16 01:11:08'),
('SH023', 'AllStart', 'slim', '-', 20, 220000, 300000, 9, '2020-06-16 01:17:40'),
('SH024', 'Vans', 'Casual', '-', 29, 200000, 300000, 10, '2020-06-17 01:17:04'),
('SH025', 'Vans', 'Casual', '-', 30, 300000, 400000, 10, '2020-06-17 01:17:23'),
('SH026', 'GeofMaxx', 'tipe', '-', 30, 300000, 300000, 10, '2020-06-17 02:49:02'),
('SH027', 'GeofMaxx', 'tipe', '-', 30, 100000, 200000, 3, '2020-06-17 02:49:16');

-- --------------------------------------------------------

--
-- Table structure for table `profit`
--

CREATE TABLE `profit` (
  `no` int(11) NOT NULL,
  `date` date NOT NULL,
  `trans_today` int(100) NOT NULL,
  `trans_total` int(100) NOT NULL,
  `sold_today` int(100) NOT NULL,
  `sold_total` int(100) NOT NULL,
  `admission_fee_today` int(100) NOT NULL,
  `admission_fee_total` int(100) NOT NULL,
  `capital` int(100) NOT NULL,
  `income_today` int(100) NOT NULL,
  `income_total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `profit`
--

INSERT INTO `profit` (`no`, `date`, `trans_today`, `trans_total`, `sold_today`, `sold_total`, `admission_fee_today`, `admission_fee_total`, `capital`, `income_today`, `income_total`) VALUES
(1, '2020-03-09', 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, '2020-03-10', 6, 6, 32, 32, 11410000, 11410000, 8620000, 2790000, 2790000),
(3, '2020-03-11', 2, 8, 5, 37, 2400000, 13810000, 10390000, 630000, 3420000),
(5, '2020-04-07', 2, 10, 4, 41, 1340000, 15150000, 11340000, 390000, 3810000),
(6, '2020-05-27', 1, 11, 101010, 101051, 20000, 15170000, 11360000, 0, 3810000);

-- --------------------------------------------------------

--
-- Table structure for table `promo`
--

CREATE TABLE `promo` (
  `id_promo` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` enum('discount','getfree') NOT NULL,
  `discount` int(100) NOT NULL DEFAULT '0',
  `max_get_discount` int(100) NOT NULL DEFAULT '0',
  `min_buy` int(100) NOT NULL DEFAULT '0',
  `min_items` int(100) NOT NULL DEFAULT '0',
  `free_lots` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `promo`
--

INSERT INTO `promo` (`id_promo`, `name`, `type`, `discount`, `max_get_discount`, `min_buy`, `min_items`, `free_lots`) VALUES
('PR001', 'Open House', 'discount', 22, 200000, 700000, 0, 0),
('PR002', 'Happy Shoes', 'discount', 15, 200000, 600000, 0, 0),
('PR005', 'the winer', 'discount', 20, 0, 0, 0, 0),
('PR006', 'combo discount and free', 'getfree', 0, 300000, 500000, 5, 2),
('PR007', 'Diskon 20%', 'discount', 20, 20, 20, 20, 20),
('PR008', 'beli 2 dapat 1', 'getfree', 0, 0, 200000, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tes`
--

CREATE TABLE `tes` (
  `a` int(11) NOT NULL,
  `b` varchar(100) NOT NULL,
  `c` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `d` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id_trans` varchar(100) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tot_sold` int(100) NOT NULL,
  `promo` varchar(100) DEFAULT NULL,
  `discount` int(100) DEFAULT NULL,
  `tot_capital` int(100) NOT NULL,
  `pay` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id_trans`, `datetime`, `tot_sold`, `promo`, `discount`, `tot_capital`, `pay`) VALUES
('TR001', '2020-03-09 20:08:07', 16, 'PR003', 0, 3970000, 5290000),
('TR002', '2020-03-09 20:18:07', 6, NULL, 0, 1450000, 1830000),
('TR003', '2020-03-09 20:28:07', 1, NULL, 0, 230000, 330000),
('TR004', '2020-03-09 20:38:07', 3, 'PR001', 200000, 1310000, 1540000),
('TR005', '2020-03-09 20:48:07', 2, NULL, 0, 460000, 660000),
('TR006', '2020-03-09 20:58:07', 4, NULL, 0, 1200000, 1760000),
('TR007', '2020-03-11 01:52:14', 3, NULL, 0, 1310000, 1740000),
('TR008', '2020-03-11 01:54:44', 2, NULL, 0, 460000, 660000),
('TR009', '2020-04-07 04:04:02', 2, NULL, 0, 490000, 680000),
('TR010', '2020-04-07 04:11:50', 2, NULL, 0, 460000, 660000),
('TR011', '2020-05-27 13:42:47', 101010, NULL, NULL, 20000, 20000);

--
-- Triggers `transaction`
--
DELIMITER $$
CREATE TRIGGER `after_tranasction_insert_to_profit` AFTER INSERT ON `transaction` FOR EACH ROW BEGIN
DECLARE nox INT;
DECLARE datex DATE;
DECLARE trans_totx INT;
DECLARE sold_totx INT;
DECLARE adm_fee_totx INT;
DECLARE capx INT;
DECLARE income_totx INT;
DECLARE this_income INT;
DECLARE fill INT;

SELECT no INTO nox FROM profit ORDER BY no DESC LIMIT 1;
SELECT date INTO datex FROM profit ORDER BY no DESC LIMIT 1;
SELECT trans_total INTO trans_totx FROM profit ORDER BY no DESC LIMIT 1;
SELECT sold_total INTO sold_totx FROM profit ORDER BY no DESC LIMIT 1;
SELECT admission_fee_total INTO adm_fee_totx FROM profit ORDER BY no DESC LIMIT 1;
SELECT capital INTO capx FROM profit ORDER BY no DESC LIMIT 1;
SELECT income_total INTO income_totx FROM profit ORDER BY no DESC LIMIT 1;

SET this_income = NEW.pay - NEW.tot_capital;
SELECT no INTO fill FROM profit WHERE date=date(NEW.datetime);
IF (fill > 0 ) THEN
UPDATE profit SET trans_today = trans_today + 1,
trans_total = trans_total + 1,
sold_today = sold_today + NEW.tot_sold,
sold_total = sold_total + NEW.tot_sold,
admission_fee_today = admission_fee_today + NEW.pay,
admission_fee_total = admission_fee_total + NEW.pay,
capital = capital + NEW.tot_capital,
income_today = income_today + this_income,
income_total = income_total + this_income WHERE no = fill;
ELSE
INSERT INTO profit VALUES
( null, date(NEW.datetime), 
1, (trans_totx + 1), 
NEW.tot_sold, (sold_totx + NEW.tot_sold),
NEW.pay, (adm_fee_totx + NEW.pay), 
(capx + NEW.tot_capital), this_income, 
(income_totx + this_income));
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `trans_detail`
--

CREATE TABLE `trans_detail` (
  `id_trans` varchar(100) NOT NULL,
  `id_product` varchar(100) NOT NULL,
  `amount` int(100) NOT NULL,
  `sub_capital` int(100) NOT NULL,
  `sub_total` int(100) NOT NULL,
  `is_free` enum('1','0') NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trans_detail`
--

INSERT INTO `trans_detail` (`id_trans`, `id_product`, `amount`, `sub_capital`, `sub_total`, `is_free`) VALUES
('TR001', 'SH001', 5, 150000, 165000, '0'),
('TR001', 'SH003', 1, 200000, 0, '1'),
('TR001', 'SH016', 2, 780000, 100000, '0'),
('TR001', 'SH018', 8, 1840000, 2640000, '0'),
('TR002', 'SH004', 1, 210000, 290000, '0'),
('TR002', 'SH009', 3, 690000, 900000, '0'),
('TR002', 'SH011', 2, 550000, 640000, '0'),
('TR003', 'SH001', 1, 260000, 350000, '0'),
('TR004', 'SH002', 1, 260000, 350000, '0'),
('TR004', 'SH015', 2, 820000, 1060000, '0'),
('TR005', 'SH001', 2, 460000, 660000, '0'),
('TR006', 'SH010', 4, 1200000, 1760000, '0'),
('TR007', 'SH002', 1, 260000, 350000, '0'),
('TR007', 'SH015', 2, 820000, 1060000, '0'),
('TR008', 'SH001', 2, 460000, 660000, '0'),
('TR009', 'SH001', 1, 230000, 330000, '0'),
('TR009', 'SH002', 1, 260000, 350000, '0'),
('TR010', 'SH001', 2, 460000, 660000, '0'),
('TR011', 'SH001', 2, 90000, 900, '0');

--
-- Triggers `trans_detail`
--
DELIMITER $$
CREATE TRIGGER `after_trans_detail_insert_to_products` AFTER INSERT ON `trans_detail` FOR EACH ROW BEGIN
DECLARE lot INT;
SELECT stock INTO lot FROM products WHERE products.id_product = NEW.id_product;
UPDATE products SET stock = (lot - NEW.amount) WHERE products.id_product = NEW.id_product;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uname` varchar(100) NOT NULL,
  `paswd` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `lvl` varchar(100) NOT NULL,
  `jk` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uname`, `paswd`, `nama`, `lvl`, `jk`) VALUES
('dev', 'c4ca4238a0b923820dcc509a6f75849b', 'Big Boss', '', 'l'),
('in', 'c20ad4d76fe97759aa27a0c99bff6710', 'Admin Barang', 'inventori', 'l'),
('kas', 'c4ca4238a0b923820dcc509a6f75849b', 'Kasir Sepatu', 'kasir', 'p'),
('ow', 'c4ca4238a0b923820dcc509a6f75849b', 'Pemilik Toko', 'owner', 'l');

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_dettrans`
-- (See below for the actual view)
--
CREATE TABLE `v_dettrans` (
`datetime` timestamp
,`id_trans` varchar(100)
,`id_product` varchar(100)
,`NmSepatu` varchar(201)
,`size` int(100)
,`amount` int(100)
,`price` int(100)
,`Status` varchar(6)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_getfree`
-- (See below for the actual view)
--
CREATE TABLE `v_getfree` (
`id_promo` varchar(100)
,`id_product` varchar(100)
,`sepatu` varchar(201)
,`size` int(100)
,`price` int(100)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_sepatu`
-- (See below for the actual view)
--
CREATE TABLE `v_sepatu` (
`id_product` varchar(100)
,`sepatu` varchar(201)
,`descr` varchar(100)
,`size` int(100)
,`price` int(100)
,`stock` int(100)
);

-- --------------------------------------------------------

--
-- Structure for view `v_dettrans`
--
DROP TABLE IF EXISTS `v_dettrans`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_dettrans`  AS  select `transaction`.`datetime` AS `datetime`,`trans_detail`.`id_trans` AS `id_trans`,`trans_detail`.`id_product` AS `id_product`,concat(`products`.`brand`,' ',`products`.`type`) AS `NmSepatu`,`products`.`size` AS `size`,`trans_detail`.`amount` AS `amount`,`products`.`price` AS `price`,if((`trans_detail`.`is_free` = 1),'Free','Dibeli') AS `Status` from ((`trans_detail` join `products` on((`trans_detail`.`id_product` = `products`.`id_product`))) join `transaction` on((`trans_detail`.`id_trans` = `transaction`.`id_trans`))) order by `transaction`.`datetime` desc ;

-- --------------------------------------------------------

--
-- Structure for view `v_getfree`
--
DROP TABLE IF EXISTS `v_getfree`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_getfree`  AS  select `getfree`.`id_promo` AS `id_promo`,`getfree`.`id_product` AS `id_product`,concat(`products`.`brand`,' ',`products`.`type`) AS `sepatu`,`products`.`size` AS `size`,`products`.`price` AS `price` from (`getfree` join `products` on((`getfree`.`id_product` = `products`.`id_product`))) ;

-- --------------------------------------------------------

--
-- Structure for view `v_sepatu`
--
DROP TABLE IF EXISTS `v_sepatu`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_sepatu`  AS  select `products`.`id_product` AS `id_product`,concat(`products`.`brand`,' ',`products`.`type`) AS `sepatu`,`products`.`descr` AS `descr`,`products`.`size` AS `size`,`products`.`price` AS `price`,`products`.`stock` AS `stock` from `products` where (`products`.`stock` > 0) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `getfree`
--
ALTER TABLE `getfree`
  ADD PRIMARY KEY (`id_promo`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id_product`);

--
-- Indexes for table `profit`
--
ALTER TABLE `profit`
  ADD PRIMARY KEY (`no`);

--
-- Indexes for table `promo`
--
ALTER TABLE `promo`
  ADD PRIMARY KEY (`id_promo`);

--
-- Indexes for table `tes`
--
ALTER TABLE `tes`
  ADD PRIMARY KEY (`a`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id_trans`),
  ADD KEY `promo` (`promo`);

--
-- Indexes for table `trans_detail`
--
ALTER TABLE `trans_detail`
  ADD PRIMARY KEY (`id_trans`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uname`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `profit`
--
ALTER TABLE `profit`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tes`
--
ALTER TABLE `tes`
  MODIFY `a` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
