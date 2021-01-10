package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.dao.ProductDao;
import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void insert(ProductEntity product){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(product);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }

    }

    @Override
    public void edit(ProductEntity product){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(product);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void delete(int id)
    {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            ProductEntity productEntity = em.find(ProductEntity.class, id);
            trans.begin();
            em.remove(em.merge(productEntity));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public ProductEntity get(int id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            ProductEntity productEntity = em.find(ProductEntity.class, id);
            return productEntity;
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<ProductEntity> getAll(){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
    @Override
    public List<ProductEntity> getByPage(int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
    @Override
    public List<ProductEntity> getByPageAndPrice(double priceStart,double priceEnd, int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.price >= :priceStart and P.price <= : priceEnd";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("priceStart",priceStart);
        q.setParameter("priceEnd",priceEnd);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
    @Override
    public List<ProductEntity> searchByPageAndCategory(String cate_name,int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P Where P.categoryEntity.cateName =:cate_name ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("cate_name",cate_name);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;

    }
    @Override
    public List<ProductEntity> search(String keyword)
    {

        return null;
    }

    @Override
    public List<ProductEntity> searchByCategory(String cate_name){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P Where P.categoryEntity.cateName =:cate_name ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("cate_name",cate_name);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;

    }

    @Override
    public List<ProductEntity> searchByName(String productName) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.name like :productName";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("productName","%"+productName+"%");
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
    public List<ProductEntity> searchByPrice(double priceStart,double priceEnd){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.price >= :priceStart and P.price <= : priceEnd";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("priceStart",priceStart);
        q.setParameter("priceEnd",priceEnd);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
}
