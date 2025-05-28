package pe.edu.upeu.systurismojpc.ui.presentation.screens.hospedaje

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.systurismojpc.modelo.HospedajeDto
import pe.edu.upeu.systurismojpc.modelo.HospedajeResp
import pe.edu.upeu.systurismojpc.modelo.DestinoResp
import pe.edu.upeu.systurismojpc.repository.HospedajeRepository
import pe.edu.upeu.systurismojpc.repository.DestinoRepository
import pe.edu.upeu.systurismojpc.utils.FileUtils
import javax.inject.Inject

@HiltViewModel
class HospedajeViewModel @Inject constructor(
    private val hospedajeRepository: HospedajeRepository,
    private val destinoRepository: DestinoRepository
) : ViewModel() {

    private val _lista = MutableStateFlow<List<HospedajeResp>>(emptyList())
    val lista: StateFlow<List<HospedajeResp>> = _lista

    private val _destinos = MutableStateFlow<List<DestinoResp>>(emptyList())
    val destinos: StateFlow<List<DestinoResp>> = _destinos

    fun getHospedajes() {
        viewModelScope.launch {
            _lista.value = hospedajeRepository.reportarHospedajes()
        }
    }

    fun getDestinos() {
        viewModelScope.launch {
            _destinos.value = destinoRepository.reportarDestinos()
        }
    }

    fun eliminarHospedaje(hospedaje: HospedajeDto, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val rpta = hospedajeRepository.deleteHospedaje(hospedaje)
            onResult(rpta)
            getHospedajes()
        }
    }

    fun guardarHospedaje(hospedaje: HospedajeDto, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            onResult(hospedajeRepository.insertarHospedaje(hospedaje))
        }
    }

    fun modificarHospedaje(hospedaje: HospedajeDto, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            onResult(hospedajeRepository.modificarHospedaje(hospedaje))
        }
    }

    suspend fun buscarHospedaje(id: Long): HospedajeResp {
        return hospedajeRepository.buscarHospedajeId(id)
    }

    fun guardarHospedajeConImagen(
        context: Context,
        nombre: String,
        descripcion: String,
        direccion: String,
        whatsappContacto: String,
        precioPorNoche: Double,
        idDestino: Long,
        imagenUri: Uri,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val file = FileUtils.getFileFromUri(context, imagenUri)
            if (file != null) {
                val resultado = hospedajeRepository.insertarHospedajeConImagen(
                    nombre, descripcion, direccion, whatsappContacto, precioPorNoche, idDestino, file
                )
                onResult(resultado)
                getHospedajes()
            } else {
                onResult(false)
            }
        }
    }
}