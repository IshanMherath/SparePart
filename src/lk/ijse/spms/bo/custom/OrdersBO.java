/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import java.util.ArrayList;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.entity.Orders;
import lk.ijse.spms.model.OrdersDTO;

/**
 *
 * @author User
 */
public interface OrdersBO extends SuperBO{
  public boolean addOrders(OrdersDTO dTO)throws Exception;
  public boolean deleteOrders(String id)throws Exception;
  public ArrayList<String> getAllOrdersIds()throws Exception;
  public ArrayList<OrdersDTO> getAllOrders()throws Exception;
}
