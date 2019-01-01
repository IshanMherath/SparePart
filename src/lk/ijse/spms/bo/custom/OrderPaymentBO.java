/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import java.util.ArrayList;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.model.OrderPaymentDTO;

/**
 *
 * @author User
 */
public interface OrderPaymentBO extends SuperBO{
    public boolean addPayment(OrderPaymentDTO dTO)throws Exception;
    public boolean deletePayment(String id)throws Exception;
    public ArrayList<OrderPaymentDTO> getAllPayment() throws Exception; 
    public ArrayList<String> LoardpaymentIds()throws Exception;
            
}
