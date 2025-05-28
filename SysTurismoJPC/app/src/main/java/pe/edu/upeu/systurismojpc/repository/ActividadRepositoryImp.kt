package pe.edu.upeu.systurismojpc.repository

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import pe.edu.upeu.systurismojpc.data.remote.RestActividad
import pe.edu.upeu.systurismojpc.modelo.ActividadDto
import pe.edu.upeu.systurismojpc.modelo.ActividadResp
import pe.edu.upeu.systurismojpc.utils.TokenUtils
import java.io.File
import javax.inject.Inject

class ActividadRepositoryImp @Inject constructor(
    private val restActividad: RestActividad
) : ActividadRepository {

    override suspend fun deleteActividad(actividad: ActividadDto): Boolean {
        val response = restActividad.deleteActividad(TokenUtils.TOKEN_CONTENT, actividad.idActividad)
        return response.isSuccessful
    }

    override suspend fun reportarActividades(): List<ActividadResp> {
        val response = restActividad.reportarActividades(TokenUtils.TOKEN_CONTENT)
        return if (response.isSuccessful) response.body() ?: emptyList() else emptyList()
    }

    override suspend fun buscarActividadId(id: Long): ActividadResp {
        val response = restActividad.getActividadId(TokenUtils.TOKEN_CONTENT, id)
        return response.body() ?: throw Exception("Actividad no encontrada")
    }

    override suspend fun insertarActividad(actividad: ActividadDto): Boolean {
        val response = restActividad.insertarActividad(TokenUtils.TOKEN_CONTENT, actividad)
        return response.isSuccessful && response.body()?.idActividad != null
    }

    override suspend fun modificarActividad(actividad: ActividadDto): Boolean {
        val response = restActividad.actualizarActividad(TokenUtils.TOKEN_CONTENT, actividad)
        return response.isSuccessful && response.body()?.idActividad != null
    }

    override suspend fun insertarActividadConImagen(
        idDestino: Long,
        nombre: String,
        descripcion: String,
        nivelRiesgo: String,
        whatsappContacto: String,
        precio: Double,
        imageFile: File
    ): ActividadResp? {
        val requestFile = imageFile.asRequestBody("image/*".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("imagen", imageFile.name, requestFile)

        val idDestinoPart = MultipartBody.Part.createFormData("idDestino", idDestino.toString())
        val nombrePart = MultipartBody.Part.createFormData("nombre", nombre)
        val descripcionPart = MultipartBody.Part.createFormData("descripcion", descripcion)
        val nivelRiesgoPart = MultipartBody.Part.createFormData("nivelRiesgo", nivelRiesgo)
        val whatsappPart = MultipartBody.Part.createFormData("whatsappContacto", whatsappContacto)
        val precioPart = MultipartBody.Part.createFormData("precio", precio.toString())

        val response = restActividad.insertarActividadConImagen(
            TokenUtils.TOKEN_CONTENT,
            idDestinoPart,
            nombrePart,
            descripcionPart,
            nivelRiesgoPart,
            whatsappPart,
            precioPart,
            body
        )
        return if (response.isSuccessful) response.body() else null
    }
}
