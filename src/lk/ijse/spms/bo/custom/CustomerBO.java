/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import java.util.ArrayList;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.entity.Customer;
import lk.ijse.spms.entity.Parts;
import lk.ijse.spms.model.CommonDTO;
import lk.ijse.spms.model.CustomerDTO;

/**
 *
 * @author User
 */
public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CommonDTO dTO) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public CustomerDTO searchCustomer(String id) throws Exception;

    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;

    public ArrayList<CustomerDTO> getAllParts() throws Exception;

    public boolean addCustomerWithOrderDetail(CommonDTO dTO) throws Exception;
}
