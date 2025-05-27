package pe.edu.upeu.systurismojpc.ui.presentation.screens.actividad

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import pe.edu.upeu.systurismojpc.modelo.ActividadDto
import pe.edu.upeu.systurismojpc.modelo.DestinoDto
import pe.edu.upeu.systurismojpc.modelo.DestinoResp
import pe.edu.upeu.systurismojpc.modelo.DestinoSimpleDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActividadFormScreen(
    navController: NavController,
    actividadId: String?,
    actividadViewModel: ActividadViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var idDestino by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var nivelRiesgo by remember { mutableStateOf("") }
    var whatsappContacto by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var imagenPath by remember { mutableStateOf("") }
    var imagenUri by remember { mutableStateOf<Uri?>(null) }

    // Lanzador para seleccionar imagen
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            imagenUri = it
            imagenPath = it.toString()
        }
    }

    // Cargar datos si es edición
    LaunchedEffect(actividadId) {
        if (!actividadId.isNullOrBlank()) {
            val actividad = actividadViewModel.buscarActividad(actividadId.toLong())
            idDestino = actividad.idDestino?.toString() ?: ""
            nombre = actividad.nombre ?: ""
            descripcion = actividad.descripcion ?: ""
            nivelRiesgo = actividad.nivelRiesgo ?: ""
            whatsappContacto = actividad.whatsappContacto ?: ""
            precio = actividad.precio?.toString() ?: ""
            imagenPath = actividad.imagenPath ?: ""
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (actividadId.isNullOrBlank()) "Registrar Actividad" else "Editar Actividad") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = idDestino,
                onValueChange = { idDestino = it },
                label = { Text("ID Destino") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = nivelRiesgo,
                onValueChange = { nivelRiesgo = it },
                label = { Text("Nivel Riesgo") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = whatsappContacto,
                onValueChange = { whatsappContacto = it },
                label = { Text("Whatsapp Contacto") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = precio,
                onValueChange = { precio = it },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { launcher.launch("image/*") },
                modifier = Modifier.fillMaxWidth()
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
                        .padding(vertical = 8.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val idDestinoLong = idDestino.toLongOrNull()
                    val precioDouble = precio.toDoubleOrNull()

                    if (idDestinoLong == null || precioDouble == null || nombre.isBlank()) {
                        // Aquí puedes mostrar un mensaje de error al usuario usando un Toast, Snackbar, etc.
                        return@Button
                    }

                    val actividadDto = ActividadDto(
                        idActividad = actividadId?.toLongOrNull() ?: 0L,
                        idDestino = idDestinoLong,
                        nombre = nombre,
                        descripcion = descripcion,
                        nivelRiesgo = nivelRiesgo,
                        whatsappContacto = whatsappContacto,
                        precio = precioDouble,
                        imagenPath = imagenPath
                    )

                    if (imagenUri != null) {
                        actividadViewModel.guardarActividadConImagen(
                            context,
                            actividadDto.idDestino,
                            actividadDto.nombre,
                            actividadDto.descripcion,
                            actividadDto.nivelRiesgo,
                            actividadDto.whatsappContacto,
                            actividadDto.precio,
                            imagenUri!!
                        ) { success ->
                            if (success) {
                                navController.popBackStack()
                            } else {
                                // Mostrar error (podrías usar un Snackbar o Toast)
                            }
                        }
                    } else {
                        // Si no hay imagen, guardar sin imagen
                        actividadViewModel.guardarActividad(actividadDto) { success ->
                            if (success) {
                                navController.popBackStack()
                            } else {
                                // Mostrar error
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (actividadId.isNullOrBlank()) "Guardar" else "Actualizar")
            }
        }
    }
}