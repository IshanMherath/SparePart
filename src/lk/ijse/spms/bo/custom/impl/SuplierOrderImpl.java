/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.spms.bo.custom.SuplierOrderBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.custom.SuplierDAO;
import lk.ijse.spms.dao.custom.SuplierOrderDAO;
import lk.ijse.spms.entity.Suplier;
import lk.ijse.spms.entity.SuplierOrder;
import lk.ijse.spms.model.SuplierDTO;
import lk.ijse.spms.model.SuplierOrderDTO;

/**
 *
 * @author User
 */
public class SuplierOrderImpl implements SuplierOrderBO{
      private static SuplierOrderDAO suplierOrderDAO; 
    public SuplierOrderImpl() {
          try {
              suplierOrderDAO=(SuplierOrderDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.SUPLIERORDER);
          } catch (Exception ex) {
              Logger.getLogger(SuplierOrderImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    @Override
    public ArrayList<String> addidList() throws Exception {
        ArrayList<String> getIdLis=new ArrayList<>();
        ArrayList<SuplierOrder> all = suplierOrderDAO.getAll();
        for (SuplierOrder suplier : all) {
          getIdLis.add(suplier.getSoId());
        }
        return getIdLis;
    }

    @Override
    public boolean addSuplierOrder(SuplierOrderDTO dTO) throws Exception {
        return suplierOrderDAO.add(new SuplierOrder(dTO.getSoId(), dTO.getSup_Id(), dTO.getPart_Id(),dTO.getQty(),dTO.getAmount()));
    }

    @Override
    public ArrayList<SuplierOrderDTO> getAllSuplierOrders() throws Exception {
          ArrayList<SuplierOrder> all = suplierOrderDAO.getAll();
          ArrayList<SuplierOrderDTO> getAllSupplier=new ArrayList<>();
          for (SuplierOrder id : all) {
            getAllSupplier.add(new SuplierOrderDTO(id.getSoId(), id.getSup_Id(), id.getPart_Id(), id.getQty(),id.getAmount()));
        }
          return getAllSupplier;
    }

    @Override
    public boolean deleteSupplierOrder(String id) throws Exception {
        return suplierOrderDAO.delete(id);
    }

    @Override
    public SuplierOrderDTO searchSupplierOrders(String id) throws Exception {
          SuplierOrder search = suplierOrderDAO.search(id);
          return new SuplierOrderDTO(search.getSoId(), search.getSup_Id(), search.getPart_Id(), search.getQty(),search.getAmount());
    }
    
}
