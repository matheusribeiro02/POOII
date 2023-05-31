package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.db.db;
import model.entities.Curso;

public class CursoDAOImp implements CursoDAO{
	
	private Connection conexao;
	PreparedStatement pst = null; 
	ResultSet rs = null;
	
	public CursoDAOImp(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Curso obj) {
		
		try {
			pst = conexao.prepareStatement("INSERT INTO curso (nomeCurso) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getNomeCurso());
			int linhas = pst.executeUpdate();
			
			if (linhas > 0) {
				rs = pst.getGeneratedKeys();
				if(rs.next()) {
					obj.setIdCurso(rs.getInt(1));
				}
				System.out.println("Curso " + obj.getNomeCurso() + " cadastrado com sucesso!");
			} else {
				System.out.println("N�o foi poss�vel inserir!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.fechaPreparedStatement(pst);
			db.fechaResultSet(rs);
		}
		
	}

	@Override
	public void update(Curso obj) {
	    try {
	        pst = conexao.prepareStatement("UPDATE curso SET nomeCurso = ? WHERE idCurso = ?");
	        pst.setString(1, obj.getNomeCurso());
	        pst.setInt(2, obj.getIdCurso());
	        
	        int linhas = pst.executeUpdate();
	        
	        if (linhas > 0) {
	            System.out.println("Curso atualizado com sucesso!");
	        } else {
	            System.out.println("Não foi possível atualizar o curso!");
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
	        pst = conexao.prepareStatement("DELETE FROM curso WHERE idCurso = ?");
	        pst.setInt(1, id);
	        
	        int linhas = pst.executeUpdate();
	        
	        if (linhas > 0) {
	            System.out.println("Curso removido com sucesso!");
	        } else {
	            System.out.println("Não foi possível remover o curso!");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.fechaPreparedStatement(pst);
	    }
	}

	@Override
	public Curso findById(Integer id) {
	    Curso curso = null;
	    
	    try {
	        pst = conexao.prepareStatement("SELECT * FROM curso WHERE idCurso = ?");
	        pst.setInt(1, id);
	        
	        rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            curso = new Curso();
	            curso.setIdCurso(rs.getInt("idCurso"));
	            curso.setNomeCurso(rs.getString("nomeCurso"));
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.fechaPreparedStatement(pst);
	        db.fechaResultSet(rs);
	    }
	    
	    return curso;
	}

	@Override
	public List<Curso> findAll() {
	    List<Curso> cursos = new ArrayList<>();
	    
	    try {
	        pst = conexao.prepareStatement("SELECT * FROM curso");
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            Curso curso = new Curso();
	            curso.setIdCurso(rs.getInt("idCurso"));
	            curso.setNomeCurso(rs.getString("nomeCurso"));
	            cursos.add(curso);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.fechaPreparedStatement(pst);
	        db.fechaResultSet(rs);
	    }
	    
	    return cursos;
	}
	
}
