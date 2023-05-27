/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;

import java.util.List;
import model.*;

/**
 *
 * @author Lenovo
 */
public interface dataimplement {

    public void insert(data p);
    public void update(data p);
    public void delete(int id);
    public void tampilno(data p);
    public DataKeluar tampilkeluar(data p);
   
    public List<data> getAll();
    
}
