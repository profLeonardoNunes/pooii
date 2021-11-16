
import controllers.ProdutoController;
import model.Produto;

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
        ProdutoController pc = new ProdutoController();
        Produto prod = new Produto();
        prod.setNome("Mouse Logitech c9393");
        prod.setQuantidade(50.0);
        pc.CadastrarProduto(prod);
    }    
}
