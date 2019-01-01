/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.ijse.spms.bo.custom.CustomerBO;
import lk.ijse.spms.dao.CrudeDAO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.dao.custom.CustomerDAO;
import lk.ijse.spms.dao.custom.OrderdetailDAO;
import lk.ijse.spms.dao.custom.OrdersDAO;
import lk.ijse.spms.dao.custom.impl.OrderdetailDAOImpl;
import lk.ijse.spms.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.spms.db.DBConnection;
import lk.ijse.spms.entity.Customer;
import lk.ijse.spms.entity.OrderDetail;
import lk.ijse.spms.entity.Orders;
import lk.ijse.spms.model.CommonDTO;
import lk.ijse.spms.model.CustomerDTO;
import lk.ijse.spms.model.OrderdetailDTO;
import lk.ijse.spms.model.TempDTO;

/**
 *
 * @author User
 */
public class CustomerBOImpl implements CustomerBO {

    private static CustomerDAO superDAO;
    private static OrderdetailDAO orderdetailDAO = new OrderdetailDAOImpl();

    private static OrdersDAO ordersDAO = new OrdersDAOImpl();

    public CustomerBOImpl() throws Exception {
        superDAO = (CustomerDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.CUSTOMER);
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return superDAO.delete(id);
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer dto = superDAO.search(id);
        CustomerDTO ref = new CustomerDTO(dto.getCust_id(), dto.getFname(), dto.getLname(), dto.getNIC(), dto.getAddress(), dto.getTelephone_num(), dto.getCust_Email());
        return ref;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        Customer cus = new Customer(customerDTO.getCust_id(), customerDTO.getFname(), customerDTO.getLname(), customerDTO.getNIC(), customerDTO.getAddress(), customerDTO.getTelephone_num(), customerDTO.getCust_Email());
        return superDAO.update(cus);
    }

    @Override
    public ArrayList getAllParts() throws Exception {
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        ArrayList<Customer> all = superDAO.getAll();
        for (Customer cus : all) {
            customerList.add(new CustomerDTO(cus.getCust_id(), cus.getFname(), cus.getLname(), cus.getNIC(), cus.getAddress(), cus.getTelephone_num(), cus.getCust_Email()));
        }
        return customerList;
    }

    @Override
    public boolean addCustomer(CommonDTO dTO) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        System.out.println(dTO.getCustomerDTO().getCust_id());
        try {
            conn.setAutoCommit(false);
            boolean result = superDAO.add(new Customer(dTO.getCustomerDTO().getCust_id(), dTO.getCustomerDTO().getFname(), dTO.getCustomerDTO().getLname(), dTO.getCustomerDTO().getNIC(), dTO.getCustomerDTO().getAddress(), dTO.getCustomerDTO().getTelephone_num(), dTO.getCustomerDTO().getCust_Email()));
            if (!result) {
                return false;
            }
            conn.commit();
            return true;
        } finally {
            conn.rollback();
            conn.setAutoCommit(true);
        }
    }
    @Override
    public boolean addCustomerWithOrderDetail(CommonDTO dTO) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            conn.setAutoCommit(false);
            boolean result = superDAO.add(new Customer(dTO.getCustomerDTO().getCust_id(), dTO.getCustomerDTO().getFname(), dTO.getCustomerDTO().getLname(), dTO.getCustomerDTO().getNIC(), dTO.getCustomerDTO().getAddress(), dTO.getCustomerDTO().getTelephone_num(), dTO.getCustomerDTO().getCust_Email()));
            if (!result) {
                return false;
            }
            System.out.println(dTO.getOrderDTO().getOrderID()+ dTO.getOrderDTO().getDate()+ dTO.getOrderDTO().getDate()+ dTO.getOrderDTO().getAdvance());
           
            result = ordersDAO.add(new Orders(dTO.getOrderDTO().getOrderID() ,dTO.getOrderDTO().getCust_id(), dTO.getOrderDTO().getDate(), dTO.getOrderDTO().getAdvance()));
            if (!result) {
                conn.rollback();
                return false;
            }
            ObservableList<OrderdetailDTO> OrderdetailDTO = dTO.getOrderdetailDTO();
            for (OrderdetailDTO one : OrderdetailDTO) {
                result = orderdetailDAO.add(new OrderDetail(
                        one.getOrderDetailID(),
                        one.getOrderId(),
                        one.getPid(),
                        one.getOrderQty(),
                        one.getUnitPrise()
                ));

                if (!result) {
                    conn.rollback();
                    return false;
                }
            }
            if (!result) {
                conn.rollback();
                return false;
            }
            conn.commit();
            return true;
        } finally {
            conn.rollback();
            conn.setAutoCommit(true);
        }
    }
}
