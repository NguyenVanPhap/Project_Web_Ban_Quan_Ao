package com.webbanquanao.service.impl;

import com.webbanquanao.dao.SkuDao;
import com.webbanquanao.dao.impl.SkuDaoImpl;
import com.webbanquanao.model.SkuEntity;
import com.webbanquanao.service.SkuService;

import java.util.List;

public class SkuServiceImpl implements SkuService {
    SkuDao skuDao = new SkuDaoImpl();
    @Override
    public List<SkuEntity> getAll() {
        return skuDao.getAll();
    }
}
