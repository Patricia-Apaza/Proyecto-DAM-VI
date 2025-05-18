package pe.edu.upeu.systurismojpc.repository

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import pe.edu.upeu.systurismojpc.data.remote.RestDestino
import pe.edu.upeu.systurismojpc.modelo.DestinoDto
import pe.edu.upeu.systurismojpc.modelo.DestinoResp
import pe.edu.upeu.systurismojpc.utils.TokenUtils
import java.io.File
import javax.inject.Inject

class DestinoRepositoryImp @Inject constructor(
    private val restDestino: RestDestino
) : DestinoRepository {

    override suspend fun deleteDestino(destino: DestinoDto): Boolean {
        val response = restDestino.deleteDestino(TokenUtils.TOKEN_CONTENT, destino.idDestino)
        return response.isSuccessful
    }

    override suspend fun reportarDestinos(): List<DestinoResp> {
        val response = restDestino.reportarDestinos(TokenUtils.TOKEN_CONTENT)
        return if (response.isSuccessful) response.body() ?: emptyList() else emptyList()
    }

    override suspend fun buscarDestinoId(id: Long): DestinoResp {
        val response = restDestino.getDestinoId(TokenUtils.TOKEN_CONTENT, id)
        return response.body() ?: throw Exception("Destino no encontrado")
    }

    override suspend fun insertarDestino(destino: DestinoDto): Boolean {
        val response = restDestino.insertarDestino(TokenUtils.TOKEN_CONTENT, destino)
        return response.isSuccessful && response.body()?.idDestino != null
    }

    override suspend fun modificarDestino(destino: DestinoDto): Boolean {
        val response = restDestino.actualizarDestino(TokenUtils.TOKEN_CONTENT, destino)
        return response.isSuccessful && response.body()?.idDestino != null
    }

    override suspend fun insertarDestinoConImagen(
        nombre: String,
        descripcion: String,
        ubicacion: String,
        imageFile: File
    ): Boolean {
        val requestFile = imageFile.asRequestBody("image/*".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("imagen", imageFile.name, requestFile)

        val nombrePart = MultipartBody.Part.createFormData("nombre", nombre)
        val descripcionPart = MultipartBody.Part.createFormData("descripcion", descripcion)
        val ubicacionPart = MultipartBody.Part.createFormData("ubicacion", ubicacion)

        val response = restDestino.insertarDestinoConImagen(
            TokenUtils.TOKEN_CONTENT,
            nombrePart,
            descripcionPart,
            ubicacionPart,
            body
        )
        return response.isSuccessful
    }
}
