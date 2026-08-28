
import Controller.LoginController;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class LoginControllerTest {
    
    LoginController controller = new LoginController();
    
    @Test 
    public void testValidateAdminLogin(){
        
        String result = controller.login("Admin", "123");
        
        System.out.println();
        System.out.println("TEST 1 Admin Login - Coorect Credentials");
        System.out.println("Username: Admin");
        System.out.println("Password: Correct");
        System.out.println("Role: Admin");
        System.out.println("Expected Result: LOGIN_SUCCESS_ADMIN");
        System.out.println("Actual Result:" + result);
        
        assertEquals("LOGIN_SUCCESS_ADMIN", result);
        
        
        System.out.println();
    }
    
    @Test 
    public void testValidateDentistLogin(){
        
        String result = controller.login("joseph", "123");
        
        System.out.println();
        System.out.println("TEST 2 Dentist Login - Coorect Credentials");
        System.out.println("Username: joseph");
        System.out.println("Password: Correct");
        System.out.println("Role: Dentist");
        System.out.println("Expected Result: LOGIN_SUCCESS_Dentist");
        System.out.println("Actual Result:" + result);
        
        assertEquals("LOGIN_SUCCESS_DENTIST", result);
        
       
        System.out.println();
    }
    
    @Test 
    public void testValidateStaffLogin(){
        
        String result = controller.login("bruce", "123");
        
        System.out.println();
        System.out.println("TEST 3 Staff Login - Coorect Credentials");
        System.out.println("Username: bruce");
        System.out.println("Password: Correct");
        System.out.println("Role: Staff");
        System.out.println("Expected Result: LOGIN_SUCCESS_Staff");
        System.out.println("Actual Result:" + result);
        
        assertEquals("LOGIN_SUCCESS_STAFF", result);
        
       
        System.out.println();
    }
    
    @Test 
    public void testInvalidPassword(){
        
        String result = controller.login("joseph", "321");
        
        System.out.println();
        System.out.println("TEST 4 Admin Login - Wrong Password");
        System.out.println("Username: Admin");
        System.out.println("Password: Incorrect");
        System.out.println("Role: Staff");
        System.out.println("Expected Result: INVALID_CREDENTIALS");
        System.out.println("Actual Result:" + result);
        
        assertEquals("INVALID_CREDENTIALS", result);
        
      
        System.out.println();
    }
    
    @Test 
    public void testEmptyUsername(){
        
        String result = controller.login("", "123");
        System.out.println("TEST 5 User Login - Empty Username");
        System.out.println("Username: Empty");
        System.out.println("Password: 123");
        System.out.println("Expected Result: Username is required");
        System.out.println("Actual Result:" + result);
        assertEquals("Username is required", result);
    }
    
    @Test 
    public void testEmptyPassword(){
        
        String result = controller.login("joseph", "");
        System.out.println("TEST 6 User Login - Empty Password");
        System.out.println("Username: user");
        System.out.println("Password: Empty");
        System.out.println("Expected Result: Password is required");
        System.out.println("Actual Result:" + result);
        assertEquals("Password is required", result);
         System.out.println();
    }
    
    
     @Test 
    public void testNonExistingUser(){
        
        String result = controller.login("unknown", "123");
         System.out.println("TEST 7 Non-user login");
        System.out.println("Username: unknown");
        System.out.println("Password: 123");
        System.out.println("Expected Result: INVALID_CREDENTIALS");
        System.out.println("Actual Result:" + result);
        assertEquals("INVALID_CREDENTIALS", result);
    }
    
   
}
