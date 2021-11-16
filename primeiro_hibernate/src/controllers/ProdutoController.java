/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.persistence.*;
import model.Produto;

/**
 *
 * @author Leonardo
 */
public class ProdutoController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("Produtos");
        }
        return emf.createEntityManager();
    }
    
    public void CadastrarProduto(Produto prod){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
