package com.webbanquanao.dao;


import com.webbanquanao.model.CartitemEntity;

import java.util.List;

public interface CartItemDao {
    void insert(CartitemEntity cartItem);

    void edit(CartitemEntity cartItem);

    void delete(String id);

    CartitemEntity get(String name);

    CartitemEntity get(int id);

    List<CartitemEntity> getAll();

    List<CartitemEntity> search(String name);
}
