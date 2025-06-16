# Proyecto SysGestionTurismo

Este proyecto es un sistema de gestión de turismo comunitario para la península de Capachica. El sistema permite gestionar actividades turísticas, reservas, servicios y más. Está desarrollado con Spring Boot para el backend y se integra con una aplicación móvil para turistas y dueños de negocios.

## 1. Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- **IntelliJ IDEA**: IDE utilizado para el desarrollo del backend.
- **Maven**: Sistema de gestión de dependencias.
- **Base de Datos**: Puedes usar MySQL o PostgreSQL (o cualquier otra base de datos compatible).
- **Herramienta de control de versiones (Git)**: Necesitarás Git para clonar el proyecto desde el repositorio.

## 2. Clonar el Proyecto

1. Abre una terminal y usa el siguiente comando para clonar el proyecto:
    ```bash
    git clone https://github.com/Patricia-Apaza/Proyecto-DAM-VI.git
    ```

2. Accede al directorio del proyecto:
    ```bash
    cd Proyecto-DAM-VI
    ```

## 3. Configuración del Proyecto

1. Abre una terminal en el directorio del proyecto y ejecuta el siguiente comando para iniciar el servidor:
    ```bash
    mvn spring-boot:run
    ```

2. En Android Studio, abre el proyecto y luego abre el archivo `TokenUtils`. Cambia la IP según sea necesario.

## 4. Configuración de la Base de Datos

1. Crea la base de datos en MySQL o PostgreSQL (según el que estés usando). Por ejemplo, en MySQL puedes usar el siguiente comando:
    ```sql
    CREATE DATABASE sysgestionturismo;
    ```

## 5. Probar la API

1. Una vez que el servidor esté corriendo, puedes probar la API.
2. Abre Swagger y autentifícate con las siguientes credenciales:
   - **Usuario**: `admin@gmail.com`
   - **Contraseña**: `123456`
3. Para iniciar sesión al iniciar la aplicación, poner las siguientes credenciales:
   - **Usuario**: `turista@gmail.com`
   - **Contraseña**: `Tu123456*`

## Modelo de Base de Datos

El sistema tiene un modelo de base de datos que incluye las siguientes entidades principales:

![image](https://github.com/user-attachments/assets/99f0896b-e343-4234-a6b2-07e5d7a2e1b8)

En el cual contiene:
## Esquema de Base de Datos

La base de datos contiene las siguientes tablas principales:

- **Actividad**: id_actividad, nombre, descripcion, precio, id_destino, nivel_riesgo, whatsapp_contacto, imagen_path.
- **Checkin**: id_checkin, id_reserva, tipo_reserva, fecha_checkin, estado_checkin, registrado_por, observacion.
- **Checkout**: id_checkout, id_checkin, tipo_reserva, fecha_checkout, estado_checkout, registrado_por, observacion.
- **Cliente**: id_cliente, nombres, apellidos, num_documento, imagen_perfil, whatsapp_contacto, correo, direccion, tipo_documento.
- **Destino**: id_destino, nombre, descripcion, ubicacion, imagen_path.
- **Hospedaje**: id_hospedaje, nombre, descripcion, precio_por_noche, id_destino, imagen_path, whatsapp_contacto, direccion.
- **Inventario**: id_inventario, nombre_item, cantidad_disponible, id_destino.
- **Inventario_actividad**: id_inventario_actividad, id_actividad, nombre_actividad, fecha_sesion, hora_inicio, hora_fin, capacidad_personas, personas_registradas, cantidad_disponible, precio_por_persona, descripcion.
- **Inventario_hospedaje**: id_inventario_hospedaje, id_hospedaje, tipo_cuarto, tipo_cama, bano_privado, precio_por_noche, descripcion, cantidad_total, cantidad_disponible.
- **Inventario_paquete_turistico**: id_inventario_paquete_turistico, id_paquete_turistico, fecha_salida, fecha_retorno, hora_salida, capacidad_personas, personas_registradas, precio_por_persona, descripcion, imagen_path.
- **Inventario_restaurante**: id_inventario_restaurante, id_restaurante, tipo_producto, nombre_producto, cantidad_disponible_producto, cantidad_total_producto, total_mesas, mesas_disponibles, capacidad_por_mesa, precio, observaciones.
- **Menu_diario**: id_menu, id_restaurante, fecha, nombre_plato, descripcion, precio, imagen_path.
- **Nivel_paquete**: id_nivel_paquete, nombre_nivel, descripcion.
- **Pago**: id_pago, monto, metodo_pago, fecha_pago, id_reserva.
- **Paquete_actividad**: id_paquete_actividad, id_paquete_turistico, id_actividad.
- **Paquete_destino**: id_paquete_destino, id_paquete_turistico, id_destino.
- **Paquete_hospedaje**: id_paquete_hospedaje, id_paquete_turistico, id_hospedaje.
- **Paquete_restaurante**: id_paquete_restaurante, id_paquete_turistico, id_restaurante.
- **Paquete_turistico**: id_paquete_turistico, nombre, descripcion, duracion_dias, precio_total, whatsapp_contacto, imagen_path, id_nivel_paquete, id_destino.
- **Resena**: id_resena, comentario, calificacion, id_cliente, id_destino.
- **Reserva**: id_reserva, id_cliente, tipo_reserva, estado_reserva, total_pago, observaciones, fecha_fin, fecha_inicio, numero_personas, id_paquete, fecha_reserva.
- **Reserva_actividad**: id_reserva_actividad, id_reserva, id_inventario_actividad, disponible, cantidad_personas, incluye_ninos, cantidad_ninos, estado_reserva, fecha_reserva.
- **Reserva_hospedaje**: id_reserva_hospedaje, id_reserva, id_inventario_hospedaje, disponible, fecha_inicio, fecha_fin, cantidad_habitaciones, cantidad_personas, incluye_ninos, cantidad_ninos, incluye_desayuno, estado_reserva.
- **Reserva_menu**: id_reserva_menu, id_reserva_restaurante, id_menu, disponible, cantidad, observaciones.
- **Reserva_ninos**: id_reserva_ninos, id_reserva_hospedaje, id_reserva_actividad, id_reserva_paquete, id_reserva_restaurante, nombre, apellido, edad, tipo_documento, num_documento, direccion, registrado_por_cliente_id.
- **Reserva_paquete_turistico**: id_reserva_paquete_turistico, id_reserva, id_inventario_paquete, disponible, cantidad_personas, incluye_ninos, cantidad_ninos, estado_reserva, fecha_reserva.
- **Reserva_restaurante**: id_reserva_restaurante, id_reserva, id_restaurante, fecha, hora, cantidad_personas, incluye_ninos, cantidad_ninos, estado.
- **Restaurante**: id_restaurante, nombre, descripcion, direccion, whatsapp_contacto, id_destino, imagen_path.
- **Usuario**: id_usuario, correo, contraseña, rol.

## Requerimientos de la Aplicación Móvil de Turismo

### 1. Requerimientos Funcionales (RF)

#### 1.1 Gestión de Autenticación de Usuarios
- **RF1.1**: El sistema debe permitir el registro de turistas mediante correo electrónico, contraseña, nombre completo, sexo y nacionalidad.  
- **RF1.2**: El sistema debe permitir el inicio de sesión de turistas utilizando su correo electrónico y contraseña.  
- **RF1.3**: El sistema debe permitir el registro de propietarios de servicios turísticos con correo electrónico, contraseña y los datos correspondientes a su negocio.  
- **RF1.4**: El sistema debe permitir el inicio de sesión de los propietarios de servicios mediante correo electrónico y contraseña.  

#### 1.2 Funcionalidades para Turistas
- **RF2.1**: El sistema debe mostrar un listado de distritos disponibles (Capachica, Llachon, Ticonata).  
- **RF2.2**: El sistema debe permitir al turista seleccionar un distrito.  
- **RF2.3**: El sistema debe mostrar los servicios disponibles en cada distrito (tours, hospedajes, participación en costumbres locales, restaurantes).  
- **RF2.4**: El sistema debe permitir visualizar los detalles de cada servicio (descripción, imágenes, horarios y ubicación).  
- **RF2.5**: El sistema debe permitir al turista realizar una reserva de servicio.  
- **RF2.6**: El sistema debe permitir al turista visualizar un historial de sus reservaciones.  

#### 1.3 Funcionalidades para Propietarios de Servicios
- **RF3.1**: El sistema debe permitir al propietario visualizar el perfil de su negocio registrado.  
- **RF3.2**: El sistema debe permitir editar la información del servicio ofrecido (nombre, descripción, imágenes, horarios).  
- **RF3.3**: El sistema debe permitir visualizar las reservaciones realizadas a los servicios del negocio.  

#### 1.4 Funcionalidades Comunes
- **RF4.1**: El sistema debe permitir a cualquier usuario cerrar sesión.  
- **RF4.2**: El sistema debe permitir la navegación hacia pantallas anteriores dentro de la aplicación.  

---

### 2. Requerimientos No Funcionales (RNF)
- **RNF1**: La aplicación debe ser adaptable a distintos tamaños de pantalla (diseño responsivo).  
- **RNF2**: El tiempo de carga de cada pantalla no debe superar los tres segundos.  
- **RNF3**: Las contraseñas deben almacenarse en la base de datos de forma encriptada.  
- **RNF4**: La aplicación debe incluir validaciones de entrada para garantizar la integridad de los datos (por ejemplo, correos válidos y contraseñas seguras).  
- **RNF5**: El diseño de la interfaz debe ser intuitivo, amigable y completamente en idioma español.  
- **RNF6**: Se debe garantizar la confidencialidad y protección de los datos personales de los usuarios.  
- **RNF7**: La aplicación debe ser compatible con dispositivos Android 9 o versiones superiores.  

---

### 3. Requerimientos de Datos (RD)
- **RD1**: El sistema debe almacenar datos de turistas, tales como: nombre completo, correo electrónico, contraseña encriptada, país de origen y número telefónico.  
- **RD2**: El sistema debe almacenar datos de los propietarios de servicios turísticos, incluyendo: nombre, tipo de servicio, correo electrónico, contraseña, imágenes, descripción y ubicación.  
- **RD3**: El sistema debe registrar información detallada de los servicios turísticos, incluyendo: tipo, nombre, descripción, precio, horarios y material gráfico.  
- **RD4**: El sistema debe almacenar información de las reservas, tales como: datos del cliente, servicio reservado, fechas y estado de la reserva.  

---

### 4. Funcionalidades Implementadas y Pendientes

#### Funcionalidades Implementadas
- Módulo de búsqueda de servicios  
- Sistema de filtros para la búsqueda  
- Implementación del botón de retroceso en la navegación  
- Generación de reportes en formato PDF  
- Visualización de imágenes en hospedajes y paquetes turísticos  
- Gestión de restaurantes y sus reservas  
- Módulo de check-in y check-out  
- Registro de reservas específicas por tipo de servicio  
- Gestión de inventarios diferenciados por servicio  
- Registro de número de documento y fotografía de perfil en clientes  
- Estados diferenciados para las reservas (pendiente, confirmada, en curso, finalizada, cancelada)  
- Actualización completa de los controladores del backend  

#### Funcionalidades Pendientes
- Implementación del sistema de servicios favoritos  
- Autenticación mediante cuenta de Google  
- Inclusión de idiomas adicionales (francés e inglés)  
- Descuento automático del inventario al confirmar una reserva  
- Formulario complementario para el registro de niños  
- Establecimiento de precios dinámicos por temporada u oferta  
- Integración de canales de contacto vía WhatsApp  
- Desarrollo de un sistema de carrito de compras  
- Modificación y ampliación de las tablas de pagos y facturación  
- Desarrollo de una pantalla adicional de detalle (opcional)  

---

### 4. Roles de Usuario

| Rol                   | Funciones Principales                                                                                         |
|------------------------|--------------------------------------------------------------------------------------------------------------|
| **Turista**           | Registrarse, iniciar sesión, explorar distritos, buscar servicios turísticos, realizar y gestionar reservas. |
| **Dueño de Negocio**  | Registrarse, iniciar sesión, gestionar la información de sus servicios, visualizar y administrar reservas.    |
| **Administrador General** | Gestionar usuarios (turistas y dueños), monitorear estadísticas del sistema, supervisar contenidos y servicios registrados, administrar reportes y validar operaciones críticas del sistema. |

## Prototipos

Puedes ver los prototipos de la aplicación móvil en Figma:  
- [Prototipo en Figma (vista)](https://www.figma.com/proto/eDt0JbWJj7ZaogjJwLUsn8/YakuApp?node-id=0-1&t=ROPQ0LbkbiRLvQBC-1)
- [Prototipo en Figma (prototipo)]([[https://www.figma.com/proto/eDt0JbWJj7ZaogjJwLUsn8/YakuApp?node-id=5-78&t=Rsz1wmt13XAkuOyC-1&starting-point-node-id=3%3A51](https://www.figma.com/design/eDt0JbWJj7ZaogjJwLUsn8/YakuApp?node-id=0-1&p=f&t=EhGLq4XerHR7feVn-0)](https://www.figma.com/design/eDt0JbWJj7ZaogjJwLUsn8/YakuApp?node-id=0-1&t=47pf9RXtXh8Ofo3x-1))

