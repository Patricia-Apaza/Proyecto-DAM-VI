package pe.edu.upeu.systurismojpc.repository

import pe.edu.upeu.systurismojpc.modelo.HospedajeDto
import pe.edu.upeu.systurismojpc.modelo.HospedajeResp
import java.io.File

interface HospedajeRepository {
    suspend fun deleteHospedaje(hospedaje: HospedajeDto): Boolean
    suspend fun reportarHospedajes(): List<HospedajeResp>
    suspend fun buscarHospedajeId(id: Long): HospedajeResp
    suspend fun insertarHospedaje(hospedaje: HospedajeDto): Boolean
    suspend fun modificarHospedaje(hospedaje: HospedajeDto): Boolean
    suspend fun insertarHospedajeConImagen(
        nombre: String,
        descripcion: String,
        direccion: String,
        whatsappContacto: String,
        precioPorNoche: Double,
        idDestino: Long,
        imageFile: File
    ): Boolean
}