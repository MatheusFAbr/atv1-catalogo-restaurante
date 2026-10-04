package br.com.pi.catalogorestaurante.ui.resumo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pi.catalogorestaurante.domain.ResumoPedido
import br.com.pi.catalogorestaurante.model.FormaPagamento
import br.com.pi.catalogorestaurante.model.ItemCarrinho

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun ResumoPedidoScreen(
    itens: List<ItemCarrinho>,
    formaPagamento: FormaPagamento,
    resumo: ResumoPedido,
    onFormaPagamentoAlterada: (FormaPagamento) -> Unit,
    onFinalizarPedido: () -> Unit,
    onVoltar: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Resumo do Pedido")
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Itens selecionados",
                style = MaterialTheme.typography.titleMedium
            )

            if (itens.isEmpty()) {
                Text("Nenhum item foi adicionado.")
            } else {
                itens.forEach { item ->
                    ItemPedidoRow(
                        itemCarrinho = item
                    )
                }
            }

            Text(
                text = "Forma de pagamento",
                style = MaterialTheme.typography.titleMedium
            )

            SeletorPagamento(
                formaSelecionada = formaPagamento,
                onFormaSelecionada = onFormaPagamentoAlterada
            )

            Text(
                text = "Recibo",
                style = MaterialTheme.typography.titleMedium
            )

            ReciboPedido(
                resumo = resumo
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onFinalizarPedido,
                enabled = itens.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Finalizar pedido")
            }

            OutlinedButton(
                onClick = onVoltar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Voltar ao catálogo")
            }
        }
    }
}