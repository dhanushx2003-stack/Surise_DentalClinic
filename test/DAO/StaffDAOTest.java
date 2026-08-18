/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Model.Staff;
import dao.StaffDAO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author DELL
 */
public class StaffDAOTest {
    
 
    @Test
    public void testRegisterPatient() {

        Staff staff = new Staff();

        staff.setName("Test Patient");
        staff.setUsername("testpatient001");
        staff.setPassword("12345");
        staff.setRole("Patient");

        StaffDAO dao = new StaffDAO();

        boolean result = dao.register(staff);

        assertTrue(result, "Patient registration should be successful");
    }
}