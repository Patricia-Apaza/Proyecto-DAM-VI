package pe.edu.upeu.systurismojpc.ui.presentation.screens.destino

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pe.edu.upeu.systurismojpc.modelo.DestinoDto

@Composable
fun DestinoFormScreen(
    navController: NavController,
    destinoId: String?,
    destinoViewModel: DestinoViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }

    LaunchedEffect(destinoId) {
        if (!destinoId.isNullOrBlank()) {
            val destino = destinoViewModel.buscarDestino(destinoId.toLong())
            nombre = destino.nombre
            descripcion = destino.descripcion
            ubicacion = destino.ubicacion
        }
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {

        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = ubicacion, onValueChange = { ubicacion = it }, label = { Text("Ubicación") })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val dto = DestinoDto(
                idDestino = destinoId?.toLongOrNull() ?: 0L,
                nombre = nombre,
                descripcion = descripcion,
                ubicacion = ubicacion
            )
            scope.launch {
                if (destinoId.isNullOrBlank()) {
                    destinoViewModel.guardarDestino(dto) {}
                } else {
                    destinoViewModel.modificarDestino(dto) {}
                }
                navController.popBackStack()
            }
        }) {
            Text("Guardar")
        }
    }
}