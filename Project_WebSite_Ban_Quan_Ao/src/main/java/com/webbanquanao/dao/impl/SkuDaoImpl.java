package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.dao.SkuDao;
import com.webbanquanao.model.SkuEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SkuDaoImpl implements SkuDao {
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
}
