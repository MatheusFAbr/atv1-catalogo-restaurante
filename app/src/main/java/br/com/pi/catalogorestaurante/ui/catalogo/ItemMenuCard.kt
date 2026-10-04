package br.com.pi.catalogorestaurante.ui.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pi.catalogorestaurante.model.Bebida
import br.com.pi.catalogorestaurante.model.ItemMenu
import br.com.pi.catalogorestaurante.model.Prato

@Composable
fun ItemMenuCard(
    item: ItemMenu,
    onAdicionar: (ItemMenu) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.nome,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "R$ %.2f".format(item.preco),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            item.descricao?.let { descricao ->
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = descricao,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            when (item) {
                is Prato -> {
                    Text(
                        text = buildString {
                            append(if (item.individual) "Individual" else "Para compartilhar")

                            if (item.vegetariano) {
                                append(" • Vegetariano")
                            }
                        },
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                is Bebida -> {
                    Text(
                        text = if (item.alcoolica) {
                            "Bebida alcoólica"
                        } else {
                            "Bebida não alcoólica"
                        },
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { onAdicionar(item) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Adicionar ao pedido")
            }
        }
    }
}