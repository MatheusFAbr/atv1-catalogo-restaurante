# Catálogo Interativo de Restaurante

Aplicativo Android desenvolvido para a disciplina de Programação de Dispositivos Móveis.

O projeto consiste em um catálogo de restaurante onde o usuário pode visualizar pratos e bebidas, adicionar itens ao pedido, escolher uma forma de pagamento e consultar o resumo da compra.

## Funcionalidades

- Listagem de pratos e bebidas
- Adição de itens ao pedido
- Controle da quantidade de itens
- Resumo do pedido
- Seleção da forma de pagamento
- Pagamento em Dinheiro, Cartão ou Pix
- Desconto de 10% para pagamento via Pix
- Taxa de serviço de 10%
- Cálculo do subtotal e valor final
- Geração do relatório do pedido no Logcat

## Tecnologias

- Kotlin
- Jetpack Compose
- Material Design 3
- Android Studio
- Git e GitHub

## Estrutura do projeto

O projeto foi dividido em camadas para separar a modelagem dos dados, regras de negócio e interface.

```text
br.com.pi.catalogorestaurante
├── data
├── domain
├── model
├── ui
│   ├── catalogo
│   ├── resumo
│   └── theme
├── viewmodel
└── MainActivity.kt
```

### Model

Contém as classes utilizadas para representar os itens do cardápio, pratos, bebidas, formas de pagamento e itens adicionados ao carrinho.

### Domain

Responsável pelas regras de negócio, incluindo os cálculos do pedido e a geração do relatório.

### UI

Contém as telas e componentes desenvolvidos com Jetpack Compose.

### ViewModel

Responsável pelo estado do pedido e pela comunicação entre a interface e as regras de negócio.

## Integrantes

| Integrante | Responsabilidade |
| --- | --- |
| Matheus Ferrari Abrahão | Modelagem de dados e integração da aplicação |
| Leonardo de Lima | Regras de negócio e cálculos do pedido |
| Arthur Fukunaga Fagundes Nepomuceno | Interface do catálogo |
| Vinícius de Souza Camargo Costa | Interface de resumo e pagamento |

## Regras do pedido

A taxa de serviço corresponde a **10% do subtotal**.

Para pagamentos via **Pix**, é aplicado um desconto de **10% sobre o subtotal**.

O valor final é calculado da seguinte forma:

```text
Total = Subtotal + Taxa de Serviço - Desconto
```

## Cenário de teste

Para validação dos cálculos foi utilizado o seguinte pedido:

| Item | Quantidade | Valor |
| --- | ---: | ---: |
| Pizza Margherita | 1 | R$ 42,00 |
| Feijoada completa | 1 | R$ 58,00 |
| Suco de laranja | 1 | R$ 12,00 |

Com pagamento via Pix:

```text
Subtotal:        R$ 112,00
Taxa de serviço: R$  11,20
Desconto:        R$  11,20
Total:           R$ 112,00
```

## Execução

1. Clone o repositório.
2. Abra o projeto no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Inicie um emulador Android ou conecte um dispositivo físico.
5. Execute o aplicativo.

## Capturas de tela

As capturas das principais telas da aplicação serão adicionadas nesta seção.

### Catálogo

<!-- ![Catálogo](docs/catalogo.png) -->

### Resumo do pedido

<!-- ![Resumo](docs/resumo.png) -->

### Logcat

<!-- ![Logcat](docs/logcat.png) -->
