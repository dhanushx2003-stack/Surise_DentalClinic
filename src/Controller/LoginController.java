/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dao.StaffDAO;

/**
 *
 * @author DELL
 */
public class LoginController {
    
    private StaffDAO staffDAO;
    
    public LoginController(){
        staffDAO = new StaffDAO();
    }
    
    public String validateInput(String username, String password){
        
        if (username == null || username.trim().isEmpty()){
            return "Username is required";
        }
        
        if (password == null || password.trim().isEmpty()){
            return "Password is required";
        }
        
        if (username.length() < 3){
            return "Username must contain at least 3 characters";
        }
        
        if (password.length() < 3){
            return "Password must contain at least 3 characters";
        }
        
        return "VALID";
    }
    
    public String login(String username, String password){
        
        String validateResult = validateInput(username, password);
        
        if (!validateResult.equals("VALID")){
            return validateResult;
        }
        
        String role = staffDAO.login(username, password);
        
        if (role == null){
            return "Invalid Credentials";
        }
        
        role = role.trim();
        
        if (role.equalsIgnoreCase("ADMIN")){
            return "Admin Login Success";
        }
        
         if (role.equalsIgnoreCase("Dentist")){
            return "Dentist Login Success";
        }
         
          if (role.equalsIgnoreCase("Staff")){
            return "Staff Login Success";
        }
          
          return "LOGIN_SUCCESS";
    }
}
