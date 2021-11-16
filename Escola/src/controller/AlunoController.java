/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Aluno;

/**
 *
 * @author Leonardo
 */
public class AlunoController {
    private static EntityManagerFactory emf;
    
    private static EntityManager getEntityManager(){
        if(emf==null)
        {
            emf = Persistence.createEntityManagerFactory("Alunos");
        }
        return emf.createEntityManager();        
    }
    
    public void CadastrarAluno(Aluno aluno){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }    
}