package com.example.documentos.ui.theme.Documentos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.documentos.data.dto.DocumentoDTO

@Composable
fun Consult(documentos: List<DocumentoDTO>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Lista de documentos", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(documentos) { documento ->
                DocumentoItem(documento)
            }
        }
    }
}

@Composable
fun DocumentoItem(documento: DocumentoDTO, viewModel: DocumentoViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Nombre: " + documento.NombreCliente, style = MaterialTheme.typography.titleMedium)
            Text(text = "Fecha: " + documento.Fecha, style = MaterialTheme.typography.titleMedium)
            Text(text = "Rnc: " + documento.Rnc, style = MaterialTheme.typography.titleMedium)
            Text(text = "Cantidad: " + documento.Cantidad.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Precio: " + documento.Precio.toString(), style = MaterialTheme.typography.titleMedium)
        }
    }
}