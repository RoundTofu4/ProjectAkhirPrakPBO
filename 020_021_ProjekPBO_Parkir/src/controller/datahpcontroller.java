/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata.dataDAO;
import model.*;

import view.Masuk;
import view.LihatData;
import view.Keluar;
import view.Notiket;
import DAOImplement.dataimplement;
/**
 *
 * @author Lenovo
 */

public class datahpcontroller {
    Masuk frame;
    LihatData frame2;
    Keluar frame3;
    Notiket frame4;
    dataimplement impldatahp;
    List<data> dp;
    
    /**
     *
     * @param frame
     * @param frame2
     * @param frame3
     * @param frame4
     */
    public datahpcontroller(Masuk frame, LihatData frame2, Keluar frame3, Notiket frame4){
        this.frame = frame;
        this.frame2 = frame2;
        this.frame3 = frame3;
        this.frame4 = frame4;
        impldatahp = new dataDAO();
        dp = impldatahp.getAll();
    }

    public datahpcontroller(Masuk frame) {
        this.frame = frame;
        impldatahp = new dataDAO();
        dp = impldatahp.getAll();
    }

    public datahpcontroller(LihatData frame2) {
        this.frame2 = frame2;
        impldatahp = new dataDAO();
        dp = impldatahp.getAll();
    }

    public datahpcontroller(Keluar frame3) {
        this.frame3 = frame3;
        impldatahp = new dataDAO();
        dp = impldatahp.getAll();
    }

    public datahpcontroller(Notiket frame4) {
        this.frame4 = frame4;
        impldatahp = new dataDAO();
        dp = impldatahp.getAll();
    }

    
    public void isitabel(){
        dp = impldatahp.getAll();
        modeltabeldata mp = new modeltabeldata(dp);
        frame2.getjTable1().setModel(mp);
    }
    
    public void insert(){
        data dp = new data();
        dp.setNo_pol(frame.getNopol().getText());
        dp.setJenis((String) frame.getJenis().getSelectedItem());
        impldatahp.insert(dp);
        
    }

    public void update(){
        data dp = new data();
        dp.setNo_tiket(Integer.valueOf(frame3.getNo_tiket().getText()));
        impldatahp.update(dp);
    }
    
     public void tampilkeluar(){
         data hp = new data();
         dataDAO dao = new dataDAO();
         hp.setNo_tiket(Integer.valueOf(frame3.getNo_tiket().getText()));
       DataKeluar result = impldatahp.tampilkeluar(hp); 
       String nopol1 = result.getNopol1();
       String wmasuk1 = result.getWmasuk1();
       String wkeluar1 = result.getWkeluar1();
       String biaya = result.getBiaya1();
       frame3.getJlnopol().setText(nopol1);
       frame3.getJlwmasuk().setText(wmasuk1);
       frame3.getJlwkeluar().setText(wkeluar1);
       frame3.getJltotal().setText(biaya);
        
    }
    
    public void delete(){
        int id = Integer.parseInt(frame2.getjButton4().getText());
       impldatahp.delete(id);
    }
    
    public void tampilno(){
    data dp = new data();
//         dp.setWaktu_keluar(frame.getJTxtmerk().getText());
//        dp.setStatus(frame.getJtxtbrand().getText());
//        dp.setNo_tiket(Integer.parseInt(frame4.getJTxtid().getText()));
        //jLabel2.setText(nomor[i-1]);
        impldatahp.tampilno(dp);
    }
}
