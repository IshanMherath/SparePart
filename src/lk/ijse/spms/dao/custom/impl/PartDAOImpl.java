/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.custom.PartsDAO;
import lk.ijse.spms.entity.Parts;
import lk.ijse.spms.model.PartsDTO;

/**
 *
 * @author User
 */
public class PartDAOImpl implements PartsDAO{

    @Override
    public boolean add(Parts entity) throws Exception {
          String SQL="Insert Into Parts Values(?,?,?,?,?,?,?,?,?)";
          return CrudUtil.executeUpdate(SQL, entity.getPID(),entity.getPART_NAME(),entity.getDescription(),entity.getVEHICLE_TYPE(),entity.getMODEL(),entity.getCATOCORY(),entity.getTYPE(),entity.getQTY(),entity.getUnitPrice());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Parts where PID=?", id);
    }

    @Override
    public boolean update(Parts entity) throws Exception {
        String SQL="UPDATE Parts SET  PART_NAME=?, Description=?, VEHICLE_TYPE=?,MODEL=?,CATOCORY=?,TYPE=?,QTY=?,UnitPrice=? WHERE PID=?";
        String PART_NAME=entity.getPART_NAME();
        String Description=entity.getDescription();
        String VEHICLE_TYPE=entity.getVEHICLE_TYPE();
        String MODEL=entity.getMODEL();
        String CATOCORY=entity.getCATOCORY();
        String TYPE=entity.getTYPE();
        int QTY=entity.getQTY();
        double UnitPrice=entity.getUnitPrice();
         String PID=entity.getPID();
        return CrudUtil.executeUpdate(SQL,PART_NAME,Description,VEHICLE_TYPE,MODEL, CATOCORY,TYPE,QTY,UnitPrice,PID);
    }

    @Override
    public Parts search(String id) throws Exception {
                 ResultSet rst=CrudUtil.executeQuery("Select * From Parts where PID=?", id);
         if(rst.next()){
            String PID=rst.getString("PID");
            String PART_NAME=rst.getString("PART_NAME");
            String Description=rst.getString("Description");
            String VEHICLE_TYPE=rst.getString("VEHICLE_TYPE");
            String CATOCORY=rst.getString("CATOCORY");
            String TYPE=rst.getString("TYPE");
            int QTY=rst.getInt("QTY");
            double UnitPrice=rst.getDouble("UnitPrice");
            Parts parts=new Parts(PID, PART_NAME, Description, VEHICLE_TYPE, TYPE, CATOCORY, TYPE, QTY, UnitPrice);
               return  parts;
         }else{
             return null;
         }

    }

    @Override
    public ArrayList<Parts> getAll() throws Exception {
                ArrayList<Parts> partList=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("select * from Parts");
        while(rst.next()){
            partList.add(new Parts(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getInt(8),rst.getDouble(9)));
            }
        return partList;
       
    }

    @Override
    public Parts searchh(String id,String name) throws Exception {
        ResultSet rst = CrudUtil.executeQuery(" select * from parts where pid=? || PART_NAME=?", id,name);
            if(rst.next()){
            String PID=rst.getString("PID");
            String PART_NAME=rst.getString("PART_NAME");
            String Description=rst.getString("Description");
            String VEHICLE_TYPE=rst.getString("VEHICLE_TYPE");
            String CATOCORY=rst.getString("CATOCORY");
            String TYPE=rst.getString("TYPE");
            int QTY=rst.getInt("QTY");
            double UnitPrice=rst.getDouble("UnitPrice");
            Parts parts=new Parts(PID, PART_NAME, Description, VEHICLE_TYPE, TYPE, CATOCORY, TYPE, QTY, UnitPrice);
               return  parts;
         }else{
             return null;
         }

    }
}
 