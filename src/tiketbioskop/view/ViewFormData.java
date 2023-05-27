/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.view;

import datatiket.controller.tiket.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class ViewFormData extends JFrame implements ActionListener, ItemListener {

    TiketController Tiket = new TiketController();
    
protected String judul;
 
private JTextField fnama = new JTextField();
private JComboBox<String> fmovie = new JComboBox<>();
private JTextField fharga = new JTextField();
private JComboBox<String> fseat = new JComboBox<>();
private JComboBox<String> fjenis = new JComboBox<>();


JLabel lnama    = new JLabel("Nama:");
JLabel lmovie  = new JLabel("Movie:");
String[]movie = {"","Evil Dead Rise", "Loki", "Guardian Of Galaxy"};


JLabel lharga    = new JLabel("Harga:");
JLabel lseat    = new JLabel("Seat:");
String[]seat = {"","A1","A2","A3","A4","A5","B1","B2","B3","B4","B5","C1","C2","C3","C4","C5","D1","D2","D3","D4","D5"};
JLabel ljenis = new JLabel("Jenis :");
String[]jenis = {"","Regular","Gold Class","Velvet"};
JLabel ljudul   = new JLabel("");

JButton buttonSubmit    = new JButton("Submit");
JButton buttonReset     = new JButton("Reset");
JButton buttonBack      = new JButton("Back");

    
    public ViewFormData(String judul) {
        
        setTitle("Form Pembelian Tiket");
        setSize(500,400);
        setVisible(true);

        this.judul = judul;
        
        ljudul.setText(this.judul);
        ljudul.setFont(new Font("Arial",Font.BOLD,20));
        
        this.setLayout(null);

        fnama.setBounds(100, 60, 200, 25);
        fmovie.setBounds(100, 90, 200, 25);
        fjenis.setBounds(100, 120, 200, 25);
        fharga.setBounds(100, 150, 200, 25);
        fseat.setBounds(100, 180, 200, 25);
    
       
        lnama.setBounds(30, 60, 50, 20);
        lmovie.setBounds(30, 90, 50, 20);
        ljenis.setBounds(30, 120, 50, 20);
        lharga.setBounds(30, 150, 50, 20);
        lseat.setBounds(30, 180, 50, 20);
        ljudul.setBounds(10, 10, 250, 20);
        
      
        buttonSubmit.setBounds(30, 240, 80, 25);
        buttonReset.setBounds(115, 240, 80, 25);
        buttonBack.setBounds(200, 240, 80, 25);   
        fmovie.setModel(new DefaultComboBoxModel<>(movie));
        fseat.setModel(new DefaultComboBoxModel<>(seat));
        fjenis.setModel(new DefaultComboBoxModel<>(jenis));
        fjenis.addItemListener(this);

        this.add(fnama);
        this.add(fmovie);
        this.add(fjenis);
        this.add(fharga);
        this.add(fseat);
        this.add(lnama);
        this.add(lmovie);
        this.add(ljenis);
        this.add(lharga);
        this.add(lseat);
        this.add(ljudul);
        this.add(buttonSubmit);
        this.add(buttonReset);
        this.add(buttonBack);
        buttonSubmit.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonBack.addActionListener(this);
        
        buttonReset.setBackground(Color.red);
        buttonSubmit.setBackground(Color.green);
        buttonReset.setForeground(Color.white);
        buttonSubmit.setForeground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public JTextField getFnama() {
        return fnama;
    }

    public JComboBox<String> getFmovie() {
        return fmovie;
    }

    public JTextField getFharga() {
        updateFharga();
        return fharga;
    }

    public JComboBox<String> getFseat() {
        return fseat;
    }

    public JComboBox<String> getFjenis() {
        return fjenis;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    private void updateFharga() {
            String jenis = (String)fjenis.getSelectedItem();
            int harga = 0;
            
            if(jenis.equals("Regular")){
                harga = 100000;
            }else if(jenis.equals("Gold Class")){
                harga = 200000;
            }else if(jenis.equals("Velvet")){
                harga = 300000;
            }
            fharga.setText(String.valueOf(harga));
      
    }
    public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == fjenis && e.getStateChange() == ItemEvent.SELECTED) {
        updateFharga();
    }
}
}

