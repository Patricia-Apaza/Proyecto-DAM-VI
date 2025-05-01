package pe.edu.upeu.systurismojpc.ui.presentation.screens.destino

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pe.edu.upeu.systurismojpc.modelo.DestinoDto
import pe.edu.upeu.systurismojpc.modelo.toDto
import pe.edu.upeu.systurismojpc.ui.navegation.Destinations


@Composable
fun DestinoMainScreen(
    navController: NavController,
    destinoViewModel: DestinoViewModel = hiltViewModel()
) {
    val lista by destinoViewModel.lista.collectAsState()

    LaunchedEffect(true) {
        destinoViewModel.getDestinos()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Destinations.DestinoFormSC.passId(null))
            }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).padding(16.dp)) {
            items(lista.size) { index ->
                val destino = lista[index]
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = destino.nombre, style = MaterialTheme.typography.titleLarge)
                        Text(text = destino.descripcion)
                        Text(text = destino.ubicacion)
                        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                            TextButton(onClick = {
                                navController.navigate(Destinations.DestinoFormSC.passId(destino.idDestino.toString()))
                            }) { Text("Editar") }

                            TextButton(onClick = {
                                destinoViewModel.eliminarDestino(destino.toDto()) {}
                            }) { Text("Eliminar") }
                        }
                    }
                }
            }
        }
    }
}