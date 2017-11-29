/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabiblioteca;

import DAO.LivroDAO;
import DAO.UsuarioDAO;
import Model.Usuario;
import Model.Livro;
import View.Login;

/**
 *
 * @author internet
 */
public class SistemaBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        UsuarioDAO alDAO = new UsuarioDAO();
        Usuario al = new Usuario();
        al.setNomeCompleto("Rafael Pinheiro Rocha");
        al.setRA(2216);
        al.setSenha("123456");
        alDAO.gravaUsuario(al);
        Usuario al2;
        //al2 = alDAO.buscaUsuario(1);
       // System.out.println("Saida");
       // System.out.println(al2.getNomeCompleto());
        

        
        /*
        LivroDAO alDAO = new LivroDAO();
        Livro al = new Livro();
        al.setAutor("Rafael");
        alDAO.gravaLivro(al);

*/
        
        Login log = new Login();
        log.setVisible(true);
    }
    
}
