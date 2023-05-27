/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.view;

import java.awt.event.*;
/**
 *
 * @author HP
 */
public class ViewInputData extends ViewFormData {
    
    public ViewInputData() {
        super("Input Data Pembeli");
         setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e){
         if (e.getSource() == super.buttonSubmit){
            Tiket.addData(this);
        }
         if (e.getSource() == super.buttonBack){
            Tiket.viewMenu(this);
        }
         if (e.getSource() == super.buttonReset){
            Tiket.resetForm(this);
        }
    }
}
