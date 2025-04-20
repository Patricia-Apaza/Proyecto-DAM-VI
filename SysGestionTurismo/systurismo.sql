-- Crear tabla Usuario
CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         correo VARCHAR(100) NOT NULL UNIQUE,
                         telefono VARCHAR(15),
                         contrasena VARCHAR(255) NOT NULL,
                         activo BOOLEAN NOT NULL
);

-- Crear tabla Cliente
CREATE TABLE cliente (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombres VARCHAR(100) NOT NULL,
                         apellidos VARCHAR(100) NOT NULL,
                         dni VARCHAR(8) NOT NULL UNIQUE,
                         telefono VARCHAR(15),
                         correo VARCHAR(100),
                         direccion VARCHAR(200),
                         fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear tabla Destino
CREATE TABLE destino (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         descripcion TEXT,
                         ubicacion VARCHAR(200),
                         imagen_url VARCHAR(255)
);

-- Crear tabla Hospedaje
CREATE TABLE hospedaje (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(100) NOT NULL,
                           descripcion TEXT,
                           direccion VARCHAR(200),
                           telefono VARCHAR(15),
                           precio_por_noche DOUBLE NOT NULL,
                           imagen_url VARCHAR(255),
                           destino_id BIGINT,
                           FOREIGN KEY (destino_id) REFERENCES destino(id) ON DELETE SET NULL
);

-- Crear tabla Actividad
CREATE TABLE actividad (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(100) NOT NULL,
                           descripcion TEXT,
                           duracion INT NOT NULL,
                           precio DOUBLE NOT NULL
);

-- Crear tabla PaqueteTuristico
CREATE TABLE paquete_turistico (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   nombre VARCHAR(100) NOT NULL,
                                   descripcion TEXT,
                                   precio DOUBLE NOT NULL,
                                   duracion_dias INT NOT NULL
);

-- Crear tabla Paquete_Actividades (relación muchos a muchos entre PaqueteTuristico y Actividad)
CREATE TABLE paquete_actividades (
                                     paquete_id BIGINT,
                                     actividad_id BIGINT,
                                     PRIMARY KEY (paquete_id, actividad_id),
                                     FOREIGN KEY (paquete_id) REFERENCES paquete_turistico(id) ON DELETE CASCADE,
                                     FOREIGN KEY (actividad_id) REFERENCES actividad(id) ON DELETE CASCADE
);

-- Crear tabla Paquete_Destinos (relación muchos a muchos entre PaqueteTuristico y Destino)
CREATE TABLE paquete_destinos (
                                  paquete_id BIGINT,
                                  destino_id BIGINT,
                                  PRIMARY KEY (paquete_id, destino_id),
                                  FOREIGN KEY (paquete_id) REFERENCES paquete_turistico(id) ON DELETE CASCADE,
                                  FOREIGN KEY (destino_id) REFERENCES destino(id) ON DELETE CASCADE
);

-- Crear tabla Restaurante
CREATE TABLE restaurante (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             nombre VARCHAR(100) NOT NULL,
                             direccion VARCHAR(200),
                             telefono VARCHAR(15),
                             descripcion TEXT,
                             destino_id BIGINT,
                             FOREIGN KEY (destino_id) REFERENCES destino(id) ON DELETE SET NULL
);

-- Crear tabla Reseña
CREATE TABLE resena (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        comentario TEXT,
                        calificacion INT NOT NULL,
                        fecha DATE DEFAULT CURRENT_DATE,
                        cliente_id BIGINT,
                        paquete_turistico_id BIGINT,
                        FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE,
                        FOREIGN KEY (paquete_turistico_id) REFERENCES paquete_turistico(id) ON DELETE CASCADE
);

-- Crear tabla Reserva
CREATE TABLE reserva (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         fecha_reserva DATE NOT NULL,
                         fecha_inicio DATE NOT NULL,
                         fecha_fin DATE NOT NULL,
                         cantidad_personas INT NOT NULL,
                         estado VARCHAR(20) NOT NULL,
                         cliente_id BIGINT,
                         paquete_id BIGINT,
                         usuario_id BIGINT,
                         FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE,
                         FOREIGN KEY (paquete_id) REFERENCES paquete_turistico(id) ON DELETE CASCADE,
                         FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE SET NULL
);

-- Crear tabla CheckIn
CREATE TABLE check_in (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          fecha_check_in TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          numero_habitacion VARCHAR(50) NOT NULL,
                          observaciones TEXT,
                          cliente_id BIGINT,
                          FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);

-- Crear tabla CheckOut
CREATE TABLE check_out (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           fecha_check_out TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           numero_habitacion VARCHAR(50) NOT NULL,
                           monto_pago DOUBLE NOT NULL,
                           comentarios TEXT,
                           cliente_id BIGINT,
                           FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);

-- Crear tabla Inventario
CREATE TABLE inventario (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nombre_item VARCHAR(100) NOT NULL,
                            descripcion TEXT,
                            cantidad INT NOT NULL,
                            fecha_registro DATE DEFAULT CURRENT_DATE,
                            estado VARCHAR(50) NOT NULL,
                            hospedaje_id BIGINT,
                            restaurante_id BIGINT,
                            FOREIGN KEY (hospedaje_id) REFERENCES hospedaje(id) ON DELETE SET NULL,
                            FOREIGN KEY (restaurante_id) REFERENCES restaurante(id) ON DELETE SET NULL
);

-- Crear tabla Pago
CREATE TABLE pago (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      monto DOUBLE NOT NULL,
                      metodo_pago VARCHAR(50),
                      estado_pago VARCHAR(20),
                      fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      reserva_id BIGINT,
                      FOREIGN KEY (reserva_id) REFERENCES reserva(id) ON DELETE CASCADE
);

-- Crear índice para correo de Usuario (único)
CREATE UNIQUE INDEX idx_usuario_correo ON usuario(correo);

-- Crear índice para DNI de Cliente (único)
CREATE UNIQUE INDEX idx_cliente_dni ON cliente(dni);
