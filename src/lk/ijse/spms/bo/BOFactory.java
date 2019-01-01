/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo;

import lk.ijse.spms.bo.custom.OrderdetailBO;
import lk.ijse.spms.bo.custom.impl.CustomerBOImpl;
import lk.ijse.spms.bo.custom.impl.DamagepartsBOImpl;
import lk.ijse.spms.bo.custom.impl.MakeOrderBOImpl;
import lk.ijse.spms.bo.custom.impl.OrderPaymentBOImpl;
import lk.ijse.spms.bo.custom.impl.OrderdetailBOImpl;
import lk.ijse.spms.bo.custom.impl.OrdersBOImpl;
import lk.ijse.spms.bo.custom.impl.PartdBOImpl;
import lk.ijse.spms.bo.custom.impl.StockBOImpl;
import lk.ijse.spms.bo.custom.impl.SuplierBOImpl;
import lk.ijse.spms.bo.custom.impl.SuplierOrderImpl;
import lk.ijse.spms.bo.custom.impl.SuplierOrderPaymentBOImpl;

/**
 *
 * @author User
 */
public class BOFactory {
    private static BOFactory bOFactory;
     public enum BOTypes {
       CUSTOMER,DAMAGEPARTS,ORDERDETAIL,ORDERS,PARTS,STOCK,SUPLIER,SUPLIERORDER,MAKEORDER,ORDERPAYMENT,SUPLIERORDERPAYMENT; 
    }
public static BOFactory getBOFactory() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
public SuperBO getSuperBO(BOTypes types) throws Exception {
        switch (types) {
         case CUSTOMER:
             return new CustomerBOImpl();
         case DAMAGEPARTS:
             return new DamagepartsBOImpl();
         case ORDERDETAIL:
             return new OrderdetailBOImpl();
         case ORDERS:
             return new OrdersBOImpl();
         case PARTS:
             return new PartdBOImpl();
         case STOCK:
             return new StockBOImpl();
         case SUPLIER:
             return  new SuplierBOImpl();
         case SUPLIERORDER:
             return new SuplierOrderImpl();
         case MAKEORDER:
             return new MakeOrderBOImpl();
         case ORDERPAYMENT:
             return new OrderPaymentBOImpl();
         case SUPLIERORDERPAYMENT:
             return new SuplierOrderPaymentBOImpl();
         default:
             return null;
        }
   }
}
