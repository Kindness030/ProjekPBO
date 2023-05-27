/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.view;

import java.awt.event.ActionEvent;
import tiketbioskop.model.DtTiket;
/**
 *
 * @author HP
 */
public class ViewEditData extends ViewFormData{
    DtTiket edit;
    public ViewEditData(DtTiket tiket) {
        super("Update Pembelian Tiket");
        this.edit = tiket;
        super.getFnama().setText(tiket.getNama());
        super.getFmovie().setSelectedItem(tiket.getMovie());
        super.getFseat().setSelectedItem(tiket.getSeat());
        super.getFjenis().setSelectedItem(tiket.getJenis());
        String hargaText = "";
        double harga = tiket.getHarga();
        if (harga != 0.0) {
            hargaText = String.format("%,.2f", harga);
        }
        super.getFharga().setText(hargaText);

        setLocationRelativeTo(null);
    }
    
     public void actionPerformed(ActionEvent e){
         if (e.getSource() == super.buttonSubmit){
            Tiket.updateTiket(this, edit.getId());
        }
         if (e.getSource() == super.buttonBack){
            Tiket.viewMenu(this);
        }
         if (e.getSource() == super.buttonReset){
            Tiket.resetForm(this);
        }
    }
}
