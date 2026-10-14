# 📒 Agenda de Contatos

Uma aplicação de linha de comando desenvolvida em **Java** para gerenciar contatos de forma simples e organizada, com persistência de dados em arquivo de texto.

O projeto foi desenvolvido com foco na prática de conceitos fundamentais da linguagem Java, organização de classes, coleções e manipulação de arquivos.

---

## ✨ Funcionalidades

- ➕ **Cadastrar contatos** — adicionar nome e telefone.
- ✏️ **Editar contatos** — atualizar informações de um contato existente.
- 🗑️ **Excluir contatos** — remover contatos cadastrados.
- 🔤 **Listar por letra** — encontrar contatos pela inicial do nome.
- 🔎 **Pesquisar contatos** — buscar registros por parte do nome.
- 💾 **Persistência de dados** — salvar e carregar contatos usando um arquivo `agenda.txt`.
- ⚠️ **Tratamento de exceções** — lidar com opções inválidas e situações de erro.

## 🛠️ Tecnologias utilizadas

- **Java** — linguagem de programação.
- **Collections Framework** — organização e manipulação dos contatos.
- **Java I/O** — leitura e gravação de arquivos.
- **Expressões regulares** — suporte à pesquisa de contatos por parte do nome.

## 📂 Estrutura do projeto

```text
src/
├── Main.java
├── Aplicacao.java
├── Agenda.java
├── Contato.java
├── Menu.java
├── ArquivoAgenda.java
├── Console.java
└── AgendaException.java

agenda.txt
README.md
```

*A estrutura acima é ilustrativa. Ajuste os caminhos conforme a organização real do projeto.*

## ▶️ Como executar

### Pré-requisitos

- JDK instalado.
- IDE Java, como IntelliJ IDEA, Eclipse ou VS Code, ou um terminal com o compilador Java configurado.

### Executando pela IDE

1. Clone ou baixe este repositório.
2. Abra o projeto na sua IDE.
3. Localize a classe `Main.java`.
4. Execute o método `main()`.

### Executando pelo terminal

Se os arquivos estiverem organizados sem declarações de `package`, compilados a partir da pasta que contém os arquivos `.java`, você pode usar:

```bash
javac *.java
java Main
```

Se as classes estiverem organizadas em pacotes ou em uma pasta `src`, ajuste o comando de compilação conforme a estrutura do projeto.

## 💾 Persistência de dados

Os contatos são armazenados no arquivo `agenda.txt`, permitindo que os registros sejam carregados quando a aplicação for iniciada novamente.

Formato ilustrativo:

```text
Naruto Uzumaki,1111-1111
Sasuke Uchiha,2222-2222
```

Cada linha representa um contato, com nome e telefone separados por vírgula. O arquivo deve seguir o formato esperado pela classe `ArquivoAgenda`.

## 🎯 Objetivos de aprendizagem

Este projeto permite praticar conceitos importantes do desenvolvimento em Java:

- Programação orientada a objetos (POO).
- Encapsulamento e responsabilidades das classes.
- Listas, mapas e ordenação de dados.
- Métodos, construtores e tratamento de exceções.
- Manipulação de arquivos e persistência local.
- Separação entre regras de negócio e interação com o usuário.

## 🚀 Próximas melhorias

- [ ] Implementar testes automatizados.
- [ ] Melhorar a validação de nomes e telefones.
- [ ] Aprimorar o tratamento de erros de leitura e gravação.
- [ ] Adicionar confirmação antes de excluir contatos.
- [ ] Criar uma interface gráfica.
- [ ] Migrar a persistência para um banco de dados.

---

👨‍💻 Autor

Eros Almeida



