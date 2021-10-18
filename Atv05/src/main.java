/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario u = new Usuario();
//        u.setId(1);
//        u.setNome("Vinicius");
//        u.setLogin("vinicius.marques");
//        u.setSenha("123321");
//        u.setEmail("vinicius@marques.com.br");
//        u.AtualizarUsuario();

        
        if (!u.VerificaMaster()) {
            u.CriarMaster();
        }
              
        frmLogin frm = new frmLogin();
        frm.setVisible(true);        

    }
}
