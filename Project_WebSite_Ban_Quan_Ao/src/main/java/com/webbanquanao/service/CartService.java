package com.webbanquanao.service;

import com.webbanquanao.model.CartEntity;

import java.util.List;

public interface CartService {
    void insert(CartEntity cart);

    void edit(CartEntity newCart);

    void delete(int id);

    CartEntity get(int id);

    List<CartEntity> getAll();

    List<CartEntity> search(String keyword);

    void removeProduct(CartEntity cart, int pId);

    double totalBill(CartEntity cart);
}
