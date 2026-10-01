package br.com.pi.catalogorestaurante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.com.pi.catalogorestaurante.ui.catalogo.CatalogoScreen
import br.com.pi.catalogorestaurante.ui.resumo.ResumoPedidoScreen
import br.com.pi.catalogorestaurante.ui.theme.CatalogoRestauranteTheme
import br.com.pi.catalogorestaurante.viewmodel.PedidoViewModel

class MainActivity : ComponentActivity() {

    private val pedidoViewModel: PedidoViewModel by viewModels()

    private var telaAtual by mutableStateOf(Tela.CATALOGO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatalogoRestauranteTheme {

                when (telaAtual) {

                    Tela.CATALOGO -> {
                        CatalogoScreen(
                            itens = pedidoViewModel.cardapio,
                            quantidadeCarrinho = pedidoViewModel.quantidadeCarrinho,
                            onAdicionarItem = { item ->
                                pedidoViewModel.adicionarItem(item)
                            },
                            onVerPedido = {
                                telaAtual = Tela.RESUMO
                            }
                        )
                    }

                    Tela.RESUMO -> {
                        ResumoPedidoScreen(
                            itens = pedidoViewModel.carrinho,
                            formaPagamento = pedidoViewModel.formaPagamento,
                            resumo = pedidoViewModel.resumo,
                            onFormaPagamentoAlterada = { forma ->
                                pedidoViewModel.selecionarFormaPagamento(forma)
                            },
                            onFinalizarPedido = {
                                pedidoViewModel.finalizarPedido()
                            },
                            onVoltar = {
                                telaAtual = Tela.CATALOGO
                            }
                        )
                    }
                }
            }
        }
    }
}

private enum class Tela {
    CATALOGO,
    RESUMO
}