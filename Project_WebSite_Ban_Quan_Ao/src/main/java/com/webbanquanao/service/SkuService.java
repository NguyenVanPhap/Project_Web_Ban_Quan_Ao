package com.webbanquanao.service;

import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.SkuEntity;

import java.util.List;

public interface SkuService {
    void insert(SkuEntity skuEntity);

    void edit(SkuEntity skuEntity);

    void delete(int id);
    SkuEntity get(int id);
    List<SkuEntity> getAll();
    List<SkuEntity> searchByProduct(int pro_id);
}
