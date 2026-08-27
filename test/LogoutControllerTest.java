
import Controller.LogoutController;
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
public class LogoutControllerTest {
    
    LogoutController controller = new LogoutController();
    
    @Test
    public void testStaffLogout(){
        
        String result = controller.Logout();
        System.out.println("TEST 1 Staff Logout");
        System.out.println("Function: Staff clicks Logout");
        System.out.println("Expected Result: Logout Successful");
        System.out.println("Actual Result: " + result);
        assertEquals("Logout Successful", result);
        System.out.println();
    }
    
    @Test
    public void testDentistLogout(){
        
        String result = controller.Logout();
        System.out.println("TEST 1 Dentist Logout");
        System.out.println("Function: Dentist clicks Logout");
        System.out.println("Expected Result: Logout Successful");
        System.out.println("Actual Result: " + result);
        assertEquals("Logout Successful", result);
        System.out.println();
    }
    
     @Test
    public void testAdminLogout(){
        
        String result = controller.Logout();
        System.out.println("TEST 1 Admin Logout");
        System.out.println("Function: Admin clicks Logout");
        System.out.println("Expected Result: Logout Successful");
        System.out.println("Actual Result: " + result);
        assertEquals("Logout Successful", result);
        System.out.println();
    }
}
