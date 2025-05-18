-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 18, 2025 at 10:50 AM
-- Server version: 8.4.3
-- PHP Version: 8.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `systurismo`
--

-- --------------------------------------------------------

--
-- Table structure for table `actividad`
--

CREATE TABLE `actividad` (
  `id_actividad` bigint NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `actividad`
--

INSERT INTO `actividad` (`id_actividad`, `nombre`, `descripcion`, `precio`, `id_destino`) VALUES
(1, 'Paseo en Balsa - Editado', 'Nuevo recorrido', 35, 1),
(2, 'Visita Cultural', 'Exploración de tradiciones y costumbres', 50, 2),
(13, 'r', '', 0, 27);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` bigint NOT NULL,
  `nombre_completo` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre_completo`, `correo`, `telefono`, `direccion`) VALUES
(1, 'Juan Pérez', 'juan@gmail.com', '987654321', 'Av. Principal 123'),
(2, 'Ana Barrios', 'ana@gmail.com', '912345678', 'Jirn la Paz'),
(10, 'Mara Ramirez', 'mara@gmail.com', '976543234', 'Pirmides');

-- --------------------------------------------------------

--
-- Table structure for table `destino`
--

CREATE TABLE `destino` (
  `id_destino` bigint NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `destino`
--

INSERT INTO `destino` (`id_destino`, `nombre`, `descripcion`, `ubicacion`, `imagen_path`) VALUES
(1, 'Isla Isañata Capachica act', 'Hermosa isla en el lago Titicaca', 'Puno, Perú', 'content://com.google.android.apps.docs.storage/document/acc%3D1%3Bdoc%3Dencoded%3DXke8_XT_Q7CAZN1OlMeFLGfsCRAVZfm7cHvt8MOwJmSSsQ176oP7Olk%3D'),
(2, 'Isla Tikonata Capachica', 'Cultura viva en el lago', 'Capachica, Puno, Perú', 'content://com.google.android.apps.docs.storage/document/acc%3D1%3Bdoc%3Dencoded%3DXke8_XT_Q7CAZN1OlMeFLGfsCRAVZfm7cHvt8MOwJmSSsQ176oP7Olk%3D'),
(15, 'Isla Prueba', 'Isla', 'Capachica, Puno', 'content://com.google.android.apps.docs.storage/document/acc%3D1%3Bdoc%3Dencoded%3DXke8_XT_Q7CAZN1OlMeFLGfsCRAVZfm7cHvt8MOwJmSSsQ176oP7Olk%3D'),
(18, 'ftgyh', 'rftgy', 'rftgyh', 'content://com.google.android.apps.docs.storage/document/acc%3D1%3Bdoc%3Dencoded%3DXke8_XT_Q7CAZN1OlMeFLGfsCRAVZfm7cHvt8MOwJmSSsQ176oP7Olk%3D'),
(22, 'pru', 'des', 'tfghj', '/imagenes/destinos/1747533214551_temp_image816932070564273441.tmp'),
(23, 'ej', 'ej', 'ej', '/imagenes/destinos/1747533305768_temp_image1234048405022805868.tmp'),
(27, 'ftugyvgj', 'vghvyh', 'gyhgyhujybhjghuy', '/imagenes/destinos/1747564907267_temp_image8621481576224451656.tmp');

-- --------------------------------------------------------

--
-- Table structure for table `hospedaje`
--

CREATE TABLE `hospedaje` (
  `id_hospedaje` bigint NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio_por_noche` double DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hospedaje`
--

INSERT INTO `hospedaje` (`id_hospedaje`, `nombre`, `descripcion`, `precio_por_noche`, `id_destino`) VALUES
(1, 'Hospedaje Isañata', 'Habitaciones familiares', 100, 1),
(2, 'Hostal Tikonata', 'Hospedaje tradicional en Tikonata', 80, 2),
(3, 'Hospedaje Isañata', 'Habitaciones familiares', 100, 1),
(4, 'Hostal Tikonata', 'Hospedaje tradicional en Tikonata', 80, 2);

-- --------------------------------------------------------

--
-- Table structure for table `inventario`
--

CREATE TABLE `inventario` (
  `id_inventario` bigint NOT NULL,
  `nombre_item` varchar(255) DEFAULT NULL,
  `cantidad_disponible` int DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario`
--

INSERT INTO `inventario` (`id_inventario`, `nombre_item`, `cantidad_disponible`, `id_destino`) VALUES
(1, 'Balsas de Totora', 5, 1),
(2, 'Ropa Tradicional', 10, 2);

-- --------------------------------------------------------

--
-- Table structure for table `pago`
--

CREATE TABLE `pago` (
  `id_pago` bigint NOT NULL,
  `monto` double DEFAULT NULL,
  `metodo_pago` varchar(255) DEFAULT NULL,
  `fecha_pago` timestamp NULL DEFAULT NULL,
  `id_reserva` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pago`
--

INSERT INTO `pago` (`id_pago`, `monto`, `metodo_pago`, `fecha_pago`, `id_reserva`) VALUES
(1, 200, 'VISA', '2025-04-30 10:39:18', 1),
(2, 150, 'Transferencia', '2025-04-30 10:39:18', 2);

-- --------------------------------------------------------

--
-- Table structure for table `paquete_actividad`
--

CREATE TABLE `paquete_actividad` (
  `id_paquete` bigint NOT NULL,
  `id_actividad` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_actividad`
--

INSERT INTO `paquete_actividad` (`id_paquete`, `id_actividad`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `paquete_turistico`
--

CREATE TABLE `paquete_turistico` (
  `id_paquete` bigint NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio_total` double DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_turistico`
--

INSERT INTO `paquete_turistico` (`id_paquete`, `nombre`, `descripcion`, `precio_total`, `id_destino`) VALUES
(1, 'Paquete Full Capachica', 'Visita completa a Capachica', 200, 1),
(2, 'Paquete Isañata Exprés', 'Tour rápido a Isla Isañata', 150, 2),
(3, 'Paquete Full Capachica', 'Visita completa a Capachica', 200, 1),
(4, 'Paquete Isañata Exprés', 'Tour rápido a Isla Isañata', 150, 2);

-- --------------------------------------------------------

--
-- Table structure for table `resena`
--

CREATE TABLE `resena` (
  `id_resena` bigint NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `calificacion` int DEFAULT NULL,
  `id_cliente` bigint DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `resena`
--

INSERT INTO `resena` (`id_resena`, `comentario`, `calificacion`, `id_cliente`, `id_destino`) VALUES
(1, '¡Excelente experiencia!', 5, 1, 1),
(2, 'Muy bonito pero algo cansado', 4, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` bigint NOT NULL,
  `fecha_reserva` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `numero_personas` int DEFAULT NULL,
  `id_cliente` bigint DEFAULT NULL,
  `id_paquete` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `fecha_reserva`, `fecha_inicio`, `fecha_fin`, `numero_personas`, `id_cliente`, `id_paquete`) VALUES
(1, '2025-05-01', '2025-05-05', '2025-05-07', 2, 1, 1),
(2, '2025-06-10', '2025-06-12', '2025-06-13', 3, 2, 2),
(3, '2025-05-01', '2025-05-05', '2025-05-07', 2, 1, 1),
(4, '2025-06-10', '2025-06-12', '2025-06-13', 3, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` bigint NOT NULL,
  `correo` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `rol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `correo`, `contraseña`, `rol`) VALUES
(1, 'admin@gmail.com', '$2a$10$gYvVkg444XONkGYoFXKCq.sWqsypynXuY5uAFvac/oVZFUOzFfKWq', 'ADMIN'),
(3, 'turista@gmail.com', '$2a$10$1/nRU/yY3xVLmdhrsoG1BuZrH6jdQhjC0//MeaY4ULtnd2xWoJTDS', 'CLIENTE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`id_actividad`),
  ADD KEY `id_destino` (`id_destino`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `destino`
--
ALTER TABLE `destino`
  ADD PRIMARY KEY (`id_destino`);

--
-- Indexes for table `hospedaje`
--
ALTER TABLE `hospedaje`
  ADD PRIMARY KEY (`id_hospedaje`),
  ADD KEY `id_destino` (`id_destino`);

--
-- Indexes for table `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id_inventario`),
  ADD KEY `id_destino` (`id_destino`);

--
-- Indexes for table `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `id_reserva` (`id_reserva`);

--
-- Indexes for table `paquete_actividad`
--
ALTER TABLE `paquete_actividad`
  ADD PRIMARY KEY (`id_paquete`,`id_actividad`),
  ADD KEY `id_actividad` (`id_actividad`);

--
-- Indexes for table `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  ADD PRIMARY KEY (`id_paquete`),
  ADD KEY `id_destino` (`id_destino`);

--
-- Indexes for table `resena`
--
ALTER TABLE `resena`
  ADD PRIMARY KEY (`id_resena`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_destino` (`id_destino`);

--
-- Indexes for table `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_paquete` (`id_paquete`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actividad`
--
ALTER TABLE `actividad`
  MODIFY `id_actividad` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `destino`
--
ALTER TABLE `destino`
  MODIFY `id_destino` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `hospedaje`
--
ALTER TABLE `hospedaje`
  MODIFY `id_hospedaje` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id_inventario` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pago`
--
ALTER TABLE `pago`
  MODIFY `id_pago` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  MODIFY `id_paquete` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `resena`
--
ALTER TABLE `resena`
  MODIFY `id_resena` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `actividad_ibfk_1` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);

--
-- Constraints for table `hospedaje`
--
ALTER TABLE `hospedaje`
  ADD CONSTRAINT `hospedaje_ibfk_1` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);

--
-- Constraints for table `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);

--
-- Constraints for table `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`);

--
-- Constraints for table `paquete_actividad`
--
ALTER TABLE `paquete_actividad`
  ADD CONSTRAINT `paquete_actividad_ibfk_1` FOREIGN KEY (`id_paquete`) REFERENCES `paquete_turistico` (`id_paquete`),
  ADD CONSTRAINT `paquete_actividad_ibfk_2` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`);

--
-- Constraints for table `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  ADD CONSTRAINT `paquete_turistico_ibfk_1` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);

--
-- Constraints for table `resena`
--
ALTER TABLE `resena`
  ADD CONSTRAINT `resena_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `resena_ibfk_2` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);

--
-- Constraints for table `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_paquete`) REFERENCES `paquete_turistico` (`id_paquete`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
