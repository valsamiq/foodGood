-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-06-2018 a las 14:57:56
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `foodgood`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dish`
--

CREATE TABLE `dish` (
  `name` varchar(100) NOT NULL,
  `type` varchar(50) NOT NULL,
  `restaurant` varchar(150) NOT NULL,
  `price` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `dish`
--

INSERT INTO `dish` (`name`, `type`, `restaurant`, `price`) VALUES
('Aleix', 'thai', 'thaiGracia', '156.00'),
('fideos', 'thai', 'thaiGracia', '15.00'),
('PlatÃ³', 'Griego', 'thaiGracia', '180.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rate`
--

CREATE TABLE `rate` (
  `idrate` int(11) NOT NULL,
  `user` varchar(10) NOT NULL,
  `dish` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  `mark` int(2) NOT NULL,
  `comment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rate`
--

INSERT INTO `rate` (`idrate`, `user`, `dish`, `date`, `mark`, `comment`) VALUES
(1, 'balsamiq', 'fideos', '2018-06-14 09:37:44', 6, 'tan guenos, pero no tanto'),
(2, 'balsamiq', 'Aleix', '2018-06-14 09:46:38', 10, 'perfect tio'),
(3, 'admin', 'fideos', '2018-06-14 10:45:03', 2, 'avia una moska'),
(4, 'admin', 'Aleix', '2018-06-14 10:47:01', 10, 'a tope'),
(5, 'balsamiqvs', 'Aleix', '2018-06-14 13:48:20', 9, 'Perfect!');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant`
--

CREATE TABLE `restaurant` (
  `name` varchar(150) NOT NULL,
  `city` varchar(100) NOT NULL,
  `specialty` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `restaurant`
--

INSERT INTO `restaurant` (`name`, `city`, `specialty`) VALUES
('Aleix', 'Sant Celoni', 'thai'),
('thaiGracia', 'girona', 'thai');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `city` varchar(100) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(60) DEFAULT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`username`, `password`, `city`, `name`, `surname`, `type`) VALUES
('admin', 'admin', 'Barcelona', 'Admin', '', 1),
('balsamiq', 'admin', 'Sant Celoni', 'Aleix', 'Ibern', 0),
('balsamiqvs', 'admin', 'Sant Celoni', 'Aleix', 'Ibern', 0),
('kelvin', 'admin', 'addd', 'star', 'wars', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dish`
--
ALTER TABLE `dish`
  ADD PRIMARY KEY (`name`),
  ADD KEY `fk_dish_1_idx` (`restaurant`);

--
-- Indices de la tabla `rate`
--
ALTER TABLE `rate`
  ADD PRIMARY KEY (`idrate`),
  ADD KEY `fk_rate_1_idx` (`user`),
  ADD KEY `fk_rate_2_idx` (`dish`);

--
-- Indices de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`name`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `rate`
--
ALTER TABLE `rate`
  MODIFY `idrate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dish`
--
ALTER TABLE `dish`
  ADD CONSTRAINT `fk_dish_1` FOREIGN KEY (`restaurant`) REFERENCES `restaurant` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `rate`
--
ALTER TABLE `rate`
  ADD CONSTRAINT `fk_rate_1` FOREIGN KEY (`user`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_rate_2` FOREIGN KEY (`dish`) REFERENCES `dish` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
