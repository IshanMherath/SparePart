/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.dao.custom.SuplierDAO;
import lk.ijse.spms.entity.Suplier;
import lk.ijse.spms.entity.SuplierOrderPayment;
import lk.ijse.spms.model.SuplierDTO;

/**
 *
 * @author User
 */
public class SuplierDAOImpl implements SuplierDAO{

    @Override
    public boolean add(Suplier entity) throws Exception {
      return CrudUtil.executeUpdate("Insert into suplier values(?,?,?,?,?,?)", entity.getSup_Id_PK(),entity.getSup_Name(),entity.getAddress(),entity.getCompany(),entity.getTeliPhone(),entity.getEmail());
      
    }

    @Override
    public boolean delete(String id) throws Exception {
      return CrudUtil.executeUpdate("Delete from suplier where SUP_ID=?", id);
    }

    @Override
    public boolean update(Suplier entity) throws Exception {
        return CrudUtil.executeUpdate("Update suplier set SUP_NAME=?,Address=?,Company=?,TeliPhone=?,Email=? where SUP_ID=?",entity.getSup_Name(),entity.getAddress(),entity.getCompany(),entity.getTeliPhone(),entity.getEmail(),entity.getSup_Id_PK());
    }

    @Override
    public Suplier search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from suplier where SUP_ID=?", id);
        if(rst.next()){
            return new Suplier(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4), rst.getString(5), rst.getString(6));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Suplier> getAll() throws Exception {
         ArrayList<Suplier> suplier=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from suplier");
        while(rst.next()){
         suplier.add(new Suplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return suplier;
    }
}

 