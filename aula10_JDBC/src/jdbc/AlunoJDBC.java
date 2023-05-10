package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {
	
	Connection con;
	String sql;
	PreparedStatement pst;
	
	public void salvar(Aluno a) throws SQLException {
		try {
			con = db.getConexao();
			
			System.out.println("***Conexao realizada com sucesso!*** \n");
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES (?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			Date dataSql = new Date(a.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			pst.executeUpdate();
			System.out.println("***Aluno cadastrado com sucesso!*** \n");
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
		}
	}
	
	public List<Aluno> listarAlunos() throws SQLException {
	    List<Aluno> alunos = new ArrayList<>();
	    try {
	        con = db.getConexao();
	        sql = "SELECT * FROM aluno";
	        pst = con.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            Aluno a = new Aluno();
	            a.setId(rs.getInt("id"));
	            a.setNome(rs.getString("nome"));
	            a.setSexo(rs.getString("sexo"));
	            a.setDt_nasc(rs.getDate("dt_nasc"));
	            alunos.add(a);
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        
	    }
	    return alunos;
	}

	public void apagar(int id) throws SQLException {
	    try {
	        con = db.getConexao();
	        sql = "DELETE FROM aluno WHERE id = ?";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, id);
	        pst.executeUpdate();
	        System.out.println("***Aluno removido com sucesso!*** \n");
	    } catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        
	    }
	}

	public void alterar(Aluno a) throws SQLException {
	    try {
	        con = db.getConexao();
	        sql = "UPDATE aluno SET nome = ?, sexo = ?, dt_nasc = ? WHERE id = ?";
	        pst = con.prepareStatement(sql);
	        pst.setString(1, a.getNome());
	        pst.setString(2, a.getSexo());
	        Date dataSql = new Date(a.getDt_nasc().getTime());
	        pst.setDate(3, dataSql);
	        pst.setInt(4, a.getId());
	        pst.executeUpdate();
	        System.out.println("***Aluno atualizado com sucesso!*** \n");
	    } catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        
	    }
	}

}
