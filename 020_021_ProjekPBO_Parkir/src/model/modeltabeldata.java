/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Surya Aji
 */
public class modeltabeldata extends AbstractTableModel{

    List<data> dp;
    public modeltabeldata(List<data>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0) {return "No Tiket";}
        else if (column == 1) {return "No Pol";}
        else if (column == 2) {return "Jenis";}
        else if (column == 3) {return "Waktu Masuk";}
        else if (column == 4) {return "Waktu Keluar";}
        else if (column == 5) {return "Status";}
        else if (column == 6) {return "Biaya";}
        else{return null;}
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (column == 0) {return dp.get(row).getNo_tiket();}
        else if (column == 1) {return dp.get(row).getNo_pol();}
        else if (column == 2) {return dp.get(row).getJenis();}
        else if (column == 3) {return dp.get(row).getWaktu_masuk();}
        else if (column == 4) {return dp.get(row).getWaktu_keluar();}
        else if (column == 5) {return dp.get(row).getStatus();}
        else if (column == 6) {return dp.get(row).getBiaya();}
        else{return null;}
    }
    
}
