/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom;

import java.util.ArrayList;
import lk.ijse.spms.bo.SuperBO;
import lk.ijse.spms.entity.Parts;
import lk.ijse.spms.model.PartsDTO;

/**
 *
 * @author User
 */
public interface PartsBO extends SuperBO{
    public boolean addParts(Parts part)throws Exception;
    public boolean deleteParts(String id)throws Exception;
    public Parts searchParts(String id)throws Exception;
    public boolean updateParts(Parts parts)throws Exception;
    public ArrayList<PartsDTO> getAllParts()throws Exception;
    public ArrayList<String> getAllIdss()throws Exception;
    
    public PartsDTO searchPartss(String id,String name)throws Exception;
}
