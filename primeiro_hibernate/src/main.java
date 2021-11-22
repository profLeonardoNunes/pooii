
import controllers.ProdutoController;
import jdk.nashorn.internal.objects.NativeArray;
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
        
        //Cadastra um novo Produto
//        Produto p = new Produto();
//        p.setNome("Gabinete Redragon Modelo ABCD");
//        p.setQuantidade(15.0);        
//        
//        pc.CadastrarProduto(p);

        //Lista os produtos cadastrados
//        for(Produto p: pc.Listar()){
//            System.out.println(p.getNome() + " - " + p.getQuantidade());
//        }
        
        //Consulta um produto com base em uma chave
        //System.out.println(pc.Consultar(3).getNome());
        
        //Deleta um produto com base em uma chave
        //pc.Remover(4);
        
    }
}