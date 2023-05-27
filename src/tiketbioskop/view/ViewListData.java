/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.view;

import datatiket.controller.tiket.TiketController;
import tiketbioskop.model.DtTiket;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.*;
/**
 *
 * @author HP
 */
public class ViewListData extends JFrame implements MouseListener, ActionListener {

    
    TiketController Tiket = new TiketController();
    
    JLabel ljudul = new JLabel("List Pembelian Tiket");
    JButton buttonBack = new JButton("Back");
    JButton bTambah = new JButton("Tambah Data");    
    DefaultTableModel model;
    JTable tabel;
    DtTiket[] tiket1 = new DtTiket[500];
    
    public ViewListData(DtTiket[] tiket1){
        addMouseListener(this); 
        this.tiket1 = tiket1;
        setTitle("List Tiket yang Dibeli");
        setSize(700,450);
        setVisible(true);
        setLayout(null);
        this.add(ljudul);
        ljudul.setFont(new Font("Arial",Font.BOLD,20));
        ljudul.setBounds(10, 10, 260, 40);
        
        model = new DefaultTableModel();
        tabel = new JTable(model);
        model.setColumnIdentifiers(new Object[]{"ID", "Nama", "Movie", "Seat","Jenis", "Harga"});
        					
        TableColumn column;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tabel.getColumnModel().getColumn(0); 
        column.setPreferredWidth(50);
        column = tabel.getColumnModel().getColumn(1); 
        column.setPreferredWidth(250); 
        column = tabel.getColumnModel().getColumn(2); 
        column.setPreferredWidth(250); 
        column = tabel.getColumnModel().getColumn(3); 
        column.setPreferredWidth(50); 
        column = tabel.getColumnModel().getColumn(4); 
        column.setPreferredWidth(200);
        
        tabel.setBackground(Color.PINK);
        tabel.setRowSelectionAllowed(true);
        tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tabel.setFont(new Font("Arial",Font.PLAIN,14));
        tabel.setSelectionBackground(Color.GREEN);
        tabel.setSelectionForeground(Color.CYAN);
        tabel.addMouseListener(this);
        
        JScrollPane scroll = new JScrollPane(tabel);
        this.add(scroll);
        scroll.setBounds(20,50,600,250);
        this.addData();
        
        this.add(buttonBack);
        buttonBack.setBounds(40,320,80,20);
        buttonBack.addActionListener(this);
        this.add(bTambah);
        bTambah.setBounds(150,320,120,20);
        bTambah.addActionListener(this);
        
         
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addData() {
        DtTiket[] listData = this.tiket1;
       for (DtTiket dttiket : listData) {
            try {
                model.addRow(new Object[]{
                    dttiket.getId(), 
                    dttiket.getNama(),
                    dttiket.getMovie(),
                    dttiket.getSeat(),
                    dttiket.getJenis(),
                    String.format("%,.2f", dttiket.getHarga())});
            } catch (Exception e) {

            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (tabel.getSelectedRow() != -1) {
            int index = tabel.getSelectedRow() ;
            Tiket.viewPerhitunganHarga(this, tiket1[index]);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
 
    }

    @Override
    public void mouseEntered(MouseEvent e) {
  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource() == buttonBack){
            Tiket.back(this);
        }
     if (e.getSource() == bTambah){
            Tiket.input(this);
        }
    
    }
    
}
