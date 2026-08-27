/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Appointment;
import dao.AppointmentDAO;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class DentistController {
    
    private AppointmentDAO dao;
    
    public DentistController(){
        dao = new AppointmentDAO();
    }
    
    public String SearchAppointment(String DentistName){
        
        if(DentistName == null || DentistName.trim().isEmpty()){
            return "Enter Dentist Name";
        }
        
        try{
            ResultSet rs = dao.searchDentistName(DentistName);
            if(rs != null && rs.next()){
                return "Appointment Found";
            }else{
                return "Appointment Not Found";
            }
            
        }catch (Exception e){
            return "Error";
        }
    }
    
    public String UpdateTreatmentType(String AppointmentNumber, String TreatmentType){
        
        if (AppointmentNumber == null || AppointmentNumber.trim().isEmpty()){
            return "Enter Appointment Number";
        }
        
        if(TreatmentType == null || TreatmentType.trim().isEmpty()){
            return "Select Treatment Type";
        }
        
        try{
            int AppointmentNo = Integer.parseInt(AppointmentNumber);
            boolean Updated = dao.UpdateTreatment(AppointmentNo, TreatmentType);
            
            if(Updated){
                Appointment a = dao.getAppoitmentByNo(AppointmentNo);
                
                if(a != null){
                    dao.SaveToFile(a);
                }
                return "Appointment Updated";
            } else {
                return "Updated Failed";
            }
        } catch (Exception e){
            return "Error";
        }
    }
}
