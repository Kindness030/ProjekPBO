/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatiket.controller.tiket;

import javax.swing.*;
import java.awt.HeadlessException;
import tiketbioskop.model.*;
import tiketbioskop.view.*;
import tiketbioskop.model.DtTiket;


/**
 *
 * @author HP
 */
public class TiketController {
    public void viewPerhitunganHarga(ViewListData list, DtTiket tiket){
        list.toBack();
        ViewHitungHarga baru = new ViewHitungHarga(tiket);
        baru.toFront(); 
    }
    public void back(ViewListData list){
        list.toBack();
        list.setVisible(false);
    }
    public void input(ViewListData list){
        list.toBack();
        ViewInputData input = new ViewInputData();
        input.toFront();
    }
    /* 
        fungsi Create Data Karyawan
    */
    public void viewMenu(ViewFormData form){
        form.toBack();
        form.setVisible(false);
    }
    public void resetForm(ViewFormData form){
        form.getFnama().setText("");
        form.getFharga().setText("");
        form.getFmovie().setSelectedItem("");
    }


    /* 
        fungsi Add Data Karyawan
    */
    public void addData(ViewInputData input){
        try{
            String nama = input.getFnama().getText();
            String seat = (String)input.getFseat().getSelectedItem();
            String movie = (String)input.getFmovie().getSelectedItem();
            String jenis = (String)input.getFjenis().getSelectedItem();
            double harga = Double.parseDouble(input.getFharga().getText());
                if( harga<0){
                throw new ArithmeticException("Bilangan Tidak Positif");  
            } 
            DtTiket baru = new DtTiket(0,nama,movie,seat,jenis,harga);
            ModelDataTiket mdt = new ModelDataTiket();
            String msg = mdt.create(baru);
            JOptionPane.showMessageDialog(input,msg);
        }catch(HeadlessException | ArithmeticException | NumberFormatException e){
            System.out.print(e.getMessage());
            if ("Bilangan Tidak Positif".equals(e.getMessage())) {
                JOptionPane.showMessageDialog(input,e.getMessage());
            }else{
                JOptionPane.showMessageDialog(input,"Tidak sesuai");
            }
        }
    }  

     /* 
        fungsi Edit Data Karyawan
    */
    public void edit(ViewHitungHarga harga, DtTiket tiket) {
        harga.toBack();
        ViewEditData baru = new ViewEditData(tiket);
        baru.toFront();
    }

     /* 
        fungsi Update Data Karyawan
    */
    public void updateTiket(ViewEditData input, int id){
        try{
            String nama = input.getFnama().getText();
            String movie = (String)input.getFmovie().getSelectedItem();
            String seat = (String)input.getFseat().getSelectedItem();
            String jenis = (String)input.getFjenis().getSelectedItem();
            double harga = Double.parseDouble(input.getFharga().getText());
            if( harga<0){
                throw new ArithmeticException("Bilangan Tidak Positif");  
            } 
            DtTiket baru = new DtTiket(id,nama,movie,seat,jenis,harga);
            ModelDataTiket mdt = new ModelDataTiket();
            String msg = mdt.update(baru);
            JOptionPane.showMessageDialog(input,msg);
        }catch(Exception e){
            System.out.print(e.getMessage());
            if ("Bilangan tidak Positif".equals(e.getMessage())) {
                JOptionPane.showMessageDialog(input,e.getMessage());
            }else{
                JOptionPane.showMessageDialog(input,"Tidak sesuai");
            }
        }
    }

    /* 
        fungsi Delete Data Karyawan
    */
    public void delete(ViewHitungHarga harga, int id) {
        int input = JOptionPane.showConfirmDialog(harga,
                "Yakin ingin menghapus?", "Hapus data",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        System.out.println(input);
        if (input == 0) {
            ModelDataTiket mdt = new ModelDataTiket();
            String msg = mdt.delete(id);
            JOptionPane.showMessageDialog(harga,msg);
            harga.toBack();
        }
    }
}
