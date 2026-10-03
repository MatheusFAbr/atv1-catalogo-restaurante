package br.com.pi.catalogorestaurante.domain


import android.util.Log
import br.com.pi.catalogorestaurante.model.Bebida
import br.com.pi.catalogorestaurante.model.FormaPagamento
import br.com.pi.catalogorestaurante.model.ItemCarrinho
import br.com.pi.catalogorestaurante.model.Prato

object RelatorioPedido {

    private const val TAG = "RELATORIO_PEDIDO"

    fun imprimir(
        itens: List<ItemCarrinho>,
        formaPagamento: FormaPagamento,
        resumo: ResumoPedido
    ) {
        Log.d(TAG, "===== RECIBO DO PEDIDO =====")

        val itensAgrupados = itens.groupBy { itemCarrinho ->
            when (itemCarrinho.item) {
                is Prato -> "PRATOS"
                is Bebida -> "BEBIDAS"
            }
        }

        itensAgrupados.forEach { (categoria, itensCategoria) ->

            Log.d(TAG, "--- $categoria ---")

            itensCategoria.forEach { itemCarrinho ->
                Log.d(
                    TAG,
                    "${itemCarrinho.item.nome} | " +
                        "Qtd: ${itemCarrinho.quantidade} | " +
                        "R$ %.2f".format(itemCarrinho.subtotal)
                )
            }
        }

        Log.d(TAG, "--------------------------")
        Log.d(TAG, "Pagamento: ${formaPagamento.descricao}")
        Log.d(TAG, "Subtotal: R$ %.2f".format(resumo.subtotal))
        Log.d(TAG, "Taxa de serviço: R$ %.2f".format(resumo.taxaServico))
        Log.d(TAG, "Desconto: R$ %.2f".format(resumo.desconto))
        Log.d(TAG, "TOTAL: R$ %.2f".format(resumo.total))
        Log.d(TAG, "==========================")
    }
}