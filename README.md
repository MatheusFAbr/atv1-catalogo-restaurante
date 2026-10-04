# 🍽️ Catálogo Interativo de Restaurante

Aplicativo Android desenvolvido como atividade acadêmica da disciplina de **Programação de Dispositivos Móveis**, com o objetivo de simular um catálogo interativo de restaurante, permitindo visualizar o cardápio, adicionar itens ao pedido, selecionar a forma de pagamento e consultar o resumo final da compra.

O projeto foi desenvolvido em grupo utilizando **Kotlin**, **Jetpack Compose** e **Material Design 3**, com separação de responsabilidades entre modelagem de dados, regras de negócio e interface gráfica.

---

## 📱 Funcionalidades

O aplicativo permite:

- Visualizar pratos e bebidas disponíveis no cardápio;
- Consultar nome, descrição, preço e características dos itens;
- Adicionar produtos ao pedido;
- Controlar a quantidade de itens adicionados;
- Visualizar o resumo do pedido;
- Selecionar a forma de pagamento;
- Realizar pagamento em **Dinheiro**, **Cartão** ou **Pix**;
- Aplicar automaticamente **10% de desconto para pagamentos via Pix**;
- Calcular a taxa de serviço de **10% sobre o subtotal**;
- Calcular subtotal, desconto, taxa de serviço e valor total;
- Exibir um recibo com os valores do pedido;
- Gerar um relatório do pedido no **Logcat**, agrupando os itens por categoria.

---

## 🛠️ Tecnologias utilizadas

- **Kotlin**
- **Android Studio**
- **Jetpack Compose**
- **Material Design 3**
- **Android SDK**
- **Gradle**
- **Git**
- **GitHub**

---

## 🏗️ Estrutura do projeto

O projeto foi organizado separando as diferentes responsabilidades da aplicação:

```text
br.com.pi.catalogorestaurante
│
├── data/
│   └── CardapioRepository.kt
│
├── domain/
│   ├── CalculadoraPedido.kt
│   ├── RelatorioPedido.kt
│   └── ResumoPedido.kt
│
├── model/
│   ├── Bebida.kt
│   ├── FormaPagamento.kt
│   ├── ItemCarrinho.kt
│   ├── ItemMenu.kt
│   └── Prato.kt
│
├── ui/
│   ├── catalogo/
│   │   ├── CatalogoScreen.kt
│   │   └── ItemMenuCard.kt
│   │
│   ├── resumo/
│   │   ├── ItemPedidoRow.kt
│   │   ├── ReciboScreen.kt
│   │   ├── ResumoScreen.kt
│   │   └── SeletorPagamento.kt
│   │
│   └── theme/
│
├── viewmodel/
│   └── PedidoViewModel.kt
│
└── MainActivity.kt
```

---

## 👥 Integrantes e responsabilidades

| Integrante | Responsabilidade |
|---|---|
| **Matheus Ferrari Abrahão** | Modelagem de dados, estrutura base, repositório de dados e integração da aplicação |
| **Leonardo de Lima** | Regras de negócio, cálculos do pedido e geração do relatório |
| **Arthur Fukunaga Fagundes Nepomuceno** | Interface do catálogo e componente visual dos itens |
| **Vinícius de Souza Camargo Costa** | Interface de resumo do pedido, seleção de pagamento e recibo |

### Matheus Ferrari Abrahão — Modelagem e integração

Responsável pela estrutura dos dados utilizados pelo aplicativo, incluindo pratos, bebidas, formas de pagamento e itens do carrinho.

Também realizou a integração da aplicação por meio do `PedidoViewModel`, `CardapioRepository` e `MainActivity`.

### Leonardo de Lima — Regras de negócio

Responsável pela camada de domínio da aplicação, incluindo:

- cálculo do subtotal;
- taxa de serviço;
- desconto de acordo com a forma de pagamento;
- cálculo do valor final;
- geração do relatório do pedido no Logcat.

### Arthur Fukunaga Fagundes Nepomuceno — Catálogo

Responsável pela interface principal do cardápio, incluindo:

- listagem dos itens;
- apresentação dos pratos e bebidas;
- componente reutilizável para os itens do cardápio;
- interação para adicionar produtos ao pedido.

### Vinícius de Souza Camargo Costa — Resumo e pagamento

Responsável pela interface de finalização do pedido, incluindo:

- listagem dos itens selecionados;
- resumo dos valores;
- seleção da forma de pagamento;
- apresentação do recibo do pedido.

---

## 💰 Regras de cálculo

O aplicativo utiliza as seguintes regras para calcular o pedido:

### Subtotal

O subtotal corresponde à soma dos valores de todos os itens considerando suas respectivas quantidades.

```text
Subtotal = Σ (preço × quantidade)
```

### Taxa de serviço

É aplicada uma taxa de serviço de **10% sobre o subtotal**.

```text
Taxa de serviço = subtotal × 10%
```

### Desconto via Pix

Pedidos pagos utilizando **Pix** recebem **10% de desconto sobre o subtotal**.

```text
Desconto Pix = subtotal × 10%
```

### Total

```text
Total = subtotal + taxa de serviço - desconto
```

---

## 🧪 Cenário de validação

Para validar as regras da aplicação, pode ser utilizado o seguinte pedido:

| Item | Quantidade | Valor |
|---|---:|---:|
| Pizza Margherita | 1 | R$ 42,00 |
| Feijoada completa | 1 | R$ 58,00 |
| Suco de laranja | 1 | R$ 12,00 |

Resultado esperado utilizando **Pix**:

```text
Subtotal:            R$ 112,00
Taxa de serviço:     R$  11,20
Desconto Pix:        R$  11,20
--------------------------------
Total:               R$ 112,00
```

Esse cenário demonstra que tanto a taxa de serviço quanto o desconto do Pix são calculados sobre o subtotal.

---

## 📸 Telas da aplicação

### Catálogo

> Adicionar aqui a captura de tela da tela de catálogo.

<!-- Exemplo:
![Tela de Catálogo](docs/catalogo.png)
-->

### Resumo do pedido

> Adicionar aqui a captura de tela da tela de resumo do pedido.

<!-- Exemplo:
![Resumo do Pedido](docs/resumo.png)
-->

---

## 📋 Relatório no Logcat

Ao finalizar o pedido, a aplicação gera um relatório no **Logcat**, apresentando os itens agrupados por categoria e os valores calculados.

> Adicionar aqui uma captura de tela do Logcat após executar o cenário de validação.

<!-- Exemplo:
![Relatório Logcat](docs/logcat.png)
-->

---

## 🔄 Fluxo da aplicação

```text
Catálogo
   │
   ├── Visualizar pratos e bebidas
   │
   └── Adicionar itens
            │
            ▼
      PedidoViewModel
            │
            ▼
     Resumo do pedido
            │
            ├── Selecionar pagamento
            │
            ├── Calcular valores
            │
            └── Finalizar pedido
                     │
                     ▼
              Relatório / Logcat
```

---

## 📚 Objetivo acadêmico

O desenvolvimento deste projeto teve como objetivo aplicar conceitos de desenvolvimento Android com Kotlin, incluindo:

- orientação a objetos;
- modelagem de dados;
- separação de responsabilidades;
- regras de negócio;
- gerenciamento de estado;
- interfaces declarativas com Jetpack Compose;
- componentes reutilizáveis;
- Material Design 3;
- trabalho colaborativo utilizando Git e GitHub;
- branches, commits, Pull Requests e revisão de código.

---

## 📄 Licença

Projeto desenvolvido exclusivamente para fins acadêmicos.
