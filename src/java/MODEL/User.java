/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;



/**
 *
 * @author Alex
 */

public class User {

    private String id;

    private String name;

    private String rol;

    private int yearBirth;

    public User() {
    }

    public User(String name, String rol, int yearBirth) {
     
        this.name = name;
        this.rol = rol;
        this.yearBirth = yearBirth;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", rol=" + rol + ", yearBirth=" + yearBirth + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }           
}
