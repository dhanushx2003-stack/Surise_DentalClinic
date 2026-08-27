/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Appointment;
import dao.AppointmentDAO;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class AppointmentController {
    
    private AppointmentDAO dao;
    
    public AppointmentController(){
        dao = new AppointmentDAO();
    }
    
    public String RegisterAppointment(String AppointmentNo, String PatientName, String Address, String ContactNo, String DentistName, String AppointmentDate, String AppointmentTime){
        
        if (AppointmentNo.trim().isEmpty() || PatientName.trim().isEmpty() ||  Address.trim().isEmpty() || ContactNo.trim().isEmpty() || DentistName.trim().isEmpty() || AppointmentDate.trim().isEmpty() || AppointmentTime.trim().isEmpty()){
            return "Empty Fields";
        }
        
        int Number;
        
        try{
            Number = Integer.parseInt(AppointmentNo.trim());
        }catch (NumberFormatException e){
            return "Invalid Appointment Number";
        }
        
        Appointment a = new Appointment();
        
        a.setAppointmentNo(Number);
        a.setPatientName(PatientName);
        a.setAddress(Address);
        a.setContactNo(ContactNo);
        a.setDentistName(DentistName);
        a.setAppointmentDate(AppointmentDate);
        a.setAppointmentTime(AppointmentTime);
        
        try{
            if (dao.AddAppointment(a)){
                return "Patient Registered";
            } else {
                return "Appointment Registration Failed";
            }
        } catch (SQLException e){
            
            if (e.getErrorCode() == 1062){
            return "Duplicate Appointment Number";
        }
            return "Database Error";
        }
    }
    
    public String SearchAppointment(String AppointmentNo){
        
        if (AppointmentNo == null || AppointmentNo.trim().isEmpty()){
            return "Enter Appointment Number";
        }
        
        int appointmentNo;
        
        try{
            appointmentNo = Integer.parseInt(AppointmentNo.trim());
        } catch (NumberFormatException e){
            return "Invalid Appointment Number";
        }
        
        try{
            Appointment appointment = dao.getAppoitmentByNo(appointmentNo);
            
            if (appointment != null){
                return "Patient Found";
            } else {
                return "Patient Not Registered";
            }
        } catch (SQLException e){
            e.printStackTrace();
            return "Database Error";
        }
    }
    
    public String DeleteAppointment(String AppointmentNo){
         
        if (AppointmentNo == null || AppointmentNo.trim().isEmpty()){
            return "Select Appointment";
        }
        
        int appointmentNo;
        
        try{
            appointmentNo = Integer.parseInt(AppointmentNo.trim());
        } catch (NumberFormatException e){
            return "Invalid Appointment Number";
        }
        
        try{
            Appointment appointment = dao.getAppoitmentByNo(appointmentNo);
            
            if (appointment == null){
                return "Select an Appointment";
            }
            
            boolean deleted = dao.DeleteAppointment(appointmentNo);
            
            if (deleted){
                return "Patient Appointment Deleted";
            } else {
                return "Cannot delete appointment";
            }
        } catch (SQLException e){
            e.printStackTrace();
            return "Database Error";
        }
    }
}
