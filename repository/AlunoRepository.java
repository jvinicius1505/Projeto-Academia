package repository;

import model.Aluno;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AlunoRepository {
    private static AlunoRepository instancia;
    private Map<String, Aluno> alunos = new HashMap<>();

    private AlunoRepository() {}

    public static synchronized AlunoRepository getInstancia() {
        if (instancia == null) {
            instancia = new AlunoRepository();
        }
        return instancia;
    }

    public void adicionar(Aluno aluno) {
        if (aluno == null || aluno.getCpf() == null) {
            throw new IllegalArgumentException("Aluno ou CPF não pode ser nulo.");
        }
        if (alunos.containsKey(aluno.getCpf())) {
            throw new IllegalArgumentException("Aluno com o CPF " + aluno.getCpf() + " já cadastrado.");
        }
        alunos.put(aluno.getCpf(), aluno);
    }

    public Aluno buscar(String cpf) {
        if (cpf == null) {
            return null;
        }
        return alunos.get(cpf);
    }

    public void remover(String cpf) {
        if (cpf == null || !alunos.containsKey(cpf)) {
            throw new IllegalArgumentException("Aluno com o CPF " + cpf + " não encontrado para remoção.");
        }
        alunos.remove(cpf);
    }

    public Collection<Aluno> listarTodos() {
        return alunos.values();
    }
}