package br.com.pi.catalogorestaurante.ui.resumo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pi.catalogorestaurante.model.FormaPagamento

@Composable
fun SeletorPagamento(
    formaSelecionada: FormaPagamento,
    onFormaSelecionada: (FormaPagamento) -> Unit
) {
    Column {
        FormaPagamento.entries.forEach { forma ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = forma == formaSelecionada,
                    onClick = {
                        onFormaSelecionada(forma)
                    }
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = if (forma == FormaPagamento.PIX) {
                        "${forma.descricao} (10% de desconto)"
                    } else {
                        forma.descricao
                    }
                )
            }
        }
    }
}