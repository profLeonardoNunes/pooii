
import Helpers.Crud;
import controllers.CategoriaController;
import controllers.ProdutoController;
import forms.frmProduto;
import jdk.nashorn.internal.objects.NativeArray;
import model.Categoria;

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
        //new frmProduto().setVisible(true) ;       
        Crud crud = new Crud();
       
        Categoria c = new Categoria();
        CategoriaController cc = new CategoriaController();        
        c.setNome("Terceira categoria");        
        //cc.Cadastrar(c);   
        crud.Cadastrar(cc);
        
//
//        Produto p = new Produto();
//        ProdutoController pc = new ProdutoController();
//        
//        p.setNome("Produto 4");
//        p.setQuantidade(0.0);
//        CategoriaController cc = new CategoriaController(); 
//      
//        p.setCategoria(cc.Consultar(1));
//        
//        pc.Cadastrar(p);

//        CategoriaController cc = new CategoriaController(); 
//        for(Produto produto: cc.Consultar(1).getProdutos())
//        {
//            System.out.println(produto.getNome());
//        }
//        
//        ProdutoController pc = new ProdutoController();
//        
//        System.out.println(pc.Consultar(2).getCategoria().getNome());;
        
        

    }
}
