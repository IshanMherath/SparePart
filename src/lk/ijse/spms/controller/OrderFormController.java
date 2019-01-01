/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.spms.bo.BOFactory;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.bo.custom.CustomerBO;
import lk.ijse.spms.bo.custom.MakeOrderBO;
import lk.ijse.spms.bo.custom.OrderdetailBO;
import lk.ijse.spms.bo.custom.OrdersBO;
import lk.ijse.spms.bo.custom.PartsBO;
import lk.ijse.spms.bo.custom.StockBO;
import lk.ijse.spms.bo.custom.impl.CustomerBOImpl;
import lk.ijse.spms.common.IDGenarator;
import lk.ijse.spms.entity.Customer;
import lk.ijse.spms.entity.Parts;
import lk.ijse.spms.model.CommonDTO;
import lk.ijse.spms.model.CustomerDTO;
import lk.ijse.spms.model.OrderdetailDTO;
import lk.ijse.spms.model.OrdersDTO;
import lk.ijse.spms.model.PartsDTO;
import lk.ijse.spms.model.TempDTO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class OrderFormController implements Initializable {

    @FXML
    private JFXButton butAdd;
    @FXML
    private JFXTextField txtLname;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private TextField txtTeli;
    @FXML
    private TextField txtOrderId;
    @FXML
    private TextField txtOrderDate;
    @FXML
    private TextField txtSearchOrder;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private JFXTextField txtPartId;
    @FXML
    private JFXTextField txtPartName;
    @FXML
    private TableView<OrderdetailDTO> OrderDetailsTable;
    @FXML
    private TextField txtSearchParts;
    @FXML
    private JFXTextField txtFname;
    @FXML
    private JFXTextField txtCustAddress;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtCustId;
    @FXML
    private JFXTextField txtAdvance;

    /**
     * Initializes the controller class.
     */
    CustomerBO customerBO;
    OrdersBO ordersBO;
    OrderdetailBO orderdetailBO;
    StockBO stockBO;
    MakeOrderBO makeOrderBO;
    @FXML
    private JFXTextField txtOrderQty;
    @FXML
    private JFXTextField txtUnitPise;
    @FXML
    private JFXButton butAddCart;
    @FXML
    private JFXTextField txtOrderDtId;
    @FXML
    private TableView<OrdersDTO> orderTable;
    @FXML
    private TextField txtSearchCustomer;
    
    private static PartsBO partsBO;

    public OrderFormController() throws Exception {
        this.customerBO = (CustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CUSTOMER);
        this.ordersBO = (OrdersBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ORDERS);
        this.orderdetailBO = (OrderdetailBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ORDERDETAIL);
        partsBO=(PartsBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PARTS);
        //  stockBO=(StockBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.STOCK);
        // makeOrderBO=(MakeOrderBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.MAKEORDER);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            customerIdGenerator();
            OrderDetailsTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderDetailID"));
            OrderDetailsTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderId"));
            OrderDetailsTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("pid"));
            OrderDetailsTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
            OrderDetailsTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("unitPrise"));
            getAllOrders();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void saveTronsaction(ActionEvent event) throws Exception {
        CustomerDTO customerDTO = new CustomerDTO(txtCustId.getText(), txtFname.getText(), txtLname.getText(), txtNIC.getText(), txtCustAddress.getText(), txtTeli.getText(), txtEmail.getText());
        OrdersDTO ordersDTO = new OrdersDTO(txtOrderId.getText(), txtCustId.getText(), txtOrderDate.getText(), Double.parseDouble(txtAdvance.getText()));
        System.out.println(txtCustId.getText());
        ObservableList<OrderdetailDTO> items = OrderDetailsTable.getItems();
        CommonDTO commonDTO=new CommonDTO(customerDTO, ordersDTO, items);
        boolean addOrder = customerBO.addCustomerWithOrderDetail(commonDTO);
        if (addOrder) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Order Sucsess Fully Added", ButtonType.OK);
            a.showAndWait();

        } else {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Order Not Added", ButtonType.OK);
            a.showAndWait();

        }
    }

    @FXML
    private void onActionAddCart(ActionEvent event) {
        OrderdetailDTO temp = new OrderdetailDTO(
                txtOrderDtId.getText(),
                txtOrderId.getText(),
                txtPartId.getText(),
                Integer.parseInt(txtOrderQty.getText()),
                Double.parseDouble(txtUnitPise.getText())
        );
        OrderDetailsTable.getItems().add(temp);
    }

    @FXML
    private void deleteTrancacton(ActionEvent event) throws Exception {
       CustomerDTO customerDTO = new CustomerDTO(txtCustId.getText(), txtFname.getText(), txtLname.getText(), txtNIC.getText(), txtCustAddress.getText(), txtTeli.getText(), txtEmail.getText());
        OrdersDTO ordersDTO = new OrdersDTO(txtOrderId.getText(), txtCustId.getText(), txtOrderDate.getText(), Double.parseDouble(txtAdvance.getText()));
      
        ObservableList<OrderdetailDTO> items = OrderDetailsTable.getItems();
        CommonDTO commonDTO=new CommonDTO(customerDTO, ordersDTO, items);
        boolean deleteCustome = orderdetailBO.deleteCustomerWithOrderDetail(commonDTO);
        if(deleteCustome){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Delete Sucsess",ButtonType.OK);
            a.showAndWait();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Delete No Sucsess",ButtonType.OK);
            a.showAndWait();
        }
    }
     private void customerIdGenerator() throws SQLException, ClassNotFoundException, IOException, Exception {
         String Id;
        Id = IDGenarator.getNewID(" Customer", "Cust_id", "CUS");
        txtCustId.setText(Id);
    }

    private void getAllOrders() {
        try {
            orderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
            orderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cust_id"));
            orderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
            orderTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("advance"));
            
            orderTable.setItems(FXCollections.observableArrayList(ordersBO.getAllOrders()));
        } catch (Exception ex) {
            Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchParts(ActionEvent event) throws Exception {
        String id=txtSearchParts.getText();
        Parts searchParts = partsBO.searchParts(id);
        if(searchParts!=null){
           txtPartId.setText(searchParts.getPID());
           txtPartName.setText(searchParts.getPART_NAME());            
        }
        
    }

    @FXML
    private void searchPartss(ActionEvent event) throws Exception {
        String name=txtSearchParts.getText();
        String id=txtSearchParts.getText();
        PartsDTO searchPartss = partsBO.searchPartss(id,name);
        if(searchPartss!=null){
            txtPartId.setText(searchPartss.getId());
            txtPartName.setText(searchPartss.getPartName());
            txtUnitPise.setText(""+searchPartss.getUnitPrise());
        
        }
    }

    @FXML
    private void CustomerNameValidate(KeyEvent event) {
        String customerID = txtCustId.getText();
        boolean matches1 = customerID.matches("CUS[0-9]{3,8}");
        if (matches1) {
            txtFname.requestFocus();
        }else{
        Alert a=new Alert(Alert.AlertType.ERROR, "Wrong Customer Id..", ButtonType.OK);
        a.showAndWait();
        
        }
    }

    @FXML
    private void CuatomerNicValidate(KeyEvent event) {
        
    }

    @FXML
    private void customerTeliValidate(KeyEvent event) {
    }

    @FXML
    private void CustomerLastNameValidate(KeyEvent event) {
    }

    @FXML
    private void CustomerAddrssValidate(KeyEvent event) {
    }

    @FXML
    private void CustomerEmailValidate(KeyEvent event) {
    }

    @FXML
    private void CustiIdValidate(KeyEvent event) {
    }
    
}
