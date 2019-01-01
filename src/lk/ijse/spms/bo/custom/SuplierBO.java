/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import java.util.ArrayList;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.entity.Suplier;
import lk.ijse.spms.model.SuplierDTO;

/**
 *
 * @author User
 */
public interface SuplierBO extends SuperBO{
    public boolean addSuplier(SuplierDTO dTO)throws Exception;
    public boolean deleteSuplier(String id)throws Exception;
    public SuplierDTO searchSuplier(String id)throws Exception;
    public boolean updateSuplier(SuplierDTO dTO)throws Exception;
    public ArrayList<SuplierDTO> getAllSuplier()throws Exception;
    public ArrayList<String> getAllSuplierIds()throws Exception;
    
    
}
