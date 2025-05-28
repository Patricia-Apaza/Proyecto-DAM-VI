package pe.edu.upeu.systurismojpc.ui.presentation.screens.hospedaje

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import pe.edu.upeu.systurismojpc.modelo.HospedajeDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospedajeFormScreen(
    navController: NavController,
    hospedajeId: String?,
    hospedajeViewModel: HospedajeViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var whatsappContacto by remember { mutableStateOf("") }
    var precioPorNoche by remember { mutableStateOf("") }
    var imagenPath by remember { mutableStateOf("") }
    var destinoSeleccionado by remember { mutableStateOf(0L) }
    var expanded by remember { mutableStateOf(false) }

    val destinos by hospedajeViewModel.destinos.collectAsState()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            imagenPath = it.toString()
        }
    }

    LaunchedEffect(hospedajeId) {
        hospedajeViewModel.getDestinos()
        if (!hospedajeId.isNullOrBlank()) {
            val hospedaje = hospedajeViewModel.buscarHospedaje(hospedajeId.toLong())
            nombre = hospedaje.nombre
            descripcion = hospedaje.descripcion
            direccion = hospedaje.direccion
            whatsappContacto = hospedaje.whatsappContacto
            precioPorNoche = hospedaje.precioPorNoche.toString()
            imagenPath = hospedaje.imagenPath ?: ""
            destinoSeleccionado = hospedaje.idDestino
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (hospedajeId.isNullOrBlank()) "Registrar Hospedaje" else "Editar Hospedaje") }
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
                        HospedajeFields(
                            nombre = nombre,
                            onNombreChange = { nombre = it },
                            descripcion = descripcion,
                            onDescripcionChange = { descripcion = it },
                            direccion = direccion,
                            onDireccionChange = { direccion = it },
                            whatsappContacto = whatsappContacto,
                            onWhatsappContactoChange = { whatsappContacto = it },
                            precioPorNoche = precioPorNoche,
                            onPrecioPorNocheChange = { precioPorNoche = it },
                            destinos = destinos,
                            destinoSeleccionado = destinoSeleccionado,
                            onDestinoSeleccionado = { destinoSeleccionado = it },
                            expanded = expanded,
                            onExpandedChange = { expanded = it }
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
                            HospedajeFields(
                                nombre = nombre,
                                onNombreChange = { nombre = it },
                                descripcion = descripcion,
                                onDescripcionChange = { descripcion = it },
                                direccion = direccion,
                                onDireccionChange = { direccion = it },
                                whatsappContacto = whatsappContacto,
                                onWhatsappContactoChange = { whatsappContacto = it },
                                precioPorNoche = precioPorNoche,
                                onPrecioPorNocheChange = { precioPorNoche = it },
                                destinos = destinos,
                                destinoSeleccionado = destinoSeleccionado,
                                onDestinoSeleccionado = { destinoSeleccionado = it },
                                expanded = expanded,
                                onExpandedChange = { expanded = it }
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
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
                            val precio = precioPorNoche.toDoubleOrNull() ?: 0.0
                            if (hospedajeId.isNullOrBlank()) {
                                hospedajeViewModel.guardarHospedajeConImagen(
                                    context = context,
                                    nombre = nombre,
                                    descripcion = descripcion,
                                    direccion = direccion,
                                    whatsappContacto = whatsappContacto,
                                    precioPorNoche = precio,
                                    idDestino = destinoSeleccionado,
                                    imagenUri = Uri.parse(imagenPath)
                                ) { success ->
                                    if (success) {
                                        navController.popBackStack()
                                    }
                                }
                            } else {
                                val dto = HospedajeDto(
                                    idHospedaje = hospedajeId.toLong(),
                                    nombre = nombre,
                                    descripcion = descripcion,
                                    direccion = direccion,
                                    whatsappContacto = whatsappContacto,
                                    precioPorNoche = precio,
                                    imagenPath = imagenPath,
                                    idDestino = destinoSeleccionado
                                )
                                hospedajeViewModel.modificarHospedaje(dto) {
                                    navController.popBackStack()
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (hospedajeId.isNullOrBlank()) "Guardar" else "Actualizar")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospedajeFields(
    nombre: String, onNombreChange: (String) -> Unit,
    descripcion: String, onDescripcionChange: (String) -> Unit,
    direccion: String, onDireccionChange: (String) -> Unit,
    whatsappContacto: String, onWhatsappContactoChange: (String) -> Unit,
    precioPorNoche: String, onPrecioPorNocheChange: (String) -> Unit,
    destinos: List<pe.edu.upeu.systurismojpc.modelo.DestinoResp>,
    destinoSeleccionado: Long,
    onDestinoSeleccionado: (Long) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
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
        value = direccion,
        onValueChange = onDireccionChange,
        label = { Text("Dirección") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )

    OutlinedTextField(
        value = whatsappContacto,
        onValueChange = onWhatsappContactoChange,
        label = { Text("WhatsApp Contacto") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )

    OutlinedTextField(
        value = precioPorNoche,
        onValueChange = onPrecioPorNocheChange,
        label = { Text("Precio por Noche") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = onExpandedChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        OutlinedTextField(
            value = destinos.find { it.idDestino == destinoSeleccionado }?.nombre ?: "Seleccionar Destino",
            onValueChange = {},
            readOnly = true,
            label = { Text("Destino") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) }
        ) {
            destinos.forEach { destino ->
                DropdownMenuItem(
                    text = { Text(destino.nombre) },
                    onClick = {
                        onDestinoSeleccionado(destino.idDestino)
                        onExpandedChange(false)
                    }
                )
            }
        }
    }
}