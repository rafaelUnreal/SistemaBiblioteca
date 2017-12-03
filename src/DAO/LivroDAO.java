/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Livro;
import Model.Usuario;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author internet
 */
public class LivroDAO {
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    public LivroDAO(String persist){
        factory = Persistence.createEntityManagerFactory(persist);
        manager = factory.createEntityManager();

    }
    public void gravaLivro(Livro al){
        manager.getTransaction().begin();
        manager.persist(al);
        manager.getTransaction().commit();
        //PARA DEBUG
        System.out.println("Inserção realizada com sucesso!");
        
    }
    
    public Livro buscaLivro(int RA){
    
        Livro al = new Livro();
        al = manager.find(Livro.class,RA);
       
        return al; 
    }
     public List<Livro> listaLivros(){
        
List<Livro> livroList = manager.createQuery("SELECT t FROM Livro AS t",Livro.class).getResultList();


    return livroList;
}
    public void removeLivro(int id){
        Livro al = new Livro();
        
        al = manager.find(Livro.class,id);
        
        manager.getTransaction().begin();
        manager.remove(al);
        manager.getTransaction().commit();
        
    }
    
    public void atualizaLivro(Livro al){
            
        manager.getTransaction().begin();
        manager.merge(al);
        manager.getTransaction().commit();
        
    }
    
}
