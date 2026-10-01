package br.com.pi.catalogorestaurante.model

enum class FormaPagamento(
    val descricao: String,
    val percentualDesconto: Double
) {
    DINHEIRO("Dinheiro", 0.0),
    CARTAO("Cartão", 0.0),
    PIX("Pix", 0.10)
}
