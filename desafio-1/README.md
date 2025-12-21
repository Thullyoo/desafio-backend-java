# Desafio Técnico – Java Developer (Softway)

## 📌 Visão Geral

Este projeto foi desenvolvido como parte do **desafio técnico para a vaga de Java Developer na Softway**. O objetivo principal é demonstrar capacidade de **modelagem de dados**, **implementação de regras de negócio**, **boas práticas de código**, **tratamento de erros** e **desacoplamento de componentes**.

O sistema simula um ambiente onde **Empresas** e **Clientes** realizam **transações financeiras** (depósitos e saques), com aplicação de **taxas administrativas**, notificações e callbacks.

---

## 🎯 Objetivos do Sistema

* Existência de dois tipos de usuários:

  * **Empresa**
  * **Cliente**
* Validação de documentos:

  * **CPF** para Cliente
  * **CNPJ** para Empresa
* Cada Empresa possui ao menos um **tipo de taxa do sistema**
* As taxas são aplicadas em **depósitos e saques**
* Empresas mantêm um **saldo**, já considerando o abatimento das taxas
* Clientes podem realizar **depósitos e saques** através das Empresas (respeitando saldo disponível)
* Envio de **callback** para a Empresa a cada transação
* Envio de **notificação** para o Cliente após a transação

---

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot**

  * Spring Web
  * Spring Data JPA
* **Banco de Dados Relacional** (ex: PostgreSQL ou H2 para testes)
* **Lombok**
* **Maven**

### Diferenciais Implementáveis

* Testes automatizados
* Documentação da API
* Proposta de arquitetura

---

## 🧱 Arquitetura e Organização

O projeto segue princípios de **Clean Code** e **boa separação de responsabilidades**:

* **Controller** → Camada responsável pelos endpoints REST
* **Service** → Contém regras de negócio e validações
* **Repository** → Persistência de dados
* **DTOs** → Objetos de entrada e saída
* **Entities** → Modelagem das tabelas
* **Utils / Validators** → Validação de CPF, CNPJ e regras comuns

O código foi estruturado visando **manutenibilidade**, **baixo acoplamento** e **facilidade de evolução**.

---

## 🗂️ Modelagem de Domínio

### Cliente

* CPF válido
* Saldo
* Pode realizar depósitos e saques

### Empresa

* CNPJ válido
* Saldo próprio
* Possui taxas administrativas
* Recebe callbacks de transações

### Transação

* Tipo: Depósito ou Saque
* Valor
* Empresa associada
* Cliente associado
* Taxa aplicada

---

## 📡 Funcionalidades Principais

* Cadastro de Cliente
* Cadastro de Empresa
* Configuração de taxas por Empresa
* Realização de depósitos
* Realização de saques
* Atualização automática de saldos
* Envio de callback para Empresa (simulado via webhook.site)
* Envio de notificação para Cliente (mock)

---

## 🔔 Callbacks e Notificações

* A cada transação, é realizado um **callback HTTP** para a Empresa
* O envio pode falhar propositalmente (simulado com instabilidade)
* Utilizado o site **webhook.site** para simulação
* Cliente recebe uma notificação simulada (log, e-mail mock ou SMS mock)

---

## ⚠️ Tratamento de Erros

* Validação de CPF e CNPJ
* Verificação de saldo disponível
* Tratamento de falhas no callback
* Retornos HTTP adequados
* Mensagens claras para erros de negócio

---
