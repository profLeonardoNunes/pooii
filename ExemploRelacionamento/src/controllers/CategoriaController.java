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
import model.Categoria;
import model.Produto;

/**
 *
 * @author Leonardo
 */
public class CategoriaController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Produtos");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Categoria categ){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(categ);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public  List<Categoria> Listar(){
        EntityManager em = getEntityManager();
        List<Categoria> categorias = em.createQuery("from Categoria c").getResultList();
        em.close();
        emf.close();
        return categorias;
    }
    
    public  Categoria Consultar(int id){
        EntityManager em = getEntityManager();
        Categoria categoria = em.find(Categoria.class, id);
        em.close();
        emf.close();
        return categoria;
    }
    
}
