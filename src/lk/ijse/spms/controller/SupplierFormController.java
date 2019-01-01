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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.spms.bo.BOFactory;
import lk.ijse.spms.bo.custom.PartsBO;
import lk.ijse.spms.bo.custom.StockBO;
import lk.ijse.spms.bo.custom.SuplierBO;
import lk.ijse.spms.bo.custom.SuplierOrderBO;
import lk.ijse.spms.common.IDGenarator;
import lk.ijse.spms.entity.SuplierOrder;
import lk.ijse.spms.model.CommonDTO;
import lk.ijse.spms.model.StockDTO;
import lk.ijse.spms.model.SuplierDTO;
import lk.ijse.spms.model.SuplierOrderDTO;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SupplierFormController implements Initializable {

    @FXML
    private TextField txtSupId;
    @FXML
    private JFXTextField txtSupTeli;
    @FXML
    private JFXTextField txtSupAddrss;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private TextField txtSupDate;
    @FXML
    private JFXTextField txtSupQty;
    @FXML
    private JFXComboBox<String> cmbSupId;
    @FXML
    private TableView<SuplierDTO> suplierTable;
    @FXML
    private JFXTextField txtSupEmail;
    @FXML
    private JFXComboBox<String> cmbPartId;
    @FXML
    private TableView<SuplierOrderDTO> SuplierOrderTable;
    
    private static SuplierBO suplierBO;
    @FXML
    private JFXTextField txtSupName;
    @FXML
    private JFXTextField txtCompany;
    
    private static PartsBO partsBO;
    @FXML
    private TextField txtSearchSuplier;
    @FXML
    private JFXButton delDtn;
    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXButton updateBtn;
    private TextField txtStockId;
    @FXML
    private TextField txtUnitPrise;
    @FXML
    private TextField txtSupOrdeId;
    @FXML
    private JFXTextField txtSupplierOrderDetailsId;
    
    private static StockBO stockBO;
    
    private static SuplierOrderBO suplierOrderBO;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private TextField txtSearchSupplierOrder;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            suplier();
            
            suplierBO=(SuplierBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPLIER);
            partsBO=(PartsBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PARTS);
            stockBO=(StockBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.STOCK);
            suplierOrderBO=(SuplierOrderBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.SUPLIERORDER);
            loardPartOds();
            getAllSuplier();
            suplierId();
            sulierOrserId();
            //sulierOrserDeatailsId();
            getAllSupplierOrders();
        } catch (Exception ex) {
            Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void onAddBtn(ActionEvent event) throws Exception {
        boolean addSuplier = suplierBO.addSuplier(new SuplierDTO(txtSupId.getText(), txtSupName.getText(), txtSupAddrss.getText(), txtCompany.getText(),txtSupTeli.getText(),txtSupEmail.getText()));
        if(addSuplier){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Added Suplier", ButtonType.OK);
            a.showAndWait();
            txtSupName.clear();
            txtSupAddrss.clear();
            txtCompany.clear();
            txtSupTeli.clear();
            txtSupEmail.clear();
            suplier();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Adedd Not Supplier", ButtonType.OK);
            a.showAndWait();
        }
    }
    private void suplier() throws SQLException, ClassNotFoundException, IOException, Exception {
         String Id;
        Id = IDGenarator.getNewID(" suplier", "SUP_ID", "S");
        txtSupId.setText(Id);
    }
    private void sulierOrserId() throws SQLException, ClassNotFoundException, IOException, Exception {
         String Id;
        Id = IDGenarator.getNewID(" suplierorder", "SOID", "SO");
        txtSupOrdeId.setText(Id);
    }
    private void sulierOrserDeatailsId() throws SQLException, ClassNotFoundException, IOException, Exception {
         String Id;
        Id = IDGenarator.getNewID(" Stock", "Stock_Id", "SOD");
        txtSupplierOrderDetailsId.setText(Id);
    }
    private void loardPartOds() throws Exception{
        ArrayList<String> idList=partsBO.getAllIdss();
        cmbPartId.getItems().clear();
        for (String id : idList) {
            cmbPartId.getItems().add(id);
        }
    }
    private void suplierId() throws Exception{
        ArrayList<String> allSuplierIds = suplierBO.getAllSuplierIds();
        cmbSupId.getItems().clear();
        for (String id : allSuplierIds) {
            cmbSupId.getItems().add(id);
        }
    }

    @FXML
    private void searchSuppliers(ActionEvent event) throws Exception {
        String id=txtSearchSuplier.getText();
        SuplierDTO searchSuplier = suplierBO.searchSuplier(id);
        if(searchSuplier !=null){
            txtSupId.setText(searchSuplier.getSup_Id());
            txtSupName.setText(searchSuplier.getSup_Name());
            txtSupAddrss.setText(searchSuplier.getAddress());
            txtCompany.setText(searchSuplier.getCompany());
            txtSupTeli.setText(searchSuplier.getTeliPhone());
            txtSupEmail.setText(searchSuplier.getEmail());
        }
    }

    @FXML
    private void onDeleteSupplier(ActionEvent event) throws Exception {
        String id=txtSupId.getText();
        boolean deleteSuplier = suplierBO.deleteSuplier(id);
        if(deleteSuplier){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Delete Supplier", ButtonType.OK);
            a.showAndWait();
            suplier();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Delete Unsucses", ButtonType.OK);
            a.showAndWait();
        }
            
    }

    @FXML
    private void ClearTextField(ActionEvent event) {
        try {
            txtSearchSuplier.clear();
            txtSupId.clear();
            suplier();
            txtSupName.clear();
            txtSupAddrss.clear();
            txtCompany.clear();
            txtSupTeli.clear();
            txtSupEmail.clear();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateSupplier(ActionEvent event) throws Exception {
        boolean updateSuplier = suplierBO.updateSuplier(new SuplierDTO(txtSupId.getText(), txtSupName.getText(), txtSupAddrss.getText(), txtCompany.getText(), txtSupTeli.getText(), txtSupEmail.getText()));
        if(updateSuplier){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Update Sucsess", ButtonType.OK);
            a.showAndWait();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Update Not Sucsess", ButtonType.OK);
            a.showAndWait();
        }
    }

    private void getAllSuplier() {
        try {
            suplierTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sup_Id"));
            suplierTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("sup_Name"));
            suplierTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
            suplierTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("company"));
            suplierTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("teliPhone"));
            suplierTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("email"));
            
            suplierTable.setItems(FXCollections.observableArrayList(suplierBO.getAllSuplier()));
        } catch (Exception ex) {
            Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addtransaction(ActionEvent event) throws Exception {
       String supId;
        String pid=cmbPartId.getSelectionModel().getSelectedItem();
        supId=cmbSupId.getSelectionModel().getSelectedItem();
        int qty=Integer.parseInt(txtSupQty.getText());
        double unitPrise=Double.parseDouble(txtUnitPrise.getText());
        Double amount=qty * unitPrise;
        SuplierOrderDTO suplierOrderDTO=new SuplierOrderDTO(txtSupOrdeId.getText(),supId, pid,qty,amount);
       StockDTO stockDTO=new StockDTO(txtSupplierOrderDetailsId.getText(),pid, txtSupOrdeId.getText(), qty, amount);
        CommonDTO commonDTO=new CommonDTO(suplierOrderDTO, stockDTO);
        boolean addOrdereWithOrderDetails = stockBO.addOrdereWithOrderDetails(commonDTO);
        if(addOrdereWithOrderDetails){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Add Orderss ", ButtonType.OK);
            a.showAndWait();
            sulierOrserId();
            sulierOrserDeatailsId();
            
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Added Not Sucss", ButtonType.OK);
            a.showAndWait();
            
        }
    }

    private void getAllSupplierOrders() {
        try {
            SuplierOrderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("soId"));
            SuplierOrderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("sup_Id"));
            SuplierOrderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("part_Id"));
            SuplierOrderTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
            SuplierOrderTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("amount"));
            
            SuplierOrderTable.setItems(FXCollections.observableArrayList(suplierOrderBO.getAllSuplierOrders()));
        } catch (Exception ex) {
            Logger.getLogger(SupplierFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onDeleteOrderDetails(ActionEvent event) throws Exception {
        String supId;
        String pid=cmbPartId.getSelectionModel().getSelectedItem();
        supId=cmbSupId.getSelectionModel().getSelectedItem();
        int qty=Integer.parseInt(txtSupQty.getText());
        double unitPrise=Double.parseDouble(txtUnitPrise.getText());
        Double amount=qty * unitPrise;
        SuplierOrderDTO suplierOrderDTO=new SuplierOrderDTO(txtSupOrdeId.getText(),supId, pid,qty,amount);
       StockDTO stockDTO=new StockDTO(txtSupplierOrderDetailsId.getText(),pid, txtSupOrdeId.getText(), qty, amount);
        CommonDTO commonDTO=new CommonDTO(suplierOrderDTO, stockDTO);
        boolean deleteOrdereWithOrderDetails = stockBO.deleteOrdereWithOrderDetails(commonDTO);
        if(deleteOrdereWithOrderDetails){
            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Delete Orders", ButtonType.OK);
            a.showAndWait();

        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Delete Not Sucsess", ButtonType.OK);
            a.showAndWait();
        }
     }

    @FXML
    private void searchSupplierOrder(ActionEvent event) throws Exception {
       String id=txtSearchSupplierOrder.getText();
        SuplierOrderDTO search= suplierOrderBO.searchSupplierOrders(id);
        if(search!=null){
            txtSupOrdeId.setText(search.getSoId());
            txtSupId.setText(search.getSup_Id());
            cmbPartId.getItems().add(search.getPart_Id());
            txtSupQty.setText(""+search.getQty());
            
        }
        
    }
}
