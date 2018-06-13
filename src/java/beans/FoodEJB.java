/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Dish;
import entities.Restaurant;
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

    @PersistenceUnit
    EntityManagerFactory emf;

    public void altaUsers(User u) throws Eeeeerroooorr {
        EntityManager em = emf.createEntityManager();
        User tmp = em.find(User.class, u.getUsername());
        if (tmp != null) {
            em.close();
            throw new Eeeeerroooorr("Username ya existente");
        }
        em.persist(u);
        em.close();
    }

    public void altaPlatos(Dish e) throws Eeeeerroooorr {
        EntityManager em = emf.createEntityManager();
        Dish aux = em.find(Dish.class, e.getName());
        if (aux != null) {
            em.close();
            throw new Eeeeerroooorr("Plato ya existente");
        }
        em.persist(e);
        em.close();
    }
    
    public void altaRestaurantes(Restaurant r) throws Eeeeerroooorr{
        EntityManager em = emf.createEntityManager();
        Restaurant tmp = em.find(Restaurant.class, r.getName());
        if(tmp != null){
            em.close();
            throw new Eeeeerroooorr("Restaurante ya existente");
        }
        em.persist(r);
        em.close();
    }
    
    public User checkUser(String usu, String pass) throws Eeeeerroooorr {
        EntityManager em = emf.createEntityManager();
        User tmp = em.find(User.class, usu);
        if (tmp != null) {
            if (tmp.getPassword().equals(pass)) {
            } else {
                tmp = null;
                throw new Eeeeerroooorr("Usuario/Contraseña Incorrecto");
            }
        } else {
            throw new Eeeeerroooorr("Usuario/Contraseña Incorrecto");
        }
        em.close();
        return tmp;
    }
}
