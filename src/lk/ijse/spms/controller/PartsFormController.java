/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.spms.bo.BOFactory;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.bo.custom.PartsBO;
import lk.ijse.spms.bo.custom.impl.PartdBOImpl;
import lk.ijse.spms.common.IDGenarator;
import lk.ijse.spms.entity.Parts;
import lk.ijse.spms.model.PartsDTO;

/**
 *
 * @author User
 */
public class PartsFormController implements Initializable{
    

    @FXML
    private TextField comboModel;
    @FXML
    private TextField comboCatocory;
    @FXML
    private TextField txtType;
    @FXML
    private JFXButton addBtn;
    @FXML
    private TextField textId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField textDescrip;
    @FXML
    private TextField txtVehicleType;
    @FXML
    private TextField txtQty;
    @FXML
    private TextField txtUntPrs;
    @FXML
    private JFXButton BtnDelette;
    @FXML
    private JFXButton BtnSearch;
    @FXML
    private JFXButton BtnUpdate;
    @FXML
    private TableView<PartsDTO> tablePartDeatails;
    private  static  PartsBO superBO;
    @FXML
    private JFXComboBox<String> idCombo;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        try {
           superBO=  (PartsBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PARTS);
                    partAll();
                    getAllIds();
                    part();
        } catch (Exception ex) {
            Logger.getLogger(PartsFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AddPartDeatails(ActionEvent event) {
    String partName = txtName.getText();
          if(partName.matches("[A-Z]{3,10}")){
              textDescrip.requestFocus();
            String description=textDescrip.getText();
            if(description.matches("[A-Z]{3,10}")){
                txtVehicleType.requestFocus();
                String vehicleType=txtVehicleType.getText();
                if(vehicleType.matches("[A-Z]{3,10}")){
                    comboModel.requestFocus();
                    String model=comboModel.getText();
                    if(model.matches("[A-Z]{3,10}")){
                        comboCatocory.requestFocus();
                        String catocory=comboCatocory.getText();
                        if(catocory.matches("[A-Z]{3,10}")){
                            txtType.requestFocus();
                            String type=txtType.getText();
                            if(type.matches("[A-Z]{3,10}")){
                                txtQty.requestFocus();
                                String qty=txtQty.getText();
                                if(qty.matches("^[0-9]{0,10}")){
                                    txtUntPrs.requestFocus();
                                    String unitPrise=txtUntPrs.getText();
                                    if(unitPrise.matches("[0-9]{3,7}[.]\\d{2}")){
                                       try {
                                        String id=textId.getText();
                                        String name=txtName.getText();
                                        String descriptio=textDescrip.getText();
                                        String vehicleTy=txtVehicleType.getText();
                                        String mode=comboModel.getText();
                                        String catocor=comboCatocory.getText();
                                        String  typ=txtType.getText();
                                        int Qt=Integer.parseInt(txtQty.getText());
                                        double unitPris=Double.parseDouble(txtUntPrs.getText());
                                        Parts cus=new Parts(id, name, descriptio, vehicleTy, mode, catocor, typ, Qt, unitPris);

                                       superBO =  (PartsBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PARTS);
                                        boolean addCustomer = superBO.addParts(cus);
                                        if(addCustomer){
                                            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Added Sucsess", ButtonType.OK);
                                            a.showAndWait();
                                            partAll();

                                        }else{
                                            Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Added Sucsess", ButtonType.OK);
                                            a.showAndWait();
                                        }
                                    } catch (Exception ex) {
                                        Logger.getLogger(PartsFormController.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    }else{
                                    Alert a=new Alert(Alert.AlertType.ERROR, "UnitPrise Somthong Wromng", ButtonType.OK);
                                    a.showAndWait();
                                    }
                                }else{
                                    Alert a=new Alert(Alert.AlertType.ERROR, "qty Somthong Wromng", ButtonType.OK);
                                    a.showAndWait();
                                }
                            }else{
                                Alert a=new Alert(Alert.AlertType.ERROR, "type Somthong Wromng", ButtonType.OK);
                                a.showAndWait();                        
                            }
                        }else{
                            Alert a=new Alert(Alert.AlertType.ERROR, "Catocory Somthong Wromng", ButtonType.OK);
                            a.showAndWait();
                        }
                    }else{
                        Alert a=new Alert(Alert.AlertType.ERROR, "Model Somthong Wromng", ButtonType.OK);
                        a.showAndWait();        
                    }
                }else{
                    Alert a=new Alert(Alert.AlertType.ERROR, "vehicleType Somthong Wromng", ButtonType.OK);
                    a.showAndWait();
                }
            }else{
                Alert a=new Alert(Alert.AlertType.ERROR, "Description Somthong Wromng", ButtonType.OK);
                a.showAndWait(); 
            }
          }else{
              Alert a=new Alert(Alert.AlertType.ERROR, "part Name Somthong Wromng", ButtonType.OK);
              a.showAndWait();                  
        }   
    }
     


    @FXML
    private void OnDelete(ActionEvent event) throws Exception {
      String id=textId.getText();
       superBO =  (PartsBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PARTS);
      boolean IsDelete = superBO.deleteParts(id);
      if(IsDelete){
      Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Deleted Sucsess", ButtonType.OK);
      a.showAndWait();
      partAll();
      } else{
      Alert a=new Alert(Alert.AlertType.ERROR,"Deleted Fail", ButtonType.OK);
      a.showAndWait();
      }
    }

    @FXML
    private void searchParts(ActionEvent event) throws Exception {
        
        String PID=textId.getText();
           superBO =  (PartsBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PARTS);
        Parts parts=superBO.searchParts(PID);
        if (parts != null) {
            textId.setText(parts.getPID());
            txtName.setText(parts.getPART_NAME());
            textDescrip.setText(parts.getDescription());
            txtVehicleType.setText(parts.getVEHICLE_TYPE());
            comboModel.setText(parts.getMODEL());
            comboCatocory.setText(parts.getCATOCORY());
            txtType.setText(parts.getTYPE());
            txtQty.setText(parts.getQTY()+"");
            txtUntPrs.setText(parts.getUnitPrice()+"");
            
        }else{
        
        Alert a=new Alert(Alert.AlertType.ERROR, "No Such Parts", ButtonType.OK);
        a.showAndWait();
        }
        partAll();
     
    }

    @FXML
    private void OnUpdatePart(ActionEvent event) throws Exception {
        String PID=textId.getText();
        String PART_NAME=txtName.getText();
        String Description=textDescrip.getText();
        String VEHICLE_TYPE=txtVehicleType.getText();
        String MODEL=comboModel.getText();
        String CATOCORY=comboCatocory.getText();
        String TYPE=txtType.getText();
        int QTY=Integer.parseInt(txtQty.getText());
        double UnitPrice=Double.parseDouble(txtUntPrs.getText());
        Parts parts=new Parts(PID, PART_NAME, Description, VEHICLE_TYPE, MODEL, CATOCORY, TYPE, QTY, UnitPrice);
        superBO=(PartsBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PARTS);
              boolean isUpdate= superBO.updateParts(parts);
             if(isUpdate){
                 Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Update Sucsess", ButtonType.OK);
                 a.showAndWait();
                 partAll();
             }else{
              Alert a=new Alert(Alert.AlertType.ERROR, "Update Fail", ButtonType.OK);
                 a.showAndWait();
     
             
             }
          }
    
     private void part() throws SQLException, ClassNotFoundException, IOException, Exception {
         String Id;
        Id = IDGenarator.getNewID(" parts", "PID", "P");
        textId.setText(Id);
    }
    
    
       
    private void partAll() throws Exception {
        part();
        tablePartDeatails.getColumns().get(0).setStyle("-fx-alignment:center");
        tablePartDeatails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tablePartDeatails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("partName"));
        tablePartDeatails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Description"));
        tablePartDeatails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tablePartDeatails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("model"));
        tablePartDeatails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("catocory"));
        tablePartDeatails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("type"));
        tablePartDeatails.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tablePartDeatails.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("unitPrise"));
        
         tablePartDeatails.setItems(FXCollections.observableArrayList(superBO.getAllParts()));
         tablePartDeatails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PartsDTO>(){
            @Override
            public void changed(ObservableValue<? extends PartsDTO> observable, PartsDTO oldValue, PartsDTO newValue) {
                PartsDTO parts=observable.getValue();
                textId.setText(parts.getId());
                txtName.setText(parts.getPartName());
                textDescrip.setText(parts.getVehicleType());
                comboModel.setText(parts.getModel());
                txtVehicleType.setText(parts.getVehicleType());
                comboCatocory.setText(parts.getCatocory());
                txtType.setText(parts.getType());
               txtUntPrs.setText(Double.toString(parts.getUnitPrise()));
               txtQty.setText(Integer.toString(parts.getQty()));
            }
         
         
         });
    }
    public void getAllIds()throws Exception{
        ArrayList<String> ids=superBO.getAllIdss();
        idCombo.getItems().clear();
        for (String id : ids) {
            idCombo.getItems().add(id);
        }
    }
}
    
 
