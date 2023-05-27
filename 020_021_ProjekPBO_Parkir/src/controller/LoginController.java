/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.*;
import koneksi.connector;

/**
 *
 * @author Lenovo
 */



public class LoginController {
    Connection connection;
    Login login;
    
    public LoginController(Login login) {
        
        this.login = login;
        
        //JButton jButton1 = login.getjButton1();
        login.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection = connector.connection();
                 PreparedStatement st = null;
                String user = login.getJtfusername().getText();
               
                String cekuser = null;  
                String pass=login.getJpassfield().getText();
                String cekpass = null;
                try{
                    String query = "SELECT * FROM admin WHERE username = '" + user + "' AND password = '" + pass +"'";
                    st = connection.prepareStatement(query);
                    ResultSet resultSet = st.executeQuery();
                    while (resultSet.next()) {
                        cekuser = resultSet.getString("username");
                        cekpass = resultSet.getString("password");
                    }
                    resultSet.close();
                    st.close();
                }catch (SQLException ex){
                    System.out.println("Error");
                }
                if (cekuser == null && cekpass == null) {
                    JOptionPane.showMessageDialog(null,"Username atau Password anda salah","LOGIN",JOptionPane.INFORMATION_MESSAGE);
                    login.setJtfusername("");
                    login.setJpassfield("");
                }else{
                    JOptionPane.showMessageDialog(null,"Login Berhasil !","LOGIN",JOptionPane.INFORMATION_MESSAGE);
                    new KategoriKendaraan().setVisible(true);
                    login.dispose();
                }
            }
        }
      );
    }
}

    

