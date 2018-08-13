/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author kenda
 */
public class Users {
    private String User;
    private String Password;

    public Users(String User, String Password) {
        this.User = User;
        this.Password = Password;
    }

    public Users() {
    }

    public String getUser() {
        return User;
    }

    public String getPassword() {
        return Password;
    } 

    public void setUser(String User) {
        this.User = User;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
