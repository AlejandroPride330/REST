/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import POJO.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Alex
 */
@Path("/users")
public class UserService {
 
    @GET
    @Path("/all/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsersXML(){
         List<User> l = new ArrayList<>();
         l.add(new User("1", "Alex", "Eljefe", 1993));
         l.add(new User("2", "Enrique", "profesor", 1976));
         return l;
    }
    
    @GET
    @Path("/all/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersJSON(){
         List<User> l = new ArrayList<>();
         l.add(new User("1", "Alex", "Eljefe", 1993));
         l.add(new User("2", "Enrique", "profesor", 1976));
         return l;
    }
    
   // @POST
    
}
