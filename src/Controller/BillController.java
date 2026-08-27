/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dao.AppointmentDAO;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class BillController {
    
    private AppointmentDAO dao;
    
    public BillController(){
        dao = new AppointmentDAO();
    }
    
    public String CalculateBill(String AppointmentNumber){
        
        if(AppointmentNumber == null || AppointmentNumber.trim().isEmpty()){
            return "Enter Appointment Number";
        }
        
        int appointmentNo;
        
        try{
            appointmentNo = Integer.parseInt(AppointmentNumber);
        }catch (NumberFormatException e){
            return "Invalid Appointment Number";
        }
         ResultSet rs = dao.searchAppointment(appointmentNo);
         
         try{
             if(rs.next()){
                 String PatientName = rs.getString("PatientName");
                 String DentistName = rs.getString("DentistName");
                  String TreatmentType = rs.getString("TreatmentType");
                  
                  double TreatmentCost = 0;
                  
                  switch (TreatmentType){
                      case "Root Canal":
                      TreatmentCost = 1000;
                      break;
                      
                      case "Whitening":
                      TreatmentCost = 2000;
                      break;
                      
                      case "Cleaning":
                      TreatmentCost = 3000;
                      break;
                      
                      case "Dental Implants":
                      TreatmentCost = 4000;
                      break;
                      
                      case "Tooth Extarction":
                      TreatmentCost = 5000;
                      break;
                  }
                  
                  double ConsultationFee = 0;
                  
                  switch (DentistName){
                      case "Dr. Ranjan":
                          ConsultationFee = 500;
                          break;
                          
                          case "Dr. Marian":
                          ConsultationFee = 600;
                          break;
                          
                          case "Dr. Wilson":
                          ConsultationFee = 700;
                          break;
                          
                          case "Dr. Joseph":
                          ConsultationFee = 800;
                          break;
                          
                          case "Dr. Christine":
                          ConsultationFee = 900;
                          break;
                  }
                  
                  double TotalCost = TreatmentCost + ConsultationFee;
                  
                  return "Bill Generated";
             }else{
                 return "Patient Not Found";
             }
         }catch (Exception e){
             return "Error";
         }
    }
    
    public String ValidateAppointmentNumber(String AppointmentNumber){
        
        if(AppointmentNumber == null || AppointmentNumber.trim().isEmpty()){
            return "Enter Appointment Number";
        }
        
        try{
            Integer.parseInt(AppointmentNumber);
            return "Valid Appointment Number";
        } catch (NumberFormatException e){
            return "Invalid Appointment Number";
        }
    }
   
}
