/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.EmprestimoModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno Pinheiro Rocha
 */
public class EmprestimoDAO {
    
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    public EmprestimoDAO(String persist){
        factory = Persistence.createEntityManagerFactory(persist);
        manager = factory.createEntityManager();

    }
    public void gravaEmprestimo(EmprestimoModel al){
        manager.getTransaction().begin();
        manager.persist(al);
        manager.getTransaction().commit();
        //PARA DEBUG
        System.out.println("Inserção realizada com sucesso!");
        
    }
    
    public EmprestimoModel buscaEmprestimo(int ID){
    
        EmprestimoModel al = new EmprestimoModel();
        al = manager.find(EmprestimoModel.class,ID);
       
        return al; 
    }
     public List<EmprestimoModel> listaEmprestimos(){
        
List<EmprestimoModel> empList = manager.createQuery("SELECT t FROM Emprestimo AS t",EmprestimoModel.class).getResultList();


    return empList;
}
    public void removeEmprestimo(int id){
        EmprestimoModel al = new EmprestimoModel();
        
        al = manager.find(EmprestimoModel.class,id);
        
        manager.getTransaction().begin();
        manager.remove(al);
        manager.getTransaction().commit();
        
    }
    
    public void atualizaEmprestimo(EmprestimoModel al){
            
        manager.getTransaction().begin();
        manager.merge(al);
        manager.getTransaction().commit();
        
    }
    
}
