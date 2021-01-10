package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.BrandDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BrandDaoImpl implements BrandDao {
    @Override
    public List<BrandEntity> getAll() {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM BrandEntity ";
        TypedQuery<BrandEntity> q = em.createQuery(qString,BrandEntity.class);
        List<BrandEntity> brandEntities;
        try{
            brandEntities = q.getResultList();
            if(brandEntities == null || brandEntities.isEmpty())
                brandEntities = null;
        }finally {
            em.close();
        }
        return brandEntities;
    }
    @Override
    public BrandEntity get(int brand_id)
    {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            BrandEntity brandEntity = em.find(BrandEntity.class, brand_id);
            return brandEntity;
        }
        finally {
            em.close();
        }
    }
}
