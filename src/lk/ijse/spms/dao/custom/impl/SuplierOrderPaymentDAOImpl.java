/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.custom.SuplierOrderPaymentDAO;
import lk.ijse.spms.entity.SuplierOrderPayment;

/**
 *
 * @author User
 */
public class SuplierOrderPaymentDAOImpl implements SuplierOrderPaymentDAO{

    @Override
    public boolean add(SuplierOrderPayment entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into suplierorderpayment values(?,?,?,?,?)", entity.getPid_PK(),entity.getSoid_FK(),entity.getDate(),entity.getAdvance(),entity.getFullpayment());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return  CrudUtil.executeUpdate("delete from suplierorderpayment where PID=?", id);
    }

    @Override
    public boolean update(SuplierOrderPayment entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuplierOrderPayment search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SuplierOrderPayment> getAll() throws Exception {
        ArrayList<SuplierOrderPayment> suplierOrderPayment=new ArrayList<>();
        ResultSet query = CrudUtil.executeQuery("Select * from SuplierOrderPayment");
        while(query.next()){
           suplierOrderPayment.add(new SuplierOrderPayment(query.getString(1),
                   query.getString(2),query.getString(3),query.getDouble(4),
                   query.getDouble(5)));
        }
        return suplierOrderPayment;
    }
    
}
