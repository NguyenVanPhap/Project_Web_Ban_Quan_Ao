package com.webbanquanao.service.impl;

import com.webbanquanao.dao.CategoryDao;
import com.webbanquanao.dao.impl.CategoryDaoImpl;
import com.webbanquanao.model.Category;
import com.webbanquanao.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void edit(Category newCategory) {
        categoryDao.edit(newCategory);
    }

    @Override
    public void delete(int cate_id) {
        categoryDao.detele(cate_id);
    }

    @Override
    public Category get(int cate_id) {
        return categoryDao.get(cate_id);
    }

    @Override
    public Category get(String cate_name) {
        return categoryDao.getName(cate_name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String cate_name) {
        return categoryDao.search(cate_name);
    }
}
