/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.util.ArrayList;
import lk.ijse.spms.bo.custom.PartsBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.dao.custom.PartsDAO;
import lk.ijse.spms.dao.custom.impl.PartDAOImpl;
import lk.ijse.spms.entity.Parts;
import lk.ijse.spms.model.PartsDTO;
import org.jfree.chart.block.Arrangement;

/**
 *
 * @author User
 */
public class PartdBOImpl implements PartsBO{
    private  static PartsDAO partsDAO=new PartDAOImpl();
    private static PartsDAO superDAO;
public PartdBOImpl() throws Exception{
    superDAO = (PartsDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.PARTS);
}

    @Override
    public boolean addParts(Parts part) throws Exception {
        
         return superDAO.add(part);
    }

    
    @Override
    public boolean deleteParts(String id) throws Exception {
        return superDAO.delete(id);
    }

    @Override
    public Parts searchParts(String id) throws Exception {
        return superDAO.search(id);
    }

    @Override
    public boolean updateParts(Parts parts) throws Exception {
        return superDAO.update(parts);   
    }    

    @Override
    public ArrayList getAllParts() throws Exception {
         
    ArrayList<Parts>pat=partsDAO.getAll();
       ArrayList<PartsDTO>dtos=new ArrayList<>();
        for (Parts guide : pat) {
            dtos.add(new PartsDTO(guide.getPID(),guide.getPART_NAME(),guide.getDescription(),guide.getVEHICLE_TYPE(),guide.getMODEL(),guide.getCATOCORY(),guide.getTYPE(),guide.getQTY(),guide.getUnitPrice()));
           }
        return dtos;  
    }    

    @Override
    public ArrayList<String> getAllIdss() throws Exception {
        ArrayList<Parts> idList=partsDAO.getAll();
        ArrayList<String> newId=new ArrayList<>();
        for (Parts parts : idList) {
            newId.add(parts.getPID());
        }
        return newId;
    }

    @Override
    public PartsDTO searchPartss(String id,String name) throws Exception {
        Parts searchh = partsDAO.searchh(id,name);
        return new PartsDTO(searchh.getPID(), searchh.getPART_NAME(), searchh.getDescription(), searchh.getVEHICLE_TYPE(), searchh.getMODEL(), searchh.getCATOCORY(), searchh.getTYPE(),searchh.getQTY(), searchh.getUnitPrice());
    }
    
}
