package com.webbanquanao.service.impl;

import com.webbanquanao.dao.SizeDao;
import com.webbanquanao.dao.SkuDao;
import com.webbanquanao.dao.impl.SizeDaoImpl;
import com.webbanquanao.dao.impl.SkuDaoImpl;
import com.webbanquanao.model.SizeEntity;
import com.webbanquanao.model.SkuEntity;
import com.webbanquanao.service.SizeService;

import java.util.List;

public class SizeServiceImpl implements SizeService {
    SizeDao sizeDao = new SizeDaoImpl();
    @Override
    public void insert(SizeEntity sizeEntity){
        sizeDao.insert(sizeEntity);
    }

    @Override
    public void edit(SizeEntity sizeEntity) {
//        SkuEntity oldSku = skuDao.get(newskuEntity.getSkuId());
//
//        oldSku.setColorEntity(newskuEntity.getColorEntity());
//        oldSku.setSizeEntity(newskuEntity.getSizeEntity());
//        oldSku.setQuantity(newskuEntity.getQuantity());
//
//
//        skuDao.edit(oldSku);

    }

    @Override
    public void delete(int id) {
        sizeDao.delete(id);

    }

    @Override
    public SizeEntity get(int id) {
        return sizeDao.get(id);
    }
    @Override
    public List<SizeEntity> getAll() {
        return sizeDao.getAll();
    }

    @Override
    public int getSizeId(String size_name) { return sizeDao.getSizeId(size_name); }
}
