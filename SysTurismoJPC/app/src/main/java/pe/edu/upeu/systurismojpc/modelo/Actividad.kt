package pe.edu.upeu.systurismojpc.modelo

data class ActividadDto(
    var idActividad: Long,
    var idDestino: Long,
    var nombre: String,
    var descripcion: String,
    var nivelRiesgo: String,
    var whatsappContacto: String,
    var precio: Double,
    var imagenPath: String
)

data class ActividadSimpleDto(
    var idActividad: Long
)

data class ActividadResp(
    val idActividad: Long,
    val idDestino: Long,
    val nombre: String,
    val descripcion: String,
    val nivelRiesgo: String,
    val whatsappContacto: String,
    val precio: Double,
    val imagenPath: String
)

fun ActividadResp.toDto(): ActividadDto {
    return ActividadDto(
        idActividad = this.idActividad,
        idDestino = this.idDestino,
        nombre = this.nombre,
        descripcion = this.descripcion,
        nivelRiesgo = this.nivelRiesgo,
        whatsappContacto = this.whatsappContacto,
        precio = this.precio,
        imagenPath = this.imagenPath
    )
}
