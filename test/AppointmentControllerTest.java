
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
public class AppointmentControllerTest {

    AppointmentController controller = new AppointmentController();

    @Test
    public void testValidAppoitmentRegistration() {
        String result = controller.RegisterAppointment("111", "Dilruk Perera", "Negombo", "0779856321", "Dr. Ranjan", "2026-02-12", "10:00 AM");

        System.out.println();
        System.out.println("Test 1 Appointment Registration");
        System.out.println("Appointment Number: 111");
        System.out.println("Patient Name: Dilruk Perera");
        System.out.println("Address: Negombo");
        System.out.println("Contact Number: 0779856321");
        System.out.println("Dentist Name: Dr. Ranjan");
        System.out.println("Appointment Date: 2026-02-12");
        System.out.println("Appointment Time: 10:00 AM");
        System.out.println("Expected Result: Patient Registered");
        System.out.println("Actual Result: " + result);
        assertEquals("Patient Registered", result);
        
        System.out.println();
    }

    @Test
    public void testEmptyFields() {
        String result = controller.RegisterAppointment("", "", "", "", "", "", "");

        System.out.println();
        System.out.println("Test 2 Empty Fields");
        System.out.println("Appointment Number: ");
        System.out.println("Patient Name: ");
        System.out.println("Address: Negombo");
        System.out.println("Contact Number: ");
        System.out.println("Dentist Name: ");
        System.out.println("Appointment Date: ");
        System.out.println("Appointment Time: ");
        System.out.println("Expected Result: Empty Fields");
        System.out.println("Actual Result: " + result);
        assertEquals("Empty Fields", result);
        
        System.out.println("");
    }

    @Test
    public void testInvalidAppointmentNumber() {
        String result = controller.RegisterAppointment("A11", "Dilruk Perera", "Negombo", "0779856321", "Dr. Ranjan", "2026-02-12", "10:00 AM");

        System.out.println();
        System.out.println("Test 3 Invalid Appointment Number");
        System.out.println("Appointment Number: A11");
        System.out.println("Patient Name: Dilruk Perera");
        System.out.println("Address: Negombo");
        System.out.println("Contact Number: 0779856321");
        System.out.println("Dentist Name: Dr. Ranjan");
        System.out.println("Appointment Date: 2026-02-12");
        System.out.println("Appointment Time: 10:00 AM");
        System.out.println("Expected Result: Invalid Appointment Number");
        System.out.println("Actual Result: " + result);
        assertEquals("Invalid Appointment Number", result);
        
        System.out.println("");

    }

    @Test
    public void testDeuplicateAppointmentNumber() {
        String result = controller.RegisterAppointment("112", "Dilruk Perera", "Negombo", "0779856321", "Dr. Ranjan", "2026-02-12", "10:00 AM");
        String result2 = controller.RegisterAppointment("112", "Dilruk Perera", "Negombo", "0779856321", "Dr. Ranjan", "2026-02-12", "10:00 AM");

        System.out.println();
        System.out.println("Test 4 Duplicate Appointment Number");
        System.out.println("Appointment Number: 111");
        System.out.println("Appointment Number: 111");
        System.out.println("Expected Result: Duplicate Appointment Number");
        System.out.println("Actual Result: " + result2);
        assertEquals("Duplicate Appointment Number", result2);
       
        System.out.println("");
    }

    @Test
    public void testNoPatientName() {
        String result = controller.RegisterAppointment("113", "", "Colombo", "0774125632", "Dr. Christine", "2026-05-12", "10:30 AM");

        System.out.println();
        System.out.println("Test 5 No Patient Name");
        System.out.println("Appointment Number: 113");
        System.out.println("Patient Name: ");
        System.out.println("Address: Colombo");
        System.out.println("Contact Number: 0774125632");
        System.out.println("Dentist Name: Dr. Christine");
        System.out.println("Appointment Date: 2026-05-12");
        System.out.println("Appointment Time: 10:30 AM");
        System.out.println("Expected Result: Add the details");
        System.out.println("Actual Result: " + result);
        assertEquals("Empty Fields", result);
        
        System.out.println();
    }

    @Test
    public void testNoAddress() {
        String result = controller.RegisterAppointment("114", "Mark Henry", "", "0775231568", "Dr. Wilson", "2026-08-14", "10:25 AM");
        
        System.out.println();
        System.out.println("Test 6 No Address");
        System.out.println("Appointment Number: 114");
        System.out.println("Patient Name: Mark Henry");
        System.out.println("Address: ");
        System.out.println("Contact Number: 0775231568");
        System.out.println("Dentist Name: Dr. Wilson");
        System.out.println("Appointment Date: 2026-08-14");
        System.out.println("Appointment Time: 10:25 AM");
        System.out.println("Expected Result: Add the details");
        System.out.println("Actual Result: " + result);
        assertEquals("Empty Fields", result);
       
        System.out.println();

    }
    
    @Test
    public void testNoContactNumber(){
        
        String result = controller.RegisterAppointment("115", "Jack Ryan", "Dehiwela", "", "Dr. Marian", "2026-07-07", "08:00 AM");
        
        System.out.println();
        System.out.println("Test 7 No Contact Number");
        System.out.println("Appointment Number: 115");
        System.out.println("Patient Name: Jack Ryan");
        System.out.println("Address: Dehiwela");
        System.out.println("Contact Number: ");
        System.out.println("Dentist Name: Dr. Marian");
        System.out.println("Appointment Date: 2026-07-07");
        System.out.println("Appointment Time: 08:00 AM");
        System.out.println("Expected Result: Add the details");
        System.out.println("Actual Result: " + result);
        assertEquals("Empty Fields", result);
       
        System.out.println();
    }
    
    @Test
    public void testNoAppointmentDate(){
        String result = controller.RegisterAppointment("116", "Sanduni Perera", "Thaladuwa", "0774123256", "Dr. Marian", "", "08:30 PM");
        
        System.out.println();
        System.out.println("Test 8 No Appointment Date");
        System.out.println("Appointment Number: 116");
        System.out.println("Patient Name: Sanduni Perera");
        System.out.println("Address: Thaladuwa");
        System.out.println("Contact Number: 0774123256");
        System.out.println("Dentist Name: Dr. Marian");
        System.out.println("Appointment Date: ");
        System.out.println("Appointment Time: 08:30 PM");
        System.out.println("Expected Result: Add the details");
        System.out.println("Actual Result: " + result);
        assertEquals("Empty Fields", result);
       
        System.out.println();
    }
    
    @Test
    public void testNoAppointmentTime(){
        String result = controller.RegisterAppointment("117", "Mary Watson", "Maradana", "0778523698", "Dr. Joseph", "2026-12-01", "");
        
        System.out.println();
        System.out.println("Test 9 No Appointment Time");
        System.out.println("Appointment Number: 117");
        System.out.println("Patient Name: Mary Watson");
        System.out.println("Address: Maradana");
        System.out.println("Contact Number: 0778523698");
        System.out.println("Dentist Name: Dr. Joseph");
        System.out.println("Appointment Date: 2026-12-01");
        System.out.println("Appointment Time: ");
        System.out.println("Expected Result: Add the details");
        System.out.println("Actual Result: " + result);
        assertEquals("Empty Fields", result);
        
        System.out.println();
    }
}
