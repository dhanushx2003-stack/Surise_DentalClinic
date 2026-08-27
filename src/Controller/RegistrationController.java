/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Staff;
import dao.StaffDAO;

/**
 *
 * @author DELL
 */
public class RegistrationController {
    
    private StaffDAO staffDAO;
    
    public RegistrationController(){
        staffDAO = new StaffDAO();
    }
    
    public String validateInput(String Name, String Username, String Password, String ConfirmPassword){
        
        if (Name == null || Name.trim().isEmpty()){
            return "Enter Name";
        }
        
        if (Username == null || Username.trim().isEmpty()){
            return "Enter Username";
        }
        
         if (Password == null || Password.trim().isEmpty()){
            return "Enter Password";
        }
         
         if (ConfirmPassword == null || ConfirmPassword.trim().isEmpty()){
            return "Enter Confirm Password";
        }
         
        if (!Password.equals(ConfirmPassword)){
            return "Passwords do not match";
        }
        
        return "Valid";
    }
    
    public String Register(String Name, String Username, String Password, String ConfirmPassword){
        
        String validationResult = validateInput(Name, Username, Password, ConfirmPassword);
        
        if (!validationResult.equals("Valid")){
            return validationResult;
        }
        
        Staff staff = new Staff();
        
        staff.setName(Name);
        staff.setUsername(Username);
        staff.setPassword(Password);
        
        staff.setRole("Staff");
        
        boolean registered = staffDAO.register(staff);
        
        if(registered){
            return "Registration Successful";
        }
        
        return "Registration Failed";
    }
}
