package br.com.pi.catalogorestaurante.model

data class Bebida(
    override val id: Int,
    override val nome: String,
    override val preco: Double,
    override val descricao: String? = null,
    val alcoolica: Boolean = false
) : ItemMenu(id, nome, preco, descricao) {

    override val categoria: String = "Bebidas"
}
