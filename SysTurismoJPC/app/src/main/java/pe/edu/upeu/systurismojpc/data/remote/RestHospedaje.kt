package pe.edu.upeu.systurismojpc.data.remote

import okhttp3.MultipartBody
import pe.edu.upeu.systurismojpc.modelo.HospedajeDto
import pe.edu.upeu.systurismojpc.modelo.HospedajeResp
import pe.edu.upeu.systurismojpc.modelo.Message
import retrofit2.Response
import retrofit2.http.*

interface RestHospedaje {

    @GET(BASE_RUTA + "/listar")
    suspend fun reportarHospedajes(@Header("Authorization") token: String): Response<List<HospedajeResp>>

    @GET(BASE_RUTA + "/buscar/{id}")
    suspend fun getHospedajeId(@Header("Authorization") token: String, @Path("id") id: Long): Response<HospedajeResp>

    @DELETE(BASE_RUTA + "/eliminar/{id}")
    suspend fun deleteHospedaje(@Header("Authorization") token: String, @Path("id") id: Long): Response<Unit>

    @PUT(BASE_RUTA + "/editar")
    suspend fun actualizarHospedaje(
        @Header("Authorization") token: String,
        @Body hospedaje: HospedajeDto
    ): Response<HospedajeResp>

    @POST(BASE_RUTA + "/guardar")
    suspend fun insertarHospedaje(
        @Header("Authorization") token: String,
        @Body hospedaje: HospedajeDto
    ): Response<HospedajeResp>

    @Multipart
    @POST("/api/hospedaje/guardar-con-imagen")
    suspend fun insertarHospedajeConImagen(
        @Header("Authorization") token: String,
        @Part nombre: MultipartBody.Part,
        @Part descripcion: MultipartBody.Part,
        @Part direccion: MultipartBody.Part,
        @Part whatsappContacto: MultipartBody.Part,
        @Part precioPorNoche: MultipartBody.Part,
        @Part idDestino: MultipartBody.Part,
        @Part imagen: MultipartBody.Part
    ): Response<Void>

    companion object {
        const val BASE_RUTA = "/api/hospedaje"
    }
}