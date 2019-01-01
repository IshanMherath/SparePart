/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.custom.SuplierOrderDAO;
import lk.ijse.spms.entity.SuplierOrder;
import lk.ijse.spms.model.SuplierOrderDTO;

/**
 *
 * @author User
 */
public class SuplierOrderDAOImpl implements SuplierOrderDAO{

    @Override
    public boolean add(SuplierOrder entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into suplierorder values(?,?,?,?,?)", entity.getSoId(),entity.getSup_Id(),entity.getPart_Id(),entity.getQty(),entity.getAmount());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("Delete from suplierorder where SOID=?", id);
        
    }

    @Override
    public boolean update(SuplierOrder entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuplierOrder search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from suplierorder where SOID=?", id);
        if(rst.next()){
            return new SuplierOrder(rst.getString(1), rst.getString(2),rst.getString(3), rst.getInt(4), rst.getDouble(5));
        }
        return null;
    }

    @Override
    public ArrayList<SuplierOrder> getAll() throws Exception {
        ArrayList<SuplierOrder> newSup=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from suplierorder");
        while(rst.next()){
          newSup.add(new SuplierOrder(rst.getString(1), rst.getString(2), rst.getString(3),rst.getInt(4), rst.getDouble(5)));
        }
        return newSup;
    }
}

