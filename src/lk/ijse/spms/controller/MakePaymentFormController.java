/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.spms.bo.BOFactory;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.bo.custom.OrderPaymentBO;
import lk.ijse.spms.bo.custom.OrdersBO;
import lk.ijse.spms.bo.custom.SuplierBO;
import lk.ijse.spms.bo.custom.SuplierOrderBO;
import lk.ijse.spms.bo.custom.SuplierOrderPaymentBO;
import lk.ijse.spms.common.IDGenarator;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.entity.OrderPayment;
import lk.ijse.spms.entity.SuplierOrderPayment;
import lk.ijse.spms.model.OrderPaymentDTO;
import lk.ijse.spms.model.SuplierOrderPaymentDTO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MakePaymentFormController implements Initializable {

    @FXML
    private TextField txtPaymentId;
    @FXML
    private JFXTextField txtFullPayment;
    @FXML
    private JFXTextField textDate;
    @FXML
    private JFXTextField textAdvance;
    @FXML
    private JFXComboBox<String> comboOrderId;
    
    private static OrderPaymentBO superBO;
    @FXML
    private JFXButton addBtn;
    @FXML
    private TableView<OrderPaymentDTO> OrderPaymentTable;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private JFXComboBox<String> CombosuplierId;
    @FXML
    private TextField txtSupplierPaymentId;
    @FXML
    private JFXTextField txtSupPayDate;
    @FXML
    private JFXTextField txtSupAdvance;
    
    private SuplierOrderPaymentBO suplierOrderPaymentBO;
    private static SuplierBO suplierBO;
    private static OrdersBO ordersBO;
    private static  SuplierOrderBO suplierOrderBO;
    @FXML
    private JFXTextField txtFullPaymentt;
    @FXML
    private JFXButton addBtnn;
    @FXML
    private JFXButton deelteBtnn;
    @FXML
    private TableView<SuplierOrderPaymentDTO> suplierPaymentTable;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           superBO =(OrderPaymentBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ORDERPAYMENT);
           suplierOrderPaymentBO = (SuplierOrderPaymentBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPLIERORDERPAYMENT);
             suplierBO=(SuplierBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPLIER);
             ordersBO=(OrdersBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ORDERS);
             suplierOrderBO= (SuplierOrderBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPLIERORDER);
           getAllOrderIds();
           getAllOrderPayment();
           setDateTime();
           getAllSupplierPayment();
           suplierPaymentIds();
           getAllSuplierIds();
           orderPaymentIds();
        } catch (Exception ex) {
            Logger.getLogger(MakePaymentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void getAllOrderIds() throws Exception {
        ArrayList<String> allOrdersIds = ordersBO.getAllOrdersIds();
        comboOrderId.getItems().clear();
        for (String sb : allOrdersIds) {
            comboOrderId.getItems().add(sb);
            
        }
    }
    

    @FXML
    private void addPayment(MouseEvent event) {
        try {
            String opId=txtPaymentId.getText();
            String orderId=comboOrderId.getSelectionModel().getSelectedItem();
            String date=textDate.getText();
            double advance=Double.parseDouble(textAdvance.getText());
            double fullPayment=Double.parseDouble(txtFullPayment.getText());
            OrderPaymentDTO op=new OrderPaymentDTO(opId, orderId, date, advance, fullPayment);
            boolean addPayment = superBO.addPayment(op);
            if(addPayment){
                Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Payment is Added",ButtonType.OK);
                a.showAndWait();
                getAllOrderPayment();
                //txtPaymentId.clear();
                comboOrderId.getItems().clear();
                getAllOrderIds(); 
                //textDate
                textAdvance.clear();
                txtFullPayment.clear();
            }else{
                Alert a=new Alert(Alert.AlertType.ERROR,"Payment is Not Added",ButtonType.OK);
                a.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(MakePaymentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void setDateTime(){
       Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0),new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
                     textDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                     txtSupPayDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
           }      
       }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }  

    private void getAllOrderPayment() throws Exception {
        orderPaymentIds();
        //suplierPaymentIds();
             OrderPaymentTable.getColumns().get(0).setStyle("-fx-alignment:center");
            OrderPaymentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("opaymentId"));
            OrderPaymentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderId"));
            OrderPaymentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
            OrderPaymentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("OrderAdvance"));
            OrderPaymentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("OrderFullPayment"));
            
            OrderPaymentTable.setItems(FXCollections.observableArrayList(superBO.getAllPayment()));
            OrderPaymentTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrderPaymentDTO>(){
                 @Override
                 public void changed(ObservableValue<? extends OrderPaymentDTO> observable, OrderPaymentDTO oldValue, OrderPaymentDTO newValue) {
                     OrderPaymentDTO or=observable.getValue();
                     txtPaymentId.setText(or.getOpaymentId());
                 }
            });
        }

    @FXML
    private void onDeletePayment(ActionEvent event) throws Exception {
        String id=txtPaymentId.getText();
        boolean deletePayment = superBO.deletePayment(id);
        if(deletePayment){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Delete Sucsess", ButtonType.OK);
            a.showAndWait();
            getAllOrderPayment();
            txtPaymentId.clear();
            comboOrderId.getItems().clear();
            textAdvance.clear();
            txtFullPayment.clear();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Delete UnSucsess",ButtonType.OK);
            a.showAndWait();
        }
    }
      private void suplierPaymentIds() throws SQLException, ClassNotFoundException, IOException, Exception {
         String Id;
        Id = IDGenarator.getNewID(" suplierorderpayment", "PID", "SP");
        txtSupplierPaymentId.setText(Id);
    }
  private void orderPaymentIds() throws SQLException, ClassNotFoundException, IOException, Exception {
         String Id;
        Id = IDGenarator.getNewID(" orderpayment", "OPID", "O");
        txtPaymentId.setText(Id);
    }
    private void getAllSuplierIds() throws Exception {
        ArrayList<String> suIds = suplierOrderBO.addidList();
        CombosuplierId.getItems().clear();
        for (String e : suIds) {
            CombosuplierId.getItems().add(e);
            
        }
    }


    @FXML
    private void addSupplierPayment(ActionEvent event) {
        try {
            String spid=txtSupplierPaymentId.getText();
            String soid=CombosuplierId.getValue();
                    //getSelectionModel().getSelectedItem();
            String date=txtSupPayDate.getText();
            double advance=Double.parseDouble(txtSupAdvance.getText());
            double fullPayment=Double.parseDouble(txtFullPaymentt.getText());
            
            SuplierOrderPaymentDTO dTO=new SuplierOrderPaymentDTO(spid, soid, date, advance, fullPayment);
            boolean addSupplierPayment = suplierOrderPaymentBO.addSupplierPayment(dTO);
            if(addSupplierPayment){
                Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Added Sucses", ButtonType.OK);
                a.showAndWait();
                getAllSupplierPayment();
                CombosuplierId.getItems().clear();
                getAllSuplierIds();
                txtSupAdvance.clear();
                txtFullPaymentt.clear();
            }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Adding fail", ButtonType.OK);
            a.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(MakePaymentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void deleteSupplierPayment(ActionEvent event) throws Exception {
        String id=txtSupplierPaymentId.getText();
        boolean deleteSupplierPayment = suplierOrderPaymentBO.deleteSupplierPayment(id);
        if(deleteSupplierPayment){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Delete Sucsess",ButtonType.OK);
            a.showAndWait();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Delete Faile", ButtonType.OK);
            a.showAndWait();
        }
    }

    private void getAllSupplierPayment() {
        try {
            suplierPaymentTable.getColumns().get(0).setStyle("-fx-alignment:center");
            suplierPaymentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("pid"));
            suplierPaymentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("soid"));
            suplierPaymentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
            suplierPaymentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("advance"));
            suplierPaymentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("fullPayment"));
            suplierPaymentTable.setItems(FXCollections.observableArrayList(suplierOrderPaymentBO.getAllSupplierPayment()));
        } catch (Exception ex) {
            Logger.getLogger(MakePaymentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
}
