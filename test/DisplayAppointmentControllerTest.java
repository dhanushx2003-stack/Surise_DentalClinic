
import Controller.AppointmentController;
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
public class DisplayAppointmentControllerTest {
    
    AppointmentController controller = new AppointmentController();
    
    @Test
    public void testSearchAppointment(){
        String AppointmentNo = "111";
        String expected = "Patient Found";
        String actual = controller.SearchAppointment(AppointmentNo);
        System.out.println();
        System.out.println("TEST 1 Search Valid Appointment");
        System.out.println("Appointment Number: " + AppointmentNo);
        System.out.println("Expected Result: " + expected);
        System.out.println("Actual Result: " + actual);
        assertEquals(expected, actual);
        
        System.out.println();
    }
    
    @Test
    public void testSearchInvalidAppointment(){
        String AppointmentNo = "1111";
        String expected = "Patient Not Registered";
        String actual = controller.SearchAppointment(AppointmentNo);
        System.out.println();
        System.out.println("TEST 2 Search Invalid Appointment");
        System.out.println("Appointment Number: " + AppointmentNo);
        System.out.println("Expected Result: " + expected);
        System.out.println("Actual Result: " + actual);
        assertEquals(expected, actual);
      
        System.out.println(); 
    }
    
    @Test
    public void testNonExistingAppointment(){
        String AppointmentNo = "";
        String expected = "Enter Appointment Number";
        String actual = controller.SearchAppointment(AppointmentNo);
        System.out.println();
        System.out.println("TEST 3 Search Non Existing Appointment");
        System.out.println("Appointment Number: " + AppointmentNo);
        System.out.println("Expected Result: " + expected);
        System.out.println("Actual Result: " + actual);
        assertEquals(expected, actual);
      
        System.out.println(); 
    }
    
    @Test
    public void testDeleteAppointment(){
        String AppointmentNo = "124";
        String expected = "Patient Appointment Deleted";
        String actual = controller.DeleteAppointment(AppointmentNo);
        System.out.println();
        System.out.println("TEST 4 Delete Appointment");
        System.out.println("Appointment Number: " + AppointmentNo);
        System.out.println("Expected Result: " + expected);
        System.out.println("Actual Result: " + actual);
        assertEquals(expected, actual);
        
        System.out.println(); 
    }
    
    @Test
    public void testDeletNonExistingAppointment(){
        String AppointmentNo = "122";
        String expected = "Select an Appointment";
        String actual = controller.DeleteAppointment(AppointmentNo);
        System.out.println();
        System.out.println("TEST 5 Delete Non Existing Appointment");
        System.out.println("Appointment Number: " + AppointmentNo);
        System.out.println("Expected Result: " + expected);
        System.out.println("Actual Result: " + actual);
        assertEquals(expected, actual);
       
        System.out.println(); 
    }
}
