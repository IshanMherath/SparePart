/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.sql.Connection;
import lk.ijse.spms.bo.custom.StockBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.custom.StockDAO;
import lk.ijse.spms.dao.custom.SuplierOrderDAO;
import lk.ijse.spms.db.DBConnection;
import lk.ijse.spms.entity.Stock;
import lk.ijse.spms.entity.Suplier;
import lk.ijse.spms.entity.SuplierOrder;
import lk.ijse.spms.model.CommonDTO;

/**
 *
 * @author User
 */
public class StockBOImpl implements StockBO{
    private static StockDAO stockDAO;
    private static SuplierOrderDAO suplierOrderDAO;
    public StockBOImpl() throws Exception {
        stockDAO=(StockDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.STOCK);
        suplierOrderDAO=(SuplierOrderDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.SUPLIERORDER);
    }
    
    @Override
    public boolean addOrdereWithOrderDetails(CommonDTO dTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try{
            boolean add = suplierOrderDAO.add(new SuplierOrder(dTO.getSuplierOrderDTO().getSoId(), dTO.getSuplierOrderDTO().getSup_Id(), dTO.getSuplierOrderDTO().getPart_Id(),dTO.getSuplierOrderDTO().getQty(), dTO.getSuplierOrderDTO().getAmount()));
            if(!add){
                return false;
            }
           add=stockDAO.add(new Stock(dTO.getStockDTO().getStock_Id(), dTO.getStockDTO().getPid(), dTO.getStockDTO().getSoId(), dTO.getStockDTO().getQty(), dTO.getStockDTO().getAmount()));
           if(!add){
               connection.rollback();
               return false;
           }
           if(!add){
               connection.rollback();
               return false;
           }
           connection.commit();
           return true;
        }finally{
            connection.setAutoCommit(true);
        }
    }  

    @Override
    public boolean deleteOrdereWithOrderDetails(CommonDTO dTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try{
            boolean delete = suplierOrderDAO.delete(dTO.getSuplierOrderDTO().getSoId());
            if(!delete){
                return false;
            }
            delete=stockDAO.delete(dTO.getStockDTO().getStock_Id());
            if(!delete){
                connection.rollback();
                return false;
            }
            if(!delete){
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        }finally{
        connection.setAutoCommit(true);
        }
    }
}
