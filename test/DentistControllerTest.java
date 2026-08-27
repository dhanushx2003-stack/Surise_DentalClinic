
import Controller.DentistController;
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
public class DentistControllerTest {

    DentistController controller = new DentistController();

    @Test
    public void testSearchCorrectDentist() {

        System.out.println("TEST 1 Search Appointment using correct Dentist");
        String DentistName = "Dr. Wilson";
        System.out.println("Dentist Name: " + DentistName);
        String Actual = controller.SearchAppointment(DentistName);

        System.out.println("Appointment Number: 120");
        System.out.println("Patient Name: Maya Fernado");
        System.out.println("Address: Kandy");
        System.out.println("Contact Number: 07796512485");
        System.out.println("Dentist Name: Dr. Wilson");
        System.out.println("Treatment Type: Not Selected");
        System.out.println("Appointment Date: 2026-10-11");
        System.out.println("Appointment Time: 01:30 PM");

        String Expected = "Appointment Found";
        System.out.println("Expected Result: " + Expected);
        System.out.println("Actual Result: " + Actual);
        assertEquals(Expected, Actual);
        System.out.println("");
    }

    @Test
    public void testSearchIncorrectDentist() {

        System.out.println("");
        System.out.println("TEST 2 Search Appointment using incorrect Dentist");
        String DentistName = "Dr. Mark";
        System.out.println("Dentist Name: " + DentistName);
        String Actual = controller.SearchAppointment(DentistName);

        String Expected = "Appointment Not Found";
        System.out.println("Expected Result: " + Expected);
        System.out.println("Actual Result: " + Actual);
        assertEquals(Expected, Actual);
        System.out.println("");
    }
    
    @Test
    public void testSearchNoDentist(){
        
        System.out.println("");
        System.out.println("TEST 3 Search Appointment with no Dentist");
        String DentistName = "";
        System.out.println("Dentist Name: " + DentistName);
        String Actual = controller.SearchAppointment(DentistName);

        String Expected = "Enter Dentist Name";
        System.out.println("Expected Result: " + Expected);
        System.out.println("Actual Result: " + Actual);
        assertEquals(Expected, Actual);
        System.out.println("");
    }
    
    @Test
    public void testSelectTreatment(){
        
        System.out.println("");
        System.out.println("TEST 4 Select Treatment Type");
        String AppointmentNumber = "120";
        String TreatmentType = "Whitening";
        System.out.println("Appointment Number: " + AppointmentNumber);
        System.out.println("Treatment Type: " + TreatmentType);
        String Actual = controller.UpdateTreatmentType(AppointmentNumber, TreatmentType);
          System.out.println("Appointment Number: 120");
        System.out.println("Patient Name: Maya Fernado");
        System.out.println("Address: Kandy");
        System.out.println("Contact Number: 07796512485");
        System.out.println("Dentist Name: Dr. Wilson");
        System.out.println("Treatment Type: Whitening");
        System.out.println("Appointment Date: 2026-10-11");
        System.out.println("Appointment Time: 01:30 PM");

        String Expected = "Appointment Updated";
        System.out.println("Expected Result: " + Expected);
        System.out.println("Actual Result: " + Actual);
        assertEquals(Expected, Actual);
        System.out.println("");
    }
}
