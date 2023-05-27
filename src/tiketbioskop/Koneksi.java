/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop;

import java.sql.*;

/**
 *
 * @author HP
 */
public class Koneksi {
    String DBurl = "jdbc:mysql://localhost/bioskop";
    String DBusername = "root";
    String DBpassword = "";
    public Connection koneksi;
    public Statement statement;
    public Koneksi() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Terkoneksi");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}

