/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.util.ArrayList;
import lk.ijse.spms.bo.custom.OrderPaymentBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.dao.custom.OrderPaymentDAO;
import lk.ijse.spms.entity.OrderPayment;
import lk.ijse.spms.model.OrderPaymentDTO;

/**
 *
 * @author User
 */
public class OrderPaymentBOImpl implements OrderPaymentBO{
    private static OrderPaymentDAO orderPaymentDAO;
    public OrderPaymentBOImpl() throws Exception {
        orderPaymentDAO = (OrderPaymentDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ORDERPAYMENT);
    }

    @Override
    public ArrayList<OrderPaymentDTO> getAllPayment() throws Exception {
        ArrayList<OrderPaymentDTO> orderPaymentList=new ArrayList<>();
        ArrayList<OrderPayment> all = orderPaymentDAO.getAll();
        for(OrderPayment op : all){
            orderPaymentList.add(new OrderPaymentDTO(op.getOpId(),op.getOrderId(),op.getDate(),op.getAdvance(),op.getFullPayment()));
        }
        return orderPaymentList;
    }

    @Override
    public ArrayList<String> LoardpaymentIds() throws Exception {
        ArrayList<OrderPayment> all = orderPaymentDAO.getAll();
        ArrayList<String> idList=new ArrayList<>();
        for(OrderPayment op : all){
            idList.add(op.getOrderId());
        }
        return idList;
    }

    @Override
    public boolean addPayment(OrderPaymentDTO dTO) throws Exception {   
        OrderPayment op=new OrderPayment(dTO.getOpaymentId(),dTO.getOrderId(),dTO.getPaymentDate(),dTO.getOrderAdvance(),dTO.getOrderFullPayment());
        return orderPaymentDAO.add(op);
    }

    @Override
    public boolean deletePayment(String id) throws Exception {
        return orderPaymentDAO.delete(id);
    }
}

