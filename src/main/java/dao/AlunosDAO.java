package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.FabricaConexao;
import models.Aluno;

public class AlunosDAO {

    /**
     * ADICIONAR
     * 
     * @param aluno
     * @return
     */
    public boolean salvar(Aluno a) {

        try {
            // Criar a conexão
            Connection con = FabricaConexao.getInstance().getConnection();

            // faz o insert

            String sql = "INSERT INTO aluno(matricula, nome, cpf, data_nascimento, endereco, telefone, email) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, a.getMatricula());
           
            

            int res = pstm.executeUpdate();
            if (res == 1) {
                return true;
            } else {
                return false;
            }

            
        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    /**
     * LISTAR
     */

    /**
     * buscar aluno por matricula
     */
}
