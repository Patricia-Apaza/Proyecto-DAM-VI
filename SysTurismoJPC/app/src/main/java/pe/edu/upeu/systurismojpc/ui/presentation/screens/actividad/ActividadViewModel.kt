package pe.edu.upeu.systurismojpc.ui.presentation.screens.actividad

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.systurismojpc.modelo.ActividadDto
import pe.edu.upeu.systurismojpc.modelo.ActividadResp
import pe.edu.upeu.systurismojpc.repository.ActividadRepository
import pe.edu.upeu.systurismojpc.utils.FileUtils
import javax.inject.Inject

@HiltViewModel
class ActividadViewModel @Inject constructor(
    private val actividadRepository: ActividadRepository
) : ViewModel() {

    private val _lista = MutableStateFlow<List<ActividadResp>>(emptyList())
    val lista: StateFlow<List<ActividadResp>> = _lista

    fun getActividades() {
        viewModelScope.launch {
            _lista.value = actividadRepository.reportarActividades()
        }
    }

    fun eliminarActividad(actividad: ActividadDto, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val rpta = actividadRepository.deleteActividad(actividad)
            onResult(rpta)
            getActividades()
        }
    }

    fun guardarActividad(actividad: ActividadDto, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            onResult(actividadRepository.insertarActividad(actividad))
        }
    }

    fun modificarActividad(actividad: ActividadDto, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            onResult(actividadRepository.modificarActividad(actividad))
        }
    }

    suspend fun buscarActividad(id: Long): ActividadResp {
        return actividadRepository.buscarActividadId(id)
    }

    fun guardarActividadConImagen(
        context: Context,
        idDestino: Long,
        nombre: String,
        descripcion: String,
        nivelRiesgo: String,
        whatsappContacto: String,
        precio: Double,
        imagenUri: Uri,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val file = FileUtils.getFileFromUri(context, imagenUri)
            if (file != null) {
                val actividadGuardada = actividadRepository.insertarActividadConImagen(
                    idDestino,
                    nombre,
                    descripcion,
                    nivelRiesgo,
                    whatsappContacto,
                    precio,
                    file
                )
                onResult(actividadGuardada != null)
                if (actividadGuardada != null) {
                    getActividades()
                }
            } else {
                onResult(false)
            }
        }
    }
}
