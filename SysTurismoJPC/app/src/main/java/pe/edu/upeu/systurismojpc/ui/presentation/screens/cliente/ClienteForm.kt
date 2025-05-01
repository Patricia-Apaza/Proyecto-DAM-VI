package pe.edu.upeu.systurismojpc.ui.presentation.screens.cliente

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pe.edu.upeu.systurismojpc.modelo.ClienteDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClienteForm(
    text: String,
    darkMode: Boolean,
    navController: NavController,
    viewModel: ClienteViewModel = hiltViewModel()
) {
    val id = text.toLongOrNull() ?: 0L

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }

    LaunchedEffect(id) {
        if (id != 0L) {
            val cliente = viewModel.buscarPorId(id)
            cliente?.let {
                nombre = it.nombreCompleto
                correo = it.correo
                telefono = it.telefono
                direccion = it.direccion
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(if (id == 0L) "Registrar Cliente" else "Editar Cliente") })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre Completo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = direccion,
                onValueChange = { direccion = it },
                label = { Text("Dirección") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val cliente = ClienteDto(
                        idCliente = id,
                        nombreCompleto = nombre,
                        correo = correo,
                        telefono = telefono,
                        direccion = direccion
                    )

                    if (id == 0L) {
                        viewModel.insertarCliente(cliente)
                    } else {
                        viewModel.modificarCliente(cliente)
                    }

                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (id == 0L) "Guardar" else "Actualizar")
            }
        }
    }
}