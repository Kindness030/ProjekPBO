/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.view;

import tiketbioskop.controller.harga.HargaController;
import tiketbioskop.model.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author HP
 */
public class ViewHasil extends JFrame implements ActionListener {
  
    HargaController Harga = new HargaController();
    JLabel ftambah = new JLabel();
    JLabel fnama = new JLabel();
    JLabel fharga = new JLabel();
    JLabel fmovie = new JLabel();
    JLabel fjenis = new JLabel();
    JLabel lnama = new JLabel("NAMA:");
    JLabel lharga = new JLabel("HARGA:");
    JLabel lmovie = new JLabel("MOVIE:");
    JLabel ljenis = new JLabel("Jenis :");
    JLabel ltambah = new JLabel("TOTAL HARGA:");
    JLabel ljudul = new JLabel("Menghitung Harga");
    JButton buttonBack = new JButton("Kembali");
    
    public ViewHasil(DtTiket tiket, int total) {

        setTitle("Hitung Gaji");
        setSize(350,350);
        setVisible(true);
        setLocationRelativeTo(null);
        
        fnama.setText(tiket.getNama());
        fmovie.setText(String.valueOf(tiket.getMovie()));
        fjenis.setText(String.valueOf(tiket.getJenis()));
        fharga.setText(String.valueOf(String.format("%,.2f", tiket.getHarga())));
        ftambah.setText(String.format("%,.2f", (total+25000)+tiket.getHarga()));
        
        this.setLayout(null);
        this.add(fnama);
        this.add(fharga);
        this.add(fmovie);
        this.add(fjenis);
        this.add(ftambah);
        fnama.setBounds(160, 60, 130, 30);
        fharga.setBounds(160, 90, 130, 30);
        fmovie.setBounds(160, 120, 130, 30);
        fjenis.setBounds(160, 150, 130, 30);
        ftambah.setBounds(160, 180, 105, 30);
        
        this.add(lnama);
        this.add(lharga);
        this.add(lmovie);
        this.add(ljenis);
        this.add(ljudul);
        this.add(ltambah);   
        lnama.setBounds(20, 60, 40, 30);
        lharga.setBounds(20, 90, 40, 30);
        lmovie.setBounds(20, 120, 40, 30);
        ljenis.setBounds(20, 150, 40, 30);
        ljudul.setBounds(20, 20, 250, 30);
        lharga.setBounds(20, 180, 120, 30);
        this.add(buttonBack);
        buttonBack.setBounds(20, 260, 85, 35);
        buttonBack.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBack){
            Harga.back(this);
        }
    }

    
    
}
