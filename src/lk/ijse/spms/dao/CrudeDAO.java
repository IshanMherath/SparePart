/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao;

import java.util.ArrayList;

import lk.ijse.spms.entity.Super;

/**
 *
 * @author User
 */
public interface CrudeDAO<T,ID>extends SuperDAO{
    public boolean add(T entity)throws Exception;
    public boolean delete(ID id)throws Exception;
    public boolean update(T entity)throws Exception;
    public T search(ID id)throws Exception;
    public ArrayList<T> getAll()throws Exception;
}
