package pe.edu.upeu.systurismojpc.ui.presentation.screens.cliente

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pe.edu.upeu.systurismojpc.modelo.ClienteResp
import pe.edu.upeu.systurismojpc.ui.navegation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClienteMain(
    navController: NavController,
    navegarEditarAct: (String) -> Unit,
    viewModel: ClienteViewModel = hiltViewModel()
) {
    val listaClientes by viewModel.listaClientes.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.cargarClientes()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Administrar Clientes") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Destinations.ClienteFormSC.passId("0"))
            }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar Cliente")
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(listaClientes) { cliente ->
                ClienteItem(cliente = cliente, onEdit = {
                    navegarEditarAct(cliente.idCliente.toString())
                }, onDelete = {
                    viewModel.eliminarCliente(cliente)
                })
                Divider()
            }
        }
    }
}

@Composable
fun ClienteItem(
    cliente: ClienteResp,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = cliente.nombreCompleto, style = MaterialTheme.typography.titleMedium)
            Text(text = cliente.correo, style = MaterialTheme.typography.bodyMedium)
            Text(text = cliente.telefono, style = MaterialTheme.typography.bodyMedium)
        }
        Row {
            IconButton(onClick = onEdit) {
                Icon(Icons.Default.Edit, contentDescription = "Editar")
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar")
            }
        }
    }
}