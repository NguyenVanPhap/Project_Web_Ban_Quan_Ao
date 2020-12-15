package com.webbanquanao.service.impl;

import com.webbanquanao.dao.CartItemDao;
import com.webbanquanao.dao.impl.CartItemDaoImpl;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.service.CartItemService;

import java.util.List;

public class CartItemServiceImpl implements CartItemService {
    CartItemDao cartItemDao = new CartItemDaoImpl();

    @Override
    public void insert(CartitemEntity cartItem) {
        cartItemDao.insert(cartItem);

    }

    @Override
    public void edit(CartitemEntity newCartItem) {
/*        CartitemEntity oldCartItem = cartItemDao.get(newCartItem.getId());
  //      oldCartItem.setCart(newCartItem.getCart());
   //     oldCartItem.setProduct(newCartItem.getProduct());
        oldCartItem.setQuantity(newCartItem.getQuantity());
        oldCartItem.setUnitPrice(newCartItem.getUnitPrice());

        cartItemDao.edit(oldCartItem);*/
    }

    @Override
    public void delete(String id) {
        cartItemDao.delete(id);
    }

    @Override
    public CartitemEntity get(int id) {
        return cartItemDao.get(id);
    }

    @Override
    public List<CartitemEntity> getAll() {
        return cartItemDao.getAll();
    }

    @Override
    public List<CartitemEntity> search(String keyword) {
        return cartItemDao.search(keyword);
    }


}

