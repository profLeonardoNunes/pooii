/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Categoria;

/**
 *
 * @author Leonardo
 */
public class Crud {
    
    private static EntityManagerFactory emf;

    private static EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("Produtos");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Object obj){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
