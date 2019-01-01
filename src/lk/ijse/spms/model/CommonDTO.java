/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.model;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class CommonDTO {
    private CustomerDTO customerDTO;
    private OrdersDTO orderDTO;
    private ObservableList<OrderdetailDTO> orderdetailDTO;
    private OrderdetailDTO orderdetailDTO1;
    private SuplierOrderDTO suplierOrderDTO;
    private StockDTO stockDTO;
    
    public CommonDTO() {
    }
     public CommonDTO(SuplierOrderDTO suplierOrderDTO,StockDTO stockDTO) {
         this.suplierOrderDTO=suplierOrderDTO;
         this.stockDTO=stockDTO;
    }
   
    public CommonDTO(CustomerDTO customerDTO, OrdersDTO orderDTO, ObservableList<OrderdetailDTO> orderdetailDTO) {
        this.customerDTO = customerDTO;
        this.orderDTO = orderDTO;
        this.orderdetailDTO = orderdetailDTO;
    }
//`   public CommonDTO(C){
//
//}
    /**
     * @return the customerDTO
     */
    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    /**
     * @param customerDTO the customerDTO to set
     */
    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    /**
     * @return the orderDTO
     */
    public OrdersDTO getOrderDTO() {
        return orderDTO;
    }

    /**
     * @param orderDTO the orderDTO to set
     */
    public void setOrderDTO(OrdersDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    /**
     * @return the orderdetailDTO
     */
    public ObservableList<OrderdetailDTO> getOrderdetailDTO() {
        return orderdetailDTO;
    }

    /**
     * @param orderdetailDTO the orderdetailDTO to set
     */
    public void setOrderdetailDTO(ObservableList<OrderdetailDTO> orderdetailDTO) {
        this.orderdetailDTO = orderdetailDTO;
    }

    /**
     * @return the orderdetailDTO1
     */
    public OrderdetailDTO getOrderdetailDTO1() {
        return orderdetailDTO1;
    }

    /**
     * @param orderdetailDTO1 the orderdetailDTO1 to set
     */
    public void setOrderdetailDTO1(OrderdetailDTO orderdetailDTO1) {
        this.orderdetailDTO1 = orderdetailDTO1;
    }

    /**
     * @return the suplierOrderDTO
     */
    public SuplierOrderDTO getSuplierOrderDTO() {
        return suplierOrderDTO;
    }

    /**
     * @param suplierOrderDTO the suplierOrderDTO to set
     */
    public void setSuplierOrderDTO(SuplierOrderDTO suplierOrderDTO) {
        this.suplierOrderDTO = suplierOrderDTO;
    }

    /**
     * @return the stockDTO
     */
    public StockDTO getStockDTO() {
        return stockDTO;
    }

    /**
     * @param stockDTO the stockDTO to set
     */
    public void setStockDTO(StockDTO stockDTO) {
        this.stockDTO = stockDTO;
    }

   
}
