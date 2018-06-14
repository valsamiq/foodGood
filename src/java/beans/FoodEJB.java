/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Dish;
import entities.Rate;
import entities.Restaurant;
import entities.User;
import exceptions.Eeeeerroooorr;
import java.util.ArrayList;
import java.util.List;
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
    public void altaValoras(Rate r) throws Eeeeerroooorr{
        EntityManager em = emf.createEntityManager();
        //Rate tmp = em.find(Rate.class, r.getName());
        //if(tmp != null){
        //    em.close();
        //    throw new Eeeeerroooorr("Plato/Usu ya valorado");
        //}
        em.persist(r);
        em.close();
    }
    public List<Dish> getAllDish(){
        return emf.createEntityManager().createNamedQuery("Dish.findAll").getResultList();
    }
    public List<Dish> filterAllDish(String type){
        List<Dish> allDish = getAllDish();
        List<Dish> tmp = new ArrayList<>();
        if(type.equalsIgnoreCase("all")){
            return allDish;
        } else{
            for(Dish d : allDish){
                if(d.getType().equalsIgnoreCase(type)){
                    tmp.add(d);
                }
            }
            return tmp;
        }
    }
    public User getUserByName(String name){
        EntityManager em = emf.createEntityManager();
        User tmp = em.find(User.class, name);
        return tmp;
    }
    public Dish getDishByName(String name){
        EntityManager em = emf.createEntityManager();
        Dish tmp = em.find(Dish.class, name);
        return tmp;
    }
    public Restaurant getRestByName(String name){
        EntityManager em = emf.createEntityManager();
        Restaurant tmp = em.find(Restaurant.class, name);
        return tmp;
    }
    public void delDishByName(String dish){
        EntityManager em = emf.createEntityManager();
        Dish tmp = em.find(Dish.class, dish);
        em.remove(tmp);
        em.close();
    }
    public void modDish(Dish d){
        EntityManager em = emf.createEntityManager();
        Dish tmp = em.find(Dish.class, d.getName());
        tmp.setPrice(d.getPrice());
        em.persist(tmp);
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