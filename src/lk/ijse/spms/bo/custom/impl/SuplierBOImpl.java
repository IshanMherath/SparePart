/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.util.ArrayList;
import lk.ijse.spms.bo.custom.SuplierBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.dao.custom.SuplierDAO;
import lk.ijse.spms.entity.Suplier;
import lk.ijse.spms.model.SuplierDTO;

/**
 *
 * @author User
 */
public class SuplierBOImpl implements SuplierBO{
    private static SuplierDAO suplierDAO; 
            
    public SuplierBOImpl() throws Exception {
         suplierDAO= (SuplierDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.SUPLIER);
    }

    @Override
    public boolean addSuplier(SuplierDTO dTO) throws Exception {
       return suplierDAO.add(new Suplier(dTO.getSup_Id(), dTO.getSup_Name(),dTO.getAddress(), dTO.getCompany(),dTO.getTeliPhone(),dTO.getEmail()));
    }

    @Override
    public boolean deleteSuplier(String id) throws Exception {
        return suplierDAO.delete(id);
    }

    @Override
    public SuplierDTO searchSuplier(String id) throws Exception {
        Suplier search = suplierDAO.search(id);
        return new SuplierDTO(search.getSup_Id_PK(),search.getSup_Name(), search.getAddress(), search.getCompany(), search.getTeliPhone(), search.getEmail());
    }

    @Override
    public boolean updateSuplier(SuplierDTO dTO) throws Exception {
       return suplierDAO.update(new Suplier(dTO.getSup_Id(), dTO.getSup_Name(), dTO.getAddress(), dTO.getCompany(), dTO.getTeliPhone(), dTO.getEmail()));
    }

    @Override
    public ArrayList<SuplierDTO> getAllSuplier() throws Exception {
        ArrayList<Suplier> all = suplierDAO.getAll();
        ArrayList<SuplierDTO> list=new ArrayList<> ();
        for (Suplier ex : all) {
            list.add(new SuplierDTO(ex.getSup_Id_PK(),ex.getSup_Name(), ex.getAddress(), ex.getCompany(), ex.getTeliPhone(), ex.getEmail()));
        }
        return list;
    }

    @Override
    public ArrayList<String> getAllSuplierIds() throws Exception {
        ArrayList<Suplier> all = suplierDAO.getAll();
        ArrayList<String> getAllIds=new ArrayList<>();
        for (Suplier id : all) {
            getAllIds.add(id.getSup_Id_PK());
        }
        return getAllIds;
    }
}
