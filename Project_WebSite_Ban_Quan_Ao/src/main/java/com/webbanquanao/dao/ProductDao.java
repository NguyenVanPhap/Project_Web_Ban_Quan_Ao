package com.webbanquanao.dao;

import com.webbanquanao.model.ProductEntity;

import java.util.List;

public interface ProductDao {
    void insert(ProductEntity product);

    void edit(ProductEntity product);

    void delete(int id);

    ProductEntity get(int id);

    List<ProductEntity> getAll();

    List<ProductEntity> search(String keyword);

    List<ProductEntity> searchByCategory(int cate_id);

    List<ProductEntity> searchByName(String productName);
}
