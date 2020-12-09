package com.webbanquanao.service;

import com.webbanquanao.model.CartitemEntity;

import java.util.List;

public interface CartItemService {
    void insert(CartitemEntity cartItem);

    void edit(CartitemEntity cartItem);

    void delete(String id);

    CartitemEntity get(int id);

    List<CartitemEntity> getAll();

    List<CartitemEntity> search(String keyword);
}
