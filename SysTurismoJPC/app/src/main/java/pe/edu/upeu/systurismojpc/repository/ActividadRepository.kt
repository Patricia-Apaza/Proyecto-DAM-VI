package pe.edu.upeu.systurismojpc.repository

import pe.edu.upeu.systurismojpc.modelo.ActividadDto
import pe.edu.upeu.systurismojpc.modelo.ActividadResp

interface ActividadRepository {
    suspend fun deleteActividad(actividad: ActividadDto): Boolean
    suspend fun reportarActividades(): List<ActividadResp>
    suspend fun buscarActividadId(id: Long): ActividadResp
    suspend fun insertarActividad(actividad: ActividadDto): Boolean
    suspend fun modificarActividad(actividad: ActividadDto): Boolean
}