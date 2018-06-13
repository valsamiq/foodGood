/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Dish;
import entities.User;
import exceptions.Eeeeerroooorr;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author daw2
 */
@Stateless
public class FoodEJB {
    
    @PersistenceUnit EntityManagerFactory emf;
    
    public void altaUsers(User u) throws Eeeeerroooorr{
        EntityManager em = emf.createEntityManager();
        User tmp = em.find(User.class, u.getUsername());
        if(tmp != null){
            em.close();
            throw new Eeeeerroooorr("Username ya existente");
        }
        em.persist(u);
        em.close();
    }
    public void altaPlatos(Dish e) throws Eeeeerroooorr{
        EntityManager em = emf.createEntityManager();
        Dish aux = em.find(Dish.class, e.getName());
        if(aux != null){
            em.close();
            throw  new Eeeeerroooorr("Plato ya existente");
        }
        em.persist(e);
        em.close();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}