/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao;

import lk.ijse.spms.bo.BOFactory;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.bo.custom.impl.CustomerBOImpl;
import lk.ijse.spms.bo.custom.impl.DamagepartsBOImpl;
import lk.ijse.spms.bo.custom.impl.OrderdetailBOImpl;
import lk.ijse.spms.bo.custom.impl.OrdersBOImpl;
import lk.ijse.spms.bo.custom.impl.PartdBOImpl;
import lk.ijse.spms.bo.custom.impl.StockBOImpl;
import lk.ijse.spms.bo.custom.impl.SuplierBOImpl;
import lk.ijse.spms.bo.custom.impl.SuplierOrderImpl;
import lk.ijse.spms.dao.custom.OrderPaymentDAO;
import lk.ijse.spms.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.spms.dao.custom.impl.DamagePartsDAOmpl;
import lk.ijse.spms.dao.custom.impl.OrderPaymentDAOImpl;
import lk.ijse.spms.dao.custom.impl.OrderdetailDAOImpl;
import lk.ijse.spms.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.spms.dao.custom.impl.PartDAOImpl;
import lk.ijse.spms.dao.custom.impl.StockDAOImpl;
import lk.ijse.spms.dao.custom.impl.SuplierDAOImpl;
import lk.ijse.spms.dao.custom.impl.SuplierOrderDAOImpl;
import lk.ijse.spms.dao.custom.impl.SuplierOrderPaymentDAOImpl;

/**
 *
 * @author User
 */
public class DAOFactory {
    private static DAOFactory daof;

    public enum DAOFactypes{
        CUSTOMER,DAMAGEPARTS,ORDERDETAIL,ORDERS,PARTS,STOCK,SUPLIER,SUPLIERORDER,ORDERPAYMENT,SUPLIERORDERPAYMENT;
    }
    public static DAOFactory getDAOFactory(){
        if(daof==null){
            daof=new DAOFactory();
        }
        return daof;
    }
    public SuperDAO getSuperDAO(DAOFactypes types) throws Exception {
           switch(types){
               case CUSTOMER:
                   return new CustomerDAOImpl();
               case DAMAGEPARTS:
                   return new DamagePartsDAOmpl();
               case PARTS:
                   return new PartDAOImpl();
               case ORDERS:
                   return  new OrdersDAOImpl();
               case ORDERDETAIL:
                   return new  OrderdetailDAOImpl();
               case STOCK:
                   return new StockDAOImpl();
               case SUPLIER:
                   return new SuplierDAOImpl();
               case SUPLIERORDER:
                   return new SuplierOrderDAOImpl();
                case ORDERPAYMENT:
                    return new OrderPaymentDAOImpl();
                case SUPLIERORDERPAYMENT:
                    return new SuplierOrderPaymentDAOImpl();
                   default:
                       return null;
           }
   
        }
}

    

