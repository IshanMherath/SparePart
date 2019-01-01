/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.custom.StockDAO;
import lk.ijse.spms.entity.Stock;

/**
 *
 * @author User
 */
public class StockDAOImpl implements StockDAO{

    @Override
    public boolean add(Stock entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Stock Values(?,?,?,?,?)", entity.getStock_Id(),entity.getPid(),entity.getSoId(),entity.getQty(),entity.getAmount());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from Stock where Stock_Id=? ", id);
    }

    @Override
    public boolean update(Stock entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stock search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Stock> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
