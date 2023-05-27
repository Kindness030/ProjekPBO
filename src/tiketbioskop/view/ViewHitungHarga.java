/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.view;

import java.awt.*;
import java.awt.event.*;
import tiketbioskop.controller.harga.HargaController;
import datatiket.controller.tiket.TiketController;
import tiketbioskop.model.*;
import javax.swing.*;
/**
 *
 * @author HP
 */
public class ViewHitungHarga extends JFrame implements ActionListener {

    HargaController Harga = new HargaController();
    TiketController Tiket = new TiketController();
    
    private JTextField ftambah = new JTextField();
    JLabel fnama = new JLabel();
    JLabel fharga = new JLabel();
    JLabel fmovie = new JLabel();
    JLabel fjenis = new JLabel();
    
    JLabel lnama = new JLabel("NAMA:");
    JLabel lharga = new JLabel("HARGA:");
    JLabel lmovie = new JLabel("MOVIE:");
    JLabel ljenis = new JLabel("Jenis :");
    JLabel ltambah = new JLabel("Tambahan:");
    JLabel ljudul = new JLabel("Perhitungan Harga");
    
    JButton buttonSubmit = new JButton("Edit");
    JButton buttonReset = new JButton("Delete");
    JButton buttonBack = new JButton("Back");
    JButton buttonHarga = new JButton("Total Harga");

    DtTiket tiket;
    public ViewHitungHarga(DtTiket tiket) {
        
        setTitle("Perhitungan Harga");
        setSize(350,350);
        setVisible(true);
        setLocationRelativeTo(null);
        
        this.tiket = tiket;
        
        fnama.setText(tiket.getNama());
        fmovie.setText(String.valueOf(tiket.getMovie()));
        fjenis.setText(String.valueOf(tiket.getJenis()));
        fharga.setText(String.format("%,.2f", tiket.getHarga()));
        
        this.setLayout(null);
        
        this.add(fnama);
        this.add(fharga);
        this.add(fmovie);
        this.add(fjenis);
        this.add(ftambah);
        fnama.setBounds  (150, 60, 130, 30);
        fharga.setBounds  (150, 90, 130, 30);
        fmovie.setBounds  (150, 120,130, 30);
        fjenis.setBounds(150, 150, 130, 30);
        ftambah.setBounds(150, 180, 100, 20);
        
        this.add(lnama);
        this.add(lharga);
        this.add(lmovie);
        this.add(ljenis);
        this.add(ljudul);
        this.add(ltambah);
        lnama.setBounds  (10, 60, 40, 20);
        lharga.setBounds  (10, 90, 40, 20);
        lmovie.setBounds  (10, 120, 40, 20);
        ljenis.setBounds(10, 150, 40, 20);
        ljudul.setBounds (10, 20, 250, 20);
        ltambah.setBounds(10, 180, 120, 20);
        
        this.add(buttonSubmit);
        this.add(buttonReset);
        this.add(buttonBack);  
        this.add(buttonHarga);
        buttonHarga.setBounds  (80, 220, 100, 30);
        buttonSubmit.setBounds(100, 250, 90, 30);
        buttonReset.setBounds (190, 250, 90, 30);
        buttonBack.setBounds  (10,  250, 90, 30);
       
        buttonSubmit.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonHarga.addActionListener(this);
        
        buttonSubmit.setBackground(Color.BLUE);
        buttonReset.setBackground(Color.RED);
        buttonBack.setBackground(Color.YELLOW);
        buttonHarga.setBackground(Color.GREEN);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getFtambah() {
        return ftambah;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == buttonSubmit){
            Tiket.edit(this, tiket);
        }
        if (e.getSource() == buttonReset){
            Tiket.delete(this, tiket.getId());
        }
        if (e.getSource() == buttonBack){
            Harga.back(this);
        }
        if (e.getSource() == buttonHarga) {
        String inputTotal = ftambah.getText();
        if (!inputTotal.isEmpty()) {
            try {
                int total = Integer.parseInt(inputTotal);
                Harga.viewHasil(this, tiket, total);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Total tidak valid");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Total tidak boleh kosong");
        }
    }
    }
    }
    

