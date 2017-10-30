/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.model;

/**
 *
 * @author cmgoe
 */
public class User {
    private String username;
    private char[] password;
    private String name;
    
    public User (String username, char[] password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
}
