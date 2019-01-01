/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom;


import lk.ijse.spms.dao.CrudeDAO;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.entity.Parts;

/**
 *
 * @author User
 */
public interface PartsDAO extends CrudeDAO<Parts, String>{
    public Parts searchh(String id,String name)throws Exception;
}
