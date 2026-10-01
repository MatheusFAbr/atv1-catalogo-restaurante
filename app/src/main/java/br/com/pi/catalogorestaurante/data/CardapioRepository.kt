package br.com.pi.catalogorestaurante.data

import br.com.pi.catalogorestaurante.model.Bebida
import br.com.pi.catalogorestaurante.model.ItemMenu
import br.com.pi.catalogorestaurante.model.Prato

object CardapioRepository {

    fun obterItens(): List<ItemMenu> {
        return listOf(
            Prato(
                id = 1,
                nome = "Pizza Margherita",
                preco = 42.0,
                descricao = "Molho de tomate, muçarela e manjericão",
                vegetariano = true,
                individual = true
            ),
            Prato(
                id = 2,
                nome = "Feijoada completa",
                preco = 58.0,
                descricao = null,
                vegetariano = false,
                individual = true
            ),
            Prato(
                id = 3,
                nome = "Risoto de cogumelos",
                preco = 46.0,
                descricao = "Arroz arbóreo com cogumelos e parmesão",
                vegetariano = true,
                individual = true
            ),
            Bebida(
                id = 4,
                nome = "Suco de laranja",
                preco = 12.0,
                descricao = "Suco natural de laranja",
                alcoolica = false
            ),
            Bebida(
                id = 5,
                nome = "Refrigerante",
                preco = 8.0,
                descricao = null,
                alcoolica = false
            ),
            Bebida(
                id = 6,
                nome = "Cerveja",
                preco = 14.0,
                descricao = "Long neck",
                alcoolica = true
            )
        )
    }
}