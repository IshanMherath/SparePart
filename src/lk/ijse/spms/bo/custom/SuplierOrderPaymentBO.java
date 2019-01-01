/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import java.util.ArrayList;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.dao.custom.SuplierOrderPaymentDAO;
import lk.ijse.spms.model.SuplierOrderPaymentDTO;

/**
 *
 * @author User
 */
public interface SuplierOrderPaymentBO extends SuperBO{
    public boolean addSupplierPayment(SuplierOrderPaymentDTO dTO)throws Exception;
    public boolean  deleteSupplierPayment(String id)throws Exception;
    public ArrayList<SuplierOrderPaymentDTO> getAllSupplierPayment()throws Exception;
}