/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Staff {
    
    private String Name;
    private String Username;
    private String Password;
    private String Role;
    
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getUsername(){
       return Username; 
    }
    public void setUsername(String Username){
        this.Username = Username;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password = Password;
    }
    public String getRole(){
        return Role;
    }
    public void setRole(String Role){
        this.Role = Role;
    }
}
