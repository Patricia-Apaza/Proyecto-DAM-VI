package pe.edu.upeu.systurismojpc.ui.presentation.screens.actividad

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pe.edu.upeu.systurismojpc.modelo.ActividadDto

@Composable
fun ActividadFormScreen(
    navController: NavController,
    actividadId: String?,
    actividadViewModel: ActividadViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var destinoId by remember { mutableStateOf("") }

    LaunchedEffect(actividadId) {
        if (!actividadId.isNullOrBlank()) {
            val actividad = actividadViewModel.buscarActividad(actividadId.toLong())
            nombre = actividad.nombre
            descripcion = actividad.descripcion
            precio = actividad.precio.toString()
            destinoId = actividad.destino.idDestino.toString()
        }
    }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = precio, onValueChange = { precio = it }, label = { Text("Precio") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = destinoId, onValueChange = { destinoId = it }, label = { Text("ID de Destino") })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val dto = ActividadDto(
                idActividad = actividadId?.toLongOrNull() ?: 0L,
                nombre = nombre,
                descripcion = descripcion,
                precio = precio.toDoubleOrNull() ?: 0.0,
                destino = destinoId.toLongOrNull() ?: 0L
            )
            scope.launch {
                if (actividadId.isNullOrBlank()) {
                    actividadViewModel.guardarActividad(dto) {}
                } else {
                    actividadViewModel.modificarActividad(dto) {}
                }
                navController.popBackStack()
            }
        }) {
            Text("Guardar")
        }
    }
}