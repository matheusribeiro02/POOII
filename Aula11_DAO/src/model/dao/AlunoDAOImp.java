package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.db.db;
import model.entities.Aluno;

public class AlunoDAOImp implements AlunoDAO{
	
	private Connection conexao;
	PreparedStatement pst = null; 
	ResultSet rs = null;
	
	public AlunoDAOImp(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Aluno obj) {
		
		try {
			pst = conexao.prepareStatement("INSERT INTO aluno (nomeAluno) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getNomeAluno());
			int linhas = pst.executeUpdate();
			
			if (linhas > 0) {
				rs = pst.getGeneratedKeys();
				if(rs.next()) {
					obj.setIdAluno(rs.getInt(1));
				}
				System.out.println("Aluno " + obj.getNomeAluno() + " cadastrado com sucesso!");
			} else {
				System.out.println("Não foi possível inserir!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.fechaPreparedStatement(pst);
			db.fechaResultSet(rs);
		}
		
	}

	@Override
	public void update(Aluno obj) {
	    try {
	        pst = conexao.prepareStatement("UPDATE aluno SET nomeAluno = ? WHERE idAluno = ?");
	        pst.setString(1, obj.getNomeAluno());
	        pst.setInt(2, obj.getIdAluno());
	        
	        int linhas = pst.executeUpdate();
	        
	        if (linhas > 0) {
	            System.out.println("Aluno atualizado com sucesso!");
	        } else {
	            System.out.println("Não foi possível atualizar o aluno!");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.fechaPreparedStatement(pst);
	    }
	}

	@Override
	public void deleteById(Integer id) {
	    try {
	        pst = conexao.prepareStatement("DELETE FROM aluno WHERE idAluno = ?");
	        pst.setInt(1, id);
	        
	        int linhas = pst.executeUpdate();
	        
	        if (linhas > 0) {
	            System.out.println("Aluno removido com sucesso!");
	        } else {
	            System.out.println("Não foi possível remover o aluno!");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.fechaPreparedStatement(pst);
	    }
	}

	@Override
	public Aluno findById(Integer id) {
	    Aluno aluno = null;
	    
	    try {
	        pst = conexao.prepareStatement("SELECT * FROM aluno WHERE idAluno = ?");
	        pst.setInt(1, id);
	        
	        rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            aluno = new Aluno();
	            aluno.setIdAluno(rs.getInt("idAluno"));
	            aluno.setNomeAluno(rs.getString("nomeAluno"));
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.fechaPreparedStatement(pst);
	        db.fechaResultSet(rs);
	    }
	    
	    return aluno;
	}

	@Override
	public List<Aluno> findAll() {
	    List<Aluno> alunos = new ArrayList<>();
	    
	    try {
	        pst = conexao.prepareStatement("SELECT * FROM curso");
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            Aluno aluno = new Aluno();
	            aluno.setIdAluno(rs.getInt("idAluno"));
	            aluno.setNomeAluno(rs.getString("nomeAluno"));
	            alunos.add(aluno);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.fechaPreparedStatement(pst);
	        db.fechaResultSet(rs);
	    }
	    
	    return alunos;
	}
	
}
