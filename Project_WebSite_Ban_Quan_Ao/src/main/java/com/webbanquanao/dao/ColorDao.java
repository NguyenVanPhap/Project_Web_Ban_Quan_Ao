package com.webbanquanao.dao;

import com.webbanquanao.model.ColorEntity;
import com.webbanquanao.model.SizeEntity;
import com.webbanquanao.model.SkuEntity;

import java.util.List;

public interface ColorDao {
    void insert(ColorEntity colorEntity);

    void edit(ColorEntity colorEntity);

    void delete(int id);
    ColorEntity get(int id);
    List<ColorEntity> getAll();

}
