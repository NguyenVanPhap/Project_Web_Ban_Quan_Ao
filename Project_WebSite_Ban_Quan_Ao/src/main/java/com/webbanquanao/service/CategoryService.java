package com.webbanquanao.service;

import com.webbanquanao.model.Category;

import java.util.List;

public interface CategoryService {
    void insert(Category category);

    void edit(Category category);

    void delete(int cate_id);

    Category get(int cate_id);

    Category get(String cate_name);

    List<Category> getAll();

    List<Category> search(String cate_name);
}
