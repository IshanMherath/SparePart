/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.spms.bo.BOFactory;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.bo.custom.CustomerBO;
import lk.ijse.spms.dao.custom.CustomerDAO;
import lk.ijse.spms.model.CustomerDTO;
import lk.ijse.spms.validation.Validation;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CustomerFormController implements Initializable {

    @FXML
    private JFXButton deleteBtn;
    private static CustomerBO superBO;
    @FXML
    private TextField idText;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXTextField fNameText;
    @FXML
    private JFXTextField lNameText;
    @FXML
    private JFXTextField nicText;
    @FXML
    private JFXTextField addressText;
    @FXML
    private JFXTextField teliText;
    @FXML
    private JFXTextField eMailText;
    @FXML
    private TableView<CustomerDTO> customerTable;
    @FXML
    private JFXButton searchBtn;
    
    private static Validation v1=new Validation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           superBO =(CustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CUSTOMER);
           getCustomerAll();
           //validation=new Validation();
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void DeleteCustomer(ActionEvent event) throws Exception {
        String id = idText.getText();
        boolean deleteCustomer = superBO.deleteCustomer(id);
        if(deleteCustomer){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Delete Sucsess",ButtonType.OK);
            a.showAndWait();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Delete Not Sucsess",ButtonType.OK);
            a.showAndWait();
        } 
    }

    
    @FXML
    private void OnUpdate(ActionEvent event) throws Exception {
        String id=idText.getText();
        String fName=fNameText.getText();
        String lNsame=lNameText.getText();
        String nic=nicText.getText();
        String address=addressText.getText();
        String teli=teliText.getText();
        String email=eMailText.getText();
        CustomerDTO cust=new CustomerDTO(id, fName, lNsame, nic, address, teli, email);
        
         superBO = (CustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CUSTOMER);
        boolean updateCustomer = superBO.updateCustomer(cust);
        if(updateCustomer){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Update Sucsess", ButtonType.OK);
            a.showAndWait();
        }else{
        Alert a=new Alert(Alert.AlertType.ERROR, "Update Fail", ButtonType.OK);
        a.showAndWait();
        }
    }

    @FXML
    private void OnSearchBtn(MouseEvent event) throws Exception {
        String id=idText.getText();
        CustomerDTO searchCustomer = superBO.searchCustomer(id);
        if(searchCustomer !=null){
            idText.setText(searchCustomer.getCust_id());
            fNameText.setText(searchCustomer.getFname());
            lNameText.setText(searchCustomer.getLname());
            nicText.setText(searchCustomer.getNIC());
            addressText.setText(searchCustomer.getAddress());
            teliText.setText(searchCustomer.getTelephone_num());
            eMailText.setText(searchCustomer.getCust_Email());
            }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"No such Customer ", ButtonType.OK);
            a.showAndWait();
             }
        }

    private void getCustomerAll() throws Exception {
        customerTable.getColumns().get(0).setStyle("-fx-alignment:center");
        customerTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Cust_id"));
        customerTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Fname"));
        customerTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Lname"));
        customerTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("NIC"));
        customerTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        customerTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("telephone_num"));
        customerTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("cust_Email"));
        
        customerTable.setItems(FXCollections.observableArrayList(superBO.getAllParts()));
        customerTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerDTO>(){
            @Override
            public void changed(ObservableValue<? extends CustomerDTO> observable, CustomerDTO oldValue, CustomerDTO newValue) {
                CustomerDTO cus=observable.getValue();
                idText.setText(cus.getCust_id());
                fNameText.setText(cus.getFname());
                lNameText.setText(cus.getLname());
                nicText.setText(cus.getNIC());
                addressText.setText(cus.getAddress());
                teliText.setText(cus.getTelephone_num());
                eMailText.setText(cus.getCust_Email());
                
            }
        });
    }

    @FXML
    private void customerNICValdation(KeyEvent event) {
      //  v1.nicValidation(nicText);
    }
}

