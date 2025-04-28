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

## Modelo de Base de Datos

El sistema tiene un modelo de base de datos que incluye las siguientes entidades principales:
![Captura de pantalla 2025-04-28 044449](https://github.com/user-attachments/assets/87c8091c-3528-44bb-851b-a0566b152591)

En el cual contiene:
  - Actividad: id_actividad,	nombre,	descripcion,	precio,	id_destino.
  - Cliente: id_cliente,	nombre_completo,	correo,	telefono,	direccion.
  - Destino: id_destino,	nombre,	descripcion,	ubicacion,
  - Hospedaje: id_hospedaje,	nombre,	descripcion,	precio_por_noche,	id_destino.
  - Inventario: id_inventario,	nombre_item,	cantidad_disponible,	id_destino.
  - Pago: id_pago,	monto,	metodo_pago,	fecha_pago,	id_reserva.
  - Paquete_actividad: id_paquete,	id_actividad.
  - Paquete_turistico: id_paquete,	nombre,	descripcion,	precio_total,	id_destino.
  - Reseña: id_resena,	comentario,	calificacion,	id_cliente,	id_destino.
  - Reserva: id_reserva,	fecha_reserva,	fecha_inicio,	fecha_fin,	numero_personas,	id_cliente,	id_paquete.
  - Usuario: id_uduario, correo, contraseña, rol.

## Requerimientos de la Aplicación Móvil de Turismo

### 1. Requerimientos Funcionales (RF)

#### 1.1 Gestión de Autenticación de Usuarios

- **RF1.1**: Permitir el registro de turistas con correo, contraseña, nombre, sexo y nacionalidad.
- **RF1.2**: Permitir el inicio de sesión de turistas con correo y contraseña.
- **RF1.3**: Permitir el registro de dueños de servicios turísticos con correo, contraseña y datos del negocio.
- **RF1.4**: Permitir el inicio de sesión de dueños de negocios con correo y contraseña.

#### 1.2 Funcionalidades para Turistas

- **RF2.1**: Mostrar un menú de distritos disponibles (Capachica, Llachon, Ticonata).
- **RF2.2**: Permitir al turista seleccionar un distrito.
- **RF2.3**: Mostrar los servicios disponibles de cada distrito (Tours, Hospedaje, Participación en costumbres locales, Restaurantes).
- **RF2.4**: Permitir al turista ver el detalle de cada servicio (descripción, fotos, horarios, ubicación).
- **RF2.5**: Permitir al turista realizar una reserva de un servicio.
- **RF2.6**: Permitir al turista ver un historial de sus reservaciones.

#### 1.3 Funcionalidades para Dueños de Negocio

- **RF3.1**: Permitir al dueño ver el perfil de su negocio registrado.
- **RF3.2**: Permitir al dueño editar la información de su servicio (nombre, descripción, fotos, horarios).
- **RF3.3**: Permitir al dueño ver las reservaciones realizadas a sus servicios.

#### 1.4 Funcionalidades Comunes

- **RF4.1**: Permitir al usuario salir de la aplicación.
- **RF4.2**: Permitir al usuario retroceder a través de pantallas.

### 2. Requerimientos No Funcionales (RNF)

- **RNF1**: La aplicación debe ser responsiva (adaptativa a diferentes tamaños de pantalla).
- **RNF2**: El tiempo de carga de cada pantalla no debe superar los 3 segundos.
- **RNF3**: Las contraseñas deben ser encriptadas en la base de datos.
- **RNF4**: La app debe contar con validaciones de entrada (por ejemplo, correos válidos, contraseñas seguras).
- **RNF5**: El diseño debe ser intuitivo, amigable y en español.
- **RNF6**: Garantizar la privacidad de los datos personales.
- **RNF7**: Compatible con Android 9 y versiones superiores.

### 3. Requerimientos de Datos (RD)

- **RD1**: Guardar datos de turistas (nombre, correo, contraseña encriptada, país, teléfono).
- **RD2**: Guardar datos de dueños de negocio (nombre, tipo de servicio, correo, contraseña, fotos, descripción, ubicación).
- **RD3**: Guardar detalles de los servicios turísticos (tipo, nombre, descripción, precio, horario, fotos).
- **RD4**: Guardar información de reservas (usuario turista, servicio reservado, fecha y hora, estado de la reserva).

### 4. Roles de Usuario

| Rol               | Funciones Principales                                                                 |
|-------------------|----------------------------------------------------------------------------------------|
| **Turista**       | Registrarse, iniciar sesión, buscar distritos, buscar servicios, hacer reservaciones. |
| **Dueño de Negocio** | Registrarse, iniciar sesión, editar información de su negocio, ver reservas recibidas. |

## Prototipos

Puedes ver los prototipos de la aplicación móvil en Figma:  
- [Prototipo en Figma (vista)](https://www.figma.com/proto/eDt0JbWJj7ZaogjJwLUsn8/YakuApp?node-id=0-1&t=ROPQ0LbkbiRLvQBC-1)
- [Prototipo en Figma (prototipo)]([https://www.figma.com/proto/eDt0JbWJj7ZaogjJwLUsn8/YakuApp?node-id=5-78&t=Rsz1wmt13XAkuOyC-1&starting-point-node-id=3%3A51](https://www.figma.com/design/eDt0JbWJj7ZaogjJwLUsn8/YakuApp?node-id=0-1&p=f&t=EhGLq4XerHR7feVn-0))

