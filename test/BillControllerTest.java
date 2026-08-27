
import Controller.BillController;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class BillControllerTest {
    
    BillController controller = new BillController();
    
    @Test
    public void testValidAppointment(){
        
       System.out.println();
       System.out.println("TEST 1 Generate Bill with Valid Appointment");
       
       String AppointmentNumber = "129";
       
       System.out.println("Appointment Number: " + AppointmentNumber);
       
       String Outcome = controller.CalculateBill(AppointmentNumber);
       
       System.out.println("Patient Name: Raj Gnadhi");
       System.out.println("Dentist Name: Dr. Joesph");
       System.out.println("Treatment Type: Tooth Extraction");
       System.out.println("Treatment Cost: 500.00");
       System.out.println("Consultation Fee: 800.00");
       System.out.println("Total Cost: 5800.00");
       
       
       String Expected = "Bill Generated";
       System.out.println("Expected Result: " + Expected);
        System.out.println("Actual Result: " + Outcome);
        assertEquals(Expected,Outcome);
       
       System.out.println();
    }
    
    @Test
    public void testInvalidAppointment(){
        
        System.out.println("TEST 2 Generate Bill with Invalid Appointment");
        
        String AppointmentNumber = "180";
        
        System.out.println("Appointment Numer: " + AppointmentNumber);
        
        String Outcome = controller.CalculateBill(AppointmentNumber);
        
        String Expected = "Patient Not Found";
        
        System.out.println("Expected Result: " + Expected);
        System.out.println("Actual Result: " + Outcome);
        assertEquals(Expected,Outcome);
        System.out.println();
    }
    
    @Test
    public void testNoAppointment(){
        
        System.out.println("TEST 3 Generate Bill without Appoiintment");
        String AppointmentNumber = "";
         System.out.println("Appointment Numer: " + AppointmentNumber);
          String Outcome = controller.CalculateBill(AppointmentNumber);
          String Expected = "Enter Appointment Number";
          System.out.println("Expected Result: " + Expected);
        System.out.println("Actual Result: " + Outcome);
        assertEquals(Expected,Outcome);
        System.out.println();
    }
    
    @Test
    public void testValidateAppointmentNumber(){
        
         System.out.println("TEST 4 Validate Appointment");
        String AppointmentNumber = "129";
         System.out.println("Appointment Numer: " + AppointmentNumber);
          String Outcome = controller.ValidateAppointmentNumber(AppointmentNumber);
          String Expected = "Valid Appointment Number";
          System.out.println("Expected Result: " + Expected);
        System.out.println("Actual Result: " + Outcome);
        assertEquals(Expected,Outcome);
        System.out.println();
    }
}
