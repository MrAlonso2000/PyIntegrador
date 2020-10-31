/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author josel
 */
public interface OperacionesBd <T> {
    public abstract Boolean insert(T t);
    public abstract Boolean update(T t);
    public abstract Boolean delete(Object id);
    public abstract T selectById(Object id);
    public abstract ArrayList<T> selectAll();
   
}


