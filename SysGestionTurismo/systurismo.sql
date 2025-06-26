-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 26, 2025 at 03:42 AM
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
(14, 'Escalada', 'Subida al cerro', 100, 1, 'alto', '937453278', '/imagenes/actividades/1747953167803_escalada.jpeg'),
(15, 'Ciclismo', 'Conocer el lugar ', 100, 1, 'Medio', '91234567', '/imagenes/actividades/1747996947129_ciclismo.jpeg'),
(16, 'Actualizado', 'bui', 20, NULL, 'bajo', '965432234', '/imagenes/actividades/1748321502411_temp_image2568476975421626905.tmp'),
(72, 'zxectgvygyjhgy', 'gyu', 80, NULL, 'bajo', '954376598', 'content://com.google.android.apps.docs.storage/document/acc%3D1%3Bdoc%3Dencoded%3DkBEq-wcPTMBaZi0rDzh68uC_ABxPTQv2W6GJgrY5KhcULGirM8uB4XU%3D');

-- --------------------------------------------------------

--
-- Table structure for table `carrito`
--

CREATE TABLE `carrito` (
  `id_carrito` bigint NOT NULL,
  `id_cliente` bigint NOT NULL,
  `fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` enum('ACTIVO','FINALIZADO') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `carrito`
--

INSERT INTO `carrito` (`id_carrito`, `id_cliente`, `fecha_creacion`, `estado`) VALUES
(12, 14, '2025-06-26 03:16:58', 'ACTIVO'),
(13, 13, '2025-06-26 03:29:19', 'ACTIVO');

-- --------------------------------------------------------

--
-- Table structure for table `carrito_item`
--

CREATE TABLE `carrito_item` (
  `id_carrito_item` bigint NOT NULL,
  `id_carrito` bigint NOT NULL,
  `tipo_item` enum('ACTIVIDAD','HOSPEDAJE','MENU','RESTAURANTE','PAQUETE','DESTINO') DEFAULT NULL,
  `id_referencia` bigint NOT NULL,
  `cantidad` int DEFAULT '1',
  `fecha_agregado` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `observaciones` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `carrito_item`
--

INSERT INTO `carrito_item` (`id_carrito_item`, `id_carrito`, `tipo_item`, `id_referencia`, `cantidad`, `fecha_agregado`, `observaciones`) VALUES
(11, 12, 'ACTIVIDAD', 2, 1, '2025-06-26 03:16:58', 'Tour en bote'),
(12, 12, 'HOSPEDAJE', 5, 2, '2025-06-26 03:17:09', 'Hotel vista al lago'),
(13, 12, 'ACTIVIDAD', 3, 1, '2025-06-26 03:26:25', 'Caminata en los miradores'),
(14, 12, 'HOSPEDAJE', 6, 1, '2025-06-26 03:26:38', 'Hospedaje rural con desayuno incluido'),
(15, 13, 'ACTIVIDAD', 2, 1, '2025-06-26 03:29:19', 'Tour por la península'),
(16, 13, 'MENU', 4, 2, '2025-06-26 03:29:33', 'Menú vegetariano para dos personas');

-- --------------------------------------------------------

--
-- Table structure for table `checkin`
--

CREATE TABLE `checkin` (
  `id_checkin` bigint NOT NULL,
  `id_reserva` bigint NOT NULL,
  `tipo_reserva` varchar(255) DEFAULT NULL,
  `fecha_checkin` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estado_checkin` tinyint(1) DEFAULT '1',
  `registrado_por` varchar(255) DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `checkin`
--

INSERT INTO `checkin` (`id_checkin`, `id_reserva`, `tipo_reserva`, `fecha_checkin`, `estado_checkin`, `registrado_por`, `observacion`) VALUES
(1, 1, 'hospedaje', '2025-05-22 07:50:38', 1, 'admin@correo.com', 'Check-in sin inconvenientes'),
(2, 2, 'Turismo', '2025-05-25 15:00:00', 1, 'Admin', 'Primer checkin de prueba');

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE `checkout` (
  `id_checkout` bigint NOT NULL,
  `id_checkin` bigint DEFAULT NULL,
  `tipo_reserva` varchar(255) DEFAULT NULL,
  `fecha_checkout` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estado_checkout` tinyint(1) DEFAULT '1',
  `registrado_por` varchar(255) DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`id_checkout`, `id_checkin`, `tipo_reserva`, `fecha_checkout`, `estado_checkout`, `registrado_por`, `observacion`) VALUES
(1, NULL, 'hospedaje', '2025-05-22 07:53:23', 1, 'admin@correo.com', 'Salida puntual, sin daños reportados'),
(2, NULL, 'Turismo', '2025-05-25 12:30:00', 1, 'admin', 'Checkout sin novedades'),
(3, 1, 'Hotel', '2025-05-25 10:30:00', 1, 'usuario1', 'Salida temprana');

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
  `nombre_actividad` varchar(255) DEFAULT NULL,
  `fecha_sesion` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `capacidad_personas` int NOT NULL,
  `personas_registradas` int DEFAULT '0',
  `cantidad_disponible` int DEFAULT NULL,
  `precio_por_persona` decimal(38,2) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario_actividad`
--

INSERT INTO `inventario_actividad` (`id_inventario_actividad`, `id_actividad`, `nombre_actividad`, `fecha_sesion`, `hora_inicio`, `hora_fin`, `capacidad_personas`, `personas_registradas`, `cantidad_disponible`, `precio_por_persona`, `descripcion`) VALUES
(1, 14, 'Escalada en roca - nivel avanzado', '2025-05-31', '13:00:00', '16:00:00', 15, 5, 10, 75.00, 'Sesión avanzada para escaladores con experiencia.'),
(2, 15, 'Escalada en montaña', '2025-05-31', '13:00:00', '16:00:00', 15, 5, 10, 75.00, 'Sesión avanzada para escaladores con experiencia.');

-- --------------------------------------------------------

--
-- Table structure for table `inventario_hospedaje`
--

CREATE TABLE `inventario_hospedaje` (
  `id_inventario_hospedaje` bigint NOT NULL,
  `id_hospedaje` bigint DEFAULT NULL,
  `tipo_cuarto` varchar(255) DEFAULT NULL,
  `tipo_cama` varchar(255) DEFAULT NULL,
  `bano_privado` tinyint(1) DEFAULT '1',
  `precio_por_noche` double DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `cantidad_total` int NOT NULL,
  `cantidad_disponible` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario_hospedaje`
--

INSERT INTO `inventario_hospedaje` (`id_inventario_hospedaje`, `id_hospedaje`, `tipo_cuarto`, `tipo_cama`, `bano_privado`, `precio_por_noche`, `descripcion`, `cantidad_total`, `cantidad_disponible`) VALUES
(1, 1, 'Matrimonial', 'Queen', 1, 150, 'Habitación cómoda con vista al lago', 10, 10),
(2, 1, 'Suite doble', 'Queen', 1, 120.5, 'Suite con vista al mar, aire acondicionado y baño privado', 10, 5),
(3, 1, 'Una plaza', 'Queen', 1, 120.5, 'Suite con vista al mar, aire acondicionado y baño privado', 10, 5);

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
  `precio_por_persona` decimal(38,2) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario_paquete_turistico`
--

INSERT INTO `inventario_paquete_turistico` (`id_inventario_paquete_turistico`, `id_paquete_turistico`, `fecha_salida`, `fecha_retorno`, `hora_salida`, `capacidad_personas`, `personas_registradas`, `precio_por_persona`, `descripcion`, `imagen_path`) VALUES
(1, 1, '2025-06-10', '2025-06-12', '08:00:00', 20, 0, 250.00, 'Paquete todo incluido: actividades, hospedaje y alimentación', NULL),
(2, 1, '2025-07-10', '2025-07-15', '08:00:00', 30, 0, 899.99, 'Paquete completo al Cañón del Colca con hospedaje incluido.', 'https://mi-servidor.com/imagenes/colca.jpg'),
(3, 1, '2025-07-10', '2025-07-15', '08:00:00', 30, 0, 899.99, 'Paquete completo al Cañón del Colca con hospedaje incluido.', 'https://mi-servidor.com/imagenes/colca.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `inventario_restaurante`
--

CREATE TABLE `inventario_restaurante` (
  `id_inventario_restaurante` bigint NOT NULL,
  `id_restaurante` bigint DEFAULT NULL,
  `tipo_producto` varchar(255) DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  `cantidad_disponible_producto` int DEFAULT '0',
  `cantidad_total_producto` int DEFAULT '0',
  `total_mesas` int DEFAULT '0',
  `mesas_disponibles` int DEFAULT '0',
  `capacidad_por_mesa` int DEFAULT '4',
  `precio` double DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario_restaurante`
--

INSERT INTO `inventario_restaurante` (`id_inventario_restaurante`, `id_restaurante`, `tipo_producto`, `nombre_producto`, `cantidad_disponible_producto`, `cantidad_total_producto`, `total_mesas`, `mesas_disponibles`, `capacidad_por_mesa`, `precio`, `observaciones`) VALUES
(1, 1, 'Bebida', 'Cerveza Artesanal', 50, 100, 20, 15, 4, 12.5, 'Producto nuevo en carta'),
(2, 1, 'Plato', 'Trucha Frita', 50, 100, 20, 15, 4, 12.5, 'Producto nuevo en carta');

-- --------------------------------------------------------

--
-- Table structure for table `menu_diario`
--

CREATE TABLE `menu_diario` (
  `id_menu` bigint NOT NULL,
  `id_restaurante` bigint DEFAULT NULL,
  `fecha` date NOT NULL,
  `nombre_plato` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` decimal(38,2) DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `menu_diario`
--

INSERT INTO `menu_diario` (`id_menu`, `id_restaurante`, `fecha`, `nombre_plato`, `descripcion`, `precio`, `imagen_path`) VALUES
(1, 1, '2025-05-26', 'Trucha frita', 'Sacado del lago', 20.00, '/imagenes/menus/1748247931131_trucha-frita_web.jpg'),
(2, 1, '2025-05-26', 'Trucha ', 'Sacado del lago', 20.00, '/imagenes/menus/1748247982632_trucha-frita_web.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `nivel_paquete`
--

CREATE TABLE `nivel_paquete` (
  `id_nivel_paquete` bigint NOT NULL,
  `nombre_nivel` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nivel_paquete`
--

INSERT INTO `nivel_paquete` (`id_nivel_paquete`, `nombre_nivel`, `descripcion`) VALUES
(1, 'Económico', 'Servicios básicos para presupuestos ajustados'),
(2, 'Estándar', 'Experiencia media entre básica y completa'),
(3, 'Premium', 'Servicios exclusivos y de alta calidad');

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
  `id_actividad` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_actividad`
--

INSERT INTO `paquete_actividad` (`id_paquete_actividad`, `id_paquete_turistico`, `id_actividad`) VALUES
(1, 1, 14),
(2, 2, 15),
(3, 2, 14),
(4, 1, 15),
(6, 7, 16),
(9, 10, 16);

-- --------------------------------------------------------

--
-- Table structure for table `paquete_destino`
--

CREATE TABLE `paquete_destino` (
  `id_paquete_destino` bigint NOT NULL,
  `id_paquete_turistico` bigint NOT NULL,
  `id_destino` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_destino`
--

INSERT INTO `paquete_destino` (`id_paquete_destino`, `id_paquete_turistico`, `id_destino`) VALUES
(2, 1, 1),
(4, 1, 15),
(5, 1, 18),
(7, 7, 27),
(8, 10, 27);

-- --------------------------------------------------------

--
-- Table structure for table `paquete_hospedaje`
--

CREATE TABLE `paquete_hospedaje` (
  `id_paquete_hospedaje` bigint NOT NULL,
  `id_paquete_turistico` bigint NOT NULL,
  `id_hospedaje` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_hospedaje`
--

INSERT INTO `paquete_hospedaje` (`id_paquete_hospedaje`, `id_paquete_turistico`, `id_hospedaje`) VALUES
(1, 1, 2),
(2, 1, 2),
(4, 7, 5),
(5, 10, 5);

-- --------------------------------------------------------

--
-- Table structure for table `paquete_restaurante`
--

CREATE TABLE `paquete_restaurante` (
  `id_paquete_restaurante` bigint NOT NULL,
  `id_paquete_turistico` bigint NOT NULL,
  `id_restaurante` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_restaurante`
--

INSERT INTO `paquete_restaurante` (`id_paquete_restaurante`, `id_paquete_turistico`, `id_restaurante`) VALUES
(1, 1, 2),
(2, 1, 2),
(4, 7, 2),
(5, 10, 2);

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
  `id_nivel_paquete` bigint DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `paquete_turistico`
--

INSERT INTO `paquete_turistico` (`id_paquete_turistico`, `nombre`, `descripcion`, `duracion_dias`, `precio_total`, `whatsapp_contacto`, `imagen_path`, `id_nivel_paquete`, `id_destino`) VALUES
(1, 'Paquete Full Capachica', 'Visita completa a Capachica', 0, 200, NULL, NULL, NULL, NULL),
(2, 'Paquete Isañata Exprés', 'Tour rápido a Isla Isañata', 0, 150, NULL, NULL, NULL, NULL),
(3, 'Paquete Full Capachica', 'Visita completa a Capachica', 0, 200, NULL, NULL, NULL, NULL),
(4, 'Paquete Isañata Exprés', 'Tour rápido a Isla Isañata', 0, 150, NULL, NULL, NULL, NULL),
(7, 'Paquete Capchic', 'Experiencia premium', 7, 2000, '954375460', '1748448276331_paquete.jpeg', 3, 27),
(10, 'Paquete Aventura', 'Excursión', 3, 150, '975432123', '1750575510092_paquete turistico.jpg', 2, 27);

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
  `estado_reserva` varchar(255) DEFAULT NULL,
  `fecha_reserva` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva_actividad`
--

INSERT INTO `reserva_actividad` (`id_reserva_actividad`, `id_reserva`, `id_inventario_actividad`, `disponible`, `cantidad_personas`, `incluye_ninos`, `cantidad_ninos`, `estado_reserva`, `fecha_reserva`) VALUES
(1, 1, 2, 1, 4, 1, 1, 'confirmado', '2025-05-25 10:00:00'),
(2, 1, 2, 1, 2, 1, 1, 'confirmado', '2025-05-25 10:00:00');

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
  `estado_reserva` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva_hospedaje`
--

INSERT INTO `reserva_hospedaje` (`id_reserva_hospedaje`, `id_reserva`, `id_inventario_hospedaje`, `disponible`, `fecha_inicio`, `fecha_fin`, `cantidad_habitaciones`, `cantidad_personas`, `incluye_ninos`, `cantidad_ninos`, `incluye_desayuno`, `estado_reserva`) VALUES
(1, 1, 1, 1, '2025-06-01 05:00:00', '2025-06-03 05:00:00', 1, 2, 1, 1, 0, 'pendiente'),
(2, 1, 2, 1, '2025-06-10 14:00:00', '2025-06-12 12:00:00', 2, 4, 1, 2, 1, 'confirmado'),
(3, 1, 2, 1, '2025-06-10 14:00:00', '2025-06-12 12:00:00', 2, 4, 1, 2, 1, 'confirmado');

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
  `observaciones` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva_menu`
--

INSERT INTO `reserva_menu` (`id_reserva_menu`, `id_reserva_restaurante`, `id_menu`, `disponible`, `cantidad`, `observaciones`) VALUES
(3, 1, 1, 1, 3, 'Pedido para 3 personas'),
(4, 1, 1, 1, 3, 'Pedido para 5 personas');

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
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `edad` int NOT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL,
  `num_documento` varchar(255) DEFAULT NULL,
  `direccion` text,
  `registrado_por_cliente_id` bigint NOT NULL
) ;

--
-- Dumping data for table `reserva_ninos`
--

INSERT INTO `reserva_ninos` (`id_reserva_ninos`, `id_reserva_hospedaje`, `id_reserva_actividad`, `id_reserva_paquete`, `id_reserva_restaurante`, `nombre`, `apellido`, `edad`, `tipo_documento`, `num_documento`, `direccion`, `registrado_por_cliente_id`) VALUES
(1, NULL, NULL, 1, NULL, 'Ana', 'Gómez', 8, 'DNI', '123456', 'Jr. Principal 123', 1),
(2, 1, 2, 3, 4, 'Juan', 'Perez', 5, 'DNI', '12345678', 'Calle Falsa 123', 10),
(4, 1, 1, 3, 4, 'Juan', 'Perez', 5, 'DNI', '12345678', 'Calle Falsa 123', 10),
(5, NULL, NULL, 3, 4, 'Juan', 'Perez', 5, 'DNI', '12345678', 'Calle Falsa 123', 10);

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
  `estado_reserva` varchar(255) DEFAULT NULL,
  `fecha_reserva` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reserva_paquete_turistico`
--

INSERT INTO `reserva_paquete_turistico` (`id_reserva_paquete_turistico`, `id_reserva`, `id_inventario_paquete`, `disponible`, `cantidad_personas`, `incluye_ninos`, `cantidad_ninos`, `estado_reserva`, `fecha_reserva`) VALUES
(1, 1, 1, 1, 3, 1, 1, 'pendiente', '2025-05-22 08:07:19'),
(2, 1, 2, 1, 4, 1, 2, 'pendiente', '2025-05-25 10:30:00'),
(3, 1, 2, 1, 4, 1, 2, 'confirmado', '2025-05-25 10:30:00');

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
(1, 1, 1, '2025-06-05', '13:00:00', 4, 1, 2, 'Pendiente'),
(2, 1, 2, '2025-05-29', '19:30:00', 4, 1, 2, 'Pendiente'),
(3, 1, 2, '2025-05-29', '19:30:00', 4, 1, 2, 'confirmado'),
(4, 1, 2, '2025-05-29', '19:30:00', 4, 0, 0, 'confirmado');

-- --------------------------------------------------------

--
-- Table structure for table `restaurante`
--

CREATE TABLE `restaurante` (
  `id_restaurante` bigint NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `whatsapp_contacto` varchar(255) DEFAULT NULL,
  `id_destino` bigint DEFAULT NULL,
  `imagen_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `restaurante`
--

INSERT INTO `restaurante` (`id_restaurante`, `nombre`, `descripcion`, `direccion`, `whatsapp_contacto`, `id_destino`, `imagen_path`) VALUES
(1, 'Sabores Andinos', 'Comida típica de la región con ingredientes frescos y locales.', 'Jr. Principal 123, Capachica', '+519876543210', 1, 'imagenes/restaurantes/sabores_andinos.jpg'),
(2, 'Restaurante San Pedro', 'Comida criolla', 'Capachica', '942345675', 1, '/imagenes/restaurantes/1748090432745_restaurante.jpeg');

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
(3, 'turista@gmail.com', '$2a$10$1/nRU/yY3xVLmdhrsoG1BuZrH6jdQhjC0//MeaY4ULtnd2xWoJTDS', 'CLIENTE'),
(4, 'cliente@gmail.com', '$2a$10$cjDnJIhBw.sLtR8B1pY0JedhmbjPC3sLypDU9o7FEIbuRBEIWtDzu', 'CLIENTE'),
(5, 'renzo@gmail.com', '$2a$10$lBi6CXPSkmWr2T6u2sqKHuNqpiKV6zvlekMx1A86HRldlhd2LuZxS', 'CLIENTE'),
(6, 'sysadmin@gmail.com', '$2a$10$E12VKHYRpbF6M4.JZJns7eH.6EF0ot.CegH5J8AddRvQNraon.2X6', 'ADMIN');

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
-- Indexes for table `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`id_carrito`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indexes for table `carrito_item`
--
ALTER TABLE `carrito_item`
  ADD PRIMARY KEY (`id_carrito_item`),
  ADD KEY `id_carrito` (`id_carrito`);

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
  ADD KEY `fk_checkout_checkin` (`id_checkin`);

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
  ADD KEY `inventario_restaurante_ibfk_1` (`id_restaurante`);

--
-- Indexes for table `menu_diario`
--
ALTER TABLE `menu_diario`
  ADD PRIMARY KEY (`id_menu`),
  ADD KEY `menu_diario_ibfk_1` (`id_restaurante`);

--
-- Indexes for table `nivel_paquete`
--
ALTER TABLE `nivel_paquete`
  ADD PRIMARY KEY (`id_nivel_paquete`),
  ADD UNIQUE KEY `nombre_nivel` (`nombre_nivel`);

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
  ADD KEY `paquete_restaurante_ibfk_1` (`id_paquete_turistico`),
  ADD KEY `paquete_restaurante_ibfk_2` (`id_restaurante`);

--
-- Indexes for table `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  ADD PRIMARY KEY (`id_paquete_turistico`),
  ADD KEY `fk_paquete_nivel` (`id_nivel_paquete`),
  ADD KEY `FKc4qn98uowfvh2awf4ukr04op0` (`id_destino`);

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
  ADD KEY `reserva_actividad_ibfk_2` (`id_inventario_actividad`);

--
-- Indexes for table `reserva_hospedaje`
--
ALTER TABLE `reserva_hospedaje`
  ADD PRIMARY KEY (`id_reserva_hospedaje`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `reserva_hospedaje_ibfk_2` (`id_inventario_hospedaje`);

--
-- Indexes for table `reserva_menu`
--
ALTER TABLE `reserva_menu`
  ADD PRIMARY KEY (`id_reserva_menu`),
  ADD KEY `reserva_menu_ibfk_1` (`id_reserva_restaurante`),
  ADD KEY `reserva_menu_ibfk_2` (`id_menu`);

--
-- Indexes for table `reserva_ninos`
--
ALTER TABLE `reserva_ninos`
  ADD PRIMARY KEY (`id_reserva_ninos`),
  ADD KEY `registrado_por_cliente_id` (`registrado_por_cliente_id`),
  ADD KEY `reserva_ninos_ibfk_2` (`id_reserva_actividad`),
  ADD KEY `reserva_ninos_ibfk_1` (`id_reserva_hospedaje`),
  ADD KEY `fk_reserva_ninos_paquete` (`id_reserva_paquete`),
  ADD KEY `reserva_ninos_ibfk_4` (`id_reserva_restaurante`);

--
-- Indexes for table `reserva_paquete_turistico`
--
ALTER TABLE `reserva_paquete_turistico`
  ADD PRIMARY KEY (`id_reserva_paquete_turistico`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `fk_reserva_paquete_inventario` (`id_inventario_paquete`);

--
-- Indexes for table `reserva_restaurante`
--
ALTER TABLE `reserva_restaurante`
  ADD PRIMARY KEY (`id_reserva_restaurante`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `reserva_restaurante_ibfk_2` (`id_restaurante`);

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
  MODIFY `id_actividad` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT for table `carrito`
--
ALTER TABLE `carrito`
  MODIFY `id_carrito` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `carrito_item`
--
ALTER TABLE `carrito_item`
  MODIFY `id_carrito_item` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `checkin`
--
ALTER TABLE `checkin`
  MODIFY `id_checkin` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `checkout`
--
ALTER TABLE `checkout`
  MODIFY `id_checkout` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  MODIFY `id_hospedaje` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id_inventario` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `inventario_actividad`
--
ALTER TABLE `inventario_actividad`
  MODIFY `id_inventario_actividad` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `inventario_hospedaje`
--
ALTER TABLE `inventario_hospedaje`
  MODIFY `id_inventario_hospedaje` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `inventario_paquete_turistico`
--
ALTER TABLE `inventario_paquete_turistico`
  MODIFY `id_inventario_paquete_turistico` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `inventario_restaurante`
--
ALTER TABLE `inventario_restaurante`
  MODIFY `id_inventario_restaurante` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `menu_diario`
--
ALTER TABLE `menu_diario`
  MODIFY `id_menu` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nivel_paquete`
--
ALTER TABLE `nivel_paquete`
  MODIFY `id_nivel_paquete` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `pago`
--
ALTER TABLE `pago`
  MODIFY `id_pago` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `paquete_actividad`
--
ALTER TABLE `paquete_actividad`
  MODIFY `id_paquete_actividad` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `paquete_destino`
--
ALTER TABLE `paquete_destino`
  MODIFY `id_paquete_destino` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `paquete_hospedaje`
--
ALTER TABLE `paquete_hospedaje`
  MODIFY `id_paquete_hospedaje` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `paquete_restaurante`
--
ALTER TABLE `paquete_restaurante`
  MODIFY `id_paquete_restaurante` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `paquete_turistico`
--
ALTER TABLE `paquete_turistico`
  MODIFY `id_paquete_turistico` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
-- AUTO_INCREMENT for table `reserva_actividad`
--
ALTER TABLE `reserva_actividad`
  MODIFY `id_reserva_actividad` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reserva_hospedaje`
--
ALTER TABLE `reserva_hospedaje`
  MODIFY `id_reserva_hospedaje` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `reserva_menu`
--
ALTER TABLE `reserva_menu`
  MODIFY `id_reserva_menu` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `reserva_ninos`
--
ALTER TABLE `reserva_ninos`
  MODIFY `id_reserva_ninos` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reserva_paquete_turistico`
--
ALTER TABLE `reserva_paquete_turistico`
  MODIFY `id_reserva_paquete_turistico` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `reserva_restaurante`
--
ALTER TABLE `reserva_restaurante`
  MODIFY `id_reserva_restaurante` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `restaurante`
--
ALTER TABLE `restaurante`
  MODIFY `id_restaurante` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `actividad_ibfk_1` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);

--
-- Constraints for table `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Constraints for table `carrito_item`
--
ALTER TABLE `carrito_item`
  ADD CONSTRAINT `carrito_item_ibfk_1` FOREIGN KEY (`id_carrito`) REFERENCES `carrito` (`id_carrito`);

--
-- Constraints for table `checkin`
--
ALTER TABLE `checkin`
  ADD CONSTRAINT `checkin_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`);

--
-- Constraints for table `checkout`
--
ALTER TABLE `checkout`
  ADD CONSTRAINT `fk_checkout_checkin` FOREIGN KEY (`id_checkin`) REFERENCES `checkin` (`id_checkin`);

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
  ADD CONSTRAINT `fk_paquete_nivel` FOREIGN KEY (`id_nivel_paquete`) REFERENCES `nivel_paquete` (`id_nivel_paquete`),
  ADD CONSTRAINT `FKc4qn98uowfvh2awf4ukr04op0` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`id_destino`);

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
  ADD CONSTRAINT `fk_reserva_ninos_paquete` FOREIGN KEY (`id_reserva_paquete`) REFERENCES `reserva_paquete_turistico` (`id_reserva_paquete_turistico`),
  ADD CONSTRAINT `reserva_ninos_ibfk_1` FOREIGN KEY (`id_reserva_hospedaje`) REFERENCES `reserva_hospedaje` (`id_reserva_hospedaje`),
  ADD CONSTRAINT `reserva_ninos_ibfk_2` FOREIGN KEY (`id_reserva_actividad`) REFERENCES `reserva_actividad` (`id_reserva_actividad`),
  ADD CONSTRAINT `reserva_ninos_ibfk_4` FOREIGN KEY (`id_reserva_restaurante`) REFERENCES `reserva_restaurante` (`id_reserva_restaurante`),
  ADD CONSTRAINT `reserva_ninos_ibfk_5` FOREIGN KEY (`registrado_por_cliente_id`) REFERENCES `cliente` (`id_cliente`);

--
-- Constraints for table `reserva_paquete_turistico`
--
ALTER TABLE `reserva_paquete_turistico`
  ADD CONSTRAINT `fk_reserva_paquete_inventario` FOREIGN KEY (`id_inventario_paquete`) REFERENCES `inventario_paquete_turistico` (`id_inventario_paquete_turistico`),
  ADD CONSTRAINT `reserva_paquete_turistico_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`);

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
