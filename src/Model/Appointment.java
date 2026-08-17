/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



/**
 *
 * @author DELL
 */
public class Appointment {
    
    private int AppointmentNo;
    private String PatientName;
    private String Address;
    private String ContactNo;
    private String DentistName;
    private String TreatmentType;
    private String AppointmentDate;
    private String AppointmentTime;
    
     public int getAppointmentNo(){
       return AppointmentNo; 
    }
    public void setAppointmentNo(int AppointmentNo){
        this.AppointmentNo = AppointmentNo;
    }
     public String getPatientName(){
       return PatientName; 
    }
    public void setPatientName (String PatientName){
        this.PatientName = PatientName;
    }
     public String getAddress(){
       return Address; 
    }
    public void setAddress (String Address){
        this.Address = Address;
    }
    public String getContactNo(){
       return ContactNo; 
    }
    public void setContactNo (String ContactNo){
        this.ContactNo = ContactNo;
    }
     public String getDentistName(){
       return DentistName; 
    }
    public void setDentistName (String DentistName){
        this.DentistName = DentistName;
    }
     public String getTreatmentType(){
       return TreatmentType; 
    }
    public void setTreatmentType (String TreatmentType){
        this.TreatmentType = TreatmentType;
    }
     public String getAppointmentDate(){
       return AppointmentDate; 
    }
    public void setAppointmentDate (String AppointmentDate){
        this.AppointmentDate = AppointmentDate;
    }
     public String getAppointmentTime(){
       return AppointmentTime; 
    }
    public void setAppointmentTime (String AppointmentTime){
        this.AppointmentTime = AppointmentTime;
    }
}
