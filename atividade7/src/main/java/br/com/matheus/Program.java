package br.com.matheus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entities.Automovel;
import Entities.Marca;
import Entities.Modelo;

public class Program {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividade7");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            
            Marca marca = new Marca();
            marca.setNome("Minha Marca");

           
            Modelo modelo = new Modelo();
            modelo.setDescricao("Meu Modelo");
            modelo.setMarca(marca);

            
            Automovel automovel = new Automovel();
            automovel.setAnoFabricacao(2023);
            automovel.setAnoModelo(2023);
            automovel.setPreco(50000);
            automovel.setModelo(modelo);

            // Persiste os objetos
            em.persist(marca);
            em.persist(modelo);
            em.persist(automovel);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

