/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Usuario;
import java.util.List;
import javax.persistence.*;
import org.hibernate.*;
/**
 *
 * @author internet
 */
public class UsuarioDAO {
    
    private EntityManagerFactory factory;
    private EntityManager manager;
    private Session session;
    
    public UsuarioDAO(String persist){
        factory = Persistence.createEntityManagerFactory(persist);
        manager = factory.createEntityManager();
       
        

    }
    public void gravaUsuario(Usuario al){
        manager.getTransaction().begin();
        manager.persist(al);
        manager.getTransaction().commit();
        //PARA DEBUG
        System.out.println("Inserção realizada com sucesso!");
     
        
    }
    public Usuario buscaUsuario(int RA){
    
    
        return manager.find(Usuario.class,RA);
   
     
    }
    public List<Usuario> listaUsuarios(){
        
List<Usuario> userList = manager.createQuery("SELECT t FROM Usuario AS t",Usuario.class).getResultList();


    return userList;
}
    
    public void removeUsuario(int RA){
        Usuario al = new Usuario();
        
        al = manager.find(Usuario.class,RA);
        
        manager.getTransaction().begin();
        manager.remove(al);
        manager.getTransaction().commit();
 
        
    }
    
    public void atualizaAluno(Usuario al){
            
        manager.getTransaction().begin();
        manager.merge(al);
        manager.getTransaction().commit();

        
    }
    
}
