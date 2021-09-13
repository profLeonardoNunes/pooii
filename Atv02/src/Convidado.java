
import java.sql.Connection;
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
public class Convidado {

    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private String situacao;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSituacao() {
        if (this.getIdade() < 16) {
            situacao = "Entrada proibida";
        } else if (this.getIdade() >= 16 && this.getIdade() < 18) {
            situacao = "Necessita autorização dos pais";
        } else {
            situacao = "Entrada autorizada";
        }        
        return this.situacao;
       
    }

    public ArrayList<Convidado> getConvidados() {
        ArrayList<Convidado> convidados = new ArrayList<>();
        try {
            Connection conexao = new Banco().getConexao();
            Statement stmt;

            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from convidados");

            while (rs.next()) {
                Convidado c = new Convidado();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setIdade(rs.getInt("idade"));
                convidados.add(c);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return convidados;
    }

    public ArrayList<Convidado> getConvidados(String busca) {
        ArrayList<Convidado> convidados = new ArrayList<>();
        try {
            Connection conexao = new Banco().getConexao();
            Statement stmt;

            stmt = conexao.createStatement();
            String comando = "select * from convidados where nome like '%" + busca + "%'";
            ResultSet rs = stmt.executeQuery(comando);

            while (rs.next()) {
                Convidado c = new Convidado();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setIdade(rs.getInt("idade"));
                convidados.add(c);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return convidados;
    }

    public Convidado getConvidado(int id) {
        Convidado convidado = new Convidado();
        try {
            Connection conexao = new Banco().getConexao();
            Statement stmt;

            stmt = conexao.createStatement();
            String comando = "select * from convidados where id = " + id + "";
            ResultSet rs = stmt.executeQuery(comando);

            while (rs.next()) {

                convidado.setId(rs.getInt("id"));
                convidado.setNome(rs.getString("nome"));
                convidado.setCpf(rs.getString("cpf"));
                convidado.setIdade(rs.getInt("idade"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return convidado;
    }
}
