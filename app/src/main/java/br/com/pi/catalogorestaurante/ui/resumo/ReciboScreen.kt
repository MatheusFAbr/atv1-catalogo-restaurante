package br.com.pi.catalogorestaurante.ui.resumo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.HorizontalDivider
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pi.catalogorestaurante.domain.ResumoPedido

@Composable
fun ReciboPedido(
    resumo: ResumoPedido
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LinhaValor(
            titulo = "Subtotal",
            valor = resumo.subtotal
        )

        LinhaValor(
            titulo = "Taxa de serviço (10%)",
            valor = resumo.taxaServico
        )

        LinhaValor(
            titulo = "Desconto",
            valor = -resumo.desconto
        )

        Spacer(modifier = Modifier.height(4.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "R$ %.2f".format(resumo.total),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
private fun LinhaValor(
    titulo: String,
    valor: Double
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(titulo)

        Text(
            text = "R$ %.2f".format(valor)
        )
    }
}