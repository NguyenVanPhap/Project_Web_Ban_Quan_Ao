package com.webbanquanao.dao;

import com.webbanquanao.model.Category;

import java.util.List;

public interface CategoryDao {
    void insert(Category category);

    void edit(Category category);

    void detele(int cate_id);

    Category get(int cate_id);

    Category getName(String cate_name);

    List<Category> getAll();

    List<Category> search(String keyword);
}
