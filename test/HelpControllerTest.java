
import Controller.HelpController;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class HelpControllerTest {

    HelpController controller = new HelpController();

    @Test
    public void testHelpSection() {

        String Help = controller.Help();
        String HelpSection = controller.HelpSection();

        System.out.println("TEST Help Section");
        System.out.println("" + Help);

        System.out.println(HelpSection);

        boolean result = Help != null && Help.equals("How to Use Sunrise Dental Clinic")
                && HelpSection != null && !HelpSection.trim().isEmpty() && HelpSection.contains("Staff has to get registered")
                && HelpSection.contains("Register New Appointment") && HelpSection.contains("Display Appointment Details")
                && HelpSection.contains("Calculate and Print Bill") && HelpSection.contains("Help Section")
                && HelpSection.contains("Logout");

        
        System.out.println("Expected Result: Instructions are displayed");
        System.out.println("Actual Result: " + (result ? "Instructions are displayed" : "Instructions aren't displayed"));
        assertTrue(result);
    }
}
