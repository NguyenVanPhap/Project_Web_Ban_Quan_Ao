package com.webbanquanao.service.impl;

import com.webbanquanao.dao.SkuDao;
import com.webbanquanao.dao.impl.SkuDaoImpl;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.SkuEntity;
import com.webbanquanao.service.SkuService;

import java.util.List;

public class SkuServiceImpl implements SkuService {
    SkuDao skuDao = new SkuDaoImpl();
    @Override
    public void insert(SkuEntity skuEntity){
        skuDao.insert(skuEntity);
    }

    @Override
    public void edit(SkuEntity newskuEntity) {
        SkuEntity oldSku = skuDao.get(newskuEntity.getSkuId());

        oldSku.setProductEntity(newskuEntity.getProductEntity());
        oldSku.setColorEntity(newskuEntity.getColorEntity());
        oldSku.setSizeEntity(newskuEntity.getSizeEntity());
        oldSku.setQuantity(newskuEntity.getQuantity());


        skuDao.edit(oldSku);

    }

    @Override
    public void delete(int id) {
        skuDao.delete(id);

    }

    @Override
    public SkuEntity get(int id) {
        return skuDao.get(id);
    }
    @Override
    public List<SkuEntity> getAll() {
        return skuDao.getAll();
    }
    @Override
    public List<SkuEntity> searchByProduct(int pro_id) {
        return skuDao.searchByProduct(pro_id);
    }
}
