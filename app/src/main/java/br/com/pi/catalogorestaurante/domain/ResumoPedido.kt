package br.com.pi.catalogorestaurante.domain


data class ResumoPedido(
    val subtotal: Double,
    val taxaServico: Double,
    val desconto: Double,
    val total: Double
)