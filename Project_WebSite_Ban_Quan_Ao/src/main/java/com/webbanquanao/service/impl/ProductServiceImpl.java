package com.webbanquanao.service.impl;

import com.webbanquanao.dao.ProductDao;
import com.webbanquanao.dao.impl.ProductDaoImpl;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.ProductService;

import java.io.File;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();

    @Override
    public void insert(ProductEntity product){
        productDao.insert(product);
    }

    @Override
    public void edit(ProductEntity newProduct) {
        ProductEntity oldProduct = productDao.get(newProduct.getId());

        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCategoryEntity(newProduct.getCategoryEntity());
        oldProduct.setDes(newProduct.getDes());
        if (newProduct.getImage() != null) {
            // XOA ANH CU DI
//            String fileName = oldProduct.getImage();
//            final String dir = "F:\\upload";
//            final String dir = context.getRealPath("image");
//            File file = new File(dir + "/" + fileName);
//            if (file.exists()) {
//                file.delete();
//            }

            oldProduct.setImage(newProduct.getImage());
        }

        productDao.edit(oldProduct);

    }

    @Override
    public void delete(int id) {
        productDao.delete(id);

    }

    @Override
    public ProductEntity get(int id) {
        return productDao.get(id);
    }

    @Override
    public List<ProductEntity> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<ProductEntity> search(String product) {
        return productDao.search(product);
    }

    @Override
    public List<ProductEntity> searchByCategory(int cate_id) {
        return productDao.searchByCategory(cate_id);
    }

    @Override
    public List<ProductEntity> searchByName(String productName) {
        return productDao.searchByName(productName);
    }

    public List<ProductEntity> searchByPrice(double priceStart,double priceEnd) {
        return productDao.searchByPrice(priceStart,priceEnd);
    }
}
