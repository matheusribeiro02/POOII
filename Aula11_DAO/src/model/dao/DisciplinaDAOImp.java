package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.db.db;
import model.entities.Disciplina;


public class DisciplinaDAOImp implements DisciplinaDAO {
    
    private Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public DisciplinaDAOImp(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void insert(Disciplina obj) {
        
        try {
            pst = conexao.prepareStatement("INSERT INTO disciplina (nomeDisciplina) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNomeDisciplina());
            int linhas = pst.executeUpdate();
            
            if (linhas > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    obj.setIdDisciplina(rs.getInt(1));
                }
                System.out.println("Disciplina " + obj.getNomeDisciplina() + " cadastrada com sucesso!");
            } else {
                System.out.println("Não foi possível inserir a disciplina!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.fechaPreparedStatement(pst);
            db.fechaResultSet(rs);
        }
        
    }
    
    @Override
    public void update(Disciplina obj) {
        try {
            pst = conexao.prepareStatement("UPDATE disciplina SET nomeDisciplina = ? WHERE idDisciplina = ?");
            pst.setString(1, obj.getNomeDisciplina());
            pst.setInt(2, obj.getIdDisciplina());
            
            int linhas = pst.executeUpdate();
            
            if (linhas > 0) {
                System.out.println("Disciplina atualizada com sucesso!");
            } else {
                System.out.println("Não foi possível atualizar a disciplina!");
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
            pst = conexao.prepareStatement("DELETE FROM disciplina WHERE idDisciplina = ?");
            pst.setInt(1, id);
            
            int linhas = pst.executeUpdate();
            
            if (linhas > 0) {
                System.out.println("Disciplina removida com sucesso!");
            } else {
                System.out.println("Não foi possível remover a disciplina!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.fechaPreparedStatement(pst);
        }
    }
    
    @Override
    public Disciplina findById(Integer id) {
        Disciplina disciplina = null;
        
        try {
            pst = conexao.prepareStatement("SELECT * FROM disciplina WHERE idDisciplina = ?");
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                disciplina = new Disciplina();
                disciplina.setIdDisciplina(rs.getInt("idDisciplina"));
                disciplina.setNomeDisciplina(rs.getString("nomeDisciplina"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.fechaPreparedStatement(pst);
            db.fechaResultSet(rs);
        }
        
        return disciplina;
    }
    
    @Override
    public List<Disciplina> findAll() {
        List<Disciplina> disciplinas = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT * FROM disciplina");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setIdDisciplina(rs.getInt("idDisciplina"));
                disciplina.setNomeDisciplina(rs.getString("nomeDisciplina"));
                disciplinas.add(disciplina);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.fechaPreparedStatement(pst);
            db.fechaResultSet(rs);
        }
        
        return disciplinas;
    }
    
}

