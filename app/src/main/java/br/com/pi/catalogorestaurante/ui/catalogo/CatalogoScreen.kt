package br.com.pi.catalogorestaurante.ui.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pi.catalogorestaurante.model.ItemMenu

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun CatalogoScreen(
    itens: List<ItemMenu>,
    quantidadeCarrinho: Int,
    onAdicionarItem: (ItemMenu) -> Unit,
    onVerPedido: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Catálogo do Restaurante")
                }
            )
        },
        bottomBar = {
            Button(
                onClick = onVerPedido,
                enabled = quantidadeCarrinho > 0,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Ver pedido ($quantidadeCarrinho)")
            }
        }
    ) { paddingValues ->

        if (itens.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Nenhum item disponível no cardápio.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = itens,
                    key = { it.id }
                ) { item ->
                    ItemMenuCard(
                        item = item,
                        onAdicionar = onAdicionarItem
                    )
                }
            }
        }
    }
}