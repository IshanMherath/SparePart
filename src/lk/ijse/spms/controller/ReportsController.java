/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.controller;

import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.ijse.spms.db.DBConnection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ReportsController implements Initializable {

    @FXML
    private JFXButton partBtn;
    @FXML
    private JFXButton btnOrder;
    @FXML
    private JFXButton suppBtn;
    @FXML
    private JFXButton btnOrderDtl;
    @FXML
    private JFXButton stokBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onLorsCustomer(ActionEvent event) throws Exception {
    InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/Customer.jasper");
            Connection con = DBConnection.getInstance().getConnection();
            HashMap map = new HashMap();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
            JasperViewer.viewReport(fillReport, false);  
    }

    @FXML
    private void partsreport(ActionEvent event) throws Exception {
        InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/Partss.jasper");
            Connection con = DBConnection.getInstance().getConnection();
            HashMap map = new HashMap();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
            JasperViewer.viewReport(fillReport, false);  
    
    
    }

    @FXML
    private void orderReport(ActionEvent event) throws Exception {
         InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/Order.jasper");
            Connection con = DBConnection.getInstance().getConnection();
            HashMap map = new HashMap();
            JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
            JasperViewer.viewReport(fillReport, false);  
    
    }

    @FXML
    private void supplierReport(ActionEvent event) throws Exception {
      InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/Suplier.jasper");
      Connection con = DBConnection.getInstance().getConnection();
      HashMap map = new HashMap();
      JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
      JasperViewer.viewReport(fillReport, false);    
    }

    @FXML
    private void orderDetailsBtn(ActionEvent event) throws Exception {
      InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/OrderDetail.jasper");
      Connection con = DBConnection.getInstance().getConnection();
      HashMap map = new HashMap();
      JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
      JasperViewer.viewReport(fillReport, false);    
   
    }

    @FXML
    private void stockReport(ActionEvent event) throws Exception {
      InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/Stock.jasper");
      Connection con = DBConnection.getInstance().getConnection();
      HashMap map = new HashMap();
      JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
      JasperViewer.viewReport(fillReport, false);    
   
    }

    @FXML
    private void damagePartLoer(ActionEvent event) throws Exception {
      InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/PamageParts.jasper");
      Connection con = DBConnection.getInstance().getConnection();
      HashMap map = new HashMap();
      JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
      JasperViewer.viewReport(fillReport, false);    
   
    
    }

    @FXML
    private void lordSupplierReport(ActionEvent event) throws Exception {
      InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/SuplierOrder.jasper");
      Connection con = DBConnection.getInstance().getConnection();
      HashMap map = new HashMap();
      JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
      JasperViewer.viewReport(fillReport, false);    
     
    }

    @FXML
    private void lordSupplierOrderPayment(ActionEvent event) throws Exception {
      InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/SuplierOrderPayment.jasper");
      Connection con = DBConnection.getInstance().getConnection();
      HashMap map = new HashMap();
      JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
      JasperViewer.viewReport(fillReport, false);    
     
    }

    @FXML
    private void lordOrderPayment(ActionEvent event) throws Exception {
      InputStream is = this.getClass().getResourceAsStream("/lk/ijse/spms/report/OrderPayment.jasper");
      Connection con = DBConnection.getInstance().getConnection();
      HashMap map = new HashMap();
      JasperPrint fillReport = JasperFillManager.fillReport(is, map, con);
      JasperViewer.viewReport(fillReport, false);    
    
    }
    
}
