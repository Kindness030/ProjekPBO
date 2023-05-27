/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.model;

/**
 *
 * @author HP
 */
public class DtTiket {
    private int id;
    private double harga;
    private String nama;
    private String movie;
    private String seat;
    private String jenis;

    public DtTiket(int id, String nama, String movie, String seat, String jenis, double harga) {
        this.id = id;
        this.harga = harga;
        this.nama = nama;
        this.movie = movie;
        this.seat = seat;
        this.jenis = jenis;
       
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    
}
