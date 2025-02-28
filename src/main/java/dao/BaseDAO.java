package dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDAO <T, ID extends Serializable>{
    boolean save(T entity);
    boolean update(T entity);
    boolean deleteById(ID id);  
    T findById(ID id);
    List<T> findAll();
}
