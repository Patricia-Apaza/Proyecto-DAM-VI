package pe.edu.upeu.systurismojpc.repository

import pe.edu.upeu.systurismojpc.modelo.DestinoDto
import pe.edu.upeu.systurismojpc.modelo.DestinoResp
import java.io.File

interface DestinoRepository {
    suspend fun deleteDestino(destino: DestinoDto): Boolean
    suspend fun reportarDestinos(): List<DestinoResp>
    suspend fun buscarDestinoId(id: Long): DestinoResp
    suspend fun insertarDestino(destino: DestinoDto): Boolean
    suspend fun modificarDestino(destino: DestinoDto): Boolean
    suspend fun insertarDestinoConImagen(
        nombre: String,
        descripcion: String,
        ubicacion: String,
        imageFile: File
    ): Boolean
}
