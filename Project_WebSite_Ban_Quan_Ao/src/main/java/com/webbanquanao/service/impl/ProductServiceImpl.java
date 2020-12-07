package com.webbanquanao.service.impl;

import com.webbanquanao.dao.ProductDao;
import com.webbanquanao.dao.impl.ProductDaoImpl;
import com.webbanquanao.model.Product;
import com.webbanquanao.service.ProductService;

import java.io.File;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();

    @Override
    public void insert(Product product){
        productDao.insert(product);
    }

    @Override
    public void edit(Product newProduct) {
        Product oldProduct = productDao.get(newProduct.getId());

        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCategory(newProduct.getCategory());
        if (newProduct.getImage() != null) {
            // XOA ANH CU DI
            String fileName = oldProduct.getImage();
            final String dir = "F:\\upload";
            File file = new File(dir + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }

            oldProduct.setImage(newProduct.getImage());
        }

        productDao.edit(oldProduct);

    }

    @Override
    public void delete(int id) {
        productDao.delete(id);

    }

    @Override
    public Product get(int id) {
        return productDao.get(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> search(String product) {
        return productDao.search(product);
    }

    @Override
    public List<Product> searchByCategory(int cate_id) {
        return productDao.searchByCategory(cate_id);
    }

    @Override
    public List<Product> searchByName(String productName) {
        return productDao.searchByName(productName);
    }


}
