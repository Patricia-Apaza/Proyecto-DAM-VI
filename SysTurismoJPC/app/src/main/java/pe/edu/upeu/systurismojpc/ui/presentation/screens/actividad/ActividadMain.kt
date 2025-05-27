package pe.edu.upeu.systurismojpc.ui.presentation.screens.actividad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import pe.edu.upeu.systurismojpc.modelo.ActividadResp
import pe.edu.upeu.systurismojpc.modelo.toDto
import pe.edu.upeu.systurismojpc.ui.navegation.Destinations

fun construirUrlImagenActividad(path: String): String {
    val baseUrl = "http://10.0.2.2:8081/api/actividad/imagen/"
    return if (path.startsWith("http")) path else baseUrl + path
}

@Composable
fun MostrarImagenActividadDesdePath(imagenPath: String?) {
    val fullUrl = when {
        imagenPath.isNullOrBlank() -> null
        imagenPath.startsWith("http") -> imagenPath
        imagenPath.startsWith("/imagenes/") -> "http://10.0.2.2:8081$imagenPath"
        else -> "http://10.0.2.2:8081/api/actividad/imagen/$imagenPath"
    }

    if (fullUrl != null) {
        AsyncImage(
            model = fullUrl,
            contentDescription = "Imagen de la Actividad",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 8.dp),
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text("Sin imagen", color = Color.DarkGray)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
        topBar = {
            TopAppBar(title = { Text("Actividades") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Destinations.ActividadFormSC.passId(null))
            }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(lista) { actividad: ActividadResp ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = actividad.nombre, style = MaterialTheme.typography.titleMedium)
                        Text(text = actividad.descripcion, style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Nivel de Riesgo: ${actividad.nivelRiesgo}", style = MaterialTheme.typography.bodySmall)
                        Text(text = "Whatsapp: ${actividad.whatsappContacto}", style = MaterialTheme.typography.bodySmall)
                        Text(text = "Precio: S/ ${actividad.precio}", style = MaterialTheme.typography.bodySmall)

                        // Mostrar la imagen desde el backend
                        MostrarImagenActividadDesdePath(imagenPath = actividad.imagenPath)

                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ) {
                            IconButton(onClick = {
                                navController.navigate(Destinations.ActividadFormSC.passId(actividad.idActividad.toString()))
                            }) {
                                Icon(Icons.Default.Edit, contentDescription = "Editar")
                            }
                            IconButton(onClick = {
                                actividadViewModel.eliminarActividad(actividad.toDto()) {}
                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }
}
