/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodMood.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author cmgoe
 */
public class UserList {

    private ArrayList<User> theUsers;

    public UserList() {
        if (theUsers == null) {
            theUsers = new ArrayList<User>();
        }
    }

    public boolean authenticate(String username, char[] password) {
        boolean authenticated = false;
        boolean nameMatch = false;
        boolean passwordMatch = false;
        for (int i = 0; i < theUsers.size(); i++) {
            nameMatch = username.equals(theUsers.get(i).getUsername());
            passwordMatch = String.valueOf(password).equals(String.valueOf(theUsers.get(i).getPassword()));
            if (nameMatch && passwordMatch) {
                authenticated = true;
                break;
            }
        }

        return authenticated;
    }

    public void addUser(User userToAdd) {
        theUsers.add(userToAdd);
    }

    public void buildTestUserList() {
        theUsers = new ArrayList();
        for (int i = 0; i < 100; i++) {
            String username = ("TestUser" + i);
            char[] password = {'t', 'e', 's', 't'};
            User newUser = new User(username, password, "Tester");
            theUsers.add(newUser);
        }
        System.out.println("made new users");
    }

    public User getCurrUser(String username) {
        User tempUser = null;
        for (int i = 0; i < theUsers.size(); i++) {
            if (theUsers.get(i).getUsername().equals(username)) {
                tempUser = theUsers.get(i);
            }
        }
        return tempUser;
    }

    public ArrayList<User> getUserList() {
        return this.theUsers;
    }
}
