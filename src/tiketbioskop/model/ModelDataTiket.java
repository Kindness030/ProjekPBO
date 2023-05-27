/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.model;

import java.sql.*;
import tiketbioskop.Koneksi;

/**
 *
 * @author HP
 */
public class ModelDataTiket {
    DtTiket data[] = new DtTiket[100];
    Koneksi connector = new Koneksi();
    
    public DtTiket[] getAll(){
        try{
            int jumlahDT = 0;
            String query = "Select * from `tiket`";
            
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String movie = resultSet.getString("movie");
                double harga = resultSet.getDouble("harga");
                String seat = resultSet.getString("seat");
                String jenis = resultSet.getString("jenis");
                data[jumlahDT] = new DtTiket(id,nama,movie,seat, jenis, harga);
                jumlahDT++;
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
       return data;
    }
    
    public DtTiket getOne(String ids){
        try{
            String query = "Select * from `tiket` where `id` ='"+ids+"'";
            
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String movie = resultSet.getString("movie");
                double harga = resultSet.getDouble("harga");
                String seat = resultSet.getString("seat");
                String jenis = resultSet.getString("jenis");
                data[0] = new DtTiket(id,nama,movie,seat, jenis, harga);
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
        return data[0];
    }
    
    public String create(DtTiket tiket){
        String message = "...";
        try{
            String nama = tiket.getNama();
            double harga = tiket.getHarga();
            String movie = tiket.getMovie();
            String seat = tiket.getSeat();
            String jenis = tiket.getJenis();
            String query = "INSERT INTO `tiket` VALUE(NULL,'"+nama+"','"+movie+"','"+harga+"','"+seat+"','"+jenis+"')";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            
            message = "Berhasil Create Data";
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
        return message;
    }
    
    public String delete(int id){
        String message= "...";
        try{
            String query = "DELETE FROM tiket WHERE id = '" + id + "'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            
            message = "Berhasil Delete";
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
        return message;
    }
    
    public String update(DtTiket tiket){
        String message = "...";
        try{
            String query = "UPDATE tiket set nama = '"+tiket.getNama()+"', harga = "+tiket.getHarga()+", movie = '"+tiket.getMovie()+"',seat = '"+tiket.getSeat()+"', jenis = '"+tiket.getJenis()+"' WHERE id = '"+tiket.getId()+"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            
            message = "Berhasil Update Data";
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
        return message;
    }
}
