# Desafio Técnico – Backend Nubank

## 📌 Visão Geral

Este projeto consiste no desenvolvimento de uma **API RESTful** para gerenciamento de **clientes** e seus **contatos**, conforme o desafio técnico proposto para a vaga de **Desenvolvedor Backend Júnior – Nubank**.

O objetivo é demonstrar a aplicação de boas práticas no desenvolvimento backend utilizando **Java**, **Spring Boot** e **PostgreSQL**, com foco em organização de código, modelagem de entidades e relacionamentos.

---

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot**

  * Spring Web
  * Spring Data JPA
* **PostgreSQL**
* **Lombok**
* **Maven**

### (Opcionais / Diferenciais)

* Docker
* Swagger (OpenAPI)
* Testes automatizados

---

## 🧱 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas, respeitando o princípio da **separação de responsabilidades**:

* **Controller** → Responsável por expor os endpoints da API
* **Service** → Contém a lógica de negócio
* **Repository** → Comunicação com o banco de dados
* **DTOs** → Objetos para entrada e saída de dados
* **Entities** → Representação das tabelas no banco de dados

---

## 🗂️ Modelagem de Dados

### Cliente

* Um cliente pode possuir **um ou mais contatos**

### Contato

* Um contato pertence a **um único cliente**

Relacionamento:

* **OneToMany** (Cliente → Contatos)
* **ManyToOne** (Contato → Cliente)

---

## 📡 Endpoints Disponíveis

### ➕ Cadastro de Cliente

```
POST /clientes
```

### ➕ Cadastro de Contato (associado a um cliente)

```
POST /contatos
```

### 📄 Listar todos os clientes com seus contatos

```
GET /clientes
```

### 📄 Listar contatos de um cliente específico

```
GET /clientes/{id}/contatos
```

---
