package pe.edu.upeu.systurismojpc.ui.presentation.screens.destino

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import pe.edu.upeu.systurismojpc.modelo.DestinoDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinoFormScreen(
    navController: NavController,
    destinoId: String?,
    destinoViewModel: DestinoViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    var imagenPath by remember { mutableStateOf("") }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            imagenPath = it.toString()
        }
    }

    LaunchedEffect(destinoId) {
        if (!destinoId.isNullOrBlank()) {
            val destino = destinoViewModel.buscarDestino(destinoId.toLong())
            nombre = destino.nombre
            descripcion = destino.descripcion
            ubicacion = destino.ubicacion
            imagenPath = destino.imagenPath ?: ""
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (destinoId.isNullOrBlank()) "Registrar Destino" else "Editar Destino") }
            )
        }
    ) { paddingValues ->
        BoxWithConstraints(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val isCompact = maxWidth < 600.dp

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isCompact) {
                    Column {
                        DestinoFields(
                            nombre, { nombre = it },
                            descripcion, { descripcion = it },
                            ubicacion, { ubicacion = it }
                        )

                        Button(
                            onClick = {
                                launcher.launch("image/*")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Text("Seleccionar Imagen")
                        }

                        if (imagenPath.isNotBlank()) {
                            AsyncImage(
                                model = imagenPath,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .padding(bottom = 8.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                } else {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Column(modifier = Modifier.weight(1f)) {
                            DestinoFields(
                                nombre, { nombre = it },
                                descripcion, { descripcion = it },
                                "", {}
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            DestinoFields(
                                "", {},
                                "", {},
                                ubicacion, { ubicacion = it }
                            )

                            Button(
                                onClick = {
                                    launcher.launch("image/*")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            ) {
                                Text("Seleccionar Imagen")
                            }

                            if (imagenPath.isNotBlank()) {
                                AsyncImage(
                                    model = imagenPath,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(180.dp)
                                        .padding(bottom = 8.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        scope.launch {
                            if (destinoId.isNullOrBlank()) {
                                destinoViewModel.guardarDestinoConImagen(
                                    context = context,
                                    nombre = nombre,
                                    descripcion = descripcion,
                                    ubicacion = ubicacion,
                                    imagenUri = Uri.parse(imagenPath)
                                ) { success ->
                                    if (success) {
                                        navController.popBackStack()
                                    } else {
                                        // Mostrar error si deseas
                                    }
                                }
                            } else {
                                val dto = DestinoDto(
                                    idDestino = destinoId.toLong(),
                                    nombre = nombre,
                                    descripcion = descripcion,
                                    ubicacion = ubicacion,
                                    imagenPath = imagenPath
                                )
                                destinoViewModel.modificarDestino(dto) {
                                    navController.popBackStack()
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (destinoId.isNullOrBlank()) "Guardar" else "Actualizar")
                }
            }
        }
    }
}


@Composable
fun DestinoFields(
    nombre: String, onNombreChange: (String) -> Unit,
    descripcion: String, onDescripcionChange: (String) -> Unit,
    ubicacion: String, onUbicacionChange: (String) -> Unit
) {
    OutlinedTextField(
        value = nombre,
        onValueChange = onNombreChange,
        label = { Text("Nombre") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )

    OutlinedTextField(
        value = descripcion,
        onValueChange = onDescripcionChange,
        label = { Text("Descripción") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )

    OutlinedTextField(
        value = ubicacion,
        onValueChange = onUbicacionChange,
        label = { Text("Ubicación") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}
