package com.webbanquanao.service;

import com.webbanquanao.model.Product;

import java.util.List;

public interface ProductService {
    void insert(Product product);

    void edit(Product product);

    void delete(int id);

    Product get(int id);

    List<Product> getAll();

    List<Product> search(String name);

    List<Product> searchByCategory(int cate_id);

    List<Product> searchByName(String productName);
}
