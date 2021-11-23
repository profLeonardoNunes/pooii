/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import model.Produto;

/**
 *
 * @author Leonardo
 */
public class ProdutoController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("Produtos");
        }
        return emf.createEntityManager();
    }
    
    public void Cadastrar(Produto prod){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void Atualizar(Produto prod){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(prod);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public  List<Produto> Listar(){
        EntityManager em = getEntityManager();
        List<Produto> produtos = em.createQuery("from Produto p").getResultList();
        em.close();
        emf.close();
        return produtos;
    }
    
    //Consulta uma lista de produtos cujo nome contenham o parametro nome
    public  List<Produto> ListarPorNome(String nome){
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("from Produto p where nome like :nome");
        consulta.setParameter("nome", "%"+nome+"%");
        
        List<Produto> produtos = consulta.getResultList();
        
        em.close();
        emf.close();
        return produtos;
    }
    
    
     public  Produto Consultar(int id){
        EntityManager em = getEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        emf.close();
        return produto;
    }
     
     public void Remover(int id){
        EntityManager em = getEntityManager();
        Produto produto = em.find(Produto.class,id);
        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();
        em.close();
        emf.close();
     }
}