/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Staff;
import java.sql.PreparedStatement;
import java.sql.Connection;
import db.DBConnection;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class StaffDAO {

    public boolean register(Staff staff) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO staff(Name, Username, Password, Role) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, staff.getName());
            ps.setString(2, staff.getUsername());
            ps.setString(3, staff.getPassword());
            ps.setString(4, staff.getRole());

            System.out.println("REGISTERING USER");
            System.out.println("Name: " + staff.getName());
            System.out.println("Username: " + staff.getUsername());
            System.out.println("Role: " + staff.getRole());

            int result = ps.executeUpdate();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public String login(String Username, String Password) {

         try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT Role FROM staff "
                   + "WHERE Username = ? AND Password = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, Username);
        ps.setString(2, Password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            String role = rs.getString("Role");

            System.out.println("Username = [" + Username + "]");
            System.out.println("Role = [" + role + "]");

            return role;
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return null;
    }
        public void Admin(){
            try {

        Connection con =
                DBConnection.getConnection();

        String checkSQL =
                "SELECT * FROM staff WHERE Username=?";

        PreparedStatement check =
                con.prepareStatement(checkSQL);

        check.setString(1, "admin");

        ResultSet rs =
                check.executeQuery();

        if (!rs.next()) {

            String sql =
                    "INSERT INTO staff "
                  + "(Name, Username, Password, Role) "
                  + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, "Administrator");
            ps.setString(2, "admin");
            ps.setString(3, "123");
            ps.setString(4, "ADMIN");

            ps.executeUpdate();

            System.out.println(
                    "Admin account created."
            );

        }

    } catch (Exception e) {

        e.printStackTrace();
    }
        }
    }

