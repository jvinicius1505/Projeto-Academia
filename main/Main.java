package main;

import fachada.Fachada;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Fachada sistema = Fachada.getInstancia();
        System.out.println(">>> INICIANDO TESTES DO SISTEMA DE ACADEMIA <<<");

        Instrutor instrutor = new Instrutor("João", "00011122233", 30, "Musculação");
        List<Exercicio> exercicios = List.of(
            new Exercicio("Supino", "Peitoral"),
            new Exercicio("Agachamento", "Pernas"),
            new Exercicio("Remada Curvada", "Costas")
        );

        System.out.println("\n=============================================");
        System.out.println("    1. TESTANDO CENÁRIOS DE SUCESSO");
        System.out.println("=============================================");

        try {
            System.out.println("\n[TESTE] Cadastrando um novo aluno...");
            Aluno aluno = new Aluno("Lucas", "12345678900", 25, "Mensal");
            sistema.cadastrarAluno(aluno);
            System.out.println("-> SUCESSO: Aluno 'Lucas' cadastrado.");

            System.out.println("\n[TESTE] Criando um novo treino...");
            Treino treino = sistema.criarTreino("Treino de Adaptação", instrutor, exercicios);
            System.out.println("-> SUCESSO: Treino 'Treino de Adaptação' criado.");

            System.out.println("\n[TESTE] Atribuindo treino ao aluno...");
            sistema.atribuirTreino(aluno.getCpf(), treino);
            System.out.println("-> SUCESSO: Treino atribuído ao aluno 'Lucas'.");

            System.out.println("\n[TESTE] Buscando e exibindo dados do aluno...");
            Aluno alunoBuscado = sistema.buscarAluno("12345678900");
            System.out.println("  - Aluno Encontrado: " + alunoBuscado.getNome());
            for (Treino t : alunoBuscado.getTreinos()) {
                System.out.println("    - Treino: " + t.getNome() + " (Instrutor: " + t.getInstrutor().getNome() + ")");
                for (Exercicio e : t.getExercicios()) {
                    System.out.println("      > " + e.getNome() + " (" + e.getGrupoMuscular() + ")");
                }
            }

            System.out.println("\n[TESTE] Listando todos os alunos...");
            System.out.println("-> Alunos cadastrados: " + sistema.listarAlunos().size());


            System.out.println("\n[TESTE] Removendo o aluno...");
            sistema.removerAluno("12345678900");
            System.out.println("-> SUCESSO: Aluno 'Lucas' removido.");

            System.out.println("\n[TESTE] Verificando se o aluno foi removido...");
            System.out.println("-> Alunos cadastrados agora: " + sistema.listarAlunos().size());

        } catch (Exception e) {
            System.err.println("### ERRO INESPERADO EM CENÁRIO DE SUCESSO: " + e.getMessage());
        }

        System.out.println("\n=============================================");
        System.out.println("    2. TESTANDO TRATAMENTO DE EXCEÇÕES");
        System.out.println("=============================================");

        // Teste de cadastro duplicado
        try {
            System.out.println("\n[TESTE] Tentando cadastrar um aluno duplicado...");
            Aluno alunoTemp = new Aluno("Temp", "99988877766", 20, "Diário");
            sistema.cadastrarAluno(alunoTemp); // Primeira vez, sucesso
            sistema.cadastrarAluno(alunoTemp); // Segunda vez, deve falhar
        } catch (IllegalArgumentException e) {
            System.out.println("-> SUCESSO: Capturada exceção esperada. Mensagem: " + e.getMessage());
        }

        // Teste de busca por aluno inexistente
        try {
            System.out.println("\n[TESTE] Tentando buscar um aluno que não existe...");
            sistema.buscarAluno("00000000000");
        } catch (NoSuchElementException e) {
            System.out.println("-> SUCESSO: Capturada exceção esperada. Mensagem: " + e.getMessage());
        }

        // Teste de remoção de aluno inexistente
        try {
            System.out.println("\n[TESTE] Tentando remover um aluno que não existe...");
            sistema.removerAluno("00000000000");
        } catch (IllegalArgumentException e) {
            System.out.println("-> SUCESSO: Capturada exceção esperada. Mensagem: " + e.getMessage());
        }

        // Teste de criação de objeto com dados inválidos (nome nulo)
        try {
            System.out.println("\n[TESTE] Tentando criar um aluno com nome nulo...");
            new Aluno(null, "11122233344", 30, "Anual");
        } catch (IllegalArgumentException e) {
            System.out.println("-> SUCESSO: Capturada exceção esperada. Mensagem: " + e.getMessage());
        }
        
        // Teste de criação de treino com lista de exercícios vazia
        try {
            System.out.println("\n[TESTE] Tentando criar um treino sem exercícios...");
            sistema.criarTreino("Treino Vazio", instrutor, new ArrayList<>());
        } catch (IllegalArgumentException e) {
            System.out.println("-> SUCESSO: Capturada exceção esperada. Mensagem: " + e.getMessage());
        }

        System.out.println("\n\n>>> TODOS OS TESTES FORAM CONCLUÍDOS <<<");
    }
}