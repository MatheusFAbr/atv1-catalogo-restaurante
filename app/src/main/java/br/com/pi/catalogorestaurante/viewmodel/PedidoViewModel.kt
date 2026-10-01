package br.com.pi.catalogorestaurante.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.pi.catalogorestaurante.data.CardapioRepository
import br.com.pi.catalogorestaurante.domain.CalculadoraPedido
import br.com.pi.catalogorestaurante.domain.RelatorioPedido
import br.com.pi.catalogorestaurante.domain.ResumoPedido
import br.com.pi.catalogorestaurante.model.FormaPagamento
import br.com.pi.catalogorestaurante.model.ItemCarrinho
import br.com.pi.catalogorestaurante.model.ItemMenu

class PedidoViewModel : ViewModel() {

    val cardapio: List<ItemMenu> = CardapioRepository.obterItens()

    var carrinho by mutableStateOf<List<ItemCarrinho>>(emptyList())
        private set

    var formaPagamento by mutableStateOf(FormaPagamento.DINHEIRO)
        private set

    val quantidadeCarrinho: Int
        get() = carrinho.sumOf { it.quantidade }

    val resumo: ResumoPedido
        get() = CalculadoraPedido.calcularResumo(
            itens = carrinho,
            formaPagamento = formaPagamento
        )

    fun adicionarItem(item: ItemMenu) {
        val itemExistente = carrinho.find {
            it.item.id == item.id
        }

        carrinho = if (itemExistente == null) {
            carrinho + ItemCarrinho(
                item = item,
                quantidade = 1
            )
        } else {
            carrinho.map {
                if (it.item.id == item.id) {
                    it.copy(
                        quantidade = it.quantidade + 1
                    )
                } else {
                    it
                }
            }
        }
    }

    fun selecionarFormaPagamento(
        formaPagamento: FormaPagamento
    ) {
        this.formaPagamento = formaPagamento
    }

    fun finalizarPedido() {
        RelatorioPedido.imprimir(
            itens = carrinho,
            formaPagamento = formaPagamento,
            resumo = resumo
        )
    }
}