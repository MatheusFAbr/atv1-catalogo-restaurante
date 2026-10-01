package br.com.pi.catalogorestaurante.model

abstract class ItemMenu(
    open val id: Int,
    open val nome: String,
    open val preco: Double,
    open val descricao: String? = null
) {
    abstract val categoria: String
}
