-- Inserción de datos en la tabla Usuario
INSERT INTO usuario (nombre, correo, telefono, contrasena, activo)
VALUES
    ('Admin', 'admin@example.com', '999888777', 'admin123', true),
    ('Usuario1', 'usuario1@example.com', '998877665', 'user1234', true);

-- Inserción de datos en la tabla Cliente
INSERT INTO cliente (nombres, apellidos, dni, telefono, correo, direccion, fecha_registro)
VALUES
    ('Juan', 'Perez', '12345678', '987654321', 'juan.perez@example.com', 'Av. Principal 123', CURRENT_TIMESTAMP),
    ('Maria', 'Gomez', '23456789', '976543210', 'maria.gomez@example.com', 'Av. Secundaria 456', CURRENT_TIMESTAMP);

-- Inserción de datos en la tabla Destino
INSERT INTO destino (nombre, descripcion, ubicacion, imagen_url)
VALUES
    ('Machu Picchu', 'Famoso sitio arqueológico en los Andes peruanos.', 'Cusco, Perú', 'machu_picchu.jpg'),
    ('Islas Ballestas', 'Hermosas islas en la costa sur de Perú.', 'Paracas, Perú', 'islas_ballestas.jpg');

-- Inserción de datos en la tabla Hospedaje
INSERT INTO hospedaje (nombre, descripcion, direccion, telefono, precio_por_noche, imagen_url, destino_id)
VALUES
    ('Hotel Machu Picchu', 'Hotel cercano a Machu Picchu con vista panorámica.', 'Avenida Principal 123, Cusco', '987654321', 120.00, 'hotel_machu_picchu.jpg', 1),
    ('Hotel Paracas', 'Hotel en la playa cerca de las Islas Ballestas.', 'Avenida de la Playa 456, Paracas', '976543210', 150.00, 'hotel_paracas.jpg', 2);

-- Inserción de datos en la tabla Actividad
INSERT INTO actividad (nombre, descripcion, duracion, precio)
VALUES
    ('Tour Machu Picchu', 'Excursión guiada a Machu Picchu.', 240, 50.00),
    ('Navegación a Islas Ballestas', 'Excursión en bote a las Islas Ballestas.', 120, 35.00);

-- Inserción de datos en la tabla PaqueteTuristico
INSERT INTO paquete_turistico (nombre, descripcion, precio, duracion_dias)
VALUES
    ('Aventura Machu Picchu', 'Paquete que incluye transporte, hospedaje y tour a Machu Picchu.', 500.00, 3),
    ('Escape a Paracas', 'Paquete que incluye transporte, hospedaje y tour a las Islas Ballestas.', 350.00, 2);

-- Relacionando Paquetes con Actividades
INSERT INTO paquete_actividades (paquete_id, actividad_id)
VALUES
    (1, 1),  -- Paquete Aventura Machu Picchu con Tour Machu Picchu
    (2, 2);  -- Paquete Escape a Paracas con Navegación a Islas Ballestas

-- Relacionando Paquetes con Destinos
INSERT INTO paquete_destinos (paquete_id, destino_id)
VALUES
    (1, 1),  -- Paquete Aventura Machu Picchu con Destino Machu Picchu
    (2, 2);  -- Paquete Escape a Paracas con Destino Islas Ballestas

-- Inserción de datos en la tabla Restaurante
INSERT INTO restaurante (nombre, direccion, telefono, descripcion, destino_id)
VALUES
    ('Restaurante Machu Picchu', 'Calle Principal 789, Cusco', '987654322', 'Restaurante con comida típica peruana.', 1),
    ('Restaurante Paracas', 'Calle de la Playa 321, Paracas', '976543211', 'Restaurante especializado en frutos del mar.', 2);

-- Inserción de datos en la tabla Reseña
INSERT INTO resena (comentario, calificacion, fecha, cliente_id, paquete_turistico_id)
VALUES
    ('Excelente experiencia, totalmente recomendado.', 5, CURRENT_DATE, 1, 1),
    ('Buen servicio, pero el viaje fue un poco largo.', 3, CURRENT_DATE, 2, 2);

-- Inserción de datos en la tabla Reserva
INSERT INTO reserva (fecha_reserva, fecha_inicio, fecha_fin, cantidad_personas, estado, cliente_id, paquete_id, usuario_id)
VALUES
    (CURRENT_DATE, CURRENT_DATE, '2025-05-01', 2, 'CONFIRMADA', 1, 1, 1),
    (CURRENT_DATE, '2025-06-01', '2025-06-03', 1, 'PENDIENTE', 2, 2, 2);

-- Inserción de datos en la tabla CheckIn
INSERT INTO check_in (cliente_id, fecha_check_in, numero_habitacion, observaciones)
VALUES
    (1, CURRENT_TIMESTAMP, '101', 'Habitación con vista al valle'),
    (2, CURRENT_TIMESTAMP, '102', 'Habitación cerca del restaurante');

-- Inserción de datos en la tabla CheckOut
INSERT INTO check_out (cliente_id, fecha_check_out, numero_habitacion, monto_pago, comentarios)
VALUES
    (1, CURRENT_TIMESTAMP, '101', 120.00, 'Todo excelente, me gustaría volver.'),
    (2, CURRENT_TIMESTAMP, '102', 150.00, 'Buena experiencia, solo faltó algo más de variedad en el menú.');
