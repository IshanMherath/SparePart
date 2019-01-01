/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.sql.Connection;
import lk.ijse.spms.bo.custom.CustomerBO;
import lk.ijse.spms.bo.custom.MakeOrderBO;
import lk.ijse.spms.bo.custom.OrderdetailBO;
import lk.ijse.spms.bo.custom.OrdersBO;
import lk.ijse.spms.bo.custom.StockBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.custom.CustomerDAO;
import lk.ijse.spms.dao.custom.OrderdetailDAO;
import lk.ijse.spms.dao.custom.OrdersDAO;
import lk.ijse.spms.dao.custom.StockDAO;
import lk.ijse.spms.db.DBConnection;
import lk.ijse.spms.entity.Customer;
import lk.ijse.spms.entity.OrderDetail;
import lk.ijse.spms.entity.Orders;
import lk.ijse.spms.model.CustomerDTO;
import lk.ijse.spms.model.OrderdetailDTO;
import lk.ijse.spms.model.OrdersDTO;

/**
 *
 * @author User
 */
public class MakeOrderBOImpl implements MakeOrderBO{
     private static CustomerDAO customerDAO;
    private  static OrdersDAO ordersDAO;
    private static OrderdetailDAO orderdetailDAO;
    private static StockDAO stockDAO;
    //private static MakeOrder;
  
    public MakeOrderBOImpl() throws Exception {
        ordersDAO= (OrdersDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ORDERS);
        customerDAO=(CustomerDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.CUSTOMER);
        orderdetailDAO=(OrderdetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ORDERDETAIL);
        stockDAO=(StockDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.STOCK);
    }

    @Override
    public boolean addOrder(CustomerDTO customerDTO, OrdersDTO ordersDTO, OrderdetailDTO orderdetailDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        try {
            boolean add = customerDAO.add(new Customer(customerDTO.getCust_id(),customerDTO.getFname(), customerDTO.getLname(), customerDTO.getNIC(), customerDTO.getAddress(), customerDTO.getTelephone_num(), customerDTO.getCust_Email()));
                if(!add){
                    return false;
                }
             add = ordersDAO.add(new Orders(ordersDTO.getOrderID(), ordersDTO.getCust_id(),ordersDTO.getDate(),ordersDTO.getAdvance()));
                if(!add){
                connection.rollback();
                return false;
                }
              add=orderdetailDAO.add(new OrderDetail(orderdetailDTO.getOrderDetailID(), orderdetailDTO.getOrderId(),orderdetailDTO.getPid(),orderdetailDTO.getOrderQty(), orderdetailDTO.getUnitPrise()));
              if(!add){
                  connection.rollback();
                  return false;
              }
              connection.commit();
              return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
