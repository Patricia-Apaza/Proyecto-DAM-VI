package pe.edu.upeu.systurismojpc.modelo

data class ActividadDto(
    var idActividad: Long,
    var nombre: String,
    var descripcion: String,
    var precio: Double,
    var destino: Long // Solo se envía el ID del destino
)

data class ActividadResp(
    val idActividad: Long,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val destino: DestinoResp
)

fun ActividadResp.toDto(): ActividadDto {
    return ActividadDto(
        idActividad = this.idActividad,
        nombre = this.nombre,
        descripcion = this.descripcion,
        precio = this.precio,
        destino = this.destino.idDestino
    )
}
