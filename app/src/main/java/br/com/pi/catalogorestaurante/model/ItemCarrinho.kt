package br.com.pi.catalogorestaurante.model

data class ItemCarrinho(
    val item: ItemMenu,
    val quantidade: Int = 1
) {
    init {
        require(quantidade > 0) {
            "A quantidade deve ser maior que zero."
        }
    }

    val subtotal: Double
        get() = item.preco * quantidade
}
