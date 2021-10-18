
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
public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String login;
    private String senha;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean VerificaMaster() {
        Connection conexao = new Banco().getConexao();
        String comando = "SELECT * FROM usuarios WHERE login = 'master' and senha = 'master'";
        Statement stmt;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);

            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public void CriarMaster() {
        try {
            Connection conexao = new Banco().getConexao();
            String comando = "insert into usuarios (nome,email,login,senha) values(?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setString(1, "master");
            ps.setString(2, "master@master.com");
            ps.setString(3, "master");
            ps.setString(4, "master");

            ps.execute();
            System.out.println("Dados armazenados com sucesso!");
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario Logar(String login, String senha) {
        Connection conexao = new Banco().getConexao();
        String comando = "SELECT * FROM usuarios WHERE login = '" + login + "' "
                + "and senha = '" + senha + "'";
        Statement stmt;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                return u;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void CriarUsuario() {
        try {
            Connection conexao = new Banco().getConexao();
            String comando = "insert into usuarios (nome,email,login,senha) values(?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setString(1, this.nome);
            ps.setString(2, this.email);
            ps.setString(3, this.login);
            ps.setString(4, this.senha);

            ps.execute();
            System.out.println("Novo usuario criado com sucesso!");
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AtualizarUsuario() {
        try {
            Connection conexao = new Banco().getConexao();
            String comando = "update usuarios set nome = ?, email = ?, login = ?, senha = ? where id = ?";
            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setString(1, this.nome);
            ps.setString(2, this.email);
            ps.setString(3, this.login);
            ps.setString(4, this.senha);
            ps.setInt(5, this.id);

            ps.execute();
            System.out.println("Usuario atualizado com sucesso!");
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeletarUsuario() {
        try {
            Connection conexao = new Banco().getConexao();
            String comando = "delete from usuarios where id = ?";
            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setInt(1, this.id);

            ps.execute();
            System.out.println("Usuario deletado com sucesso!");
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Usuario> Consultar(String busca) {
        Connection conexao = new Banco().getConexao();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String comando = "SELECT * FROM usuarios where nome like '%" + busca + "%' or "
                + "email like '%" + busca + "%' or "
                + "login like '%" + busca + "%'";
        Statement stmt;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return usuarios;
    }

    public Usuario Consultar() {
        Connection conexao = new Banco().getConexao();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String comando = "SELECT * FROM usuarios where id = " + this.id;
        Statement stmt;
        Usuario u = new Usuario();
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);

            while (rs.next()) {

                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return u;
    }

}
