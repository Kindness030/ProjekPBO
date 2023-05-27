/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketbioskop.controller;

import tiketbioskop.model.*;
import tiketbioskop.view.*;
/**
 *
 * @author HP
 */
public class ControllerMenu {
    public void viewLihatData(ViewMenu menu){
        ModelDataTiket mdt = new ModelDataTiket();
        DtTiket[] result = mdt.getAll();
        menu.toBack();
        ViewListData baru = new ViewListData(result);
        baru.toFront(); 
    }
    public void viewTambahData(ViewMenu menu){
        menu.toBack();
        ViewInputData baru = new ViewInputData();
        baru.toFront(); 
    }
}
