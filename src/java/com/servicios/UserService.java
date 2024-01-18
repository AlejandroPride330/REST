/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import DAO.UserDaoImplements;
import DAO.UsersDAO;
import MODEL.User;
import UTILS.FicherosXML;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 *
 * @author Alex
 */
@Path("/users")
public class UserService implements UsersDAO {
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> getUsers() {
        try {
            List<User> users = UserDaoImplements.getUsers();
//            users.add(new User("Enrique Nogal", "Profesor", 1976));
//            users.add(new User("Elia Nogal", "Alumno", 2005));
//            return UserDaoImplements.getUsers();
            return users;
        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
            return null;
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public User getUserByID(@PathParam("id") int id) {
        try {
            User user = UserDaoImplements.getUserByID(id);
            return user;
        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
            return null;
        }
    }
    
    @GET
    @Path("/all/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsersXML() {
        List<User> l = new ArrayList<>();
        l.add(new User("Alex", "Eljefe", 1993));
        l.add(new User("Enrique", "profesor", 1976));
        return l;
    }

    @GET
    @Path("/all/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersJSON() {
         List<User> l = new ArrayList<>();
        l.add(new User("Alex", "Eljefe", 1993));
        l.add(new User("Enrique", "profesor", 1976));
        return l;
//        List<User> l = new ArrayList<>();  he metido aquí datos para probar
//        l = insertUser();
//        return l;
    }

    @POST
    public List<User> insertUser() {
        Transaction tx = null;
        List<User> l = new ArrayList<>();
        //try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try{
            FicherosXML fxml = new FicherosXML();
            HashMap<String, String> mapa = new HashMap<String, String>();
            mapa = fxml.leerXML();

            User u = new User( mapa.get("name"),  mapa.get("rol"), Integer.parseInt(mapa.get("yearBirth")));
            l.add(u);
            System.out.println(l);
        } catch (HibernateException e) {
            System.out.println(e);

        }
        return l;
    }
//   
//   @GET
//   @Path("/all/XML")
//    public List<User> getAllProductXML() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Query<User> query = session.createQuery("FROM User", User.class);
//            return query.getResultList();
//
//        } catch (HibernateException e) {
//            System.out.println(e);
//            return null;
//        }
//    }    

//    @GET
//   @Path("/all/JSON")
//    public List<User> getAllProductJSON() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Query<User> query = session.createQuery("FROM User", User.class);
//            return query.getResultList();
//
//        } catch (HibernateException e) {
//            System.out.println(e);
//            return null;
//        }
//    }    
}
