package pe.edu.upeu.systurismojpc.ui.presentation.screens.destino

import androidx.compose.foundation.Image
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
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import pe.edu.upeu.systurismojpc.modelo.toDto
import pe.edu.upeu.systurismojpc.ui.navegation.Destinations
import coil.compose.AsyncImage


fun construirUrlImagen(path: String): String {
    val baseUrl = "http://10.0.2.2:8081/api/destino/imagen/"
    return if (path.startsWith("http")) path else baseUrl + path
}

@Composable
fun MostrarImagenDesdePath(imagenPath: String?) {
    val fullUrl = when {
        imagenPath.isNullOrBlank() -> null
        imagenPath.startsWith("http") -> imagenPath
        imagenPath.startsWith("/imagenes/") -> "http://10.0.2.2:8081$imagenPath"
        else -> "http://10.0.2.2:8081/api/destino/imagen/$imagenPath"
    }

    if (fullUrl != null) {
        AsyncImage(
            model = fullUrl,
            contentDescription = "Imagen del Destino",
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
fun DestinoMainScreen(
    navController: NavController,
    destinoViewModel: DestinoViewModel = hiltViewModel()
) {
    val lista by destinoViewModel.lista.collectAsState()

    LaunchedEffect(true) {
        destinoViewModel.getDestinos()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Destinos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Destinations.DestinoFormSC.passId(null))
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
            items(lista) { destino ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = destino.nombre, style = MaterialTheme.typography.titleMedium)
                        Text(text = destino.descripcion, style = MaterialTheme.typography.bodyMedium)
                        Text(text = destino.ubicacion, style = MaterialTheme.typography.bodySmall)

                        // ✅ Mostrar la imagen desde el backend
                        MostrarImagenDesdePath(imagenPath = destino.imagenPath)

                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ) {
                            IconButton(onClick = {
                                navController.navigate(Destinations.DestinoFormSC.passId(destino.idDestino.toString()))
                            }) {
                                Icon(Icons.Default.Edit, contentDescription = "Editar")
                            }
                            IconButton(onClick = {
                                destinoViewModel.eliminarDestino(destino.toDto()) {}
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
