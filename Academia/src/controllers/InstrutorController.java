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
import models.Instrutor;

/**
 *
 * @author Leonardo
 */
public class InstrutorController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Academia");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Instrutor obj){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public  List<Instrutor> Listar(){
        EntityManager em = getEntityManager();
        List<Instrutor> lista = em.createQuery("from Instrutor i").getResultList();
        em.close();
        emf.close();
        return lista;
    }
    
    public  Instrutor Consultar(int id){
        EntityManager em = getEntityManager();
        Instrutor obj = em.find(Instrutor.class, id);
        em.close();
        emf.close();
        return obj;
    }
}
