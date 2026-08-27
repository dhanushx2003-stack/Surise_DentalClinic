
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
        
        assertEquals("Admin Login Success", result);
        
        System.out.println("Result: Pass");
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
        
        assertEquals("Dentist Login Success", result);
        
        System.out.println("Result: Pass");
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
        
        assertEquals("Staff Login Success", result);
        
        System.out.println("Result: Pass");
        System.out.println();
    }
    
    @Test 
    public void testInvalidPassword(){
        
        String result = controller.login("joseph", "321");
        
        System.out.println();
        System.out.println("TESt Admin Login - Wrong Password");
        System.out.println("Username: Admin");
        System.out.println("Password: Incorrect");
        System.out.println("Role: Staff");
        System.out.println("Expected Result: INVALID_CREDENTIALS");
        System.out.println("Actual Result:" + result);
        
        assertEquals("Invalid Credentials", result);
        
        System.out.println("Result: Pass");
        System.out.println();
    }
    
    @Test 
    public void testEmptyUsername(){
        
        String result = controller.login("", "123");
        
        assertEquals("Username is required", result);
    }
    
    @Test 
    public void testEmptyPassword(){
        
        String result = controller.login("joseph", "");
        
        assertEquals("Password is required", result);
    }
    
    @Test 
    public void testShortUsername(){
        
        String result = controller.login("jo", "123");
        
        assertEquals("Username must contain at least 3 characters", result);
    }
    
     @Test 
    public void testShortPassword(){
        
        String result = controller.login("joesph", "12");
        
        assertEquals("Password must contain at least 3 characters", result);
    }
    
     @Test 
    public void testNonExistingUser(){
        
        String result = controller.login("unknown", "123");
        
        assertEquals("Invalid Credentials", result);
    }
    
     @Test 
    public void testInvalidStaffPassword(){
        
        String result = controller.login("bruce", "wrong");
        
        assertEquals("Invalid Credentials", result);
    }
}
