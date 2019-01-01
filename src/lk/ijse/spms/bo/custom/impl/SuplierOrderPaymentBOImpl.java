/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.util.ArrayList;
import lk.ijse.spms.bo.custom.SuplierOrderPaymentBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.dao.custom.SuplierOrderPaymentDAO;
import lk.ijse.spms.entity.SuplierOrderPayment;
import lk.ijse.spms.model.SuplierOrderPaymentDTO;

/**
 *
 * @author User
 */
public class SuplierOrderPaymentBOImpl implements SuplierOrderPaymentBO{
    private static SuplierOrderPaymentDAO suplierOrderPaymentDAO;
    public SuplierOrderPaymentBOImpl() throws Exception {
        suplierOrderPaymentDAO= (SuplierOrderPaymentDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.SUPLIERORDERPAYMENT);
    }
    

    @Override
    public boolean addSupplierPayment(SuplierOrderPaymentDTO dTO) throws Exception {
       // double advance=Double.parseDouble()
       return suplierOrderPaymentDAO.add(new SuplierOrderPayment(dTO.getPid(),dTO.getSoid(),dTO.getDate(),dTO.getAdvance(),dTO.getFullPayment()));
    }

    @Override
    public boolean deleteSupplierPayment(String id) throws Exception {
        return suplierOrderPaymentDAO.delete(id);
    }

    @Override
    public ArrayList<SuplierOrderPaymentDTO> getAllSupplierPayment() throws Exception {
        ArrayList<SuplierOrderPaymentDTO> suplierPayment=new ArrayList<>();
        ArrayList<SuplierOrderPayment> all = suplierOrderPaymentDAO.getAll();
        for (SuplierOrderPayment Op : all) {
            suplierPayment.add(new SuplierOrderPaymentDTO(Op.getPid_PK(),Op.getSoid_FK(), Op.getDate(),Op.getAdvance(),Op.getFullpayment()));
        }
        return suplierPayment;
    }
}
