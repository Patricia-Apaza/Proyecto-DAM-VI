package pe.edu.upeu.systurismojpc.repository

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import pe.edu.upeu.systurismojpc.data.remote.RestHospedaje
import pe.edu.upeu.systurismojpc.modelo.HospedajeDto
import pe.edu.upeu.systurismojpc.modelo.HospedajeResp
import pe.edu.upeu.systurismojpc.utils.TokenUtils
import java.io.File
import javax.inject.Inject

class HospedajeRepositoryImp @Inject constructor(
    private val restHospedaje: RestHospedaje
) : HospedajeRepository {

    override suspend fun deleteHospedaje(hospedaje: HospedajeDto): Boolean {
        val response = restHospedaje.deleteHospedaje(TokenUtils.TOKEN_CONTENT, hospedaje.idHospedaje)
        return response.isSuccessful
    }

    override suspend fun reportarHospedajes(): List<HospedajeResp> {
        val response = restHospedaje.reportarHospedajes(TokenUtils.TOKEN_CONTENT)
        return if (response.isSuccessful) response.body() ?: emptyList() else emptyList()
    }

    override suspend fun buscarHospedajeId(id: Long): HospedajeResp {
        val response = restHospedaje.getHospedajeId(TokenUtils.TOKEN_CONTENT, id)
        return response.body() ?: throw Exception("Hospedaje no encontrado")
    }

    override suspend fun insertarHospedaje(hospedaje: HospedajeDto): Boolean {
        val response = restHospedaje.insertarHospedaje(TokenUtils.TOKEN_CONTENT, hospedaje)
        return response.isSuccessful && response.body()?.idHospedaje != null
    }

    override suspend fun modificarHospedaje(hospedaje: HospedajeDto): Boolean {
        val response = restHospedaje.actualizarHospedaje(TokenUtils.TOKEN_CONTENT, hospedaje)
        return response.isSuccessful && response.body()?.idHospedaje != null
    }

    override suspend fun insertarHospedajeConImagen(
        nombre: String,
        descripcion: String,
        direccion: String,
        whatsappContacto: String,
        precioPorNoche: Double,
        idDestino: Long,
        imageFile: File
    ): Boolean {
        val requestFile = imageFile.asRequestBody("image/*".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("imagen", imageFile.name, requestFile)

        val nombrePart = MultipartBody.Part.createFormData("nombre", nombre)
        val descripcionPart = MultipartBody.Part.createFormData("descripcion", descripcion)
        val direccionPart = MultipartBody.Part.createFormData("direccion", direccion)
        val whatsappPart = MultipartBody.Part.createFormData("whatsappContacto", whatsappContacto)
        val precioPart = MultipartBody.Part.createFormData("precioPorNoche", precioPorNoche.toString())
        val destinoPart = MultipartBody.Part.createFormData("idDestino", idDestino.toString())

        val response = restHospedaje.insertarHospedajeConImagen(
            TokenUtils.TOKEN_CONTENT,
            nombrePart,
            descripcionPart,
            direccionPart,
            whatsappPart,
            precioPart,
            destinoPart,
            body
        )
        return response.isSuccessful
    }
}