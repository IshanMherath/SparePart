/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.model.CommonDTO;

/**
 *
 * @author User
 */
public interface StockBO extends SuperBO{
    public boolean addOrdereWithOrderDetails(CommonDTO dTO)throws Exception;
    public boolean deleteOrdereWithOrderDetails(CommonDTO dTO)throws Exception;
}
