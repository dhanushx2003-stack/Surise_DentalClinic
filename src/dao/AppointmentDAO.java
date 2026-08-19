/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Appointment;
import java.sql.Connection;
import db.DBConnection;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class AppointmentDAO {

    public boolean AddAppointment(Appointment a) throws SQLException {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO appointment" + "(AppointmentNo, PatientName, Address, ContactNo, DentistName, TreatmentType, AppointmentDate, AppointmentTime)" + "VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, a.getAppointmentNo());
        ps.setString(2, a.getPatientName());
        ps.setString(3, a.getAddress());
        ps.setString(4, a.getContactNo());
        ps.setString(5, a.getDentistName());
        ps.setString(6, "Not Selected");
        ps.setString(7, a.getAppointmentDate());
        ps.setString(8, a.getAppointmentTime());

        return ps.executeUpdate() > 0;

    }
    
    public boolean UpdateTreatment(int AppointmentNo, String TreatmentType)
            throws SQLException{
        
        Connection con = DBConnection.getConnection();
        
        String sql = "UPDATE appointment SET TreatmentType = ?" + "WHERE AppointmentNo = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, TreatmentType);
        ps.setInt(2, AppointmentNo);
        
        return ps.executeUpdate() > 0;
    }

    public ResultSet getAllAppointments() {

        ResultSet rs = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM appointment";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;

    }

    public ResultSet searchAppointment(int AppointmentNo) {

        ResultSet rs = null;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM appointment WHERE AppointmentNo=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, AppointmentNo);
            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
    
     public ResultSet searchDentistName(String DentistName) {

      ResultSet rs = null;

    try {
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM appointment WHERE DentistName LIKE ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, "%" + DentistName + "%");

        rs = ps.executeQuery();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return rs;
    }
     
     public Appointment getAppoitmentByNo(int AppointmentNo)throws SQLException{
         
         Connection con = DBConnection.getConnection();
         
         String sql = "SELECT * FROM appointment WHERE AppointmentNo=?";
         
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setInt(1, AppointmentNo);
         
         ResultSet rs = ps.executeQuery();
         
         if (rs.next()){
             
             Appointment a = new Appointment();
             
             a.setAppointmentNo(rs.getInt("AppointmentNo"));
             a.setPatientName(rs.getString("PatientName"));
             a.setAddress(rs.getString("Address"));
             a.setContactNo(rs.getString("ContactNo"));
             a.setDentistName(rs.getString("DentistName"));
             a.setTreatmentType(rs.getString("TreatmentType"));
             a.setAppointmentDate(rs.getString("AppointmentDate"));
             a.setAppointmentTime(rs.getString("AppointmentTime"));
             
             return a;
         }
         
         return null;
     }

    public void SaveToFile(Appointment a) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Appointment.txt", true))) {

            bw.write("Appointment Number: " + a.getAppointmentNo());
            bw.newLine();
            bw.write("Patient Name: " + a.getPatientName());
            bw.newLine();
            bw.write("Address: " + a.getAddress());
            bw.newLine();
            bw.write("Contact Number: " + a.getContactNo());
            bw.newLine();
            bw.write("Dentist Name: " + a.getDentistName());
            bw.newLine();
            bw.write("Treatment Type: " + a.getTreatmentType());
            bw.newLine();
            bw.write("Appointment Date: " + a.getAppointmentDate());
            bw.newLine();
            bw.write("Appointment Time: " + a.getAppointmentTime());
            bw.newLine();
            bw.write("----------------------------------------------");
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean DeleteAppointment(int AppointmentNo) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM appointment WHERE AppointmentNo=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, AppointmentNo);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean UpdateAppointment(Appointment a) throws SQLException {

         try {
        Connection con = DBConnection.getConnection();

        String sql = "UPDATE appointment SET "
                + "PatientName=?, "
                + "Address=?, "
                + "ContactNo=?, "
                + "DentistName=?, "
                + "TreatmentType=?, "
                + "AppointmentDate=?, "
                + "AppointmentTime=? "
                + "WHERE AppointmentNo=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, a.getPatientName());
        ps.setString(2, a.getAddress());
        ps.setString(3, a.getContactNo());
        ps.setString(4, a.getDentistName());
        ps.setString(5, a.getTreatmentType());
        ps.setString(6, a.getAppointmentDate());
        ps.setString(7, a.getAppointmentTime());
        ps.setInt(8, a.getAppointmentNo());

        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;

    }

    
   

    
}
