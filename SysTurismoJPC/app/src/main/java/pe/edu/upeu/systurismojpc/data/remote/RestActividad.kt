package pe.edu.upeu.systurismojpc.data.remote

import okhttp3.MultipartBody
import pe.edu.upeu.systurismojpc.modelo.ActividadDto
import pe.edu.upeu.systurismojpc.modelo.ActividadResp
import retrofit2.Response
import retrofit2.http.*

interface RestActividad {

    @GET(BASE_RUTA + "/listar")
    suspend fun reportarActividades(@Header("Authorization") token: String): Response<List<ActividadResp>>

    @GET(BASE_RUTA + "/buscar/{id}")
    suspend fun getActividadId(@Header("Authorization") token: String, @Path("id") id: Long): Response<ActividadResp>

    @DELETE(BASE_RUTA + "/eliminar/{id}")
    suspend fun deleteActividad(@Header("Authorization") token: String, @Path("id") id: Long): Response<Unit>

    @PUT(BASE_RUTA + "/editar")
    suspend fun actualizarActividad(
        @Header("Authorization") token: String,
        @Body actividad: ActividadDto
    ): Response<ActividadResp>

    @POST(BASE_RUTA + "/guardar")
    suspend fun insertarActividad(
        @Header("Authorization") token: String,
        @Body actividad: ActividadDto
    ): Response<ActividadResp>

    @Multipart
    @POST("/api/actividad/guardar-con-imagen")
    suspend fun insertarActividadConImagen(
        @Header("Authorization") token: String,
        @Part idDestino: MultipartBody.Part,
        @Part nombre: MultipartBody.Part,
        @Part descripcion: MultipartBody.Part,
        @Part nivelRiesgo: MultipartBody.Part,
        @Part whatsappContacto: MultipartBody.Part,
        @Part precio: MultipartBody.Part,
        @Part imagen: MultipartBody.Part
    ): Response<ActividadResp>

    companion object {
        const val BASE_RUTA = "/api/actividad"
    }
}
