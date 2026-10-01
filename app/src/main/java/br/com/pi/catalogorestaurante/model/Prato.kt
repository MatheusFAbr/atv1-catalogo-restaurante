package br.com.pi.catalogorestaurante.model

data class Prato(
    override val id: Int,
    override val nome: String,
    override val preco: Double,
    override val descricao: String? = null,
    val vegetariano: Boolean = false,
    val individual: Boolean = true
) : ItemMenu(id, nome, preco, descricao) {

    override val categoria: String = "Pratos"
}
