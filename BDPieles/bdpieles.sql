-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-05-2018 a las 23:25:18
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdpieles`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abono`
--

CREATE TABLE `abono` (
  `idabono` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `fechaabono` date NOT NULL,
  `abono` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `abono`
--

INSERT INTO `abono` (`idabono`, `idcliente`, `descripcion`, `fechaabono`, `abono`) VALUES
(8, 4, 'mashtate', '2018-05-04', '64.89'),
(9, 4, 'matarilerilero', '2018-05-18', '76.40'),
(10, 4, 'purrums', '2018-05-05', '34.65'),
(11, 5, 'Grrrra!', '2018-05-03', '2000.00'),
(12, 5, 'guaca guaca', '2018-05-04', '23.80'),
(13, 5, 'waka waka eh eh!', '2018-05-04', '7.00'),
(14, 5, 'En paz', '2018-05-11', '860.00'),
(15, 4, 'para dejarlo parejo', '2018-05-04', '9.06'),
(16, 4, 'dfas', '2018-05-04', '500.00'),
(17, 3, 'Tu primera vez', '2018-05-04', '501.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idpersona` int(11) NOT NULL,
  `nit` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idpersona`, `nit`) VALUES
(3, '65432'),
(4, '54322'),
(5, '543232'),
(6, '65432'),
(7, '58490');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `iddetalleventa` int(11) NOT NULL,
  `idventa` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `medida` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`iddetalleventa`, `idventa`, `idproducto`, `medida`, `subtotal`) VALUES
(1, 1, 2, '8.90', '1335.00'),
(2, 1, 3, '8.45', '59.15'),
(3, 1, 1, '79.33', '396.65'),
(4, 3, 2, '3.30', '495.00'),
(5, 3, 2, '7.56', '1134.00'),
(6, 3, 3, '7.00', '49.00'),
(7, 3, 1, '54.00', '270.00'),
(8, 3, 1, '7.40', '37.00'),
(9, 4, 2, '3.54', '531.00'),
(10, 4, 1, '54.00', '270.00'),
(11, 2, 2, '34.00', '5100.00'),
(12, 12, 4, '6.00', '195.60'),
(13, 15, 4, '7.00', '228.20'),
(14, 14, 2, '4.00', '600.00'),
(15, 10, 5, '5.00', '675.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idpersona` int(11) NOT NULL,
  `acceso` varchar(15) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idpersona`, `acceso`, `login`, `password`, `estado`) VALUES
(1, 'Administrador', 'admin', 'admin123', 'A'),
(2, 'Digitador', 'digitador', 'digitador123', 'D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `email` varchar(25) NOT NULL,
  `direccion` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idpersona`, `nombre`, `apellido`, `telefono`, `email`, `direccion`) VALUES
(1, 'Alan', 'Itzep', 'Perez', 'alternativo61@hotmail.com', 'Ciudad'),
(2, 'Pancho ', 'Villa', '76543236', 'elorto@banbros.com', 'Hidalgo'),
(3, 'Jorgito ', 'El curioso', '12345678', 'perlas@gsmd.com', 'Paris'),
(4, 'Yailyn', 'De Leon', '853829', 'ysik.cds@sgdl.com', 'Satelite'),
(5, 'Humberto', 'Carrera', '55637364', 'dhuenm@gmail.com', 'Oman'),
(6, 'Peter', 'Pan', '54096482', 'dshfds.sd@dgm.com', 'Tijuana love'),
(7, 'Tecun', 'Uman', '58673940', 'dsfod.ds@hotm.com', 'Quiche');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `precioventa` decimal(10,2) NOT NULL,
  `preciocosto` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `nombre`, `descripcion`, `precioventa`, `preciocosto`) VALUES
(1, 'Galleta Chiky', 'Cubierta de Chocolate', '5.00', '1.00'),
(2, 'Mouse ', 'Optico, Inalambrico', '150.00', '89.00'),
(3, 'Del Frutal', 'Jugo sabor a fruta', '7.00', '3.00'),
(4, 'AXE', 'Deshodorante', '32.60', '4.65'),
(5, 'Progreso', 'Cementos', '135.00', '40.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idempleado` int(11) NOT NULL,
  `fechaventa` date NOT NULL,
  `totalmedida` decimal(10,2) NOT NULL,
  `totalventa` decimal(10,2) NOT NULL,
  `tipopago` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idventa`, `idcliente`, `idempleado`, `fechaventa`, `totalmedida`, `totalventa`, `tipopago`) VALUES
(1, 5, 1, '2018-04-30', '96.68', '1790.80', 'Efectivo'),
(2, 5, 1, '2018-04-30', '34.00', '5100.00', 'Efectivo'),
(3, 4, 1, '2018-05-02', '79.26', '1985.00', 'Efectivo'),
(4, 3, 1, '2018-05-11', '57.54', '801.00', 'Efectivo'),
(9, 6, 1, '2018-05-03', '0.00', '0.00', 'Efectivo'),
(10, 7, 1, '2018-05-04', '0.00', '0.00', 'Efectivo'),
(11, 6, 1, '2018-05-13', '0.00', '0.00', 'Cheque'),
(12, 7, 1, '2018-05-18', '0.00', '0.00', 'Efectivo'),
(13, 6, 1, '2018-05-18', '0.00', '0.00', 'Efectivo'),
(14, 7, 1, '2018-04-30', '4.00', '600.00', 'Efectivo'),
(15, 3, 1, '2018-04-30', '0.00', '0.00', 'Efectivo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abono`
--
ALTER TABLE `abono`
  ADD PRIMARY KEY (`idabono`),
  ADD KEY `fk_abono_cliente1_idx` (`idcliente`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`iddetalleventa`),
  ADD KEY `fk_venta_detalleventa1_idx` (`idventa`),
  ADD KEY `fk_detalleventa_producto1_idx` (`idproducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idproducto`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idventa`),
  ADD KEY `fk_detalleventa_empleado1_idx` (`idempleado`),
  ADD KEY `fk_venta_cliente1_idx` (`idcliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abono`
--
ALTER TABLE `abono`
  MODIFY `idabono` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `iddetalleventa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idproducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idventa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `abono`
--
ALTER TABLE `abono`
  ADD CONSTRAINT `fk_abono_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_persona` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `fk_detalleventa_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venta_detalleventa1` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_empleado_persona1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_detalleventa_empleado1` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venta_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
