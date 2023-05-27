/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.controller.harga;

import tiketbioskop.model.*;
import tiketbioskop.view.*;
/**
 *
 * @author HP
 */
public class HargaController {
    public void back(ViewHitungHarga harga){
        harga.toBack();
        harga.setVisible(false);
        
    }
     public void viewHasil(ViewHitungHarga harga, DtTiket tiket, int total) {
        harga.toBack();
        ViewHasil baru = new ViewHasil(tiket, total);
        baru.toFront();
    }
    public void back(ViewHasil hasil){
        hasil.toBack();
        hasil.setVisible(false);
        
    }

    
}
