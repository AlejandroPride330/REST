/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import MODEL.User;
import UTILS.HibernateUtil;

/**
 *
 * @author paul
 */
public class UserDaoImplements {
    
    public static List<User> getUsers() throws Exception{
        try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {

            Query<User> query = session.createQuery("FROM User ", User.class); //  todo:prueba con TypedQuery
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error al obtener la lista de usuarios");
        }
    }
    
    public static User getUserByID(int id) throws Exception{
        try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE id = :value", User.class);
            query.setParameter("value", id);
            return query.uniqueResult();
        } catch (Exception e) {
            throw new Exception("Error al obtener la lista de usuarios");
        }
    }
}
