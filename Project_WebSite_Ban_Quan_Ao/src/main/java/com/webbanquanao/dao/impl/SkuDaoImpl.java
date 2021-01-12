package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.dao.SkuDao;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.SkuEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class SkuDaoImpl implements SkuDao {
    @Override
    public void insert(SkuEntity skuEntity){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(skuEntity);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }

    }

    @Override
    public void edit(SkuEntity skuEntity){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(skuEntity);
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
            SkuEntity skuEntity = em.find(SkuEntity.class, id);
            trans.begin();
            em.remove(em.merge(skuEntity));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    @Override
    public SkuEntity get(int id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            SkuEntity skuEntity = em.find(SkuEntity.class, id);
            return skuEntity;
        }
        finally {
            em.close();
        }
    }
    @Override
    public List<SkuEntity> getAll() {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM SkuEntity ";
        TypedQuery<SkuEntity> q = em.createQuery(qString,SkuEntity.class);
        List<SkuEntity> skuEntities;
        try{
            skuEntities = q.getResultList();
            if(skuEntities == null || skuEntities.isEmpty())
                skuEntities = null;
        }finally {
            em.close();
        }
        return skuEntities;
    }
    @Override
    public boolean checkExistOption(int pro_id,int color_id, int size_id) {

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM SkuEntity u "+
                "WHERE u.productEntity.id=:pro_id and u.colorEntity.id=:color_id and u.sizeEntity.id=:size_id";
        TypedQuery<SkuEntity> q = em.createQuery(qString,SkuEntity.class);
        q.setParameter("pro_id",pro_id);
        q.setParameter("color_id",color_id);
        q.setParameter("size_id",size_id);

        List<SkuEntity> skuEntities;
        try{
            skuEntities=q.getResultList();

        }
        catch (NoResultException e){
            return  false;
        }
        finally {
            em.close();
        }
        if(skuEntities.size()>0 &&skuEntities!=null)
            return true;
        return false;
    }
    @Override
    public List<SkuEntity> searchByProduct(int pro_id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM SkuEntity Sku Where Sku.productEntity.id =:pro_id ";
        TypedQuery<SkuEntity> q = em.createQuery(qString,SkuEntity.class);
        q.setParameter("pro_id",pro_id);
        List<SkuEntity> skuEntities = new ArrayList<SkuEntity>();
        try{
            skuEntities = q.getResultList();
            if(skuEntities == null || skuEntities.isEmpty())
                skuEntities= null;
        }finally {
            em.close();
        }
        return skuEntities;

    }
}
