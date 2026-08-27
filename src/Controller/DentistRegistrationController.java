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
public class DentistRegistrationController {
    
    private StaffDAO staffdao;
    
    public DentistRegistrationController(){
        staffdao = new StaffDAO();
    }
    
    public String RegisterDentist(String Name, String Username, String Password, String ConfirmPassword){
        
        if(Name == null || Name.trim().isEmpty()){
            return "Enter Name";
        }
        
        if(Username == null || Username.trim().isEmpty()){
            return "Enter Username";
        }
        
        if(Password == null || Password.trim().isEmpty()){
            return "Enter Password";
        }
        
        if(ConfirmPassword == null || ConfirmPassword.trim().isEmpty()){
            return "Enter Confirm Password";
        }
        
         if(!Password.equals(ConfirmPassword)){
             return "Passwords do not match";
        }
         
         Staff s = new Staff();
         
         s.setName(Name);
         s.setUsername(Username);
         s.setPassword(Password);
         s.setRole("Dentist");
         
         try{
             boolean result = staffdao.register(s);
             
             if(result){
                 return "Registration Successful";
             }else {
                 return "Registration Failed";
             }
         } catch (Exception e){
             if (e.getMessage() != null && e.getMessage().contains("Duplicate")){
                 return "Account already exists";
             }
             return "Registration Failed";
         }
    }
}
