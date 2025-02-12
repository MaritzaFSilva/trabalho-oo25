package repository;

import java.util.ArrayList;
import java.util.List;

import dao.AlunosDAO;
import models.Aluno;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {

        AlunosDAO alunosDAO = new AlunosDAO();

        boolean resultado = alunosDAO.salvar(aluno);

        if (resultado) {
            alunos.add(aluno);
        }
    }

    public List<Aluno> listarTodos() {

        // chama o listar do alunosDAO
        return alunos;
    }

    public Aluno buscarPorMatricula(int matricula) {
        return alunos.stream()
                .filter(aluno -> aluno.getMatricula() == matricula)
                .findFirst()
                .orElse(null);
    }

    public void excluir(int matricula) {
        alunos.removeIf(aluno -> aluno.getMatricula() == matricula);
    }
}