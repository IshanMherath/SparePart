/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import java.util.ArrayList;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.model.CommonDTO;
import lk.ijse.spms.model.CustomerDTO;
import lk.ijse.spms.model.OrderdetailDTO;
import lk.ijse.spms.model.OrdersDTO;

/**
 *
 * @author User
 */
public interface OrderdetailBO extends SuperBO{
    public boolean addOrder(CustomerDTO customerDTO,OrdersDTO ordersDTO,ArrayList<OrderdetailDTO>list)throws Exception;
     public boolean deleteCustomerWithOrderDetail(CommonDTO dTO) throws Exception;
}
