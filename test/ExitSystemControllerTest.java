
import Controller.ExitSystemController;
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
public class ExitSystemControllerTest {
    
    ExitSystemController controller = new ExitSystemController();
    
    @Test
    public void testExitSystem(){
        System.out.println("TEST Exit System");
        System.out.println("Function: Admin clicks Exit System");
        String result = controller.ExitSystem();
        System.out.println("Expected Result: Sunrise Dental Clinic System Closed");
        System.out.println("Actual Result: " + result);
        assertEquals("Sunrise Dental Clinic System Closed", result);
    }
}
