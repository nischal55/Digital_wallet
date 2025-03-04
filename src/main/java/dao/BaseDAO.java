package dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDAO <T>{
    boolean save(T entity);
    boolean update(T entity);
    boolean deleteById(Long id);  
    T findById(Long id);
    List<T> findAll();
}
