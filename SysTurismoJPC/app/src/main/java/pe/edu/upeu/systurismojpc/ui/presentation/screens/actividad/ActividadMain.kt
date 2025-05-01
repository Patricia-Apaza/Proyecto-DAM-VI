package pe.edu.upeu.systurismojpc.ui.presentation.screens.actividad

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pe.edu.upeu.systurismojpc.modelo.toDto
import pe.edu.upeu.systurismojpc.ui.navegation.Destinations

@Composable
fun ActividadMainScreen(
    navController: NavController,
    actividadViewModel: ActividadViewModel = hiltViewModel()
) {
    val lista by actividadViewModel.lista.collectAsState()

    LaunchedEffect(true) {
        actividadViewModel.getActividades()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Destinations.ActividadFormSC.passId(null))
            }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).padding(16.dp)) {
            items(lista.size) { index ->
                val actividad = lista[index]
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = actividad.nombre, style = MaterialTheme.typography.titleLarge)
                        Text(text = actividad.descripcion)
                        Text(text = "Precio: S/ ${actividad.precio}")
                        Text(text = "Destino: ${actividad.destino.nombre}")
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            TextButton(onClick = {
                                navController.navigate(Destinations.ActividadFormSC.passId(actividad.idActividad.toString()))
                            }) { Text("Editar") }

                            TextButton(onClick = {
                                actividadViewModel.eliminarActividad(actividad.toDto()) {}
                            }) { Text("Eliminar") }
                        }
                    }
                }
            }
        }
    }
}