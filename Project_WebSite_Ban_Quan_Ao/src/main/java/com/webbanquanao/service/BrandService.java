package com.webbanquanao.service;

import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;

import java.util.List;

public interface BrandService {
    List<BrandEntity> getAll();
    BrandEntity get(int brand_id);
}
