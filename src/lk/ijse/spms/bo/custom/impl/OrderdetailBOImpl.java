/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.ijse.spms.bo.custom.OrderdetailBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.custom.CustomerDAO;
import lk.ijse.spms.dao.custom.OrderdetailDAO;
import lk.ijse.spms.dao.custom.OrdersDAO;
import lk.ijse.spms.db.DBConnection;
import lk.ijse.spms.entity.Customer;
import lk.ijse.spms.entity.OrderDetail;
import lk.ijse.spms.entity.Orders;
import lk.ijse.spms.model.CommonDTO;
import lk.ijse.spms.model.CustomerDTO;
import lk.ijse.spms.model.OrderdetailDTO;
import lk.ijse.spms.model.OrdersDTO;

/**
 *
 * @author User
 */
public class OrderdetailBOImpl implements OrderdetailBO{
     private static CustomerDAO customerDAO;
    private  static OrdersDAO ordersDAO;
    private static OrderdetailDAO orderdetailDAO;
 
    public OrderdetailBOImpl() throws Exception {
     ordersDAO= (OrdersDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ORDERS);
        customerDAO=(CustomerDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.CUSTOMER);
        orderdetailDAO=(OrderdetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ORDERDETAIL);
       
    }

    @Override
    public boolean addOrder(CustomerDTO customerDTO, OrdersDTO ordersDTO, ArrayList<OrderdetailDTO>list) throws Exception {
     Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        Orders orders=new Orders(ordersDTO.getOrderID(),ordersDTO.getCust_id(), ordersDTO.getDate(),ordersDTO.getAdvance());
         boolean add = ordersDAO.add(orders);
         if(add){
             for(OrderdetailDTO o : list){
                 OrderDetail orderDeatailsList=new OrderDetail(o.getOrderDetailID(), o.getOrderId(),o.getPid(),o.getOrderQty(),o.getUnitPrise());
                 boolean add1 = orderdetailDAO.add(orderDeatailsList);
            if(!add1){
                connection.rollback();
               connection.setAutoCommit(true);
          
            }
            connection.commit();
                connection.setAutoCommit(true);
                 }
             
             }else{
         connection.rollback();
            connection.setAutoCommit(true);
         }
          return false;
         
    } 

    @Override
    public boolean deleteCustomerWithOrderDetail(CommonDTO dTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection(); 
        connection.setAutoCommit(false);
        try{
            ObservableList<OrderdetailDTO> OrderdetailDTO = dTO.getOrderdetailDTO();
            for (OrderdetailDTO orderdetailDTO : OrderdetailDTO) {
                boolean delete = orderdetailDAO.delete(orderdetailDTO.getOrderDetailID());
                if(!delete){
                    return false;
                }
                delete = ordersDAO.delete(dTO.getOrderDTO().getOrderID());
                if(!delete){
                    connection.rollback();
                    return false;
                }
                delete = customerDAO.delete(dTO.getCustomerDTO().getCust_id());
                if(!delete){
                    connection.rollback();
                    return false;
                }
            } 
            connection.commit();
            return true;
        }finally{
        connection.setAutoCommit(true);
        }
    }     
}
