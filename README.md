# Projeto Academia - Sistema de Gerenciamento de Treinos

Este projeto é um sistema simples para gerenciamento de alunos, instrutores e treinos em uma academia. Desenvolvido em Java, aplica princípios de orientação a objetos, boas práticas de organização em camadas, e simula uma pequena aplicação com funcionalidades essenciais de CRUD e autenticação.

## Estrutura de Pacotes

O projeto está organizado em pacotes separados por responsabilidade, seguindo uma arquitetura em camadas: </br>
src/ </br>
│ </br>
├── model/ → Classes de domínio (entidades): Pessoa, Aluno, Instrutor, Treino, Exercicio </br>
├── repository/ → Repositórios para acesso/simulação de dados: AlunoRepository </br>
├── service/ → Regras de negócio: TreinoService </br>
├── controller/ → Fachada de acesso às funcionalidades da aplicação </br>
└── main/ → Ponto de entrada da aplicação: Main.java </br>


## Conceitos Aplicados

- **Programação Orientada a Objetos (POO)**  
  - Herança (`Aluno` e `Instrutor` estendem `Pessoa`)
  - Encapsulamento de dados e responsabilidades
  - Composição (`Treino` contém `Exercicio`)

- **Camadas da aplicação**  
  - Separação clara entre **modelo**, **serviço**, **repositório**, **fachada** e **interface (main)**

- **Design Patterns**  
  - Fachada (`Fachada.java`) para simplificar o uso do sistema
  - Repositório para abstração de acesso a dados

## Funcionalidades

- Cadastro de alunos e instrutores
- Criação de treinos com exercícios
- Associação de treinos aos alunos
- Listagem de treinos
- Autenticação de usuários do sistema

## Como Executar

1. **Pré-requisitos:**
   - Java JDK 8 ou superior instalado
   - IDE como IntelliJ, Eclipse ou terminal com `javac` e `java`

2. **Compilação e execução via terminal:**
   ```bash
   javac -d bin src/**/*.java
   java -cp bin main.Main
   
3. **Via IDE:**   
  - Importe o projeto como Java Project
  - Rode a classe main.Main

## Autor:
João Vinícius França e Mendonça

*Este projeto foi desenvolvido para a 3a VA de Laboratório de Programação II, do professor Rinaldo Lima da UFRPE.*
