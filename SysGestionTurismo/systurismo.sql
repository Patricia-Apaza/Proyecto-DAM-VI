-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 23, 2025 at 01:03 PM
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
  `id_destino` bigint DEFAULT NULL,
  `nivel_riesgo` varchar(255) DEFAULT NULL,
  `whatsapp_contacto` varchar(255) DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `actividad`
--

INSERT INTO `actividad` (`id_actividad`, `nombre`, `descripcion`, `precio`, `id_destino`, `nivel_riesgo`, `whatsapp_contacto`, `imagen_path`) VALUES
(1, 'Paseo en Balsa - Editado', 'Nuevo recorrido', 35, 1, 'bajo', NULL, NULL),
(2, 'Visita Cultural', 'Exploración de tradiciones y costumbres', 50, 2, 'bajo', NULL, NULL),
(13, 'r', '', 0, 27, 'bajo', NULL, NULL),
(14, 'Escalada', 'Subida al cerro', 100, 1, 'alto', '937453278', '/imagenes/actividades/1747953167803_escalada.jpeg'),
(15, 'Ciclismo', 'Conocer el lugar ', 100, 1, 'Medio', '91234567', '/imagenes/actividades/1747996947129_ciclismo.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `checkin`
--

CREATE TABLE `checkin` (
  `id_checkin` bigint NOT NULL,
  `id_reserva` bigint NOT NULL,
  `tipo_reserva` varchar(30) NOT NULL,
  `fecha_checkin` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estado_checkin` tinyint(1) DEFAULT '1',
  `registrado_por` varchar(100) DEFAULT NULL,
  `observacion` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `checkin`
--

INSERT INTO `checkin` (`id_checkin`, `id_reserva`, `tipo_reserva`, `fecha_checkin`, `estado_checkin`, `registrado_por`, `observacion`) VALUES
(1, 1, 'hospedaje', '2025-05-22 07:50:38', 1, 'admin@correo.com', 'Check-in sin inconvenientes');

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE `checkout` (
  `id_checkout` bigint NOT NULL,
  `id_reserva` bigint NOT NULL,
  `tipo_reserva` varchar(30) NOT NULL,
  `fecha_checkout` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estado_checkout` tinyint(1) DEFAULT '1',
  `registrado_por` varchar(100) DEFAULT NULL,
  `observacion` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`id_checkout`, `id_reserva`, `tipo_reserva`, `fecha_checkout`, `estado_checkout`, `registrado_por`, `observacion`) VALUES
(1, 1, 'hospedaje', '2025-05-22 07:53:23', 1, 'admin@correo.com', 'Salida puntual, sin daños reportados');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` bigint NOT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `num_documento` varchar(255) DEFAULT NULL,
  `imagen_perfil` varchar(255) DEFAULT NULL,
  `whatsapp_contacto` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombres`, `apellidos`, `num_documento`, `imagen_perfil`, `whatsapp_contacto`, `correo`, `direccion`, `tipo_documento`) VALUES
(1, '', '', NULL, NULL, NULL, 'juan@gmail.com', 'Av. Principal 123', NULL),
(2, '', '', NULL, NULL, NULL, 'ana@gmail.com', 'Jirn la Paz', NULL),
(10, '', '', NULL, NULL, NULL, 'mara@gmail.com', 'Pirmides', NULL),
(11, 'Laura', 'Mendoza', '12345678', '/imagenes/clientes/1747958486726_perfil.png', '952394458', 'laura@gmail.com', 'Jr. San Martin', NULL),
(12, 'Laura', 'Mendoza', '12345678', '/imagenes/clientes/1747958995271_perfil.png', '952394458', 'laura@gmail.com', 'Jr. San Martin', 'DNI'),
(13, 'Kass', 'Bautista', '12345678', '/imagenes/clientes/1747995309252_perfil.png', '952394458', 'laura@gmail.com', 'Jr. San Martin', 'DNI'),
(14, 'Angeles', 'Rojas', '12345678', '/imagenes/clientes/1747996631534_perfil.png', '952394458', 'angeles@gmail.com', 'Jr. San Martin', 'DNI');

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
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio_por_noche` double DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL,
  `whatsapp_contacto` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hospedaje`
--

INSERT INTO `hospedaje` (`id_hospedaje`, `nombre`, `descripcion`, `precio_por_noche`, `id_destino`, `imagen_path`, `whatsapp_contacto`, `direccion`) VALUES
(1, 'Hospedaje Isañata', 'Habitaciones familiares', 100, 1, NULL, NULL, NULL),
(2, 'Hostal Tikonata', 'Hospedaje tradicional en Tikonata', 80, 2, NULL, NULL, NULL),
(3, 'Hospedaje Isañata', 'Habitaciones familiares', 100, 1, NULL, NULL, NULL),
(4, 'Hostal Tikonata', 'Hospedaje tradicional en Tikonata', 80, 2, NULL, NULL, NULL),
(5, 'Sol', 'Hospedaje rústico cerca del lago', 80, 1, '/imagenes/hospedajes/1747999194777_hospedaje.jpeg', '932456765', 'Av. Lago Titicaca 123');

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
-- Table structure for table `inventario_actividad`
--

CREATE TABLE `inventario_actividad` (
  `id_inventario_actividad` bigint NOT NULL,
  `id_actividad` bigint DEFAULT NULL,
  `nombre_actividad` varchar(100) NOT NULL,
  `fecha_sesion` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `capacidad_personas` int NOT NULL,
  `personas_registradas` int DEFAULT '0',
  `precio_por_persona` decimal(10,2) NOT NULL,
  `descripcion` text,
  `cantidad_disponible` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario_actividad`
--

INSERT INTO `inventario_actividad` (`id_inventario_actividad`, `id_actividad`, `nombre_actividad`, `fecha_sesion`, `hora_inicio`, `hora_fin`, `capacidad_personas`, `personas_registradas`, `precio_por_persona`, `descripcion`, `cantidad_disponible`) VALUES
(1, 1, 'Caminata ecológica', '2025-06-10', '08:00:00', '11:00:00', 20, 5, 25.00, 'Recorrido por senderos naturales guiado por expertos.', 15);

-- --------------------------------------------------------

--
-- Table structure for table `inventario_hospedaje`
--

CREATE TABLE `inventario_hospedaje` (
  `id_inventario_hospedaje` bigint NOT NULL,
  `id_hospedaje` bigint DEFAULT NULL,
  `tipo_cuarto` varchar(50) NOT NULL,
  `cantidad_total` int NOT NULL,
  `cantidad_disponible` int NOT NULL,
  `tipo_cama` varchar(50) DEFAULT NULL,
  `bano_privado` tinyint(1) DEFAULT '1',
  `precio_por_noche` decimal(10,2) NOT NULL,
  `descripcion` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario_hospedaje`
--

INSERT INTO `inventario_hospedaje` (`id_inventario_hospedaje`, `id_hospedaje`, `tipo_cuarto`, `cantidad_total`, `cantidad_disponible`, `tipo_cama`, `bano_privado`, `precio_por_noche`, `descripcion`) VALUES
(1, 1, 'Matrimonial', 10, 10, 'Queen', 1, 150.00, 'Habitación cómoda con vista al lago');

-- --------------------------------------------------------

--
-- Table structure for table `inventario_paquete_turistico`
--

CREATE TABLE `inventario_paquete_turistico` (
  `id_inventario_paquete_turistico` bigint NOT NULL,
  `id_paquete_turistico` bigint DEFAULT NULL,
  `fecha_salida` date NOT NULL,
  `fecha_retorno` date NOT NULL,
  `hora_salida` time NOT NULL,
  `capacidad_personas` int NOT NULL,
  `personas_registradas` int DEFAULT '0',
  `precio_por_persona` decimal(10,2) NOT NULL,
  `descripcion` text,
  `imagen_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario_paquete_turistico`
--

INSERT INTO `inventario_paquete_turistico` (`id_inventario_paquete_turistico`, `id_paquete_turistico`, `fecha_salida`, `fecha_retorno`, `hora_salida`, `capacidad_personas`, `personas_registradas`, `precio_por_persona`, `descripcion`, `imagen_path`) VALUES
(1, 1, '2025-06-10', '2025-06-12', '08:00:00', 20, 0, 250.00, 'Paquete todo incluido: actividades, hospedaje y alimentación', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `inventario_restaurante`
--

CREATE TABLE `inventario_restaurante` (
  `id_inventario_restaurante` bigint NOT NULL,
  `id_restaurante` bigint DEFAULT NULL,
  `tipo_producto` varchar(50) NOT NULL,
  `nombre_producto` varchar(100) NOT NULL,
  `cantidad_disponible_producto` int DEFAULT '0',
  `cantidad_total_producto` int DEFAULT '0',
  `total_mesas` int DEFAULT '0',
  `mesas_disponibles` int DEFAULT '0',
  `capacidad_por_mesa` int DEFAULT '4',
  `precio` decimal(10,2) DEFAULT NULL,
  `observaciones` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `menu_diario`
--

CREATE TABLE `menu_diario` (
  `id_menu` bigint NOT NULL,
  `id_restaurante` bigint DEFAULT NULL,
  `fecha` date NOT NULL,
  `nombre_plato` varchar(100) NOT NULL,
  `descripcion` text,
  `precio` decimal(10,2) DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  `id_paquete_actividad` bigint NOT NULL,
  `id_paquete_turistico` bigint NOT NULL,
  `id_actividad` bigint NOT NULL,
  `id_paquete` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_actividad`
--

INSERT INTO `paquete_actividad` (`id_paquete_actividad`, `id_paquete_turistico`, `id_actividad`, `id_paquete`) VALUES
(1, 1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `paquete_destino`
--

CREATE TABLE `paquete_destino` (
  `id_paquete_destino` bigint NOT NULL,
  `id_paquete_turistico` bigint NOT NULL,
  `id_destino` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paquete_hospedaje`
--

CREATE TABLE `paquete_hospedaje` (
  `id_paquete_hospedaje` bigint NOT NULL,
  `id_paquete_turistico` bigint NOT NULL,
  `id_hospedaje` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paquete_restaurante`
--

CREATE TABLE `paquete_restaurante` (
  `id_paquete_restaurante` bigint NOT NULL,
  `id_paquete_turistico` bigint NOT NULL,
  `id_restaurante` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paquete_turistico`
--

CREATE TABLE `paquete_turistico` (
  `id_paquete_turistico` bigint NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `duracion_dias` int NOT NULL,
  `precio_total` double NOT NULL,
  `whatsapp_contacto` varchar(255) DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_turistico`
--

INSERT INTO `paquete_turistico` (`id_paquete_turistico`, `nombre`, `descripcion`, `duracion_dias`, `precio_total`, `whatsapp_contacto`, `imagen_path`, `id_destino`) VALUES
(1, 'Paquete Full Capachica', 'Visita completa a Capachica', 0, 200, NULL, NULL, 1),
(2, 'Paquete Isañata Exprés', 'Tour rápido a Isla Isañata', 0, 150, NULL, NULL, 2),
(3, 'Paquete Full Capachica', 'Visita completa a Capachica', 0, 200, NULL, NULL, 1),
(4, 'Paquete Isañata Exprés', 'Tour rápido a Isla Isañata', 0, 150, NULL, NULL, 2),
(5, 'Full Capachica', 'Paquete turístico completo', 5, 1500, '954375460', '1748005359419_paquete turistico.jpg', 1);

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
  `id_cliente` bigint NOT NULL,
  `tipo_reserva` varchar(255) DEFAULT NULL,
  `estado_reserva` varchar(255) DEFAULT NULL,
  `total_pago` double DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `numero_personas` int DEFAULT NULL,
  `id_paquete` bigint DEFAULT NULL,
  `fecha_reserva` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `id_cliente`, `tipo_reserva`, `estado_reserva`, `total_pago`, `observaciones`, `fecha_fin`, `fecha_inicio`, `numero_personas`, `id_paquete`, `fecha_reserva`) VALUES
(1, 1, '', 'pendiente', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 2, '', 'pendiente', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 1, '', 'pendiente', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 2, '', 'pendiente', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 1, 'paquete', 'pendiente', 1200.5, 'Pago pendiente', '2025-07-07', '2025-07-01', 2, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `reserva_actividad`
--

CREATE TABLE `reserva_actividad` (
  `id_reserva_actividad` bigint NOT NULL,
  `id_reserva` bigint DEFAULT NULL,
  `id_inventario_actividad` bigint DEFAULT NULL,
  `disponible` tinyint(1) DEFAULT '1',
  `cantidad_personas` int NOT NULL,
  `incluye_ninos` tinyint(1) DEFAULT '0',
  `cantidad_ninos` int DEFAULT '0',
  `estado_reserva` varchar(50) DEFAULT 'pendiente',
  `fecha_reserva` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva_actividad`
--

INSERT INTO `reserva_actividad` (`id_reserva_actividad`, `id_reserva`, `id_inventario_actividad`, `disponible`, `cantidad_personas`, `incluye_ninos`, `cantidad_ninos`, `estado_reserva`, `fecha_reserva`) VALUES
(1, 1, 1, 1, 2, 1, 1, 'pendiente', '2025-05-22 08:05:37');

-- --------------------------------------------------------

--
-- Table structure for table `reserva_hospedaje`
--

CREATE TABLE `reserva_hospedaje` (
  `id_reserva_hospedaje` bigint NOT NULL,
  `id_reserva` bigint DEFAULT NULL,
  `id_inventario_hospedaje` bigint DEFAULT NULL,
  `disponible` tinyint(1) DEFAULT '1',
  `fecha_inicio` timestamp NOT NULL,
  `fecha_fin` timestamp NOT NULL,
  `cantidad_habitaciones` int NOT NULL,
  `cantidad_personas` int NOT NULL,
  `incluye_ninos` tinyint(1) DEFAULT '0',
  `cantidad_ninos` int DEFAULT '0',
  `incluye_desayuno` tinyint(1) DEFAULT '0',
  `estado_reserva` varchar(50) DEFAULT 'pendiente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva_hospedaje`
--

INSERT INTO `reserva_hospedaje` (`id_reserva_hospedaje`, `id_reserva`, `id_inventario_hospedaje`, `disponible`, `fecha_inicio`, `fecha_fin`, `cantidad_habitaciones`, `cantidad_personas`, `incluye_ninos`, `cantidad_ninos`, `incluye_desayuno`, `estado_reserva`) VALUES
(1, 1, 1, 1, '2025-06-01 05:00:00', '2025-06-03 05:00:00', 1, 2, 1, 1, 0, 'pendiente');

-- --------------------------------------------------------

--
-- Table structure for table `reserva_menu`
--

CREATE TABLE `reserva_menu` (
  `id_reserva_menu` bigint NOT NULL,
  `id_reserva_restaurante` bigint DEFAULT NULL,
  `id_menu` bigint DEFAULT NULL,
  `disponible` tinyint(1) DEFAULT '1',
  `cantidad` int NOT NULL DEFAULT '1',
  `observaciones` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reserva_ninos`
--

CREATE TABLE `reserva_ninos` (
  `id_reserva_ninos` bigint NOT NULL,
  `id_reserva_hospedaje` bigint DEFAULT NULL,
  `id_reserva_actividad` bigint DEFAULT NULL,
  `id_reserva_paquete` bigint DEFAULT NULL,
  `id_reserva_restaurante` bigint DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `edad` int NOT NULL,
  `num_documento` varchar(20) DEFAULT NULL,
  `direccion` text,
  `registrado_por_cliente_id` bigint NOT NULL,
  `tipo_documento` varchar(20) DEFAULT NULL
) ;

--
-- Dumping data for table `reserva_ninos`
--

INSERT INTO `reserva_ninos` (`id_reserva_ninos`, `id_reserva_hospedaje`, `id_reserva_actividad`, `id_reserva_paquete`, `id_reserva_restaurante`, `nombre`, `apellido`, `edad`, `num_documento`, `direccion`, `registrado_por_cliente_id`, `tipo_documento`) VALUES
(1, NULL, NULL, 1, NULL, 'Ana', 'Gómez', 8, '123456', 'Jr. Principal 123', 1, 'DNI');

-- --------------------------------------------------------

--
-- Table structure for table `reserva_paquete_turistico`
--

CREATE TABLE `reserva_paquete_turistico` (
  `id_reserva_paquete_turistico` bigint NOT NULL,
  `id_reserva` bigint DEFAULT NULL,
  `id_inventario_paquete` bigint DEFAULT NULL,
  `disponible` tinyint(1) DEFAULT '1',
  `cantidad_personas` int NOT NULL,
  `incluye_ninos` tinyint(1) DEFAULT '0',
  `cantidad_ninos` int DEFAULT '0',
  `estado_reserva` varchar(50) DEFAULT 'pendiente',
  `fecha_reserva` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva_paquete_turistico`
--

INSERT INTO `reserva_paquete_turistico` (`id_reserva_paquete_turistico`, `id_reserva`, `id_inventario_paquete`, `disponible`, `cantidad_personas`, `incluye_ninos`, `cantidad_ninos`, `estado_reserva`, `fecha_reserva`) VALUES
(1, 1, 1, 1, 3, 1, 1, 'pendiente', '2025-05-22 08:07:19');

-- --------------------------------------------------------

--
-- Table structure for table `reserva_restaurante`
--

CREATE TABLE `reserva_restaurante` (
  `id_reserva_restaurante` bigint NOT NULL,
  `id_reserva` bigint DEFAULT NULL,
  `id_restaurante` bigint DEFAULT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `cantidad_personas` int NOT NULL,
  `incluye_ninos` tinyint(1) DEFAULT '0',
  `cantidad_ninos` int DEFAULT '0',
  `estado` varchar(20) DEFAULT 'Pendiente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva_restaurante`
--

INSERT INTO `reserva_restaurante` (`id_reserva_restaurante`, `id_reserva`, `id_restaurante`, `fecha`, `hora`, `cantidad_personas`, `incluye_ninos`, `cantidad_ninos`, `estado`) VALUES
(1, 1, 1, '2025-06-05', '13:00:00', 4, 1, 2, 'Pendiente');

-- --------------------------------------------------------

--
-- Table structure for table `restaurante`
--

CREATE TABLE `restaurante` (
  `id_restaurante` bigint NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` text,
  `direccion` varchar(255) DEFAULT NULL,
  `whatsapp_contacto` varchar(20) DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `restaurante`
--

INSERT INTO `restaurante` (`id_restaurante`, `nombre`, `descripcion`, `direccion`, `whatsapp_contacto`, `id_destino`, `imagen_path`) VALUES
(1, 'Sabores Andinos', 'Comida típica de la región con ingredientes frescos y locales.', 'Jr. Principal 123, Capachica', '+519876543210', 1, 'imagenes/restaurantes/sabores_andinos.jpg');

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
-- Indexes for table `checkin`
--
ALTER TABLE `checkin`
  ADD PRIMARY KEY (`id_checkin`),
  ADD KEY `id_reserva` (`id_reserva`);

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`id_checkout`),
  ADD KEY `id_reserva` (`id_reserva`);

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
-- Indexes for table `inventario_actividad`
--
ALTER TABLE `inventario_actividad`
  ADD PRIMARY KEY (`id_inventario_actividad`),
  ADD KEY `id_actividad` (`id_actividad`);

--
-- Indexes for table `inventario_hospedaje`
--
ALTER TABLE `inventario_hospedaje`
  ADD PRIMARY KEY (`id_inventario_hospedaje`),
  ADD KEY `id_hospedaje` (`id_hospedaje`);

--
-- Indexes for table `inventario_paquete_turistico`
--
ALTER TABLE `inventario_paquete_turistico`
  ADD PRIMARY KEY (`id_inventario_paquete_turistico`),
  ADD KEY `inventario_paquete_turistico_ibfk_1` (`id_paquete_turistico`);

--
-- Indexes for table `inventario_restaurante`
--
ALTER TABLE `inventario_restaurante`
  ADD PRIMARY KEY (`id_inventario_restaurante`),
  ADD KEY `id_restaurante` (`id_restaurante`);

--
-- Indexes for table `menu_diario`
--
ALTER TABLE `menu_diario`
  ADD PRIMARY KEY (`id_menu`),
  ADD KEY `id_restaurante` (`id_restaurante`);

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
  ADD PRIMARY KEY (`id_paquete_actividad`),
  ADD KEY `id_actividad` (`id_actividad`),
  ADD KEY `paquete_actividad_ibfk_1` (`id_paquete_turistico`);

--
-- Indexes for table `paquete_destino`
--
ALTER TABLE `paquete_destino`
  ADD PRIMARY KEY (`id_paquete_destino`),
  ADD KEY `id_destino` (`id_destino`),
  ADD KEY `paquete_destino_ibfk_1` (`id_paquete_turistico`);

--
-- Indexes for table `paquete_hospedaje`
--
ALTER TABLE `paquete_hospedaje`
  ADD PRIMARY KEY (`id_paquete_hospedaje`),
  ADD KEY `id_hospedaje` (`id_hospedaje`),
  ADD KEY `paquete_hospedaje_ibfk_1` (`id_paquete_turistico`);

--
-- Indexes for table `paquete_restaurante`
--
ALTER TABLE `paquete_restaurante`
  ADD PRIMARY KEY (`id_paquete_restaurante`),
  ADD KEY `id_restaurante` (`id_restaurante`),
  ADD KEY `paquete_restaurante_ibfk_1` (`id_paquete_turistico`);

--
-- Indexes for table `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  ADD PRIMARY KEY (`id_paquete_turistico`),
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
  ADD KEY `fk_reserva_paquete` (`id_paquete`);

--
-- Indexes for table `reserva_actividad`
--
ALTER TABLE `reserva_actividad`
  ADD PRIMARY KEY (`id_reserva_actividad`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `id_inventario_actividad` (`id_inventario_actividad`);

--
-- Indexes for table `reserva_hospedaje`
--
ALTER TABLE `reserva_hospedaje`
  ADD PRIMARY KEY (`id_reserva_hospedaje`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `id_inventario_hospedaje` (`id_inventario_hospedaje`);

--
-- Indexes for table `reserva_menu`
--
ALTER TABLE `reserva_menu`
  ADD PRIMARY KEY (`id_reserva_menu`),
  ADD KEY `id_reserva_restaurante` (`id_reserva_restaurante`),
  ADD KEY `id_menu` (`id_menu`);

--
-- Indexes for table `reserva_ninos`
--
ALTER TABLE `reserva_ninos`
  ADD PRIMARY KEY (`id_reserva_ninos`),
  ADD KEY `id_reserva_hospedaje` (`id_reserva_hospedaje`),
  ADD KEY `id_reserva_actividad` (`id_reserva_actividad`),
  ADD KEY `id_reserva_paquete` (`id_reserva_paquete`),
  ADD KEY `id_reserva_restaurante` (`id_reserva_restaurante`),
  ADD KEY `registrado_por_cliente_id` (`registrado_por_cliente_id`);

--
-- Indexes for table `reserva_paquete_turistico`
--
ALTER TABLE `reserva_paquete_turistico`
  ADD PRIMARY KEY (`id_reserva_paquete_turistico`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `id_inventario_paquete` (`id_inventario_paquete`);

--
-- Indexes for table `reserva_restaurante`
--
ALTER TABLE `reserva_restaurante`
  ADD PRIMARY KEY (`id_reserva_restaurante`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `id_restaurante` (`id_restaurante`);

--
-- Indexes for table `restaurante`
--
ALTER TABLE `restaurante`
  ADD PRIMARY KEY (`id_restaurante`),
  ADD KEY `id_destino` (`id_destino`);

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
  MODIFY `id_actividad` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `destino`
--
ALTER TABLE `destino`
  MODIFY `id_destino` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `hospedaje`
--
ALTER TABLE `hospedaje`
  MODIFY `id_hospedaje` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
-- AUTO_INCREMENT for table `paquete_actividad`
--
ALTER TABLE `paquete_actividad`
  MODIFY `id_paquete_actividad` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  MODIFY `id_paquete_turistico` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `resena`
--
ALTER TABLE `resena`
  MODIFY `id_resena` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
-- Constraints for table `checkin`
--
ALTER TABLE `checkin`
  ADD CONSTRAINT `checkin_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`);

--
-- Constraints for table `checkout`
--
ALTER TABLE `checkout`
  ADD CONSTRAINT `checkout_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`);

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
-- Constraints for table `inventario_actividad`
--
ALTER TABLE `inventario_actividad`
  ADD CONSTRAINT `inventario_actividad_ibfk_1` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`);

--
-- Constraints for table `inventario_hospedaje`
--
ALTER TABLE `inventario_hospedaje`
  ADD CONSTRAINT `inventario_hospedaje_ibfk_1` FOREIGN KEY (`id_hospedaje`) REFERENCES `hospedaje` (`id_hospedaje`);

--
-- Constraints for table `inventario_paquete_turistico`
--
ALTER TABLE `inventario_paquete_turistico`
  ADD CONSTRAINT `inventario_paquete_turistico_ibfk_1` FOREIGN KEY (`id_paquete_turistico`) REFERENCES `paquete_turistico` (`id_paquete_turistico`);

--
-- Constraints for table `inventario_restaurante`
--
ALTER TABLE `inventario_restaurante`
  ADD CONSTRAINT `inventario_restaurante_ibfk_1` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurante` (`id_restaurante`);

--
-- Constraints for table `menu_diario`
--
ALTER TABLE `menu_diario`
  ADD CONSTRAINT `menu_diario_ibfk_1` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurante` (`id_restaurante`);

--
-- Constraints for table `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`);

--
-- Constraints for table `paquete_actividad`
--
ALTER TABLE `paquete_actividad`
  ADD CONSTRAINT `paquete_actividad_ibfk_1` FOREIGN KEY (`id_paquete_turistico`) REFERENCES `paquete_turistico` (`id_paquete_turistico`),
  ADD CONSTRAINT `paquete_actividad_ibfk_2` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`);

--
-- Constraints for table `paquete_destino`
--
ALTER TABLE `paquete_destino`
  ADD CONSTRAINT `paquete_destino_ibfk_1` FOREIGN KEY (`id_paquete_turistico`) REFERENCES `paquete_turistico` (`id_paquete_turistico`),
  ADD CONSTRAINT `paquete_destino_ibfk_2` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);

--
-- Constraints for table `paquete_hospedaje`
--
ALTER TABLE `paquete_hospedaje`
  ADD CONSTRAINT `paquete_hospedaje_ibfk_1` FOREIGN KEY (`id_paquete_turistico`) REFERENCES `paquete_turistico` (`id_paquete_turistico`),
  ADD CONSTRAINT `paquete_hospedaje_ibfk_2` FOREIGN KEY (`id_hospedaje`) REFERENCES `hospedaje` (`id_hospedaje`);

--
-- Constraints for table `paquete_restaurante`
--
ALTER TABLE `paquete_restaurante`
  ADD CONSTRAINT `paquete_restaurante_ibfk_1` FOREIGN KEY (`id_paquete_turistico`) REFERENCES `paquete_turistico` (`id_paquete_turistico`),
  ADD CONSTRAINT `paquete_restaurante_ibfk_2` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurante` (`id_restaurante`);

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
  ADD CONSTRAINT `fk_reserva_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `fk_reserva_paquete` FOREIGN KEY (`id_paquete`) REFERENCES `paquete_turistico` (`id_paquete_turistico`);

--
-- Constraints for table `reserva_actividad`
--
ALTER TABLE `reserva_actividad`
  ADD CONSTRAINT `reserva_actividad_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`),
  ADD CONSTRAINT `reserva_actividad_ibfk_2` FOREIGN KEY (`id_inventario_actividad`) REFERENCES `inventario_actividad` (`id_inventario_actividad`);

--
-- Constraints for table `reserva_hospedaje`
--
ALTER TABLE `reserva_hospedaje`
  ADD CONSTRAINT `reserva_hospedaje_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`),
  ADD CONSTRAINT `reserva_hospedaje_ibfk_2` FOREIGN KEY (`id_inventario_hospedaje`) REFERENCES `inventario_hospedaje` (`id_inventario_hospedaje`);

--
-- Constraints for table `reserva_menu`
--
ALTER TABLE `reserva_menu`
  ADD CONSTRAINT `reserva_menu_ibfk_1` FOREIGN KEY (`id_reserva_restaurante`) REFERENCES `reserva_restaurante` (`id_reserva_restaurante`),
  ADD CONSTRAINT `reserva_menu_ibfk_2` FOREIGN KEY (`id_menu`) REFERENCES `menu_diario` (`id_menu`);

--
-- Constraints for table `reserva_ninos`
--
ALTER TABLE `reserva_ninos`
  ADD CONSTRAINT `reserva_ninos_ibfk_1` FOREIGN KEY (`id_reserva_hospedaje`) REFERENCES `reserva_hospedaje` (`id_reserva_hospedaje`),
  ADD CONSTRAINT `reserva_ninos_ibfk_2` FOREIGN KEY (`id_reserva_actividad`) REFERENCES `reserva_actividad` (`id_reserva_actividad`),
  ADD CONSTRAINT `reserva_ninos_ibfk_3` FOREIGN KEY (`id_reserva_paquete`) REFERENCES `reserva_paquete_turistico` (`id_reserva_paquete_turistico`),
  ADD CONSTRAINT `reserva_ninos_ibfk_4` FOREIGN KEY (`id_reserva_restaurante`) REFERENCES `reserva_restaurante` (`id_reserva_restaurante`),
  ADD CONSTRAINT `reserva_ninos_ibfk_5` FOREIGN KEY (`registrado_por_cliente_id`) REFERENCES `cliente` (`id_cliente`);

--
-- Constraints for table `reserva_paquete_turistico`
--
ALTER TABLE `reserva_paquete_turistico`
  ADD CONSTRAINT `reserva_paquete_turistico_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`),
  ADD CONSTRAINT `reserva_paquete_turistico_ibfk_2` FOREIGN KEY (`id_inventario_paquete`) REFERENCES `inventario_paquete_turistico` (`id_inventario_paquete_turistico`);

--
-- Constraints for table `reserva_restaurante`
--
ALTER TABLE `reserva_restaurante`
  ADD CONSTRAINT `reserva_restaurante_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`),
  ADD CONSTRAINT `reserva_restaurante_ibfk_2` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurante` (`id_restaurante`);

--
-- Constraints for table `restaurante`
--
ALTER TABLE `restaurante`
  ADD CONSTRAINT `restaurante_ibfk_1` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
