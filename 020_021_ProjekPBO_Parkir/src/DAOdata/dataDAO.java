/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdata;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import controller.datahpcontroller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.KategoriKendaraan;
import view.Keluar;
import view.Masuk;
import DAOImplement.dataimplement;
import java.time.*;


/**
 *
 * @author Lenovo
 */
public class dataDAO implements dataimplement{
    Connection connection;
    String[] nomor = new String[500];
    int i = 0;
    
    final String select = "select * from data;";
    final String insert = "INSERT INTO data (no_pol, jenis) VALUES (?, ?);";
    final String delete = "delete from data where no_tiket=?";
    final String update= "update `data` set `status` = 'keluar', `waktu_keluar` = CURRENT_TIMESTAMP, `biaya` = ? WHERE `data`.`no_tiket` = ?";
    final String tampil = "select * from data WHERE `no_tiket` =?";
    public dataDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(data p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNo_pol());
            statement.setString(2, p.getJenis());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            int notikett = 0;
            while(rs.next()){
                p.setNo_tiket(rs.getInt(1));
                notikett = rs.getInt(1);
            }
           
            JOptionPane.showMessageDialog(null, "Nomor Tiket Anda : "+notikett+"", "berhasil", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Input Kosong !", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void delete(int no_tiket) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, no_tiket);
            statement.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Mohon Click Data !", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<data> getAll() {
        List<data> dp = null;
        try{
            dp = new ArrayList<data>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                data hp = new data();
                hp.setNo_tiket(rs.getInt("no_tiket"));
                hp.setNo_pol(rs.getString("no_pol"));
                hp.setJenis(rs.getString("jenis"));
                hp.setWaktu_masuk(rs.getString("waktu_masuk"));
                hp.setWaktu_keluar(rs.getString("waktu_keluar"));
                hp.setStatus(rs.getString("status"));
                hp.setBiaya(rs.getString("biaya"));
                dp.add(hp);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(dataDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dp;
    }

        @Override
    public void update(data p) {
        PreparedStatement statement = null;
        
//------------------------------------------------------------------------------------------------------------
        
        String tampil = "select * from data WHERE `data`.`no_tiket` = "+p.getNo_tiket()+"";
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        Timestamp waktumasuk=null;
        Timestamp waktusekarang = Timestamp.valueOf(LocalDateTime.now());
        String jeniskendaraan1 = null;
        long biaya = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(tampil);
            
            while(rs.next()){
                waktumasuk = rs.getTimestamp("waktu_masuk");
                jeniskendaraan1 = rs.getString("jenis");
            }
            long date1 = waktumasuk.getTime();
            long date2 = date.getTime();
            var diff =  date2 - date1;
            var diffInMs = (diff/1000);
            long jam = diffInMs/3600;
            
            if(jeniskendaraan1.equals("Motor")){
                if (jam<1) {
                    biaya=2000;
                }
                else if (jam>=1) {
                    biaya = 2000 + (1000*(jam-1));
                }
            }
            else if(jeniskendaraan1.equals("Mobil")){
                if (jam<1) {
                    biaya=3000;
                }
                else if (jam>=1) {
                    biaya = 3000 + (2000*(jam-1));
                }
            }
            System.out.println(jeniskendaraan1);
        }
        catch(SQLException ex){System.out.println("ex1");}
        
//-------------------------------------------------------------------------------------------------------------------       
        

        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, Long.toString(biaya));
            statement.setString(2, Integer.toString(p.getNo_tiket()));
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Input Kosong !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
       
    }

    @Override
public DataKeluar tampilkeluar(data p) {
  PreparedStatement statement = null;
  DataKeluar datakeluar = new DataKeluar();
    try {
        statement = connection.prepareStatement(tampil);
        statement.setInt(1, p.getNo_tiket());
        ResultSet rs = statement.executeQuery();
        
        if (rs.next()) {
            data hp = new data();
            
            hp.setNo_pol(rs.getString("no_pol"));
            datakeluar.setNopol1(hp.getNo_pol());
            
            hp.setWaktu_masuk(rs.getString("waktu_masuk"));
            datakeluar.setWmasuk1(hp.getWaktu_masuk());
            
            hp.setWaktu_keluar(rs.getString("waktu_keluar"));
            datakeluar.setWkeluar1(hp.getWaktu_keluar());
            
            hp.setBiaya(rs.getString("biaya"));
            datakeluar.setBiaya1(hp.getBiaya());
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        System.out.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan", "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return datakeluar;
}

    

    @Override
    public void tampilno(data p) {
     PreparedStatement statement = null;
     List<data> dp = null;
            
        try {
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(select);
            String sql = "select * from data";
            while (rs.next()) {
                nomor[i] = rs.getString("no_tiket");
                i++;
            }
//            connector.st.close();
//            connector.koneksi.close();
        }
        catch(SQLException ex){}
        //jLabel2.setText(nomor[i-1]);
        
    }

    

    
     
}
