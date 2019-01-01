/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import java.util.ArrayList;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.model.SuplierDTO;
import lk.ijse.spms.model.SuplierOrderDTO;

/**
 *
 * @author User
 */
public interface SuplierOrderBO extends SuperBO{
    public ArrayList<String> addidList()throws Exception;
    public boolean addSuplierOrder(SuplierOrderDTO dTO)throws Exception;
    public ArrayList<SuplierOrderDTO> getAllSuplierOrders()throws Exception;
    public boolean deleteSupplierOrder(String id)throws Exception;
    public SuplierOrderDTO searchSupplierOrders(String id)throws Exception;
}
