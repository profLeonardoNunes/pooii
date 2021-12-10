/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Aluno;

/**
 *
 * @author Leonardo
 */
public class AlunoController {

    private static EntityManagerFactory emf;

    private static EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("Academia");
        }
        return emf.createEntityManager();
    }

    public void Cadastrar(Aluno obj) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public List<Aluno> Listar() {
        EntityManager em = getEntityManager();
        List<Aluno> lista = em.createQuery("from Aluno a").getResultList();
        em.close();
        emf.close();
        return lista;
    }

    public Aluno Consultar(int id) {
        EntityManager em = getEntityManager();
        Aluno obj = em.find(Aluno.class, id);
        em.close();
        emf.close();
        return obj;
    }

}
