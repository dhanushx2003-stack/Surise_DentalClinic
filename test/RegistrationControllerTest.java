
import Controller.RegistrationController;
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
public class RegistrationControllerTest {

    RegistrationController controller = new RegistrationController();

    @Test
    public void testValidRegistration() {
        String Username = "Test User" + System.currentTimeMillis();
        String result = controller.Register("Andrew Dhanush", Username, "123", "123");
        System.out.println("");
        System.out.println("TEST 1 Staff Registration");
        System.out.println("Name: Andrew Dhanush");
        System.out.println("Username: " + Username);
        System.out.println("Password: 123");
        System.out.println("Confirm Password: 123");
        System.out.println("Role: Staff");
        System.out.println("Expected Result: Registration Successful");
        System.out.println("Actual Result: " + result);
        assertEquals("Registration Successful", result);
        
         System.out.println("");
    }

    @Test
    public void testEmptyName() {
        String result = controller.Register("", "dhanush", "123", "123");
        System.out.println("");
        System.out.println("TEST 2 Empty Name");
        System.out.println("Name: ");
        System.out.println("Username: dhanush");
        System.out.println("Password: 123");
        System.out.println("Confirm Password: 123");
        
        System.out.println("Expected Result: Enter Name");
        System.out.println("Actual Result: " + result);
        assertEquals("Enter Name", result);
        
        System.out.println("");
    }

    @Test
    public void testEmptyUsername() {
        String result = controller.Register("Andrew Dhanush", "", "123", "123");
        System.out.println("");
        System.out.println("TEST 3 Empty Username");
        System.out.println("Name: Andrew Dhanush");
        System.out.println("Username: Empty");
        System.out.println("Password: 123");
        System.out.println("Confirm Password: 123");
        
        System.out.println("Expected Result: Enter Username");
        System.out.println("Actual Result: " + result);
        assertEquals("Enter Username", result);
        
        System.out.println("");
    }

    @Test
    public void testEmptyPassword() {
        String result = controller.Register("Andrew Dhanush", "dhanush", "", "123");
        System.out.println("");
        System.out.println("TEST 4 Empty Password");
        System.out.println("Name: Andrew Dhanush");
        System.out.println("Username: dhanush");
        System.out.println("Password: Empty");
        System.out.println("Confirm Password: 123");
       
        System.out.println("Expected Result: Enter Password");
        System.out.println("Actual Result: " + result);
        assertEquals("Enter Password", result);
        
        System.out.println("");
    }

    @Test
    public void testEmptyConfirmPassword() {
        String result = controller.Register("Andrew Dhanush", "dhanush", "123", "");
        System.out.println("");
        System.out.println("TEST 5 Empty Confirm Password");
        System.out.println("Name: Andrew Dhanush");
        System.out.println("Username: dhanush");
        System.out.println("Password: 123");
        System.out.println("Confirm Password: Empty");
        
        System.out.println("Expected Result: Enter Confirm Password");
        System.out.println("Actual Result: " + result);
        assertEquals("Enter Confirm Password", result);
        
        System.out.println("");
    }

    @Test
    public void testPasswordMatch() {
        String result = controller.Register("Andrew Dhanush", "dhanush", "123", "111");
        System.out.println("");
         System.out.println("TEST 6 Password Match");
        System.out.println("Name: Andrew Dhanush");
        System.out.println("Username: dhanush");
        System.out.println("Password: 123");
        System.out.println("Confirm Password: 111");
       
        System.out.println("Expected Result: Passwords do not match");
        System.out.println("Actual Result: " + result);
        assertEquals("Passwords do not match", result);
        
        System.out.println("");
    }

}
