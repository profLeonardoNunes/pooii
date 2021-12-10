/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Leonardo
 */
@Entity
public class Treino {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany(fetch=FetchType.EAGER, mappedBy="treino")
    private List<AtividadeFisica> atividadesFisicas;
    @ManyToOne
    private Aluno aluno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AtividadeFisica> getAtividadesFisicas() {
        return atividadesFisicas;
    }

    public void setAtividadesFisicas(List<AtividadeFisica> atividadesFisicas) {
        this.atividadesFisicas = atividadesFisicas;
    }
    
    
}
