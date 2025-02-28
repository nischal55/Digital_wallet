package dao.impl;

import dao.BaseDAO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


public class BaseDaoImpl<T, ID extends Serializable> implements BaseDAO<T, ID>{
    
    private final Class<T> entityClass;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private EntityManager em = emf.createEntityManager();

    
    public BaseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    
    @Override
    public boolean save(T entity) {
        EntityTransaction transaction = em.getTransaction();
        boolean status = false;
        
        try{
            transaction.begin();
            em.persist(entity);
            transaction.commit();
            status = true;
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();  
        }
        return status;
    }

    @Override
    public boolean update(T entity) {
        EntityTransaction transaction = em.getTransaction();
        boolean status = false;
        try{
            transaction.begin();
            em.merge(entity);
            transaction.commit();
            status = true;
            
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        
        return status;
    }

    @Override
    public boolean deleteById(ID id) {
        EntityTransaction transaction = em.getTransaction();
        boolean status = false;
        
        try{
            transaction.begin();
            T entity = em.find(entityClass, id);
             if (entity != null) {
                em.remove(entity);
                status = true;
            }
            transaction.commit();
            
           
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        
        return status;
    }

    @Override
    public T findById(ID id) {
         try {
            return em.find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        try {
            TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
