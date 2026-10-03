package br.com.pi.catalogorestaurante.domain


import br.com.pi.catalogorestaurante.model.FormaPagamento
import br.com.pi.catalogorestaurante.model.ItemCarrinho

object CalculadoraPedido {

    private const val PERCENTUAL_TAXA_SERVICO = 0.10

    fun calcularSubtotal(itens: List<ItemCarrinho>): Double {
        return itens.sumOf { it.subtotal }
    }

    fun calcularTaxaServico(subtotal: Double): Double {
        return subtotal * PERCENTUAL_TAXA_SERVICO
    }

    fun calcularDesconto(
        subtotal: Double,
        formaPagamento: FormaPagamento
    ): Double {
        return subtotal * formaPagamento.percentualDesconto
    }

    fun calcularResumo(
        itens: List<ItemCarrinho>,
        formaPagamento: FormaPagamento
    ): ResumoPedido {

        val subtotal = calcularSubtotal(itens)
        val taxaServico = calcularTaxaServico(subtotal)
        val desconto = calcularDesconto(
            subtotal = subtotal,
            formaPagamento = formaPagamento
        )

        val total = subtotal + taxaServico - desconto

        return ResumoPedido(
            subtotal = subtotal,
            taxaServico = taxaServico,
            desconto = desconto,
            total = total
        )
    }
}