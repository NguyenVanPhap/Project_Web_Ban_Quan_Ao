package com.webbanquanao.dao;

import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.CategoryEntity;

import java.util.List;

public interface BrandDao {
    List<BrandEntity> getAll();
    BrandEntity get(int brand_id);
}
