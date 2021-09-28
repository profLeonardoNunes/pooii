
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leonardo
 */
public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private Double altura;
    private Double peso;
    private Double IMC;
    private String descIMC;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getIMC() {
        this.IMC = this.peso / (this.altura * this.altura);

        return IMC;
    }

    public String getDescIMC() {
        if (this.getIMC() < 18.5) {
            this.descIMC = "Magreza";
        } else if (this.getIMC() >= 18.5 && this.IMC <= 24.9) {
            this.descIMC = "Normal";
        } else if (this.getIMC() >= 25 && this.IMC <= 29.9) {
            this.descIMC = "Normal";
        } else {
            this.descIMC = "Obesidade";
        }

        System.out.println(descIMC);
        return descIMC;
    }

    public ArrayList<Pessoa> listarPessoas(String busca) {
        ArrayList<Pessoa> pessoas = new ArrayList();
        Banco banco = new Banco();
        Connection conexao = banco.getConexao();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pessoas where nome like '%" + busca + "%'");
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setAltura(rs.getDouble("altura"));
                p.setPeso(rs.getDouble("peso"));
                pessoas.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pessoas;
    }

    public void Gravar() {
        Banco b = new Banco();
        Connection conexao = b.getConexao();

        try {
            String comando = "insert into pessoas (nome, idade, peso, altura) values (?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(comando);
            
            ps.setString(1, this.nome);
            ps.setInt(2, this.idade);
            ps.setDouble(3, this.peso);
            ps.setDouble(4, this.altura);
            
            ps.execute();
            conexao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
