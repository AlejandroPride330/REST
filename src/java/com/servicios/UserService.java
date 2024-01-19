/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import DAO.UserDaoImplements;
import DAO.UsersDAO;
import MODEL.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

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
        List<User> users = new ArrayList<User>();
        try {
            users = UserDaoImplements.getUsers();
        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
            return null;
        }
        return users;
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public User getUserByID(@PathParam("id") int id) {
        User user;
        try {
            user = UserDaoImplements.getUserByID(id);

        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
            return null;
        }
        return user;
    }

    @GET
    @Path("/yearBirth/{yearBirth}")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> getUserByYearBirth(@PathParam("yearBirth") int yearBirth) {
        List<User> l = null;
        try {
            l = UserDaoImplements.getUserByYearBirth(yearBirth);

        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
        }
        return l;
    }

    @GET
    @Path("/all/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersJSON() {
        try {
            return UserDaoImplements.getUsers();

        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
            return null;
        }
    }

    @POST
    @Path("/insert/xml")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public User insertUserXML(User u) {
        System.out.println("datos recibidos: " + u.toString());
        try (UserDaoImplements us = new UserDaoImplements()) {

            us.insertUser(u);
            return u;

        } catch (Exception e) {
            e.printStackTrace();
            return u;
        }
        
    }
    @POST
    @Path("/insert/xml1")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public User insertUserXML1(User u) {
        System.out.println("datos recibidos: " + u.toString());
        return u;
    }

    @POST
    @Path("/create/xml")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public List<User> createUser(List<User> lu) {
        List<User> r = new ArrayList<User>();
        try (UserDaoImplements us = new UserDaoImplements()) {
            for (User u : lu) {
                if (us.insertUser(u)) {
                    r.add(u);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

}
