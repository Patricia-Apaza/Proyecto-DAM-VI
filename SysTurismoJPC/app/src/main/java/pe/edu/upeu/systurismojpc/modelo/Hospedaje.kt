package pe.edu.upeu.systurismojpc.modelo

data class HospedajeDto(
    var idHospedaje: Long,
    var nombre: String,
    var descripcion: String,
    var direccion: String,
    var whatsappContacto: String,
    var precioPorNoche: Double,
    var imagenPath: String,
    var idDestino: Long
)

data class HospedajeSimpleDto(
    var idHospedaje: Long
)

data class HospedajeResp(
    val idHospedaje: Long,
    val nombre: String,
    val descripcion: String,
    val direccion: String,
    val whatsappContacto: String,
    val precioPorNoche: Double,
    val imagenPath: String,
    val idDestino: Long,
    val destinoNombre: String? = null 
)

fun HospedajeResp.toDto(): HospedajeDto {
    return HospedajeDto(
        idHospedaje = this.idHospedaje,
        nombre = this.nombre,
        descripcion = this.descripcion,
        direccion = this.direccion,
        whatsappContacto = this.whatsappContacto,
        precioPorNoche = this.precioPorNoche,
        imagenPath = this.imagenPath,
        idDestino = this.idDestino
    )
}