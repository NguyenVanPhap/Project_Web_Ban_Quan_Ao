package com.webbanquanao.service.impl;

import com.webbanquanao.dao.CartDao;
import com.webbanquanao.dao.impl.CartDaoImpl;
import com.webbanquanao.model.CartEntity;
import com.webbanquanao.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();

    @Override
    public List<CartEntity> search(String name) {
        return cartDao.search(name);
    }

    @Override
    public void insert(CartEntity cart) {
        cartDao.insert(cart);

    }

    @Override
    public List<CartEntity> getAll() {
        return cartDao.getAll();
    }

    @Override
    public CartEntity get(int id) {
        return cartDao.get(id);
    }

    @Override
    public void edit(CartEntity newCart) {
        CartEntity oldCart = cartDao.get(newCart.getId());

        oldCart.setBuyDate(newCart.getBuyDate());
  //      oldCart.setBuyer(newCart.getBuyer());

        cartDao.edit(oldCart);
    }

    @Override
    public void delete(int id) {
        cartDao.delete(id);
    }
}
