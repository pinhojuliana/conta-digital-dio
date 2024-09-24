# 💰 Projeto Conta Bancária Digital - Lab DIO

Bem-vindo ao projeto **Conta Bancária Digital**, parte do laboratório da DIO. Esse projeto simula operações bancárias em um sistema de contas utilizando orientação a objetos em Java.

## 🏦 Funcionalidades

Este sistema bancário contém as seguintes funcionalidades:

- **Classe Banco**: Gerencia o banco com lista de contas e clientes.
  - Cadastrar clientes 🧑‍🤝‍🧑
  - Cadastrar contas 📑
  - Exibir clientes cadastrados 👤
  - Exibir contas cadastradas 🏦

### 🧑‍💻 Cliente

- **Classe Cliente**: Representa um cliente com os seguintes atributos:
  - Nome ✍️
  - Email 📧
  - Data e Hora de Criação ⏰
  - Implementa a interface `Comparable` para ordenação alfabética dos clientes.
  
- **Pessoa Física**: Extende `Cliente` e adiciona o atributo **CPF** 🆔.
  
- **Pessoa Jurídica**: Extende `Cliente` e adiciona o atributo **CNPJ** 🆔.

### 💳 Conta

- **Classe Conta**: Representa uma conta bancária com os seguintes atributos:
  - Agência 🏦
  - Número da conta 🔢
  - Saldo 💵
  - Cliente associado 👤
  - Histórico de movimentações 💸 (armazenado em um `Map<LocalDateTime, Double>`)

#### Métodos da Classe Conta

- **Sacar**: Permite sacar um valor da conta. 🏧
- **Depositar**: Permite depositar um valor na conta. 💰
- **Transferir**: Realiza a transferência de valores entre contas. 🔄
- **Imprimir Extrato**: Exibe as movimentações e o saldo atual da conta. 📃

## 📚 Conteúdos abordados
- Java
- Orientação a Objetos 
- Collections (List, Map)
- Exceções
- Stream API

## 🤝 Contribuições
**Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.**
